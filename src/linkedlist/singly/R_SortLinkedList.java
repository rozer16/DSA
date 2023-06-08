package linkedlist.singly;


/*https://leetcode.com/problems/delete-node-in-a-linked-list/description/
https://www.geeksforgeeks.org/merge-sort-for-linked-list/
*
* */
public class R_SortLinkedList {
    public static void main(String[] args) {
        R_SortLinkedList test = new R_SortLinkedList();
        int [] arr= {4,2,1,3};
        Node head1 = Util.createLinkedList(arr);
        Node newHead = test.mergeSort(head1);
        Util.displayLinkedList(newHead);
    }

    public Node mergeSort(Node head){

        //If the size of the linked list is 1 then return the head
        if(head == null || head.next == null)
            return head;

        Node mid = findMid(head);
        Node r = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(r);
        Node merged = mergeTwoLists(left,right);

        return merged;
    }


    public Node mergeTwoLists(Node list1, Node list2) {
        Node p1= list1;
        Node p2 =list2;
        Node p3=null;
        Node newHead = null;
        if(p1 == null)
            return p2;

        if(p2 == null)
            return p1;

        if(p1.data < p2.data){
            newHead = p1;
            p3=p1;
            p1 = p1.next;

        }else{
            newHead = p2;
            p3 = p2;
            p2 = p2.next;

        }
        while(p1!= null & p2!= null){
            if(p1.data <p2.data){
                p3.next=p1;
                p3 = p3.next;
                p1 = p1.next;

            }else{
                p3.next= p2;
                p3 = p3.next;
                p2 = p2.next;
            }
        }


        while(p1!= null){
            p3.next=p1;
            p3 = p3.next;
            p1 = p1.next;
        }
        while(p2!= null){
            p3.next=p2;
            p3 = p3.next;
            p2 = p2.next;
        }
        return newHead;
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
