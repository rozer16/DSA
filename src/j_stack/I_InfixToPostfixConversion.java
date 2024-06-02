package j_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
* 
a)) Scan the infix expression from left to right
b)) If the scanned character is an operand, put it in the postfix expression
    Otherwise, do the following
c)) If the precedence and associativity of the scanned operator are greater than the precedence
    and associativity of the operator in the stack [or the stack is empty or the stack
    contains a ‘(‘ ], then push it in the stack)
    [‘^‘ operator is right associative and other operators like ‘+‘,’–‘,’*‘ and ‘/‘
    are left-associative]))
d)) Check especially for a condition when the operator at the top of the stack and
    the scanned operator both are ‘^‘)) In this condition, the precedence of the scanned operator
    is higher due to its right associativity)) So it will be pushed into the operator stack
e)) In all the other cases when the top of the operator stack is the same as the scanned operator,
    then pop the operator from the stack because of left associativity due to which the scanned
    operator has less precedence Else, Pop all the operators from the stack which are greater than
    or equal to in precedence than that of the scanned operator
f)) After doing that Push the scanned operator to the stack (If you encounter parenthesis while popping
    then stop there and push the scanned operator in the stack)
h)) If the scanned character is a ‘(‘, push it to the stack
i)) If the scanned character is a ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis
j)) Repeat steps 2-5 until the infix expression is scanned
k)) Once the scanning is over, Pop the stack and add the operators in the postfix expression until it is not empty
l)) Finally, print the postfix expression
* 
* 
* */
public class I_InfixToPostfixConversion {


    public static void main(String[] args) {
        I_InfixToPostfixConversion test = new I_InfixToPostfixConversion();
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(test.infixToPostfix(infix)); //abcd^e-fgh*+^*+i-
    }
    public int getPrecedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public String infixToPostfix(String exp){
        StringBuilder str = new StringBuilder();

        // Initializing empty stack
        Deque<Character> stack
                = new ArrayDeque<Character>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c)){
                str.append(c);
            }else if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    str.append(stack.pop());
                }
                stack.pop();
            }else{
                //An operator is encountered

                //If newly encounters operator has less or equal precedence than top of the stack
                while(!stack.isEmpty() && ( getPrecedence(c) <= getPrecedence(stack.peek())) ){
                    str.append(stack.pop());
                }
                //Either of case newly encountered operator has high or low precedence than top of the stack, push
                stack.push(c);
            }


        }
        // Pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Infix expression";
            str.append(stack.pop());
        }

        return str.toString();
    }
}
