package o_dp.D_SubSequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/*
* https://www.youtube.com/watch?v=45TkgKy0GS0
* https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/submissions/1250282764/
* Elements in array can be negative
*
* */
public class C3_Partition_2_Subsets_Min_Absolute_Sum_Diff {
    public static void main(String[] args) {
        int nums [] ={3,9,7,3};
        C3_Partition_2_Subsets_Min_Absolute_Sum_Diff solution = new C3_Partition_2_Subsets_Min_Absolute_Sum_Diff();
       // System.out.println(solution.minimumDifference(nums));


        int [] num1 = {-36, 36};
        System.out.println(solution.minimumDifference(num1));

    }

    public int minimumDifference(int[] nums) {

        int n = nums.length;

        //All subset sums of different sizes up to n/2 of first half of the array.
        HashMap<Integer, ArrayList<Integer>> fPartition = new HashMap<Integer, ArrayList<Integer>>();

        //All subset sums of different sizes up to n/2 of second half of the array.
        HashMap<Integer, ArrayList<Integer>> sPartition = new HashMap<Integer, ArrayList<Integer>>();

        //Function calls that fill subset sums in to above hashmaps.
        generateSubSums(nums, 0, n/2, 0, 0, fPartition);
        generateSubSums(nums, n/2, n, 0, 0, sPartition);

        //Store total array sum.
        int total = 0;
        for(int ele: nums) total += ele;

        //Take biggest integer possible as the initial result.
        int result = Integer.MAX_VALUE;

        //Iterate over all sizes from 0 to n/2 inclusive.
        for(int i=0; i<=n/2; i++){

            //Subset sums of first partittion of size i
            ArrayList<Integer> fSums = fPartition.get(i);

            //Subset sums of second partittion of size n/2 - i (remaining part)
            ArrayList<Integer> sSums = sPartition.get(n/2-i);

            //Sort the second partition's subset sums to apply binary search on it.
            Collections.sort(sSums);

            //Number of subset sums of size i,
            int size = sSums.size();

            //Find the suitable subset sum of the second partition for every subset sub of first partition using binary search.
            for(int fSum : fSums){
                int low = 0;
                int high = size - 1;
                while(low <= high){
                    int mid = low + (high - low)/2;

                    //Sum of the partiton of size i and n/2-i together should constitute to total/2 (total - 2 * (x+y) -> min).
                    int target = 2 * (fSum + sSums.get(mid));

                    //If they are equal then return 0 because lowest absolute difference cannot be less than 0.
                    if(total == target) return 0;
                    else if(total > target) low = mid+1;
                    else high = mid-1;
                }

                //Now check the element at low and high and compare which one is giving lowest absolute difference and update result.
                if(low < size){
                    result = Math.min(result, Math.abs(total - 2 * (fSum + sSums.get(low))));
                }
                if(high >= 0){
                    result = Math.min(result, Math.abs(total - 2 * (fSum + sSums.get(high))));
                }
            }
        }
        return result;
    }

    //Method that recursively uses pick and non-pick method to find the subset sums of all sizes
    private static void generateSubSums(int[] nums, int start, int end, int sum, int size,
                                        HashMap<Integer, ArrayList<Integer>> partition){

        //If start reached end that means we have no more subset sums to explore and add current subset sum of size to hashmap.
        if(start >= end){
            partition.computeIfAbsent(size, key -> new ArrayList<Integer>()).add(sum);
            return;
        }

        //Picking element at the current index start. Add element to the sum and increase the size as we are picking.
        generateSubSums(nums, start+1, end, sum+nums[start], size+1, partition);

        //Not picking element at the current index start.
        generateSubSums(nums, start+1, end, sum, size, partition);
    }
}
