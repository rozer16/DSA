package n_dynamic_programming.B_1D_DP;


import java.util.Arrays;

/*
https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

Given an array coins[] of size N and a target value V, where coins[i] represents the coins of different denominations. You have an infinite supply of each of coins. The task is to find minimum number of coins required to make the given value V. If it’s not possible to make a change, print -1.

Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required We can use one coin of 6 cents and 1 coin of 5 cents



* */
public class D2_Minimum_No_Of_Coins {

    public static void main(String args[])
    {
        int coins[] =  {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        D2_Minimum_No_Of_Coins sol = new D2_Minimum_No_Of_Coins();
        System.out.println("Minimum coins required is "+ sol.minCoins(coins, m, V) );
    }
    public int minCoins(int coins[], int m, int V)
    {
        // base case
        if (V == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++)
        {
            if (coins[i] <= V)
            {
                int sub_res = minCoins(coins, m, V-coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }


    // Function to find the minimum number of coins needed
    // to make a target value
    public int minCoinsMameization(int[] coins, int m, int V)
    {
        // Create a DP table to store results of subproblems
        int[] dp = new int[V + 1];
        Arrays.fill(dp, -1); // Initialize DP table with -1

        // Call the utility function to solve the problem
        return minCoinsUtil(coins, m, V, dp);
    }

    public static int minCoinsUtil(int[] coins, int m,
                                   int V, int[] dp)
    {
        // Base case: If target value V is 0, no coins are
        // needed
        if (V == 0)
            return 0;

        // If subproblem is already solved, return the
        // result from DP table
        if (dp[V] != -1)
            return dp[V];

        int res = Integer.MAX_VALUE;

        // Iterate over all coins and recursively solve for
        // subproblems
        for (int i = 0; i < m; i++) {
            if (coins[i] <= V) {
                // Recursive call to solve for remaining
                // value V - coins[i]
                int sub_res = minCoinsUtil(
                        coins, m, V - coins[i], dp);

                // If the subproblem has a valid solution
                // and the total number of coins is smaller
                // than the current result, update the
                // result
                if (sub_res != Integer.MAX_VALUE
                        && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }

        // Save the result in the DP table
        dp[V] = res;

        return res;
    }
    int minCoinsTabulation(int coins[], int m, int V)
    {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[V + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i)
                {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;


                }

        }

        if(table[V]==Integer.MAX_VALUE)
            return -1;

        return table[V];

    }




}
