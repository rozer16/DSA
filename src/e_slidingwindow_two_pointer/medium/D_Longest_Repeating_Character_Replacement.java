package e_slidingwindow_two_pointer.medium;


/*
https://www.youtube.com/watch?v=_eNhaDCr6P0
https://leetcode.com/problems/longest-repeating-character-replacement/description/


You are given a string s and an integer k.
 You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get
    after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
* */
public class D_Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        D_Longest_Repeating_Character_Replacement sol = new D_Longest_Repeating_Character_Replacement();
        System.out.println(sol.characterReplacement("AABABBA",1));
    }

    public int characterReplacement(String s, int k) {

        int maxLen = 0;
        char [] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int [] charFreq = new int[26];
        while(right < s.length()){
            charFreq[chars[right]-'A']++;
            maxFreq = Math.max(charFreq[chars[right]-'A'] , maxFreq);
            while((right-left+1)-maxFreq > k){
                charFreq[chars[left]-'A']--;


                //Calculating freq again
                maxFreq = 0;
                for(int fre : charFreq)
                    maxFreq = Math.max(maxFreq, fre);

                left++;
            }

            if((right-left+1)-maxFreq <= k)
                maxLen = Math.max(maxLen, right-left+1);

            right++;
        }

        return maxLen;
    }

    //Intuition : Keep track of max freq for e.g. AAABAA
    // No of chars to be replaced = (right-left+1)-freq of A = No of non A occurrence
    public int characterReplacementBF(String s, int k) {
        int maxLen = 0;
        char [] chars = s.toCharArray();

        for(int i = 0; i< s.length(); i++){
            int maxFreq = 0;
            int [] charFreq = new int[26];
            for(int j = i; j< s.length(); j++){
                charFreq[chars[j]-'A']++;
                maxFreq = Math.max(maxFreq, charFreq[chars[j]-'A']);
                int noOfCharsTobeReplaced = j-i+1 - maxFreq;

                if(noOfCharsTobeReplaced <= k)
                    maxLen = Math.max(j-i+1, maxLen);

                if(noOfCharsTobeReplaced > k){
                    break;
                }

            }
        }

        return maxLen;
    }
}
