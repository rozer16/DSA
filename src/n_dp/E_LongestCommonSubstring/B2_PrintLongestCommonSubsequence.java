package n_dp.E_LongestCommonSubstring;

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
}
