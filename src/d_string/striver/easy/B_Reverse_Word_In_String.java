package d_string.striver.easy;

import java.util.ArrayList;
import java.util.List;

public class B_Reverse_Word_In_String {

    public static void main(String[] args) {
        B_Reverse_Word_In_String obj = new B_Reverse_Word_In_String();
        System.out.println(obj.reverseWords("Let's take LeetCode contest"));//contest LeetCode take Let's
        System.out.println(obj.reverseWords("  hello world  "));//world hello
    }

    // Function to reverse every word in the given string
    public String reverseWords(String s) {
        int n = s.length(); // Length of string

        // List to store the words present in string
        List<String> words = new ArrayList<>();

        // Pointers to mark the start and end of a word
        int start, end;

        int i = 0;
        while (i < n) {

            // Finding the first character of a word (if any)
            while (i < n && s.charAt(i) == ' ') i++;

            // If no word is found, break
            if (i >= n) break;

            start = i; // Storing the index of first character of word

            // Finding the last character of the word
            while (i < n && s.charAt(i) != ' ') i++;

            end = i - 1; // Storing the index of last character of word

            // Add the found word to the list of words
            String wordFound = s.substring(start, end + 1);
            words.add(wordFound);
        }

        StringBuilder ans = new StringBuilder();

        // Adding all the words to result in the reverse order
        for (int j = words.size() - 1; j >= 0; j--) {
            ans.append(words.get(j));

            // Adding spaces in between words
            if (j != 0) ans.append(' ');
        }

        return ans.toString(); // Return the stored result
    }
}
