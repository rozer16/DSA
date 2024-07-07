package e_linkedlist.doubly;

public class A_BasicDoublyLinkedListOperation {
    private void displayList(Node head) {
        Node node = head;
        while(node != null){
            System.out.print(node.data+"=>");
            node = node.next;
        }
        System.out.println();
    }

    private Node createDoublyLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node lastNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            node.prev = lastNode;
            lastNode.next = node;
            lastNode = node;
        }


        return head;
    }

    private void addNode(Node head_ref, int pos, int data)
    {
        Node node = new Node(data);
        Node curr = head_ref;
        int count = 1;
        while(curr != null && count <= pos){
            curr = curr.next;
            count++;
        }

        if(curr != null){
            node.prev = curr;
            node.next = curr.next;
            curr.next = node;
            curr.next.prev = node;
        }
    }


    private Node deleteNode(Node head,int x)
    {
        int count = 1;
        Node current = head;

        if(head == null)
            return null;

        if(head.next == null && head.prev == null)
            return null;

        while(current != null && count < x){
            current = current.next;
            count++;
        }

        if(current != null ){
                if(current.prev != null) {
                    current.prev.next = current.next;
                }else{
                    head = current.next;
                    head.prev = null;
                }

                if(current.next != null){
                    current.next.prev=current.prev;
                }
                current = null;


        }



        return head;
    }

    public static void main(String[] args) {
        A_BasicDoublyLinkedListOperation test = new A_BasicDoublyLinkedListOperation();
        /*int[] arr = {2,4,5};
        Node head = test.createDoublyLinkedList(arr);
        System.out.println("Before add");
        test.displayList(head);
        System.out.println("After add");
        test.addNode(head,2,6);
        test.displayList(head);
*/
        int[] arr1 = {1,5,2,9};
        Node head1 = test.createDoublyLinkedList(arr1);
        System.out.println("Before delete");
        test.displayList(head1);
        System.out.println("After delete");
        head1= test.deleteNode(head1,1);
        test.displayList(head1);
    }


}
