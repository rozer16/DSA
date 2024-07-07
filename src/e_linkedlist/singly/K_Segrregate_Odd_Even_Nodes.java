package e_linkedlist.singly;

public class K_Segrregate_Odd_Even_Nodes {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;

        ListNode oddHead = head;
        ListNode evenHead = head.next;

        int index = 3;
        ListNode temp =  head.next.next;
        ListNode odd = oddHead;
        ListNode even = evenHead;
        while(temp != null){
            ListNode next = temp.next;
            if(index % 2 == 0){
                even.next = temp;
                even = even.next;
            }else{
                odd.next = temp;
                odd = odd.next;
            }

            if(index % 2 == 0 )
                even.next = null;
            else
                odd.next = null;

            temp = next;
            index++;
        }
        odd.next = evenHead;

        return oddHead;
    }

    public void print(ListNode head){
        int index = 4;
        ListNode temp = head;
        while(temp != null && index < 4){
            System.out.print(temp.val+"  ");
            temp = temp.next;
            index++;
        }

        System.out.println("");
    }
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
        /*Node head = Util.createLinkedList(arr);
        System.out.println("Original LinkedList");
        Util.displayLinkedList(head);
        Node head1 = test.oddEvenList(head);
        Util.displayLinkedList(head1);*/

        Node head = Util.createLinkedList(arr);
        System.out.println("Original LinkedList");

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);


        ListNode head1 = test.oddEvenList(node);

    }
}
