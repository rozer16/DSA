package e_linkedlist.singly;


/*https://leetcode.com/problems/delete-node-in-a-linked-list/description/
https://www.geeksforgeeks.org/merge-sort-for-linked-list/
*
* */
public class M2_SortLinkedList {
    public static void main(String[] args) {
        M2_SortLinkedList test = new M2_SortLinkedList();
        int [] arr= {4,2,1,3};
        Node head1 = Util.createLinkedList(arr);
        Node newHead = test.sortLL(head1);
        Util.displayLinkedList(newHead);
    }

    public  Node sortLL(Node head) {
        if(head == null || head.next == null)
            return head;
        Node middle = findMiddle(head);

        Node left = head;
        Node right = middle.next;
        middle.next = null;
        Node leftS = sortLL(left);
        Node rightS = sortLL(right);
        return merge(leftS,rightS);
    }

    public Node findMiddle(Node head){
        Node sp = head;
        Node fp = head;

        if(head == null || head.next == null || head.next.next == null)
            return head;

        while(fp != null && fp.next != null  && fp.next.next != null){
            sp = sp.next;
            fp = fp.next.next;
        }

        return sp;
    }

    public Node merge(Node head1, Node head2){
        Node n1 = head1;
        Node n2 = head2;
        Node n3 = new Node(-1);
        Node newHead = n3;

        if(n1 == null)
            return n2;
        if(n2 == null)
            return n1;


        while(n1 != null && n2 != null){
            if(n1.data < n2.data){
                n3.next = n1;
                n1 = n1.next;
                n3 = n3.next;

            }else{
                n3.next = n2;
                n2 = n2.next;
                n3 = n3.next;
            }
        }

        if(n1 != null)
            n3.next = n1;
        if(n2 != null)
            n3.next = n2;

        return newHead.next;

    }

    private Node findMid(Node head) {
        if(head == null || head.next == null)
                return head;

        Node fast = head.next;
        Node slow = head;

        while(fast != null & fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
