package j_stack;



/*
* https://leetcode.com/problems/sum-of-subarray-ranges/
*
You are given an integer array nums.
The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.
*
*
*
Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
*
*
Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
*
*
*
Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.
* */
public class V_SumOfSubArrayRanges {

    public static void main(String[] args) {
        V_SumOfSubArrayRanges test = new V_SumOfSubArrayRanges();
        int [] arr = {1,2,3};
        System.out.println(test.subArrayRanges(arr));
    }


    /*

    TC : Complexity : O(n^2)
    SC : O(1)

    */
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long sum = 0;
        for(int i=0;i<len;i++){
            int maxVal = nums[i];
            int minVal = nums[i];
            for(int j = i+1; j<len;j++){
                maxVal = Math.max(maxVal,nums[j]);
                minVal = Math.min(minVal,nums[j]);
                sum += (maxVal-minVal);
            }
        }
        return sum;
    }
}