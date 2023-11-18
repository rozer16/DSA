package k_BT;

import org.xml.sax.ext.Attributes2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        if(!isLeaf(root)){
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
