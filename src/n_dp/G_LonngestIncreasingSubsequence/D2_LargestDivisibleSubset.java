package n_dp.G_LonngestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D2_LargestDivisibleSubset {


    public static void main(String[] args) {
        int [] nums = {1,2,3};
        D2_LargestDivisibleSubset solution = new D2_LargestDivisibleSubset();
        System.out.println(solution.largestDivisibleSubset(nums));

    }



    /*
    Time Complexity: O(N*N)

    Reason: There are two nested loops.

    Space Complexity: O(N)

    Reason: We are only using two rows of size n.


    First of all sort the array,
    Then find the longest divisible subsequence of the array.
    In order to find the longest divisible subsequence,
     we will follow the algorithm used to find the longest increasing subsequence discussed in the link to dp-42

    The distinguishing factor between longest increasing subsequence and longest divisible subsequence is that
     we used to insert the element if arr[i] > arr[prev] but here we will insert the element when arr[i] % arr[prev] == 0.
    At last return the hash array as the answer.

    * */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        //sort the array,
        Arrays.sort(nums);


        int [] dp = new int[n];
        Arrays.fill(dp, 1);

        int [] parent = new int[n];
        for(int i = 0; i<n; i++)
            parent[i] = i;


        int maxCount = 0;
        int maxCountIndex = 0;
        for(int i = 1; i< nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    parent[i] = j;
                    if(maxCount < dp[i]){
                        maxCount = dp[i];
                        maxCountIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>(maxCount);
        result.add(nums[maxCountIndex]);
        int index = maxCountIndex;
        while(parent[index] != index){
            index = parent[index];
            result.add(nums[index]);
        }
        Collections.reverse(result);
        return result;
    }
}
