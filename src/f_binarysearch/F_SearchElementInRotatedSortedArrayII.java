package f_binarysearch;


/*
https://takeuforward.org/arrays/search-element-in-rotated-sorted-array-ii/


https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

https://youtu.be/w2G2W8l__pc


There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.



Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false


Follow up: This problem is similar to Search in Rotated Sorted Array,
 but nums may contain duplicates. Would this affect the runtime complexity? How and why?
*
* */
public class F_SearchElementInRotatedSortedArrayII {

    public static void main(String[] args) {
        int arr [] = {2,5,6,0,0,1,2};
        F_SearchElementInRotatedSortedArrayII sol = new F_SearchElementInRotatedSortedArrayII();
        System.out.println(sol.search(arr,0));
    }
    public boolean search(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == target)
                return true;


            //6 7 1 2 3 4 4 5 --> Works since we can check if left is sorted or half is sorted : 6<2 false so left is unsorted
            //6 7 1 2 3 3 4 4 4 --> Works since we can check if left is sorted or half is sorted : 6<2 false so left is unsorted
            // 3 1 2 3 3 3 3 --> This doesnt work for finding which one is sorted so we will have to shring from left and right.
            // if we are trying to find exact that element then it will be found from middle.
            ////Edge case:

            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }

            //Check if left is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    //element might exists in left half:
                    high = mid-1;
                }else{
                    //element might exists right half:
                    low = mid+1;
                }
            }else{
                //Right half is sorted
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return false;
    }
}
