package n_dp.B_1D_DP;

import java.util.Arrays;

public class B4_Frog_K_Jumps {

    public static void main(String[] args) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 2;

        B4_Frog_K_Jumps solution= new B4_Frog_K_Jumps();
        System.out.println("Min cost with max k jumps with memoization : "+solution.calculateMinCostWithKJumpsMemoization(0,height,k));
        System.out.println("Min cost with max k jumps with tabulation : "+solution.calculateMinCostWithKJumpsTabulation(height,k));

    }




    public int calculateMinCostWithKJumpsMemoization(int index, int height [], int k){
        int [] dp = new int[height.length];
        Arrays.fill(dp,-1);
        return calculateMinCostWithKJumpsMemoization(height.length-1,height,dp,k);
    }

    //Time Complexity: O(N *K)
    //Reason: The overlapping subproblems will return the answer in constant time.
    // Therefore the total number of new subproblems we solve is ‘n’.
    // At every new subproblem, we are running another loop for K times. Hence, total time complexity is O(N * K).

    //Space Complexity: O(N)

    //Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
    // Therefore total space complexity will be O(N) + O(N) ≈ O(N)

    public int calculateMinCostWithKJumpsMemoization(int ind, int[] height, int[] dp, int k) {
        // Base case: If we are at the beginning (index 0), no cost is needed since reaching from 0 to 0.
        if (ind == 0)
            return 0;

        // If the result for this index has been previously calculated, return it.
        if (dp[ind] != -1)
            return dp[ind];

        int mmSteps = Integer.MAX_VALUE;

        // Loop to try all possible jumps from '1' to 'k'
        for (int j = 1; j <= k; j++) {
            // Ensure that we do not jump beyond the beginning of the array
            if (ind - j >= 0) {
                // Calculate the cost for this jump and update mmSteps with the minimum cost
                int jump = calculateMinCostWithKJumpsMemoization(ind - j, height, dp, k) + Math.abs(height[ind] - height[ind - j]);
                mmSteps = Math.min(jump, mmSteps);
            }
        }

        return dp[ind] = mmSteps;
    }


     public int calculateMinCostWithKJumpsTabulation(int[] height, int k) {
        int dp[] = new int[height.length];
        Arrays.fill(dp, -1);

        int n = height.length;
        dp[0] = 0;

        // Loop through the array to fill in the dp array
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            // Loop to try all possible jumps from '1' to 'k'
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1]; // The result is stored in the last element of dp
    }

}
