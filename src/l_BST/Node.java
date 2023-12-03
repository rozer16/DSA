package l_BST;

class Node {
    int data;
    Node  left, right;
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static Node getBST(){
        Node root = new Node(8);
        root . left = new Node(5);
        root . left . left = new Node(4);
        root . left . right = new Node(7);
        root . left . right . left = new Node(6);
        root . right = new Node(12);
        root . right . left = new Node(10);
        root . right . right = new Node(14);
        root . right . right . left = new Node(13);
        return root;
    }
}