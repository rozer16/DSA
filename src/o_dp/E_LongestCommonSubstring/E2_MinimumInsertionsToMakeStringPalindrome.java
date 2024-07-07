package o_dp.E_LongestCommonSubstring;

public class E2_MinimumInsertionsToMakeStringPalindrome {

    public static void main(String[] args) {
        String str1 = "mbadm";
        String str2 = "mdabm";
        E2_MinimumInsertionsToMakeStringPalindrome solution = new E2_MinimumInsertionsToMakeStringPalindrome();
        System.out.println("Min no of insertion required to make string palindrom :"+solution.minInsertions(str1));
    }

    public int minInsertions(String s) {
        String str2  = new StringBuilder(s).reverse().toString();


        return s.length()-longestCommonSubSequenceLength(s,str2);

    }
    public int longestCommonSubSequenceLength(String str1, String str2){
        int n = str1.length();
        int m = str2.length();


        int [] prev = new int[m+1];


        for (int ind1 = 1; ind1 <= n; ind1++) {
            int [] curr = new int[m+1];
            for (int ind2 = 1; ind2 <= m ; ind2++) {

                if(str1.charAt(ind1-1) == str2.charAt(ind2-1))
                    curr[ind2] =  1 + prev[ ind2 - 1];
                else

                    curr[ind2]  =  Math.max(
                            prev[ ind2],
                            curr[ ind2-1]
                    );
            }
            prev= curr;
        }
        return prev[m];

    }

}


