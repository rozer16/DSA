package n_graph.B_BFS_DFS_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L_FindSafeNodeUsingDFS {

    public static boolean dfsCheckUsingAdjList(int node, boolean [] visited, boolean [] pathVisited, List<Integer> result, List<List<Integer>> adj){
        visited[node] = true;
        pathVisited[node] = true;


        for(int nodeNeigh : adj.get(node)){
            if(!visited[nodeNeigh]){
                if(dfsCheckUsingAdjList(nodeNeigh, visited,pathVisited,result,adj))
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path

            else if(pathVisited[nodeNeigh])
                return true;
        }

        result.add(node);
        pathVisited[node] = false;
        return false;
    }
    static  List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        boolean [] visited = new boolean[V];
        boolean [] pathVisited = new boolean[V];
        List<Integer> result = new ArrayList<>(V);
        for(int i = 0;i<adj.size();i++){
            if(!visited[i]){
                dfsCheckUsingAdjList(i,visited,pathVisited, result, adj);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static List<Integer> eventualSafeNodesUsingAdjMatrix(int[][] graph) {

        //Any node which is part of cycle or node is directly connected to any node which is part of cycle is not safe node
        //To detect a cycle
        int V = graph.length;

        boolean [] visited = new boolean[V];
        boolean [] pathVisited = new boolean[V];
        List<Integer> result = new ArrayList<>();


        for(int i = 0; i< V;i++){
            if(!visited[i]){
                dfsCheckUsingAjsArray(i,visited,pathVisited,graph,result);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static boolean dfsCheckUsingAjsArray(int node, boolean [] visited, boolean [] pathVisited, int [][] graph, List<Integer> result){
        visited[node] = true;
        pathVisited[node] = true;

        for(int i = 0; i<graph[node].length; i++){
            if(!visited[graph[node][i]]){
                if(dfsCheckUsingAjsArray(graph[node][i],visited,pathVisited,graph,result))
                    return true;
            } else if(pathVisited[graph[node][i]]){
                return true;
            }
        }

        result.add(node);
        pathVisited[node] = false;
        return false;
    }
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(5);
        adj.get(3).add(0);
        adj.get(4).add(5);

        System.out.println(eventualSafeNodes(7,adj));


        int [][] graph = {
                /*0 : */    {1,2,3,4},
                /*1 : */    {1,2},
                /*2 : */    {3,4},
                /*3 : */    {0,4}
        };
        System.out.println(eventualSafeNodesUsingAdjMatrix(graph));

    }


}