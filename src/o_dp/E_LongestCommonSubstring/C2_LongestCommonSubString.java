package o_dp.E_LongestCommonSubstring;

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
        for (int index1 = 1; index1 <=n ; index1++) {
            int [] curr = new int[m+1];
            for (int index2 = 1; index2 <= m ; index2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if(str1.charAt(index1-1) == str2.charAt(index2-1)) {
                    curr[index2] = 1 + prev[index2 - 1];
                    max = Math.max(max,curr[index2]);
                }else{
                    curr[index2] = 0;
                }
            }
            prev = curr;
        }

        return max;
    }


    //Below solution is recursive and has exponential time complexity
    public int longestCommonSubstrRecursive(String s1, String s2, int n, int m, int count) {
        // Base case: If either string length is 0, return count
        if (n == 0 || m == 0) {
            return count;
        }

        // If characters match, increment count and recursively call function
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            count = longestCommonSubstrRecursive(s1, s2, n - 1, m - 1, count + 1);
        }

        // Explore options by recursively calling function with different indices and reset count
        int res = Math.max(count, Math.max(
                longestCommonSubstrRecursive(s1, s2, n - 1, m, 0),
                longestCommonSubstrRecursive(s1, s2, n, m - 1, 0)
        ));

        return res;
    }
}
