package linkedlist.singly;

public class F_RevertBothPartsByDevidingK {

    public Node reverseBothParts(Node head){




        return null;
    }

    public static void main(String[] args) {
        F_RevertBothPartsByDevidingK test = new F_RevertBothPartsByDevidingK();
        int [] arr= {1,2,3,4,5};
        Node head = Util.createLinkedList(arr);
        System.out.println("Original LinkedList");
        Util.displayLinkedList(head);
        Node newHead = test.reverseBothParts(head);
        System.out.println("After BothPart reverse LinkedList");
        Util.displayLinkedList(newHead);
    }
}
