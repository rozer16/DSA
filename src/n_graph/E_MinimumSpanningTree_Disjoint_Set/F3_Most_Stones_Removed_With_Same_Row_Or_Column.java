package n_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.HashSet;
import java.util.Set;

public class F3_Most_Stones_Removed_With_Same_Row_Or_Column {

    public static void main(String[] args) {

        int n = 6;
        int[][] stones = {
                {0, 0}, {0, 2},
                {1, 3}, {3, 1},
                {3, 2}, {4, 3}
        };
        F3_Most_Stones_Removed_With_Same_Row_Or_Column solution = new F3_Most_Stones_Removed_With_Same_Row_Or_Column();
        System.out.println("No of max stones removed : "+solution.removeStones(stones));

    }

    public int removeStones(int[][] stones) {
        int noOfRows = -1;
        int noOfCols = -1;
        int n= stones.length;
        for (int i = 0; i < stones.length; i++) {
             noOfRows = Math.max(noOfRows,stones[i][0]);
             noOfCols = Math.max(noOfCols, stones[i][1]);
        }


        Set<Integer> nodes = new HashSet<>();
        C3_Disjointset_Union_By_Size ds = new C3_Disjointset_Union_By_Size(noOfRows+noOfCols+1);
        for (int i = 0; i < stones.length; i++) {
            int rowNode = stones[i][0];
            int colNode = stones[i][1] + noOfRows+1;

            ds.unionBySize(rowNode,colNode);
            nodes.add(rowNode);
            nodes.add(colNode);
        }

        int noOfComponent = 0;
        for(Integer no : nodes){
            if(no == ds.findUltimateParent(no)){
                noOfComponent++;
            }
        }
        return stones.length - noOfComponent;


    }
}
