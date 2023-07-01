package b_array.easy;

import java.util.Arrays;

/*
* https://leetcode.com/problems/rotate-array/
* Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 *
*
* */
public class H_RightRotateArrayByK {
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5};
        H_RightRotateArrayByK test = new H_RightRotateArrayByK();
        System.out.println(Arrays.toString(test.rightRotateArrayByK(arr,2)));
    }

    //TC: O(n)
    //SC : O(1)
    public void rotate(int [] arr,int k){
        if(k==arr.length)
            return;
        if(k>arr.length)
            k=k%arr.length;
        reverseArray(arr,0,arr.length-1);
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,arr.length-1);

    }

    public void reverseArray(int [] arr, int p1,int p2){
        int left = p1;
        int right = p2;
        while(left <= right){
            swap(arr,left++,right--);
        }
    }

    private void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    //TC : O(n)
    //SC : O(k)
    public int [] rightRotateArrayByK(int [] arr, int k){
        if(arr.length == 1)
            return arr;
        if(k>arr.length)
            k=k%arr.length;
        int [] temp = new int[k];
        System.arraycopy(arr,arr.length-k,temp,0,k);
        System.arraycopy(arr,0,arr,k,arr.length-k);
        System.arraycopy(temp,0,arr,0,k);

        return arr;
    }
}
