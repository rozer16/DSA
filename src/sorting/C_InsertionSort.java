package sorting;

import java.util.Arrays;

public class C_InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{20, 35, -15, 7, 55, 1, -22};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    /*
    In this sorting we will sort from right to left opposite to bubble & insertion sort.
    firstUnsortedIndex = 1 to len - 1  --> First index of unsorted partition
    i = 0 --> index used to traverse the array from right to left, the most last  sorted index of an array
    newElement = a[i] --> the element we want to insert into sorted partition
    If newElement is less than a[i], then we will shift a[i] to left

    i =0 , firstUnsortedIndex = 1 , newElement = 35
    20 35 -15 7 55 1 -22

    i =1 , firstUnsortedIndex =2 , newElement = -15
    20 35 -15 7 55 1 -22
    20 35 35 7 55 1 -22
    20 20 35 7 55 1 -22
    -15 20 35 7 55 1 -22

    i =2 , firstUnsortedIndex =3 , newElement = 7
    -15 20 35 35 55 1 -22   i = 1
    -15 20 20 35 55 1 -22   i = 0
    -15 7 20 35 55 1 -22

    i =3 , firstUnsortedIndex =4 , newElement = 55
    -15 7 20 35 55 1 -22

    i =4 , firstUnsortedIndex =5 , newElement = 1
    -15 7 20 35 55 55 -22     i = 3
    -15 7 20 35 35 55 -22     i = 2
    -15 7 20 20 35 55 -22     i = 1
    -15 7 7 20 35 55 -22      i = 0;
    -15 1 7 20 35 55 -22

    i =5 , firstUnsortedIndex =6 , newElement = -22
    -15 1 7 20 35 55 55    i = 4
    -15 1 7 20 35 35 55    i = 3
    -15 1 7 20 20 35 55    i = 2
    -15 1 7 7 20 35 55    i = 1
    -15 1 1 7 20 35 55    i = 0
    -15 -15 1 7 20 35 55
    -22 -15 1 7 20 35 55



    * In place algorithm
    * Stable Algorithm
    * Complexity : O(n2) - quadratic
    * Outer loop is one that is growing the sorted partition by one
        and inner loop is to find the correct position of first element of unsorted element
    * Lot of shifting.So solution is shell sort
    * */

    private static void insertionSort(int [] a){
        for(int fistUnsoredIndex = 1; fistUnsoredIndex < a.length ; fistUnsoredIndex ++){
            int i = fistUnsoredIndex ;
            int firstUnsoredValue = a[fistUnsoredIndex];
            while(i > 0 && firstUnsoredValue < a[i-1]){
               a[i] = a[i-1];
               i--;
            }
            a[i] = firstUnsoredValue;
        }
    }
    public static void swap(int [] arr,int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}