package k_BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* Left Right Root
*
* */
public class C_DFS_PostOrder {

    public static void main(String[] args) {
        A1_Node root = A1_Node.createTree();
        System.out.println("=============PostOrder Recursion=====");
        displayPostOrderTreeByRecursion(root);
        System.out.println("\n=============PostOrder Iteration1=====");
        displayPostOrderTreeByIteration1(root);
        System.out.println("\n=============PostOrder Iteration2=====");
        displayPostOrderTreeByIteration2(root);
    }

    private static void displayPostOrderTreeByRecursion(A1_Node root) {
        if (root == null) {
            return;
        }

        displayPostOrderTreeByRecursion(root.getLeft());
        displayPostOrderTreeByRecursion(root.getRight());
        System.out.print(root.getVal() + " ");

    }

    //Using two stacks
    private static void displayPostOrderTreeByIteration1(A1_Node root) {
        if (root == null)
            return;

        Stack<A1_Node> s1 = new Stack<>();
        Stack<A1_Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            A1_Node temp = s1.pop();
            if (temp.getLeft() != null)
                s1.push(temp.getLeft());
            if (temp.getRight() != null)
                s1.push(temp.getRight());

            s2.push(temp);
        }

        while (!s2.isEmpty()) {
            A1_Node temp = s2.pop();
            System.out.print(temp.getVal() + " ");
        }
    }

    //Using 1 stack
    private static void displayPostOrderTreeByIteration2(A1_Node root) {
        if(root == null){
            return;
        }
        List<Integer> postorder = new ArrayList<>();
        Stack<A1_Node> stack = new Stack<>();
        A1_Node curr = root;


        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.getLeft();
            }else{
                A1_Node temp = stack.peek().getRight();
                if(temp != null){
                    curr = temp;
                }else{
                    temp = stack.pop();
                    postorder.add(temp.getVal());
                    while (!stack.isEmpty() && stack.peek().getRight() == temp){
                        temp = stack.pop();
                        postorder.add(temp.getVal());
                    }
                }
            }
        }

        System.out.println(postorder);
    }
}