package BibleDSA.problems.g_linkedlist;

public class RemoveNthNodeFromEnd {

    public void removeNthNodeFromEnd(Node head, int n){
        if(head == null)
            return;
        // 1 ==> 2 ==> 3 ==>  4 ==> 5

        Node pointer1 = head;
        Node pointer2 = head;
        Node pointer3 = null;
        for(int i = 1;i<n;i++){
            if(pointer1.getNext() == null){
                System.out.println("Invalid index");
            }
            pointer1 = pointer1.getNext();
        }

        while(pointer1.getNext() != null){
            pointer1 = pointer1.getNext();
            pointer3 = pointer2;
            pointer2 = pointer2.getNext();
        }

        pointer3.setNext(pointer2.getNext());
        pointer2.setNext(null);

    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node head = singleLinkedList.createLinkList();
        removeNthNodeFromEnd.removeNthNodeFromEnd(head,2);
        singleLinkedList.display(head);
    }
}
