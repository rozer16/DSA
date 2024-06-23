package n_dp.H_Partition_DP;

public class C2_BurstBalloons_DP {

    public static void main(String[] args) {

    }

    public int maxCoins(int[] nums) {

        /*int n = nums.length;
        int [] numsNew = new int[n+2];
        numsNew[0] = 1;
        numsNew[n+1] = 1;
        System.arraycopy(nums, 0, numsNew, 1, n);
        int [][]dp = new int[numsNew.length][numsNew.length];
        for(int [] row : dp)
            Arrays.fill(row, -1);
        //return maxCoinsRecursion(1,n,numsNew,dp);*/

        return maxCoinsTabulation(nums);
    }

    public int maxCoinsRecursion(int left, int right,int[] nums,int [][]dp) {
        if(left > right)
            return 0;

        if(dp[left][right] != -1)
            return dp[left][right];

        int coins = Integer.MIN_VALUE;
        for(int index = left; index <= right; index++){
            int tempCoins = (nums[left-1]*nums[index]*nums[right+1])
                    + maxCoinsRecursion(left, index-1,nums,dp)
                    + maxCoinsRecursion(index+1, right, nums,dp)
                    ;
            coins = Math.max(coins, tempCoins);
        }

        dp[left][right] = coins;
        return coins;

    }

    public int maxCoinsTabulation(int[] nums) {
        int n = nums.length;
        int [] numsNew = new int[n+2];
        numsNew[0] = 1;
        numsNew[n+1] = 1;
        System.arraycopy(nums, 0, numsNew, 1, n);
        int [][]dp = new int[n+2][n+2];


        for(int left = n; left >=1; left--){
            for(int right = 1; right <=n; right++){
                if(left > right)
                    continue;

                int coins = Integer.MIN_VALUE;
                for(int index = left; index <= right; index++){
                    int tempCoins = (numsNew[left-1]*numsNew[index]*numsNew[right+1])
                            + dp[left][index-1]
                            + dp[index+1][right]
                            ;
                    coins = Math.max(coins, tempCoins);
                }
                dp[left][right] = coins;
            }
        }


        return dp[1][n];

    }
}
