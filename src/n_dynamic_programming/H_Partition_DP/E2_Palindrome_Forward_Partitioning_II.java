package n_dynamic_programming.H_Partition_DP;

import java.util.Arrays;

public class E2_Palindrome_Forward_Partitioning_II {

    public static void main(String[] args) {
        String s = "bababcbadcede";
        E2_Palindrome_Forward_Partitioning_II sol = new E2_Palindrome_Forward_Partitioning_II();

        int [] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        System.out.println("Min partition : "+(sol.minCutRecursionMemoization(0,s,dp)-1));
        System.out.println("Min partition : "+(sol.minCutRecursionTabulation(s)-1));
    }



    public int minCutRecursion(int i,String s) {
        if(i == s.length())
            return 0;

        int mini = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if(isPalindrom(i,j,s)){
                int cost = 1 + minCutRecursion(j+1, s);
                mini = Math.min(mini, cost);
            }
        }

        return mini;
    }

    public int minCutRecursionMemoization(int i,String s, int [] dp) {
        if(i == s.length())
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int mini = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if(isPalindrom(i,j,s)){
                int cost = 1 + minCutRecursionMemoization(j+1, s,dp);
                mini = Math.min(mini, cost);
            }
        }

        dp[i] = mini;
        return mini;
    }

    public int minCutRecursionTabulation(String s ) {

        int n = s.length();
        int [] dp = new int[s.length()+1];

        for (int i = n-1; i >= 0; i--) {
            int mini = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if(isPalindrom(i,j,s)){
                    int cost = 1 + dp[j+1];
                    mini = Math.min(mini, cost);
                }
            }
            dp[i] = mini;
        }

        return dp[0]-1;
    }

    public boolean isPalindrom(int left, int right, String str){
        while(left < right){
            if(str.charAt(left) != str.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }



}
