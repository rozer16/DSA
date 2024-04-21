package n_dynamic_programming.B_1D_DP;

import java.util.ArrayList;
import java.util.List;

public class A2_ClimbinbStars_NoOfSteps {




    public static void main(String[] args) {
        A2_ClimbinbStars_NoOfSteps solution = new A2_ClimbinbStars_NoOfSteps();
        System.out.println(solution.countStepsRecursive(3));;
        //System.out.println(solution.countClimbStairs(3));;
    }


    //Top Down approach / Recrusive

    public int countStepsRecursive(int n){
        //From 0 -> 0 no steps
        // from 1 you can only jump 0 so 1
        if(n <= 1){
            return n;
        }
        return countStepsRecursive(n-1)+countStepsRecursive(n-2);
    }

    //Bottom up approach /iterative
    public int countStepsTabulation(int n){
        int [] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }

    public int countStepsSpaceOptimized(int n){
       int prev2 = 1;
       int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int currI = prev2 + prev1;
             prev2 = prev1;
             prev1 = currI;
        }

        return prev1;

    }


    public int ListClimbStairs(int n) {
        List<List<Integer>> steps = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        getClimbingStartsSteps(n,steps,0,curr);
        System.out.println(steps);
        return steps.size();
    }


    public void getClimbingStartsSteps(int n, List<List<Integer>> steps, int stepsTaken,List<Integer> curr){
        if(stepsTaken >= n) {
            steps.add(new ArrayList<>(curr));
            return;
        }

        boolean isOne= false;
        if(stepsTaken+1 <= n){
            isOne = true;
            curr.add(1);
            getClimbingStartsSteps(n,steps,stepsTaken+1,curr);
        }

        if(isOne)
            curr.remove(curr.size()-1);

        boolean isTwo = false;
        if(stepsTaken+2 <= n){
            isTwo = true;
            curr.add(2);
            getClimbingStartsSteps(n,steps,stepsTaken+2,curr);
        }
        if (isTwo)
            curr.remove(curr.size()-1);



    }
}
