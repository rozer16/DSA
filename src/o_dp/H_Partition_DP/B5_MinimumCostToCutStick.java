package o_dp.H_Partition_DP;

import java.util.Arrays;

public class B5_MinimumCostToCutStick {
    public static void main(String[] args) {
       int arr [] = {1,3,5,4};
       int stickLength = 7;
       B5_MinimumCostToCutStick solution = new B5_MinimumCostToCutStick();
        System.out.println("Recursion: "+solution.minCostRecursion(stickLength,arr ));
        System.out.println("Memoization: "+solution.minCostMemoization(stickLength,arr ));
        System.out.println("Tabulation "+solution.minCostTabulation(stickLength,arr ));

        /*
        Recursion : 38000
        Memoization: 38000
        Tabulation: 38000
        * */
    }




    public int minCostRecursion(int n, int[] cuts) {
        int len = cuts.length;

        //Sorting it in order to solve divison of two subproblem independently i.e. cutting stick on left subarray/ right subarray is possible
        Arrays.sort(cuts);
        int [] newCuts = new int[len+2];
        newCuts[0] = 0;
        System.arraycopy(cuts,0,newCuts,1, cuts.length);
        newCuts[newCuts.length-1] = n;
        return minCostRecursion(1,len, newCuts);

    }


    //Time Complexity: Exponential
    public int minCostRecursion(int left, int right, int[] cuts) {

        if(left > right)
            return 0;
        int mini = Integer.MAX_VALUE;
        for(int index = left; index <= right; index++){
            int cost =   (cuts[right+1]-cuts[left-1])
                    + minCostRecursion(left, index-1,cuts)
                    + minCostRecursion(index+1, right, cuts)
                    ;
            mini = Math.min(mini, cost);
        }

        return mini;
    }

    public int minCostMemoization(int n, int[] cuts) {
        int len = cuts.length;

        //Sorting it in order to solve divison of two subproblem independently i.e. cutting stick on left subarray/ right subarray is possible
        Arrays.sort(cuts);
        int [] newCuts = new int[len+2];
        newCuts[0] = 0;
        System.arraycopy(cuts,0,newCuts,1, cuts.length);
        newCuts[newCuts.length-1] = n;


        int[][] dp = new int[len+1][len+1];
        for(int [] row: dp)
            Arrays.fill(row, -1);

        return minCostMemoization(1,len, newCuts,dp);



    }

/*
    Time Complexity: O(N*N*N)

    Reason: There are 2 variables i and j, therefore, N*N states and we explicitly run a loop inside the function which will run for N times,
     therefore at max ‘N*N*N’ new problems will be solved.

    Space Complexity: O(N*N) + O(N)

    Reason: We are using an auxiliary recursion stack space(O(N))and a 2D array ( O(N*N)).*/

    public int minCostMemoization(int left, int right, int[] cuts, int[][] dp) {

        if(left > right)
            return 0;

        if(dp[left][right] != -1)
            return dp[left][right];
        int mini = Integer.MAX_VALUE;
        for(int index = left; index <= right; index++){
            int cost =   (cuts[right+1]-cuts[left-1])
                    + minCostRecursion(left, index-1,cuts)
                    + minCostRecursion(index+1, right, cuts)
                    ;
            mini = Math.min(mini, cost);
        }
        dp[left][right] = mini;
        return mini;
    }


    public int minCostTabulation(int n, int[] cuts) {
        int len = cuts.length;
        //Sorting it in order to solve divison of two subproblem independently i.e. cutting stick on left subarray/ right subarray is possible
        Arrays.sort(cuts);

        int [] newCuts = new int[len+2];
        newCuts[0] = 0;
        System.arraycopy(cuts,0,newCuts,1, cuts.length);
        newCuts[newCuts.length-1] = n;

        return minCostTabulation(newCuts, n);

    }


/*
    Time Complexity: O(N*N*N)

    Reason: There are 2 variables i and j, therefore, N*N states
    and we explicitly run a loop inside the function which will run for N times, therefore at max ‘N*N*N’ new problems will be solved.

    Space Complexity: O(N*N)
*/


    public int minCostTabulation(int[] cuts , int stickLegnth) {
        int n= cuts.length;
        int[][] dp = new int[n][n];


        // we need to iterate oppsite of recursion , recursion start point : left = 1, right = 4
        // Tabulation start point : left : 4, right = 1
        //n-2 since we added stick length at the end of an array so n-1 = stick of length and n-2 = last element of an original array
        for(int left = n-2 ; left >= 1; left--){
            for(int right=1; right <= n-2; right++){

                if(left > right)
                    continue;

                int mini = Integer.MAX_VALUE;
                for(int index = left; index <= right; index++){
                    int cost =   (cuts[right+1]-cuts[left-1])
                            + dp[left][index-1]
                            + dp[index+1][right];                                ;
                    mini = Math.min(mini, cost);
                }
                dp[left][right] = mini;
            }
        }

        // in memoization we returned : minCostMemoization(1,n-2, newCuts,dp);
        return dp[1][n-2];
    }
}
