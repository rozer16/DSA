package m_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.ArrayList;
import java.util.List;

public class H2_Number_Of_Islands_II {
    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {
                {0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        System.out.println("No of islands : " + new H2_Number_Of_Islands_II().numOfIslands(n, m, operators));

        //No of islands : [1, 1, 2, 1, 1, 2, 2, 2, 3, 3, 1, 1]
    }

    public boolean isValid(int adjR,int adjC, int n, int m){
        return adjR >= 0 && adjR<n && adjC >=0 && adjC < m;
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        boolean[][] visited = new boolean[n][m];
       C3_Disjointset_Union_By_Size ds = new C3_Disjointset_Union_By_Size(n*m);

       int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};

        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            int row = operators[i][0];
            int col = operators[i][1];

            if(visited[row][col]){
                result.add(cnt);
                continue;
            }
            visited[row][col] = true;
            cnt++;

            for (int j = 0; j < 4; j++) {
                int adjrow = row+dx[j];
                int adjcol = col+dy[j];

                if(isValid(adjrow,adjcol,n,m) && visited[adjrow][adjcol]){

                    int cellNo = (row*m)+col;
                    int adjCellNo = (adjrow*m)+adjcol;

                    if(ds.findUltimateParent(cellNo) != ds.findUltimateParent(adjCellNo)){
                        cnt--;
                        ds.unionBySize(cellNo,adjCellNo);
                    }

                }

            }
            result.add(cnt);
        }

        return result;
    }
}
