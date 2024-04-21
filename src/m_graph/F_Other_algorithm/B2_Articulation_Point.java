package m_graph.F_Other_algorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B2_Articulation_Point {

    int order = 1;
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> edges = new ArrayList<>();

            edges.add(Arrays.asList(0,1));
            edges.add(Arrays.asList(1,4));
            edges.add(Arrays.asList(2,4));
            edges.add(Arrays.asList(2,3));
            edges.add(Arrays.asList(3,4));

        B2_Articulation_Point solution = new B2_Articulation_Point();
        System.out.println("Critical Nodes : "+solution.articulationPoints(n,edges)); //1 4
    }

    public List<Integer> articulationPoints(int n,
                                            List<List<Integer>> edges ) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            graph.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i+":"+graph.get(i));
        }
        boolean [] visited = new boolean[n];
        int [] low = new int[n];
        int [] tin = new int[n];
        boolean [] mark = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i])
                dfs(i,-1,graph,low,tin,mark,visited);
        }

        List<Integer> articulationPoints = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(mark[i]){
                articulationPoints.add(i);
            }
        }

        if(articulationPoints.isEmpty()){
            articulationPoints.add(-1);
        }

        return articulationPoints;



    }


    public void dfs(int node, int parent, List<List<Integer>> graph, int [] low,  int [] tin, boolean [] mark, boolean[] visited){
        visited[node] = true;
        low[node] = tin[node] = order;
        order++;


        int child = 0;
        for(Integer adj : graph.get(node)){
            if(adj == parent)
                continue;

            if(!visited[adj]){
                dfs(adj,node,graph,low,tin,mark,visited);
                low[node] = Math.min(low[adj],low[node]);

                if(low[adj] >= tin[node] && parent != -1)
                    mark[node] = true;

                child++;
            }else{
                low[node] = Math.min(low[node], tin[adj]);
            }

        }

        if(child > 1 && parent == -1)
            mark[node] = true;
    }
}
