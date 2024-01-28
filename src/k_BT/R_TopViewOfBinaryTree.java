/*

https://takeuforward.org/data-structure/top-view-of-a-binary-tree/
*/
package k_BT;


import java.util.*;

/*
*
 *   horizontal -2 -1    0   1   2
 *
 *
 *   Level1:             1
 *   Level2:        2        3
 *   Level3:     4     10|9      10
 *   Level4:        5
 *   Level5:            6
 *
*
*
* Top view of binary tree : 4 2 1 3 10 (Taking top element from each horizontal line
*
*
*
			1
		2		3
	4		5|6		7
*
*
*
*   Top view : 4 2 1 3 7
*
*   Pair : Node,Vertical
*   Queue<Pair>
    TreeMap<Vertical,val>
* */


public class R_TopViewOfBinaryTree {

    public static void main(String[] args) {
        A1_Node node = A1_Node.createTree();
        List<Integer> topviewList = getTopViewNodeValues(node);
        System.out.println(topviewList);
    }

    private static List<Integer> getTopViewNodeValues(A1_Node node) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        if(node == null)
            return result;

        queue.offer(new Pair(node,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                A1_Node curr = pair.getNode();
                int vertical = pair.getVertical();

                if(!map.containsKey(vertical))
                    map.put(vertical,curr.getVal());

                if(curr.getLeft() != null)
                    queue.offer(new Pair(curr.getLeft(),vertical-1));
                if(curr.getRight() != null)
                    queue.offer(new Pair(curr.getRight(),vertical+1));
            }

        }

        result.addAll(map.values());

        return result;

    }


    static class Pair{
        A1_Node node;
        int vertical;


        public Pair(A1_Node node, int level) {
            this.node = node;
            this.vertical = level;
        }

        public A1_Node getNode() {
            return node;
        }

        public void setNode(A1_Node node) {
            this.node = node;
        }

        public int getVertical() {
            return vertical;
        }

        public void setVertical(int vertical) {
            this.vertical = vertical;
        }
    }
}
