package e1_greedy_algorithm;

import java.util.Arrays;


/*
https://leetcode.com/problems/jump-game-ii/description/
https://youtu.be/7SBVnw7GSTk?list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea


You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].


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
