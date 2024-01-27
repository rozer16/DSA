package a_sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class D_MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{20, 35, -15, 7, 55, 1, -22};
        mergeSort(a,0,a.length);
        System.out.println(Arrays.toString(a));
    }
  /*
    *
    * Divide and conquer algo(Two phase : splitting and merging)
    * Recursive Algo
    * Splitting is logical.We dont create new array.
    *
    *Splitting
        * Divide the array into two.First is called left and second is called right.
        * Keep splitting until all arrays have only one element each.
    * Sorting
        * Merge array into sorted
        * Repeat until you have a single sorted array

    *  Not in place.Uses temporary array.

    start =0 end = arr.length
    midpoint = (start + end) / 2

    * end is always going to 1 greater than last index of array.
    * First we are going to handle left side of array and
        after completing left side we are going to handle right side of an array.


    *
    */

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;  // mid = low+((high-low)/2)
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
    }



    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }






}

