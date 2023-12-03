package k_BT;


/*

https://takeuforward.org/data-structure/morris-preorder-traversal-of-a-binary-tree/

https://www.youtube.com/watch?v=80Zug6D1_r4
 */
public class ZD_MorrisPreorderTraversalOFBT {

    public static void main(String[] args) {

    }
    static class TreeNode {
        int val;
        ZC_SerializeDeserializeBT.TreeNode left;
        ZC_SerializeDeserializeBT.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, ZC_SerializeDeserializeBT.TreeNode left, ZC_SerializeDeserializeBT.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
