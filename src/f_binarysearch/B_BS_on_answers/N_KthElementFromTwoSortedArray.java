package f_binarysearch.B_BS_on_answers;

/*
https://www.youtube.com/watch?v=D1oDwWCq50g
https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=k-th-element-of-two-sorted-array
https://takeuforward.org/data-structure/k-th-element-of-two-sorted-arrays/

* */
public class N_KthElementFromTwoSortedArray {

    public long kthElement( int arr1[], int arr2[], int len1, int len2, int k) {

        if(len1 > len2)
            return kthElement(arr2,arr1, len2,len1,k);

        //In case k > len2 for e.g. k = 6 and len1=4,len2 = 5 so I will have to take at least 1 from arr1
        //Earlier I was taking low = 0 considering I wont take any element but  I will have to take at least 1 from arr1
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
