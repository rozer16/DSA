package e1_greedy_algorithm;


import java.util.Arrays;

/*

https://www.youtube.com/watch?v=LjPx4wQaRIs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=48
https://www.youtube.com/watch?v=LjPx4wQaRIs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=48

https://takeuforward.org/data-structure/job-sequencing-problem/
* */
public class L_Job_Sequencing_Problem {


    public static void main(String[] args) {
        Job [] jobs = {
          new Job(1,4,20),
          new Job(2,1,10),
          new Job(3,1,40),
          new Job(4,1,30),



        };

        L_Job_Sequencing_Problem sol = new L_Job_Sequencing_Problem();
        System.out.println(Arrays.toString(sol.JobScheduling(jobs, jobs.length)));
    }



    /*
        Time Complexity: O(N log N) + O(N*M).
        O(N log N ) for sorting the jobs in decreasing order of profit.
        O(N*M) since we are iterating through all N jobs and for every job we are checking from the last deadline,
         say M deadlines in the worst case.

        Space Complexity: O(M) for an array that keeps track of which day job is performed
        if M is the maximum deadline available.
    * */
    int[] JobScheduling(Job arr[], int n){
        //Comparator<Job> c1 = (c1,c2) -> c2.profit - c1.profit;
        Arrays.sort(arr, (c1,c2) -> c2.profit - c1.profit);

        int maxDeadline = Integer.MIN_VALUE;
        for(int i = 0; i< n; i++){
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }


        //Creating array to maintain if on given time unit we have allocated a job already.
        int jobs [] = new int[maxDeadline+1];
        Arrays.fill(jobs, -1);
        //Since we are going to map job 1..N, populating arr[0] = 1
        jobs[0] = 1;
        int noOfJobs = 0;
        int profit = 0;
        for(int i = 0; i<n; i++){
            int deadline = arr[i].deadline;
            while(deadline >= 0 && jobs[deadline] != -1)
                deadline--;

            if(deadline >= 0){
                jobs[deadline] = arr[i].id;
                noOfJobs++;
                profit += arr[i].profit;

            }
        }
        return new int[]{noOfJobs, profit};
    }



    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", profit=" + profit +
                    ", deadline=" + deadline +
                    '}';
        }
    }
}
