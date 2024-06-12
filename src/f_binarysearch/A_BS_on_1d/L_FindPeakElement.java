package f_binarysearch.A_BS_on_1d;


/*
*
*
* https://takeuforward.org/data-structure/peak-element-in-array/
* https://www.youtube.com/watch?v=cXxmbemS6XM
* https://leetcode.com/problems/find-peak-element/description/
*
*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
* */
public class L_FindPeakElement {

    public int recursive_binary_search(int [] nums,int low,int high){
        if(low == high){
            return low;
        }
        int mid = (low + high) >> 1;
        if(nums[mid] > nums[mid+1]){
            return recursive_binary_search(nums, low, mid);
        }
        else{
            return recursive_binary_search(nums, mid+1, high);
        }
    }


    public int findPeakElement(int[] arr) {
        int len = arr.length;
        if(arr.length == 1)
            return 0;
        //If first ele is peak
        if(arr[0] > arr[1]) return 0;

        //If last ele is peak
        if(arr[len-1] > arr[len-2])  return len-1;

        int low = 1;
        int high = len-2;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                return mid;
            }else if(arr[mid] > arr[mid-1]){
                //Check if increasing curve then peak can be on right half
                low = mid+1;
            }else {
                //Check if decreasing curve then peak can be on the left
                high = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        L_FindPeakElement test = new L_FindPeakElement();
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        int [] arr1 = {6,5,4,3,2,1,2};


        System.out.println(test.findPeakElement(arr));
    }
}
