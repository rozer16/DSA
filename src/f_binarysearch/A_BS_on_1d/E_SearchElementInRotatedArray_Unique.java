package f_binarysearch.A_BS_on_1d;

/*
https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/

https://leetcode.com/problems/search-in-rotated-sorted-array/

https://youtu.be/5qGrJbHhqFs

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target,
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
* */

public class E_SearchElementInRotatedArray_Unique {

    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        E_SearchElementInRotatedArray_Unique sol = new E_SearchElementInRotatedArray_Unique();
        System.out.println(sol.search(arr,0)); //4
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2},3)); //-1

    }

    /*
    1) By having a sorted array, we guarantee that each index divides the array into two sorted halves.
    2) In the search process, we compare the target value with the middle element,
       i.e. arr[mid], and then eliminate either the left or right half accordingly.
       This elimination becomes feasible due to the inherent property of the sorted halves
       (i.e. Both halves always remain sorted).


    3) Place the 2 pointers i.e. low and high:
      Initially, we will place the pointers like this:
                low will point to the first index,
                and high will point to the last index.


    4) Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
            mid = (low+high) // 2 ( ‘//’ refers to integer division)


       Check if arr[mid] == target: If it is, return the index mid.


     5) IMPORTANT STEP :
        5.1)
            Identify the sorted half, check where the target is located, and then eliminate one half accordingly:

            If arr[low] <= arr[mid]: This condition ensures that the left part is sorted.
                     If arr[low] <= target && target <= arr[mid]: It signifies that the target is in this sorted half.
                            So, we will eliminate the right half (high = mid-1).
                     Otherwise, the target does not exist in the sorted half.
                     So, we will eliminate this left half by doing low = mid+1.
        5.2)

            Otherwise, if the right half is sorted:
                    If arr[mid] <= target && target <= arr[high]: It signifies that the target is in this sorted right half.
                         So, we will eliminate the left half (low = mid+1).
                    Otherwise, the target does not exist in this sorted half.
                     So, we will eliminate this right half by doing high = mid-1.
    *
    * */
    public int search(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len-1;

        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target)
                return mid;

            //For rotated array either left part will be sorted or right part
            //If left is sorted
            if(arr[low] <= arr[mid]){
                //If element lies in between arr[low]...arr[mid]
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid-1;
                }else{
                    //eliminate this left half
                    low = mid+1;
                }
            }else{
                ////If right is sorted
                if(arr[mid+1] <= target && target <= arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}
