package n_dp.A_IntroToDP;

public class A5_Fibbonacci_Tabulation_Space_Optimazation {

        /*
        If we closely look at the relation,
        dp[i] =  dp[i-1] + dp[i-2]

        we see that for any i, we do need only the last two values in the array.
         So is there a need to maintain a whole array for it?

        * */

        public int fibbonacci(int n){
            int prev1 = 1;
            int prev2 = 0;

            for (int i = 2; i <= n ; i++) {
                int currI = prev1 + prev2;
                prev2 = prev1;
                prev1 = currI;
            }

            return prev1;
        }
}

