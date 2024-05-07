package n_dynamic_programming.E_LongestCommonSubstring;

public class D2_FindLongestCommoPalindromSubSequence {
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s1) {

        String s2 = new StringBuffer(s1).reverse().toString();

        int n = s1.length();
        int m = s2.length();

        int []prev = new int[m+1];

        // Fill the dp array using dynamic programming
        for (int ind11 = 1; ind11 <=n ; ind11++) {
            int []curr = new int[m+1];
            for (int ind22 = 1; ind22 <= m ; ind22++) {

                // If the characters at the current indices are the same, increment the LCS length
                if(s1.charAt(ind11-1) == s2.charAt(ind22-1))
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

        return prev[m];


    }
}
