package c_binarysearch.C_bs_on_2d;

/*
https://youtu.be/JXU4Akft7yk
https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/
https://leetcode.com/problems/search-a-2d-matrix/description/


You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.


Input: matrix = [
                    [1,3,5,7],
                    [10,11,16,20],
                    [23,30,34,60]
                 ],


target = 3
Output: true
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
