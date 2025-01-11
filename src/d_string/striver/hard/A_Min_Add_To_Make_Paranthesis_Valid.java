package d_string.striver.hard;


/**
 <a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/">LEETCODE</a>

 A parentheses string is valid if and only if:

 It is the empty string,
 It can be written as AB (A concatenated with B), where A and B are valid strings, or
 It can be written as (A), where A is a valid string.
 You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

 For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 Return the minimum number of moves required to make s valid.



 Example 1:

 Input: s = "())"
 Output: 1
 Example 2:

 Input: s = "((("
 Output: 3
 * */
public class A_Min_Add_To_Make_Paranthesis_Valid {

    public int minAddToMakeValid(String s) {
    int open = 0;  // Count of unmatched opening parentheses
    int close = 0; // Count of unmatched closing parentheses

    for(int i = 0; i < s.length(); i++) {
        if(s.charAt(i) == '(') {
            open++;  // Increment count for an opening parenthesis
        } else {
            if(open >= 1) {
                open--;  // Match a closing parenthesis with an unmatched opening parenthesis
            } else {
                close++; // Increment count for an unmatched closing parenthesis
            }
        }
    }

    // The total number of unmatched parentheses is the sum of unmatched opening and closing parentheses
    return open + close;
}
}
