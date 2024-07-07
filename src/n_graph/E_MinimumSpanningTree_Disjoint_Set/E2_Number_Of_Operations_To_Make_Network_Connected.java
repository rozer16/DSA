package n_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.List;

public class E2_Number_Of_Operations_To_Make_Network_Connected {

    //1.Find No of provinces
    //2. Find no of extra edges
    //3 if np -1 < extra edges then return np-1 else -1
    public int makeConnected(int n, int[][] connections) {

        int noOfExtraEdges = 0;
        C3_Disjointset_Union_By_Size ds = new C3_Disjointset_Union_By_Size(n);
        for (int i = 0; i < connections.length; i++) {
            int node1 = connections[i][0];
            int node2 = connections[i][1];
            if(ds.findUltimateParent( node1 ) == ds.findUltimateParent(node2)){
                noOfExtraEdges++;
            }else{
                ds.unionBySize(node1,node2);
            }
        }

        int noOfProvinces = 0;
        List<Integer> parent = ds.getParent();
        for (int i = 0; i < n; i++) {
            if(i == parent.get(i))
                noOfProvinces++;
        }
        if((noOfProvinces-1) <= noOfExtraEdges)
            return noOfProvinces-1;

        return -1;
    }

    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        int n = 9;


        E2_Number_Of_Operations_To_Make_Network_Connected solution = new E2_Number_Of_Operations_To_Make_Network_Connected();
        System.out.println("No of edges required to connect graph : "+solution.makeConnected(n, connections));
    }
}
