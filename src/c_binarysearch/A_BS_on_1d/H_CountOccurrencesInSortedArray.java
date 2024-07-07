package c_binarysearch.A_BS_on_1d;


/*
https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/

https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence

https://youtu.be/hjR1IYVx9lY

Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
Example 2:

Input:
N = 7, X = 4
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 0
Explanation: 4 is not present in the
given array.
*
* */
public class H_CountOccurrencesInSortedArray {

    public static void main(String[] args) {
        int [] arr = {1, 1, 2, 2, 2, 2, 3};
        H_CountOccurrencesInSortedArray sol = new H_CountOccurrencesInSortedArray();
        System.out.println(sol.count(arr,arr.length,2));

    }

    int count(int[] arr, int n, int x) {
        int lb = lowerBound(arr,x);
        if(lb == -1)
            return 0;

        int last = upperBound(arr, x);

        return last-lb+1;

    }
    public int lowerBound(int [] arr, int x){
        int low = 0;
        int len = arr.length;
        int high = len-1;

        int result = -1;

        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                result = mid;
                //Trying to find lesser index if any
                high = mid-1;
            }else if(arr[mid] > x){
                high = mid-1;
            }else {
                low =  mid+1;
            }
        }

        return result;
    }


    public int upperBound(int [] arr, int x){
        int low = 0;
        int len = arr.length;
        int high = len-1;

        int result = -1;

        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid ] == x ){
                result = mid;
                //Trying to find greater index
                low=mid+1;
            }else if(arr[mid] > x){
                high = mid-1;
            }else {
                low =  mid+1;
            }
        }

        return result;
    }
}
