package e_slidingwindow_two_pointer.medium;

import java.util.Arrays;

/*
https://www.youtube.com/watch?v=xtqN4qlgr8s
https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/


Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1


Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
* */
public class G_No_Of_Substrings_Containing_All_Three_Characters {
    public static void main(String[] args) {
        G_No_Of_Substrings_Containing_All_Three_Characters sol = new G_No_Of_Substrings_Containing_All_Three_Characters();
        System.out.println(sol.numberOfSubstrings("abcabc")); //10
    }



    //TC : O(n)
    //SC : O(1)

    public int numberOfSubstrings(String s) {
        int [] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);

        int n = s.length();
        char [] chars = s.toCharArray();
        int index = 0;
        int cnt = 0;
        while(index < n){
            lastSeen[chars[index]-'a'] = index;

            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                int start = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                cnt += start+1;
            }
            index++;
        }

        return cnt;
    }
    //TC : O(n^2)
    //SC : O(1)
    public int numberOfSubstringsBF(String s) {
        int result = 0;
        int n = s.length();
        int [] hash = new int[3];
        char [] chars = s.toCharArray();
        for(int i = 0; i<n; i++){
            hash = new int[3];

            for(int j = i; j<n; j++){
                hash[chars[j]-'a'] = 1;

                if(hash[0] + hash[1] + hash[2] == 3){
                    result = result + n - j ;
                    break;
                }
            }
        }
        return result;
    }
}
