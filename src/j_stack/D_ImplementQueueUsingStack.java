package j_stack;

import java.util.Stack;

/*
//Using two stack
1) take two stacks s1, s2
2) if push
    2.1) first transfer all ele from s1 -> s2
    2.2) push newEle to s1
    2.3) push all ele from s2 -> s1


*/
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
