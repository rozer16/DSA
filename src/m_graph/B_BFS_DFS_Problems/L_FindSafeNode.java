package m_graph.B_BFS_DFS_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L_FindSafeNode {

    public static boolean dfsCheck(int node, boolean [] visited, boolean [] pathVisited, List<Integer> result, List<List<Integer>> adj){
        visited[node] = true;
        pathVisited[node] = true;


        for(int nodeNeigh : adj.get(node)){
            if(!visited[nodeNeigh]){
                if(dfsCheck(nodeNeigh, visited,pathVisited,result,adj))
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
                dfsCheck(i,visited,pathVisited, result, adj);
            }
        }
        Collections.sort(result);
        return result;
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

    }


}