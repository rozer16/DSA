package n_graph.B_BFS_DFS_Problems;

public class G_NumberOfEnclaves {

    public static void dfs(int row, int col, int [][] matrix, boolean [][] visited, int [] delRow, int [] delCol){
        visited[row][col] = true;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < rows && nCol >=0 && nCol < cols && matrix[nRow][nCol] == 1 && !visited[nRow][nCol] )
                dfs(nRow,nCol,matrix,visited,delRow,delCol);
        }
    }


    public int numEnclaves(int[][] grid) {
        int [] delRow = new int[]{-1,0,1,0};
        int [] delCol = new int[]{0,1,0,-1};

        int n = grid.length;
        int m = grid[0].length;
        boolean [] [] visited = new boolean[n][m];

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // first row, first col, last row, last col
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    // if it is a land then store it in queue
                    if(grid[i][j] == 1) {
                        dfs(i,j,grid,visited,delRow,delCol);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int [][] grid={
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        }; //3

        int grid1 [][] = {
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0}
        };
        System.out.println(new G_NumberOfEnclaves().numEnclaves(grid1));

    }
}
