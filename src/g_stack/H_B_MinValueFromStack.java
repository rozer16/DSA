package g_stack;


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

TC : O(N)
SC : O(N)
* */



/*
Input : ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

output   : [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483647,-2147483648,null,-2147483648]
Expected : [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]


* */
public class H_B_MinValueFromStack {
    Stack<Long> stack ;
    Long min=Long.MAX_VALUE;


    public H_B_MinValueFromStack(){
        stack = new Stack<>();
    }


    public static void main(String[] args) {
        H_B_MinValueFromStack test = new H_B_MinValueFromStack();
        int x = -2147483648;
        System.out.println(x);
        test.push(2147483647);
        System.out.println("Min val : "+test.peek());
        System.out.println("Min val : "+test.min);
        test.push(-2147483648);
        System.out.println("peek val : "+test.peek());
        System.out.println("Min val : "+test.min);
        test.pop();
        System.out.println("Min val : "+test.min);


    }

    public void push(int val){
        Long val1 = Long.valueOf(val);
        if(stack.isEmpty()){
            min = val1;
            stack.push(val1);
            return;
        }
        if(val<min){
            stack.push((2*val1)-min);
            min = val1;
            return;
        }
        stack.push(val1);
    }

    public void pop(){
        if(stack.isEmpty())
            return ;
        if(stack.peek() < min){
            long temp = min;
            min = (2*min)-stack.peek();
            stack.pop();
            if(stack.isEmpty())
                min = Long.MAX_VALUE;
            return ;
        }
        stack.pop();
    }

    public int peek() {
        if(stack.peek() < min){
            return min.intValue();
        }
        return stack.peek().intValue();
    }



}
