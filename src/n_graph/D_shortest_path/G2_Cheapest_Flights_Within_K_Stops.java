package n_graph.D_shortest_path;

import java.util.*;

public class G2_Cheapest_Flights_Within_K_Stops {

    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
            };

        System.out.println(new G2_Cheapest_Flights_Within_K_Stops().findCheapestPrice(n,flights,src,dst,K)); //700
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Create the adjacency list to depict airports and flights in
        // the form of a graph.
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length ; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        // Distance array to store the updated distances from the source.
        int [] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;

        // Create a queue which stores the node and their distances from the
        // source in the form of {stops, node, cost} with ‘stops’ indicating
        // the no. of nodes between src and current node.
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0,src,0));

        // Iterate through the graph using a queue like in Dijkstra with
        // popping out the element with min stops first.

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            int currentNode = tuple.getNode();
            int stopsSoFar = tuple.getStops();
            int costSoFar = tuple.getCost();

            //We will pop elements from queue until min stops is allowedStops+I2_No_Of_Ways_To_Arrive_Destination
            // We stop the process as soon as the limit for the stops reaches.
            if(stopsSoFar > k)
                continue;

            for(Pair pair : adj.get(currentNode)){
                int newCost = costSoFar + pair.getCost();

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                //Relaxing all edges
                if(distance[pair.getNode()] > newCost && stopsSoFar <= k){
                    distance[pair.getNode()] = newCost;
                    queue.offer(new Tuple(stopsSoFar+1, pair.getNode(), newCost));
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }


    static class Pair{
        int node;
        int cost;

        public Pair(int node, int distance) {
            this.node = node;
            this.cost = distance;
        }


        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }

    static  class Tuple{
        int stops;
        int node;
        int cost;

        public Tuple(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }

        public int getStops() {
            return stops;
        }

        public void setStops(int stops) {
            this.stops = stops;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }
}
