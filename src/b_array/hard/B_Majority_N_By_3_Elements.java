package b_array.hard;

import java.util.*;

/*
https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/
https://youtu.be/vwZj1K0e9U8
https://leetcode.com/problems/majority-element-ii/description/



Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

If no such element exists, return an empty vector.

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]



If we closely observe, in the given array, there can be a maximum of two integers that can occur more than floor(N/3) times.

Let’s understand it using the following scenario:
Assume there are 8 elements in the given array. Now,
if there is any majority element, it should occur more than floor(8/3) = 2 times.

So, the majority of elements should occur at least 3 times.
Now, if we imagine there are 3 majority elements, then the total occurrence of them will be 3X3 = 9 i.e. greater than the size of the array.
But this should not happen. That is why there can be a maximum of 2 majority elements.
* */
public class B_Majority_N_By_3_Elements {


    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11,4,5, 33, 11};
        B_Majority_N_By_3_Elements sol = new B_Majority_N_By_3_Elements();
        List<Integer> ans = sol.majorityElement(arr); //11,33
    }

    /*
            Time Complexity: O(N) + O(N), where N = size of the given array.
            Reason: The first O(N) is to calculate the counts and find the expected majority elements.
            The second one is to check if the calculated elements are the majority ones or not.

            Space Complexity: O(1) as we are only using a list that stores a maximum of 2 elements. The space used is so small that it can be considered constant.
    * */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i< n; i++ ){
            if(cnt1 == 0 && nums[i] != ele2){
                cnt1 = 1;
                ele1 = nums[i];
            }else if(cnt2 == 0 && nums[i] != ele1){
                cnt2 = 1;
                ele2 = nums[i];
            }else if(ele1 == nums[i]){
                cnt1++;
            }else if(ele2 == nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1) cnt1++;
            if (nums[i] == ele2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) result.add(ele1);
        if (cnt2 >= mini)  result.add(ele2);


        return result;
    }



    /*
        Use a hashmap and store the elements as <key, value> pairs. (Can also use frequency array based on the size of nums).
            Here the key will be the element of the array and the value will be the number of times it occurs.

        Time Complexity: O(N*logN), where N = size of the given array.
        Reason: We are using a map data structure.
        Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN).
        If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

        Space Complexity: O(N) as we are using a map data structure.
        We are also using a list that stores a maximum of 2 elements. That space used is so small that it can be considered constant.
    * */
    public List<Integer> majorityElementBetter(int []v) {
        int n = v.length; //size of the array
        List<Integer> ls = new ArrayList<>(); // list of answers

        //declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // least occurrence of the majority element:
        int mini = (int)(n / 3) + 1;

        //storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);

            //checking if v[i] is
            // the majority element:
            if (mpp.get(v[i]) == mini) {
                ls.add(v[i]);
            }
            if (ls.size() == 2) break;
        }

        return ls;
    }
}
