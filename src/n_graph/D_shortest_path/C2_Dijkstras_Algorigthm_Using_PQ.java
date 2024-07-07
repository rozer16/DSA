package n_graph.D_shortest_path;

import java.util.*;

public class C2_Dijkstras_Algorigthm_Using_PQ {

    public static void main(String[] args) {
        int V = 6, E=3, S=0;


        List<List<Pair>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new Pair(1,4));
        adj.get(0).add(new Pair(2,4));

        adj.get(1).add(new Pair(0,4));
        adj.get(1).add(new Pair(2,2));

        adj.get(2).add(new Pair(0,4));
        adj.get(2).add(new Pair(1,2));
        adj.get(2).add(new Pair(3,3));
        adj.get(2).add(new Pair(4,1));
        adj.get(2).add(new Pair(5,6));

        adj.get(3).add(new Pair(2,3));
        adj.get(3).add(new Pair(5,2));


        adj.get(4).add(new Pair(2,1));
        adj.get(4).add(new Pair(5,3));

        adj.get(5).add(new Pair(2,6));
        adj.get(5).add(new Pair(3,2));
        adj.get(5).add(new Pair(4,3));

        int [] distance = dijkstrasShortestDistance(V,adj,S);
        System.out.println(Arrays.toString(distance));

    }

    //TC : E logV

    private static int[] dijkstrasShortestDistance(int v, List<List<Pair>> adj, int source) {

        int [] distance = new int[v];
        Arrays.fill(distance,(int)1e9);
        distance[source] = 0;


        //Taking priority queue because we wanted always first node with mini   mum distance.
        Queue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::getWeight));
        priorityQueue.offer(new Pair(source,0));

        while (!priorityQueue.isEmpty()){
            Pair pair = priorityQueue.poll();
            int node = pair.getAdjNode();
            int weight = pair.getWeight();

            for (Pair adjPair : adj.get(node)){
                int adjNode = adjPair.getAdjNode();
                int adjWeight = adjPair.getWeight();


                //Relaxing all edges
                if(distance[adjNode] > weight+adjWeight){
                    distance[adjNode    ] = weight+adjWeight;
                    priorityQueue.offer(new Pair(adjNode,weight+adjWeight));
                }
            }
        }

        for (int i = 0; i < v; i++) {
            if(distance[i] == 1e9){
                distance[i] = -1;
            }
        }

        return distance;
    }
}


class PairA{
    int adjnode;
    int distance;
    public PairA(int distance,int node){
        this.adjnode = node;
        this.distance = distance;
    }

    public int getAdjnode() {
        return adjnode;
    }

    public void setAdjnode(int adjnode) {
        this.adjnode = adjnode;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
