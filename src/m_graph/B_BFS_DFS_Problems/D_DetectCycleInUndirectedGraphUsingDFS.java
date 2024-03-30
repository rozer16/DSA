package m_graph.B_BFS_DFS_Problems;

import java.util.ArrayList;
import java.util.List;

public class D_DetectCycleInUndirectedGraphUsingDFS {


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
        //Looping visited since map can be multi connected
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                //If current node is visited then return true and dont check further
                if(dfsDetectCycle(i,-1,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsDetectCycle(int start, int parent, List<List<Integer>> adj, boolean [] visited){

        visited[start] = true;
        for (int neigh : adj.get(start)){
            // If current node is not visited then its already marked as visited and iterate all its adjacent
            if(!visited[neigh]){
                if(dfsDetectCycle(neigh,start,adj,visited))
                    return true;
             //If node is visited and neighbour is not parent of current node than its cycle!!
            }else if (neigh != parent) {
                return true;
            }
        }

        return false;
    }
}
