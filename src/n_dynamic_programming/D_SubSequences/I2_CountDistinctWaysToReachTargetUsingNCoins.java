package n_dynamic_programming.D_SubSequences;

import java.util.Arrays;

public class I2_CountDistinctWaysToReachTargetUsingNCoins {

    public static void main(String[] args) {
        int amount = 5;
        int [] coins = {1,2,5};

        int dp[][] = new int[coins.length][amount+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        I2_CountDistinctWaysToReachTargetUsingNCoins solution = new I2_CountDistinctWaysToReachTargetUsingNCoins();
        System.out.println("No of ways we can reach target by using coints Using recursion : "+solution.changeRecursion(coins.length-1,amount,coins) );
        System.out.println("No of ways we can reach target by using coints Using momoizatoin : "+solution.changeRecursionMemoization(coins.length-1,amount,coins,dp) );
        System.out.println("No of ways we can reach target by using coints Using tabulation : "+solution.changeRecursionTabulation(amount,coins) );
        System.out.println("No of ways we can reach target by using coints Using space optimization : "+solution.changeRecursionSpaceOptimization(amount,coins) );
    }



    public int changeRecursion(int index,int amount, int[] coins) {
        if(index == 0 ){
            if(amount % coins[0] == 0)
                return 1;
            return 0;
        }


        int notTake = changeRecursion(index-1,amount,coins);
        int take = 0;
        if(coins[index] <= amount)
            take = changeRecursion(index,amount-coins[index],coins);
        return take + notTake;

    }

    public int changeRecursionMemoization(int index,int amount, int[] coins,int [][] dp) {
        if(index == 0 ){
            if(amount % coins[0] == 0)
                return 1;
            return 0;
        }


        if(dp[index][amount] != -1)
            return dp[index][amount];

        int notTake = changeRecursion(index-1,amount,coins);
        int take = 0;
        if(coins[index] <= amount)
            take = changeRecursion(index,amount-coins[index],coins);

        dp[index][amount] = notTake + take;
        return take + notTake;

    }


    public int changeRecursionTabulation(int amount, int[] coins) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];

        for (int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }


        for (int index = 1 ; index < n; index++) {
            for (int amo = 0; amo <= amount; amo++) {
                int notTake = dp[index-1][amo];
                int take = 0;
                if(coins[index] <= amo)
                    take = dp[index][amo-coins[index]];

                dp[index][amo] = notTake + take;
            }
        }


        return dp[n-1][amount];

    }


    public int changeRecursionSpaceOptimization(int amount, int[] coins) {
        int n = coins.length;
        int [] prev = new int[amount+1];

        for (int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0)
                prev[i] = 1;
            else
                prev[i] = 0;
        }


        for (int index = 1 ; index < n; index++) {
            int [] curr = new int[amount+1];
            for (int amo = 0; amo <= amount; amo++) {
                int notTake = prev[amo];
                int take = 0;
                if(coins[index] <= amo)
                    take = curr[amo-coins[index]];

                curr[amo] = notTake + take;
            }
            prev = curr;
        }


        return prev[amount];

    }



}
