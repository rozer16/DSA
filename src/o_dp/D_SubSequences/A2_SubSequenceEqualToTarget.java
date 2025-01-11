package o_dp.D_SubSequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A2_SubSequenceEqualToTarget {

    public static void main(String[] args) {
        int [] arr =  {1,2,3,4};
        int k = 12;


        int dp [][] = new int[arr.length][k+1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        A2_SubSequenceEqualToTarget solution = new A2_SubSequenceEqualToTarget();
        System.out.println("Any subseq having sum k using recursion "+solution.subSequenceHavingTarget(arr,k, arr.length-1));
        System.out.println("Any subseq having sum k using memoization "+solution.subSequenceHavingTargetMemoization(arr,k, arr.length-1,dp));
        System.out.println("Any subseq having sum k using tabulation "+solution.subSequenceHavingTargetTabulation(arr,k));
        System.out.println("Any subseq having sum k using  space optimization "+solution.subSequenceHavingTargetTabulation(arr,k));


        /*


        Any subseq having sum k using recursion false
        Any subseq having sum k using memoization false
        Any subseq having sum k using tabulation false
        Any subseq having sum k using  space optimization false


        * */
    }


    public boolean subSequenceHavingTarget(int [] arr, int target, int index){
        if(target == 0)
            return true;

        if(index == 0)
            return arr[0] == target;

        boolean notTake = subSequenceHavingTarget(arr, target, index-1);
        boolean take = false;

        if(target > arr[index]){
            take = subSequenceHavingTarget(arr, target-arr[index], index-1);
        }

        return take || notTake;

    }

    public boolean subSequenceHavingTargetMemoization(int [] arr, int target, int index, int [][] dp){
        if(target == 0)
            return true;

        if(index == 0)
            return arr[0] == target;

        if(dp[index][target] != -1)
            return dp[index][target] == 1;

        boolean notTake = subSequenceHavingTargetMemoization(arr, target, index-1,dp);
        boolean take = false;

        if(target > arr[index]){
            take = subSequenceHavingTargetMemoization(arr, target-arr[index], index-1,dp);
        }

        dp[index][target] = take || notTake ? 1 : 0;

        return take || notTake;

    }


    public boolean subSequenceHavingTargetTabulation(int [] arr, int k){

        int n = arr.length;
        boolean dp[][] = new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if(arr[0] <= k)
            dp[0][arr[0]] = true;


        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[index-1][target];

                boolean take = false;

                if(target >= arr[index])
                    take = dp[index-1][target-arr[index]];

                dp[index][target]  = take || notTake;
            }
        }
        return dp[n -1][k];
    }

    public boolean subSequenceHavingTargetSpaceOptimization(int [] arr, int k){

        int n = arr.length;
        boolean prev [] = new boolean[k+1];
        prev[0] = true;

        if(arr[0] <= k)
            prev[arr[0]] = true;


        for (int index = 1; index < n; index++) {
            boolean curr [] = new boolean[k+1];
            // Initialize the first column of the current row
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];

                boolean take = false;

                if(target >= arr[index])
                    take = prev[target-arr[index]];

                curr[target]  = take || notTake;
            }
            prev = curr;
        }
        return prev[k];
    }

    //All above implementations are for only checking if there is any subsequence having sum k with positive integers.
    //For negative no, please follow below implementation

    static Boolean isSubsetSumWithNegatives(int arr[], int target) {
        int n = arr.length;

        // Calculate the range of possible sums
        int minSum = 0, maxSum = 0;
        for (int num : arr) {
            if (num > 0) maxSum += num;
            else minSum += num;
        }

        // If target is outside the range of possible sums, return false
        if (target < minSum || target > maxSum) return false;

        // Use a map to store DP states
        Map<String, Boolean> dp = new HashMap<>();

        return isSubsetSumRecursion(arr, target, n - 1, dp);
    }

    static Boolean isSubsetSumRecursion(int arr[], int target, int i, Map<String, Boolean> dp) {
        // Construct the key for the current state
        String key = i + ":" + target;

        // Base case: when target is zero
        if (target == 0) return true;

        // Base case: when only one element is considered
        if (i == 0) return arr[0] == target;

        // Check if result is already computed
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // Recursive cases: not take or take the current element
        boolean notTake = isSubsetSumRecursion(arr, target, i - 1, dp);
        boolean take = false;
        if (arr[i] <= target) {
            take = isSubsetSumRecursion(arr, target - arr[i], i - 1, dp);
        }

        // Store the result in the Map
        dp.put(key, notTake || take);
        return notTake || take;
    }


    //Below implementation is with shifting of index


    static Boolean isSubsetSumWithNegativesWithShiftingIndex(int arr[], int target) {
        int n = arr.length;

        // Calculate the range of possible sums
        int minSum = 0, maxSum = 0;
        for (int num : arr) {
            if (num > 0) maxSum += num;
            else minSum += num;
        }

        // If target is outside the range of possible sums, return false
        if (target < minSum || target > maxSum) return false;

        // Offset to convert negative indices to non-negative
        int offset = -minSum;
        int[][] dp = new int[n][maxSum - minSum + 1];

        // Initialize DP array
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return isSubsetSumRecursion(arr, target, n - 1, dp, offset);
    }

    static Boolean isSubsetSumRecursion(int arr[], int target, int i, int[][] dp, int offset) {
        // Adjust target with offset to map it to non-negative indices
        int adjustedTarget = target + offset;

        // Base case: when target is zero
        if (target == 0) return true;

        // Base case: when only one element is considered
        if (i == 0) return arr[0] == target;

        // Check if result is already computed
        if (dp[i][adjustedTarget] != -1) {
            return dp[i][adjustedTarget] == 1;
        }

        // Recursive cases: not take or take the current element
        boolean notTake = isSubsetSumRecursion(arr, target, i - 1, dp, offset);
        boolean take = false;
        if (arr[i] <= target) {
            take = isSubsetSumRecursion(arr, target - arr[i], i - 1, dp, offset);
        }

        // Store the result in DP table
        dp[i][adjustedTarget] = (notTake || take) ? 1 : 0;
        return notTake || take;
    }
}
