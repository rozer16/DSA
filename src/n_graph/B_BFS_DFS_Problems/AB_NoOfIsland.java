package n_graph.B_BFS_DFS_Problems;

public class AB_NoOfIsland {

    public static void main(String[] args) {
        char [][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        AB_NoOfIsland sol = new AB_NoOfIsland();
        System.out.println(sol.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};
        for(int i = 0; i<grid.length;i++){
            for(int j = 0;j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    numIslands++;
                    dfs(grid,visited,i,j,dx,dy);
                }
            }
        }
        return numIslands;
    }

    public void dfs(char [][] grid,boolean [][] visited,int row,int col, int [] dx,int [] dy){
        visited[row][col] = true;
        for(int i = 0; i< 4;i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1' && !visited[newRow][newCol])
                dfs(grid,visited, newRow, newCol,dx,dy);
        }
    }
}
