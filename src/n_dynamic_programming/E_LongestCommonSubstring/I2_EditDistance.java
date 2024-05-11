package n_dynamic_programming.E_LongestCommonSubstring;

public class I2_EditDistance {

    public static void main(String[] args) {

    }


    public int minDistanceMemoization(String word1, String word2, int index1, int index2) {

        if(index1 == 0){
            //we will have to insert 0-index2 length string from word2 to word1
            return index2;
        }

        if(index2 == 0) {
            //Will have to delete characters from index1 to 0 from word1
            return index1;
        }

        //if they are matched
        if(word1.charAt(index1-1) == word2.charAt(index2-1))
            return minDistanceMemoization(word1, word2, index1-1, index2-1);


        //If character is not matching then try to match using below there opearation and take min of them

        int insersion = 1 + minDistanceMemoization(word1,word2,index1, index2-1);



        int deletion = 1+minDistanceMemoization(word1,word2,index1-1, index2);

        int replace = 1 + minDistanceMemoization(word1,word2, index1-1, index2-1);

        return  Math.min(insersion, Math.min(deletion,replace));

    }

    public int minDistanceTabulation(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();


        int [][] dp = new int[n+1][m+1];

        for(int index2 = 0; index2 <=m ; index2++ )
            dp[0][index2] = index2;


        for(int index1 = 0; index1 <=n ; index1++ )
            dp[index1][0] = index1;


        for(int index1=1; index1 <= n; index1++){
            for(int index2=1; index2 <= m; index2++){
                if(word1.charAt(index1-1) == word2.charAt(index2-1)){
                    dp[index1][index2] = dp[index1-1][ index2-1];
                }else{
                    int insersion = 1 + dp[index1][ index2-1];
                    int deletion = 1+dp[index1-1] [index2];
                    int replace = 1 + dp[index1-1][index2-1];
                    dp[index1][index2] =   Math.min(insersion, Math.min(deletion,replace));
                }
            }
        }

        return dp[n][m];
    }

    public int minDistanceSpaceOptimization(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();


        int []prev = new int[m+1];

        for(int index2 = 0; index2 <=m ; index2++ )
            prev[index2] = index2;

        for(int index1=1; index1 <= n; index1++){
            int [] curr = new int[m+1];
            curr[0] = index1;
            for(int index2=1; index2 <= m; index2++){
                if(word1.charAt(index1-1) == word2.charAt(index2-1)){
                    curr[index2] = prev[ index2-1];
                }else{
                    int insersion =  curr[ index2-1];
                    int deletion = prev[index2];
                    int replace = prev[index2-1];
                    curr[index2] =   1+ Math.min(insersion, Math.min(deletion,replace));
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}
