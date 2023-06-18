package j_stack;

import java.util.Stack;

public class D_ImplementQueueUsingStack {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int val){
        input.push(val);
    }

    public int pop(){
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public Integer peek(){
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

}
