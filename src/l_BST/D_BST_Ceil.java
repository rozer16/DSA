package l_BST;


/*
* https://takeuforward.org/binary-search-tree/ceil-in-a-binary-search-tree/
*  https://youtu.be/KSsk8AhdOZA
*
*
* Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.
* */
public class D_BST_Ceil {

    public static void main(String[] args) {
        Node node = Node.getBST();

        System.out.println(findCeil(node,6));
    }
    static int findCeil(Node root, int input) {
        int ceil = -1;

        while (root != null) {
            if (root.data == input) {
                return input;  // If input is found in the tree, return it as ceil.
            } else if (root.data < input) {
                root = root.right;  // Move to the right subtree if input is greater than current node's data.
            } else {
                ceil = root.data;   // Mark ceil to be current node's data.
                root = root.left;   // Move to the left subtree to find a closer ceil value.
            }
        }

        return ceil;  // Return computed ceil value.
    }
}
