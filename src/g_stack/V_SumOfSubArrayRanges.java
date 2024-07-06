package g_stack;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.BiFunction;

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
        System.out.println(test.subArrayRangesBF(arr));
    }




    //TODO : Revisit again this logic, why in one loop we are able to achieve

    public long subArrayRanges(int[] nums) {
        Deque<Integer> dec_stack = new ArrayDeque<>();
        Deque<Integer> inc_stack = new ArrayDeque<>();
        long sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += pushToStack(dec_stack,nums,i, (a,b) -> a < b) //Element at i is max in no of subarray  * element
                    - pushToStack(inc_stack, nums, i, (a,b)-> a > b); //Element at i is min in no of subarray  * element
        }
        return sum;

    }


    private long pushToStack(Deque<Integer> stack, int nums[], int index, BiFunction<Integer,Integer,Boolean> biFunction){
        long sum = 0;

        while(!stack.isEmpty() && (index == nums.length || biFunction.apply(nums[stack.peek()], nums[index]))) {

            int pop_i = stack.pop();
            int prev_i = stack.isEmpty() ? -1 : stack.peek();
            sum += (pop_i - prev_i) * (index - pop_i) * (long)nums[pop_i];
        }
        stack.push(index);

        return sum;
    }


    /*TC : 2 * ( O(n) for left array tranversal + O(n) for stack traversal
                + O(n) for right array tranversal + O(n) for stack traversal
                + O(n) for calculation of total
                )


    SC : O(2n)
    */


    public long subArrayRangesBetter(int[] nums) {
        int n = nums.length;
        int left [] = new int[n];
        int right [] = new int[n];


        Deque<Integer> stack = new ArrayDeque<>();

        //Calculate min
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();

            if(stack.isEmpty()){
                left[i] = i+1;
            }else{
                left[i] = i-stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = n-1; i >= 0; i--){

            while(!stack.isEmpty() && nums[stack.peek()] > nums[i])
                stack.pop();

            if(stack.isEmpty()){
                right[i] = n-i;
            }else{
                right[i] = stack.peek()-i;
            }
            stack.push(i);
        }

        System.out.println("LeftMin : "+ Arrays.toString(left));
        System.out.println("RightMin : "+Arrays.toString(right));
        long minSum = getTotal(nums,left, right);
        stack.clear();

        //Calculate max
        left  = new int[n];
        right  = new int[n];

        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i])
                stack.pop();

            if(stack.isEmpty()){
                left[i] = i+1;
            }else{
                left[i] = i-stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = n-1; i >= 0; i--){

            while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
                stack.pop();

            if(stack.isEmpty()){
                right[i] = n-i;
            }else{
                right[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        System.out.println("LeftMax : "+Arrays.toString(left));
        System.out.println("RightMax : "+Arrays.toString(right));
        long maxSum = getTotal(nums,left, right);
        return maxSum-minSum;
    }

    public long getTotal(int arr[], int left[], int right[]){
        long total = 0;
        for(int i = 0; i< arr.length;i++)
            total = total + ((long)arr[i]*(long)left[i]*(long)right[i]);

        return total;
    }


    /*

    TC : Complexity : O(n^2)
    SC : O(1)

    */
    public long subArrayRangesBF(int[] nums) {
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
