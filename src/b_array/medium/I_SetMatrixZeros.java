package b_array.medium;

import java.util.Arrays;

/*
* https://leetcode.com/problems/set-matrix-zeroes/
* https://takeuforward.org/data-structure/set-matrix-zero/
*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.
Input: matrix = [[1,1,1]
                 [1,0,1]
                 [1,1,1]
                ]
Output: [[1,0,1]
*        [0,0,0]
*        [1,0,1]
*       ]
*
*
*
Input :

[[0,1,2,0]
 [3,4,5,2]
 [1,3,1,5]
]
*
Output
[
  [0,0,0,0]
  [0,4,5,0]
  [0,3,1,0]
]
* */
public class I_SetMatrixZeros {

    public static void main(String[] args) {
        I_SetMatrixZeros test = new I_SetMatrixZeros();
        int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        test.setZeroes(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
    }


    /*
    * TODO : Continue understand  video for O(1) space complexity.
    * */
    public void setZeroes(int[][] matrix) {

    }
    /*
    *
    * Better Approach : TC : O(2*m*n)  SC: O(m+n)
    *
    *
    * Intuition :
    *   Step 1 : Maintain two array to keep record
    *       if row value is 0 for that specific cell in one array
    *       if column value is 0 for that specific cell in one array
    *       Iterate through array and if a[i][j] is zero then set row[i] = 0, col[j] = 0
    *       Iterate through matrix in two loops and if row[i] == 0 || col[j] == 0 then set matrix[i][j] = 0
    *
    * */
    public void setZeroes2(int[][] matrix) {
        int row[] = new int[matrix.length];
        int col[] = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
    /*
    * Bruteforce :
    *
    *
    * Step 1 : Iterate all rows and columns using two loops
    * Step 2 : if a[i][j] is found 0 then mark all element as -1 for ith row and jth column //TC : O(n*m)+O(n+m)
    * Step 3 : Iterate all rows and columns using two loops again and if cell is -1 then set it 0 // TC : O(n*m)
    *
    *
    * Total TC : O(n*m)+O(n+m)+O(n*m) ~= O(n^3*m^3)
    *
    * */
    public void setZeroes1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 0){
                    markRowAsMinusone(matrix, i);
                    markColumnAsMinusone(matrix, i);
                }
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }

        }
    }

    private void markColumnAsMinusone(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[j][i] = -1;
        }
    }

    private void markRowAsMinusone(int[][] matrix, int i) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[i][j] = -1;
        }
    }
}
