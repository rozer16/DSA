package n_graph.D_shortest_path;

import java.util.*;

public class H2_Network_Delay_Time {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int [][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };

        System.out.println(new H2_Network_Delay_Time().networkDelayTime(times,n,k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        int [] delays = new int[n+1];
        Arrays.fill(delays, Integer.MAX_VALUE);
        delays[k] = 0;

        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getDelay));
        queue.offer(new Pair(k,0));


        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int currentNode = pair.getNode();
            int delaySoFar = pair.getDelay();


            for(Pair neigh : graph.get(currentNode)){
                int neighbourNode = neigh.getNode();
                int neighbourDelay = neigh.getDelay();


                //Relaxing all edges
                if(delays[neighbourNode] > delaySoFar + neighbourDelay){
                    delays[neighbourNode] = delaySoFar + neighbourDelay;
                    queue.offer(new Pair(neighbourNode, delaySoFar + neighbourDelay));
                }
            }
        }

        int maxDelay = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if(delays[i] == Integer.MAX_VALUE)
                return -1;

            if(delays[i] > maxDelay)
                maxDelay = delays[i];
        }

        return maxDelay;

    }


    static class Pair{
        int node;
        int delay;


        public Pair(int node, int delay){
            this.node = node;
            this.delay = delay;
        }


        public int getNode(){
            return node;
        }

        public void setNode(int node){
            this.node =  node;
        }

        public int getDelay(){
            return delay;
        }

        public void setDelay(int delay){
            this.delay =  delay;
        }
    }

}
