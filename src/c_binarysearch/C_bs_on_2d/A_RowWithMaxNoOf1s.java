package c_binarysearch.C_bs_on_2d;

import java.util.ArrayList;
import java.util.Arrays;


/*
https://takeuforward.org/arrays/find-the-row-with-maximum-number-of-1s/
https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=row-with-max-1s
https://youtu.be/SCz-1TtYxDI


Given a boolean 2D array, consisting of only 1's and 0's,where each row is sorted.
Find the 0-based index of the first row that has the maximum number of 1's.
Return the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.

Examples :

Input: arr[][] = [
                    [0, 1, 1, 1],
                    [0, 0, 1, 1],
                    [1, 1, 1, 1],
                    [0, 0, 0, 0]
                   ]
Output: 2
Explanation: Row 2 contains 4 1's (0-based indexing).
Input: arr[][] = [[0, 0], [1, 1]]
Output: 1
Explanation: Row 1 contains 2 1's (0-based indexing).

Expected Time Complexity: O(n+m)
Expected Auxiliary Space: O(1)


Intuition

1) Each row is sorted so if you find lower bound(smallest index, ind, where arr[ind] >= x) the you can count 1s
2) Iterate for each row and get count of 1s and store it if its greater than max

 */
public class A_RowWithMaxNoOf1s {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int n = 3, m = 3;
        System.out.println("The row with the maximum number of 1's is: " +
                rowWithMax1s(matrix, n, m));

        //The row with the maximum number of 1's is: 0
    }
    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr.get(mid) >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
    public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int cnt_max = 0;
        int index = -1;

        // traverse the rows:
        for (int i = 0; i < n; i++) {
            // get the number of 1's:
            int cnt_ones = m - lowerBound(matrix.get(i), m, 1);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }
}
