package j_stack;

import java.util.*;
/*
* https://leetcode.com/problems/next-greater-element-iv/
*
*
You are given a 0-indexed array of non-negative integers nums.
For each integer in nums, you must find its respective second greater integer.
The second greater integer of nums[i] is nums[j] such that: j > i && nums[j] > nums[i]
There exists exactly one index k such that nums[k] > nums[i] and i < k < j.
If there is no such nums[j], the second greater integer is considered to be -1.

Input: nums = [2,4,0,9,6]
Output: [9,6,6,-1,-1]
Explanation:
0th index: 4 is the first integer greater than 2, and 9 is the second integer greater than 2, to the right of 2.
1st index: 9 is the first, and 6 is the second integer greater than 4, to the right of 4.
2nd index: 9 is the first, and 6 is the second integer greater than 0, to the right of 0.
3rd index: There is no integer greater than 9 to its right, so the second greater integer is considered to be -1.
4th index: There is no integer greater than 6 to its right, so the second greater integer is considered to be -1.
Thus, we return [9,6,6,-1,-1].
*
*
Input: nums = [3,3]
Output: [-1,-1]
Explanation:
We return [-1,-1] since neither integer has any integer greater than it.
*
*
*
Input: nums = [1,17,18,0,18,10,20,0]
Output:       [18,18,-1,10,-1,-1,-1,-1]
*
*
*
* Solution 1
*  [2,4,0,9,6]
*
* 1) create one array sortedNum
* 2) Copy elements from original arrays to sortedNum and sort - SortedNums = [0,2,4,6,9]
* 3) Create map, iterate through all elements of nums and store element and index of each element
* 4)
* */
public class P_NextSecondGreaterElement {


    public static void main(String[] args) {
        int [] arr = {1,17,18,0,18,10,20,0};
        P_NextSecondGreaterElement test = new P_NextSecondGreaterElement();
        System.out.println(Arrays.toString(test.nextSecondGreaterEle(arr)));
    }
    public int[] nextSecondGreaterEle(int[] nums){
        int [] result = new int[nums.length];
        if(nums.length <= 2){
            Arrays.fill(result,-1);
            return result;
        }


        int [] sortedNums =new int[nums.length];
        System.arraycopy(nums,0, sortedNums,0, nums.length);
        int n = nums.length;
        Arrays.sort(sortedNums);

        Map<Integer,Integer>  valueIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueIndex.put(nums[i],i);
        }


        int [] arr = new int[nums.length];
        Arrays.fill(arr,-1);

        for (int j = n-1; j >=0 ; j--) {
                    int index = valueIndex.get(sortedNums[j]);
                    result[index] = findSecondLargest(nums,arr,index);

        }
        return result;
    }

    public int findSecondLargest(int [] originalNum,int [] sortedNum,int index){
        int result = -1;
        boolean firstFound = false;
        for (int i = index+1; i < sortedNum.length; i++) {

            if(sortedNum[i] == 1){
                if(!firstFound){
                    firstFound = true;
                }else{
                    result = originalNum[i];
                    break;
                }
            }
        }
        sortedNum[index] = 1;
        return result;
    }


}
