package d_linkedlist.singly;

/*
* https://leetcode.com/problems/reverse-nodes-in-k-group/
* */
public class U_ReverseLinkedListInGroupOfK {
    public static void main(String[] args) {
        U_ReverseLinkedListInGroupOfK test = new U_ReverseLinkedListInGroupOfK();
        int [] arr = {1,2,3,4,5,6,7,8};
        Node head = Util.createLinkedList(arr);
        Node newHead = test.reverseLinkedListinGroupOfK(head,6);
        Util.displayLinkedList(newHead);
    }

    private Node reverseLinkedListinGroupOfK(Node head,int k) {
        if(head == null || k ==1)
            return head;

        Node dummy = new Node(-1);
        dummy.next = head;

        Node curr = head, next = dummy, prev = dummy;

        //count length of node
        int count = 0;
        while(curr != null){
            curr = curr.next;
            count++;
        }

        while(count >= k){
            curr = prev.next;
            next = curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;

            }

            count -= k;
            prev = curr;

        }

        return dummy.next;
    }
}
