package n_dp.D_SubSequences;

public class C2_Partition_2_Subsets_Min_Absolute_Sum_Diff {
    public static void main(String[] args) {
        int nums [] ={3,9,7,3};
        C2_Partition_2_Subsets_Min_Absolute_Sum_Diff solution = new C2_Partition_2_Subsets_Min_Absolute_Sum_Diff();
       System.out.println(solution.minimumDifference(nums));


        int [] num1 = {-36, 36};
        System.out.println(solution.minimumDifference(num1));

    }

    public int minimumDifference(int[] nums) {

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int n = nums.length;
        boolean prev [] = new boolean[totalSum+1];
        prev[0] = true;

        if(nums[0] <= totalSum)
            prev[nums[0]] = true;


        for (int index = 1; index < n; index++) {
            boolean curr [] = new boolean[totalSum+1];
            // Initialize the first column of the current row
            curr[0] = true;
            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = prev[target];

                boolean take = false;

                if(target >= nums[index])
                    take = prev[target-nums[index]];

                curr[target]  = take || notTake;
            }
            prev = curr;
        }

        int min = (int)1e9;
        for (int i = 0; i <=totalSum ; i++) {
            if(prev[i]){
                int s1=i;
                int s2 = totalSum-s1;
                min = Math.min(min, Math.abs(s1-s2));
            }
        }
       return  min;
    }
}
