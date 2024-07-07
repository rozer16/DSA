package o_dp.H_Partition_DP;

import java.util.Arrays;

public class A4_MatrixChainMultiplication {


    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        A4_MatrixChainMultiplication solution = new A4_MatrixChainMultiplication();
        System.out.println("Recursion : " +solution.getMinNoOfOperationRequired(1, arr.length - 1, arr));

        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("Memoization: "+solution.getMinNoOfOperationRequiredMemoization(1, arr.length - 1, arr, dp));
        System.out.println("Tabulation: "+solution.getMinNoOfOperationRequiredTabulation(arr));

    }


    public int getMinNoOfOperationRequired(int left, int right, int[] arr) {
        if (left == right)
            return 0;

        int min = (int) 1e9;

        for (int k = left; k <= right - 1; k++) {
            int steps = getMinNoOfOperationRequired(left, k, arr)
                    + getMinNoOfOperationRequired(k + 1, right, arr)
                    + (arr[left - 1] * arr[k] * arr[right]);
            min = Math.min(min, steps);
        }

        return min;
    }

    public int getMinNoOfOperationRequiredMemoization(int left, int right, int[] arr, int[][] dp) {
        if (left == right)
            return 0;

        if (dp[left][right] != -1)
            return dp[left][right];

        int min = Integer.MAX_VALUE;

        for (int k = left; k <= right - 1; k++) {
            int steps = getMinNoOfOperationRequiredMemoization(left, k, arr, dp)
                    + getMinNoOfOperationRequiredMemoization(k + 1, right, arr, dp)
                    + (arr[left - 1] * arr[k] * arr[right]);

            dp[left][right] = Math.min(steps, min);
            min = dp[left][right] ;
        }

        return dp[left][right];
    }


    public int getMinNoOfOperationRequiredTabulation(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];



        for (int left = n-1; left >=1 ; left--) {
            for (int right = left+1; right < n ; right++) {
                for (int k = left; k <= right - 1; k++) {
                    int min = Integer.MAX_VALUE;
                    int steps = dp[left][ k]
                            + dp[k + 1] [right]
                            + (arr[left - 1] * arr[k] * arr[right]);


                    min = Math.min(steps, min);
                    dp[left][right] = min;
                }
            }
        }


        return dp[1][n-1];
    }
}
