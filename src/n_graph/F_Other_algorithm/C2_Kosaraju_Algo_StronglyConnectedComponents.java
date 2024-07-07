package n_graph.F_Other_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class C2_Kosaraju_Algo_StronglyConnectedComponents {


    public static void main(String[] args) {
        int n = 5;

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1,0));
        edges.add(Arrays.asList(0,2));
        edges.add(Arrays.asList(2,1));
        edges.add(Arrays.asList(0,3));
        edges.add(Arrays.asList(3,4));

        C2_Kosaraju_Algo_StronglyConnectedComponents solution = new C2_Kosaraju_Algo_StronglyConnectedComponents();
        System.out.println("No of Strongly connected components for graph : "+solution.kosaraju(n,edges));
        //No of Strongly connected components for graph : 3
    }



    //Time Complexity:  O(V+E) + O(V+E) ~ O(V+E) ,
    // where V = no. of vertices, E = no. of edges.
    // The first step is a simple DFS, so the first term is O(V+E).
    // The second step of reversing the graph and the third step, containing DFS again, will take O(V+E) each.

    //Space Complexity:O(V)+O(V)+O(V)+O(V+E),
    // where V = no. of vertices, E = no. of edges.
    // Three O(V) for the visited array and the stack we have used & transpose. O(V+E) space for the reversed adjacent list.


    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, List<List<Integer>> edges) {

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adjTranspose = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            adjTranspose.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adjTranspose.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }


        //1 Sort nodes according to the finish time means starting node will be on top
        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i])
                dfs1(i,adj,visited,stack);
        }

        //2. Transpose the graph  which we already did while converting edges into graph

        //3
        visited = new boolean[V];
        int stronglyConnectedComponent = 0;
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(!visited[top]){
                stronglyConnectedComponent++;
                dfs2(top,adjTranspose,visited);
            }
        }


        return stronglyConnectedComponent;
    }

    private void dfs2(int i, List<List<Integer>> adj, boolean[] visited) {
        visited[i] = true;

        for(Integer adjNode : adj.get(i)){
            if(!visited[adjNode]){
                dfs2(adjNode,adj,visited);
            }
        }
    }

    private void dfs1(int i, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;

        for(Integer adjNode : adj.get(i)){
            if(!visited[adjNode]){
                dfs1(adjNode,adj,visited,stack);
            }
        }
        stack.push(i);
    }

}
