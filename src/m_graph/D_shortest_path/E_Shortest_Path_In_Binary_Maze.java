package m_graph.D_shortest_path;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class E_Shortest_Path_In_Binary_Maze {

    public static void main(String[] args) {

        int[] source={0,1};
        int[] destination={2,2};

        int[][] grid={  {1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 0},
                        {1, 0, 0, 1}
        };

        System.out.println("Shortest path from Point : "+ Arrays.toString(source)+" " +
                "to destination :"+Arrays.toString(destination)+" is : "+
                shortestPath(grid,source,destination));
        //Shortest path from Point : [0, 1] to destination :[2, 2] is : 3

    }

    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Edge Case: if the source is only the destination.
        if(source[0] == destination[0] && source[1] == destination[1])
            return 0;

        int n = grid.length;
        int m =grid[0].length;



        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0.
        int [][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }

        //Here we dont need PQ since all nodes/adc cell are with dist 1. so we will travel first all nodes with dis 1 and then 2 and so on
        //If dist is not unit then we would have used PQ

        // Create a queue for storing cells with their distances from source
        // in the form {dist,{cell coordinates pair}}.
        Queue<TupleA> queue = new LinkedList<>();
        queue.offer(new TupleA(0,source[0],source[1]));
        distance[source[0]][source[1]] = 0;

        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.
        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};


        // Iterate through the maze by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while (!queue.isEmpty()){
            TupleA tuple = queue.poll();
            int currentCellDist = tuple.getDistance();
            int currentX = tuple.getPtx();
            int currentY = tuple.getPty();

            for (int i = 0; i < 4; i++) {
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];
                int newDistance = currentCellDist + 1;

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1 && distance[newX][newY] > newDistance){
                    if(destination[0] == newX && destination[1] == newY)
                        return newDistance;

                    distance[newX][newY] = newDistance;
                    queue.offer(new TupleA(newDistance, newX, newY));

                }
            }

        }

        return -1;
    }

    public  int shortestPath(int[][] grid) {
        // Edge Case: if the source is only the destination.

        int[] source = {0,0};
        int[] destination = {grid.length-1, grid[0].length-1};
        if(source[0] == destination[0] && source[1] == destination[1])
            return 0;

        int n = grid.length;
        int m =grid[0].length;



        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0.
        int [][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }

        //Here we dont need PQ since all nodes/adc cell are with dist 1. so we will travel first all nodes with dis 1 and then 2 and so on
        //If dist is not unit then we would have used PQ

        // Create a queue for storing cells with their distances from source
        // in the form {dist,{cell coordinates pair}}.
        Queue<TupleA> queue = new LinkedList<>();
        queue.offer(new TupleA(0,source[0],source[1]));
        distance[source[0]][source[1]] = 0;

        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.
        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};


        // Iterate through the maze by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while (!queue.isEmpty()){
            TupleA tuple = queue.poll();
            int currentCellDist = tuple.getDistance();
            int currentX = tuple.getPtx();
            int currentY = tuple.getPty();

            for (int i = -1; i <= 1 ; i++) {
                for (int j = -1; j <= 1 ; j++) {
                    int newX = currentX + dx[i];
                    int newY = currentY + dy[j];
                    int newDistance = currentCellDist + 1;

                    if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 0 && distance[newX][newY] > newDistance){
                        if(destination[0] == newX && destination[1] == newY)
                            return newDistance;

                        distance[newX][newY] = newDistance;
                        queue.offer(new TupleA(newDistance, newX, newY));

                    }
                }
            }
        }

        return -1;
    }


}

class TupleA {
    int distance;
    int ptx;

    int pty;

    public TupleA(int distance, int ptx, int pty) {
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
