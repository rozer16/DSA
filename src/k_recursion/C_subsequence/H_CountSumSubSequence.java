package k_recursion.C_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H_CountSumSubSequence {


    public static void main(String[] args) {
        List<Integer> nos = Arrays.asList(1,4,5,1);
        List<Integer> nos1 = Arrays.asList(1,2,1);
        List<List<Integer>> result = new ArrayList<>();
        CountSumSubSequence(0,nos1,0,2,result,new ArrayList<>());
        System.out.println(result); //3

    }

    public static void CountSumSubSequence(int sum, List<Integer> nos,int index, int target,List<List<Integer>> result,List<Integer> temResult){
        if(index >= nos.size()){
            if(sum == target){
                result.add(new ArrayList<>(temResult));

            }
            return;
        }

        temResult.add(nos.get(index));
        CountSumSubSequence(sum+nos.get(index),nos, index+1,target,result,temResult);
        temResult.remove(temResult.get(temResult.size()-1));
        CountSumSubSequence(sum,nos,index+1,target,result,temResult);


    }
}
