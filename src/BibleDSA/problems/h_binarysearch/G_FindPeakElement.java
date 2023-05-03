package BibleDSA.problems.h_binarysearch;


/*
*
* https://leetcode.com/problems/find-peak-element/description/
* */
public class G_FindPeakElement {

    public int recursive_binary_search(int [] nums,int low,int high){
        if(low == high){
            return low;
        }
        int mid = (low + high) >> 1;
        if(nums[mid] > nums[mid+1]){
            return recursive_binary_search(nums, low, mid);
        }
        else{
            return recursive_binary_search(nums, mid+1, high);
        }
    }

    public static void main(String[] args) {
        G_FindPeakElement test = new G_FindPeakElement();
        int [] arr = {2,2,1,3,2,3,2};
        int [] arr1 = {6,5,4,3,2,1,2};


        System.out.println(test.recursive_binary_search(arr1,0,6));
    }
}
