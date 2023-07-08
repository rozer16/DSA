package b_array.medium;


import java.util.Arrays;

/*
* https://youtu.be/Z0R2u6gd3GU
* https://leetcode.com/problems/rotate-image/
*
*
You are given an n x n 2D matrix representing an image,
rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place,
which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.
*
*
*
Input: matrix = [
    [1,2,3],
    [4,5,6],
    [7,8,9]
 ]
Output: [

    [7,4,1],
    [8,5,2]
    [9,6,3]
]

*
* */
public class J_RotateMatrix_90Degree {

    public static void main(String[] args) {
        J_RotateMatrix_90Degree test = new J_RotateMatrix_90Degree();
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        int [][] result = test.rotate(matrix);
        System.out.println("-----------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    /*
    * Optimize not to use extra space complexity, rotate in place
    *
    * Intuition :
    *
    * Observation
    * Input: matrix = [
          0 1 2
        0[1,2,3],
        1[4,5,6],
        2[7,8,9]
         ]
         *
         *
       Output: [
          0,1,2
        0[7,4,1]
        1[8,5,2]
        2[9,6,3]
        ]
*
*
*   Observation
*       1st column cells are in 1st row but in reverse order.
*       2nd column cells are in 2nd row but in reverse order.
*       3rd column cells are in 3rd row but in reverse order.
*
*   So lets transpose the matrix : column becomes row and row becomes columns
*   a[i][j] = a[j][i]
*
*
*   swap :  [0][1] & [1][0]
*   swap :  [0][2] & [2][0]

*   swap :  [1][2] & [2][1]

*
*
*
      0 1 2
    0[1,2,3],
    1[4,5,6],
    2[7,8,9]
*
*   1,4,7
*   2,5,8
*   3,6,9
*
*   Observation : Always try to swap which are right on the pointer of i,j
*       for i = 0 --> travel 0-2(i = 0-->(n-1)) : [0][1] & [1][0] & [0][1] & [1][0]
*       for i = 1 --> travel 1-2(i = 0-->(n-1)) : [1][2] & [2][1]
*
*
*   Reverse
*
    * */
    public int [][]  rotate(int[][] matrix) {
        int n = matrix.length;


        //Transpose the matrix
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                swap(matrix,i,j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
           reverse(matrix[i],0, matrix[0].length-1);
        }

        return  matrix;
    }

    private void reverse(int [] arr, int p1,int p2){
        while(p1<p2){
            int temp = arr[p1];
            arr[p1++] = arr[p2];
            arr[p2--] = temp;
        }
    }
    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    /*
    *
    * Bruteforce
    * TC : O(n^2)
    * SC : O(n^2)
    *
    * Input: matrix = [
    *   0,1,2
    * 0[1,2,3],
      1[4,5,6],
      2[7,8,9]
     ]
    Output: [
      0,1,2
    0[7,4,1],
    1[8,5,2]
    2[9,6,3]
    ]
    * i  j  ==>  j  n-1-i
    *[0][0] ==> [0][2]
    *[0][1] ==> [1][2]
    *[0][2] ==> [2][2]
    *
    *[1][0] ==> [0][1]
    *[1][1] ==> [1][1]
    *[1][2] ==> [2][1]
    *
    *[2][0] ==> [0][0]
    *[2][1] ==> [1][0]
    *[2][2] ==> [2][0]
    *
    * */
    public int [][]  rotate1(int[][] matrix) {
        int n = matrix.length;

        int [] [] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n-1-i] = matrix[i][j];
            }
        }
        return result;
    }
}
