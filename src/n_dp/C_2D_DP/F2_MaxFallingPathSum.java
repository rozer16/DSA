package n_dp.C_2D_DP;

import java.util.Arrays;

public class F2_MaxFallingPathSum {
    public static void main(String[] args) {
        F2_MaxFallingPathSum solution = new F2_MaxFallingPathSum();
        int matrix[][] = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };


        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("Max Falling Path sum using recursion : "+solution.minFallingPathSumRecursion(matrix));
        System.out.println("Max Falling Path sum using memoization : "+solution.minFallingPathSumMemoization(matrix));
        System.out.println("Max Falling Path sum using tabulation : "+solution.minFallingPathSumTabulation(matrix));
        System.out.println("Max Falling Path sum using space optimization : "+solution.minFallingPathSumSpaceOptimization(matrix));


        int matrix1[][] =  {
                        {2,1,3},
                        {6,5,4},
                        {7,8,9}
        };

        System.out.println("============");
        for (int i = 0; i < matrix1.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
        System.out.println();
        System.out.println("Max Falling Path sum using recursion : "+solution.minFallingPathSumRecursion(matrix1));
        System.out.println("Max Falling Path sum using memoization : "+solution.minFallingPathSumMemoization(matrix1));
        System.out.println("Max Falling Path sum using tabulation : "+solution.minFallingPathSumTabulation(matrix1));
        System.out.println("Max Falling Path sum using space optimization : "+solution.minFallingPathSumSpaceOptimization(matrix1));
    }

    public int minFallingPathSumRecursion(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int col = 0; col < matrix[0].length; col++) {
            max = Math.max(max, minFallingPathSumRecursion(matrix,matrix.length-1,col));
        }

        return max;
    }

    public int minFallingPathSumRecursion(int[][] matrix, int row, int col) {
        if(col < 0 || col >= matrix[0].length)
            return (int)-1e9;

        if(row == 0)
            return matrix[row][col];


        int leftDiagonal = matrix[row][col] + minFallingPathSumRecursion(matrix,row-1,col-1);
        int up = matrix[row][col] + minFallingPathSumRecursion(matrix,row-1, col);
        int rightDiagonal = matrix[row][col] + minFallingPathSumRecursion(matrix,row-1, col+1);

        return Math.max(leftDiagonal, Math.max(up, rightDiagonal));
    }

    public int minFallingPathSumMemoization(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int [][] dp= new int[matrix.length][matrix[0].length];
        for (int col = 0; col < matrix[0].length; col++) {
            for(int [] row : dp)
                Arrays.fill(row, -1);
            max = Math.max(max, minFallingPathSumMemoization(matrix,matrix.length-1,col,dp));
        }

        return max;
    }

    public int minFallingPathSumMemoization(int[][] matrix, int row, int col, int [][] dp) {
        if(col < 0 || col >= matrix[0].length)
            return (int)-1e9;

        if(row == 0)
            return matrix[row][col];

        if(dp[row][col] != -1)
            return dp[row][col];

        int leftDiagonal = matrix[row][col] + minFallingPathSumRecursion(matrix,row-1,col-1);
        int up = matrix[row][col] + minFallingPathSumRecursion(matrix,row-1, col);
        int rightDiagonal = matrix[row][col] + minFallingPathSumRecursion(matrix,row-1, col+1);

        dp[row][col] = Math.max(leftDiagonal, Math.max(up, rightDiagonal));
        return dp[row][col];
    }

    public int minFallingPathSumTabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int [][] dp= new int[matrix.length][matrix[0].length];

        // Initializing the first row - base condition
        for (int col = 0; col < matrix[0].length; col++) {
            dp[0][col] = matrix[0][col];
        }
        int maxi = Integer.MIN_VALUE;


        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int leftDownDiagonal = (int)-1e9 , down =  (int)-1e9, rightDownDiagonal =  (int)-1e9;
                if(col-1 >= 0)
                    leftDownDiagonal = matrix[row][col]+ dp[row-1][col-1];

                down = matrix[row][col] + dp[row-1][col];

                if(col+1 <= m-1 )
                    rightDownDiagonal = matrix[row][col] + dp[row-1][col+1];

                dp[row][col] = Math.max(leftDownDiagonal, Math.max(down,rightDownDiagonal));
            }
        }

        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n-1][j] );
        }
        return maxi;
    }

    public int minFallingPathSumSpaceOptimization(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int [] prev= new int[matrix[0].length];

        // Initializing the first row - base condition

        int maxi = Integer.MIN_VALUE;


        for (int col = 0; col < matrix[0].length; col++) {
            prev[col] = matrix[0][col];
        }
        for (int row = 1; row < n; row++) {
            int [] curr = new int[m];
            for (int col = 0; col < m; col++) {
                int leftDownDiagonal = (int)-1e9 , down =  (int)-1e9, rightDownDiagonal =  (int)-1e9;
                if(col-1 >= 0)
                    leftDownDiagonal = matrix[row][col]+ prev[col-1];

                down = matrix[row][col] + prev[col];

                if(col+1 <= m-1 )
                    rightDownDiagonal = matrix[row][col] + prev[col+1];

                curr[col] = Math.max(leftDownDiagonal, Math.max(down,rightDownDiagonal));
            }
            prev= curr;
        }


        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, prev[j] );
        }
        return maxi;
    }


    }
