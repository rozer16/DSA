package j_stack;


/*
*
*  https://leetcode.com/problems/implement-stack-using-queues/
 * https://youtu.be/jDZQKzEtbYQ
 *
* */
public class C_B_ImplementStackUsingQueue {

    B_QueueImplUsingArray q = new B_QueueImplUsingArray(10);

    public void push(int val){
        q.push(val);
        for (int i = 0; i <q.size()-1; i++) {
            q.push(q.pop());
        }
    }

    public void pop(){
        q.pop();
    }

    public void display(){
        q.display();
    }

    public void peek(){
        q.peek();
    }

    public static void main(String[] args) {
        C_B_ImplementStackUsingQueue test = new C_B_ImplementStackUsingQueue();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.display();
        test.pop();
        test.display();
    }

}
