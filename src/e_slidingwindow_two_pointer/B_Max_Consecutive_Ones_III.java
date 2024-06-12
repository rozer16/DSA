package e_slidingwindow_two_pointer;


/*

https://www.youtube.com/watch?v=3E4JBHSLpYk
https://leetcode.com/problems/max-consecutive-ones-iii/description/


Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.



//To solve the problem easily we can think this problem as longest subarray with max k zeroes
* */
public class B_Max_Consecutive_Ones_III {

    public static void main(String[] args) {
        B_Max_Consecutive_Ones_III sol = new B_Max_Consecutive_Ones_III();
        System.out.println(sol.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }


    /*
    To improve complexity from n^2 to n, and subarray we can use two pointers
    * */
    //TC : O(n)
    //SC : O(1)
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        int n = nums.length;


        while(right < n){
            if(nums[right] == 0)
                zeros++;

            //If zeros are greater than k then keep moving left and reduce zeros if nums[left] == 0
            if(zeros > k){
                if(nums[left] == 0)
                    zeros--;

                left++;
            }

            //Check length only if no of zeros are less than k.
            if(zeros <= k){
                max = Math.max(right-left+1, max);
            }

            right++;
        }

        return max;
    }

    //TC : O(n^2)
    // SC : O(1)
    public int longestOnesBF(int[] nums, int k) {
        int max = 0;

        for(int i =0; i<nums.length; i++){
            int noOfZeros = 0;
            for(int j=i; j<nums.length; j++){
                if(nums[j] == 0){
                    noOfZeros++;
                }

                if(noOfZeros <= k){
                    max = Math.max(j-i+1,max);
                }else{
                    break;
                }
            }
        }
        return max;
    }
}
