package g_stack;
/*
*  https://leetcode.com/problems/implement-stack-using-queues/
 * https://youtu.be/jDZQKzEtbYQ
*
* */
import java.util.LinkedList;
import java.util.Queue;

public class C_C_ImplementStackUsingQueue {
    Queue<Integer> q1;

    public C_C_ImplementStackUsingQueue(){
        q1 = new LinkedList<>();
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

    public static void main(String[] args) {
        C_C_ImplementStackUsingQueue test = new C_C_ImplementStackUsingQueue();
        test.push(2);
        test.push(3);
        test.push(4);
        System.out.println(test.q1);
    }

}
