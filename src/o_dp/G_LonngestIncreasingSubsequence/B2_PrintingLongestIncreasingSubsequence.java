package o_dp.G_LonngestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B2_PrintingLongestIncreasingSubsequence {


    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        B2_PrintingLongestIncreasingSubsequence solution = new B2_PrintingLongestIncreasingSubsequence();
        System.out.println(solution.lengthOfLISIntuitive(nums)); //[2, 5, 7, 101]
    }

    /*
    Time Complexity: O(N*N)

    Reason: There are two nested loops.

    Space Complexity: O(N)
    * */
    public List<Integer> lengthOfLISIntuitive(int[] arr) {

        //dp[i] = longest subseq for element  arr[i] from 0 to i
        int dp [] = new int[arr.length];

        // parent[i] = for finding longest subseq who is parent of dp[i]
        int parent [] = new int[arr.length];

        //Since longest increasing subseq can be min 1 i.e. element itself
        Arrays.fill(dp,1);

        for (int i = 0; i < parent.length; i++) {
            //Initializing with element is itself its parent
            parent[i] = i;
        }



        //Variable to store max count of increasing subseq
        int maxIncreasingSubSeqCount = 1;

        //Variable to store index of last element of longest increasing subseq
        int maxIncreasingSubSeqIndex = 0;

        //Starting from 1 since for index 0, longest increasing subseq could be 1
        for(int i =1; i< arr.length;i++){
            //From index 0 to i, check which index makes longest increasing subseq
            for (int j = 0; j < i; j++) {

                //If element j is less than element i and and jth longest subseq +1 is greater than ith longest subseq than update
                if(arr[j]  < arr[i] && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    if(dp[i] > maxIncreasingSubSeqCount) {
                        maxIncreasingSubSeqCount = Math.max(dp[i], maxIncreasingSubSeqCount);
                        maxIncreasingSubSeqIndex = i;
                    }
                }

            }
        }

        int index = maxIncreasingSubSeqIndex;
        List<Integer> ans = new ArrayList<>(maxIncreasingSubSeqCount);
        ans.add(index);
        while(parent[index] != index){

            index = parent[index];
            ans.add(arr[index]);
        }

        Collections.reverse(ans);
        return ans;

    }
}
