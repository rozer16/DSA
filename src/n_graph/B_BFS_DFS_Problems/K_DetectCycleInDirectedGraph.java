package n_graph.B_BFS_DFS_Problems;

import java.util.ArrayList;
import java.util.List;

public class K_DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        int V = 11;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);


        /*
        *   1 {2}
        *   2 {3}
        *   3 {4,7}
        *   4 {5}
        *   5 {6}
        *   6 {}
        *   7 {5}
        *   8 {9}
        *   9 {10}
        *   10 {8}
        *
        *
        *   1-> 2 -> 3 ->  4
        *       8    |     |
        *     |   |  7 ->  5 -> 6
        *   9  -> 10
        * */


        //System.out.println(isCyclic(11,adj));

        adj = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(6).add(5);
        adj.get(5).add(6);

        System.out.println(isCyclic(7,adj));

    }

    public static boolean isCyclic(int V, List<List<Integer>> adj) {

        //The visited array keeps a track of visited nodes,
        // The path-visited keeps a track of visited nodes in the current traversal only
        int vis[] = new int[V];
        int pathVis[] = new int[V];

        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                if(dfs(i,adj,vis,pathVis))
                    return true;
            }

        }
        return false;
    }

    private static boolean dfs(int v, List<List<Integer>> adj, int[] vis, int[] pathVis) {
        vis[v] = 1;
        pathVis[v] = 1;

        for(int adjN : adj.get(v)){
            //If vis[adjN] == 1 then it was already previously visited and no cycle detected so no meaning to check from same node again if cycle exists.
            if(vis[adjN] == 0)
                dfs(adjN,adj,vis,pathVis);
            //If node was visited earlier but was that visited using different path(pathVis[adjN] = 0) or same path(pathVis[adjN] = 1)
            else if(pathVis[adjN] == 1)
                return true;
        }

        pathVis[v] = 0;
        return false;
    }
}
