package e_linkedlist.singly;


/*
* https://leetcode.com/problems/rotate-list/description/
*
Given the head of a linked list, rotate the list to the right by k places.



Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

*
* Exemple 2
Input: head = [0,1,2], k = 4
Output: [2,0,1]
* */
public class V_RotateLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        V_RotateLinkedList test = new V_RotateLinkedList();
        ListNode node1 = test.rotateRight(node,2);

        while(node1 != null){
            System.out.print(node1.val);
            node1 = node1.next;
        }




    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null|| k == 0)
            return head;
        int size = 0;
        ListNode temp1 = head;
        while(temp1 != null){
            temp1 = temp1.next;
            size++;
        }

        if(k == size)
            return head;

        if(k>size)
            k = k%size;

        ListNode fp = head;
        ListNode sp = head;
        int temp = 0;
        while(temp < k){
            fp = fp.next;
            temp++;
        }
        while(fp.next != null){
            fp = fp.next;
            sp = sp.next;
        }

        fp.next = head;
        head = sp.next;
        sp.next = null;

        return head;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +

                '}';
    }
}