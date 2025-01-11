package o_dp.C_2D_DP;

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
        System.out.println("Unique ways to go from (0,0) to (m,n) Using Combination formula: " + solution.findNcR(m, n));

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


    /*
    The problem can be visualized as finding the number of unique permutations of a sequence of moves:
	•	To get from the top-left corner to the bottom-right corner of the grid, the robot needs to make m-1 down moves and n-1 right moves.
	•	This is a classic combinatorics problem, where the total number of unique paths is the number of ways to arrange m-1 “down” moves
        and n-1 “right” moves in a sequence of m+n-2 moves.

        The formula to calculate this is:

        Unique Paths = m+n-2/m-1 =(m+n-2)!/(m-1)!(n-1)!


        You have a grid with m rows and n columns. To move from the top-left corner (0,0) to the bottom-right corner (m-1, n-1):
        1.	The robot can only move right or down.
        2.	The robot needs to make exactly:
        •	m-1 down moves to traverse m rows, and
        •	n-1 right moves to traverse n columns.

        Thus, the robot makes a total of:

        T = (m-1) + (n-1) = m + n - 2

        moves.

        Now the question becomes:
        •	Out of these T = m+n-2 total moves, in how many ways can we choose m-1 moves to be “down” (or equivalently n-1 moves to be “right”)?


        Combinatorial Approach

        This is a classic combinatorics problem of arranging T items into two categories:
            •	m-1 “down” moves, and
            •	n-1 “right” moves.

        The total number of unique arrangements is given by the binomial coefficient:

        \binom{T}{m-1} = \frac{T!}{(m-1)! \cdot (n-1)!}

        Where:
            •	T! = (m+n-2)!: Factorial of the total number of moves.
            •	(m-1)!: Factorial of the “down” moves.
            •	(n-1)!: Factorial of the “right” moves.

        This formula counts all distinct ways to arrange T moves, considering that m-1 moves are identical (all “down”) and n-1 moves are identical (all “right”).

        Example

        Grid Size: 3 \times 7
            •	Total moves: T = m + n - 2 = 3 + 7 - 2 = 8
            •	Down moves: m-1 = 3-1 = 2
            •	Right moves: n-1 = 7-1 = 6

        The total number of unique paths is:

        8/2 = frac{8!}{2! 6!} = frac{8 * 7 * 6!}{2! * 6!} = frac{8 * 7}{2} = 28

     */

    public int findNcR(int rows,int cols){

        int N = rows+cols-2;
        int R = rows > cols ? cols-1 : rows-1;


        int result = 1;
        for (int i = 0; i < R; i++) {
            result = result * (N-i);
            result = result / (i+1);
        }
        return result;
    }
}