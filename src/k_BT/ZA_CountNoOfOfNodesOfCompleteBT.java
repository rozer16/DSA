package k_BT;


/*
*https://takeuforward.org/binary-tree/count-number-of-nodes-in-a-binary-tree/
* https://youtu.be/u-yWemKGWO0
*
*
*   Complete BT : All levels except the last one are completely filled. The last level may or may not be completely filled.
                Nodes in the last level are as left as possible.
                    1
             2              3
         4      5       6       7


                             1
                      2              3
                                  6
                               7
*
*
* */
public class ZA_CountNoOfOfNodesOfCompleteBT {


    public static void main(String[] args) {

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);



        TreeNode two = new TreeNode(2,four,null);
        TreeNode three = new TreeNode(3,six,null);

        TreeNode node = new TreeNode(1,two,three);

        ZA_CountNoOfOfNodesOfCompleteBT test = new ZA_CountNoOfOfNodesOfCompleteBT();
        System.out.println(test.countNodes(node));
        //System.out.println(countNodesStatic(node));
    }


    //Complexity : O(Log^2 N) Approach
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        int rh = getRightHeight(root);
        int lh = getLeftHeight(root);

        if(rh == lh)
            return (1<<lh)-1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }


    public int getRightHeight(TreeNode root){
        if(root == null)
            return 0;
        int height = 0;
        TreeNode temp = root;
        while(temp != null){
            height++;
           temp = temp.right;
        }
        return height;
    }
    public int getLeftHeight(TreeNode root){
        if(root == null)
            return 0;
        int height = 0;
        TreeNode temp = root;
        while(temp != null){
            height++;
            temp = temp.left;
        }
        return height;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
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
