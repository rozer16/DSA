package h_bitmanipulation;

/*
Need to revisit just copied solution.
https://leetcode.com/problems/single-number-ii/description/

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99


Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.



2 2 3 2

10
10
11
10

for 0 bit, no of 1 bit =1 ==> 1%3 ==> 1 ==> ans = 1
for 1st bit , no i 1 bit ==> 4 ==> 4%3 ==> 1 ==> ans = ans+(1<<i) ==> ans = ans+(1<<1) = 3
 */
public class S_FindOneElementHavingCountNot3 {
    public static void main(String[] args) {
        int [] arr = {2,2,3,2};
        int arr1 [] = {-2,-2,1,1,4,1,4,4,-4,-2};
        S_FindOneElementHavingCountNot3 test  = new S_FindOneElementHavingCountNot3();
        System.out.println(test.singleNumber(arr1));
    }

    public int singleNumber(int [] nums){
        int ans=0;
        for(int i=0; i<32; i++){
            int t=0;
            for(int j=0; j<nums.length; j++){
                t+=(nums[j]&1);
                nums[j]>>=1;
            }
            ans+=((t%3)<<i);
        }
        return ans;
    }

    public boolean isIthBitSet(int no,int i){
        return (no & 1<<i) > 0;
    }
    public int singleNumber1(int[] nums) {
        int ans = 0;
        int cnt = 0;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){

            ans = (ans ^ nums[i]) & ~cnt;
            cnt = (cnt ^ nums[i]) & ~ans;
        }
        return ans;
    }
}
