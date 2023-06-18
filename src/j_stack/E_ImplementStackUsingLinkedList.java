package j_stack;

import java.util.LinkedList;
import java.util.List;

public class E_ImplementStackUsingLinkedList {
    List<Integer> list;

    public E_ImplementStackUsingLinkedList(){
        list = new LinkedList<>();
    }

    public void push(int x){
        list.add(x);
    }

    public  int pop(){
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        return temp;
    }

    public int peek(){
        return  list.get(list.size()-1);
    }

    public void display(){
        for (int i = list.size()-1; i >=0 ; i--) {
            System.out.print(list.get(i)+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        E_ImplementStackUsingLinkedList test = new E_ImplementStackUsingLinkedList();
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
