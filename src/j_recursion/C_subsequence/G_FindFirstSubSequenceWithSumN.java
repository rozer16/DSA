package j_recursion.C_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G_FindFirstSubSequenceWithSumN {

    public static void main(String[] args) {
        List<Integer> nos = Arrays.asList(1,4,5,1);
        List<List<Integer>> result = new ArrayList<>();
        subFirstSequenceWithSumN(nos,0,0,6,new ArrayList<>(),result);
        System.out.println(result);;
    }
    public static boolean subFirstSequenceWithSumN(List<Integer> nos, int index, int sum, int targetSum,
                                                   List<Integer> n, List<List<Integer>> result ){

        if(index >= nos.size()){
            if(sum == targetSum){
                //Do not add n directly to result since its reference and it will be changed for not take
                result.add(new ArrayList<>(n));
                return true;
            }
            return false;

        }

        n.add(nos.get(index));

        //Take

        if(nos.get(index)+sum <= targetSum) {
            if(subFirstSequenceWithSumN(nos, index + 1, sum + nos.get(index), targetSum, n, result))
                //If we found first subsequence then return from this point and dont proceed further for without take
                return true;
        }

        n.remove(n.size() - 1);
        //Not take
        return subFirstSequenceWithSumN(nos, index + 1, sum, targetSum, n, result);
    }
}
