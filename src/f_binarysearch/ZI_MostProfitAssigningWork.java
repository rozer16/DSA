package f_binarysearch;


import java.util.Arrays;

/*
*
* You have n jobs and m workers.
* You are given three arrays: difficulty, profit, and worker where:
* difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
* worker[j] is the ability of jth worker
* (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
* Every worker can be assigned at most one job, but one job can be completed multiple times.

  For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.

   Return the maximum profit we can achieve after assigning the workers to the jobs.

    Input: difficulty= [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
    Output: 100
    Explanation: Workers are assigned jobs of difficulty [4,4,6,6]
    and they get a profit of [20,20,30,30] separately.
    *
* */
public class ZI_MostProfitAssigningWork {



    public int getMostProfitAssigningWork(int [] difficulty, int [] profit,int [] workers){

        Job jobs [] = new Job[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            Job job = new Job(difficulty[i],profit[i]);
            jobs[i] = job;
        }

        Arrays.sort(jobs ,  (j1, j2) -> Integer.compare(j1.difficulty, j2.difficulty));
        Arrays.sort(workers);
        int max = 0;
        int i=0;
        int result=0;
        for(int worker:workers){
            while(i< jobs.length && worker >= jobs[i].getDifficulty() ){
                max = Math.max(max,jobs[i].getProfit());
                i++;
            }
            result += max;
        }

        return result;

    }

    public static void main(String[] args) {
        int [] difficulty = {2,4,6,8,10};
        int [] profit = {10,20,30,40,50};
        int [] worker = {4,5,6,7};

        System.out.println(new ZI_MostProfitAssigningWork().getMostProfitAssigningWork(difficulty,profit,worker));
    }

    class Job{
        int difficulty;
        int profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(int difficulty) {
            this.difficulty = difficulty;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }
    }
}
