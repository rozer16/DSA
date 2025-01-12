package d_string.striver.hard;


/*

https://leetcode.com/problems/shortest-palindrome/description/

https://takeuforward.org/plus/dsa/strings--advanced-algo/advanced-problems-(less-asked)/shortest-palindrome


You are given a string s. You can convert s to a
palindrome
 by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.


Intuition  ;
The problem involves converting a given string into a palindrome by adding characters to the beginning of the string.
The goal is to determine the minimum number of characters that need to be added to achieve this.

The solution leverages the Longest Prefix Suffix (LPS) array,
which captures the length of the longest prefix of a string that is also a suffix.
By combining the string and its reverse with a delimiter, the LPS array helps identify the largest palindromic prefix in the string.
 This ensures the minimum number of characters are added to the front to complete the palindrome.

The reverse of the string plays a critical role, as it determines the characters that are missing to form a palindrome when compared to the original string.



* */
public class G_Add_Min_Char_To_Make_String_Palindrom {


    public static void main(String[] args) {
        G_Add_Min_Char_To_Make_String_Palindrom obj = new G_Add_Min_Char_To_Make_String_Palindrom();
        System.out.println(obj.shortestPalindrome("aacecaaa"));//aaacecaaa
        System.out.println(obj.shortestPalindrome("abcd"));//dcbabcd
    }

    public String shortestPalindrome(String s) {
        // Reverse the input string
        String rev = reverse(s);

        // Create a new string by appending the original string, a delimiter, and the reversed string
        StringBuilder s1 = new StringBuilder();
        s1.append(s);
        s1.append("$");
        s1.append(rev);

        // Calculate the number of characters to add to the front to make the string a palindrome
        int noOfMissingChars = s.length() - getLPS(s1.toString());
        String toAdd = rev.substring(0, noOfMissingChars);

        // Return the shortest palindrome by adding the necessary characters to the front
        return toAdd + s;
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

    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        // Swap characters from the start and end until the middle is reached
        while (left <= right) {
            char c1 = chars[left];
            chars[left] = chars[right];
            chars[right] = c1;

            left++;
            right--;
        }

        // Return the reversed string
        return new String(chars);
    }
}
