package k_recursion.Z_extra;

import java.util.Stack;

/*

https://leetcode.com/problems/decode-string/


Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



        Example 1:

        Input: s = "3[a]2[bc]"
        Output: "aaabcbc"
        Example 2:

        Input: s = "3[a2[c]]"
        Output: "accaccacc"
        Example 3:

        Input: s = "2[abc]3[cd]ef"
        Output: "abcabccdcdcdef"



 */
public class I_DecodeString {


    public static void main(String[] args) {
        I_DecodeString test = new I_DecodeString();
        System.out.println(test.decodeString("100[leetcode]"));


    }

    public String decodeString(String s) {
        Stack<Integer> is = new Stack<>();
        Stack<StringBuilder> ss = new Stack<>();

        int n = s.length(), num = 0;
        StringBuilder str = new StringBuilder();

        for(char ch : s.toCharArray()) {
            // There will be 4 types of characters --> number, [ , ], character

            if(ch >= '0' && ch <= '9') {
                num = (num * 10) + ch - '0';
            } else if(ch == '[') {
                ss.push(str);
                str = new StringBuilder();

                is.push(num);
                num = 0;
            } else if(ch == ']') {
                StringBuilder temp = str;
                str = ss.pop();
                int count = is.pop();

                while(count-- > 0) {
                    str.append(temp);
                }
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }


    public String decodeString1(String str){
        if(!str.contains("[")){
            return str;
        }


        int bp = 0;
        int fp = 1;
        while(fp < str.length()){
            if(str.charAt(fp) == '['){
                bp = fp;
                fp++;
                while(fp<str.length() && str.charAt(fp) != ']' && str.charAt(fp) != '['){
                    fp++;
                }
                if(str.charAt(fp) == ']'){
                    String strToBeRepeated = str.substring(bp+1,fp);
                    Integer repeatCount = getCount(str,bp-1);
                    String repeated = repeatString(strToBeRepeated,repeatCount);
                    String str1 = replaceStringWithOther(str,str.substring(bp-String.valueOf(repeatCount).length(),fp+1),repeated);
                    return decodeString(str1);

                }
            }else{
                fp++;
            }
        }



       return null;
    }

    private Integer getCount(String str, int i) {
        int fp = i;
        while( i>=0 && str.charAt(i) >= 48 && str.charAt(i)<= 57){
            i--;
        }
        return Integer.parseInt(str.substring(i+1,fp+1));
    }

    public String repeatString(String str, int no){
        String result = "";
        while(no>0){
            result+=str;
            no--;
        }
        return result;
    }

    public String replaceStringWithOther(String original,String old,String newStr){
        return original.replace(old,newStr);
    }
}
