package n_dynamic_programming.C_2D_DP;

import java.util.Arrays;

public class C2_GetUniquePathWithoutObstacle {

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        int [][] maze1 = {{0,0}};

        C2_GetUniquePathWithoutObstacle solution = new C2_GetUniquePathWithoutObstacle();
        System.out.println("Grid length using recursion : "+solution.uniquePathsWithObstaclesRecursion(maze,maze.length-1, maze[0].length-1));
        System.out.println("Grid length using memoization: "+solution.uniquePathsWithObstaclesMemoization(maze));
        System.out.println("Grid length using tabulation: "+solution.uniquePathsWithObstaclesTabulation(maze));
        System.out.println("Grid length using space optimazation: "+solution.uniquePathsWithObstaclesSpaceOptimization(maze));

    }

    public int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid,int i,int j) {

        if(i == 0 && j == 0)
            return 1;

        if(i < 0 || j< 0)
            return 0;

        if(obstacleGrid[i][j] == -1)
            return 0;

       return uniquePathsWithObstaclesRecursion(obstacleGrid,i-1,j) + uniquePathsWithObstaclesRecursion(obstacleGrid,i,j-1);

    }

    public int uniquePathsWithObstaclesMemoization(int [][] obstacleGrid){
        int [][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return uniquePathsWithObstaclesMemoization(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1,dp);
    }
    public int uniquePathsWithObstaclesMemoization(int[][] obstacleGrid, int i, int j, int[][] dp) {

        if(i == 0 && j == 0)
            return 1;

        if(i < 0 || j< 0)
            return 0;

        if(obstacleGrid[i][j] == -1)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] =  uniquePathsWithObstaclesRecursion(obstacleGrid,i-1,j) + uniquePathsWithObstaclesRecursion(obstacleGrid,i,j-1);
        return dp[i][j];

    }


    public int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {

                if (k > 0 && l > 0 && obstacleGrid[k][l] == -1) {
                    dp[k][l] = 0; // If there's an obstacle, no paths can go through here.
                    continue;
                }
                if(k == 0 && l == 0){
                    dp[k][l] = 1;
                    continue;
                }

                int top = 0, left = 0;
                if(k>0)
                    top = dp[k-1][l];
                if(l>0)
                    left = dp[l][l-1];

                dp[k][l] = top+left;

            }
        }

        return dp[n-1][m-1];

    }

    public int uniquePathsWithObstaclesSpaceOptimization(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int prev[] = new int[m];


        for (int row = 0; row < n; row++) {
            int curr [] = new int[m];
            for (int col = 0; col < m; col++) {

                if (row >= 0 && col >= 0 && obstacleGrid[row][col] == - 1) {
                    curr[col]  = 0; // If there's an obstacle, no paths can go through here.
                    continue;
                }

                if(row == 0 && col == 0){
                    curr[col] = 1;
                    continue;
                }



                int top = 0, left = 0;
                if(row>0)
                    top = prev[col];
                if(col>0)
                    left = curr[col-1];

                curr[col] = top+left;

            }
            prev = curr;
        }

        return prev[m-1];
    }
}
