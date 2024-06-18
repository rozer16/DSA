package e1_greedy_algorithm;


import java.util.Arrays;

/*
 //https://youtu.be/QhPdNS143Qg
       https://leetcode.com/problems/valid-parenthesis-string/
       https://www.youtube.com/watch?v=QhPdNS143Qg&t=603s
* */
public class E_Valid_Paranthesis_String {


    public static void main(String[] args) {
        E_Valid_Paranthesis_String sol = new E_Valid_Paranthesis_String();
        String str = "(()()))";
        int dp [][] = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(sol.checkValidString(str,0,0,dp));
    }

    //Intuition : whenever * comes, we will maintain a range
    //since in bruteforce we always return false from the moment count goes -1, for min if it becomes -1 we will reset it to 0.

    public boolean checkValidString(String s) {

        int min = 0;
        int max = 0;
        for(int index = 0; index< s.length(); index++){
            if(s.charAt(index) == '('){
                min = min+1;
                max = max+1;
            }else if(s.charAt(index) == ')'){
                min = min-1;
                max = max-1;
            }else{

                //* case
                //since we are going to perform 3 cases ) -> -1, nothing -> 0 & ( -> 1
                //so min range will be min-1 and max range will be max+1
                min = min-1;
                max = max+1;
            }

            if(min < 0)
                min = 0;

            //Edge case : what if string starts with ) so min and max will be -1
            //So at any point if max range goes negative return false;
            if(max < 0)
                return false;
        }

        return min == 0;
    }

    public boolean checkValidString2(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = s.charAt(i) == '*';
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                char a = s.charAt(i), b = s.charAt(j);
                dp[i][j] = (a == '(' || a == '*') && (b == '*' || b == ')')
                        && (i + 1 == j || dp[i + 1][j - 1]);
                for (int k = i; k < j && !dp[i][j]; ++k) {
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
                }
            }
        }
        return dp[0][n - 1];
    }

    //TC : O(n^2)
    //SC : Auxiliary space : + O(n^2)

    public boolean checkValidString(String str, int index, int noOfOpening , int [][] dp){
        if(index == str.length()){
           return noOfOpening == 0;
        }

        if(noOfOpening < 0)
            return false;

        if(dp[index][noOfOpening] != -1)
                return dp[index][noOfOpening] == 1;

        boolean result = false;

        if(str.charAt(index) == '('){
            result =  checkValidString(str, index+1, noOfOpening+1,dp);
        }else if(str.charAt(index) == ')')	{
            result =  checkValidString(str,index+1, noOfOpening-1,dp);
        }else{

            result =
                    checkValidString(str, index+1, noOfOpening+1,dp) //Opening bracket
                            || checkValidString(str, index+1, noOfOpening-1,dp) //Clossing bracket

                            || checkValidString(str, index+1, noOfOpening,dp);
        }
        dp[index][noOfOpening] = result ? 1 : 0 ;
        return  result;
    }


    public boolean checkValidString1(String str){
        int n = str.length();
        int dp[][] = new int[n+1][n+1];

        //TODO Complete tabulation and space optimization.

        for (int index = n-1; index > 0; index--) {
            for (int noOfOpening = n-1; noOfOpening > 0; noOfOpening--) {
                boolean result =false;
                if(str.charAt(index) == '('){
                    result =  dp[index+1][noOfOpening+1] == 1;
                }else if(str.charAt(index) == ')')	{
                    result =  dp[index+1][ noOfOpening-1] == 1;
                }else{

                    result =
                            dp[index+1][ noOfOpening+1] ==1 //Opening bracket
                                    || dp[index+1][noOfOpening-1] ==1//Clossing bracket
                                    || dp[index+1][ noOfOpening] == 1;
                }

                dp[index][noOfOpening] = result ? 1 : 0;
            }
        }


        return  false;
    }

}
