package j_greedy_algorithm;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/problems/shortest-job-first/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-job-first
https://www.youtube.com/watch?v=3-QbX1iDbXs&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea&index=3


Geek is a software engineer.
He is assigned with the task of calculating average waiting time of all the processes by following shortest job first policy.

The shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting process with the smallest execution time to execute next.

Given an array of integers bt of size n.
 Array bt denotes the burst time of each process.
 Calculate the average waiting time of all the processes and return the nearest integer which is smaller or equal to the output.

Note: Consider all process are available at time 0.

Example 1:

Input:
n = 5
bt = [4,3,7,1,2]
Output: 4
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 4.
Example 2:

Input:
n = 4
arr = [1,2,3,4]
Output: 2
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function solve() which takes bt[] as input parameter and returns the average waiting time of all the processes.

Expected Time Complexity: O(nlog(n))
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 105
1 <= arr[i] <= 105



SJF : Scheduling policy that selects the waiting process with the smallest execution time to execute next.
* */
public class M_Shortest_Job_First {

    public static void main(String[] args) {
        M_Shortest_Job_First sol = new M_Shortest_Job_First();
        System.out.println(sol.solve(new int[]{4 ,7 ,5 ,8 ,4 ,2 ,10 ,8 ,2 ,9}));
    }
     int solve(int bt[] ) {

        //Sorting all the jobs based on unit time it takes since all the jobs are available at 0 time.
        Arrays.sort(bt);
        int timer = bt[0];
        int totalWaiting = 0;
        for(int i = 1; i< bt.length; i++){
            totalWaiting += timer;
            timer += bt[i];
        }

        return totalWaiting/bt.length;

    }

}
