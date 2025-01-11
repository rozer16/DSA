package d_string.striver.easy;


import java.util.HashMap;
import java.util.Map;

/*

https://leetcode.com/problems/isomorphic-strings/
https://www.youtube.com/watch?v=ogTMIFPjNkQ


Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true



* */
public class E_Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        int index = 0;

        while(index < len){
            char original = s.charAt(index);
            char replace = t.charAt(index);

            if(!map.containsKey(original)){
                if(!map.containsValue(replace))
                    map.put(original, replace);
                else
                    return false ;
            }else{
                if(map.get(original) != replace)
                    return false;
            }
            index++;
        }

        return true;
    }
}
