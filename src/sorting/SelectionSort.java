package sorting;


import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[]{20, 35, -15, 7, 55, 1, -22};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }



    /*


    20 35 -15 7 55 1 -22  largestIndex=0,lastUnsortedIndex=6 , i=0


    * Divides into sorted and unsorted partition just like bubble sort.
    * Traverse the array and find largest array index by iterating an array.
    * Doesnt require as much swapping as bubble sort.

    Impl :
    lastUnsortedIndex = arr.len - 1;  This is the last index of the unsorted partition
    i = 1 Index used to traverse the array from left to right.
    largest = 0 : Index of largest element in unsorted partition


    * Time Complexity : o(n2) -quadratic
    * In place algo -- doesn't require extra space.
    * In average case selection sort performs better than bubble sort since it requires less no of swap.
    * Unstable algo

    * */
    private static void selectionSort(int [] a){
        int lastUnsortedIndex = a.length - 1;
        int largestIndex = 0;

        for(int i =0; i <= a.length-1 ; i++){
            for(int j = 1 ; j <= lastUnsortedIndex ; j++){
                if(a[j] > a[largestIndex])
                    largestIndex = j;
            }
            if(lastUnsortedIndex != largestIndex)
                swap(a,lastUnsortedIndex,largestIndex);
            lastUnsortedIndex--;
            largestIndex = 0;
        }
    }
    public static void swap(int [] arr,int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
