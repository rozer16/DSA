
/*

https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/
*/

package l_BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
* Problem Statement: BoundaryTraversal of a binary tree.
* Write a program for the Anti-Clockwise Boundary traversal of a binary tree.


*                       1
*               2               7
*           3                       8
*               4               9
*           5       6       10      11
 *
*   O/P : 1 7 8 9 11 10 6 5 4 3 2 1
*
* */
public class P_BoundaryTraversalOfBTClockWise {

    public static void main(String[] args) {
        A1_Node root = A1_Node.createTree();
        List<Integer> clockwiseno = getBoundaryNodesInClockWise(root);
        System.out.println(clockwiseno);
    }

    private static boolean isLeaf(A1_Node node){
        return node != null && node.getLeft() == null && node.getRight() == null;
    }
    private static List<Integer> getBoundaryNodesInClockWise(A1_Node root) {

        List<Integer> result = new ArrayList<>();
        result.add(root.getVal());
        getBoundaryNodesFromRightSide(root,result);
        getLeafNodesFromRightSide(root,result);
        getBoundaryNodesFromLeftSide(root,result);
        return result;
    }

    private static void getBoundaryNodesFromLeftSide(A1_Node root, List<Integer> result) {
        Stack<A1_Node> stack = new Stack<>();

        A1_Node curr = root.getLeft();
        while(curr != null){
            if(!isLeaf(curr))
                stack.push(curr);

            if(curr.getLeft() != null)
                curr = curr.getLeft();
            else
                curr = curr.getRight();
        }

        while(!stack.isEmpty()){
            result.add(stack.pop().getVal());
        }


    }

    private static void getLeafNodesFromRightSide(A1_Node root, List<Integer> result) {
        if(isLeaf(root)){
            result.add(root.getVal());
            return;
        }

        if(root.getRight() != null)
            getLeafNodesFromRightSide(root.getRight(),result);
        if(root.getLeft()!= null)
            getLeafNodesFromRightSide(root.getLeft(),result);
    }

    private static void getBoundaryNodesFromRightSide(A1_Node root, List<Integer> result) {
        A1_Node curr = root.getRight();

        while(curr != null){
            if(!isLeaf(curr))
                result.add(curr.getVal());

            if(curr.getRight() != null)
                curr = curr.getRight();
            else
                curr = curr.getLeft();

        }
    }
}
