package b_array.hard;


import java.util.Arrays;

/*
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].


Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1

* */
public class I_CountInversionPair_1 {

    public static void main(String[] args) {
        int arr1[] = {1,3,2,3,1};
        int arr [] = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        I_CountInversionPair_1 sol = new I_CountInversionPair_1();
        int cnt = sol.merge(arr, 0, arr.length - 1);
        System.out.println(cnt);
        System.out.println(Arrays.toString(arr));
    }

    public int countReversePair(int [] arr, int low, int mid, int high){

        int right = mid+1;
        int cnt = 0;
        for(int i = low; i<= mid; i++){

            long temp = 2L *arr[right];
            while(right <= high && arr[i] > temp)right++;
            cnt += (right-(mid+1));
        }

        return cnt;
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }



    public int merge(int [] nums, int left, int right){
        int cnt=0;
        if(right <= left)
            return cnt;

        int low = left;
        int high = right;
        int mid = left + (right-left)/2;

        cnt += merge(nums, low, mid);
        cnt += merge(nums, mid+1, high);
        cnt += countReversePair(nums, low, mid, high);

        mergeSort(nums, low, mid, high);
        return cnt;
    }

    public void mergeSort(int [] nums, int low, int mid, int high){
        int left = low;
        int right = mid+1;

        int temp []  = new int[high-low+1];
        int tempP=0;

        while(left <= mid && right <= high){
            if(nums[left] < nums[right]){
                temp[tempP++] = nums[left++];
            }else{
                temp[tempP++] = nums[right++];
            }
        }

        while(left <= mid){
            temp[tempP++] = nums[left++];
        }
        while(right <= high){
            temp[tempP++] = nums[right++];
        }

        System.arraycopy(temp, 0, nums, low, high-low+1);
    }
}