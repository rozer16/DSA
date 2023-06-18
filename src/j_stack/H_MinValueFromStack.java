package j_stack;


import java.util.Stack;

/*

Intuition
* While pushing -> Whatever modified value is always be lesser than minimum value
* ==> val < currMin
* ==> val - currMin < 0
* ==> val + val - currMin < val
* ==> 2val - currMin < val  --> Modified value =  2val - currMin
*

push -2 ==> min = -2
push 0 ==> min = 0
push -3 ==> min = -3 & push ((2*-3)-(-2))
        ==> min = -3 & push (-6-(-2))
        ==> min = -3 & push (-4)


* While popping
* ==> newMin = 2*min-stack.peek()    ==> 2*-3-(-4)
* ==>        = 2*min-(2*min-prevMin) ==> -6+4
*            = prevMin               ==> -2
*
* */
public class H_MinValueFromStack {
    Stack<Integer> stack ;
    int min;
    public H_MinValueFromStack(){
        stack = new Stack<>();
    }


    public static void main(String[] args) {
        H_MinValueFromStack test = new H_MinValueFromStack();
        test.push(-2);
        test.push(0);
        System.out.println(test.stack);
        System.out.println("Min val : "+test.min);
        test.push(-3);
        System.out.println("Min val : "+test.min);
        test.pop();
        System.out.println("Min val : "+test.min);
    }

    public void push(int val){
        if(stack.isEmpty()){
            min = val;
            stack.push(val);
            return;
        }
        if(val<min){
            stack.push(2*val-min);
            min = val;
            return;
        }
        stack.push(val);
    }

    public int pop(){
        if(stack.isEmpty())
            return -1;
        if(stack.peek() < min){
            int temp = min;
            min = (2*min)-stack.peek();
            stack.pop();
            return min;
        }
        return stack.pop();
    }



}
