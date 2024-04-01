package m_graph.C_Topo_Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//In topological sorting, node u will always appear before node v
// if there is a directed edge from node u towards node v(u -> v).
//Only valid on DAG (Directed Acyclic Graph)

//Depth First Search, DFS is a traversal technique where we visit a node and then continue visiting its adjacent nodes until we reach the end point,
//i.e., it keeps on moving in the depth of a particular node and then backtracks when no further adjacent nodes are available.
public class A_TopoSort_Using_DFS {


    public static void main(String[] args) {
        int V = 6;
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        List<Integer> result = topoSort(V,adj);
        System.out.println(result);

    }

    /*

     Time Complexity: O(V+E)+O(V), where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity
       Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for the visited array and the stack carried during DFS calls and O(N) for recursive stack space,
       *  where N = no. of nodes.
    *
    * */
    private static List<Integer> topoSort(int v, ArrayList<List<Integer>> adj) {
        boolean [] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if(!visited[i]){
                dfs(i,visited,stack,adj);
            }
        }
        List<Integer> result = new ArrayList<>(v);
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }

        return  result;
    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, ArrayList<List<Integer>> adj) {
        visited[node]=true;
        for(int neighNode : adj.get(node)){
            if(!visited[neighNode])
                dfs(neighNode,visited,stack,adj);
        }

        stack.push(node);
    }
}
