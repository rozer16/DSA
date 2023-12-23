package g_recursion.D_Sorting;

import java.util.Arrays;

public class C_MergeSort {
    public static void main(String[] args) {
        int arr [] = {8,1,2,6,9,5,4,3,7};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /*
    * Time complexity: O(nlogn)
        Reason: At each step, we divide the whole array, for that logn and we assume n steps are taken to get a sorted array,
        so overall time complexity will be nlogn

      Space complexity: O(n)
        Reason: We are using a temporary array to store elements in sorted order.

      Auxiliary Space Complexity: O(n)
      *
      *
      *
    * */
    public static void mergeSort(int [] arr,int low, int high){
        if(low == high)
            return;
        int mid = (high+low)/2;

        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    public static void merge(int [] arr, int low, int mid, int high){
        int temp [] = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[index++] = arr[left++];
            }else{
                temp[index++] = arr[right++];
            }
        }
        while(left <= mid)
            temp[index++] = arr[left++];
        while(right <= high)
            temp[index++] = arr[right++];

        System.arraycopy(temp,0,arr,low,temp.length);
    }
}
