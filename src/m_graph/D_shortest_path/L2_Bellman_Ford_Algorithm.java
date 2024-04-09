package m_graph.D_shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2_Bellman_Ford_Algorithm {

    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        List<List<Integer>> edges = new ArrayList() {
            {
                add(new ArrayList<>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<>(Arrays.asList(2, 4, 3)));
            }
        };

        System.out.println(Arrays.toString(new L2_Bellman_Ford_Algorithm().bellman_ford(V,edges,S)));
    }

    // V x E
    public int[] bellman_ford(int V,
                              List<List<Integer>> edges, int S) {

        int [] distanace = new int[V];
        Arrays.fill(distanace, Integer.MAX_VALUE);
        distanace[S] = 0;

        for (int i = 0; i < V-1; i++) {
            if(distanace[edges.get(i).get(0)] != Integer.MAX_VALUE
                &&  distanace[edges.get(i).get(1)]  > distanace[edges.get(i).get(0)] + edges.get(i).get(2)
            ){
                distanace[edges.get(i).get(1)] = distanace[edges.get(i).get(0)] + edges.get(i).get(2);
            }
        }

        for (int i = 0; i < edges.size(); i++) {
            int source = edges.get(i).get(0);
            int dest = edges.get(i).get(1);
            int weight = edges.get(i).get(2);

            if(distanace[source] + weight < distanace[dest])
                return new int[]{-1};
        }
        return distanace;
    }
}
