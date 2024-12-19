/*

https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/
*/

package l_BT;

import java.util.*;


/*
*
*
*                     1
             2              3
         4      5       6       7
*
* [[1], [3, 2], [4, 5, 6, 7]]
*
* */
public class O_ZigzagLevelOrderOfBT {
    public static void main(String[] args) {
        A1_Node node = A1_Node.createTree();

        List<List<Integer>> result =  zigzagLevelOrderOfBT(node);
        System.out.println(result);

    }

    public List<List<Integer>> ZigZagLevelOrder(Node root) {
        // List to store the
        // result of zigzag traversal
        List<List<Integer>> result = new ArrayList<>();

        // Check if the root is null,
        // return an empty result
        if (root == null) {
            return result;
        }

        // Queue to perform
        // level order traversal
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        // Flag to determine the direction of
        // traversal (left to right or right to left)
        boolean leftToRight = true;

        // Continue traversal until
        // the queue is empty
        while (!nodesQueue.isEmpty()) {
            // Get the number of nodes
            // at the current level
            int size = nodesQueue.size();

            // List to store the values
            // of nodes at the current level
            List<Integer> row = new ArrayList<>();

            // Traverse nodes at
            // the current level
            for (int i = 0; i < size; i++) {
                // Get the front node
                // from the queue
                Node node = nodesQueue.poll();

                // Determine the index to insert the node's
                // value based on the traversal direction
                int index = leftToRight ? i : (size - 1 - i);

                // Insert the node's value at
                // the determined index
                row.add(index, node.data);

                // Enqueue the left and right
                // children if they exist
                if (node.left != null) {
                    nodesQueue.add(node.left);
                }
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }

            // Switch the traversal
            // direction for the next level
            leftToRight = !leftToRight;

            // Add the current level's
            // values to the result list
            result.add(row);
        }

        // Return the final result of
        // zigzag level order traversal
        return result;
    }

    private static List<List<Integer>> zigzagLevelOrderOfBT(A1_Node node) {
        List<List<Integer>> result = new ArrayList<>();
        if(node == null)
            return result;
        Queue<A1_Node> queue = new LinkedList<>();
        queue.offer(node);
        boolean ltr = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                A1_Node tempNode = queue.poll();
                temp.add(tempNode.getVal());
                if(tempNode.getLeft() != null)
                    queue.offer(tempNode.getLeft());

                if(tempNode.getRight() != null)
                    queue.offer(tempNode.getRight());
            }

            if(ltr)
                Collections.reverse(temp);
            ltr = !ltr;
            result.add(temp);
        }

        return result;

    }
}
