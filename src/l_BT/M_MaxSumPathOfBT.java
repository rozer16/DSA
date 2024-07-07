/*

https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/
*/

package l_BT;

public class M_MaxSumPathOfBT {

    public static void main(String[] args) {
        A1_Node root = A1_Node.createTree();
        int sum = getMaxSumPathOfBT(root);
    }

    private static int getMaxSumPathOfBT(A1_Node root) {
        int [] maxSumPath = new int[1];
        maxSumPath[0] = Integer.MIN_VALUE;
        setMaxSumPath(root, maxSumPath);
        return maxSumPath[0];
    }

    private static int setMaxSumPath(A1_Node root, int[] maxSumPath) {
        if(root == null)
            return 0;

        int ls = setMaxSumPath(root.getLeft(),maxSumPath);
        int rs = setMaxSumPath(root.getRight(), maxSumPath);

        maxSumPath[0] = Math.max(maxSumPath[0],root.getVal()+ls+rs);


        return root.getVal()+Math.max(ls,rs);

    }
}
