package o_dp.A_IntroToDP;

import java.util.Arrays;

public class A4_Fibbonacci_Tabulation {


    /*
    Declare a dp[] array of size n+1.
    First initialize the base condition values, i.e i=0 and i=1 of the dp array as 0 and 1 respectively.
    Set an iterative loop that traverses the array( from index 2 to n) and
    for every index set its value as dp[i-1] + dp[i-2].

    * */


    /*
   Time Complexity: O(N)
        Reason: We are running a simple iterative loop

   Space Complexity: O(N)
        sReason: We are using an external array of size ‘n+1’.
    * */
    public int fibbonacci(int n){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]= 0;
        dp[1]= 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }

        return dp[n];
    }
}
