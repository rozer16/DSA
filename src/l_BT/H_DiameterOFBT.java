/*
https://takeuforward.org/data-structure/calculate-the-diameter-of-a-binary-tree/
*/
package l_BT;


/*
* Definition of Diameter of MT
*   Longest path between two nodes
*   For calculating diameter, not necessary that root node should be part of path, it can be, cant be
*
* */
public class H_DiameterOFBT {

    public static void main(String[] args) {
        A1_Node node = A1_Node.createTree();
        System.out.println(getDiaMeterOfBt(node));
    }

    private static int getDiaMeterOfBt(A1_Node node) {
        int [] diameter = new int[1];
        getHeightOfBt(node,diameter);
        return diameter[0];
    }

    private static int getHeightOfBt(A1_Node node, int[] diameter) {
        if(node == null)
            return 0;

        int hl = getHeightOfBt(node.getLeft(),diameter);
        int hr = getHeightOfBt(node.getRight(),diameter);

        diameter[0] = Math.max(diameter[0], hl+hr);

        return 1+Math.max(hl,hr);
    }
}
