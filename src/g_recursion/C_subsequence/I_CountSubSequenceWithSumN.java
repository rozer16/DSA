package g_recursion.C_subsequence;

import java.util.Arrays;
import java.util.List;

public class I_CountSubSequenceWithSumN {
    public static void main(String[] args) {
        List<Integer> nos = Arrays.asList(1,4,5,1);
        List<Integer> nos1 = Arrays.asList(1,2,1);
        System.out.println(countSubSequenceWithSumN(nos1,0,2,0)); //3

    }

    //Complexity : for all n elements 2 options take and not take
    // For e.g. 3 elements 2 2 2 = 8 = 2^3 = 2^n
    public static  int countSubSequenceWithSumN(List<Integer> nos,int sum,int targetSum,int index) {
        //For all cases we will have to go until base case, no intemediate cut shut

        //This condition can work if elements are positive, no negative.
        if(sum > targetSum)
            return 0;
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

        //Will return current node non lean then branching sum,else if leaf then 1
        return take + nottake;
    }
}
