package g_recursion.Z_extra;


import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/permutations/submissions/945603703/

  Input : [1,2,3]
* [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
* TC : O(N * N!) --> Multiplied by n because to reach last node of tree, it took n steps.
SP : O(N)
*
* */
public class C1_IntArray_Permutation_High_Complexity {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        C1_IntArray_Permutation_High_Complexity test = new C1_IntArray_Permutation_High_Complexity();
        int [] nums = {1,2,3};
        System.out.println(test.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean [] freq = new boolean[nums.length];
        helper(nums,list,result,freq);
        return result;

    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result, boolean[] freq) {
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!freq[i]){
                list.add(nums[i]);
                freq[i] = true;
                helper(nums,list,result,freq);
                freq[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

}
