package n_dp.D_SubSequences;

import java.util.Arrays;

public class K2_RodCuttingProblem {
    public static void main(String[] args) {
        int [] price =  { 3, 5, 6, 7, 10, 12 };
        int rodLength = 6;

        int [][] dp = new int[price.length][rodLength+1];
        for (int i = 0; i < price.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        K2_RodCuttingProblem solution = new K2_RodCuttingProblem();
       /* System.out.println("Max Price we get from rod using recursion "+solution.getMaxPriceFromRod(price.length-1,rodLength, price));
        System.out.println("Max Price we get from rod using memoization "+solution.getMaxPriceFromRodMemoization(price.length-1,rodLength, price,dp));
        System.out.println("Max Price we get from rod using tabulation "+solution.getMaxPriceFromRodTabulation(rodLength, price));
        System.out.println("Max Price we get from rod using space optimization "+solution.getMaxPriceFromRodSpaceOptimization(rodLength, price));
        System.out.println("Max Price we get from rod using space optimization1 "+solution.getMaxPriceFromRodSpaceOptimization1(rodLength, price));

*/
        int [] price1 =  {  25, 79, 59, 63, 65, 6, 46, 82 };
        int rodLength1 = 8;

        int [][] dp1 = new int[price1.length][rodLength1+1];
        for (int i = 0; i < price1.length; i++) {
            Arrays.fill(dp1[i], -1);
        }

        System.out.println("============");
        System.out.println("Max Price we get from rod using recursion "+solution.getMaxPriceFromRod(price1.length-1,rodLength1, price1));
        System.out.println("Max Price we get from rod using memoization "+solution.getMaxPriceFromRodMemoization(price1.length-1,rodLength1, price1,dp1));
        System.out.println("Max Price we get from rod using tabulation "+solution.getMaxPriceFromRodTabulation(rodLength1, price1));
        System.out.println("Max Price we get from rod using space optimization "+solution.getMaxPriceFromRodSpaceOptimization(rodLength1, price1));
        System.out.println("Max Price we get from rod using space optimization1 "+solution.getMaxPriceFromRodSpaceOptimization1(rodLength1, price1));

    }

    public int getMaxPriceFromRod(int index,int rodLength , int [] price){

        if(index == 0){
            return price[0]*rodLength;
        }

        int notTake = getMaxPriceFromRod(index-1,rodLength,price);
        int take = Integer.MIN_VALUE;

        int nextRodLength = index+1;
        if(rodLength >= nextRodLength)
            take = price[index]+ getMaxPriceFromRod(index, rodLength-nextRodLength,price);


        return Math.max(take, notTake);
    }

    public int getMaxPriceFromRodMemoization(int index,int rodLength , int [] price, int [][] dp){

        if(index == 0){
            return price[0]*rodLength;
        }

        if(dp[index][rodLength] != -1)
                return dp[index][rodLength];


        int notTake = getMaxPriceFromRodMemoization(index-1,rodLength,price,dp);
        int take = Integer.MIN_VALUE;

        int nextRodLength = index+1;
        if(rodLength >= nextRodLength)
            take = price[index]+ getMaxPriceFromRodMemoization(index, rodLength-nextRodLength,price,dp);


        dp[index][rodLength] = Math.max(take, notTake);

        return Math.max(take, notTake);
    }

    public int getMaxPriceFromRodTabulation(int n , int [] price){

        int [][] dp = new int[price.length][n+1];

        for (int N = 0; N <= n; N++) {
            dp[0][N] = price[0]*N;
        }

        for (int ind = 1; ind < n ; ind++) {
            for (int N = 0; N <= n; N++) {
                int notTake = dp[ind-1][N];
                int take = Integer.MIN_VALUE;

                int nextRodLength = ind+1;
                if(nextRodLength <= N )
                    take = price[ind]+ dp[ind][N-nextRodLength];


                dp[ind][N] = Math.max(take, notTake);
            }
        }
        return dp[price.length-1][n];
    }


    public int getMaxPriceFromRodSpaceOptimization(int rodLength , int [] price){

        int []prev = new int[rodLength+1];

        for (int rodLen = 0; rodLen <= rodLength; rodLen++) {
            prev[rodLen] = price[0]*rodLen;
        }

        for (int index = 1; index < price.length; index++) {
            int []curr = new int[rodLength+1];
            for (int rl = 0; rl <= rodLength; rl++) {
                int notTake = prev[rl];
                int take = Integer.MIN_VALUE;

                int nextRodLength = index+1;
                if(rl >= nextRodLength)
                    take = price[index]+ curr[rl-nextRodLength];


                curr[rl] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[rodLength];
    }

        public int getMaxPriceFromRodSpaceOptimization1(int rodLength , int [] price){

        int []prev = new int[rodLength+1];

        for (int rodLen = 0; rodLen <= rodLength; rodLen++) {
            prev[rodLen] = price[0]*rodLen;
        }

        for (int index = 1; index < price.length; index++) {

            for (int rl = 0; rl <= rodLength; rl++) {
                int notTake = prev[rl];
                int take = Integer.MIN_VALUE;

                int nextRodLength = index+1;
                if(rl >= nextRodLength)
                    take = price[index]+ prev[rl-nextRodLength];


                prev[rl] = Math.max(take, notTake);
            }

        }
        return prev[rodLength];
    }
}
