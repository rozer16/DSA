package m_graph.B_BFS_DFS_Problems;

import java.util.*;
public class A_NumberOfProviances {


    public static void main(String[] args) {

        // adjacency matrix
        int[][] cities = new int[3][3];
        cities[0] = new int[]{1, 1, 0};
        cities[1] = new int[]{1, 1, 0};
        cities[2] = new int[]{0, 0, 1};


        A_NumberOfProviances ob = new A_NumberOfProviances();
        System.out.println(ob.numProvincesByMatrixAdj(cities));
    }



    //Time Complexity: O(N) + O(V+2E), Where O(N) is for outer loop and inner loop runs in total a single DFS over entire graph,
    // and we know DFS takes a time of O(V+2E).
    //
    //Space Complexity: O(N) + O(N),Space for recursion stack space and visited array.
    public int numProvincesByMatrixAdj(int[][] isConnected) {

        boolean isVisited[] = new boolean[isConnected.length];
        int cnt = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                cnt++;
                dfsByAdjMatrix(i, isVisited, isConnected);
            }

        }
        return cnt;
    }

    public void dfsByAdjMatrix(int node, boolean[] isVisited, int[][] adj) {
        isVisited[node] = true;
        /*
                 0 1 2

        *    0   1 1 0
        *    1   1 1 0
        *    2   0 0 1
        *
        *
        * */

        //Running loop for checking matrix for node th row and ith column and check if its not visited and value is 1(i.e. connected)
        // node != i added because node is always connected to itself.
        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1 && node != i && !isVisited[i]) {
                dfsByAdjMatrix(i, isVisited, adj);
            }
        }
    }
    public int numProvincesByListAdj(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();

        //Code to convert adj matrix to adj list.
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }


        boolean isVisited[] = new boolean[isConnected.length];
        int cnt = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                cnt++;
                dfs(i, isVisited, adj);
            }
        }
        return cnt;
    }


    public void dfs(int i, boolean[] isVisited, List<List<Integer>> adj) {
        isVisited[i] = true;
        for (Integer tempNode : adj.get(i)) {
            if (!isVisited[tempNode]) {
                dfs(tempNode, isVisited, adj);
            }
        }


    }



}
