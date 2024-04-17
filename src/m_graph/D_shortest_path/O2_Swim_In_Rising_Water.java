package m_graph.D_shortest_path;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class O2_Swim_In_Rising_Water {
    public static void main(String[] args) {
            int [][] elevations = {
                    {0,1,2,3,4},
                    {6,23,22,21,5},
                    {12,13,14,15,16},
                    {11,17,18,19,20},
                    {10,9,8,7,25}
            };

        System.out.println(new O2_Swim_In_Rising_Water().swimInWater(elevations)); //16
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        Queue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(Tuple::getElevation));
        boolean visited[][] = new boolean[n][n];
        pq.offer(new Tuple(0,0,grid[0][0]));

        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple tuple = pq.poll();
            int x = tuple.x;
            int y = tuple.y;
            int elevation = tuple.elevation;

            if(x == n-1 && y == n-1)
                return elevation;

            for(int i=0; i<4; i++){
                int newX = x+ dx[i];
                int newY = y+ dy[i];

                if(isValid(newX, newY, n) && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    pq.offer(new Tuple(newX, newY, Math.max(elevation,grid[newX][newY])));
                }
            }
        }

        return -1;
    }

    public boolean isValid(int x, int y, int n){
        return x >= 0 && x<n && y >=0 && y < n;
    }

    static class Tuple{
        int x;
        int y;
        int elevation;

        public Tuple(int x, int y, int elevation){
            this.x = x;
            this.y = y;
            this.elevation = elevation;
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

        public int getElevation() {
            return elevation;
        }

        public void setElevation(int elevation) {
            this.elevation = elevation;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "x=" + x +
                    ", y=" + y +
                    ", elevation=" + elevation +
                    '}';
        }
    }
}

