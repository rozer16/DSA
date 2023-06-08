package linkedlist.singly;
/*
https://leetcode.com/problems/delete-node-in-a-linked-list/description/
*
*
* */
public class P_DeleteANodeWithoutHead {

    public void deleteNode(Node node) {

        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

        P_DeleteANodeWithoutHead test = new P_DeleteANodeWithoutHead();
        int [] arr1= {1,9,1,2,3};
        Node head1 = Util.createLinkedList(arr1);
        test.deleteNode(head1.next.next);
        Util.displayLinkedList(head1);
    }


}
