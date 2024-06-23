package n_dp.E_LongestCommonSubstring;

public class G2_ShortestCommonSupersequence {

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        G2_ShortestCommonSupersequence solution = new G2_ShortestCommonSupersequence();
        System.out.println("shortestCommonSupersequence : "+solution.shortestCommonSupersequence(str1, str2));
    }


    /*
     Time Complexity: O(N*M)

        Reason: There are two nested loops

        Space Complexity: O(N*M)

        Reason: We are using an external array of size (N*M).
     * */
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int [][] dp = new int[n+1][m+1];

        for(int ind1 = 1; ind1<= n; ind1++){
            for(int ind2=1; ind2 <= m; ind2++){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1+dp[ind1-1][ind2-1];
                }else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }

            }
        }


        String result = "";
        int ind1=n;
        int ind2=m;
        while(ind1 > 0 && ind2>0 ){
            if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
                result += str1.charAt(ind1-1);
                ind1--;
                ind2--;
            }else if(dp[ind1-1][ind2] > dp[ind1][ind2-1]){
                result += str1.charAt(ind1-1);
                ind1--;

            }else{
                result += str2.charAt(ind2-1) ;
                ind2--;
            }
        }
        while(ind1>0){
            result += str1.charAt(ind1-1);
            ind1--;
        }
        while(ind2>0){
            result += str2.charAt(ind2-1);
            ind2--;
        }

        return new StringBuilder(result).reverse().toString();

    }

}
