package k_BT;


import com.sun.source.tree.Tree;

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
*   Queue : (Node,Vertical_Axis_Value, Level)
*   Map   : Vertical_Asix_Value -> Lavel -> Node
* */
public class Q_VerticalOrderTraversalOfTree {

    public static void main(String[] args) {
        A1_Node root = A1_Node.createTree();
        List<List<Integer>> verticalOrderNodes = getVerticalOrderNodesFromBT(root);
    }

    private static List<List<Integer>> getVerticalOrderNodesFromBT(A1_Node root) {
        Queue<Tuple> queue = new LinkedList<>();
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> tupleMap= new TreeMap<>();

        queue.offer(new Tuple(0,0,root));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            A1_Node node = tuple.getNode();
            int x = tuple.getVertical();
            int y = tuple.getLevel();

            if(!tupleMap.containsKey(x))
                tupleMap.put(x, new TreeMap<>());
            if(!tupleMap.get(x).containsKey(y))
                tupleMap.get(x).put(y,new PriorityQueue<>());

            tupleMap.get(x).get(y).offer(node.getVal());

            if(node.getLeft() != null)
                queue.offer(new Tuple(x-1,y+1,node.getLeft()));
            if(node.getRight() != null)
                queue.offer(new Tuple(x+1,y+1,node.getRight()));
        }

        List<List<Integer>> result = new ArrayList<>();
        for(Map<Integer, PriorityQueue<Integer>> treeEntry : tupleMap.values()){
                List<Integer> tempList = new ArrayList<>();
                for(PriorityQueue<Integer> values : treeEntry.values()){
                    while (!values.isEmpty())
                        tempList.add(values.poll());
                }
                result.add(tempList);
        }
        return result;
    }


    static class Tuple{
        int vertical;
        int level;
        A1_Node node;

        public Tuple(int vertical, int level, A1_Node node) {
            this.vertical = vertical;
            this.level = level;
            this.node = node;
        }

        public int getVertical() {
            return vertical;
        }

        public void setVertical(int vertical) {
            this.vertical = vertical;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public A1_Node getNode() {
            return node;
        }

        public void setNode(A1_Node node) {
            this.node = node;
        }
    }
}
