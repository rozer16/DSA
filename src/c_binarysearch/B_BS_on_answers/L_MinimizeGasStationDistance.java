package c_binarysearch.B_BS_on_answers;


import java.util.PriorityQueue;

/*

https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1

https://leetcode.com/problems/minimize-max-distance-to-gas-station/description/
https://youtu.be/kMSBvlZ-_HA?list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF
https://leetcode.ca/all/774.html

On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 13,17,23], K = 5
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.



Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
* */
public class L_MinimizeGasStationDistance {

    public static void main(String[] args) {
        System.out.println(findSmallestMaxDistBruteforce(new int[]{1,2,3,4,5},4));
        System.out.println(findSmallestMaxBatter(new int[]{1,2,3,4,5},4));

    }


    //TC : n * logn + klogn
    //SC : O(stations.length-1) for newAdded and O(stations.length) for priority queue
    public static double findSmallestMaxBatter(int stations[], int k) {

        class Pair{
            double distance;
            int index;

            public Pair(double distance, int index) {
                this.distance = distance;
                this.index = index;
            }

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }
        }
        int n = stations.length;

        int newAdded [] = new int[n-1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)-> Double.compare(p2.distance,p1.distance));

        //TC : n * logn
        for (int i = 0; i < n-1; i++) {
            pq.offer(new Pair(stations[i+1]-stations[i],i));
        }

        //TC :  k logn
        //Pick and place k gas stations:
        for(int gasStation = 1; gasStation<=k; gasStation++){
            //Find the maximum section
            //and insert the gas station:

            Pair pair = pq.poll();
            newAdded[pair.index]++;
            double distance = stations[pair.index+1] - stations[pair.index];
            //If we are adding 1 station in between then 2 new gap will be created so newAdded[i]+1
            double secDistance = distance/(double)(newAdded[pair.index]+1);

            //insert the current gas station:
            pq.offer(new Pair(secDistance, pair.index));

        }

        return pq.peek().distance;
    }


    //TC : O(k*n)+O(n)
    public static double findSmallestMaxDistBruteforce(int stations[], int k) {
        int n = stations.length;

        int newAdded [] = new int[n-1];

        //Pick and place k gas stations:
        for(int gasStation = 1; gasStation<=k; gasStation++){
            //Find the maximum section
            //and insert the gas station:
            double maxDistance = 0;
            int maxDistIndex = -1;

            for(int i=0; i<n-1; i++){
                double distance = stations[i+1] - stations[i];
                //If we are adding 1 station in between then 2 new gap will be created so newAdded[i]+1
                double secDistance = distance/(double)(newAdded[i]+1);
                if(secDistance > maxDistance){
                    maxDistance = secDistance;
                    maxDistIndex = i;
                }
            }

            //insert the current gas station:
            newAdded[maxDistIndex]++;
        }

        double maxDistance = Integer.MIN_VALUE;


        //Find max distance after adding k new statation
        for(int i=0; i<n-1; i++){
            double distance = stations[i+1] - stations[i];
            double secDistance = (double)distance/(double)(newAdded[i]+1);
            if(secDistance > maxDistance){
                maxDistance = secDistance;
            }
        }

        return maxDistance;
    }
}
