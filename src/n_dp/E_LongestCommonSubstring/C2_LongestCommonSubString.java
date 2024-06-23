package n_dp.E_LongestCommonSubstring;

public class C2_LongestCommonSubString {

    public static void main(String[] args) {
        String s1 = "tyfg";
        String s2 = "cvbnuty";

        System.out.println(new C2_LongestCommonSubString().longestCommonSubString(s1,s2));
    }


    public  int longestCommonSubString(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        // Create arrays to store the LCS lengths
        int [] prev = new int[m+1];
        int max = 0;
        for (int ind11 = 1; ind11 <=n ; ind11++) {
            int [] curr = new int[m+1];
            for (int ind22 = 1; ind22 <= m ; ind22++) {

                // If the characters at the current indices are the same, increment the LCS length
                if(str1.charAt(ind11-1) == str2.charAt(ind22-1)) {
                    curr[ind22] = 1 + prev[ind22 - 1];
                    max = Math.max(max,curr[ind22]);
                }



            }
            prev = curr;
        }

        return max;
    }
}
