package n_dynamic_programming.B_1D_DP;

public class C3_MaximumSumOfNonAdjucentInCircle {

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        C3_MaximumSumOfNonAdjucentInCircle sol = new C3_MaximumSumOfNonAdjucentInCircle();
        sol.rob(arr);
    }
    public int rob(int[] nums) {
        int [] temp1 = new int[nums.length-1];
        int [] temp2 = new int[nums.length-1];


        System.arraycopy(nums,0, temp1, 0, nums.length-1);
        System.arraycopy(nums, 1, temp2,0, nums.length-1);

        C2_MaximumSumOfNonAdjacentElements sol = new C2_MaximumSumOfNonAdjacentElements();
        return Math.max(
                sol.maximumSumOfNonAdjacentElementsSpaceOptimization(temp1),
                sol.maximumSumOfNonAdjacentElementsSpaceOptimization(temp2)
                );
    }
}
