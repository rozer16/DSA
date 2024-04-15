package m_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.HashSet;
import java.util.Set;

public class I2_Making_Large_Island {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0}
        };

        System.out.println("Largest Island by changing 1 0->1 : "+new I2_Making_Large_Island().largestIsland(grid));
    }

    private boolean isValid(int row,int col, int n){
        return row >=0 && row < n && col>=0 && col < n;
    }

    public int largestIsland(int[][] grid) {
        int n  = grid.length;
        C3_Disjointset_Union_By_Size ds = new C3_Disjointset_Union_By_Size(n*n);
        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};
        int maxIslandSize = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col] == 1){
                    for (int k = 0; k < 4; k++) {
                        int newR = row+dx[k];
                        int newC = col+dy[k];
                        if(isValid(newR,newC,n) && grid[newR][newC] == 1){
                            ds.unionBySize(row*n+col,newR*n+newC);
                        }
                    }
                }
            }
        }
        int islandSize = 0;
        Set<Integer> set;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col] == 0){
                    set = new HashSet<>();
                    islandSize = 0;
                    for (int k = 0; k < 4; k++) {
                        int newR = row+dx[k];
                        int newC = col+dy[k];
                        if(isValid(newR,newC,n) && grid[newR][newC] == 1){
                            set.add(ds.findUltimateParent(newR*n+newC));
                        }
                    }
                    for(int node: set){
                        islandSize += ds.getSize().get(ds.findUltimateParent(node));
                    }
                    maxIslandSize = Math.max(maxIslandSize,islandSize+1);
                }
            }
        }


        //But if the matrix does not contain any cell with 0, step 2 will not be executed.
        // For that reason, we will just run a loop from node number 0 to n*n and for each node number,
        // we will find the ultimate parent. After that, we will find the sizes of those ultimate parents
        // and will take the size of the largest one.
        //Thus we will get the maximum size of the group of connected 1s stored in our answer.
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            maxIslandSize = Math.max(maxIslandSize, ds.getSize().get(ds.findUltimateParent(cellNo)));
        }
        return maxIslandSize;

    }
}
