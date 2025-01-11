package o_dp.D_SubSequences;

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
        //System.out.println("Max robbery done using recusion: "+solution.knapsack(N-1,W,wt,val,dp));
        System.out.println("Max robbery done using memoization : "+solution.knapsackRecursion(N-1,W,wt,val,dp));
        System.out.println("Max robbery done using tabulation : "+solution.knapsackTabulation(wt,val,N,W));
        System.out.println("Max robbery done using space optimization : "+solution.knapsackSpaceOpt(wt,val,N,W));
        System.out.println("Max robbery done using space optimization with single row array: "+solution.knapsackSpaceOptimization1(W,wt,val));


        /*
        Max robbery done using recusion: 13
        Max robbery done using memoization : 13
        Max robbery done using tabulation : 13
        Max robbery done using space optimization : 13
        Max robbery done using space optimization with single row array: 13

        * */
    }


     int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given tree itself.
         * No need to return or print the output.
         * Taking input and printing output is handled automatically.
         */

        //return knapsackRecursion(value.length-1, maxWeight, weight, value);
        return knapsackTabulation(weight, value,n, maxWeight);


    }

    int knapsackSpaceOpt(int[] weight, int[] value, int n, int bagCapacity) {
         /*
        if(index == weight.length-1){
            System.out.println("Running  with bagCapacity : "+bagCapacity+";;;;");
            System.out.println(Arrays.toString(weight));
            System.out.println(Arrays.toString(value));

        }

        */
        //int n = weight.length;
        int [] prev = new int[bagCapacity+1];

        for(int i = 0; i<= bagCapacity; i++){
            if(weight[0] <= i){
                prev[i] = value[0];
            }
        }

        for(int index = 1; index<n; index++){
            int [] curr = new int[bagCapacity+1];
            for(int bagCap = 0; bagCap <= bagCapacity; bagCap++){
                int notTake = prev[bagCap];
                int take = Integer.MIN_VALUE;

                if(bagCap >= weight[index])
                    take = value[index] + prev[ bagCap-weight[index]];

                curr[bagCap] =  Math.max(notTake, take);
            }
            prev = curr;
        }

        return prev[bagCapacity];

    }


     int knapsackTabulation(int[] weight, int[] value, int n, int bagCapacity) {
         /*
        if(index == weight.length-1){
            System.out.println("Running  with bagCapacity : "+bagCapacity+";;;;");
            System.out.println(Arrays.toString(weight));
            System.out.println(Arrays.toString(value));

        }

        */
        //int n = weight.length;
        int [][] dp = new int[n][bagCapacity+1];

        for(int i = 0; i<= bagCapacity; i++){
            if(weight[0] <= i){
                dp[0][i] = value[0];
            }
        }

        for(int index = 1; index<n; index++){
            for(int bagCap = 0; bagCap <= bagCapacity; bagCap++){
                int notTake = dp[index-1][bagCap];
                int take = Integer.MIN_VALUE;

                if(bagCap >= weight[index])
                    take = value[index] + dp[index-1][ bagCap-weight[index]];

                dp[index][bagCap] =  Math.max(notTake, take);
            }
        }

        return dp[n-1][bagCapacity];

    }


     int knapsackRecursion(int index, int bagCapacity,int[] weight, int[] value, int [][] dp) {
         /*
        if(index == weight.length-1){
            System.out.println("Running  with bagCapacity : "+bagCapacity+";;;;");
            System.out.println(Arrays.toString(weight));
            System.out.println(Arrays.toString(value));

        }

        */
        if(bagCapacity == 0)
            return 0;

        if(index == 0){
            if(bagCapacity >= weight[0]){
                return value[0];
            }else{
                return 0;
            }
        }

        if(dp[index][bagCapacity] != -1)
            return dp[index][bagCapacity];
        int notTake = knapsackRecursion(index-1, bagCapacity, weight, value,dp);
        int take = Integer.MIN_VALUE;

        if(bagCapacity >= weight[index])
            take = value[index] + knapsackRecursion(index-1, bagCapacity-weight[index], weight, value,dp);

        dp[index][bagCapacity] = Math.max(notTake, take);
        return Math.max(notTake, take);
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
