package o_dp.E_LongestCommonSubstring;

import java.util.Arrays;

public class J2_WildcardMatching {

    public static void main(String[] args) {
        String str1 = "aab";
        String str2 = "c*a*b";
        J2_WildcardMatching result = new J2_WildcardMatching();
        //System.out.println(result.isMatchSpaceOptimization(str2, str1));

        int dp[][]  = new int[str1.length()+1][str2.length()+1];
        for(int [] row : dp)
            Arrays.fill(row, -1);
        //return isMatchRecursion(p.length(),s.length(),p, s,dp );
        System.out.println(result.isMatchRecursion(str1.length(),str2.length(),str1, str2,dp));
    }

    public boolean isMatchRecursion(int index1, int index2, String str1, String str2, int[][] dp) {

        if(index1 == 0 && index2 == 0)
            return true;
        if(index1 == 0 && index2 >= 1 )
            return false;
        if(index1 >= 1 && index2 == 0){
            for(int i=0; i<=index1; i++){
                if(str1.charAt(i-1) != '*')
                    return false;
            }
            return true;

        }

        if(dp[index1][index2] != -1)
            return dp[index1][index2] == 1 ? true : false;

        if(str1.charAt(index1-1) == str2.charAt(index2-1) || str1.charAt(index1-1) == '?'){
            boolean result =  isMatchRecursion(index1-1, index2-1, str1, str2,dp);
            dp[index1][index2] = result?1:0;
            return result;
        }
        else if(str1.charAt(index1-1) == '*'){
            boolean result =  isMatchRecursion(index1-1,index2, str1, str2,dp) || isMatchRecursion(index1, index2-1, str1, str2,dp);
            dp[index1][index2] = result?1:0;
            return result;
        }else{
            dp[index1][index2] = 0;
            return false;
        }
    }

    public boolean isMatchTabulation(String str1, String str2) {


        int n = str1.length();
        int m = str2.length();
        boolean [][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int index2 = 1; index2 <= m; index2++)
            dp[0][index2] = false;

        for(int index1 = 1; index1 <= n; index1++){
            dp[index1][0] = isAllStars(str1, index1-1);
        }

        for(int index1 = 1; index1 <= n; index1++){
            for(int index2 = 1; index2 <= m; index2++){
                if(str1.charAt(index1-1) == str2.charAt(index2-1) || str1.charAt(index1-1) == '?'){
                    dp[index1][index2] = dp[index1-1][index2-1];
                }
                else if(str1.charAt(index1-1) == '*'){
                    dp[index1][index2] =  dp[index1-1][index2]
                            || dp[index1] [index2-1];
                }else{
                    dp[index1][index2] = false;

                }
            }
        }
        return dp[n][m];
    }

    public boolean isMatchSpaceOptimization(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();
        boolean []prev = new boolean[m+1];
        prev[0] = true;
        boolean []curr = new boolean[m+1];

        for(int i = 1; i <= n; i++){

            curr[0] = isAllStars(S1, i);
            for(int j = 1; j <= m; j++){
                if(S1.charAt(i-1) == S2.charAt(j-1) || S1.charAt(i-1) == '?'){
                    curr[j] = prev[j-1];
                }else{
                    if(S1.charAt(i-1) == '*')
                        curr[j] =  prev[j] || curr[j-1];
                    else
                        curr[j] = false;
                }
            }
            prev=curr.clone();
        }
        return prev[m];
    }

    public boolean isAllStars(String str1, int i){
        for(int j=1; j <= i; j++){
            if(str1.charAt(j-1) != '*' ){
                return false;
            }
        }
        return true;
    }

}
