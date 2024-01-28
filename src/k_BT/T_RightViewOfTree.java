/*

https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
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
* Bottom view of binary tree : 1 3 10 5 6 (Taking right most element from each  level
*
*
*
			1
		2		3
	4		5|6		7
*
*
*
*   Top view : 1,3,7
*
*   Pair : Node,Level
*   Queue<Pair>
    TreeMap<Level,Nodeval>
* */
public class T_RightViewOfTree {
    public static void main(String[] args) {
        A1_Node node = A1_Node.createTree();
        List<Integer> bottomViewEle = getRightViewEleByRecursion(node);
        System.out.println(bottomViewEle);
    }

    private static List<Integer> getRightViewEleByRecursion(A1_Node node){
        List<Integer> result = new ArrayList<>();
        getRightViewEleByRecursion(node,0,result);
        return result;
    }

    private static void getRightViewEleByRecursion(A1_Node node, int level, List<Integer> result) {
        //Following reverse preorder i.e. root right left

        if(node == null)
            return;

        if(result.size() == level)
            result.add(node.getVal());

        getRightViewEleByRecursion(node.getRight(),level+1,result);
        getRightViewEleByRecursion(node.getLeft(),level+1,result);

    }

    private static List<Integer> getRightViewEle(A1_Node node) {


        List<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();

        if(node == null)
            return result;

        queue.offer(new Pair(node,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                A1_Node curr = pair.getNode();
                int level = pair.level;

                map.put(level,curr.getVal());

                if(curr.getLeft() != null)
                    queue.offer(new Pair(curr.getLeft(), level+1));
                if(curr.getRight() != null)
                    queue.offer(new Pair(curr.getRight(), level+1));
            }
        }

        result.addAll(map.values());


        return result;


    }

    static  class Pair{
        A1_Node node ;
        int level;

        public Pair(A1_Node node, int vertical) {
            this.node = node;
            this.level = vertical;
        }

        public A1_Node getNode() {
            return node;
        }

        public void setNode(A1_Node node) {
            this.node = node;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
