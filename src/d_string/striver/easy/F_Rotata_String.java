package d_string.striver.easy;

/*
https://leetcode.com/problems/rotate-string/description/

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.


Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false

* */
public class F_Rotata_String {


    public static void main(String[] args) {
        F_Rotata_String obj = new F_Rotata_String();
        System.out.println(obj.rotateString("abcde", "cdeab"));

    }
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal);
    }

    public boolean rotateString1(String s, String goal) {
        if(s.length() != goal.length())
            return false;

        int len = s.length();
        int index = findIndex(goal, s.charAt(0));
        if(index == -1)
            return false;

        for(int i=0; i< s.length();i++){
            if(s.charAt(i) != goal.charAt((i+index)%len)){
                System.out.println("i : "+i);
                System.out.println("index : "+index);
                System.out.println(s.charAt(i) + " "+goal.charAt((i+index)%len));
                return false;
            }
        }

        return true;
    }

    public int findIndex(String s, char ch){
        int len = s.length();

        for(int i=0; i< s.length();i++){
            if(s.charAt(i) == ch)
                return i;
        }

        return -1;
    }
}
