package n_dynamic_programming.E_LongestCommonSubstring;

import java.util.Arrays;

public class A4_LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "acd", str2 = "ced";
        A4_LongestCommonSubsequence solution = new A4_LongestCommonSubsequence();
        int [][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }


        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring : "+solution.findLongestSubStringLength(str1.length()-1, str2.length()-1, str1, str2));
        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring using memoization : "+solution.findLongestSubStringLengthMemoization(str1.length()-1, str2.length()-1, str1, str2,dp));
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring using memoization shifting index: "+solution.findLongestSubStringLengthMemoizationShifting(str1.length(), str2.length(), str1, str2,dp));
        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring using tabulation: "+solution.findLongestSubStringLengthTabulation(str1, str2));
        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring using space optimization: "+solution.findLongestSubStringLengthSpaceOptimization( str1, str2));


        System.out.println("==========================================");



        str1 = "abcde";
        str2 = "ace";

        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring : "+solution.findLongestSubStringLength(str1.length()-1, str2.length()-1, str1, str2));



        dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring using memoization : "+solution.findLongestSubStringLengthMemoization(str1.length()-1, str2.length()-1, str1, str2,dp));


        dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring using memoization shifting index: "+solution.findLongestSubStringLengthMemoizationShifting(str1.length(), str2.length(), str1, str2,dp));
        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring using Tabulation : "+solution.findLongestSubStringLengthTabulation(str1, str2));
        System.out.println("Str1 : "+str1+", str2: "+str2+" , Longest common substring  space optimization: "+solution.findLongestSubStringLengthSpaceOptimization( str1, str2));


        /*


        Str1 : acd, str2: ced , Longest common substring : 2
        Str1 : acd, str2: ced , Longest common substring using memoization : 2
        Str1 : acd, str2: ced , Longest common substring using memoization shifting index: 2
        Str1 : acd, str2: ced , Longest common substring using tabulation: 2
        Str1 : acd, str2: ced , Longest common substring using space optimization: 2
        ==========================================
        Str1 : abcde, str2: ace , Longest common substring : 3
        Str1 : abcde, str2: ace , Longest common substring using memoization : 3
        Str1 : abcde, str2: ace , Longest common substring using memoization shifting index: 3
        Str1 : abcde, str2: ace , Longest common substring using Tabulation : 3
        Str1 : abcde, str2: ace , Longest common substring  space optimization: 3


        * */
    }


    // // Function to find the length of the Longest Common Subsequence (LCS)
    public int findLongestSubStringLength(int ind1, int ind2 ,String str1, String str2){
        if(ind1 < 0 || ind2 < 0)
            return 0;

        if(str1.charAt(ind1) == str2.charAt(ind2))
            return 1+ findLongestSubStringLength(ind1-1, ind2-1, str1, str2);

        return Math.max(
                findLongestSubStringLength(ind1-1, ind2, str1, str2),
                findLongestSubStringLength(ind1, ind2-1, str1, str2)

        );
    }

    public int findLongestSubStringLengthMemoization(int ind1, int ind2 ,String str1, String str2, int [][] dp){
        // Base case: If either of the strings reaches the end, return 0
        if(ind1 < 0 || ind2 < 0)
            return 0;


        // If the result for this subproblem has already been calculated, return it
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        // If the characters at the current indices are the same, increment the LCS length
        if(str1.charAt(ind1) == str2.charAt(ind2))
            return 1+ findLongestSubStringLengthMemoization(ind1-1, ind2-1, str1, str2,dp);

        // If the characters are different, choose the maximum LCS length by either
        // skipping a character in s1 or skipping a character in s2
        return Math.max(
                findLongestSubStringLengthMemoization(ind1-1, ind2, str1, str2,dp),
                findLongestSubStringLengthMemoization(ind1, ind2-1, str1, str2,dp)

        );
    }


    /*
    Time Complexity: O(N*M)

    Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.

    Space Complexity: O(N*M) + O(N+M)

    Reason: We are using an auxiliary recursion stack space(O(N+M))
     (see the recursive tree, in the worst case, we will go till N+M calls at a time) and a 2D array ( O(N*M)).

    * */
    public int findLongestSubStringLengthMemoizationShifting(int ind1, int ind2 ,String str1, String str2, int [][] dp){
        if(ind1 == 0 || ind2 == 0)
            return 0;

        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if(str1.charAt(ind1-1) == str2.charAt(ind2-1))
            return 1+ findLongestSubStringLengthMemoizationShifting(ind1-1, ind2-1, str1, str2,dp);


        dp[ind1][ind2] = Math.max(
                findLongestSubStringLengthMemoizationShifting(ind1-1, ind2, str1, str2,dp),
                findLongestSubStringLengthMemoizationShifting(ind1, ind2-1, str1, str2,dp)

        );
        return  dp[ind1][ind2];
    }



    /*
    Time Complexity: O(N*M)

    Reason: There are two nested loops

    Space Complexity: O(N*M)

    Reason: We are using an external array of size ‘N*M)’. Stack Space is eliminated.
    * */

    public int findLongestSubStringLengthTabulation(String str1, String str2){
        int n = str1.length();
        int m = str2.length();


        // Create a 2D array to store results of subproblems
        int [][] dp = new int[n+1][m+1];

        for (int rows[] : dp)
            Arrays.fill(rows, -1);


        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using dynamic programming
        for (int ind11 = 1; ind11 <=n ; ind11++) {
            for (int ind22 = 1; ind22 <= m ; ind22++) {

                // If the characters at the current indices are the same, increment the LCS length
                if(str1.charAt(ind11-1) == str2.charAt(ind22-1))
                    dp[ind11][ind22] =  1+ dp[ind11-1][ ind22-1];
                else
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2
                    dp[ind11][ind22] = Math.max(
                        dp[ind11-1][ ind22],
                        dp[ind11] [ind22-1]
                    );

            }
        }

        return  dp[n][m];
    }



    /*
    Time Complexity: O(N*M)

    Reason: There are two nested loops.

    Space Complexity: O(M)

    Reason: We are using an external array of size ‘M+1’ to store only two rows.
    * */
    public int findLongestSubStringLengthSpaceOptimization(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        // Create arrays to store the LCS lengths
        int [] prev = new int[m+1];

        for (int ind11 = 1; ind11 <=n ; ind11++) {
            int [] curr = new int[m+1];
            for (int ind22 = 1; ind22 <= m ; ind22++) {

                // If the characters at the current indices are the same, increment the LCS length
                if(str1.charAt(ind11-1) == str2.charAt(ind22-1))
                    curr[ind22] =  1+ prev[ ind22-1];
                else

                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2

                    curr[ind22] = Math.max(
                            prev[ ind22],
                            curr[ind22-1]
                    );

            }
            prev = curr;
        }

        return  prev[m];
    }

}
