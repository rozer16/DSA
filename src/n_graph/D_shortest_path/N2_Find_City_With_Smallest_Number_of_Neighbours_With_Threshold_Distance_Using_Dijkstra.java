package n_graph.D_shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class N2_Find_City_With_Smallest_Number_of_Neighbours_With_Threshold_Distance_Using_Dijkstra {

    public static void main(String[] args) {
        int n = 4;

        int[][] edges =  {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;

        N2_Find_City_With_Smallest_Number_of_Neighbours_With_Threshold_Distance_Using_Dijkstra solution = new N2_Find_City_With_Smallest_Number_of_Neighbours_With_Threshold_Distance_Using_Dijkstra();
        System.out.println(solution.findTheCity(n,edges,distanceThreshold));
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<Pair>> ajd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ajd.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            ajd.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            ajd.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            int [] shortestDistFromI = getMinDistance(i,ajd,n);
            System.arraycopy(shortestDistFromI,0,dist[i],0,n);

            dist[i][i] = 0;
        }

        int noOfCities = n;
        int citino = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int ajdCiti = 0; ajdCiti < n; ajdCiti++) {
                if(dist[city][ajdCiti] <= distanceThreshold)
                    cnt++;
            }

            if(cnt <= noOfCities){
                noOfCities = cnt;
                citino = city;
            }
        }



        return citino;
    }

    public int [] getMinDistance(int src,  List<List<Pair>> adj, int V){

        int [] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[src] = 0;

        Queue<Pair>  queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getDistance));
        queue.offer(new Pair(src,0));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int currentNode = p.getNode();
            int distanceSoFar = p.getDistance();

            for(Pair adjPair : adj.get(currentNode)){
                int adjNode = adjPair.getNode();
                int adjDist = adjPair.getDistance();

                if(distanceSoFar + adjDist < distance[adjNode]){
                    distance[adjNode] = distanceSoFar + adjDist;
                    queue.offer(new Pair(adjNode,distanceSoFar + adjDist));
                }
            }

        }

        return distance;
    }


    static class Pair {
        int distance;
        int node;

        public Pair(int node,int distance) {
            this.distance = distance;
            this.node = node;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "distance=" + distance +
                    ", node=" + node +
                    '}';
        }
    }
}
