package sorting;

import java.util.Arrays;
import java.util.Random;

public class ParellelMergeSort {


    public static void main(String[] args) {
        int len = 1000000;
        int[] a = createArray(len);

        int [] b = new int[len];
        System.arraycopy(a,0,b,0,a.length);

        long start = System.currentTimeMillis();
        mergeSort(a,0,a.length);
        long end = System.currentTimeMillis();
        System.out.println("Sequential time :"+(end-start));


         start = System.currentTimeMillis();
        parellelMergeSort(b,0,a.length,Runtime.getRuntime().availableProcessors());
         end = System.currentTimeMillis();
        System.out.println("Parallel time :"+(end-start));

        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
    }

    private static  int [] createArray(int n){

        Random random = new Random();
        int [] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i]= random.nextInt(n);
        }

        return a;

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
    public static void parellelMergeSort(int [] a,int low, int high , int noOfThreads){
        System.out.println("parallelMergeSort :low:"+low+" high: "+high+" noOfThread :"+noOfThreads);
        if(noOfThreads <= 1){
            mergeSort(a,low,high);
            return;
        }
        int middleIndex = (high+low)/2;
        Thread leftThread = createThread(a,low,middleIndex,noOfThreads);
        Thread rightThread = createThread(a,middleIndex,high,noOfThreads);

        leftThread.start();
        rightThread.start();

        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(a,low,middleIndex,high);;
    }
    private static Thread createThread(int [] a, int startIndex, int lastIndex, int noOfThread){
        return new Thread(() -> parellelMergeSort(a,startIndex,lastIndex,noOfThread/2));
    }


}

