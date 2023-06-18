package j_stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class F_ImplmentQueueUsingLinkedList {
    List<Integer> list;

    public F_ImplmentQueueUsingLinkedList(){
        list = new LinkedList<>();
    }

    public void push(int val){
        list.add(val);
    }

    public int pop(){
        return list.remove(0);
    }

    public int peek(){
        return list.get(0);
    }

    public void display(){
        for (int i = 0; i < list.size() ; i++) {
            System.out.print(list.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        F_ImplmentQueueUsingLinkedList test = new F_ImplmentQueueUsingLinkedList();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.display();
        test.peek();
        test.pop();
        test.display();

    }
}
