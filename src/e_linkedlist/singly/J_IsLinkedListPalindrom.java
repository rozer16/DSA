package e_linkedlist.singly;


/*
* 1) Find middle of linkedList
* 2) Reverse second half linkedlist
* 3) Keep two pointer first half and another pointer pointing to second reversed half
* 4) traverse half and complare value
*
* */
public class J_IsLinkedListPalindrom {

    public boolean isPalindrome(Node head) {
        Node middleNode = getMiddleNode(head);

        Node halfReverseHead = reverse(middleNode.next);
        Node start = head;
        while(halfReverseHead != null){
            if(start.data != halfReverseHead.data)
                return false;
            halfReverseHead = halfReverseHead.next;
            start = start.next;
        }

        return true;

    }

    public Node reverse(Node head){
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public Node getMiddleNode(Node head){
        if(head == null)
            return null;

        if(head.next == null)
            return null;


        Node fastPointer = head;
        Node slowPointer = head;

        while(fastPointer != null && fastPointer.next != null && fastPointer.next.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }

    public static void main(String[] args) {
        J_IsLinkedListPalindrom test = new J_IsLinkedListPalindrom();
        int [] arr= {1,2,3,3,2};
        Node head = Util.createLinkedList(arr);
        System.out.println("Original LinkedList");
        System.out.println(test.isPalindrome(head));
    }
}
