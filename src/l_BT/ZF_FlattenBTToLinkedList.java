package l_BT;

import java.util.Stack;

/*
https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/
https://youtu.be/sWf7k1x9XR4
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
*
* Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

*
*
*                       1
*           2                       5
*       3      4                        6
*
    Output :
*
*           1
*               2
*                   3
*                       4
*                           5
*                               6



The sequence of nodes in the linked list should be the same as that of the preorder traversal of the binary tree.
The linked list nodes are the same binary tree nodes. You are not allowed to create extra nodes.
The right child of a node points to the next node of the linked list whereas the left child points to NULL.


Solution 1: Using Recursion
Intuition:

The sequence of nodes in the linked list should be that of the preorder traversal. We will take a smaller example.


* */
public class ZF_FlattenBTToLinkedList {

    Node prev = null;


    public static void main(String[] args) {
        Node root =new Node(25);
        root.left = new Node(15);
        root.left.left = new Node(9);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(13);
        root.left.right = new Node(21);


        root.right = new Node(45);
        root.right.right = new Node(52);
        root.right.left = new Node(41);

        ZF_FlattenBTToLinkedList test = new ZF_FlattenBTToLinkedList();
        test.flattenBTToLinkedListIterative(root);
        System.out.println(root);

    }

    // Right left and logic
    public void flattenBTToLinkedListRecursive(Node node){
        if(node == null)
            return;

        //Going to most right
        flattenBTToLinkedListRecursive(node.right);
        //Going to  left
        flattenBTToLinkedListRecursive(node.left);

        //Setting prev as right
        node.right = prev;
        //Nullifying
        node.left = null;

        //Setting curr node as prev so that its parent node can set this node as its right and set left as null
        prev = node;

    }


    /*
    *
    * Thought process :
    *
    * Pop Current Node
    * Push current node right and then left node
    * set curr node's right = stack.peek
    * set curr node's left = null
    *
    * */
    public void flattenBTToLinkedListIterative(Node node){
        if(node == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);


        while (!stack.isEmpty()){
            Node curr = stack.pop();
            if(curr.right != null)
                stack.push(curr.right);
            if(curr.left != null)
                stack.push(curr.left);

            if(!stack.isEmpty())
                curr.right = stack.peek();
            curr.left = null;
        }


    }
}


