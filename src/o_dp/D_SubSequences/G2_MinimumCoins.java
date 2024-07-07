package o_dp.D_SubSequences;

import java.util.Arrays;

public class G2_MinimumCoins {

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;

        int [][] dp = new int[coins.length][amount+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }


        G2_MinimumCoins solution = new G2_MinimumCoins();
        System.out.println("Minimum coins using recursion : "+solution.coinChange(coins,amount,coins.length-1));
        System.out.println("Minimum coins using Memoization : "+solution.coinChangeMemoization(coins,amount,coins.length-1,dp));
        System.out.println("Minimum coins using tabulation : "+solution.coinChangeTabulation(coins,amount));
        System.out.println("Minimum coins using space optimization : "+solution.coinChangeTabulationSpaceOptimization(coins,amount));


        /*
        *
        * Minimum coins using recursion : 3
            Minimum coins using Memoization : 3
            Minimum coins using tabulation : 3
            Minimum coins using space optimization : 3
        * */

    }

    public int coinChange(int[] coins, int amount, int index) {
            if(index == 0){
                if(amount % coins[0] == 0){
                    return amount/coins[0];
                }
                return (int)1e9;
            }

            int notTake = coinChange(coins,amount, index-1);
            int take = (int) 1e9;

            if(coins[index] <= amount)
                take = 1+coinChange(coins, amount-coins[index], index);


            return Math.min(notTake, take);
    }

    public int coinChangeMemoization(int[] coins, int amount, int index, int [][] dp) {
        if(index == 0){
            if(amount % coins[0] == 0){
                return amount/coins[0];
            }
            return (int)1e9;
        }

        if(dp[index][amount] != -1)
            return dp[index][amount];

        int notTake = coinChangeMemoization(coins,amount, index-1,dp);
        int take = (int) 1e9;

        if(coins[index] <= amount)
            take = 1+coinChangeMemoization(coins, amount-coins[index], index,dp);

        dp[index][amount] = Math.min(notTake, take);
        return Math.min(notTake, take);
    }

    public int coinChangeTabulation(int[] coins, int amount) {

        int n = coins.length;
        int [][] dp = new int[n][amount+1];

        for (int i = 0; i <= amount ; i++) {
            if(i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int) 1e9;
        }



        for (int index = 1; index < n; index++) {
            for (int amo = 0; amo <= amount ; amo++) {
                int notTake = dp[index-1][amo];
                int take = (int) 1e9;

                if(coins[index] <= amo)
                    take = 1+dp[index][amo-coins[index]];

                dp[index][amo] = Math.min(notTake, take);
            }
        }

       return dp[n-1][amount];
    }


    public int coinChangeTabulationSpaceOptimization(int[] coins, int amount) {

        int n = coins.length;
        int [] prev  = new int[amount+1];

        for (int i = 0; i <= amount ; i++) {
            if(i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int) 1e9;
        }

        for (int index = 1; index < n; index++) {
            int [] curr  = new int[amount+1];
            for (int amo = 0; amo <= amount ; amo++) {
                int notTake = prev[amo];
                int take = (int) 1e9;

                if(coins[index] <= amo)
                    take = 1+curr[amo-coins[index]];

                curr[amo] = Math.min(notTake, take);
            }
            prev = curr;
        }

        return prev[amount];
    }

}
