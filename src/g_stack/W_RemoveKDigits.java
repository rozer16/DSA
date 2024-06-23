package g_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
*
* https://leetcode.com/problems/remove-k-digits/
*
Given string num representing a non-negative integer num, and an integer k,
 return the smallest possible integer after removing k digits from n
 *
 *
 Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
*
*
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200.
Note that the output must not contain leading zeroes.
*
*
*
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

* */
public class W_RemoveKDigits {

    public static void main(String[] args) {
        W_RemoveKDigits test = new W_RemoveKDigits();
        System.out.println(test.removeKdigits("10",1));
    }

    public String removeKdigits(String num, int k) {
        char [] arr= num.toCharArray();
        Deque<Integer> stack = new ArrayDeque();
        if(k==0){
            return num;
        }
        stack.push( arr[0]-'0');
        for(int i=1;i<num.length();i++){
            int currentNum = arr[i]-'0';
            while(!stack.isEmpty() && k> 0 && currentNum< stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(arr[i]-'0');
        }
        while(k>0){
            stack.pop();
            k--;
        }
        String result = "";

        while(!stack.isEmpty()){
            result = ""+stack.pop()+result;
        }
        int x = 0;
        while(result.length()> 0 && x < result.length() && result.charAt(x) == '0'){
            x++;
        }
        result = result.substring(x);
        return result == "" ? "0":result;
    }
}
