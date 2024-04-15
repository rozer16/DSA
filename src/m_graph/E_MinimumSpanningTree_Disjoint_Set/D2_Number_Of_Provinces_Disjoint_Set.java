package m_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2_Number_Of_Provinces_Disjoint_Set {

    public int numProvinces(List<List<Integer>> adj, int V) {
        C3_Disjointset_Union_By_Size ds = new C3_Disjointset_Union_By_Size(V);

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                if(i != j & adj.get(i).get(j) == 1)
                    ds.unionBySize(i,j);
            }

        }

        int noOfProvinces = 0;
        List<Integer> parent = ds.getParent();
        for (int i = 0; i < V; i++) {
            if(i == parent.get(i))
                noOfProvinces++;
        }

        return noOfProvinces;
    }

    public static void main(String[] args) {
       List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(1, 0, 1));
        adj.add(Arrays.asList(0,1,0));
        adj.add(Arrays.asList(1,0,1));
        int V = 3;

        List<List<Integer>> adj1 = new ArrayList<>();
        adj1.add(Arrays.asList(1 ,0, 0, 0, 0 ,1, 1));
        adj1.add(Arrays.asList(0 ,1, 0, 0, 0, 0, 0));
        adj1.add(Arrays.asList(0, 0, 1 ,0, 1, 1, 1));
        adj1.add(Arrays.asList(0, 0, 0, 1, 0, 0, 0));
        adj1.add(Arrays.asList(0, 0, 1, 0, 1, 0, 0));
        adj1.add(Arrays.asList(1, 0, 1, 0, 0, 1, 1));
        adj1.add(Arrays.asList(1, 0, 1, 0, 0, 1, 1));

        int V1= 7;

        List<List<Integer>> adj2 = new ArrayList<>();
        adj2.add(Arrays.asList(1 ,0));
        adj2.add(Arrays.asList(0 ,1));
        int V2 =2;

        D2_Number_Of_Provinces_Disjoint_Set solution = new D2_Number_Of_Provinces_Disjoint_Set();
        System.out.println("No  of proviances : "+solution.numProvinces(adj2,V2));
    }
}
