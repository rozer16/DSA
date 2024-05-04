package n_dynamic_programming.D_SubSequences;

import java.util.Arrays;

public class D2_CountSubsetsWithSumK {

    public static void main(String[] args) {

        D2_CountSubsetsWithSumK solution = new D2_CountSubsetsWithSumK();

        //Below method calls are elements greater than 1
        int[] nums = {1, 2, 2, 3};
        int k = 3;

        int dp[][] = new int[nums.length][k + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Arr : "+Arrays.toString(nums));
        System.out.println("k="+k);
        System.out.println("No of subset with sum k using recursion: " + solution.countSubsetWithSumK(nums, k, nums.length - 1));
        System.out.println("No of subset with sum k using memoization: " + solution.countSubsetWithSumKMemoization(nums, k, nums.length - 1, dp));
        System.out.println("No of subset with sum k using tabulation: " + solution.countSubsetWithSumKTabulation(nums, k));
        System.out.println("No of subset with sum k using space optimization: " + solution.countSubsetWithSumKSpaceOptimization(nums, k));


        System.out.println("====================");

        //Below method calls are for array having element 0 or greater than 0;

        int [] arr1 = {0,0,1};
        int k1= 1;
        int dp1[][] = new int[arr1.length][k1 + 1];
        for (int i = 0; i < dp1.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println("Arr : "+Arrays.toString(arr1));
        System.out.println("k="+k1);
        System.out.println("Count of Partitions with sum k using recrusion : "+ solution.countSubsetWithSumKMemoization(arr1,arr1.length-1,k1));
        System.out.println("Count of Partitions with sum k using memoization : "+ solution.countSubsetWithSumKMemoization2(arr1,arr1.length-1,k1,dp));
        System.out.println("Count of Partitions with sum k using tabulation : "+ solution.countSubsetWithSumKTabulation2(arr1,k1));
        System.out.println("Count of Partitions with sum k using space optimization : "+ solution.countSubsetWithSumKSpaceOptimization2(arr1,k1));
    }


    public int countSubsetWithSumK(int[] nums, int sum, int index) {
        if (sum == 0)
            return 1;

        if (index == 0)
            return nums[0] == sum ? 1 : 0;

        int notTake = countSubsetWithSumK(nums, sum, index - 1);
        int take = 0;
        if (sum >= nums[index])
            take = countSubsetWithSumK(nums, sum - nums[index], index - 1);

        return take + notTake;
    }

    //Above method works only if all elements in nums are greater than 0
    public int countSubsetWithSumKMemoization(int[] nums, int sum, int index, int[][] dp) {
        if (sum == 0)
            return 1;

        if (index == 0)
            return nums[0] == sum ? 1 : 0;

        if (dp[index][sum] != -1)
            return dp[index][sum];


        int notTake = countSubsetWithSumK(nums, sum, index - 1);
        int take = 0;
        if (sum >= nums[index])
            take = countSubsetWithSumK(nums, sum - nums[index], index - 1);

        dp[index][sum] = take + notTake;
        return take + notTake;
    }

    public int countSubsetWithSumKTabulation(int[] nums, int k) {
        int n = nums.length;

        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (nums[0] <= k)
            dp[0][nums[0]] = 1;

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {
                int notTake = dp[index - 1][target];
                int take = 0;
                if (target >= nums[index])
                    take = dp[index - 1][target - nums[index]];


                dp[index][target] = take + notTake;
            }
        }
        return dp[n-1][k];
    }

    public int countSubsetWithSumKSpaceOptimization(int[] nums, int k) {
        int n = nums.length;

        int[] prev = new int[k + 1];

        prev[0] = 1;

        if (nums[0] <= k)
            prev[nums[0]] = 1;

        for (int index = 1; index < n; index++) {
            int[] curr = new int[k + 1];
            curr[0] = 1;
            for (int target = 1; target <= k; target++) {
                int notTake = prev[target];
                int take = 0;
                if (target >= nums[index])
                    take = prev[target - nums[index]];


                curr[target] = take + notTake;
            }
            prev = curr;
        }
        return prev[k];
    }



    //Elements in nums might be 0 or greater than 0;
    public int countSubsetWithSumKMemoization(int [] nums, int index , int target){

        if(index == 0) {

            // we are at index 0, if the target target is 0 and the first index is also 0
            //we can form the subset in two ways, either by considering the first element or leaving it, so we can return 2.
            if (nums[0] == 0 && target == 0)
                return 2;

            //at index 0, if target == 0, and the first element is not 0, it means we will not pick the first element so we just return 1 way.
            // or 1st element is equal to target then also we will return 1
            if (target == 0 || nums[0] == target )
                return 1;

            return 0;
        }

        int notPick = countSubsetWithSumKMemoization(nums,index-1, target);
        int pick = Integer.MIN_VALUE;

        if(nums[index] <= target)
            pick = countSubsetWithSumKMemoization(nums,index-1, target-nums[index]);

        return pick+notPick;
    }

    public int countSubsetWithSumKMemoization2(int [] nums, int index , int target,int [][] dp) {
        if(index == 0){
            if(target == 0 && nums[0] == 0)
                return 2;

            if(target == 0 || nums[0] == target )
                return 1;

            return 0;
        }

        if(dp[index][target] != -1)
            return dp[index][target];
        int notPick = countSubsetWithSumKMemoization2(nums,index-1, target,dp);
        int pick = Integer.MIN_VALUE;

        if(nums[index] <= target)
            pick = countSubsetWithSumKMemoization2(nums,index-1, target-nums[index],dp);

        dp[index][target] = pick+notPick;
        return pick+notPick;

    }

    public int countSubsetWithSumKTabulation2(int [] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        //If sum is 0, target is also 0 and nums[0] is als0 0
        //so there are two cases take(since its not modifying sum) and nottake
        if (nums[0] == 0)
            dp[0][0] = 2;
        //if nums[0] != 0 but index is zero and  target is zero
        //so not take case
        else
            dp[0][0] = 1;


        // nums[0] == target  edge case
        if (nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1;



        for (int index = 1; index < n; index++) {
            for (int t1 = 0; t1 <= target; t1++) {
                int notTake = dp[index - 1][t1];
                int take = 0;
                if (t1 >= nums[index])
                    take = dp[index - 1][t1 - nums[index]];


                dp[index][t1] = take + notTake;
            }
        }
        return dp[n-1][target];

    }


    public int countSubsetWithSumKSpaceOptimization2(int [] nums, int target) {
        int n = nums.length;
        int[] prev = new int[target + 1];

        //If sum is 0, target is also 0 and nums[0] is als0 0
        //so there are two cases take(since its not modifying sum) and nottake
        if (nums[0] == 0)
            prev[0] = 2;
            //if nums[0] != 0 but index is zero and  target is zero
            //so not take case
        else
            prev[0] = 1;


        // nums[0] == target  edge case
        if (nums[0] != 0 && nums[0] <= target)
            prev[nums[0]] = 1;



        for (int index = 1; index < n; index++) {
            int[] curr = new int[target + 1];
            for (int t1 = 0; t1 <= target; t1++) {
                int notTake = prev[t1];
                int take = 0;
                if (t1 >= nums[index])
                    take = prev[t1 - nums[index]];


                curr[t1] = take + notTake;
            }
            prev = curr;
        }
        return prev[target];

    }

}
