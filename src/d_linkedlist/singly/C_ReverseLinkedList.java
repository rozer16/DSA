package d_linkedlist.singly;
/*
* https://leetcode.com/problems/reverse-linked-list/
*
* */
public class C_ReverseLinkedList {

    private Node recursiveReverseLinkedList(Node head){

        //No node in list
        if(head == null)
            return head;

        //Only 1 node or recursion has reached last node.
        if(head.next == null)
            return head;


        Node newHead = recursiveReverseLinkedList(head.next);
        //Pointing to next node to its own
        head.next.next = head;
        //Unlinking next link
        head.next = null;

        //Returning new head node.
        return newHead;
    }

    private Node iterativeReverseLinkList(Node head){

        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        return prev;
    }


    private Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node lastNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            lastNode.next = newNode;
            lastNode = newNode;
        }
        return head;
    }
    private void displayLinkedList(Node head) {
        Node node = head;
        while(node != null){
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        C_ReverseLinkedList test = new C_ReverseLinkedList();
        int[] arr = {1, 2, 1, 2};
        Node head = test.createLinkedList(arr);
        System.out.println("Original LinkedList");
        test.displayLinkedList(head);
        System.out.println("After recursive");
        Node newhead = test.recursiveReverseLinkedList(head);
        test.displayLinkedList(newhead);
        head = test.createLinkedList(arr);
        System.out.println("After iterative.");
        Node newhead1 = test.iterativeReverseLinkList(head);
        test.displayLinkedList(newhead1);
    }
}
