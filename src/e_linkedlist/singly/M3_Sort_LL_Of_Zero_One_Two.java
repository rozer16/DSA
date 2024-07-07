package e_linkedlist.singly;

public class M3_Sort_LL_Of_Zero_One_Two {

    public static void main(String[] args) {
        M3_Sort_LL_Of_Zero_One_Two test = new M3_Sort_LL_Of_Zero_One_Two();
        int [] arr= {0,2,2,1,2,1,1,1};
        Node head1 = Util.createLinkedList(arr);
        Node newHead = test.sortZeroOneTwo(head1);
        Util.displayLinkedList(newHead);
    }


    public Node sortZeroOneTwo(Node head){
        if(head == null || head.next == null)
            return head;

        Node zhead = new Node(-1);
        Node ohead = new Node(-1);
        Node thead = new Node(-1);

        Node zero = zhead;
        Node one = ohead;
        Node two = thead;

        Node curr = head;

        while(curr != null){
            if(curr.data == 0){
                zero.next = curr;
                zero = zero.next;

            }else if(curr.data == 1){
                one.next = curr;
                one = one.next;
            }else{
                two.next = curr;
                two = two.next;
            }

            curr = curr.next;
        }


        zero.next = ohead.next != null ? ohead.next : thead.next;
        one.next = thead.next;
        two.next = null;


        return zhead.next;


    }
}
