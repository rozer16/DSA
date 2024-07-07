package l_BT;

/*
https://takeuforward.org/binary-tree/print-nodes-at-distance-k-in-a-binary-tree/
* * */



import java.util.*;

public class Y_GetNodesFromKDistance {

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
        TreeNode root = new TreeNode(3);

        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        root.left = five;
        root.right = one;

        TreeNode six = new TreeNode(6);
        five.left = six;
        TreeNode two = new TreeNode(2);
        five.right = two;
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        two.left = seven;
        two.right = four;
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);
        one.left = zero;
        one.right = eight;

        Y_GetNodesFromKDistance test = new Y_GetNodesFromKDistance();
        List<Integer> result = test.distanceK(root,five,2);
        System.out.println(result);


    }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
      Map<TreeNode, TreeNode>  parent_track = new HashMap<>();
      markParents(root,parent_track);
      Map<TreeNode,Boolean> visited  = new HashMap<>();
      List<Integer> result = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(target);
      visited.put(target,true);
      int curr_size = 0;
      while(!queue.isEmpty()){
          int size = queue.size();
          if(curr_size == k)
              break;
          curr_size++;

          for (int i = 0; i < size; i++) {
              TreeNode node = queue.poll();
              if(node.left != null && !visited.containsKey(node.left)){
                  queue.offer(node.left);
                  visited.put(node.left,true);
              }
              if(node.right != null && !visited.containsKey(node.right)){
                  queue.offer(node.right);
                  visited.put(node.right,true);
              }

              if(parent_track.containsKey(node) && !visited.containsKey(parent_track.get(node))){
                  queue.offer(parent_track.get(node));
                  visited.put(parent_track.get(node),true);
              }
          }
      }

      while(!queue.isEmpty())
          result.add(queue.poll().val);

      return result;
  }

    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return;

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                parentTrack.put(node.left,node);
            }
            if(node.right != null){
                queue.offer(node.right);
                parentTrack.put(node.right,node);
            }
        }
    }

}
