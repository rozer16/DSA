package m_graph.C_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C_DetectCycleInDirectedGraph {

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

        System.out.println(detectCycle(V,adj));
    }

    private static boolean detectCycle(int v, List<List<Integer>> adj) {
        int [] inDegree = new int[v];
        int cnt = 0;


        for (int i = 0; i < v; i++) {
            for (int node : adj.get(i))
                inDegree[node]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }


        while(!queue.isEmpty()){
            int node = queue.remove();
            //Instead of putting nodes into list, count
            cnt++;
            for(int neigh : adj.get(node)){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0)
                    queue.add(neigh);
            }
        }

        System.out.println(cnt);

        //If No of node = cnt then cycle not found else found
        if(cnt == v)
            return false;
        else
            return true;
    }
}
