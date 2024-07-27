package c_binarysearch.A_BS_on_1d;


import java.util.Arrays;

/*
https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/
https://youtu.be/6zhGS79oQ4k
https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401
You're given a sorted array 'a' of 'n' integers and an integer 'x'.



Find the floor and ceiling of 'x' in 'a[0..n-1]'.



Note:
Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.


Example:
Input:
n=6, x=5, a=[3, 4, 7, 8, 8, 10]

Output:
4

Explanation:
The floor and ceiling of 'x' = 5 are 4 and 7, respectively.

* */
public class D_Find_Ceiling_Floor   {

    public static void main(String[] args) {
        int [] arr = {3, 4 ,4 ,7, 8, 10};
        System.out.println(Arrays.toString(getFloorAndCeil(arr, arr.length, 8)));//[8, 8]
        int [] arr1 = {3 ,4 ,4, 7, 8 ,10};
        System.out.println(Arrays.toString(getFloorAndCeil(arr1, arr1.length, 2)));//[-1,3]

    }
    public static int[] getFloorAndCeil(int[] a, int n, int target) {
        int floor = getFloor(a, n, target);
        int ceil = getCeil(a, n, target);

        return new int[]{floor, ceil};

    }

    public static int getFloor(int[] nums, int n, int target) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int result = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] <= target){
                result = nums[mid];
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return result;


    }

    public static int getCeil(int[] nums, int n, int target) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int result = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] >= target){
                result = nums[mid];
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return result;

    }
}
