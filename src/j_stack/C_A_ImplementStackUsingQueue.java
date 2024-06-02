package j_stack;


import java.util.LinkedList;
import java.util.Queue;

/*
* https://leetcode.com/problems/implement-stack-using-queues/
* https://youtu.be/jDZQKzEtbYQ
* Steps :
*
* 1) Add n --> Q2
* 2) Q1 --> Q2 (Element by element)
* 3) suffle(Q1  <--> Q2)
*
* Queue : top to bottom
* Stack : Bottom to top
*
*
* */
public class C_A_ImplementStackUsingQueue {


    B_QueueImplUsingArray q1 = new B_QueueImplUsingArray(10);
    B_QueueImplUsingArray q2 = new B_QueueImplUsingArray(10);


    public void push(int val){
        q2.push(val);
        while(q1.size() != 0){
            q2.push(q1.pop());
        }

        B_QueueImplUsingArray temp = q1;
        q1=q2;
        q2=temp;
    }
    public void pop(){
        q1.pop();
    }
    public void peek(){
        q1.pop();
    }

    public void display(){
        q1.display();
    }

    public static void main(String[] args) {

        C_A_ImplementStackUsingQueue test = new C_A_ImplementStackUsingQueue();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.display();
        test.pop();
        test.display();
    }
}

class MyStack {

    Queue<Integer> q1;
    public MyStack() {
        q1= new LinkedList<>();

    }

    public void push(int x) {
        System.out.println("Entry push");
        q1.add(x);
        for (int i = 0; i <q1.size()-1; i++) {
            q1.add(q1.peek());
            q1.remove(q1.peek());
        }
        System.out.println("Exit push");
    }

    public int pop() {
        System.out.println("Popping");
        return q1.remove();
    }

    public int top() {
        return q1.peek();

    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
/*
*

Queue :
4	3	2	1	Front : 2 Rear : 6
Popped element : 4
Queue :
3	2	1	Front : 3 Rear : 6


* *
* */
