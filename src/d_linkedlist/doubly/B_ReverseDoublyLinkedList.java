package d_linkedlist.doubly;



public class B_ReverseDoublyLinkedList {

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
        int[] arr1 = {1,5,2,9};
        Node head1 = test.createDoublyLinkedList(arr1);
        System.out.println("Before reverse");
        test.displayList(head1);
        head1 = test.reverseLinkedList(head1);
        System.out.println("Before reverse");
        test.displayList(head1);
    }

}
