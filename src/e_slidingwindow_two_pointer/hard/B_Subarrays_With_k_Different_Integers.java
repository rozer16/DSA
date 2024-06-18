package e_slidingwindow_two_pointer.hard;


import java.util.HashMap;
import java.util.Map;

/*
https://www.youtube.com/watch?v=7wYGbV_LsX4
https://leetcode.com/problems/subarrays-with-k-different-integers/description/


Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.



Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].



Note : This problem is slightly diff than earlier, need to return no of subarray rather than longest sub array
* */
public class B_Subarrays_With_k_Different_Integers {


    public static void main(String[] args) {
        B_Subarrays_With_k_Different_Integers sol = new B_Subarrays_With_k_Different_Integers();
        System.out.println(sol.subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int k1 =  subArrayWithLessThanOrEqualToK(nums, k) ;
        int k2 = subArrayWithLessThanOrEqualToK(nums, k-1);
        return k1-k2;

    }

    public int subArrayWithLessThanOrEqualToK(int [] nums, int k){
        int n = nums.length;
        int left = 0;
        int right = 0;
        int cnt = 0;
        Map<Integer, Integer> numFreq = new HashMap<>();

        while(right < n){


            if(numFreq.containsKey(nums[right])){
                numFreq.put(nums[right] , numFreq.get(nums[right])+1);
            }else{
                numFreq.put(nums[right],1);
            }

            while(numFreq.size() > k){
                int curr = numFreq.get( nums[left]);
                if(curr == 1){
                    numFreq.remove(nums[left]);
                }else{
                    numFreq.put(nums[left] , numFreq.get(nums[left])-1);
                }

                left++;
            }

            cnt = cnt + (right - left + 1);

            right++;
        }

        return cnt;
    }
}
