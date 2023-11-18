package k_BT;

public class A1_Node {

    private int val;
    private A1_Node left;
    private A1_Node right;

    public A1_Node(int val) {
        this.val = val;
    }

    public A1_Node(int val, A1_Node left, A1_Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public A1_Node getLeft() {
        return left;
    }

    public void setLeft(A1_Node left) {
        this.left = left;
    }

    public A1_Node getRight() {
        return right;
    }

    public void setRight(A1_Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static A1_Node createTree(){
        A1_Node root = new A1_Node(1);

        A1_Node two = new A1_Node(2);
        A1_Node three = new A1_Node(3);

        root.setLeft(two);
        root.setRight(three);

        A1_Node four = new A1_Node(4);
        A1_Node five = new A1_Node(5);

        two.setLeft(four);
        two.setRight(five);

        A1_Node six = new A1_Node(6);
        A1_Node seven = new A1_Node(7);

        three.setLeft(six);
        three.setRight(seven);

        return root;
    }
}
