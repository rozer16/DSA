package n_graph.E_MinimumSpanningTree_Disjoint_Set;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/min-cost-to-connect-all-points/

You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.


 Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation:

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18


* */
public class J1_Min_Cost_To_Connect_All_Points {

    public static void main(String[] args) {
        int [][] points = new int[][]{
                {0,0},
                {2,2},
                {3,10},
                {5,2},
                {7,0}
        };

        System.out.println("Min cost to connect all points : "+new J1_Min_Cost_To_Connect_All_Points().minCostConnectPoints(points)); //20
    }

    public int minCostConnectPoints(int[][] p) {
        int points = p.length;

        List<Edge> edges = new ArrayList();
        //1 prepare edges
        for(int i = 0; i< points; i++){
            for(int j = i+1; j<points;j++){
                int distance = Math.abs(p[j][0]-p[i][0]) + Math.abs(p[j][1]-p[i][1]);
                edges.add(new Edge(i, j, distance));
            }
        }

        //2 Sort
        Collections.sort(edges);

        int cost= 0;
        Disjointset ds = new Disjointset(points);
        for(int i=0; i<edges.size(); i++){
            int node = edges.get(i).node;
            int adjNode = edges.get(i).adjNode;
            int weight = edges.get(i).weight;

            if(!ds.isConnected(node, adjNode)){
                ds.unionBySize(node, adjNode);
                cost += weight;
            }
        }
        return cost;
    }
}

class Disjointset {

    private int noOfNodes;

    public List<Integer> getParent() {
        return new ArrayList<>(parent);
    }

    public List<Integer> getSize() {
        return size;
    }

    private List<Integer> parent;

    private List<Integer> size;


    /*
        Initial Configuration
            parent = [0,1,2,3,4,5,...n] --> each node is their own boss
            size = [0,0,0,0....0] --> all node are leaf and they dont have any children

    * */
    public Disjointset(int noOfNodes){
        this.noOfNodes = noOfNodes;
        this.parent = new ArrayList<>(noOfNodes+1);
        this.size = new ArrayList<>(noOfNodes+1);

        for (int i = 0; i <= noOfNodes; i++) {
            this.parent.add(i);
            this.size.add(1);
        }
    }

    public int findUltimateParent(int nodeU){
        //If a node and parent[node] is same that means this is boss or top node
        if(nodeU == parent.get(nodeU))
            return nodeU;

        //Path compression, making a node's ultimate parent as the node's parent
        parent.set(nodeU, findUltimateParent(parent.get(nodeU)));
        return parent.get(nodeU);
    }


    public boolean isConnected(int nodeU, int nodeV){
        return findUltimateParent(nodeU) == findUltimateParent(nodeV);
    }


    public void unionBySize(int nodeU, int nodeV){
        //Find Ultipmate parent of u & v
        int upu = findUltimateParent(nodeU);
        int upv = findUltimateParent(nodeV);

        //If they are part of same component, no need to unite them
        if(upu == upv)
            return;

        //Connect smaller component to largest and increase size of larger by size of smaller
        if(size.get(upu) < size.get(upv)){
            parent.set(upu, upv);
            size.set(upv,size.get(upv)+size.get(upu));
        }else{
            parent.set(upv, upu);
            size.set(upu, size.get(upu)+size.get(upv));
        }
    }
}

class Edge implements Comparable<Edge>{

    Integer node;
    Integer adjNode;
    Integer weight;


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
