package n_dp.G_LonngestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class E2_LongestStringChain {


    public static void main(String[] args) {
        String [] words  = {"a","b","ba","bca","bda","bdca"};
        E2_LongestStringChain solution = new E2_LongestStringChain();
        System.out.println(solution.longestStrChain(words));

        String [] words1 =   {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(solution.longestStrChain(words1));
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);

        int parent [] = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }


        int maxi=1;
        int maxIndex = 0;
        Comparator<String> comp = Comparator.comparingInt(String::length);
        Arrays.sort(words,comp);
        //System.out.println(Arrays.toString(words));
        for(int i = 1; i< n; i++){
            for(int j=0; j<i; j++){
                if(compare1(words[i], words[j]) && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    if(maxi < dp[i]){
                        maxi = dp[i];
                        maxIndex = i;
                    }

                    parent[i] = j;
                }
            }
        }

        List<String> result = new ArrayList<>();
        result.add(words[maxIndex]);
        while(parent[maxIndex] != maxIndex){
            maxIndex = parent[maxIndex];
            result.add(words[maxIndex]);
        }
        System.out.println(result);
        //System.out.println(Arrays.toString(dp));
        return maxi;
    }


    boolean compare1(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;
        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else  {

                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }
}
