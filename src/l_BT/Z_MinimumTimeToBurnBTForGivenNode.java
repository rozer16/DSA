package l_BT;


import java.util.*;

public class Z_MinimumTimeToBurnBTForGivenNode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        root.left = two;
        root.right = three;

        TreeNode four = new TreeNode(4);
        two.left = four;

        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        three.left = five;
        three.right = six;

        TreeNode seven = new TreeNode(7);
        four.right = seven;

        Z_MinimumTimeToBurnBTForGivenNode test = new Z_MinimumTimeToBurnBTForGivenNode();
        System.out.println(test.getMaxDistance(root,2));

    }

    private int getMaxDistance(TreeNode root,int nodeVal){
        int timeToBurn = 0;
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        TreeNode target = markParents(root,parentTrack,nodeVal);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        while (!queue.isEmpty()){
            int size = queue.size();
            boolean isBurned = false;


            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                if(node.left != null && !visited.contains(node.left)){
                    isBurned = true;
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    isBurned = true;
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                if(parentTrack.containsKey(node) && !visited.contains(parentTrack.get(node))){
                    isBurned = true;
                    visited.add(parentTrack.get(node));
                    queue.add(parentTrack.get(node));
                }
            }

            if(isBurned)
                timeToBurn++;
        }



        return timeToBurn;
    }

    private TreeNode markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode start = null;
        if(root == null)
            return start;

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val == val)
                start = node;
            if(node.left != null){
                queue.offer(node.left);
                parentTrack.put(node.left,node);
            }
            if(node.right != null){
                queue.offer(node.right);
                parentTrack.put(node.right,node);
            }
        }
        return start;
    }
}
