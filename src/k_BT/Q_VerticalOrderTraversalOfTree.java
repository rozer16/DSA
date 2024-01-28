
//https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/
package k_BT;


import java.util.*;

/*
*              -2 -1    0   1   2
*
*
*   Level1:             1
*   Level2:        2        3
*   Level3:     4     10|9      10
*   Level4:        5
*   Level5:            6
*
*   Vertical 0 : 4
*   Vertical 1 : 2,5
*   Vertical 2 : 1,9,10,6
*   vertical 3 : 3
*   vertical 4 : 10
*
*
*   Consider 0 as (0,0) graph, all nodes towards left are -x axis and right are +x axis
*   if we take left node of any node then vertical = parentNode_Vertical -1, level = parent_level +1
*   if we take right node of any node then vertical = parentNode_Vertical +1, level = parent_level +1
*
*   In above tree   Node        vertical        level
*                     1             0              1
*                     2            -1              2
*                     3             1              2
*                     4            -2              3
*                    10             0              3
*                     9             0              3
*                    10             2              3
*                     5            -1              4
*                     6             0              5
*
*
*  We can use two data structure to get verticals
*  TreeMap<Vertical, TreeMap<Level, PriorityQueue<Integer>>> map;
* */
public class Q_VerticalOrderTraversalOfTree {
    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List < List < Integer >> list = new ArrayList < > ();
        list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }

    }

    public static List < List < Integer >> findVertical(TreeNode root) {
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;


            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap < > ());
            }
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue < > ());
            }
            map.get(vertical).get(level).offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, vertical - 1, level + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, vertical + 1, level + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

}
class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class Tuple {
    TreeNode node;
    int vertical;
    int level;
    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        vertical = _row;
        level = _col;
    }
}