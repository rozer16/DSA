package d_string.striver.hard;


/*
https://leetcode.com/problems/longest-happy-prefix/description/

https://takeuforward.org/plus/dsa/strings--advanced-algo/advanced-problems-(less-asked)/longest-happy-prefix?tab=submissions
* */
public class H_Longest_Happy_Prefix {

    public static void main(String[] args) {
        H_Longest_Happy_Prefix obj = new H_Longest_Happy_Prefix();
        System.out.println(obj.longestPrefix("level"));//le
        System.out.println(obj.longestPrefix("ababab"));//abab
    }
    public String longestPrefix(String s) {
        return s.substring(0, getLPS(s));
    }

    public int getLPS(String text) {
        int n = text.length();
        int lps[] = new int[n];
        int left = 0;
        int right = 1;

        // Loop to calculate the LPS array
        while (right < n) {
            if (text.charAt(left) == text.charAt(right)) {
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

        // Return the last value of the LPS array, which represents the longest prefix which is also a suffix
        return lps[n - 1];
    }

}
