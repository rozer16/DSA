package h_slidingwindow_two_pointer.hard;

import java.util.HashMap;
import java.util.Map;


/*

https://youtu.be/teM9ZsVRQyc

https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/

340. Longest Substring with At Most K Distinct Characters
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
* */
public class A_Longest_Substring_With_At_Most_K_Distinct_Characters {

    public static void main(String[] args) {
        A_Longest_Substring_With_At_Most_K_Distinct_Characters sol = new A_Longest_Substring_With_At_Most_K_Distinct_Characters();
        System.out.println(sol.findLongestSubStrWithAtMostKDistinctCharacter("eceba",2));
        System.out.println(sol.findLongestSubStrWithAtMostKDistinctCharacter("aa",1));
        System.out.println(sol.findLongestSubStrWithAtMostKDistinctCharacter("aabbcc",1));
        System.out.println(sol.findLongestSubStrWithAtMostKDistinctCharacter("pqpqs",2));

    }


    // TC : O(n) + O(n)
    public int findLongestSubStrWithAtMostKDistinctCharacter(String s, int k){
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int max = 0;
        int n = s.length();
        char [] chars = s.toCharArray();

        while(right < n){
            if(map.containsKey(chars[right])){
                map.put(chars[right] , map.get(chars[right])+1);
            }else{
                map.put(chars[right],1);
            }

            if(map.size() > k){
                int curr = map.get( chars[left]);
                if(curr == 1){
                    map.remove(chars[left]);
                }else{
                    map.put(chars[left] , map.get(chars[left])+1);
                }
                left++;
            }

            if(map.size() <= k)
                max = Math.max(right - left +1, max);

            right++;
        }

        return max;
    }
}
