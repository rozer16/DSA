package o_dp.C_2D_DP;

import java.util.Arrays;

public class D2_MinimumPathSum {
    public static void main(String[] args) {
        int [][] grid = {
                {5, 9, 6},
                {11, 5, 2}
        };

        D2_MinimumPathSum solution = new D2_MinimumPathSum();
        System.out.println(" Minimum Sum Path using recursion "+solution.minPathSumRecursion(grid));
        System.out.println(" Minimum Sum Path using memoization "+solution.minPathSumRecursion(grid));
        System.out.println(" Minimum Sum Path using tabulation "+solution.minPathSumTabulation(grid));
        System.out.println(" Minimum Sum Path using space optimazation "+solution.minPathSumPathSpaceOptimazation(grid));
    }


    public int minPathSumRecursion(int[][] grid) {
        return minPathSumRecursion(grid,grid.length-1,grid[0].length-1);
    }

    public int minPathSumRecursion(int[][] grid, int row, int col) {
        if(row == 0 && col == 0){
            // // If we're at the top-left cell, return its value
            return grid[row][col];
        }

        if(row < 0 || col < 0) //If we're out of bounds, return a large value, dont return Integer.MAX_VALUE it will go in negative value after addition
            return (int)1e9;



        // Calculate the sum of the current cell plus the minimum sum path from above and from the left
        int  top = grid[row][col]+ minPathSumRecursion(grid,row-1,col);
        int left = grid[row][col] + minPathSumRecursion(grid,row, col-1);

        return   Math.min(top , left);
    }

    public int minPathSumMemoization(int[][] grid){
        int [][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return (minPathSumMemoization(grid,grid.length-1,grid[0].length,dp));
    }
    public int minPathSumMemoization(int[][] grid, int row, int col,int [][] dp) {
        if(row == 0 && col == 0){
            // // If we're at the top-left cell, return its value
            return grid[row][col];
        }

        if(row < 0 || col < 0) //If we're out of bounds, return a large value, dont return Integer.MAX_VALUE it will go in negative value after addition
            return (int)1e9;


        if(dp[row][col] != -1)
            return dp[row][col];

        // Calculate the sum of the current cell plus the minimum sum path from above and from the left
        int  top = grid[row][col]+ minPathSumRecursion(grid,row-1,col);
        int left = grid[row][col] + minPathSumRecursion(grid,row, col-1);

        dp[row][col] = Math.min(top , left);;
        return   dp[row][col];
    }


    public int minPathSumTabulation(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if(row == 0 && col == 0){
                    dp[row][col] = grid[row][col];
                    continue;
                }

                int up = (int)1e9;
                int left = (int)1e9;
                if(row>0)
                    up = dp[row-1][col];
                if(col>0)
                    left = dp[row][col-1];

                 dp[row][col] = grid[row][col]+ Math.min(up,left);
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    public int minPathSumPathSpaceOptimazation(int[][] grid) {
        int [] prev = new int[grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            int curr [] = new int[grid[0].length];
            for (int col = 0; col < grid[0].length; col++) {
                if(row == 0 && col == 0){
                    curr[col] = grid[row][col];
                    continue;
                }

                int up = (int)1e9;
                int left = (int)1e9;
                if(row>0)
                    up = prev[col];
                if(col>0)
                    left = curr[col-1];

                curr[col] = grid[row][col]+ Math.min(up,left);
            }
            prev = curr;
        }

        return prev[grid[0].length-1];
    }
}
