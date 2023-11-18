package k_BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
*
*   Anto clock wise
*                                   1
*                   2                                   7
*           3                                                   8
*                   4                                   9
*           5               6                       10      11
*
* O/P : 1  2 3 4 5 6 10 11 9 8 7
*
*   Steps :
*       1) Left Boundary excluding leaf
*       2) Leaf nodes
*       3) Right nodes in reverse order excluding leaf
*
*
* */
public class P_BoundryTraversalOfBTAntiClock {

    public static void main(String[] args) {
        A1_Node node  = A1_Node.createTree();
        List<Integer> boundaryNodes = getBoundaryNodes(node);
        System.out.println(boundaryNodes);
    }

    private static List<Integer> getBoundaryNodes(A1_Node node) {
        List<Integer> result = new ArrayList<>();
        result.add(node.getVal());
        getLeftBoundaryNodes(node,result);
       getAllLeavesNodes(node,result);
        getRightBoundaryNodes(node,result);
        return result;
    }


    public static boolean isLeaf(A1_Node node){
        return node.getLeft() == null && node.getRight() == null;
    }
    private static void getRightBoundaryNodes(A1_Node node,List<Integer> result) {
        Stack<A1_Node> stack = new Stack<>();

        A1_Node curr = node.getRight();

        while(curr != null){
            if(!isLeaf(curr))
                stack.push(curr);

            if(curr.getRight() != null){
                curr = curr.getRight();
            }else{
                curr = curr.getLeft();
            }
        }

        while(!stack.isEmpty()){
            result.add(stack.pop().getVal());
        }
    }

    private static void getAllLeavesNodes(A1_Node node, List<Integer> result) {
        if(isLeaf(node))
            result.add(node.getVal());

        if(node.getLeft() != null)
            getAllLeavesNodes(node.getLeft(),result);

        if(node.getRight() != null)
            getAllLeavesNodes(node.getRight(),result);

    }

    private static void getLeftBoundaryNodes(A1_Node node,List<Integer> result) {
        A1_Node curr = node.getLeft();

        while(curr != null){

            if(!isLeaf(curr))
                result.add(curr.getVal());

            if(curr.getLeft() != null)
                curr = curr.getLeft();
            else
                curr = curr.getRight();
        }


    }
}
