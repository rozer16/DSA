package f_binarysearch.A_BS_on_1d;

public class A_BinarySearch {

    public static int binarySearchRecursion(int []array, int left,int right, int search) {
        if(array.length < 1) {
            return -1;
        }
        if(left <= right) {
            int mid = (left + right)/2;
            if(array[mid] == search) {
                return mid;
            }
            if(search < array[mid]) {
                return binarySearchRecursion(array, left, mid, search);
            }else {
                return binarySearchRecursion(array, mid+1, right, search);
            }
        }

        return -1;
    }
    public boolean search(int [] arr,int no){

        int left = 0;
        int right = arr.length-1;


        while(left <= right){
            int mid = (right+left)/2;

            if(arr[mid] == no)
                return true;

            if(arr[mid] < no)
                left = mid+1;
            else
                right = mid-1;

        }


        return false;
    }


    public static void main(String[] args) {
        A_BinarySearch test = new A_BinarySearch();
        int [] arr = {1,2,3,4,5,6,7,8};
        System.out.println(test.search(arr,10));
    }


    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        int low = 0;
        int high = len-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[low] <= nums[mid]){
                ans = Math.min(ans, nums[low]);
                low = mid+1;
            }else{
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }

        return ans;
    }
}
