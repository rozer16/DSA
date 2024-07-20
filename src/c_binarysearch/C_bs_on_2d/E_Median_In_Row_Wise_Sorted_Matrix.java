package c_binarysearch.C_bs_on_2d;


/*
https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/
https://youtu.be/63fPPOdIr2c
https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-in-a-row-wise-sorted-matrix


Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5],
     [2, 6, 9],
     [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives
us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median.


Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2
Explanation: Sorting matrix elements gives
us {1,2,3}. Hence, 2 is median.


Expected Time Complexity: O(32 * R * log(C))
Expected Auxiliary Space: O(1)


* */
public class E_Median_In_Row_Wise_Sorted_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                            {1, 2, 3, 4, 5},
                            {8, 9, 11, 12, 13},
                            {21, 23, 25, 27, 29}
                        };
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = median(matrix, m, n);
        System.out.println("The median element is: " + ans);
    }


    /*

            1. Since we are given cols and rows as odd, multiplication of two odd no will always be odd
               so no of element on left of mid and no of ele on right of median will always be equal

            2. What is the search space where we will apply binary search?
                If we carefully observe, our answer lies between the smallest and the largest number in the given matrix. So, the search space will be [min(matrix), max(matrix)].

            3. While applying binary search how to check if an element ‘x’ is a possible median?
                If ‘x’ is the median, the number of elements smaller or equal to ‘x’ will be surely greater than (MXN) // 2 (integer division).

            4. How to check how many numbers are smaller or equal to an element ‘mid’?

                One of the ways is to traverse the whole matrix and count the numbers. But in that case, the time complexity will be high. So, we have to find other ways.
                It is given that the matrix is row-wise sorted. So, we can apply the concept of upper bound
                For every particular row, we will find the upper bound of the current element ‘mid’. The index returned will be the number of smaller or equal elements in that row.
                We will do it for each row and add them to get the total number for the whole matrix.
                Mathematically, smaller_equal_in_row = upperBound(matrix[row], mid)



                Time Complexity: O(log(109)) X O(M(logN)), where M = number of rows in the given matrix, N = number of columns in the given matrix

                Reason: Our search space lies between [0, 109] as the min(matrix) can be 0 and the max(matrix) can be 109.
                We are applying binary search in this search space and it takes O(log(109)) time complexity.
                Then we call countSmallEqual() function for every ‘mid’ and this function takes O(M(logN)) time complexity.

                Space Complexity : O(1) as we are not using any extra space
    * */
    static int median(int[][] matrix, int rows, int cols) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // point low and high to right elements
        for (int i = 0; i < rows; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][cols - 1]);
        }

        int req = (cols * rows) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int noOfEleSmallerOrEqual = countSmallEqual(matrix, rows, cols, mid);
            if (noOfEleSmallerOrEqual <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }



    //Count total no of elements for each row which are smaller or equal to x for a given matrix
    //TC : O(M(logN))  where M = number of rows in the given matrix, N = number of columns in the given matrix
    static int countSmallEqual(int[][] matrix, int rows, int cols, int x) {
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            cnt += upperBound(matrix[i], x, cols);
        }
        return cnt;
    }

    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}
