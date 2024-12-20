package c_binarysearch.B_BS_on_answers;


/*
https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
https://youtu.be/C2rRzz-JDk8
https://leetcode.com/problems/median-of-two-sorted-arrays/description/


Given two sorted arrays nums1 and nums2 of size m and n respectively,
 return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

* */
public class M_FindMediunOfTwoSortedArray {



    //Time Complexity: O(log(min(n1,n2))), where n1 and n2 are the sizes of two given arrays.
    //Reason: We are applying binary search on the range [0, min(n1, n2)].

    //Space Complexity: O(1) as no extra space is used.
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        int len1 = num1.length;
        int len2 = num2.length;


        //In order to make sure num1 length is always smaller to reduce complexity.
        if(len1 > len2)
            return findMedianSortedArrays(num2, num1);

        // If we divide result array in 2 part, how many no of element will be left half
        int noOfLeftEle = (len1+len2+1)/2;

        int low = 0;
        int high = len1;

        while(low <= high){

            //Mid always be pointing first ele on right side of ans
            //No of elements from num1 on left of ans
            int mid1 = low + (high-low)/2;
            int mid2 = noOfLeftEle - mid1; //No of elements from num2 on left of ans


            int l1 = mid1 > 0  ? num1[mid1-1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? num2[mid2-1] : Integer.MIN_VALUE;

            int r1 = mid1 < len1 ? num1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < len2 ? num2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if((len1+len2) % 2 == 1)
                    return Math.max(l1,l2);
                else
                    return ((double)(Math.max(l1,l2) + Math.min(r1,r2)))/2.0;
            }else if(l1 > r2){
                //we need to reduce no of ele on left from arr1 so that l1 will be decreased
                high = mid1-1;

            }else{
                // we need to add no of ele on left from arr1 so that l1 will be increased
                low = mid1+1;
            }

        }

        return 0; //Dummy return value;

    }
    public double findMedianSortedArraysBetter(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;


        int left = 0;
        int right = 0;
        int index1 = (len1+len2)/2;
        int index2 = index1 -1 ;
        int index3 = -1;
        double el1 = Integer.MIN_VALUE;
        double el2 = Integer.MIN_VALUE;


        while(left < len1 && right < len2 && index3 < index1+1){
            if(nums1[left] <= nums2[right]){
                index3++;
                if(index3 == index1)
                    el1 = nums1[left];
                if(index3 == index2)
                    el2 = nums1[left];

                left++;
            }else{
                index3++;
                if(index3 == index1)
                    el1 = nums2[right];
                if(index3 == index2)
                    el2 = nums2[right];

                right++;
            }
        }

        while(left < len1  && index3 < index1+1){
            index3++;
            if(index3 == index1)
                el1 = nums1[left];
            if(index3 == index2)
                el2 = nums1[left];

           left++;
        }
        while(right < len2 && index3 < index1+1){
            index3++;
            if(index3 == index1)
                el1 = nums2[right];
            if(index3 == index2)
                el2 = nums2[right];

            right++;
        }

        if((len1+len2) %2 == 1){
            return el1;
        }else{
            return (el1+el2)/2;
        }
    }
}
