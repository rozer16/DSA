package b_array.medium;

import javax.imageio.ImageTranscoder;
import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/spiral-matrix/
* https://youtu.be/3Zv-s9UUrFM
* https://takeuforward.org/data-structure/spiral-traversal-of-matrix/
*
*
*
Given an m x n matrix, return all elements of the matrix in spiral order.
*
*
Example 1:
Input: Matrix[][] = { { 1, 2, 3, 4 },
                      { 5, 6, 7, 8 },
                      { 9, 10, 11, 12 },
	                  { 13, 14, 15, 16 }
	                 }

Outhput: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
Explanation: The output of matrix in spiral form.

Example 2:
Input: Matrix[][] = { { 1, 2, 3 },
                      { 4, 5, 6 },
                      { 7, 8, 9 }
                     }

Output: 1, 2, 3, 6, 9, 8, 7, 4, 5.
Explanation: The output of matrix in spiral form.
*
* */
public class K_SpiralMatrix {

    public static void main(String[] args) {
        int [][]  Matrix = {    { 1, 2, 3 },
                                { 4, 5, 6 },
                                { 7, 8, 9 }
                            };

        K_SpiralMatrix test = new K_SpiralMatrix();
        System.out.println(test.getSpiral(Matrix));
    }




    /*
    *
    *
    *        -->          |
    *       top         right
    *       1   2   3   4
    *       5   6   7   8
    *       9   10  11  12
    *       13  14  15  16
    *       left       bottom
    *         ^         <--
    *         |
    *  As shown in the image given below, create and initialize variables
        * top as starting row index,
        * bottom as ending row index
        * left as starting column index,
        * right as ending column index.

        * In each outer loop traversal print the elements of a square in a clockwise manner.
        * Print the top row, i.e. Print the elements of the top row from column index left to right and increase the count of the top
          so that it will move to the next row.
        * Print the right column, i.e. Print the rightmost column from row index top to bottom and decrease the count of right.
        * Print the bottom row, i.e. if top <= bottom, then print the elements of a bottom row from column right to left
          and decrease the count of bottom
        * Print the left column, i.e. if left <= right, then print the elements of the left column from the bottom row to the top row
          and increase the count of left.
        * Run a loop until all the squares of loops are printed.
        * Note: As we can see in the code snippet below, two edge conditions are being added in the last two ‘for’ loops:
          when we are moving from right to left and from bottom to top.

        These conditions are added to check if the matrix is a single column or a single row.
        So, whenever the elements in a single row are traversed they cannot be traversed again backward
        so the condition is checked in the right-to-left loop. When a single column is present,
        the condition is checked in the bottom-to-top loop as elements from bottom to top cannot be traversed again.
    *
    *       -->          |
    *       top         right
    *       1   2   3   4
    *       5   6   7   8
    *       9   10  11  12
    *       13  14  15  16
    *       left       bottom
    *         ^         <--
    *         |
    *
    *
    *
    *   right --> bottom --> left --> top
    *   for(i = left --> right) print matrix[top][i]
    *   top++
    *   for(i = top --> bottom) print matrix[i][right]
    *   right--
    *   for(i = right --> left) print matrix[bottom][i]
    *   bottom--
    *   for(i = bottom --> top) print matrix[i][left]
    *   left++
    * */

    /*
    * Complexity :
    *   TC : O(n*m) since we are visiting every element once
    *   SC : O(n*m) for storing elements into list.
    *
    * */
    private List<Integer> getSpiral(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;


        int top = 0;
        int right = m-1;
        int bottom = n-1;
        int left = 0;

        //if there is a single row or single column
        while(top <= bottom && left <= right) {
            //right
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++; //In case there is only one row (top=0, bottom = n-1 = 0)then after top++(top = 1) below condition wont be satisfied.

            //bottom
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;

            //left
            if(top <= bottom) { // Need to add if condition in case there is only one row otherwise it will print  right to left of same row
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //top
            if(left <= right) { // For most inner spiral this condition is required.
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }

                left++;
            }
        }

        return spiral;

    }
}
