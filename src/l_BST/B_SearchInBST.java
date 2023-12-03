package l_BST;


/*
* https://takeuforward.org/data-structure/search-in-a-binary-search-tree-2/
* https://youtu.be/KcNt6v_56cc
*
*
* Intuition: We are given a binary search tree. In a binary search tree,
* for every node the following property is satisfied:

Values in the left subtree < Value of node < Values in the right subtree
*
* Approach:
The algorithm steps can be stated as:

Set a while loop which runs till the time root is not NULL and root’s value is not equal to the target value we are searching for.
Inside the while loop, if the target value is less than the root’s value, move root to its left child, else move root to its right child.
When the while loop ends, return root as the answer.
*
* */
public class B_SearchInBST {
    public static void main(String[] args) {
        Node node = Node.getBST();
        Node node1 = searchBST(node,6);
        System.out.println(node1);
    }

    private static Node searchBST(Node root,int val) {
        Node node = root;
        while (node != null && node.data != val){
            if(val > node.getData()){
                node = node.getRight();
            }else{
                node = node.getLeft();
            }
        }
        return node;
    }
}
