package n_dp.G_LonngestIncreasingSubsequence;

import java.util.Arrays;

public class A3_LongestIncreasingSubsequence {


    public static void main(String[] args) {
            int [] nums = {10,9,2,5,3,7,101,18};
            A3_LongestIncreasingSubsequence solution = new A3_LongestIncreasingSubsequence();
            System.out.println("LongestIncreasingSubsequence length : "+solution.lengthOfLIS(nums));
            System.out.println("LongestIncreasingSubsequence length using tabulation : "+solution.lengthOfLISTabulation(nums));
    }

    public int lengthOfLIS(int[] nums) {
        //return lengthOfLISRecursion(0,-1, nums);

        //since prevIndex can have -1 to n-1 so n+1
        int [][] dp = new int[nums.length][nums.length+1];

        for(int [] row : dp)
            Arrays.fill(row, -1);

        return lengthOfLISMemoiation(0,-1,nums,dp);
    }

    public int lengthOfLISRecursion(int index, int prevIndex, int[] nums) {
        int n = nums.length;
        if(index == n)
            return 0;

        int notTake =   lengthOfLISRecursion(index+1, prevIndex, nums);
        int take = 0;

        if(prevIndex == -1 || nums[index] > nums[prevIndex])
            take =   1+lengthOfLISRecursion(index+1, index, nums);

        return Math.max(notTake, take);
    }


    /*

            Time Complexity: O(N*N)

            Reason: There are N*N states therefore at max ‘N*N’ new problems will be solved.

            Space Complexity: O(N*N) + O(N)

            Reason: We are using an auxiliary recursion stack space(O(N)) (see the recursive tree, in the worst case we will go till N calls at a time) and a 2D array ( O(N*N+1)).

    * */
    public int lengthOfLISMemoiation(int index, int prevIndex, int[] nums, int [][] dp) {
        int n = nums.length;
        if(index == n)
            return 0;

        if(dp[index][prevIndex+1] != -1)
            return dp[index][prevIndex+1];

        int notTake =   lengthOfLISMemoiation(index+1, prevIndex, nums,dp);
        int take = 0;

        if(prevIndex == -1 || nums[index] > nums[prevIndex])
            take =   1+lengthOfLISMemoiation(index+1, index, nums,dp);

        dp[index][prevIndex+1] = Math.max(notTake, take);

        return  dp[index][prevIndex+1] ;
    }


    /*
    Time Complexity: O(N*N)

    Reason: There are two nested loops

    Space Complexity: O(N*N)

    Reason: We are using an external array of size ‘(N+1)*(N+1)’. Stack Space is eliminated.


    * */
    public int lengthOfLISTabulation(int[] nums) {
        int n = nums.length;

        int [][] dp = new int[n+1][n+1];

        for (int index = n-1; index >=0 ; index--) {
            for(int prevIndex = index-1; prevIndex >= -1; prevIndex--){
                int notTake =   dp[index+1][prevIndex+1];
                int take = 0;

                if(prevIndex == -1 || nums[index] > nums[prevIndex])
                    take =   1+dp[index+1][ index+1] ;

                dp[index][prevIndex+1] = Math.max(notTake, take);

            }
        }


        return  dp[0][0] ;
    }


    /*
    Time Complexity: O(N*N)

    Reason: There are two nested loops.

    Space Complexity: O(N)


    * */
    public int lengthOfLISSpaceOpti(int[] nums) {
        int n = nums.length;

        int [] prev = new int[n+1];
        int [] curr = new int[n+1];
        for (int index = n-1; index >=0 ; index--) {
            for(int prevIndex = index-1; prevIndex >= -1; prevIndex--){
                int notTake =   prev[prevIndex+1];
                int take = 0;

                if(prevIndex == -1 || nums[index] > nums[prevIndex])
                    take =   1+prev[ index+1] ;

                curr[prevIndex+1] = Math.max(notTake, take);

            }
            prev = curr;
        }


        return  prev[0] ;
    }


    }
