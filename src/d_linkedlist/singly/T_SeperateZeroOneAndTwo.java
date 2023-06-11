package d_linkedlist.singly;


/*
* https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it
* */
public class T_SeperateZeroOneAndTwo {
    public static void main(String[] args) {
        T_SeperateZeroOneAndTwo test = new T_SeperateZeroOneAndTwo();
        int [] arr = {0,1,1,1,2,2,2,1,0,0};
        Node head = Util.createLinkedList(arr);
        Node newHead = test.segregate(head);
        Util.displayLinkedList(newHead);
    }

    public Node createNode(int data){
        return new Node(data);
    }
    public Node segregate(Node head)
    {
        Node zeroHead = new Node(-1);;
        Node zeroP = zeroHead;

        Node oneHead = new Node(-1);
        Node oneP = oneHead;

        Node twoHead = new Node(-1);;
        Node twoP = twoHead;


        Node x = head;

        while(x != null){
            if(x.data == 0){
                zeroP.next = createNode(0);
                zeroP = zeroP.next;
            }else if(x.data == 1){
                oneP.next = createNode(1);
                oneP = oneP.next;
            }if(x.data == 2){
                twoP.next = createNode(2);
                twoP = twoP.next;
            }
            x = x.next;
        }
        Node newHead = new Node(-1);
        Node tail = newHead;
        if(zeroHead.next != null){
            tail.next = zeroHead.next;
            tail = zeroP;
        }
        if(oneHead.next != null){
            tail.next = oneHead.next;
            tail = oneP;
        }
        if(twoHead.next != null){
            tail.next = twoHead.next;
            tail = oneP;
        }
        return newHead.next;
    }
}
