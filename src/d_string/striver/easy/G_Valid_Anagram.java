package d_string.striver.easy;


/*
https://leetcode.com/problems/valid-anagram/description/

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
using all the original letters exactly once.

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

* */
public class G_Valid_Anagram {


    public static void main(String[] args) {
        G_Valid_Anagram obj = new G_Valid_Anagram();
        System.out.println(obj.isAnagram("anagram", "nagaram"));//true
        System.out.println(obj.isAnagram("rat", "car"));//false
    }

    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a'] += 1;
        }
        for(char ch : t.toCharArray()){
            freq[ch-'a'] -= 1;
        }
        for(int i : freq){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
