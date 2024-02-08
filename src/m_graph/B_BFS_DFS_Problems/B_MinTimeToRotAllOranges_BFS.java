package m_graph.B_BFS_DFS_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class B_MinTimeToRotAllOranges_BFS {

    public static void main(String args[])
    {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = new B_MinTimeToRotAllOranges_BFS().orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }

    //Time Complexity: O ( n x n ) x 4

    //Reason: Worst-case – We will be making each fresh orange rotten in the grid and for each rotten orange will check in 4 directions

    //Space Complexity: O ( n x n )

    //Reason: worst-case –  If all oranges are Rotten, we will end up pushing all rotten oranges into the Queue data structure
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;


        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    freshCount++;
                }
            }

        }

        if(freshCount == 0){
            return 0;
        }
        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};
        int cnt = 0;
        int cntMin = 0;

        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int point [] = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int row = point[0] + dx[j];
                    int col = point[1] + dy[j];

                    if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] !=1)
                        continue;
                    cnt++;
                    grid[row][col] = 2;
                    queue.offer(new int[]{row,col});
                }
            }
            if(!queue.isEmpty())
                cntMin++;

        }

        if(cnt != freshCount)
            return -1;
        else
            return cntMin;
    }
}
