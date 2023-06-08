package linkedlist.singly;


/*
*https://leetcode.com/problems/intersection-of-two-linked-lists/
*
* https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
*
* */
public class N_Find_IntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        N_Find_IntersectionOfTwoLinkedList test = new N_Find_IntersectionOfTwoLinkedList();
        int [] arr1= {1,9,1,2,3};
        Node head1 = Util.createLinkedList(arr1);
        int [] arr2= {3,2,3};
        Node head2 = Util.createLinkedList(arr1);
        Node intersecion = test.findIntersection(head1,head2);
        System.out.println("Intersection point : "+intersecion.data);
    }

    public Node findIntersection(Node head1,Node head2){
        // Maintaining two pointers ptr1 and ptr2
        // at the head of A and B,
        Node ptr1 = head1;
        Node ptr2 = head2;

        // If any one of head is null i.e
        // no Intersection Point
        if (ptr1 == null || ptr2 == null) {

            return null;
        }

        // Traverse through the lists until they
        // reach Intersection node
        while (ptr1 != ptr2) {

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

            // If at any node ptr1 meets ptr2, then it is
            // intersection node.Return intersection node.

            if (ptr1 == ptr2) {

                return ptr1;
            }
        /* Once both of them go through reassigning,
        they will be equidistant from the collision point.*/

            // When ptr1 reaches the end of a list, then
            // reassign it to the head2.
            if (ptr1 == null) {

                ptr1 = head2;
            }
            // When ptr2 reaches the end of a list, then
            // redirect it to the head1.
            if (ptr2 == null) {

                ptr2 = head1;
            }
        }

        return ptr1;
    }
}
