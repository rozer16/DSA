package n_dynamic_programming.D_SubSequences;

import java.util.Arrays;

public class F2_Knapsack {

    public static void main(String[] args) {
        int N = 4;
        int W = 5;//(A bag can have max W= 5)

        int [] wt = {1,2,4,5};
        int [] val = {5,4,8,6};

        int [][] dp = new int[N][W+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        F2_Knapsack solution = new F2_Knapsack();
        System.out.println("Max robbery done using recusion: "+solution.knapsack(N-1,W,wt,val));
        System.out.println("Max robbery done using memoization : "+solution.knapsackMemoization(N-1,W,wt,val,dp));
        System.out.println("Max robbery done using tabulation : "+solution.knapsackTabulation(W,wt,val));
        System.out.println("Max robbery done using space optimization : "+solution.knapsackSpaceOptimization(W,wt,val));
        System.out.println("Max robbery done using space optimization with single row array: "+solution.knapsackSpaceOptimization1(W,wt,val));


        /*
        Max robbery done using recusion: 13
        Max robbery done using memoization : 13
        Max robbery done using tabulation : 13
        Max robbery done using space optimization : 13
        Max robbery done using space optimization with single row array: 13

        * */
    }


    public int knapsack(int index, int W,int [] wt, int [] val ){
        if(index == 0){
            if(wt[0] <= W)
                return val[0];

            return 0;
        }


        int notPick = knapsack(index-1,W,wt,val );
        int pick = Integer.MIN_VALUE;
        if(wt[index] <= W)
            pick = val[index]+ knapsack(index-1,W-wt[index],wt,val);


        return Math.max(pick,notPick);
    }

    public int knapsackMemoization(int index, int W,int [] wt, int [] val , int [][] dp){
        if(index == 0){
            if(wt[0] <= W)
                return val[0];

            return 0;
        }


        if(dp[index][W] != -1)
            return dp[index][W];

        int notPick = knapsack(index-1,W,wt,val );
        int pick = Integer.MIN_VALUE;
        if(wt[index] <= W)
            pick = val[index]+ knapsack(index-1,W-wt[index],wt,val);


        dp[index][W] = Math.max(pick,notPick);
        return Math.max(pick,notPick);
    }


    public int knapsackTabulation( int W,int [] wt, int [] val ){

        int n = wt.length;
        int [][] dp = new int[n][W+1];

        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int index = 1; index < n; index++) {
            for (int W1 = 0; W1 <= W ; W1++) {
                int notPick = dp[index-1][W1];
                int pick = Integer.MIN_VALUE;
                if(wt[index] <= W1)
                    pick = val[index]+ dp[index-1][W1-wt[index]];

                dp[index][W1] = Math.max(pick,notPick);
            }
        }

        return dp[n-1][W];
    }

    public int knapsackSpaceOptimization( int W,int [] wt, int [] val ){

        int n = wt.length;
        int [] prev = new int[W+1];

        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        for (int index = 1; index < n; index++) {
            int [] curr = new int[W+1];
            for (int W1 = 0; W1 <= W ; W1++) {
                int notPick = prev[W1];
                int pick = Integer.MIN_VALUE;
                if(wt[index] <= W1)
                    pick = val[index]+ prev[W1-wt[index]];

                curr[W1] = Math.max(pick,notPick);
            }
            prev = curr;
        }

        return prev[W];
    }

    public int knapsackSpaceOptimization1( int W,int [] wt, int [] val ){

        int n = wt.length;
        int [] prev = new int[W+1];

        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        for (int index = 1; index < n; index++) {

            for (int W1 = W; W1 >= 0 ; W1--) {
                int notPick = prev[W1];
                int pick = Integer.MIN_VALUE;
                if(wt[index] <= W1)
                    pick = val[index]+ prev[W1-wt[index]];

                prev[W1] = Math.max(pick,notPick);
            }
        }

        return prev[W];
    }
}
