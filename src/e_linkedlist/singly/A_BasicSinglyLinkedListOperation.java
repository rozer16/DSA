package e_linkedlist.singly;

public class A_BasicSinglyLinkedListOperation {

    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {
        Node node = new Node(x);
        node.next=head;
        head=node;

        return head;
    }

    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
        if(head != null){
            Node endNode = head;
            while(endNode.next != null)
                endNode = endNode.next;

            endNode.next = new Node(x);
        }else{
            head = new Node(x);
        }


        return head;
    }

    int getLength(Node head){
        int len = 0;

        if(head == null)
            return len;

        Node node = head;
        while(node != null){
            node = node.next;
            len++;
        }
        return len;
    }


    boolean searchKey(Node head,int key){
        Node node = head;
        while(node != null){
            if(node.data == key)
                return  true;

            node = node.next;
        }

        return false;
    }
    Node deleteNodeByValue(Node head, int x)
    {
        Node current = head;
        Node prev = null;

        while(current != null){
            if(current.data == x){
                break;
            }
            prev = current;
            current = current.next;
        }

        if(current != null && current.data == x){
            Node temp = current;
            if(prev != null){
                prev.next = current.next;
            }else{
                head = current.next;
            }

            return head;
        }

        return head;
    }


    Node deleteNodeByIndex(Node head, int x){

        int counter = 1;
        Node node = head;
        Node prev = null;

        if(x == 1) {
            head = head.next;
            return head;
        }

        while(node != null && counter < x){
            prev = node;
            node = node.next;
            counter++;
        }

        prev.next = node.next;

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
        A_BasicSinglyLinkedListOperation test = new A_BasicSinglyLinkedListOperation();
        int [] arr = {1,6,3,7};
        Node head = test.createLinkedList(arr);
        System.out.println("Before Deletion");
        test.displayLinkedList(head);
        System.out.println("After Deletion");
        head = test.deleteNodeByIndex(head,4);
        test.displayLinkedList(head);

        System.out.println(test.searchKey(head,6));
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

}
