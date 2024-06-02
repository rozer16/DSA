package f_binarysearch;

public class L_FindMediunOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
