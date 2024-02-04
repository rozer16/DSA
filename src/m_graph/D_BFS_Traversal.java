package m_graph;

import java.util.*;
public class D_BFS_Traversal {

    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }

        /*
        *               0
        *           1       4
        *        2     3
        *
        * Ajc List :
        *
        *   0 = {1,4}
        *   1 = {0,2,3}
        *   2 = {1}
        *   3 = {1}
        *   4 = {0}
        *
        *
        * */
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

       D_BFS_Traversal sl = new D_BFS_Traversal();
        ArrayList < Integer > ans = sl.bfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");  //0 1 4 2 3
        }
    }


    /*
        Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes(while loop).

        Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list
    *
    * */
    private ArrayList<Integer> bfsOfGraph(int noOfNodes, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[noOfNodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            bfs.add(node);
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer it: adj.get(node)) {
                if(!visited[it]) {
                    queue.offer(it);
                    visited[it] = true;
                }
            }

        }

        return bfs;
    }
}
