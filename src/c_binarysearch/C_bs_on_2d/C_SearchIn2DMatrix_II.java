package c_binarysearch.C_bs_on_2d;


/*
https://takeuforward.org/arrays/search-in-a-row-and-column-wise-sorted-matrix/
https://www.youtube.com/watch?v=9ZbB397jU4k

https://leetcode.com/problems/search-a-2d-matrix-ii/description/


Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


Input: matrix = [
                    [1,4,7,11,15],
                    [2,5,8,12,19],
                    [3,6,9,16,22],
                    [10,13,14,17,24],
                    [18,21,23,26,30]
                 ]
target = 5
Output: true



Input: matrix = [

                    [1,4,7,11,15],
                    [2,5,8,12,19],
                    [3,6,9,16,22],
                    [10,13,14,17,24],
                    [18,21,23,26,30]
                ],
target = 20
Output: false


Hint :
Need to start either from top right or left bottom
since from top left or right bottom both sides it increasing
but  from top right or left bottom  its one side increasing and other side its decreasing


* */

public class C_SearchIn2DMatrix_II {

    //Either we can start from arr[0][cols-1] or arr[rows-1][0]
    //Since  one is increasing and other is decreasing

    //If we start of arr[0][0] or arr[row-1][cols-1] then its increasing from both side.
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = cols - 1;

        while (low < rows && high >= 0) {
            if (matrix[low][high] == target)
                return true;
            else if (matrix[low][high] > target)
                high--;
            else
                low++;

        }

        return false;
    }
}
