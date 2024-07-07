package e_linkedlist.singly;

/*
* 1->2->3 = 1->2->4
* 4->5>6 = 4->5->7
* 1->9->9 = 2->0->0
* */
public class O1_AddOneToLinkedList {

    public static void main(String[] args) {
        O1_AddOneToLinkedList test = new O1_AddOneToLinkedList();
        int [] arr1= {4,5,6};
        Node head1 = Util.createLinkedList(arr1);
        head1 = test.addOne(head1);
        Util.displayLinkedList(head1);
    }


    //Recursion
    public Node addOne(Node headNode){
        int carry = getSum(headNode);
        if(carry == 1){
            Node node = new Node(1);
            node.next = headNode;
            return node;
        }else{
            return headNode;
        }
    }

    public int getSum(Node headNode){
       if(headNode.next == null){

           int sum = headNode.data+1;
           if(sum>9){
               headNode.data = 0;
               return 1;
           }else{
               headNode.data = headNode.data+1;
               return 0;
           }
       }

       int carry = getSum(headNode.next);
       if(carry > 0){
           if((headNode.data+carry) > 9){
               headNode.data = headNode.data+carry-10;
               return 1;
           }else{
               headNode.data = headNode.data+carry;
               return 0;
           }

       }else {
           return 0;
       }

    }


    //Complexity : O(n) for first reversal + O(n) for adding one + O(n) for again reversing = O(3n)
    public static Node addOneBF(Node head)
    {
        Node newHead = reverse(head);

        int carry = 1;

        Node curr = newHead;
        while(curr != null){
            if(curr.data + carry > 9){
                carry = 1;
                curr.data = 0;
            }else{
                curr.data = curr.data+carry;
                carry = 0;
            }
            curr = curr.next;
        }
        //System.out.println("==="+newHead.data+" "+newHead.next.data+" "+newHead.next.next.data+" "+newHead.next.next.next);
        newHead = reverse(newHead);
        //System.out.println("==="+newHead.data+" "+newHead.next.data+" "+newHead.next.next.data+" "+newHead.next.next.next);
        if(carry == 1){
            Node node = new Node(1);
            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    public static Node reverse(Node head){
        Node curr = head;
        Node prev= null;

        if(head == null || head.next == null){
            return head;
        }

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
}
