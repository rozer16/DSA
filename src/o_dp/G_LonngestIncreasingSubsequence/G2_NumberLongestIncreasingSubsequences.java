package o_dp.G_LonngestIncreasingSubsequence;

public class G2_NumberLongestIncreasingSubsequences {
    public static void main(String[] args) {
        int [] nums = {1,3,5,4,7};
        G2_NumberLongestIncreasingSubsequences solution = new G2_NumberLongestIncreasingSubsequences();
       // System.out.println(solution.findNumberOfLIS(nums));
        int [] nums1 = {1,2,4,3,5,4,7,2 };
        System.out.println(solution.findNumberOfLIS(nums1));

    }
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        //refers to the len of longest increasing subseq of array with element arr[i] as its last element
        int [] dp = new int[n];

        //refers to the count of longest increasing subseq of array that are possible of length dp[i] with element arr[i] as its last element
        int [] cp = new int[n];
        int maxi = 1;


        for(int i = 0; i<n; i++){
            dp[i] = 1;
            cp[i] = 1;
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    maxi = Math.max(maxi,dp[i]);
                    cp[i] = cp[j];
                }else if(nums[j] < nums[i] && dp[i] == dp[j]+1){
                    cp[i] = cp[i]+cp[j];
                }
            }

        }

        int cnt = 0;
        for(int i = 0; i<n; i++){
            if(dp[i] == maxi)
                cnt += cp[i];
        }
        return cnt;
    }

}
