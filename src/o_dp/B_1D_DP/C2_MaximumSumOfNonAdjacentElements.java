package o_dp.B_1D_DP;

import java.util.Arrays;

public class C2_MaximumSumOfNonAdjacentElements {

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        C2_MaximumSumOfNonAdjacentElements solution = new C2_MaximumSumOfNonAdjacentElements();

        System.out.println("MaximumSumOfNonAdjacentElements using recursion : " + solution.maximumSumOfNonAdjacentElementsRecursion(arr));
        System.out.println("MaximumSumOfNonAdjacentElements using memoization : " + solution.maximumSumOfNonAdjacentElementsMemoization(arr));
        System.out.println("MaximumSumOfNonAdjacentElements using tabulation : " + solution.maximumSumOfNonAdjacentElementsTabulation(arr));
        System.out.println("MaximumSumOfNonAdjacentElements using space optimization : " + solution.maximumSumOfNonAdjacentElementsSpaceOptimization(arr));

    }


    public int maximumSumOfNonAdjacentElementsRecursion(int[] arr) {
        return maximumSumOfNonAdjacentElementsRecursion(arr, arr.length - 1);
    }

    public int maximumSumOfNonAdjacentElementsMemoization(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maximumSumOfNonAdjacentElementsMemoization(arr, arr.length - 1, dp);
    }

    public int maximumSumOfNonAdjacentElementsRecursion(int[] arr, int index) {
        if (index == 0)
            return arr[0];

        if (index < 0)
            return 0;

        int pick = arr[index] + maximumSumOfNonAdjacentElementsRecursion(arr, index - 2);

        int notPick = maximumSumOfNonAdjacentElementsRecursion(arr, index - 1);


        return Math.max(pick, notPick);
    }


    // This function recursively calculates the maximum possible sum
    // by considering or not considering the current element.

    //Time Complexity: O(N)
        //Reason: The overlapping subproblems will return the answer in constant time O(1).
                // Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).

    //Space Complexity: O(N)
            //Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
            // Therefore total space complexity will be O(N) + O(N) ≈ O(N)
    public int maximumSumOfNonAdjacentElementsMemoization(int[] arr, int index, int[] dp) {

       // If the index is 0, there is only one element to consider, so return its value.

        if (index == 0)
            return arr[0];

        // If the index is negative, there are no elements left to consider.
        if (index < 0)
            return 0;

        // If we have already calculated the result for this index, return it.

        if (dp[index] != -1)
            return dp[index];

        // Calculate the maximum sum by either picking the current element or not picking it.
        int pick = arr[index] + maximumSumOfNonAdjacentElementsRecursion(arr, index - 2);


        int notPick = maximumSumOfNonAdjacentElementsRecursion(arr, index - 1);

        // Store the maximum of the two options in the dp array for future reference.
        dp[index] = Math.max(pick, notPick);
        return Math.max(pick, notPick);
    }


    //Time Complexity: O(N)
        //Reason: We are running a simple iterative loop

    //Space Complexity: O(N)
        //Reason: We are using an external array of size ‘n+1’.
    public int maximumSumOfNonAdjacentElementsTabulation(int[] arr) {
        int[] dp = new int[arr.length];

        // Initialize the dp array with the first element of the input array.
        dp[0] = arr[0];

        // Iterate through the input array to fill the dp array.
        for (int i = 1; i < arr.length; i++) {

            // Calculate the maximum sum by either picking the current element or not picking it.
            int take = arr[i];
            // If there are at least two elements before the current element, add the value from dp[i-2].
            if (i > 1)
                take = take + dp[i - 2];

            // The non-pick option is to use the maximum sum from the previous element.
            int notTake = dp[i - 1];

            // Store the maximum of the two options in the dp array for the current index.
            dp[i] = Math.max(take, notTake);
        }

        // The final element of the dp array contains the maximum possible sum.
        return dp[arr.length - 1];
    }


    public int maximumSumOfNonAdjacentElementsSpaceOptimization(int[] arr) {

        //If we closely look at the values required at every iteration : dp[i], dp[i-1], and  dp[i-2]
        //so dp[i-1] = prev
        // dp[i-2] = prev2
        // Initialize variables to keep track of the maximum sums at the current and previous positions

        int prev = arr[0];
        int prev2 = 0;

        // Iterate through the array starting from the second element.

        for (int i = 1; i < arr.length; i++) {
            // Calculate the maximum sum by either picking the current element or not picking it.
            int take = arr[i];
            // If there are at least two elements before the current element, add the value from prev2.
            if(i > 1)
                 take = take+prev2;

            // The non-pick option is to use the maximum sum from the previous position.
            int notTake = prev;

            // Calculate the maximum sum for the current position and update prev and prev2.
            int currI = Math.max(take, notTake);
            prev2 = prev;
            prev = currI;
        }

        // The 'prev' variable now holds the maximum possible sum.
        return prev;
    }
}