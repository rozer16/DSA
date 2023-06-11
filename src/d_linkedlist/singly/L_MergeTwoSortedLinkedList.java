package d_linkedlist.singly;
/*
* https://leetcode.com/problems/merge-two-sorted-lists/
*
*
* */
public class L_MergeTwoSortedLinkedList {


    public static void main(String[] args) {
        L_MergeTwoSortedLinkedList test=new L_MergeTwoSortedLinkedList();
        int [] arr= {1,2,3};
        int [] arr1= {1,4,5};
        Node head1 = Util.createLinkedList(arr);
        Node head2 = Util.createLinkedList(arr1);
        Node head3 =test.mergeTwoLists(head1,head2);
        Util.displayLinkedList(head3);

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
}
