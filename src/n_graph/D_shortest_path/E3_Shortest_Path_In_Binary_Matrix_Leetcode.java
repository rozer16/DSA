package n_graph.D_shortest_path;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class E3_Shortest_Path_In_Binary_Matrix_Leetcode {


    public static void main(String[] args) {
        int [][] grid = {{0,1},{1,0}};
        int [][] grid1 = {{0}};
        System.out.println(shortestPath(grid1));
    }
    public static  int shortestPath(int[][] grid) {
        // Edge Case: if the source is only the destination.

        int[] source = {0,0};
        int[] destination = {grid.length-1, grid[0].length-1};
        int n = grid.length;
        int m =grid[0].length;


        if(grid[0][0] != 0 || grid[n-1][m-1] != 0)
            return -1;
        if(source[0] == destination[0] && source[1] == destination[1])
            return 1;



        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0.
        int [][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }

        //Here we dont need PQ since all nodes/adc cell are with dist I2_No_Of_Ways_To_Arrive_Destination. so we will travel first all nodes with dis I2_No_Of_Ways_To_Arrive_Destination and then 2 and so on
        //If dist is not unit then we would have used PQ

        // Create a queue for storing cells with their distances from source
        // in the form {dist,{cell coordinates pair}}.
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(1,source[0],source[1]));
        distance[source[0]][source[1]] = 1;

        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.


        // Iterate through the maze by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            int currentCellDist = tuple.getDistance();
            int currentX = tuple.getPtx();
            int currentY = tuple.getPty();

            for (int i = -1; i <= 1 ; i++) {
                for (int j = -1; j <= 1 ; j++) {
                    int newX = currentX + i;
                    int newY = currentY + j;
                    int newDistance = currentCellDist + 1;

                    if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 0 && distance[newX][newY] > newDistance){
                        if(destination[0] == newX && destination[1] == newY)
                            return newDistance;

                        distance[newX][newY] = newDistance;
                        queue.offer(new Tuple(newDistance, newX, newY));

                    }
                }
            }
        }

        return 1;
    }



}


class Tuple{
    int distance;
    int ptx;

    int pty;

    public Tuple(int distance, int ptx, int pty) {
        this.distance = distance;
        this.ptx = ptx;
        this.pty = pty;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPtx() {
        return ptx;
    }

    public void setPtx(int ptx) {
        this.ptx = ptx;
    }

    public int getPty() {
        return pty;
    }

    public void setPty(int pty) {
        this.pty = pty;
    }
}

