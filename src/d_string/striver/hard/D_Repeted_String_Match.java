package d_string.striver.hard;


/*
https://leetcode.com/problems/repeated-string-match/description/

Given two strings a and b, return the minimum number of times you should repeat string a
 so that string b is a substring of it. If it is impossible for to be a substring of a after repeating it,
 return -1.

Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".



Example 1:

Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
Example 2:

Input: a = "a", b = "aa"
Output: 2



For rabin karp algorithm,
https://www.youtube.com/watch?v=H4VrKHVG5qI


BASE : 100000 //To avoid overflow
PRIME : 31 //More bigger prime no, less collision
power = Prime No ^ (targetStrLen - 1)
Formula to calculate hash for given string : hash =( hash * PRIME + (s[i] - 'a') ) % BASE;
Formula to calculate hash for substring : hash = (hash - (s[i - len] - 'a') * power) % BASE;

* */
public class D_Repeted_String_Match {


    public int repeatedStringMatch(String a, String b) {
            if(a.equals(b))
                    return 0;


            String source = a;
            String target = b;

            int count = 0;

            while(source.length() < target.length()){
                count++;
                source += a;
            }

            if(source.equals(target))
                    return count;

            if(rabinKarp(source, target) != -1)
                return count;

            source += a;
            if(rabinKarp(source, target) != -1)
                return count+1;

            return -1;
    }


    private int rabinKarp(String text, String pattern) {
        int BASE = 100000;
        if (text.isEmpty() || pattern.isEmpty()) return -1;

        int patternLen = pattern.length();
        int power = 1;

        // Compute 31^(m-1) % BASE
        for (int i = 0; i < patternLen; i++) {
            power = (power * 31) % BASE;
        }

        // Compute hash of the target
        int patternHash = 0;
        for (int i = 0; i < patternLen; i++) {
            patternHash = (patternHash * 31 + pattern.charAt(i)) % BASE;
        }

        // Compute rolling hash for the source
        int textHash = 0;
        for (int i = 0; i < text.length(); i++) {
            textHash = (textHash * 31 + text.charAt(i)) % BASE;

            // Skip until we have the first m characters
            if (i < patternLen - 1) continue;

            // Remove the contribution of the character sliding out of the window
            if (i >= patternLen) {
                textHash = (textHash - (text.charAt(i - patternLen) * power) % BASE + BASE) % BASE;
            }

            // If hash codes match, verify the actual substring
            if (textHash == patternHash) {
                if (text.substring(i - patternLen + 1, i + 1).equals(pattern)) {
                    return i - patternLen + 1;
                }
            }
        }

        return -1;
    }
}
