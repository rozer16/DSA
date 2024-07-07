package e_linkedlist.singly;



public class H_DetectLoop {

    public boolean detectLoop(Node head){
        if(head == null)
            return false;

        if(head.next == null)
            return false;


        if(head.next == head)
            return true;


        Node fastPointer = head;
        Node slowPointer = head;

        while(fastPointer != null && slowPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(fastPointer == slowPointer)
                return true;
        }

        return false;
    }
}
