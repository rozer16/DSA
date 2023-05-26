package BibleDSA.problems.g_linkedlist;

public class ReverseSingleLinkedList {

    public Node reverseLinkedList1(Node head){
        Node reverseHead = null;
        if(head == null)
            return null;
        if(head.getNext() == null)
            return  head;

        Node pointer = head;
        Node previous = null;
        while (pointer != null){
            previous = pointer;
            pointer = pointer.getNext();
            previous.setNext(reverseHead);
            reverseHead = previous;
        }

        return reverseHead;
    }


    public Node reverseLinkedList(Node head){
        Node previous = null;
        Node current = head;

        while(current != null){
            Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        return previous;
    }
    public static void main(String[] args) {
        ReverseSingleLinkedList reverseLinkedList = new ReverseSingleLinkedList();
        SingleLinkedList basicLinkedList = new SingleLinkedList();
        Node head = basicLinkedList.createLinkList();

        Node reversedHead = reverseLinkedList.reverseLinkedList(head);
        basicLinkedList.display(reversedHead);
    }
}
