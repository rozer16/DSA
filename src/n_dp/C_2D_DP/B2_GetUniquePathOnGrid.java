package n_dp.C_2D_DP;

import java.util.Arrays;

public class B2_GetUniquePathOnGrid {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;


        B2_GetUniquePathOnGrid solution = new B2_GetUniquePathOnGrid();
        System.out.println("Unique ways to go from (0,0) to (m,n) Using recrusion: " + solution.getUniquePathOnGridRecursive(m - 1, n - 1));
        System.out.println("Unique ways to go from (0,0) to (m,n) Using memoization: " + solution.getUniquePathOnGridMemoization(m - 1, n - 1));
        System.out.println("Unique ways to go from (0,0) to (m,n) Using tabulation: " + solution.getUniquePathOnGridTabulation(m, n));
        System.out.println("Unique ways to go from (0,0) to (m,n) Using space optimazation: " + solution.getUniquePathOnGridTabulation(m, n));
        System.out.println("Unique ways to go from (0,0) to (m,n) Using Combination formula: " + solution.getUniquePathOnGridUsingCombination(m, n));

    }


    public int getUniquePathOnGridRecursive(int m, int n) {
        if (m == 0 && n == 0)
            return 1;

        if (m < 0 || n < 0)
            return 0;


        int top = getUniquePathOnGridRecursive(m - 1, n);
        int left = getUniquePathOnGridRecursive(m, n - 1);

        return top + left;
    }


    public int getUniquePathOnGridMemoization(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getUniquePathOnGridMemoization(m, n, dp);
    }

    public int getUniquePathOnGridMemoization(int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return 1;

        if (m < 0 || n < 0)
            return 0;

        if (dp[m - 1][n - 1] != -1)
            return dp[m][n];

        int top = getUniquePathOnGridRecursive(m - 1, n);
        int left = getUniquePathOnGridRecursive(m, n - 1);

        dp[m - 1][n - 1] = top + left;
        return top + left;
    }


    public int getUniquePathOnGridTabulation(int m, int n) {
        int dp[][] = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }

                int top = 0;
                int left = 0;
                if (i > 0)
                    top = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = top + left;
            }
        }

        return dp[m - 1][n - 1];
    }


    public int getUniquePathOnGridSpaceOptimazation(int m, int n) {
        int[] prev = new int[m];
        for (int i = 0; i < m; i++) {
            int curr[] = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[0] = 1;
                    continue;
                }

                int top = 0, left = 0;
                if (i > 0)
                    top = prev[j];

                if (j > 0)
                    left = curr[j - 1];

                curr[j] = top + left;
            }
            prev = curr;

        }

        return prev[n - 1];
    }


    public int getUniquePathOnGridUsingCombination(int m, int n) {
        int N = m+n-2;
        int C = m < n ? n-1 : m-1;

        double result = 1;
        for (int i = 1; i <= C; i++) {
            result = result*(N-C+i)/i;
        }


        return (int)result;

    }
}