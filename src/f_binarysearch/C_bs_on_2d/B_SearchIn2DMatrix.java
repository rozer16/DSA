package f_binarysearch.C_bs_on_2d;

/*
https://youtu.be/JXU4Akft7yk
https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/
https://leetcode.com/problems/search-a-2d-matrix/description/
* */
public class B_SearchIn2DMatrix {


    // Idea  is to convert 2d matrix into 1d hypothetically and based on mid find row and col
    //TC : log base2 (n*m)
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = (m*n)-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int row = mid/m;
            int col = mid%m;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}
