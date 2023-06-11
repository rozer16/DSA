package b_array;

import java.util.Arrays;

public class C_MergeTwoSortedArray {


    public int [] mergeTwoSortedArray(int [] arr1, int [] arr2){
        int [] result = new int[arr1.length+arr2.length];
        if(arr1.length == 0)
            return arr2;
        if(arr2.length == 0)
            return arr1;

        int len1 = arr1.length;
        int len2 = arr2.length;
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while(p1< len1 && p2 < len2 ){
            if(arr1[p1] < arr2[p2])
                result[p++] = arr1[p1++];
            else
                result[p++] = arr2[p2++];
        }
        while(p1<len1)
            result[p++] = arr1[p1++];

        while(p2<len2)
            result[p++] = arr1[p2++];

        return result;


    }

    public static void main(String[] args) {
        C_MergeTwoSortedArray test = new C_MergeTwoSortedArray();
        int [] nums1 = {1,3,5,6,8,10,12};
        int [] nums2 = {2,4,6,9,12};
        int [] num3 = test.mergeTwoSortedArray(nums1,nums2);
        System.out.println(Arrays.toString(num3));
    }
}
