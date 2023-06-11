package d_linkedlist.singly;

public class K_Segrregate_Odd_Even_Nodes {
    public Node oddEvenList(Node head) {
        if(head == null || head.next == null)
                return head;


        Node oddPointer = head;
        Node evenHead = head.next;
        Node evenPointer = head.next;


        while (oddPointer != null && oddPointer.next != null & evenPointer != null && evenPointer.next != null){

            oddPointer.next = oddPointer.next.next;
            evenPointer.next = evenPointer.next.next;
            oddPointer = oddPointer.next;
            evenPointer = evenPointer.next;
        }

        oddPointer.next=evenHead;
        return head;
    }

    public static void main(String[] args) {
        K_Segrregate_Odd_Even_Nodes test = new K_Segrregate_Odd_Even_Nodes();
        int [] arr= {1,2,3,4,5};
        Node head = Util.createLinkedList(arr);
        System.out.println("Original LinkedList");
        Util.displayLinkedList(head);
        Node head1 = test.oddEvenList(head);
        Util.displayLinkedList(head1);
    }
}
