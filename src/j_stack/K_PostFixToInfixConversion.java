package j_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class K_PostFixToInfixConversion {
    public static void main(String[] args) {
        String postfix = "abcd^e-fgh*+^*+i-";
        String postfix1 =  "ab*c+";
        K_PostFixToInfixConversion test = new K_PostFixToInfixConversion();
        System.out.println(test.postFixtoInfixConverter(postfix));
    }

    public String postFixtoInfixConverter(String s){
        Deque<String> stack
                = new ArrayDeque<String>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            }else if(isOperator(c)){
                String temp1 = stack.pop();
                String temp2 = stack.pop();
                String temp3 = "("+temp2+c+temp1+")";
                stack.push(temp3);
            }else{
                return "Invalid Postfix Expression";
            }
        }
        return stack.peek();
    }

    public boolean isOperator(char x)
    {

        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
            case '^':
                return true;
        }
        return false;
    }
}
