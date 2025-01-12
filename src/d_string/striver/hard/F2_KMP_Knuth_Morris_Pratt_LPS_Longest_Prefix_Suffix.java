package d_string.striver.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F2_KMP_Knuth_Morris_Pratt_LPS_Longest_Prefix_Suffix {
    public static void main(String[] args) {
        F2_KMP_Knuth_Morris_Pratt_LPS_Longest_Prefix_Suffix obj = new F2_KMP_Knuth_Morris_Pratt_LPS_Longest_Prefix_Suffix();
        System.out.println(Arrays.toString(obj.computeLPSBrute("abacabab")));//[0, 0, 1, 0, 1, 2, 3, 2]
        System.out.println(Arrays.toString(obj.computeLPSBrute("aaaa")));//[0, 0, 1, 2]
        System.out.println(Arrays.toString(obj.computeLPSBrute("abc"))); //[0, 0, 0]

        System.out.println(Arrays.toString(obj.computeLPSArray("leetcode@abcdleetcode")));//[0, 0, 1, 0, 1, 2, 3, 2]
    }


    public List<Integer> search(String pattern, String text) {
        String s = pattern + '$' + text; // Combined string

        // Function call to find the LPS array for the combined string
        int[] LPS = computeLPSArray(s);

        // Length of pattern and text
        int n = text.length(), m = pattern.length();

        // To store the result
        List<Integer> ans = new ArrayList<>();

        // Iterate on the combined string after the delimiter
        for (int i = m + 1; i < s.length(); i++) {
            if (LPS[i] == m) ans.add(i - 2 * m);
        }

        return ans;
    }

    /*
    Time Complexity: O(N^3) (where N is the length of the combined string)
    Computing the LPS array takes O(N3) time and finding the matches requires iterating on the LPS taking O(N) time.

        Space Complexity: O(N), to store the LPS array.
    * */
    private int[] computeLPSBrute(String s) {
        int n = s.length(); // size of string

        // To store the longest prefix suffix
        int[] LPS = new int[n];

        // Iterate on the string
        for (int i = 1; i < n; i++) {

            // For all possible lengths
            for (int len = 1; len < i; len++) {
                if (s.substring(0, len).equals(s.substring(i - len + 1, i + 1))) {
                    LPS[i] = len;
                }
            }
        }

        return LPS; // Return the computed LPS array
    }

   private static int[] computeLPSArray(String pattern) {
    int length = pattern.length(); // Length of the pattern
    int[] lps = new int[length]; // Array to store the LPS values
    int left = 0; // Length of the previous longest prefix suffix
    int right = 1; // Current position in the pattern

    // Loop to calculate lps[right] for right = 1 to length-1
    while (right < length) {
        if (pattern.charAt(right) == pattern.charAt(left)) {
            // If characters match, increment left and set lps[right]
            left++;
            lps[right] = left;
            right++;
        } else {
            // If characters do not match
            if (left != 0) {
                // Set left to the value of lps of the previous character
                left = lps[left - 1];
            } else {
                // If left is 0, set lps[right] to 0 and move to the next character
                lps[right] = 0;
                right++;
            }
        }
    }
    return lps; // Return the computed LPS array
}


}


