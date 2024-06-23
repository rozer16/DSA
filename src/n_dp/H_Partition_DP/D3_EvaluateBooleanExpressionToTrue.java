package n_dp.H_Partition_DP;

import java.util.Arrays;

public class D3_EvaluateBooleanExpressionToTrue {

    static final int MOD = 1000000007;

    public static void main(String[] args) {
        String expr = "F|T^F";
        D3_EvaluateBooleanExpressionToTrue solution = new D3_EvaluateBooleanExpressionToTrue();
        System.out.println("No of ways we can convert expression to true " + solution.evaluateBooleanExpressionToTrue(0, expr.length() - 1, 1, expr));

        int n = expr.length();
        int[][][] dp = new int[n + 1][n + 1][2];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println("No of ways we can convert expression to true using memoization " + solution.evaluateBooleanExpressionToTrueMemoization(0, expr.length() - 1, 1, expr, dp));
        System.out.println("No of ways we can convert expression to true using tabulation " + solution.evaluateBooleanExpressionToTrueTabulation(expr));
    }

    private long evaluateBooleanExpressionToTrue(int left, int right, int isTrue, String expr) {
        if (left > right)
            return 0;

        if (left == right) {
            if (isTrue == 1)
                return expr.charAt(left) == 'T' ? 1 : 0;
            else
                return expr.charAt(left) == 'F' ? 1 : 0;
        }


        long ways = 0;

        for (int index = left + 1; index < right; index = index + 2) {
            long lT = evaluateBooleanExpressionToTrue(left, index - 1, 1, expr);
            long lF = evaluateBooleanExpressionToTrue(left, index - 1, 0, expr);
            long rT = evaluateBooleanExpressionToTrue(index + 1, right, 1, expr);
            long rF = evaluateBooleanExpressionToTrue(index + 1, right, 0, expr);


            char operator = expr.charAt(index);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways +
                            (lF * rT) % MOD
                            + (lT * rF) % MOD
                            + (lF * rF) % MOD

                    ) % MOD;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rF) % MOD + (lF * rT) % MOD + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways
                            + (lF * rF) % MOD
                    ) % MOD;
                }
            } else if (operator == '^') {
                if (isTrue == 1) {
                    ways = (ways
                            + (lT * rF) % MOD
                            + (lF * rT) % MOD
                    ) % MOD;
                } else {
                    ways = (ways
                            + (lT * rT) % MOD
                            + (lF * rF) % MOD
                    ) % MOD;
                }
            }
        }


        return ways;
    }


    private long evaluateBooleanExpressionToTrueMemoization(int left, int right, int isTrue, String expr, int dp[][][]) {
        if (left > right)
            return 0;

        if (left == right) {
            if (isTrue == 1)
                return expr.charAt(left) == 'T' ? 1 : 0;
            else
                return expr.charAt(left) == 'F' ? 1 : 0;
        }

        if (dp[left][right][isTrue] != -1)
            return dp[left][right][isTrue];

        long ways = 0;

        for (int index = left + 1; index < right; index = index + 2) {
            long lT = evaluateBooleanExpressionToTrue(left, index - 1, 1, expr);
            long lF = evaluateBooleanExpressionToTrue(left, index - 1, 0, expr);
            long rT = evaluateBooleanExpressionToTrue(index + 1, right, 1, expr);
            long rF = evaluateBooleanExpressionToTrue(index + 1, right, 0, expr);


            char operator = expr.charAt(index);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways +
                            (lF * rT) % MOD
                            + (lT * rF) % MOD
                            + (lF * rF) % MOD

                    ) % MOD;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rF) % MOD + (lF * rT) % MOD + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways
                            + (lF * rF) % MOD
                    ) % MOD;
                }
            } else if (operator == '^') {
                if (isTrue == 1) {
                    ways = (ways
                            + (lT * rF) % MOD
                            + (lF * rT) % MOD
                    ) % MOD;
                } else {
                    ways = (ways
                            + (lT * rT) % MOD
                            + (lF * rF) % MOD
                    ) % MOD;
                }
            }
        }


        dp[left][right][isTrue] = (int) ways;
        return ways;
    }


    private long evaluateBooleanExpressionToTrueTabulation(String expr) {
        int n = expr.length();

        int dp[][][] = new int[n + 1][n + 1][2];

        for (int left = n - 1; left >= 0; left--) {
            for (int right = 0; right <= n - 1; right++) {

                if (left > right)
                    continue;

                if (left == right) {
                    dp[left][right][0] = expr.charAt(left) == 'F' ? 1 : 0;
                    dp[left][right][1] = expr.charAt(left) == 'T' ? 1 : 0;
                }


                long ways = 0;

                for (int index = left + 1; index < right; index = index + 2) {
                    long lT = dp[left] [index - 1] [1];
                    long lF = dp[left] [index - 1][0];
                    long rT = dp[index + 1] [right][1];
                    long rF = dp[index + 1] [right][0];


                    char operator = expr.charAt(index);
                    if (operator == '&') {
                        dp[left][right][1] = (int) ( dp[left][right][1] +  (lT * rT) % MOD)%MOD;
                        dp[left][right][0] = (int) ( dp[left][right][0] + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD)%MOD;
                    } else if (operator == '|') {
                        dp[left][right][1] = (int) (dp[left][right][1] +  (lT * rF) % MOD + (lF * rT) % MOD + (lT * rT) % MOD) % MOD;
                        dp[left][right][0] = (int) (dp[left][right][0] + (lF * rF) % MOD)%MOD;
                    } else if (operator == '^') {
                        dp[left][right][1] = (int) (dp[left][right][1] + (lT * rF) % MOD + (lF * rT) % MOD) % MOD;
                        dp[left][right][0] = (int) (dp[left][right][0] + (lT * rT) % MOD + (lF * rF) % MOD) % MOD;
                    }
                }


            } //right end
        }// left end


        return dp[0][n-1][1] ;

    }


}
