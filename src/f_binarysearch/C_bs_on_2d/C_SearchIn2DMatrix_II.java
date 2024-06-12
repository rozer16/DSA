package f_binarysearch.C_bs_on_2d;


/*
https://takeuforward.org/arrays/search-in-a-row-and-column-wise-sorted-matrix/
https://www.youtube.com/watch?v=9ZbB397jU4k

https://leetcode.com/problems/search-a-2d-matrix-ii/description/
* */

public class C_SearchIn2DMatrix_II {

    //Either we can start from arr[0][cols-1] or arr[rows-1][0]
    //Since  one is increasing and other is decreasing

    //If we start of arr[0][0] or arr[row-1][cols-1] then its increasing from both side.
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;

        }

        return false;
    }
}
