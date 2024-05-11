package n_dynamic_programming.E_LongestCommonSubstring;

import java.util.Arrays;

public class H2_DistinctSubSequeunces {
    public static void main(String[] args) {
            String str1 = "rabbbit";
            String str2 = "rabbit";

            int [][] dp = new int[str1.length()+1][str2.length()+1];
            for(int [] row : dp){
                Arrays.fill(row, -1);
            }

            H2_DistinctSubSequeunces solution = new H2_DistinctSubSequeunces();//3
            System.out.println(solution.numDistinctRecursion(str1.length(), str2.length(),str1, str2));//3
            System.out.println(solution.numDistinctRecursionMemoization(str1.length(), str2.length(),str1, str2,dp));//3
            System.out.println(solution.numDistinctTabulation(str1, str2));//3
            System.out.println(solution.numDistinctSpaceOptimization(str1, str2));//3
            System.out.println(solution.numDistinctSpaceOptimization1(str1, str2)); //3
    }

    public int numDistinctRecursion(int ind1, int ind2, String str1, String str2) {
        if(ind2 == 0)
            return 1;
        if(ind1 == 0)
            return 0;

        if(str1.charAt(ind1-1) == str2.charAt(ind2-1))
            // If the characters match, we can either include this character in the subsequence
            // or exclude it. So, we add the counts from both possibilities.

            return numDistinctRecursion(ind1-1, ind2-1, str1,str2) + numDistinctRecursion(ind1-1, ind2, str1, str2);
        else
            // If the characters don't match, we can only exclude this character.
            return numDistinctRecursion(ind1-1, ind2, str1, str2);

    }

    public int numDistinctRecursionMemoization(int ind1, int ind2, String str1, String str2, int dp[][]) {
        if(ind2 == 0)
            return 1;
        if(ind1 == 0)
            return 0;

        if(dp[ind1][ind2] != -1)
                return dp[ind1][ind2];

        if(str1.charAt(ind1-1) == str2.charAt(ind2-1)) {
            // If the characters match, we can either include this character in the subsequence
            // or exclude it. So, we add the counts from both possibilities.

            dp[ind1][ind2]  =  numDistinctRecursion(ind1 - 1, ind2 - 1, str1, str2) + numDistinctRecursion(ind1 - 1, ind2, str1, str2);
            return dp[ind1][ind2];
        }else {
            // If the characters don't match, we can only exclude this character.

            dp[ind1][ind2]  =  numDistinctRecursion(ind1 - 1, ind2, str1, str2);
            return dp[ind1][ind2];
        }

    }
    public int numDistinctTabulation(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int [][] dp = new int[n+1][m+1];

        for(int i=0; i<=n ; i++)
            dp[i][0]=1;

        // Initialize the first row (except dp[0][0]) with 0 because there's no way to form s2 from an empty string.
        for(int j=1; j<=m ; j++)
            dp[0][j]=0;



        for(int ind1 = 1; ind1 <= n; ind1++){
            for(int ind2 = 1; ind2 <=m; ind2++){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1))
                    // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.

                    dp[ind1][ind2] =  dp[ind1-1][ind2-1] + dp[ind1-1][ind2];
                else
                    // If the characters don't match, we can only exclude this character.
                    dp[ind1][ind2] =   dp[ind1-1][ind2];
            }
        }

        return dp[n][m];
    }

    public int numDistinctSpaceOptimization(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int [] prev = new int[m+1];

        prev[0] =1;


        for(int ind1 = 1; ind1 <= n; ind1++){
            int [] curr = new int[m+1];
            curr[0] =1;
            for(int ind2 = 1; ind2 <=m; ind2++){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1))
                    // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.

                    curr[ind2] =  prev[ind2-1] + prev[ind2];
                else
                    // If the characters don't match, we can only exclude this character.

                    curr[ind2] =   prev[ind2];
            }
            prev = curr;
        }

        return prev[m];
    }

    public int numDistinctSpaceOptimization1(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int [] prev = new int[m+1];

        prev[0] =1;


        for(int ind1 = 1; ind1 <= n; ind1++){
            for(int ind2 = m; ind2 > 0; ind2--){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1))
                    // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.

                    prev[ind2] =  prev[ind2-1] + prev[ind2];
                else
                    // If the characters don't match, we can only exclude this character.

                    prev[ind2] =   prev[ind2];
            }
        }

        return prev[m];
    }
}
