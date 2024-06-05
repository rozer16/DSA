package f_binarysearch;


import java.util.Arrays;

/*
*
https://takeuforward.org/arrays/search-insert-position/
*
https://youtu.be/6zhGS79oQ4k
*
https://leetcode.com/problems/search-insert-position/description/
* */
public class C_FindInsertionPoint_InSortedArray {

    public static void main(String[] args) {
        int arr[] = {1,3,5,6};
        C_FindInsertionPoint_InSortedArray sol = new C_FindInsertionPoint_InSortedArray();
        System.out.println(sol.searchInsert(arr,5)); //2
        System.out.println(sol.searchInsert(arr,2)); //1
        System.out.println(sol.searchInsert(arr,7)); //4
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int result = len;
        if(nums[0] >= target)
            return 0;
        if(nums[len-1] < target)
            return len;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] >= target){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return result;
    }
}
