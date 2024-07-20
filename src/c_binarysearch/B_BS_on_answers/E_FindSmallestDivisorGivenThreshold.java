package c_binarysearch.B_BS_on_answers;


/*
https://takeuforward.org/arrays/find-the-smallest-divisor-given-a-threshold/

https://www.youtube.com/watch?v=UvBKTVaG6U8


https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/submissions/1281948671/


Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
 divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
Example 2:

Input: nums = [44,22,33,11,1], threshold = 5
Output: 44


Constraints:

1 <= nums.length <= 5 * 104
1 <= nums[i] <= 106
nums.length <= threshold <= 106
* */
public class E_FindSmallestDivisorGivenThreshold {

    public static void main(String[] args) {
        int arr [] = {1,2,5,9};
        E_FindSmallestDivisorGivenThreshold sol = new E_FindSmallestDivisorGivenThreshold();
        System.out.println(sol.smallestDivisor(arr,6)); //5
        System.out.println(sol.smallestDivisor(new int[]{44,22,33,11,1},5)); //44
        System.out.println(sol.smallestDivisor(new int[]{21212,10101,12121},1000000));  //1

    }

    /*
    Time Complexity: O(log(max(arr[]))*N), where max(arr[]) = maximum element in the array, N = size of the array.
Reason: We are applying binary search on our answers that are in the range of [1, max(arr[])]. For every possible divisor ‘mid’, we call the sumByD() function. Inside that function, we are traversing the entire array, which results in O(N).
    * */
    public int smallestDivisor(int[] nums, int threshold) {
        int [] minmax = findMinMax(nums);
        int low = 1;  //Staring from 1 in case all no are not divisible by each other so in that case smallest divisor is 1 , e.g : 21212,10101,12121 , threshold : 1000000
        int high = minmax[1];
        int ans = 1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(divisorSum(nums,mid) <= threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return ans;
    }

    public int divisorSum(int [] nums, int devisor){
        int total = 0;

        for(int no : nums)
            total += (Math.ceil((double)no/(double)devisor));


        return total;
    }
    public int [] findMinMax(int [] bloomDay){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : bloomDay){
            if(i > max)
                max = i;

            if(i < min)
                min = i;
        }

        return new int[]{min, max};
    }
}
