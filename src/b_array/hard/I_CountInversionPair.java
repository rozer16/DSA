package b_array.hard;


import java.util.Arrays;

import static a_sorting.D_ParellelMergeSort.mergeSort;

/*
Problem Statement: Given an array of N integers, count the inversion of the array

What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].
* */
public class I_CountInversionPair   {

    public static void main(String[] args) {
        int arr [] = {5,4,3,2,1};
        I_CountInversionPair sol = new I_CountInversionPair();
        int cnt = sol.merge(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public int  merge(int arr[], int low, int high){
        int cnt = 0;
        if(high <= low)
            return cnt;

        int mid = low + (high-low)/2;

        cnt += merge(arr, low, mid);
        cnt += merge(arr,mid+1, high);
        cnt += mergeSort(arr, low, mid, high);
        return cnt;
    }

    private int mergeSort(int[] arr, int low, int mid, int high) {
        int cnt = 0;
        int left = low;
        int right = mid+1;
        int [] tempArr = new int[high-low+1];
        int tempP=0;

        while (left <= mid && right <= high){
            if(arr[left] < arr[right]){
                tempArr[tempP++] = arr[left++];
            }else{
                cnt += (mid-left)+1;
                tempArr[tempP++] = arr[right++];
            }
        }

       while(left <= mid){
           tempArr[tempP++] = arr[left++];
       }
       while(right <= high){
            tempArr[tempP++] = arr[right++];
       }
       System.arraycopy(tempArr, 0, arr, low, high-low+1);
       return  cnt;
    }
}
