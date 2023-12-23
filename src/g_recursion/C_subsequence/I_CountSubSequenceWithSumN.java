package g_recursion.C_subsequence;

import java.util.Arrays;
import java.util.List;

public class I_CountSubSequenceWithSumN {
    public static void main(String[] args) {
        List<Integer> nos = Arrays.asList(1,4,5,1);
        System.out.println(countSubSequenceWithSumN(nos,0,6,0)); //3

    }

    public static  int countSubSequenceWithSumN(List<Integer> nos,int sum,int targetSum,int index) {
        if (index >= nos.size()) {
            if (sum == targetSum) {
                //If sum is equal to targetSum then return 1
                return 1;
            } else {
                //Sum is not equal to targetSum so this cannot be added to count;
                return 0;
            }
        }

        //Take
        int take = countSubSequenceWithSumN(nos, sum + nos.get(index), targetSum, index + 1);
        int nottake = countSubSequenceWithSumN(nos, sum, targetSum, index + 1);

        return take + nottake;
    }
}
