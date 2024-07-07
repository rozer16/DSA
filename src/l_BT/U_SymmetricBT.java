package l_BT;





/*
A symmetrical binary tree is a tree that forms a mirror of itself around the center.
 In other words, every node in the left subtree will have a mirror image in the right subtree.


https://takeuforward.org/data-structure/check-for-symmetrical-binary-tree/
*               1
*       2               2
*   4          3|3              4
* */

class Node {
    int data;
    Node  left,  right;
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}


public class U_SymmetricBT {

    public static void main(String args[]) {

        Node  root = new Node(1);
        root . left = new Node(2);
        root . left . left = new Node(3);
        root . left . right = new Node(4);
        root . right = new Node(2);
        root . right . left = new Node(4);
        root . right . right = new Node(3);

        boolean res;
        res = isSymmetric(root);

        if (res)
            System.out.println("The tree is symmetrical");
        else System.out.println("The tree is NOT symmetrical");

    }
    static boolean isSymmetric(Node  root) {
        if (root==null) return true;
        return isSymmetricUtil(root . left, root . right);
    }
    static boolean isSymmetricUtil(Node  root1, Node  root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        return (root1 . data == root2 . data) && isSymmetricUtil(root1 . left, root2 .
                right) && isSymmetricUtil(root1 . right, root2 . left);
    }


}
