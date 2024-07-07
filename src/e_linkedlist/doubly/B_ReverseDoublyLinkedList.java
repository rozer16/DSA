package e_linkedlist.doubly;


import java.util.Stack;

public class B_ReverseDoublyLinkedList {



    public static Node reverseDLL(Node  head)
    {

        if(head == null || head.next == null)
            return head;


        Node last = null;
        Node curr = head;


        while(curr != null){
            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;
            curr = curr.prev;
        }

        return last.prev;
    }


    public Node reverseLinkedList1(Node head) {

       Stack<Integer> stack = new Stack<>();
       Node temp = head;
       while(temp != null){
           stack.push(temp.data);
           temp = temp.next;
       }

       temp = head;
       while(temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }
       return temp;
    }

    public Node reverseLinkedList(Node head) {
       Node prev = head;
       Node curr = head.next;

       prev.next = null;
       prev.prev =curr;

       while(curr != null){
           curr.prev = curr.next;
           curr.next=prev;
           prev = curr;
           curr = curr.prev;

       }
       head = prev;
        return head;
    }

    private Node createDoublyLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node lastNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            node.prev = lastNode;
            lastNode.next = node;
            lastNode = node;
        }


        return head;
    }

    private void displayList(Node head) {
        Node node = head;
        while(node != null){
            System.out.print(node.data+"=>");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        B_ReverseDoublyLinkedList test = new B_ReverseDoublyLinkedList();
        int[] arr1 = {1,2,3,4,5};
        Node head1 = test.createDoublyLinkedList(arr1);
        System.out.println("Before reverse");
        test.displayList(head1);
        head1 = test.reverseLinkedList1(head1);
        System.out.println("Before reverse");
        test.displayList(head1);
    }

}
