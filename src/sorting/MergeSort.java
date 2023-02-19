package sorting;

import java.util.Arrays;

public class MergeSort {
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

    public static void mergeSort(int[] a, int startIndex, int endIndex) {
        if(endIndex-startIndex < 2){
            return;
        }

        int midIndex = (startIndex + endIndex) / 2;
        mergeSort(a,startIndex,midIndex);
        mergeSort(a,midIndex,endIndex);
        merge(a,startIndex,midIndex,endIndex);
    }
    //1 2 3 4 5 6
    public static void merge(int [] array, int startIndex, int midIndex, int endIndex){
        if(array[midIndex -1] <= array[midIndex]){
            return;
        }

        int i = startIndex;
        int j = midIndex;
        int k = endIndex;

        int tempArray [] = new int[endIndex-startIndex];
        int tempIndex = 0;

        while(i< midIndex && j < endIndex ){
            tempArray[tempIndex++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        System.arraycopy(array,i,array,startIndex+tempIndex,midIndex-i);
        System.arraycopy(tempArray,0,array,startIndex,tempIndex);
    }


}

