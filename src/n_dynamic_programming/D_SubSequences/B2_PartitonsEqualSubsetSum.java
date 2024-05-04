package n_dynamic_programming.D_SubSequences;

import n_dynamic_programming.C_2D_DP.B2_GetUniquePathOnGrid;

public class B2_PartitonsEqualSubsetSum {

    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 3, 4, 5};
        int n = arr.length;


        B2_PartitonsEqualSubsetSum sol = new B2_PartitonsEqualSubsetSum();
        System.out.println("Is 2 paritions posible for array : "+sol.canPartition(arr));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i< nums.length; i++){
            sum+= nums[i];
        }

        if(sum %2 != 0)
            return false;

        int target = sum/2;

        return subSequenceHavingTargetSpaceOptimization(nums, target);
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
}
