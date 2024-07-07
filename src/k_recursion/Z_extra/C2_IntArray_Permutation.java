package k_recursion.Z_extra;


import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/permutations/submissions/945603703/
https://youtu.be/f2ic2Rsc9pU?list=PLgUwDviBIf0rQ6cnlaHRMuOp4H_D-7hwP

  Input : [1,2,3]
* [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
* Time Complexity : O(N * N!) --> Multiplied by n because to reach last node of tree, it took n steps.
  Space Complexity :
*
* */
public class C2_IntArray_Permutation {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        C2_IntArray_Permutation test = new C2_IntArray_Permutation();
        int [] nums = {1,2,3};
        System.out.println(test.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0,nums.length-1);
        return result;

    }

    public void helper(int [] nums, int left,int right){
        if(left == right){
            List<Integer> temp =  new ArrayList<>();
            for(int i:nums)
                temp.add(i);

            result.add(temp);
        }else{
            for(int i=left;i<=right;i++){
                swap(nums,left,i);
                helper(nums,left+1,right);
                swap(nums,left,i);
            }
        }


    }

    private void swap(int [] arr,int i1,int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
