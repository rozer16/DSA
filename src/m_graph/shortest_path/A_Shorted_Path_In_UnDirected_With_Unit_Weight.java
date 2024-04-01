package m_graph.shortest_path;

import sun.awt.image.ImageWatched;

import java.sql.Array;
import java.util.*;

public class A_Shorted_Path_In_UnDirected_With_Unit_Weight {


    public static void main(String[] args) {
            int V = 9;
            int [][] edges = {{0,1},{0,3},{3,4},{4 ,5},{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};
            int [] distance = shortestPath(edges,9,edges.length,0);
            System.out.println(Arrays.toString(distance));
    }


    /*
    noOfNodes = 9,
    noOfEdges = 10
    edges = [[0,1],[0,3],[3,4],[4 ,5],[5, 6],[1,2],[2,6],[6,7],[7,8],[6,8]]
    src=0
    * */
    public static int[] shortestPath(int[][] graph, int noOfNodes, int noOfEdges, int src){

        //1) Create a adj list from adj matrix
        List<List<Integer>> adjList = new ArrayList<>(noOfNodes);
        for (int i = 0; i < noOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
           adjList.get(graph[i][0]).add(graph[i][1]);
           adjList.get(graph[i][1]).add(graph[i][0]);
        }

        /*
        2) Initialize
        int [] distance with infinity value(1e9)
        Queue<Integer> for BFS
        * */

        int [] distance = new int[noOfNodes];
        Arrays.fill(distance, (int) 1e9);

        Queue<Integer> queue = new LinkedList<>();

        /*

        3) Put src node into queue and mark its distance[src] = 0 into distance array

        * */

        queue.offer(src);
        distance[src] = 0;


        /*
        Run below steps until queue is not empty

            4.1) Pop a node from queue and store into  variable node
            4.2) Iterate through adj nodes of node popped from queue.
            4.3) if node from adjList's distance distance[adjNode] > distance[node]+1 then set distance[adjNode] = distance[node]+1 and push node to queue
        * */


        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int adjNode : adjList.get(node)){
                if( distance[adjNode] > distance[node]+1 ){
                    distance[adjNode] = distance[node]+1;
                    queue.offer(adjNode);
                }
            }
        }

        //5) Run a loop in distance array and set value = -1 if its infinity(1e9)
        for (int i = 0; i < noOfNodes; i++) {
            if(distance[i] == 1e9)
                distance[i] = -1;
        }
        return  distance;
    }
}
