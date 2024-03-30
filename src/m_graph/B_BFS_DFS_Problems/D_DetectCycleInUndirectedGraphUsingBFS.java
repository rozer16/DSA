package m_graph.B_BFS_DFS_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D_DetectCycleInUndirectedGraphUsingBFS {


    /*
    * Time complexity : O(N) + 2E (Since traveling each node(n) and then checking all its adjacent node(2E) so total degrees as we traverse all adjacent nodes
    * Space Complexity: O(N) + O(N) ~ O(N), Space for queue data structure and visited array.
    *
    *
    * */
    public static void main(String[] args) {
        ArrayList <List< Integer >> adj = new ArrayList < > (5);
        for (int i = 0; i <= 5; i++) {
            adj.add(new ArrayList < > ());
        }


        /*
         *
         *              1   3
         *          0           5
         *              2   4
         *
         *
         * Adj List :
         *
         *   0 = {1,2}
         *   1 = {0,3}
         *   2 = {0,4}
         *   3 = {1,5}
         *   4 = {2,5}
         *   5 = {3,4}
         * */

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(3).add(5);
        adj.get(4).add(2);
        adj.get(4).add(5);
        adj.get(5).add(3);
        adj.get(5).add(4);

        System.out.println(detectCycle(0,adj));

    }

    public static boolean detectCycle(int src, List<List<Integer>> adj){
        boolean [] visited = new boolean[adj.size()];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                if(bfsDetectCycle(i,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfsDetectCycle(int start, List<List<Integer>> adc, boolean [] visited){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start,-1));
        visited[start] = true;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            for(int neighbour : adc.get(pair.getNodeVal())){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(new Pair(neighbour,pair.getNodeVal()));
                } else if (neighbour != pair.getParentVal()) {
                    return true;
                }
            }

        }
        return false;
    }


    static class Pair {
        int nodeVal;
        int parentVal;

        public Pair(int nodeVal, int parentVal) {
            this.nodeVal = nodeVal;
            this.parentVal = parentVal;
        }

        public int getNodeVal() {
            return nodeVal;
        }

        public void setNodeVal(int nodeVal) {
            this.nodeVal = nodeVal;
        }

        public int getParentVal() {
            return parentVal;
        }

        public void setParentVal(int parentVal) {
            this.parentVal = parentVal;
        }
    }
}
