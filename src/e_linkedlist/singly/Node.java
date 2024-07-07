package e_linkedlist.singly;

public class Node{
    int data;
    Node next;
    Node(){

    }

    Node(int x){
        data = x;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +

                '}';
    }
}
