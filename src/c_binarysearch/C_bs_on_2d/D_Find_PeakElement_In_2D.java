package c_binarysearch.C_bs_on_2d;


/*
https://youtu.be/nGGp5XBzC4g


A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.


Input: mat = [

                [10,20,15],
                [21,30,14],
                [7,16,32]
            ]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.


Input: mat = [
                [41,8,2,48,18],
                [16,15,9,7,44],
                [48,35,6,38,28],
                [3,2,14,15,33],
                [39,36,13,46,42]
             ]

o/p : [0,3]

* */
public class D_Find_PeakElement_In_2D {


    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;


        int low = 0;
        int high = cols-1;


        while(low <= high){
            int mid = low + (high-low)/2;

            int row = findMaxElementFromColumn(mat,mid);

            //Check if we are not crossing boundary on left and its greater than mat[mid][left]
            int left = mid-1 >= 0 ? mat[row][mid-1] : -1;

            //Check if we are not crossing boundary on right  and its greater than mat[mid][right]
            int right = mid+1 < cols ? mat[row][mid+1] : -1;

            if(left < mat[row][mid] && mat[row][mid] > right)
                return new int[]{row,mid};
            else if(left > mat[row][mid])
                high = mid-1;
            else
                low = mid+1;
        }

        return new int[]{-1,-1};
    }


    public int findMaxElementFromColumn(int [][] mat, int col){
        int rows = mat.length;
        int cols = mat[0].length;
        int max = Integer.MIN_VALUE;
        int maxRow = 0;
        for(int i=0;i<rows;i++) {
            if(max < mat[i][col]){
                max = mat[i][col];
                maxRow = i;
            }

        }

        return maxRow;
    }
}
