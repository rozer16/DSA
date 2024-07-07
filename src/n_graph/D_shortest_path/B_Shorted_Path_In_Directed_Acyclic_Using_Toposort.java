package n_graph.D_shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class B_Shorted_Path_In_Directed_Acyclic_Using_Toposort {

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

        int[] dis = shortestPath(n,m,edge);
        System.out.println(Arrays.toString(dis)); //[0, 2, 3, 6, 1, 5]
    }

    /*
    N = no of nodes
    M = no of edges
    edges = [a,b,c] : a -> b with c weight

    0 : {[1,2], [4,1]}
    1 : {[2,3]}
    2 : {[3,6]}
    3 : {}
    4 : {[[5,4],[2,2]]}
    5 : {[3,1]}


    * */
    public static int[] shortestPath(int N, int M, int[][] edges) {

        //1. Create a adj list from input
        /*
                0 : { Pair(1,2), Pair(4,1) }
                1 : { Pair(2,3)) }
        * */
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Pair> temp = new ArrayList<Pair>();
            adj.add(temp);
        }

        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }


        //2. Create a topo sort using BFS and store toposort in a stack
        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                dfs(i,visited,stack,adj);
            }
        }


        int [] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = (int) 1e9;
        }
        distance[0] = 0;
        //3/4 Iterate through topo sort and relax them
        while (!stack.isEmpty()) {
            int node = stack.pop();

            // In order to relax them, we simply do a simple comparison of dist[Prevnode] + wt and dist[adjNode].
            // Here dist[node] means the distance taken to reach the current node, and it is the edge weight between the node and the adjNode.

            for(Pair adjNode : adj.get(node)){
                //Because of topo sort all its adj node must have been visited and we know its distance from source node
                if(distance[adjNode.getAdjNode()] > distance[node]+adjNode.getWeight()){
                    distance[adjNode.getAdjNode()] = distance[node]+adjNode.getWeight();
                }
            }
        }

        //7) Once all the nodes have been iterated, the dist[] array will store the shortest paths and we can then return it.
        for (int i = 0; i < N; i++) {
            if(distance[i] == 1e9)
                distance[i] = -1;
        }

        return distance;
    }

    private static void dfs(int i, boolean[] visited, Stack<Integer> stack, List<List<Pair>> adj) {
        visited[i] = true;

        for(Pair pair: adj.get(i)){
            if(!visited[pair.getAdjNode()]){
                dfs(pair.getAdjNode(), visited,stack,adj);
            }
        }

        stack.push(i);
    }
}

class Pair {
    private int adjNode;
    private int weight;


    public Pair(int adjNode, int weight) {
        this.adjNode = adjNode;
        this.weight = weight;
    }

    public int getAdjNode() {
        return adjNode;
    }

    public void setAdjNode(int adjNode) {
        this.adjNode = adjNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
