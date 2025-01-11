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


        for (int index1 = 1; index1 <= n; index1++) {
            int [] curr = new int[m+1];
            for (int index2 = 1; index2 <= m ; index2++) {

                if(str1.charAt(index1-1) == str2.charAt(index2-1))
                    curr[index2] =  1 + prev[ index2 - 1];
                else

                    curr[index2]  =  Math.max(
                            prev[ index2],
                            curr[ index2-1]
                    );
            }
            prev= curr;
        }
        return prev[m];

    }

}


