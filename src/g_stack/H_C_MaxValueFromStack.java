package g_stack;

import java.util.Stack;

public class H_C_MaxValueFromStack {
    Stack<Long> stack;
    Long max = Long.MIN_VALUE;

    public H_C_MaxValueFromStack(){
        stack = new Stack<>();
    }

    /*
    *
        Peek val : -2147483648
        Max val : -2147483648
        peek val : -2147483648
        Max val : 2147483647
        Max val : -2147483648
    *
    * */
    public static void main(String[] args) {
        H_C_MaxValueFromStack test = new H_C_MaxValueFromStack();
        test.push(-2147483648);

        System.out.println("Peek val : "+test.peek());
        System.out.println("Max val : "+test.getMax());
        test.push(2147483647);
        System.out.println("peek val : "+test.peek());
        System.out.println("Max val : "+test.getMax());
        test.pop();
        System.out.println("Max val : "+test.getMax());
    }

    /*
    *
    * val > max
    *
    * */
    public void push(int val){
        Long val1 = Long.valueOf(val);
        if(stack.isEmpty()){
            stack.push(val1);
            max = val1;
            return;
        }

        /*
         * ==> val > max
         * ==> val - max > 0
         * ==> val + val - max > val
         * ==> 2val - max > val
         *
         * */
        if(val1 > max){
            stack.push(2*val1-max);
            max = val1;
            return;
        }
        stack.push(val1);
    }


    public void pop(){

        /*
        *
        * ==> 2*max-stack.peek()
        * ==> 2*max-(2*val - prevMax)
        * ==> 2*max-(2*max - prevMax)
        * ==> -(-prevMax)
        * ==> prevMax
        *
        *
        * */
        if(stack.peek() > max){
            max = 2*max-stack.peek();
        }
        stack.pop();
    }

    public  int peek(){
        if(stack.peek() > max){
            return  (int)(2*max-stack.peek());
        }
        return stack.peek().intValue();
    }

    public int getMax(){
        return max.intValue();
    }
}
