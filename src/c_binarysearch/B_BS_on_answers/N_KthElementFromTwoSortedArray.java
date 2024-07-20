package c_binarysearch.B_BS_on_answers;

/*
https://www.youtube.com/watch?v=D1oDwWCq50g
https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=k-th-element-of-two-sorted-array
https://takeuforward.org/data-structure/k-th-element-of-two-sorted-arrays/

Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the kth position of the final sorted array.


Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6


Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.



Example 2:
Input:
arr1[] = {100, 112, 256, 349, 770}
arr2[] = {72, 86, 113, 119, 265, 445, 892}
k = 7
Output:
256
Explanation:
Final sorted array is - 72, 86, 100, 112,
113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.

Your Task:
You don't need to read input or print anything.
Your task is to complete the function kthElement() which takes the arrays arr1[], arr2[],
its size N and M respectively and an integer K as inputs and returns the element at the Kth position.


Expected Time Complexity: O(Log(N) + Log(M))
Expected Auxiliary Space: O(Log (N))



* */
public class N_KthElementFromTwoSortedArray {

    public long kthElement( int arr1[], int arr2[], int len1, int len2, int k) {

        if(len1 > len2)
            return kthElement(arr2,arr1, len2,len1,k);


        //The size of the left half will be k: Here,
        // we don’t need to find the median and instead, we want the k-th element.
        // So, the partition will be after the k-th element.
        // So, the size of the left half will be k instead of (m+n)/2. For example,
        int noOfEleFromNum1InLeftHalfOfResult = k;


        //iven arr1[] size i.e. len1 = 5,
        // arr2[] size i.e. len2 = 6
        // and k = 7.
        // Now, the lowest value of mid(i.e. The no. of elements we should take from arr1[]) should be 2.
        // If we have to build an array of size, 7, and the maximum element we can take from arr2[] is 5,
        // so, we have to take a minimum of 2 elements from arr1[].
        int low = Math.max(0, k-len2);

        // // If arr1 size is greater than k
        //Earlier I was taking high= len1 but what if k is less that len1
        int high = Math.min(k,len1);

        while(low <= high){
            int mid1 = low + (high-low)/2;
            int mid2 = k -mid1;


            int l1 = mid1 > 0 ? arr1[mid1-1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? arr2[mid2-1] : Integer.MIN_VALUE;

            int r1 = mid1 < len1 ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < len2 ? arr2[mid2] : Integer.MAX_VALUE;


            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }

        }
        return 0;
    }
}
