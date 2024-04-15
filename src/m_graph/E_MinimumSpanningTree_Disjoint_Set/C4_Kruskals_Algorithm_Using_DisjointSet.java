package m_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.*;

public class C4_Kruskals_Algorithm_Using_DisjointSet {

    public static void main(String[] args) {
        int V = 5;
        //Node --> ArrayList<adjNode,Pair>
        List<List<List<Integer>>> adjList= new ArrayList<>();

        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int node = edges[i][0];
            int adjNode =edges[i][1];
            int weight = edges[i][2];
            adjList.get(node).add(Arrays.asList(adjNode,weight));
        }

        C4_Kruskals_Algorithm_Using_DisjointSet solution = new C4_Kruskals_Algorithm_Using_DisjointSet();
        System.out.println("MST weight : "+solution.findMSTUsingKruskalAlgo(V,adjList));
    }

    public int findMSTUsingKruskalAlgo(int V, List<List<List<Integer>>> adj){

        List<Edge> edges = new ArrayList<>();
        //Iterate for each node to get its adj list
        for (int i = 0; i < V; i++) {
            //For ith node get its adj node and weight
            for (int j = 0; j < adj.get(i).size(); j++) {
                int node = i;
                int adjNode = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1);

                Edge edge = new Edge(node,adjNode,weight);
                edges.add(edge);
            }
        }

        Collections.sort(edges);

        int minimalSpanningTreeWeight = 0;
        List<List<Integer>> mstPair = new ArrayList<>();


        C3_Disjointset_Union_By_Size disjointSetUnionBySize = new C3_Disjointset_Union_By_Size(V);

        for (int i = 0; i < edges.size(); i++) {
            int node = edges.get(i).getNode();
            int adjNode = edges.get(i).getAdjNode();
            int weight = edges.get(i).getWeight();

            if(disjointSetUnionBySize.findUltimateParent(node) == disjointSetUnionBySize.findUltimateParent(adjNode))
                    continue;

            minimalSpanningTreeWeight += weight;
            mstPair.add(Arrays.asList(node,adjNode));
            disjointSetUnionBySize.unionBySize(node,adjNode);
        }


        System.out.println("MST Graph is "+mstPair);
        return minimalSpanningTreeWeight;
    }

    static class Edge implements Comparable<Edge>{

        private Integer node;
        private  Integer adjNode;
        private Integer weight;
        public Edge(int node, int adjNode, int weight){
            this.node = node;
            this.adjNode = adjNode;
            this.weight = weight;
        }
        public int compareTo(Edge newEdge){
            return this.getWeight().compareTo(newEdge.getWeight());
        }

        public Integer getNode() {
            return node;
        }

        public void setNode(Integer node) {
            this.node = node;
        }

        public Integer getAdjNode() {
            return adjNode;
        }

        public void setAdjNode(Integer adjNode) {
            this.adjNode = adjNode;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }


    }
}
