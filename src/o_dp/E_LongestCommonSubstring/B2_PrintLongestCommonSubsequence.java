package o_dp.E_LongestCommonSubstring;

import java.util.*;

public class B2_PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "bdgek";


        B2_PrintLongestCommonSubsequence solution = new B2_PrintLongestCommonSubsequence();
        System.out.println(solution.getMaxLongestCommonSubSeqLen(str1,str2));
    }


    public String getMaxLongestCommonSubSeqLen(String s1, String s2){

        int n = s1.length();
        int m = s2.length();

        int [][] dp = new int[n+1][m+1];

        // Fill the dp array using dynamic programming
        for (int ind11 = 1; ind11 <=n ; ind11++) {
            for (int ind22 = 1; ind22 <= m ; ind22++) {

                // If the characters at the current indices are the same, increment the LCS length
                if(s1.charAt(ind11-1) == s2.charAt(ind22-1))
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

        char [] ans = new char[dp[n][m]];
        int row = n;
        int col = m;
        int ansInd = dp[n][m]-1;

        while(row > 0 && col > 0){
            if(s1.charAt(row-1) == s2.charAt(col-1)){
                ans[ansInd] = s2.charAt(col-1);
                ansInd--;
                row--;
                col--;
            } else if (dp[row][col-1] > dp[row-1][col]) {
                col--;
            }else{
                row--;
            }
        }

       return new String(ans);
    }

    //Method to find all LCS

    public List<String> all_longest_common_subsequences_interative(String s, String t) {
        int n = s.length();
        int m = t.length();

        int [][] dp = new int[n+1][m+1];

        for(int index1 = 1; index1 <= n; index1++){
            for(int index2 = 1; index2 <= m; index2++){
                if(s.charAt(index1-1) == t.charAt(index2-1)){
                    dp[index1][index2] = 1 + dp[index1-1][ index2-1];

                }else{
                    dp[index1][index2] =  Math.max(dp[index1-1][index2], dp[index1][ index2-1]);
                }
            }
        }

        Set<String> set = new HashSet();
        //backTrack(dp, n,m, s,t,set, new StringBuilder());
        backtrack(dp,s,t,n,m,new StringBuilder(), set);
        List<String> result = new ArrayList(set);
        Collections.sort(result);
        return result;
    }


        private void backtrack(int[][] dp, String s, String t, int i, int j, StringBuilder current, Set<String> result) {
            if (i == 0 || j == 0) {
                // Base case: add the current LCS to the result set
                result.add(current.reverse().toString());
                current.reverse(); // Undo the reversal for further backtracking
                return;
            }

            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                // Characters match, include them in the current LCS
                current.append(s.charAt(i - 1));
                backtrack(dp, s, t, i - 1, j - 1, current, result);
                current.deleteCharAt(current.length() - 1); // Backtrack
            } else {
                // Explore both possible paths (if they yield the same LCS length)
                if (dp[i - 1][j] == dp[i][j]) {
                    backtrack(dp, s, t, i - 1, j, current, result);
                }
                if (dp[i][j - 1] == dp[i][j]) {
                    backtrack(dp, s, t, i, j - 1, current, result);
                }
            }
        }
}

// Helper class to track the state
class LCSState {
    int i, j;
    StringBuilder current;

    LCSState(int i, int j, StringBuilder current) {
        this.i = i;
        this.j = j;
        this.current = current;
    }
}