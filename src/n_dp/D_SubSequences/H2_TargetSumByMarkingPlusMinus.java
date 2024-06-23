package n_dp.D_SubSequences;

public class H2_TargetSumByMarkingPlusMinus {

    public static void main(String[] args) {
        int [] arr = {1,1,1,1,1};
        int target = 3;

        H2_TargetSumByMarkingPlusMinus solution = new H2_TargetSumByMarkingPlusMinus();

        System.out.println(solution.findTargetSumWays(arr,target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++)
            totalSum += nums[i];

        int D2 = totalSum -target;


        //As the array elements are positive integers including zero, we don’t want to find the case when S2 is negative or
        // we can say that totSum is lesser than D, therefore if totSum<D, we simply return 0.

        //S2 can’t be a fraction, as all elements are integers, therefore if totSum - D is odd, we can return 0.
        if(D2 < 0 || (D2%2) != 0)
            return 0;

        return new D2_CountSubsetsWithSumK().countSubsetWithSumKSpaceOptimization2(nums,D2/2);
    }


}
