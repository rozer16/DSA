package m_graph.C_Topo_Sort;

import java.util.*;

public class E_FindSafeNodeUsingTopoSort {

    public List<Integer> eventualSafeNodes(int[][] graph) {


        //A node is a safe node if every possible path starting from that node leads to a terminal node.
        //A terminal node is a node without any outgoing edges(i.e outdegree = 0).
        //Since in toposort it works with indegree, we will reverse the link
        //so if we reverse the link, terminal node will have indegree as zero and then we will apply toposort algorithm

        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adjReverse = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjReverse.add(new ArrayList<>());
        }


        int [] indegree = new int[graph.length];

        //Loop to reverse the direction of nodes
        for (int i = 0; i < graph.length; i++) {
            for (int neighNode : graph[i]){
                adjReverse.get(neighNode).add(i);
                indegree[i]++;
            }
        }

        //Now apply topo sort using adjRev list and inDegree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for (int neighNode : adjReverse.get(node)){
                indegree[neighNode]--;
                if(indegree[neighNode] == 0)
                    queue.add(neighNode);
            }
        }


        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int [][] graph = {
                        /*0 : */    {1,2,3,4},
                        /*1 : */    {1,2},
                        /*2 : */    {3,4},
                        /*3 : */    {0,4}
                        };
    }


}
