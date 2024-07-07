package n_graph.F_Other_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A2_Tarjans_Algo_Bridges_In_Graph {

    public static void main(String[] args) {
        int n = 4;

        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            connections.add(new ArrayList(Arrays.asList(0, 1)));
            connections.add(new ArrayList(Arrays.asList(1, 2)));
            connections.add(new ArrayList(Arrays.asList(2, 0)));
            connections.add(new ArrayList(Arrays.asList(1, 3)));
        }

        List<List<Integer>> bridges = new A2_Tarjans_Algo_Bridges_In_Graph().criticalConnections(n,connections);
        for(List<Integer> bridge : bridges)
            System.out.println(bridge);
    }
    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i< n;i++){
            graph.add(new ArrayList());
        }

        for(int i=0; i<connections.size();i++){
            graph.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            graph.get(connections.get(i).get(1)).add(connections.get(i).get(0));

        }

        boolean visited[] = new boolean[n];
        int [] insertionTime = new int[n];

        //the current node refers to all its adjacent nodes except the parent
        //  and takes the minimum lowest time of insertion into account.
        // To store this entity for each node, we will use another ‘low’ array.
        int [] adjWithLowestInsertionTime = new int[n];

        dfs(0,-1,graph,visited,insertionTime,adjWithLowestInsertionTime,bridges);
        return bridges;

    }


    public void dfs(int node, int parent, List<List<Integer>> graph, boolean [] visited,
                    int [] insertionTime, int [] adjWithLowestInsertionTime, List<List<Integer>> bridges){

        visited[node] = true;
        insertionTime[node] = adjWithLowestInsertionTime[node] = timer;
        timer++;
        for(Integer adjNode : graph.get(node)){
            if(parent == adjNode)
                continue;
            if(!visited[adjNode]){
                dfs(adjNode,node,graph,visited,insertionTime,adjWithLowestInsertionTime,bridges);
                adjWithLowestInsertionTime[node] = Math.min(adjWithLowestInsertionTime[node],adjWithLowestInsertionTime[adjNode]);
                // node --- it break creates another component?
                //If adjNode has any adj Node other than parent whose insertion time is less than node's insertion time then it cant create another component
                //since this node can be reached from that lowest insertion time node
                if(adjWithLowestInsertionTime[adjNode] > insertionTime[node]    ){
                    bridges.add(Arrays.asList(node,adjNode));
                }

            }else{
                adjWithLowestInsertionTime[node] = Math.min(adjWithLowestInsertionTime[node],adjWithLowestInsertionTime[adjNode]);
            }

        }

    }
}
