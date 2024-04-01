package m_graph.C_Topo_Sort;

import java.util.*;



//In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).
//Only valid on DAG (Directed Acyclic Graph)
public class B_Kahns_Algo_For_TopoSort {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        List<Integer> result = topoSortUsingKahnsAlgo(V,adj);
        System.out.println(result);
    }


    /*
    *
    * Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

      Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).
    * */
    private static List<Integer> topoSortUsingKahnsAlgo(int v, List<List<Integer>> adj) {
        int [] inDegreeArr = new int[v];
        Queue<Integer> queue = new LinkedList<>();

        /*Get Indegree of all node

             if 1 -> {2,3} then 2 and 3 node has in degree node 1. i.e. indegree[2]++, indress[3]++
         */


        for (int i = 0; i < v; i++) {
            for(int node : adj.get(i)){
                inDegreeArr[node]++;
            }
        }


        //There would be least one node in graph which will have indegree 0
        for (int i = 0; i < v; i++) {
            if(inDegreeArr[i] == 0){
                queue.offer(i);
            }
        }

        //TODO : Is there always a case after removing link between node, there always be a node having indegree zero
        // and it will be added to queue.
        List<Integer> result = new ArrayList<>(v);
        while (!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);


            for(int neighNode : adj.get(node)){
                inDegreeArr[neighNode]--;
                if(inDegreeArr[neighNode] == 0)
                    queue.offer(neighNode);
            }
        }
        return result;
    }
}
