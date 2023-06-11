package d_linkedlist.singly;

/*
* 1->2->3 = 1->2->4
* 4->5>6 = 4->5->7
* 1->9->9 = 2->0->0
* */
public class S_AddOneToLinkedList {

    public static void main(String[] args) {
        S_AddOneToLinkedList test = new S_AddOneToLinkedList();
        int [] arr1= {4,5,6};
        Node head1 = Util.createLinkedList(arr1);
        head1 = test.addOne(head1);
        Util.displayLinkedList(head1);
    }

    public Node addOne(Node headNode){
        int carry = getSum(headNode);
        if(carry > 0){
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
               headNode.data = headNode.data+1-10;
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
}
