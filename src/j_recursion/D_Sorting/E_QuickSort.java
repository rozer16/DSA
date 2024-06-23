package j_recursion.D_Sorting;

import java.util.Arrays;

public class E_QuickSort {
    public static void main(String[] args) {
        int arr [] = {4, 6, 2, 5, 7, 9, 1, 3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        //recursion will continue until the range becomes 1.
        if (low >= high)
            return;
        ;

        // given array should be broken down into subarrays.
        // Get the index(where the pivot should be placed after sorting)
        int pIndex = partition(arr, low, high);

        quickSort(arr, low, pIndex - 1);
        quickSort(arr, pIndex + 1, high);
    }


    public static int partition(int [] arr, int low, int high){

        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i<j) {
            //the pointer i will move forward and find the  element that is greater than the pivot.
            while (i <= high && arr[i] <= pivot)
                i++;

            //the pointer j will move backward and find the first element that is smaller than the pivot.
            while (j >= low && arr[j] > pivot)
                j--;

            //Once we find such elements i.e. arr[i] > pivot and arr[j] < pivot, and i < j,
            // we will swap arr[i] and arr[j].
            if(i<j){
                swap(arr,i,j);
            }
        }
        //swap the pivot element(i.e. arr[low]) with arr[j] and will return the index j
        swap(arr,low,j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
