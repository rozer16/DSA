package n_graph.B_BFS_DFS_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class I_NumberOfDistinctIsland {

    public static void main(String[] args) {
        int [][] matrix = {
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,0},
                {0,0,1,0},
                {1,1,0,1}
        };
        System.out.println(countNoOfDistinctIslandUsingDFS(matrix));
    }

    public static int countNoOfDistinctIslandUsingDFS(int [] [] matrix){
        int cnt = 0;
        boolean visited [][] = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && !visited[i][j] ) {
                    cnt++;
                    dfs(i, j, matrix, visited);
                }
            }
        }


        return cnt;
    }

    private static void dfs(int row, int col, int[][] matrix, boolean[][] visited) {
        visited[row][col] = true;
        for (int i = -1; i <=1 ; i++) {
            for (int j = -1; j <= 1 ; j++) {
                int nr = row + i;
                int nc = col + j;

                if(nr >= 0 && nr < matrix.length && nc >=0 && nc < matrix[0].length && !visited[nr][nc] && matrix[nr][nc] ==1)
                    dfs(nr,nc,matrix,visited);
            }

        }
    }

    /*
    * Time Complexity ~ O(N² + NxMx9), N² for the nested loops, and NxMx9 for the overall DFS of the matrix, that will happen throughout if all the cells are filled with 1.
    * Space Complexity: O(N²) for visited array max queue space O(N²), If all are marked as 1 then the maximum queue space will be N².
    * */
    private static void bfs(int row, int col, int[][] matrix, boolean[][] visited) {
        visited[row][col] = true;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int r = q.peek().row;
            int c = q.peek().column;

            for (int i = -1; i <=1 ; i++) {
                for (int j = -1; j <= 1 ; j++) {
                    int nr = r + i;
                    int nc = c + j;

                    if(nr >= 0 && nr < matrix.length && nc >=0 && nc < matrix[0].length && !visited[nr][nc] && matrix[nr][nc] ==1) {
                        visited[nr][nc] = true;
                        q.offer(new Pair(nr,nc));
                    }
                }

            }
        }

    }
}

class Pair {
    int row;
    int column;
    public Pair(int first, int second) {
        this.row = first;
        this.column = second;
    }
}