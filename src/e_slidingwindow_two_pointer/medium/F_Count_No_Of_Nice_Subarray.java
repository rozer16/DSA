package e_slidingwindow_two_pointer.medium;


/*
https://youtu.be/j_QOv9OT9Og
https://leetcode.com/problems/count-number-of-nice-subarrays/description/


Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.



Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There is no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16


Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length


//Bruteforce

since subarray run two loop and cnt if no of cnt

Optimal
Solution of binary sum
if no is odd than 1 else 0
* */
public class F_Count_No_Of_Nice_Subarray {

    public int numberOfSubarrays(int[] nums, int k) {
        return numSubarraysWithSumLessThanOrEqualToGoal(nums, k) - numSubarraysWithSumLessThanOrEqualToGoal(nums, k-1);
    }

    public int numSubarraysWithSumLessThanOrEqualToGoal(int[] nums, int k){
        if(k <0)
            return 0;

        int left = 0;
        int right = 0;
        int cnt=0;
        int sum = 0;

        while(right < nums.length){

            sum += nums[right] %2 == 1 ? 1 : 0;

            //If sum is greater than k that means no of odd elements in subarray are greater than k
            while(sum > k){
                sum = sum - nums[left] %2 == 1 ? 1 : 0;
                left++;
            }

            //No of sub array between index i and j : j-i+1
            cnt = cnt + (right-left+1);

            right++;
        }

        return cnt;
    }

}
