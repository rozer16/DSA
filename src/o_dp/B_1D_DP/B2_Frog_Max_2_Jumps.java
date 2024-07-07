package o_dp.B_1D_DP;

import java.util.Arrays;

public class B2_Frog_Max_2_Jumps {

    public static void main(String[] args) {
        int height[]={30,10,60 , 10 , 60 , 50};
        B2_Frog_Max_2_Jumps solution = new B2_Frog_Max_2_Jumps();
        System.out.println("Using recursion, cost is : "+solution.getMinCostRecrusive(height)); //40
        System.out.println("Using Memoization, cost is : "+solution.getMinCostMemoization(height)); //40
        System.out.println("Using Tabulation, cost is : "+solution.getMinCostTabulation(height));
        System.out.println("Using Tabulation Space Optimization, cost is : "+solution.getMinCostTabulationWithSpaceOptimized(height));
    }
    public int getMinCostRecrusive(int [] hegiths){
        return getMinCostRecrusive(hegiths,hegiths.length-1);
    }

    public int getMinCostRecrusive(int [] hegiths,int index){
        if(index == 0)
            return 0;
        int n = hegiths.length;
        int jumpOneStep = getMinCostRecrusive(hegiths, index-1) + Math.abs(hegiths[index]-hegiths[index-1]);

        int jumpTwoSteps = Integer.MAX_VALUE;

        if(index > 1)
            jumpTwoSteps = getMinCostRecrusive(hegiths,index-2) + Math.abs(hegiths[index]-hegiths[index-2]);


        return Math.min(jumpOneStep,jumpTwoSteps);
    }


    public int getMinCostMemoization(int [] hegiths){
        int [] dp = new int[hegiths.length];
        Arrays.fill(dp,-1);
        return getMinCostMemoization(hegiths,hegiths.length-1,dp);
    }

    //Time Complexity: O(N)
    //Reason: The overlapping subproblems will return the answer in constant time O(1).
    // Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).

    //Space Complexity: O(N)
    //Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
    // Therefore total space complexity will be O(N) + O(N) ≈ O(N)
    public int getMinCostMemoization(int [] hegiths,int index,int [] dp) {
        if (index == 0)
            return 0;
        int n = hegiths.length;
        if (dp[index] != -1)
            return dp[index - 1];
        int jumpOneStep = getMinCostRecrusive(hegiths, index - 1) + Math.abs(hegiths[index] - hegiths[index - 1]);

        int jumpTwoSteps = Integer.MAX_VALUE;

        if (index > 1)
            jumpTwoSteps = getMinCostRecrusive(hegiths, index - 2) + Math.abs(hegiths[index] - hegiths[index - 2]);


        return Math.min(jumpOneStep, jumpTwoSteps);
    }

    public int getMinCostTabulation(int height []){
        int [] dp =  new int[height.length];
        dp[0] = 0;

        for (int i = 1; i < height.length; i++) {
            int jump1 = Math.abs(height[i]-height[i-1]) + dp[i-1];
            int jump2 = Integer.MAX_VALUE;
            if(i>1)
                jump2 = Math.abs(height[i]-height[i-2])+dp[i-2];

            dp[i] = Math.min(jump1,jump2);
        }

        return dp[height.length-1];
    }


    public int getMinCostTabulationWithSpaceOptimized(int height []){

        int prev1 = 0;
        int prev2 = 0;

        for (int i = 1; i < height.length; i++) {
            int jump1 = Math.abs(height[i]-height[i-1]) + prev1;
            int jump2 = Integer.MAX_VALUE;
            if(i>1)
                jump2 = Math.abs(height[i]-height[i-2])+prev2;

           int currI = Math.min(jump1,jump2);
           prev2 = prev1;
           prev1 = currI;
        }

        return prev1;
    }
}
