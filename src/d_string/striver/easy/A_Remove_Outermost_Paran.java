package d_string.striver.easy;


/*

https://leetcode.com/problems/remove-outermost-parentheses/description/


problem :
A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.


* */
public class A_Remove_Outermost_Paran {

    public static void main(String[] args) {
        A_Remove_Outermost_Paran obj = new A_Remove_Outermost_Paran();
        //System.out.println(obj.removeOuterParentheses("(()())(())"));//()()()
        System.out.println(obj.removeOuterParentheses("(()())(())(()(()))"));//()()()()(())
    }

    /*
    The logic of the provided code is to remove the outermost parentheses of every primitive valid parentheses string
     in the given string s.

     The key idea is to use the open counter to track the depth of the parentheses and only append those parentheses that are not the outermost ones.
      This approach ensures that only the inner parentheses are included in the final result,
      effectively removing the outermost parentheses of every primitive valid parentheses string.
      By doing so, the algorithm maintains the structure of the valid parentheses strings while excluding the outermost layer
    * */
    public String removeOuterParentheses(String s) {
        if(s.length() <=2)
            return "";

        StringBuilder resultTemp = new StringBuilder();
        char [] c = s.toCharArray();
        int open = 1;

        for(int i = 1; i<s.length(); i++){
            if(c[i] == '('){
                open++;
                if(open >1)
                    resultTemp.append("(");
            }else{
                if(open > 1)
                    resultTemp.append(")");
                open--;
            }

        }

        return resultTemp.toString();
    }
}
