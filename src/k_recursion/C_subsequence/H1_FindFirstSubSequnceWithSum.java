package k_recursion.C_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H1_FindFirstSubSequnceWithSum {


    public static void main(String[] args) {
        List<Integer> nos = Arrays.asList(1,4,5,1);
        List<Integer> nos1 = Arrays.asList(1,2,1);
        List<Integer> result = new ArrayList<>();
        findFirstSubSequenceWithSum(0,nos1,0,2,result);
        System.out.println(result); //3

    }

    public static boolean findFirstSubSequenceWithSum(int sum, List<Integer> nos, int index, int target, List<Integer> temResult) {


        if(index >= nos.size()){
            if (sum == target) {
                return true;
            }
            return false;
        }


        temResult.add(nos.get(index));
        if(findFirstSubSequenceWithSum(sum + nos.get(index), nos, index + 1, target, temResult))
            return true;  // If we found first element , no further recursion.
        temResult.remove(temResult.size() - 1);
        return findFirstSubSequenceWithSum(sum, nos, index + 1, target, temResult);
    }

    }


