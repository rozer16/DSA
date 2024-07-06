import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;



public class Test{

    //Deque : DLL elements can be added/removed/accessed from front as well as back

    //Stack : LIFO  push pollLast  peekLast
    //Queue : FIFO : offer pop/poll peek/peekFirst
    public static void main(String[] args) throws InterruptedException {
      Deque<Integer> deque = new ArrayDeque<>();
      deque.offer(1);
        deque.offer(2);
        deque.offer(3);


        deque.push(5);
    }

    static Node deleteAllOccurOfX(Node head, int x) {
        Node d = new Node(0);

        Node curr = head;
        curr.prev = d;
        d.next = curr;


        while(curr != null){
            if(curr.data == x){
                Node temp = curr.next;
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;

                curr.next = null;
                curr.prev = null;
                curr = temp;
            }

        }

        Node newHead = d.next;
        newHead.prev = null;
        d.next = null;
        return newHead;
    }



}

class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}