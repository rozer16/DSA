package o_dp.C_2D_DP;

import java.util.Arrays;

public class A3_Ninja_Training {
    public static void main(String[] args) {
        int[][] points = {
                {2,1,3},
                {3,4,6},
                {10,1,6},
                {8,3,7}
        };

        int[][] points1 = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        A3_Ninja_Training solution = new A3_Ninja_Training();
        System.out.println("Max Merit Points Ninja can earn for given points using recursion :  "+solution.ninjaTrainingMemoization(points));
        System.out.println("Max Merit Points Ninja can earn for given points using tabulation :  "+solution.ninjaTrainingTabulation(points));
        System.out.println("Max Merit Points Ninja can earn for given points using space optimization :  "+solution.ninjaTrainingSpaceOptimization(points));
    }


    public int ninjaTrainingRecursion(int [][] points){
        return ninjaTrainingRecursion(points, points.length -1, 3);
    }


    //Time Complexity: O(N*4*3)
        //Reason: There are N*4 states and for every state, we are running a for loop iterating three times.

    //Space Complexity: O(N) + O(N*4)
        //Reason: We are using a recursion stack space(O(N)) and a 2D array (again O(N*4)). Therefore total space complexity will be O(N) + O(N) ≈ O(N)

    public int ninjaTrainingRecursion(int [][] points, int index, int lastActivityNo){
        if(index == 0){
            int maxi = Integer.MIN_VALUE;
            for (int activity = 0; activity < 3; activity++) {
                if(activity != lastActivityNo)
                    maxi = Math.max(points[0][activity], maxi);
            }
            return maxi;
        }

        int maxi = Integer.MIN_VALUE;
        for (int activity = 0; activity < 3; activity++) {
            if(activity != lastActivityNo){
                int task1 = points[index][activity]+ninjaTrainingRecursion(points, index-1, activity);
                if(index == points.length-1)
                    System.out.println(task1);
                maxi = Math.max(maxi,task1);

            }
        }
        return maxi;
    }


    public int ninjaTrainingMemoization(int [][] points){
            int [][] dp = new int[points.length][4];
            for(int [] arr : dp)
                Arrays.fill(arr,-1);
            return ninjaTrainingMemoization(points, points.length -1, 3,dp);
    }

    public int ninjaTrainingMemoization(int [][] points, int index, int lastActivityNo, int [][] dp){
        if(dp[index][lastActivityNo] != -1)
            return dp[index][lastActivityNo];

        if(index == 0){
            int maxi = Integer.MIN_VALUE;
            for (int activity = 0; activity < 3; activity++) {
                if(activity != lastActivityNo)
                    maxi = Math.max(points[0][activity], maxi);
            }
            return maxi;
        }

        int maxi = Integer.MIN_VALUE;
        for (int activity = 0; activity < 3; activity++) {
            if(activity != lastActivityNo){
                int task1 = points[index][activity]+ninjaTrainingMemoization(points, index-1, activity,dp);
                maxi = Math.max(maxi,task1);

            }
        }
        dp[index][lastActivityNo] = maxi;
        return maxi;
    }


    public int ninjaTrainingTabulation(int [][] points){
        int n = points.length;

        //dp [i][j] = On day i, best score  we get can if j task is not performed
        //this can be used for i+1th day for performing jth task for i+1th day
        int[][] dp = new int[n][4];

        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int CurrentDay = 1; CurrentDay < n; CurrentDay++) {
            for (int lastDayTask = 0; lastDayTask < 4; lastDayTask++) {
                dp[CurrentDay][lastDayTask] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int todayTask = 0; todayTask <= 2; todayTask++) {
                    if (todayTask != lastDayTask) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[CurrentDay][todayTask] + dp[CurrentDay - 1][todayTask];
                        // Update the maximum points for the current day and last activity
                        dp[CurrentDay][lastDayTask] = Math.max(dp[CurrentDay][lastDayTask], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[n - 1][3];
    }

    public int ninjaTrainingSpaceOptimization(int [][] points){
        int n = points.length;

        //dp [i][j] = On day i, best score  we get can if j task is not performed
        //this can be used for i+1th day for performing jth task for i+1th day
        int[] prev = new int[4];

        // Initialize the first day's maximum points based on the available choices
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int CurrentDay = 1; CurrentDay < n; CurrentDay++) {
            int [] curr = new int[4];
            for (int lastDayTask = 0; lastDayTask < 4; lastDayTask++) {
                curr[lastDayTask] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int todayTask = 0; todayTask <= 2; todayTask++) {
                    if (todayTask != lastDayTask) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[CurrentDay][todayTask] + prev[todayTask];
                        // Update the maximum points for the current day and last activity
                        curr[lastDayTask] = Math.max(curr[lastDayTask], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return prev[3];
    }


}
