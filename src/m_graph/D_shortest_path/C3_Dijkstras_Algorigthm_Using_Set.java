package m_graph.D_shortest_path;

import java.util.*;

public class C3_Dijkstras_Algorigthm_Using_Set {

    public static void main(String[] args) {
        int V = 6, E = 3, S = 0;


        List<List<PairB>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new PairB(1, 4));
        adj.get(0).add(new PairB(2, 4));

        adj.get(1).add(new PairB(0, 4));
        adj.get(1).add(new PairB(2, 2));

        adj.get(2).add(new PairB(0, 4));
        adj.get(2).add(new PairB(1, 2));
        adj.get(2).add(new PairB(3, 3));
        adj.get(2).add(new PairB(4, 1));
        adj.get(2).add(new PairB(5, 6));

        adj.get(3).add(new PairB(2, 3));
        adj.get(3).add(new PairB(5, 2));


        adj.get(4).add(new PairB(2, 1));
        adj.get(4).add(new PairB(5, 3));

        adj.get(5).add(new PairB(2, 6));
        adj.get(5).add(new PairB(3, 2));
        adj.get(5).add(new PairB(4, 3));

        int[] distance = dijkstrasShortestDistance(V, adj, 0);
        System.out.println(Arrays.toString(distance));
    }

    private static int[] dijkstrasShortestDistance(int v, List<List<PairB>> adj, int source) {
        Set<PairB> set = new HashSet<>();

        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        set.add(new PairB(0, source));

        while (!set.isEmpty()) {
            PairB pair = set.iterator().next();
            set.remove(pair);

            for (PairB p : adj.get(pair.getVertex())) {
                int vertex = p.getVertex();
                int weight = p.getDistance();
                //Relaxing all edges
                if(pair.getDistance() + weight < distance[vertex]){
                    set.remove(new PairB(vertex,distance[vertex]));
                    distance[vertex] = pair.getDistance()+weight;
                    set.add(new PairB(vertex, pair.getDistance()+weight));
                }
            }
        }

        for (int i = 0; i < v; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                distance[i] = -1;
        }
        return distance;
    }


    static class PairB {
        int vertex;
        int distance;

        public PairB(int node, int distance) {
            this.vertex = node;
            this.distance = distance;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PairB pairB = (PairB) o;
            return vertex == pairB.vertex && distance == pairB.distance;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex, distance);
        }
    }
}