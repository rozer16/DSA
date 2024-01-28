/*
https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/
*/

package k_BT;

public class F_FindHightOfBT {

    public static void main(String[] args) {
        A1_Node node = A1_Node.createTree();
        System.out.println(getHeight(node));
    }

    public static int getHeight(A1_Node node){
        if(node == null)
            return 0;

        int lh = getHeight(node.getLeft());
        int rh = getHeight(node.getRight());

        return 1+Math.max(lh,rh);
    }
}
