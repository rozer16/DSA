package b_array.medium;


import java.util.Arrays;

/*
* https://leetcode.com/problems/product-of-array-except-self/description/
*
* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*
* */
public class M_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int arr [] = {-1,1,0,-3,3};
        M_ProductOfArrayExceptSelf solution = new M_ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(solution.productOfArrayExceptSelf(arr)));
    }

    public int[] productOfArrayExceptSelf(int [] arr){
        int[] result = new int[arr.length];
        Arrays.fill(result,1);

        for (int i = 1; i < arr.length; i++) {
            result[i] = arr[i-1]*result[i-1];
        }
        int rightProduct = 1;

        for (int i = arr.length-2; i >=0 ; i--) {
            rightProduct = rightProduct*arr[i+1];
            result[i] = result[i]*rightProduct;
        }


        return result;
    }


}
