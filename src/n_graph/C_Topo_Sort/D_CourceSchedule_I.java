package n_graph.C_Topo_Sort;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Statement I (Course Schedule): There are a total of n tasks you have to pick, labeled from 0 to n-1.
Some tasks may have prerequisites tasks, for example, to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]

Given the total number of n tasks and a list of prerequisite pairs of size m. Find the order of tasks you should pick to finish all tasks.

Note: There may be multiple correct orders, you need to return one of them. If it is impossible to finish all tasks, return an empty array.

Problem Statement II (Pre-requisite Tasks): There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites,
for example, to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]

Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.

Note: These two questions are linked. The second question asks if it is possible to finish all the tasks and the first question states to return the ordering of the tasks if it is possible to perform all the tasks, otherwise return an empty array.


* */
public class D_CourceSchedule_I {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer> courseOrder = new ArrayList<>();
        //Initialize Adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        /*
        numCourses = 2, prerequisites = [
                                            [1,0],
                                            [0,1]
                                        ]

        There are a total of 2 courses to take.
        To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
        * */
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //count indegree for each node
        int [] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighNode : adj.get(i)){
                inDegree[neighNode]++;
            }
        }


        //Get add nodes whose indegree are zero and add them to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }


        while(!queue.isEmpty()){
            int node = queue.remove();
            courseOrder.add(node);

            for(int neighNode : adj.get(node)){
                inDegree[neighNode]--;
                if(inDegree[neighNode] == 0)
                    queue.add(neighNode);
            }
        }

        return courseOrder.size() == numCourses;
    }

    public static void main(String[] args) {
        
    }
}
