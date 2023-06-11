package d_linkedlist.singly;


/*


https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

* Create dummy Node nd make its next as head
* Make two nodes fastPointer and slowPointer and assign dummyNode
* Iterate fast pointer to first N node
* move 1 position for fast and slow until fastPointer reaches last node(fast.next == null)
* set slow.next= slow.next.next
* Return dummy.next as head
*
* */
public class M_RemoveLastNthNode {
    public static void main(String[] args) {
        M_RemoveLastNthNode test=  new M_RemoveLastNthNode();

    }

    public Node RemoveLastNthNode(Node head, int n){
        int count = 1;
        Node start = new Node();
        start.next= head;
        Node front = start;
        Node back = start;


        while(count <= n && front!= null){
            front = front.next;
            count++;
        }

        if(front == null)
            return head;

        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return start.next;
    }
}
