package linkedlist;

public class ReverseSingleLinkedList {

    public Node reverseLinkedList(Node head){
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
    public static void main(String[] args) {
        ReverseSingleLinkedList reverseLinkedList = new ReverseSingleLinkedList();
        SingleLinkedList basicLinkedList = new SingleLinkedList();
        Node head = basicLinkedList.createLinkList();

        Node reversedHead = reverseLinkedList.reverseLinkedList(head);
        basicLinkedList.display(reversedHead);
    }
}
