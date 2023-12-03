package k_BT;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* https://takeuforward.org/data-structure/construct-a-binary-tree-from-inorder-and-preorder-traversal/
* https://youtu.be/aZNaLrVebKQ
*
*
*
* */
public class ZB_ForBTFromInOrderAndPreOrder {

    public static void main(String[] args) {

        int [] inorder = {40,20,50,10,60,30};
        int [] preorder = {10,20,40,50,30,60};

        TreeNode node = getBinaryTree(inorder,preorder);
        System.out.println(node);
    }

    private static TreeNode getBinaryTree(int[] inorder, int[] preorder) {
        Map<Integer,Integer> inOrderNodValueIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderNodValueIndex.put(inorder[i],i);
        }

        return getBinaryTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inOrderNodValueIndex);


    }

    private static TreeNode getBinaryTree(int[] preorder, int preStartInd, int preEndInd,int[] inorder, int inStartInd, int inEndInd,  Map<Integer,Integer> inOrderNodValueIndexMap) {
            if(inStartInd > inEndInd || preStartInd > preEndInd)
                return null;
            TreeNode root = new TreeNode(preorder[preStartInd]);

            int inorderRootIndex = inOrderNodValueIndexMap.get(preorder[preStartInd]);
            int leftTreeNodeCount = inorderRootIndex - inStartInd;

            root.left = getBinaryTree(
                    preorder,preStartInd+1,preStartInd+leftTreeNodeCount,
                    inorder,inStartInd,inorderRootIndex-1,
                    inOrderNodValueIndexMap);

            root.right = getBinaryTree(
                    preorder,preStartInd+leftTreeNodeCount+1,preEndInd,
                    inorder,inorderRootIndex+1,inEndInd,
                    inOrderNodValueIndexMap);
            return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
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
