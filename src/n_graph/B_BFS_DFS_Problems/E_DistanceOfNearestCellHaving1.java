package n_graph.B_BFS_DFS_Problems;

import java.util.*;
import java.util.stream.Collectors;

public class E_DistanceOfNearestCellHaving1 {


    public static void main(String[] args) {

        List<List<String>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(List<String> str : result)
            min = Math.min(min, str.size());

        int finalMin = min;
        result.parallelStream().filter(x -> x.size() == finalMin).collect(Collectors.toList());
        int [][] matrix = new int[3][3];

        matrix[0] = new int[]{0, 0, 0};
        matrix[1] = new int[]{0, 1,0};
        matrix[2] = new int[]{0, 0, 0};


        /*
        *
                [2, 1, 2]
                [1, 0, 1]
                [2, 1, 2]

        *
        * */
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };
        /*
                [1, 0, 0, 1]
                [0, 0, 1, 1]
                [1, 1, 0, 0]
        *
        *
        *
        *
        * */


        int [][] cost = updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(cost[i]));
        }

    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;


        boolean [][] visited = new boolean[m][n];
        int [][] cost = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    queue.offer(new Pair(i,j,0));
                    visited[i][j]=true;
                    cost[i][j] =0;
                }
            }

        }

        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;
            int cost1 = pair.cost;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >=0 && nx < m && ny >= 0 && ny< n && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    cost[nx][ny] = cost1+1;
                    queue.offer(new Pair(nx,ny,cost1+1));
                }
            }
        }

        return cost;
    }

    static class Pair {
        int x;
        int y;
        int cost;

        public Pair(int x_, int y_, int cost_){
            this.x = x_;
            this.y = y_;
            this.cost = cost_;

        }

    }
}
