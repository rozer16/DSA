package n_dynamic_programming.D_SubSequences;

import java.util.Arrays;

public class J2_UnboundedKnapsack {

    public static void main(String[] args) {
        int [] wt = {2,4,6};
        int [] val = {5,11,13};
        int W = 10;

        int [][] dp = new int[wt.length][W+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        J2_UnboundedKnapsack solution = new J2_UnboundedKnapsack();
        System.out.println("Maximum items thief can take using recursion : "+solution.unboundedKnapsackRecursion(wt.length-1,W,wt,val));
        System.out.println("Maximum items thief can take using memoization : "+solution.unboundedKnapsackMemoization(wt.length-1,W,wt,val,dp));
        System.out.println("Maximum items thief can take using tabulation : "+solution.unboundedKnapsackTabulation(W,wt,val));
        System.out.println("Maximum items thief can take using space optimization : "+solution.unboundedKnapsackSpaceOptimization(W,wt,val));
        System.out.println("Maximum items thief can take using space optimization1 : "+solution.unboundedKnapsackSpaceOptimization1(W,wt,val));
    }


    public int unboundedKnapsackRecursion(int index, int W, int [] wt, int[] val){

        if(index == 0){
            if(W != 0 && wt[0] % W == 0){
                return (wt[0] / W)*val[0];
            }
            return 0;
        }

        int notTake = unboundedKnapsackRecursion(index-1, W,wt,val);
        int take = Integer.MIN_VALUE;

        if(wt[index] <= W){
            take = val[index]+ unboundedKnapsackRecursion(index, W-wt[index],wt,val);
        }

        return Math.max(notTake,take);
    }

    public int unboundedKnapsackMemoization(int index, int W, int [] wt, int[] val, int [][] dp){

        if(index == 0){

            //Since thief can take any items unbouded he will try to pick as much as possible based on pending weight
            //e.g. bad has 10 kg pending and wt[0] = 3, he will pick 3 same items of wt[0]

            return (W/wt[0])*val[0];


        }

        if(dp[index][W] != -1)
            return dp[index][W];

        int notTake = unboundedKnapsackRecursion(index-1, W,wt,val);
        int take = Integer.MIN_VALUE;

        if(wt[index] <= W){
            take = val[index]+ unboundedKnapsackRecursion(index, W-wt[index],wt,val);
        }

        dp[index][W] = Math.max(notTake,take);

        return Math.max(notTake,take);
    }

    public int unboundedKnapsackTabulation(int W, int [] wt, int[] val ){

        int [][] dp = new int[wt.length][W+1];
        for (int W1 = 0; W1 <= W ; W1++) {
                dp[0][W1] = (W1/wt[0])*val[0];
        }

        for (int index = 1; index < wt.length; index++) {
            for (int weight = 1; weight <= W ; weight++) {
                int notTake = dp[index-1][weight];
                int take = Integer.MIN_VALUE;

                if(wt[index] <= weight){
                    take = val[index]+ dp[index][weight-wt[index]];
                }

                dp[index][weight] = Math.max(notTake,take);
            }
        }


        return dp[wt.length-1][W];

    }

    public int unboundedKnapsackSpaceOptimization(int W, int [] wt, int[] val ){

        int [] prev = new int[W+1];
        for (int W1 = 0; W1 <= W ; W1++) {
            prev[W1] = (W1/wt[0])*val[0];
        }

        for (int index = 1; index < wt.length; index++) {
            int [] curr = new int[W+1];
            for (int weight = 1; weight <= W ; weight++) {
                int notTake = prev[weight];
                int take = Integer.MIN_VALUE;

                if(wt[index] <= weight){
                    take = val[index]+ curr[weight-wt[index]];
                }

                curr[weight] = Math.max(notTake,take);
            }
            prev  = curr;
        }


        return prev[W];

    }

    public int unboundedKnapsackSpaceOptimization1(int W, int [] wt, int[] val ){

        int [] prev = new int[W+1];
        for (int W1 = 0; W1 <= W ; W1++) {
            prev[W1] = (W1/wt[0])*val[0];
        }

        for (int index = 1; index < wt.length; index++) {
            for (int weight = 1; weight <= W ; weight++) {
                int notTake = prev[weight];
                int take = Integer.MIN_VALUE;

                if(wt[index] <= weight){
                    take = val[index]+ prev[weight-wt[index]];
                }

                prev[weight] = Math.max(notTake,take);
            }

        }


        return prev[W];

    }
}
