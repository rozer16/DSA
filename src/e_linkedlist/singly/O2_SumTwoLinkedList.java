package e_linkedlist.singly;
/*
https://leetcode.com/problems/add-two-numbers/
* *
*
* */

public class O2_SumTwoLinkedList {

    public static void main(String[] args) {
        O2_SumTwoLinkedList test = new O2_SumTwoLinkedList();
        int [] arr1= {9,9,9,9,9,9,9};
        Node head1 = Util.createLinkedList(arr1);
        int [] arr2= {9,9,9,9};
        Node head2 = Util.createLinkedList(arr2);
        Node newa = test.addTwoNumbers(head1,head2);
        Util.displayLinkedList(newa);
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node p1 = l1;
        Node p2 = l2;
        Node newHead = new Node();
        Node p3 = newHead;
        int carry = 0;
        while(p1 != null && p2 != null){
            int sum = p1.data + p2.data+carry;
            if(sum > 9){
                sum = sum-10;
                carry = 1;
            }else{
                carry = 0;
            }
            Node n1 = new Node(sum);
            p3.next = n1;
            p3=p3.next;
            p1=p1.next;
            p2=p2.next;

        }
        while(p1 != null){
                int sum = p1.data + carry;
            if(sum > 9){
                sum = sum-10;
                carry = 1;
            }else{
                carry =0;
            }
            Node n1 = new Node(sum);
            p3.next = n1;
            p3=p3.next;
            p1=p1.next;

        }
        while(p2 != null){
            int sum = p2.data + carry;
            if(sum > 9){
                sum = sum-10;
                carry = 1;
            }else{
                carry =0;
            }
            Node n1 = new Node(sum);
            p3.next = n1;
            p3=p3.next;
            p2=p2.next;
        }
        if(carry != 0){
            Node n1 = new Node(carry);
            p3.next = n1;
            p3=p3.next;
        }
        return newHead.next;
    }
}
