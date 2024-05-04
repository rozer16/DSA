package n_dynamic_programming.C_2D_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E2_MinimumPathSumInTriangularGrid {

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        triangle.add(Arrays.asList(2,3));
        triangle.add(Arrays.asList(4,5,6));
        triangle.add(Arrays.asList(7,8,9,10));


        E2_MinimumPathSumInTriangularGrid solution = new E2_MinimumPathSumInTriangularGrid();
        System.out.println("Minimum sum path using recursion : "+solution.minimumTotalRecursion(triangle));
        System.out.println("Minimum sum path using memoization : "+solution.minimumTotalMemoization(triangle));
        System.out.println("Minimum sum path using tabulation : "+solution.minimumTotalTabulation(triangle));
        System.out.println("Minimum sum path using space optimization : "+solution.minimumTotalSpaceOptimization(triangle));

    }

    public int minimumTotalRecursion(List<List<Integer>> triangle) {
        return minimumTotalRecursion(triangle,0,0);
    }


    public int minimumTotalRecursion(List<List<Integer>> triangle, int row, int col) {

        if(row == triangle.size()-1)
            return triangle.get(row).get(col);

        int down = triangle.get(row).get(col) + minimumTotalRecursion(triangle,row+1, col);
        int diagonal = triangle.get(row).get(col) + minimumTotalRecursion(triangle,row+1, col+1);


        return Math.min(down, diagonal);

    }

    public int minimumTotalMemoization(List<List<Integer>> triangle) {
        int [][] dp = new int[triangle.size()][triangle.size()];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return minimumTotalMemoization(triangle,0,0,dp);
    }


    public int minimumTotalMemoization(List<List<Integer>> triangle, int row, int col, int [][] dp) {

        if(row == triangle.size()-1)
            return triangle.get(row).get(col);

        if(dp[row][col] != -1)
            return dp[row][col];

        int down = triangle.get(row).get(col) + minimumTotalRecursion(triangle,row+1, col);
        int diagonal = triangle.get(row).get(col) + minimumTotalRecursion(triangle,row+1, col+1);

        dp[row][col] = Math.min(down, diagonal);
        return dp[row][col];

    }


    public int minimumTotalTabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n][n];
        for (int i = 0; i < triangle.get(n-1).size(); i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for (int row = n-2; row >= 0; row--) {
            for (int col = row; col >= 0 ; col--) {
                int down = triangle.get(row).get(col) + dp[row+1][ col];
                int diagonal = triangle.get(row).get(col) + dp[row+1][ col+1];
                dp[row][col] = Math.min(down,diagonal);
            }
        }


        return dp[0][0];
    }

    public int minimumTotalSpaceOptimization(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [] prev = new int[n];
        for (int i = 0; i < triangle.get(n-1).size(); i++) {
            prev[i] = triangle.get(n-1).get(i);
        }

        for (int row = n-2; row >= 0; row--) {
            int [] curr = new int[row+1];
            for (int col = row; col >= 0 ; col--) {
                int down = triangle.get(row).get(col) + prev[ col];
                int diagonal = triangle.get(row).get(col) + prev[ col+1];
                curr[col] = Math.min(down,diagonal);
            }
            prev = curr;
        }
        return prev[0];
    }
}
