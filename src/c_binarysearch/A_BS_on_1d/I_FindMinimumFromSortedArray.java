package c_binarysearch.A_BS_on_1d;


/*
https://youtu.be/nhEMDKMB44g

https://takeuforward.org/data-structure/minimum-in-rotated-sorted-array/


https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
* */
public class I_FindMinimumFromSortedArray {

    public static void main(String[] args) {
        int [] arr = {3,4,5,1,2};
        I_FindMinimumFromSortedArray sol = new I_FindMinimumFromSortedArray();
        System.out.println(sol.findMin(arr)) ; //1
    }
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        int low = 0;
        int high = len-1;

        while(low <= high){
            int mid = low + (high-low)/2;


            //search space is already sorted then arr[low] will always be the minimum in that search space:

            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }


            // If array is rotated, either left array would be sorted or right array would be sorted

            //If left array is sorted then take min i.e. arr[low] and check on right half of array
            if(nums[low] <= nums[mid]){
                ans = Math.min(ans, nums[low]);
                low = mid+1;
            }else{

                //If right array is sorted then take min i.e. arr[mid] and check on left half of array
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }

        return ans;
    }
}
