package n_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.*;

public class B2_Prims_Algo_For_MST {

    public static void main(String[] args) {
        List<List<Integer>> list =  Arrays.asList(
                Arrays.asList(0, 1, 2),
                Arrays.asList(0, 2, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(2, 3, 2),
                Arrays.asList(3, 4, 1),
                Arrays.asList(4, 2, 2)
        );

        System.out.println("Sum of edges for Minimal Spanning tree is "+ new B2_Prims_Algo_For_MST().minimumSpanningTree(list,5));


    }


    //1) Start PQ with (0,0,0)
    //2) while queue is not empty keep popping nodes
    //3) If popped node is not visited,
            // mark it visited
            // add its weight to sum
            // add pair to MST list
            //Traverse all its non visited adj and push it to queue.
    //4) Return sum.
    public  int minimumSpanningTree(List<List<Integer>> edges, int n) {
        //Your code goes here

        List<List<Pair>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            graph.get(edges.get(i).get(0)).add(new Pair(edges.get(i).get(1),edges.get(i).get(2)));
            graph.get(edges.get(i).get(1)).add(new Pair(edges.get(i).get(0),edges.get(i).get(2)));
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparing(Tuple::getCost).thenComparing(Tuple::getDestination));
        pq.add(new Tuple(0,0,0)); //1

        boolean visited [] = new boolean[n];
        //visited[0] = true;

       List<List<Integer>> mst = new ArrayList<>(n-1);

        int sum = 0;
        while(!pq.isEmpty()){

            //2. Poll a tuple having minimum weight.
            Tuple tuple = pq.poll();
            int source = tuple.getSource();
            int dest = tuple.getDestination();
            int weight = tuple.getCost();

            //If node is visited that means that node is already gone to mst so no need to traverse its adjcent again.
            if(visited[dest])
                continue;

            //3.1
            visited[dest] = true;
            //3.2
            sum = sum + weight;
            //3.3
            mst.add(new ArrayList<>(Arrays.asList(source,dest)));

            //Iterate all its adjacent node and if adj node is not visited then push it to priority queue with weight.
            for(Pair pair : graph.get(dest)){
                int node = pair.getNode();
                int weight1 = pair.getWeight();

                if(visited[node])
                    continue;

                //3.4
                pq.offer(new Tuple(dest,node,weight1));

            }
        }
        mst.remove(0);
        System.out.println("Minimal Spanning Tree : ");
        System.out.println(mst);
        //4
        return sum;

    }

    static class Pair{
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", weight=" + weight +
                    '}';
        }
    }
    static class Tuple {
        private int source;
        private int destination;

        private int cost;

        public Tuple(int source, int destination, int cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getDestination() {
            return destination;
        }

        public void setDestination(int destination) {
            this.destination = destination;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", cost=" + cost +
                    '}';
        }
    }
}
