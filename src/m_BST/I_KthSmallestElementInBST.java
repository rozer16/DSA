package m_BST;

import java.util.Stack;

/*
* https://takeuforward.org/data-structure/kth-largest-smallest-element-in-binary-search-tree/
* https://www.youtube.com/watch?v=9TJYWh0adfk
* https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*
*                       5
*           3                       7
*   1                   4|6                 8
*           2
*
*
*     Observation : BST behaviour : left < root < right
*                   Inorder : Left Root Right
*       So Inorder traversal of binary tree always gives  nodes in ascending order
*       Inorder : 1 2 3 4 5 6 7 8
*       3rd smallest : 3
*
* */
public class I_KthSmallestElementInBST {
    public static void main(String[] args) {
        Node node = Node.getBST();
        int n = findKthSmallestElementInBST(node,6);
        System.out.println(n);
    }

    private static int findKthSmallestElementInBST(Node node, int i) {
        int result = -1;
        int k = i;

        Node curr = node;
        Stack<Node> stack = new Stack<>();
        while(true){
            if(curr != null){
                stack.push(curr);
                curr = curr.getLeft();
            }else{
                if(stack.isEmpty())
                    break;
                else{
                    Node temp = stack.pop();
                    k--;
                    if(k==0){
                        result = temp.getData();
                        break;
                    }
                    curr= temp.getRight();
                }
            }
        }



    return result;
    }
}
