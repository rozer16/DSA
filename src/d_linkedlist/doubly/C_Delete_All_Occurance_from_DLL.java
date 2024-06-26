package d_linkedlist.doubly;

/*
https://youtu.be/YJKVTnOJXSY
https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list

You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.

Example1:

Input:
2<->2<->10<->8<->4<->2<->5<->2
2
Output:
10<->8<->4<->5
Explanation:
All Occurences of 2 have been deleted.

Example2:

Input:
9<->1<->3<->4<->5<->1<->8<->4
9
Output:
1<->3<->4<->5<->1<->8<->4
Explanation:
All Occurences of 9 have been deleted.
Your Task:

Complete the function void deleteAllOccurOfX(struct Node** head_ref, int key), which takes the reference of the head pointer and an integer value key. Delete all occurrences of the key from the given DLL.

Expected Time Complexity: O(N).

Expected Auxiliary Space: O(1).
* */
public class C_Delete_All_Occurance_from_DLL {

    static Node deleteAllOccurOfX(Node head, int x) {
        Node d = new Node();

        Node curr = head;
        curr.prev = d;
        d.next = curr;


        while(curr != null){
            Node temp = curr.next;
            if(curr.data == x){
                //If node is x then remove link
                curr.prev.next = curr.next;
                if(curr.next != null)
                    curr.next.prev = curr.prev;

                curr.next = null;
                curr.prev = null;

            }
            curr = temp;

        }

        Node newHead = d.next;
        newHead.prev = null;
        d.next = null;
        return newHead;
    }
}
