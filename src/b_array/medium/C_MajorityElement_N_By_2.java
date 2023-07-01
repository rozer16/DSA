package b_array.medium;

/*
* https://leetcode.com/problems/majority-element/
* https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
* You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
*
* */
public class C_MajorityElement_N_By_2 {


    /*
    * Bruteforce : Run two loop and , for outer i inner loop will count ith element and if its more than i/2 return it
    *              Complexity : O(n^2)
    *
    * Better :  Use HashMap, iterate through array and check if that array exists in map, if no then put otherwise increase its val by one
                Time Complexity :  O(N*logN) + O(N), where N = size of the given array.
                                        Reason: We are using a map data structure.
                                        * Insertion in the map takes logN time and we are doing it for N elements.
                                          So, it results in the first term O(N*logN).
                                        * The second O(N) is for checking which element occurs more than floor(N/2) times.
                                          If we use unordered_map instead, the first term will be O(N) for the best and average case
                                          and for the worst case, it will be O(N2).

                Space Complexity: O(N) as we are using a map data structure.
    *
    *
    * Optimal :
    *           Boyer–Moore's voting algo : https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm#:~:text=The%20Boyer%E2%80%93Moore%20majority%20vote,example%20of%20a%20streaming%20algorithm.
    *
    *
    * TC : For algo O(n)
    *
    *
    * */
    public static void main(String[] args) {
        int [] arr = {3,2,3};
        int [] arr1 = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        C_MajorityElement_N_By_2 test = new C_MajorityElement_N_By_2();
        System.out.println(test.majorityElement(arr1));
    }

    /*
    *
    * Initialize 2 variables:
        Count –  for tracking the count of element
        Element – for which element we are counting
    Traverse through the given array.
    If Count is 0 then store the current element of the array as Element.
    If the current element and Element are the same increase the Count by 1.
    If they are different decrease the Count by 1.
    The integer present in Element should be the result we are expecting
    *
    *
    * */
    public int majorityElement(int[] nums) {
        int count = 1;
        int ele = nums[0];

        for(int i=1;i< nums.length;i++){
            if(count == 0)
                ele = nums[i];
            if(nums[i] == ele){
                count++;
            }else{
                count--;
            }
        }
        count = 0;

        //This step would be required only when problem says there might not be such element.
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == ele)
                count++;
        }
        return count > nums.length/2 ? ele : -1;
    }
}
