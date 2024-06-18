package e1_greedy_algorithm;

import java.util.Arrays;


/*
https://leetcode.com/problems/jump-game-ii/description/
https://youtu.be/7SBVnw7GSTk?list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea
* */
public class H_Jump_Game_II {
    public static void main(String[] args) {

        H_Jump_Game_II sol = new H_Jump_Game_II();
        System.out.println(sol.getNoOfJumpsRecursive(new int[]{2,3,1,4,1,1,1,2}, 0,0));
        System.out.println(sol.getNoOfJumpsRecursive(new int[]{2,3,0,1,4}, 0,0));
        System.out.println(sol.getNoOfJumpsRecursive(new int[]{2,3,1,1,4}, 0,0));


        int dp[][] = new int[8][8];
        for (int i = 0; i < 8; i++)
            Arrays.fill(dp[i], -1);

        System.out.println(sol.getNoOfJumpMemoization(new int[]{2,3,1,4,1,1,1,2}, 0,0,dp));

       int dp1[][] = new int[5][5];
        for (int i = 0; i < 5; i++)
            Arrays.fill(dp1[i], -1);
        System.out.println(sol.getNoOfJumpMemoization(new int[]{2,3,0,1,4}, 0,0,dp1));

        int dp2[][] = new int[5][5];
        for (int i = 0; i < 5; i++)
            Arrays.fill(dp2[i], -1);
        System.out.println(sol.getNoOfJumpMemoization(new int[]{2,3,1,1,4}, 0,0,dp2));


        System.out.println(sol.jumpGreedy(new int[]{2,3,1,4,1,1,1,2}));
        System.out.println(sol.jumpGreedy(new int[]{2,3,0,1,4}));
        System.out.println(sol.jumpGreedy(new int[]{2,3,1,1,4}));
    }



    //TC : O(N^N)
    //SC : O(N) Auxiliary stace space
    public int getNoOfJumpsRecursive(int jumpArr[] ,int index, int jumps){
        if(index == jumpArr.length-1)
            return jumps;


        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= jumpArr[index]; i++) {
            minJumps = Math.min(minJumps, getNoOfJumpsRecursive(jumpArr, index+i, jumps+1));
        }

        return minJumps;
    }


    //TC : O(N^2)
    //SC : O(N^2) Auxiliary stace space + DP array
    public int getNoOfJumpMemoization(int jumpArr[] ,int index, int jumps, int[] [] dp){
        if(index == jumpArr.length-1)
            return jumps;

        if(dp[index][jumps] != -1 )
                return dp[index][jumps];


        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= jumpArr[index]; i++) {
            minJumps = Math.min(minJumps, getNoOfJumpMemoization(jumpArr, index+i, jumps+1,dp));
        }

        dp[index][jumps] = minJumps;
        return minJumps;
    }


    public int getNoOfJumpTabulation(int jumpArr[]){
        int n = jumpArr.length;
        int dp2[][] = new int[n][n];

        for(int index =0  ; index<n; index++){

        }


        return dp2[0][0];
    }


    //Range based solution
    /*
    Start with range 0-0
    Iterate through array, set left = right+1 and choose right with the one which is farthest

    //TC : O(N)
    SC : : O(1)
    * */
    public int jumpGreedy(int[] nums) {
        int left = 0;
        int right = 0;
        int jumps = 0;
        int index = 0;

        while(right < nums.length-2){
            int farthest = 0;
            for(int i = left; i<=right; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }

            left = right+1;
            right = farthest;
            jumps++;
        }

        return jumps;
    }

}
