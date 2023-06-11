package d_linkedlist.singly;

public class Util {

    public static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node lastNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            lastNode.next = newNode;
            lastNode = newNode;
        }
        return head;
    }
    public static void displayLinkedList(Node head) {
        Node node = head;
        while(node != null){
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.println();
    }

}
