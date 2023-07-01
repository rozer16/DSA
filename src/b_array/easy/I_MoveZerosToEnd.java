package b_array.easy;

import java.util.Arrays;

/*
* https://leetcode.com/problems/move-zeroes/
*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
*
* */
public class I_MoveZerosToEnd {
    public static void main(String[] args) {
        I_MoveZerosToEnd test = new I_MoveZerosToEnd();
        int [] arr = {0,1,0,3,12};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        int p = 0;
        int mp = 0;

        while(mp < nums.length){
            if(nums[mp] != 0){
                nums[p++] = nums[mp];

            }
            mp++;
        }
        while(p<nums.length){
            nums[p++] = 0;
        }
    }
}
