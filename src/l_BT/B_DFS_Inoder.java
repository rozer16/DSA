/*
https://takeuforward.org/binary-tree/binary-tree-traversal-inorder-preorder-postorder/
https://takeuforward.org/data-structure/inorder-traversal-of-binary-tree/
*/


package l_BT;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* Left Root Right
* */
public class B_DFS_Inoder {

    public static void main(String[] args) {
        A1_Node root = A1_Node.createTree();
        System.out.println("===============Inorder Recursion====");
        displayInorderByRecursion(root);
        System.out.println("\n===============Inorder Iteration====");
        displayInorderByIteration(root);
    }

    private static void displayInorderByRecursion(A1_Node root) {

        if(root == null)
            return;

        displayInorderByRecursion(root.getLeft());
        System.out.print(root.getVal()+" ");
        displayInorderByRecursion(root.getRight());
    }

    private static void displayInorderByIteration(A1_Node root) {
        if(root == null)
            return;

        Stack<A1_Node> stack = new Stack<>();
        List<Integer> inorder = new ArrayList<>();

        A1_Node curr = root;

        while (true){
            if(curr != null){
                stack.push(curr);
                curr = curr.getLeft();
            }else{
                if(stack.isEmpty()) {
                    break;
                }else{
                    A1_Node temp = stack.pop();
                    inorder.add(temp.getVal());
                    curr = temp.getRight();
                }

            }
        }
        System.out.println();
        System.out.println(inorder);
    }
}
