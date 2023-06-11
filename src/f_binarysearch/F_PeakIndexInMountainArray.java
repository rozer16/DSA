package f_binarysearch;
/*
*
* https://leetcode.com/problems/peak-index-in-a-mountain-array/
*
*
* Example 1:

Input: arr = [0,1,0]
Output: 1


 Example 2:

Input: arr = [0,2,1,0]
Output: 1

Example 3:


Input: arr = [0,10,5,2]
Output: 1
* */
public class F_PeakIndexInMountainArray {

    public int getPeakIndexInMountainArray(int [] arr){
        int left= 0;
        int right = arr.length-1;
        int ans = 0;

        while(left <= right){
            int mid = (right+left)/2;
            if(arr[mid]>arr[mid+1]){
                ans=mid;
                right = mid-1;
            }else{
                left = mid+1;
            }


        }

        return ans;
    }

    public static void main(String[] args) {
        F_PeakIndexInMountainArray test = new F_PeakIndexInMountainArray();
        int arr[] = {0,10,5,2};

        System.out.println(test.getPeakIndexInMountainArray(arr));
    }
}
