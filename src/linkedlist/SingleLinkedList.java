package linkedlist;

public class SingleLinkedList {

    public void display(Node head){
        if(head == null)
            return;
        Node pointer = head;
        while (pointer != null){
            System.out.print(pointer.getData());
            pointer = pointer.getNext();
            if(pointer != null)
                System.out.print(" --> ");

        }
        System.out.println();
    }

    public void add(Node head,Node node, int index){
        if(head == null)
            head = node;
        if(index == 1){
            node.setNext(head);
            head = node;
        }else{
            Node previous = null;
            Node pointer = head;
            int count = 1;
            while(count != (index-1)){
                if(pointer == null){
                    previous.setNext(node);
                }
                previous = pointer;
                pointer = pointer.getNext();
                count++;
            }

            node.setNext(pointer.getNext());
            pointer.setNext(node);
        }
        display(head);
    }


    public void remove(Node head, Node node){
        if(head == null || node == null){
            return;
        }

        Node previous = null;
        Node current = head;
        if(head.getData() == node.getData()){
            head = head.getNext();
        }else {
            while (current.getData() != node.getData()) {
                previous = current;
                current = current.getNext();

                if (current.getNext() == null) {
                    System.out.println("Node not found!!!");
                    return;
                }
            }

            previous.setNext(current.getNext());
            current.setNext(null);
        }
        display(head);
    }

    public void removeNthNode(Node head,int index ){
        if(head == null)
            return;
        if(index == 1) {
            head = head.getNext();
            display(head);
            return;
        }
        int count = 1;
        Node pointer = head;
        Node previous = null;
        while(count != index){
            if(pointer.getNext() == null){
                System.out.println("Invalid Index!!!!");
                return;
            }
            previous = pointer;
            pointer = pointer.getNext();
            count++;
            //1 -> 2 ->3 --> 4
        }

        previous.setNext(pointer.getNext());
        pointer.setNext(null);
        display(head);

    }

    public Node createLinkList(){
        Node head = new Node(1);
        add(head,new Node(2),2);
        add(head,new Node(3),3);
        add(head,new Node(4),4);
        add(head,new Node(5),5);
        return head;

    }
    public static void main(String[] args) {
        SingleLinkedList basicLinkedList = new SingleLinkedList();
        Node head = new Node(1);
        basicLinkedList.add(head,new Node(2),2);
        basicLinkedList.add(head,new Node(3),3);
        basicLinkedList.add(head,new Node(4),4);



        basicLinkedList.remove(head, new Node(-5));
        basicLinkedList.removeNthNode(head, 2);

    }
}
/*
* 1 -> 2 ->3 --> 4
*
* */