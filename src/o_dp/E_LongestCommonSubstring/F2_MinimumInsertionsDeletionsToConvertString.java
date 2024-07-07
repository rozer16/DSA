package o_dp.E_LongestCommonSubstring;

public class F2_MinimumInsertionsDeletionsToConvertString {


    public static void main(String[] args) {

        F2_MinimumInsertionsDeletionsToConvertString solution = new F2_MinimumInsertionsDeletionsToConvertString();


        String word1 = "sea", word2 = "eat";
        System.out.println("Word1 : "+word1+" Word2 : "+word1+" Min no of insertion/Del required to make word1==word2 : "+solution.longestCommonSubSequenceLength(word1,word2));


        word1 = "leetcode";
        word2 = "etco";
        System.out.println("Word1 : "+word1+" Word2 : "+word1+" Min no of insertion/Del required to make word1==word2 : "+solution.minDistance(word1,word2));

    }

    public int minDistance(String word1, String word2) {
        return (Math.abs(word1.length()-word2.length())*2)-longestCommonSubSequenceLength(word1,word2);
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
