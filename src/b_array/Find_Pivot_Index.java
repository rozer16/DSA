package b_array;


/*
https://leetcode.com/problems/find-pivot-index/


Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.



Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Example 3:

Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0

* */
public class Find_Pivot_Index {

    public static void main(String[] args) {
        int [] arr = {1,7,3,6,5,6};

        Find_Pivot_Index sol = new Find_Pivot_Index();
        System.out.println(sol.pivotIndex(arr));
    }
    public int pivotIndex(int[] nums) {
            // Initialize total sum of the given array...
            int totalSum = 0;
            // Initialize 'leftsum' as sum of first i numbers, not including nums[i]...
            int leftsum = 0;
            // Traverse the elements and add them to store the totalSum...
            for (int ele : nums)
                totalSum += ele;

            // Again traverse all the elements through the for loop and store the sum of i numbers from left to right...
            for (int i = 0; i < nums.length; i++) {
                // sum to the left == leftsum.
                // sum to the right === totalSum - leftsum - nums[i]..
                // check if leftsum == totalSum - leftsum - nums[i]...
                if (leftsum  == totalSum -leftsum- nums[i])
                    return i;       // Return the pivot index...

                leftsum += nums[i];
            }
            return -1;
    }

}
