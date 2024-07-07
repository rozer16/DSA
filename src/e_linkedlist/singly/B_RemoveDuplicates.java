package e_linkedlist.singly;

import java.util.HashSet;
import java.util.Set;

public class B_RemoveDuplicates {

    // 1 1 1 2 2 3 ==> 1 2 3
    // 1 1 1 1 1 1 ==> 1
    Node removeDuplicates(Node head)
    {

        if(head == null || head.next == null)
            return head;

        Node prev = head;
        Node curr = head.next;

        while(curr != null){
            if(curr.data == prev.data){
                prev.next=curr.next;
                curr.next = null;
                curr = prev.next;
            }else{
                prev= curr;
                curr = curr.next;
            }
        }
        return head;
    }
    //1 2 3 1 3 ==> 1 2 3
    Node removeDuplicatesFromUnsorted(Node head){
        Set<Integer> nos = new HashSet<>();
        nos.add(head.data);

        Node prev = head;
        Node curr = head.next;


        while(curr != null){
            if(nos.contains(curr.data)){
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            }else{
                nos.add(curr.data);
                prev = curr;
                curr = curr.next;

            }
        }
        return head;
    }

    private Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node lastNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            lastNode.next = newNode;
            lastNode = newNode;
        }
        return head;
    }
    private void displayLinkedList(Node head) {
        Node node = head;
        while(node != null){
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        B_RemoveDuplicates test = new B_RemoveDuplicates();
        int[] arr = {1, 2, 1, 2};
        Node head = test.createLinkedList(arr);
        head = test.removeDuplicatesFromUnsorted(head);
        test.displayLinkedList(head);

    }
}
