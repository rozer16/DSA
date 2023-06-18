package j_stack;



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
/*
*

Queue :
4	3	2	1	Front : 2 Rear : 6
Popped element : 4
Queue :
3	2	1	Front : 3 Rear : 6


* *
* */
