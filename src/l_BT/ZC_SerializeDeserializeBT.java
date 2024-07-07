package l_BT;



import java.util.LinkedList;
import java.util.Queue;

/*
* https://youtu.be/-YbXySKJsX8
* https://takeuforward.org/data-structure/serialize-and-deserialize-a-binary-tree/
*
*
*
*                   1
*           2               13
*                   X|4               5
* 
* 
*   Serialize : 1 2 13 X X 4 5 X X X X
*   
*
*
* */
public class ZC_SerializeDeserializeBT {


    static String EMPTY_NODE = "#";
    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        TreeNode three = new TreeNode(3,four,five);

        TreeNode two = new TreeNode(2);

        TreeNode root = new TreeNode(1,two,three);

        String serialize = getSerializedString(root);
        System.out.println("Serialized String is : "+serialize);

        TreeNode newroot = deSerialize(serialize);
    }

    private static TreeNode deSerialize(String serialize) {
        if(serialize == null || "".equals(serialize) || EMPTY_NODE.equals(serialize)){
            return null;
        }

        String [] nodeVals = serialize.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode node = new TreeNode(Integer.parseInt(nodeVals[0]));
        queue.offer(node);
        for (int i = 1; i < nodeVals.length; i++) {
            TreeNode s = queue.poll();

            if(EMPTY_NODE.equals(nodeVals[i])){
                //queue.offer(null);
                continue;

            }else{
                TreeNode left = new TreeNode(Integer.parseInt(nodeVals[0]));
                s.left = left;
                queue.offer(left);
            }

            i=i+1;
            if(EMPTY_NODE.equals(nodeVals[i])){
                //queue.offer(null);

            }else{
                TreeNode right = new TreeNode(Integer.parseInt(nodeVals[0]));
                s.right = right;
                queue.offer(right);
            }
        }

        return  node;
    }

    private static String getSerializedString(TreeNode root) {
        if(root == null)
            return EMPTY_NODE;
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            if(node == null){
                result.append(EMPTY_NODE+" ");
                continue;
            }
            result.append(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);

        }

        return result.toString();
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
