package m_graph.D_shortest_path;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.*;

public class K2_Minimum_Multiplication_To_Reach_End {
    public static void main(String[] args) {

        int start=3, end=30;
        int[] arr = {2,5,7};
        System.out.println(new K2_Minimum_Multiplication_To_Reach_End().minimumOperations(3,start,end,arr));
    }

    public int minimumOperations(int n, int start, int end, int []a) {
        // Write your code here

        //PriorityQueue won't be required because we are increasing I2_No_Of_Ways_To_Arrive_Destination step each time not n
        Queue<Pair> queue = new LinkedList<>();

        int [] distance = new int[100000];


        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;
        queue.offer(new Pair(0,start));
        int node = 100000;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int currentNode = pair.getMultiplication();
            int stepsSoFar = pair.getSteps();

            for (int i = 0; i < a.length; i++) {
                int newNode = (currentNode * a[i])%node;
                if(newNode == end)
                    return  stepsSoFar+1;
                //Relaxing all edges1
                if(distance[newNode] > stepsSoFar+1) {
                    queue.offer(new Pair( stepsSoFar+1,newNode));
                    distance[newNode] = stepsSoFar+1;
                }
            }
        }

        return -1;
    }


    static class Pair{
        private int steps;
        private int multiplication;


        public Pair(int steps, int multiplication){
            this.steps = steps;
            this.multiplication = multiplication;
        }


        public int getSteps() {
            return steps;
        }

        public void setSteps(int steps) {
            this.steps = steps;
        }

        public int getMultiplication() {
            return multiplication;
        }

        public void setMultiplication(int multiplication) {
            this.multiplication = multiplication;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "steps=" + steps +
                    ", multiplication=" + multiplication +
                    '}';
        }
    }
}