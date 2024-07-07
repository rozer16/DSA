package e_linkedlist.singly;

/*
* 1-> 2->3->4->5, then the middle node of the list is 3.
* If there are two middle nodes(in case, when N is even), print the second middle element.
* For example, if the linked list given is 1->2->3->4->5->6, then the middle node of the list is 4.
* */
public class G_GetMiddleOfLinkedList {

    int getMiddle(Node head)
    {
        Node fastPointer = head;
        Node slowPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }


        return slowPointer.data;
    }

    public static void main(String[] args) {
        G_GetMiddleOfLinkedList test = new G_GetMiddleOfLinkedList();
        int [] arr= {1,2,3,4,5};
        Node head = Util.createLinkedList(arr);
        System.out.println("Original LinkedList");
        Util.displayLinkedList(head);
        System.out.println("Middle of linkedList : "+test.getMiddle(head));
    }
}
