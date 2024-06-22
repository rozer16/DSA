package o_heap;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/convert-min-heap-to-max-heap/
https://www.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=convert-min-heap-to-max-heap


* */
public class C_Convert_MinHeap_To_MaxHeap {


    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4};

        C_Convert_MinHeap_To_MaxHeap sol = new C_Convert_MinHeap_To_MaxHeap();
        sol.convertMinToMaxHeap(arr.length, arr);
        System.out.println(Arrays.toString(arr));
    }
    public void convertMinToMaxHeap(int N, int arr[]) {

        for(int i = (N-2)/2; i>= 0;--i){
            maxHeapify( arr,N,i);
        }
    }

    public void maxHeapify(int [] arr, int N, int i){

        int l = (2*i)+1;
        int r = (2*i)+2;

        int largest = i;

        if(N > l && arr[l] > arr[i])
            largest = l;
        if(N > r && arr[r] > arr[largest])
            largest = r;

        if(largest != i){
            swap(arr, i, largest);
            maxHeapify(arr, N, largest);
        }
    }

    public void swap(int [] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
