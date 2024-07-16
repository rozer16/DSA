package c_binarysearch.A_BS_on_1d;

import java.util.Arrays;


/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
https://takeuforward.org/data-structure/last-occurrence-in-a-sorted-array/
https://youtu.be/hjR1IYVx9lY
* */
public class G_FindStartinAndEndingPositionOfGivenTargetValue {


    public static void main(String[] args) {

        int[] arr =  {5,7,7,8,8,10};
        int n = 8, x = 6;
        G_FindStartinAndEndingPositionOfGivenTargetValue sol = new G_FindStartinAndEndingPositionOfGivenTargetValue();
        System.out.println(Arrays.toString(sol.searchRange(arr,  x)));

    }
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums,target);
        if(lb == -1)
             return new int[]{-1,-1};

        int last = upperBound(nums, target);

        return new int[]{lb, last};
    }

    public int lowerBound(int [] arr, int x){
        int low = 0;
        int len = arr.length;
        int high = len-1;

        int result = -1;

        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                result = mid;
                //Trying to find lesser index if any
                high = mid-1;
            }else if(arr[mid] > x){
                high = mid-1;
            }else {
                low =  mid+1;
            }
        }

        return result;
    }


    public int upperBound(int [] arr, int x){
        int low = 0;
        int len = arr.length;
        int high = len-1;

        int result = -1;

        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid ] == x ){
                result = mid;
                //Trying to find greater index
                low=mid+1;
            }else if(arr[mid] > x){
                high = mid-1;
            }else {
                low =  mid+1;
            }
        }

        return result;
    }
}
