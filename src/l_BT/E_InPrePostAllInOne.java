/*
https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/
*/
package l_BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class E_InPrePostAllInOne {

    static class Pair{
        A1_Node node;
        int num;


        public Pair(A1_Node node, int num) {
            this.node = node;
            this.num = num;
        }

        public A1_Node getNode() {
            return node;
        }

        public void setNode(A1_Node node) {
            this.node = node;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        A1_Node root = A1_Node.createTree();
        DisplayInPrePostAllInOn(root);
    }

    /*
    *
    *   Pair : Node, num
    *   Stack<Pair> stack = new Stack();
    *
    *
    *   if(pair.num == 1)
    *           PreOrder
    *           pair.num++
    *           left
    *   if(pair.num == 2)
     *           InOrder
     *           pair.num++
     *           right
    *   if(pair.num == 3)
     *           PostOrder
    * */
    private static void DisplayInPrePostAllInOn(A1_Node root) {
        if(root == null)
            return;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,1));
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        while(!stack.isEmpty()){
            Pair pair = stack.pop();

            //Push left side of tree
            if(pair.getNum() == 1){
                preorder.add(pair.getNode().getVal());
                pair.setNum(pair.getNum()+1);
                stack.push(pair);

                if(pair.getNode().getLeft() != null){
                    stack.push(new Pair(pair.getNode().getLeft(),1));
                }
                //Push right side of tree
            } else if (pair.getNum() == 2) {
                inorder.add(pair.getNode().getVal());
                pair.setNum(pair.getNum()+1);
                stack.push(pair);

                if(pair.getNode().getRight() != null){
                    stack.push(new Pair(pair.getNode().getRight(),1));
                }
            }else{
                postorder.add(pair.getNode().getVal());
            }
        }
        System.out.println("PreOrder : "+preorder);
        System.out.println("InOrder : "+inorder);
        System.out.println("PostOrder : "+postorder);
    }


}
