package l_BST;


/*
* https://youtu.be/f-sj7I5oXEI
*
* */
public class J_CheckIfTreeIsBSTOrBT {
    public static void main(String[] args) {

        Node root =new Node(3);
        root.left = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(2);
        root.left.right.right = new Node(3);





        Node root1 =new Node(-2147483648);
        root.right = new Node(2147483647);

        boolean bst = isValidBST(root1);
        if(bst)
            System.out.println("Its BST");
        else
            System.out.println("Its BT");
    }

    public static boolean isValidBST1(Node root, long minVal, long maxV) {
        if(root == null)
            return true;
        if (root.data >= minVal || root.data <= maxV) return false;
        return isValidBST1(root.left, minVal, root.data) && isValidBST1(root.right,root.data,maxV);
    }

    public static boolean isValidBST(Node root) {
        if(root == null)
            return true;
        return isValidBSTHelper(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean isValidBSTHelper(Node root,long leftR, long rightR) {
        if(!isValidBSTNode(root,leftR,rightR))
            return false;

        boolean left = root == null || isValidBSTHelper(root.left, leftR, root.data);
        boolean right = root == null || isValidBSTHelper(root.right, root.data, rightR);

        return left && right;
    }
    public static boolean isValidBSTNode(Node node, long leftR,long rightR){
        if(node == null)
            return true;
        if(node.left != null && ((node.left.data >= node.data ) || (node.left.data <=  leftR)))
            return false;
        if(node.right != null && ( (node.right.data <= node.data) || (node.right.data >= rightR)))
            return false;

        return true;
    }


}
