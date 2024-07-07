package o_dp.I_DPOnSquares;

public class B1_CountSquareSubmatriceswithAll1s {

    public static void main(String[] args) {

    }
/*
    Time Complexity: O(N*M), where N = total no. of rows and M = total no. of columns
    Reason: We are basically traversing a 2D matrix with N rows and M columns.

    Space Complexity: O(N*M), where N = total no. of rows and M = total no. of columns
    Reason: We are using a 2D dp array with N rows and M columns.*/
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];

        int total = 0;

        //Copying first column.
        for(int i = 0; i<n;i++){
            dp[i][0] = matrix[i][0];
            total += dp[i][0];
        }


        //Copying first row.
        for(int i = 0; i<m;i++){
            dp[0][i] = matrix[0][i];
            if(i!=0)
                total += dp[0][i];
        }



        for(int i = 1; i<n; i++){
            for(int j =1; j<m; j++){
                if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = 1+ Math.min(
                            dp[i-1][j] //Upper
                            ,Math.min(
                                    dp[i-1][j-1] //diagonal
                                    ,dp[i][j-1] //left
                            )
                    );

                    total += dp[i][j];
                    System.out.println(i+","+j+" ="+ dp[i][j]+" "+total);
                }
            }

        }

        return total;
    }
}
