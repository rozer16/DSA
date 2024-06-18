package e1_greedy_algorithm;

/*
https://leetcode.com/problems/jump-game/description/
https://youtu.be/tZAa_jJ3SwQ?list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea



You are given an integer array nums.
You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what.
Its maximum jump length is 0, which makes it impossible to reach the last index.

*/

public class G_Jump_Game_I {

    public static void main(String[] args) {
        G_Jump_Game_I sol = new G_Jump_Game_I();
        System.out.println(sol.canJump(new int[]{2,3,1,1,4}));

        System.out.println(sol.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        int reachable = 0;

        for (int index = 0; index < nums.length; index++) {
            if(reachable < index)
                return false;

            reachable = Math.max(reachable, nums[index]+index);
        }

        return true;
    }
}
