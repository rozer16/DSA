package m_graph.D_shortest_path;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class F2_Path_With_Minimum_Effort {

    public static void main(String[] args) {
        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        int [][] height1 = {{10,8},
                            {10,8},
                             {1,2},
                            {10,3},
                            {1,3},
                            {6,3},
                            {5,2},
                            {10,8},
                            {10,8},
                            {1,2},
                            {10,3},
                            {1,3},
                            {6,3},
                            {5,2}
        };
        F2_Path_With_Minimum_Effort obj = new F2_Path_With_Minimum_Effort();
        int ans = obj.minimumEffortPath(height1 );

        System.out.print(ans);
    }
    public int minimumEffortPath(int[][] heights) {


        int n = heights.length;
        int m = heights[0].length;

        // Create a priority queue containing pairs of cells
        // and their respective distance from the source cell in the
        // form {diff, {row of cell, col of cell}}.
        Queue<TupleB> pq = new PriorityQueue<>(Comparator.comparingInt(TupleB::getDistance));


        // Create a distance matrix with initially all the cells marked as
        // unvisited and the dist for source cell (0,0) as 0.
        int [][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        distance[0][0] = 0;
        pq.offer(new TupleB(0,0,0));


        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.
        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};


        // Iterate through the matrix by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while(!pq.isEmpty()){
            TupleB tuple = pq.poll();
            int dis = tuple.getDistance();
            int currentX = tuple.getX();
            int currentY = tuple.getY();


            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).

            //While pulling only we need this condition, not while offering(since there might be other shortest path to be added in PQ
            if(currentX == n-1 && currentY == m-1)
                return dis;

            for (int i = 0; i < 4; i++) {
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                // Checking validity of the cell.
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){

                    // Effort can be calculated as the max value of differences
                    // between the heights of the node and its adjacent nodes.
                    int maxHeight = Math.max(Math.abs(heights[newX][newY]-heights[currentX][currentY]),dis);

                    // If the calculated effort is less than the prev value
                    // we update as we need the min effort.
                    //Relaxing all edges
                    if(maxHeight < distance[newX][newY]){
                        pq.offer(new TupleB(maxHeight, newX,newY));
                        distance[newX][newY] = maxHeight;
                    }
                }
            }


        }


        // If the destination is unreachable.
        return -1;
    }
}

class TupleB{
    int distance;
    int x;
    int y;

    public TupleB(int distance, int x, int y) {
        this.distance = distance;
        this.x = x;
        this.y = y;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
