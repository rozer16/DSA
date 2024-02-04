package m_graph.A_Learning;


import java.util.*;

public class E_DFS {
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }


        /*
         *                  0
         *               2    1   3
         *             4
         *
         * Adj List :
         *
         *   0 = {1,4}
         *   1 = {0,2,3}
         *   2 = {1}
         *   3 = {1}
         *   4 = {0}
         * */
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        E_DFS sl = new E_DFS();
        ArrayList < Integer > ans = sl.dfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); //0 2 4 1 3
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    //Time Complexity:
                //  For an undirected graph, O(N) + O(2E),
                //  For a directed graph, O(N) + O(E),
    // Because for every node we are calling the recursive function once, the time taken is O(N)
    // and 2E is for total degrees as we traverse for all adjacent nodes.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //boolean array to keep track of visited vertices
        boolean vis[] = new boolean[V+1];

        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }

    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj,
                           ArrayList<Integer> ls) {

        //marking current node as visited
        vis[node] = true;
        ls.add(node);

        //getting neighbour nodes
        for(Integer it: adj.get(node)) {
            if(vis[it] == false) {
                dfs(it, vis, adj, ls);
            }
        }
    }
}
