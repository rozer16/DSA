package k_BT;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
*
*  Root Left Right
*
* */
public class A_DFS_Preorder {

    public static void main(String[] args) {
       A1_Node root = A1_Node.createTree();
        System.out.println("=========Recursion Inorder==========");
       displayInorderByRecursion(root);
        System.out.println("\n=========Iterative Inorder==========");
        displayInorderByIteration(root);
    }

    public static void displayInorderByRecursion(A1_Node AANode) {
        if(AANode == null)
            return;

        System.out.print(AANode.getVal()+" ");
        displayInorderByRecursion(AANode.getLeft());
        displayInorderByRecursion(AANode.getRight());
    }

    private static void displayInorderByIteration(A1_Node root){
        if(root == null)
            return;

        List<Integer> preorder = new ArrayList<>();
        Stack<A1_Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            A1_Node temp  = stack.pop();
            preorder.add(temp.getVal());
            if(temp.getRight() != null)
                stack.push(temp.getRight());
            if(temp.getLeft() != null)
                stack.push(temp.getLeft());
        }

        System.out.println("\n");
        System.out.println(preorder);
    }
}
