package n_graph.D_shortest_path;

import java.util.*;

public class D2_Source_To_Dest_Shorted_Path_Using_Dijkstras {

    public static void main(String[] args) {
        int V = 5, E = 6;

        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};

        System.out.println(shortestPath(V, E, edges));

    }


    public static List<Integer> shortestPath(int n, int m, int edges[][]) {


        // Create an adjacency list of pairs of the form node1 -> {node2, edgeWeight}
        // where the edge weight is the weight of the edge from node1 to node2.

        List<List<Pair>> adjL = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjL.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjL.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adjL.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }


        // Create a dist array for storing the updated distances and a parent array
        //for storing the nodes from where the current nodes represented by indices of
        // the parent array came from.
        int [] distance = new int[n+1];
        int [] parent = new int[n+1];

        Arrays.fill(distance,Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getDistance));
        distance[1] = 0;
        pq.offer(new Pair(1,0));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int parentNode = pair.getVertex();
            int parentWeight = pair.getDistance();


            for(Pair pair1: adjL.get(parentNode)){

                // Check if the previously stored distance value is
                // greater than the current computed value or not,
                // if yes then update the distance value.
                //Relaxing all edges
                if(parentWeight + pair1.getDistance() < distance[pair1.getVertex()]){
                    distance[pair1.getVertex()] = parentWeight + pair1.getDistance();
                    pq.offer(new Pair(pair1.getVertex(),parentWeight + pair1.getDistance()));

                    // Update the parent of the adjNode to the recent
                    // node where it came from.
                    parent[pair1.vertex] = parentNode;
                }
            }
        }

        // Store the final path in the ‘path’ array.
        List<Integer> path = new ArrayList<>();

        // If distance to a node could not be found, return an array containing -I2_No_Of_Ways_To_Arrive_Destination.
        if(distance[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }

        path.add(1);

        // Since the path stored is in a reverse order, we reverse the array
        // to get the final answer and then return the array.
        Collections.reverse(path);
        return path;
    }



    static class Pair {
        int vertex;
        int distance;

        public Pair(int node, int distance) {
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
            C3_Dijkstras_Algorigthm_Using_Set.PairB pairB = (C3_Dijkstras_Algorigthm_Using_Set.PairB) o;
            return vertex == pairB.vertex && distance == pairB.distance;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex, distance);
        }
    }
}

