package b_array.medium;


import java.util.Arrays;

/*
* https://leetcode.com/problems/rearrange-array-elements-by-sign/
* https://takeuforward.org/arrays/rearrange-array-elements-by-sign/
*
*
* You are given a 0-indexed integer array nums of even length
  consisting of an equal number of positive and negative integers.

* You should rearrange the elements of nums such that the modified array
 follows the given conditions:

        * Every consecutive pair of integers have opposite signs.
        * For all integers with the same sign, the order in which they were present
          in nums is preserved.
        * The rearranged array begins with a positive integer.
        * Return the modified array after rearranging the elements to satisfy
          aforementioned conditions.



Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect
 because they do not satisfy one or more conditions.



* Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
*
* */
public class E_RearrangeArrayByItsSign {

    public static void main(String[] args) {
      E_RearrangeArrayByItsSign test = new E_RearrangeArrayByItsSign();

      int [] arr = {3,1,-2,-5,2,-4};
      test.rearrangeArrayByItsSing(arr);
      System.out.println(Arrays.toString(arr));

      int[] arr1 = {3,1,-2,-5,2,-4,6,2};
      System.out.println(Arrays.toString(test.rearrangeArrayByItsSing1(arr1)));
    }




    /*
    * if noOfPos = noIfNeg
    * To reduce complexity from 2n to n, we can keep two pointer
    *
    *
    * Step 1 : posIndex=0 and negIndex=1
    * Step 2 : Initialize an array result with size n
    * Step 3 : iterate through array and check if arr[i] is positive or negative
    * Step 4 : if positive then result[posIndex] = arr[i] and posIndex += 2
    * Step 5 : if negative then result[negIndex] = arr[i] and negIndex += 2
    * */
    public int[] rearrangeArrayByItsSing(int [] nums){
        int posIndex = 0, negIndex = 1;
        int [] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                result[posIndex] = nums[i];
                posIndex+=2;
            }else{
                result[negIndex] = nums[i];
                negIndex+=2;
            }

        }
        return  result;
    }


    /*
    * Bruteforce SC : O(2n), sc : O(n)
    *
    * 1) Take 2 arrays pos[n/2] and neg[n/2]
    * 2) Iterate i = 0 and if ith element is positive then put in pos else in neg
    * 3) run loop 0--> n/2 and pick element one by one and put it in original array
    *
    * */
    public int [] rearrangeArrayByItsSing1(int [] nums){
        int [] pos = new int[nums.length];
        int [] neg = new int[nums.length];
        int posIndex = 0, negIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                pos[posIndex] = nums[i];
                posIndex++;
            }
            else {
                neg[negIndex] = nums[i];
                negIndex++;
            }
        }
        int len = posIndex < negIndex ? posIndex : negIndex;
        int index = 0;
        for (int i = 0; i < len; i++) {
            nums[index++] = pos[i];
            nums[index++] = neg[i];
        }
        if(negIndex > posIndex)
            System.arraycopy(neg,negIndex,nums,index,negIndex-posIndex);
        else if(negIndex < posIndex)
            System.arraycopy(pos,len,nums,index,posIndex-negIndex);

        return nums;
    }
}
