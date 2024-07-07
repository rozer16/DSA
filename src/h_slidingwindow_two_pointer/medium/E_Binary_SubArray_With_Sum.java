package h_slidingwindow_two_pointer.medium;


import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/binary-subarrays-with-sum/
    https://leetcode.com/problems/binary-subarrays-with-sum/editorial/
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

for more details : https://leetcode.com/problems/binary-subarrays-with-sum/editorial/

The reason for this is that atMost(2) includes all sets of windows whose total sum is equal to 0, 1, and 2,
 while atMost(1) comprises sets with sums of 0 and 1.

Now, see that the set atMost(2) contains the whole set of atMost(1).
So, when we subtract them, we get the remainder—subarrays that have a sum exactly equal to 2.


Complexity Analysis
Let nnn be the length of the nums array.

Time complexity: O(n)O(n)O(n)

The function slidingWindowAtMost uses two pointers, start and end to process the elements in the array. Although there is a nested loop, each pointer starts at 000 and gets incremented at most nnn times, so each pointer makes just 111 pass through the array. This means the time complexity of the function slidingWindowAtMost is O(n)O(n)O(n). We call slidingWindowAtMost twice, resulting in an overall time complexity of O(n)O(n)O(n).

Space complexity: O(1)O(1)O(1)

The space complexity is O(1)O(1)O(1) because the algorithm uses a constant amount of space for variables such as start, currentSum, and totalCount. The space required does not depend on the size of the input array.
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



        /*
        Intuition
The task involves identifying contiguous sequences of elements within an array whose sum equals a specific target value. Problems that require sequences of elements to meet criteria often utilize prefix sums.

We begin by iterating through the array. As we encounter each element, we maintain a running total (current sum). This current sum represents the cumulative addition of all elements encountered so far in the array.

Next, we check if the current sum precisely matches the target value. If it does, we have found a subarray whose elements add up to the goal.

Now consider a scenario where the current sum exceeds the target value. This doesn't necessarily eliminate the possibility of finding a subarray that meets the criteria. We need a method to determine the sum of subarrays that begin after the first index of the original array.

A prefix sum represents the cumulative sum of elements up to a specific point in the array. By subtracting the target value from the current sum, we obtain a new value, called as "prefix sum." If this value appears earlier in the array, it means a subarray starting later adds up to the target. In simpler terms, a subsequence of these elements adds up to the target sum value.

We can use a map to track the occurrences of prefix sums. If a prefix sum exists in the map, it indicates multiple groups that sum to the target. We update the map by adding the current sum. This ensures we can find any corresponding subarrays that leads to goal.

Refer to the visual slideshow demonstrating the algorithm with the example input [1, 0, 1, 0, 1] and goal = 2.


Let nnn be the length of the input array nums.

Time complexity: O(n)

We iterate through the array once to calculate the prefix sums and update the frequency map.

Space complexity: O(n)

We use an unordered map (freq) to store the frequency of prefix sums.
In the worst case, all prefix sums can be distinct,
 resulting in n unique entries in the map.
 Therefore, the space required is proportional to the size of the input array.
 // 1 0 0 1 1 0

        * */
        public int numSubarraysWithSum1(int[] nums, int goal) {
            int totalCount = 0;
            int currentSum = 0;
            // {prefix: number of occurrence}
            Map<Integer, Integer> freq = new HashMap<>(); // To store the frequency of prefix sums

            for (int num : nums) {
                currentSum += num;
                if (currentSum == goal){
                    totalCount++;
                }

                // Check if there is any prefix sum that can be subtracted from the current sum to get the desired goal
                if (freq.containsKey(currentSum - goal)){
                    totalCount += freq.get(currentSum - goal);
                }

                freq.put(currentSum, freq.getOrDefault(currentSum, 0) + 1);
            }

            return totalCount;
        }

}
