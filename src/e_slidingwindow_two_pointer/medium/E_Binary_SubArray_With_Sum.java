package e_slidingwindow_two_pointer.medium;


    /*
    https://leetcode.com/problems/binary-subarrays-with-sum/
    https://youtu.be/XnMdNUkX6VM

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
101
1010
00101
00101
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15


Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length




===============
arr : 1,0,1,0,1
No of subarray whose sum <= 2 are  14
1 10 101 1010 0 01 010 0101 1 10 101 0 01 1

No of subarray whose sum <= 1 = 10
1  10 0 01 010 1 10 0 01 1


* */
public class E_Binary_SubArray_With_Sum {

    public int numSubarraysWithSum(int[] nums, int goal) {

        //Ask : no of subArray where sum = goal
        //Solution :
        //(No of subArray where sum <= goal) -
        //(No of subArray where sum <= goal-1)

        //Lets say k = 3
        // No of subarray where sum <= 3 are : 5
        //No of subarray where sum <= 2 are 3
        // So no of subarray where sum = 3 are 5-3 = 2
        int n = numSubarraysWithSumLessThanOrEqualToGoal(nums,goal);
        int n1 = numSubarraysWithSumLessThanOrEqualToGoal(nums,goal-1);
        return n-n1;
    }

    //First task is to find no of subarray less than or equal to goal
    public int numSubarraysWithSumLessThanOrEqualToGoal(int[] nums, int goal){
        if(goal <0)
            return 0;

        int left = 0;
        int right = 0;
        int cnt=0;
        int sum = 0;
        while(right < nums.length){
            sum += nums[right];

            while(sum > goal){
                sum = sum - nums[left];
                left++;
            }
            cnt = cnt + (right-left+1);

            right++;
        }

        return cnt;
    }

}
