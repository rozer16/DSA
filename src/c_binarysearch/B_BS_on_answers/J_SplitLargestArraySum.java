package c_binarysearch.B_BS_on_answers;

public class J_SplitLargestArraySum {

    public static void main(String[] args) {
        J_SplitLargestArraySum sol = new J_SplitLargestArraySum();
        System.out.println(sol.splitArray(new int[]{7,2,5,10,8},2));
        System.out.println(sol.splitArray(new int[]{1,2,3,4,5},2));
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if (k > n)
            return -1;

        int [] maxSum = findMaxSum(nums);
        int low = maxSum[0];
        int high = maxSum[1];
        int ans = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isSplitPossibleByNSum(nums,mid) > k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }

    public int isSplitPossibleByNSum(int [] arr, int sum){
        int noOfPages = 0;
        int noOfStudent = 1;

        for (int i = 0; i < arr.length; i++) {
            if(noOfPages + arr[i] > sum){
                //  // add pages to next student
                noOfStudent++;
                noOfPages = arr[i];
            }else{
                // // add pages to current student
                noOfPages += arr[i];
            }
        }



        return noOfStudent;
    }
    public int[] findMaxSum(int [] nums){
        int maxSum [] = new int[2];
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int page : nums){
            if(max < page)
                max = page;

            sum += page;
        }

        return  new int[]{max, sum};
    }
}
