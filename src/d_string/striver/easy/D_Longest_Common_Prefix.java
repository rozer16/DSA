package d_string.striver.easy;


/*

https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.



* */
public class D_Longest_Common_Prefix {

    public static void main(String[] args) {
        D_Longest_Common_Prefix obj = new D_Longest_Common_Prefix();
        System.out.println(obj.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));//fl
        System.out.println(obj.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));//""
    }

   public String longestCommonPrefix(String[] strs) {
    // Get the number of strings in the array
    int n = strs.length;

    // Iterate through each character of the first string
    for (int i = 0; i < strs[0].length(); i++) {
        // Get the current character from the first string
        char c = strs[0].charAt(i);

        // Compare the current character with the corresponding character in all other strings
        for (int j = 0; j < n; j++) {
            // If the current index is equal to the length of any string, return the substring up to this point
            if (i == strs[j].length()) {
                return strs[0].substring(0, i);
            }

            // If the current character does not match, return the substring up to this point
            if (c != strs[j].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }
    }

    // If the loop completes, the entire first string is the common prefix
    return strs[0];
}
}
