package e1_greedy_algorithm;

import java.util.Arrays;

/*
https://www.youtube.com/watch?v=DIX2p7vb9co&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea
https://leetcode.com/problems/assign-cookies/description/
* */
public class A_Assign_Cookies {
    public static void main(String[] args) {
        A_Assign_Cookies sol = new A_Assign_Cookies();
        System.out.println(sol.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }

    public int findContentChildren(int[] g, int[] s) {
        int greedSize = g.length;
        int size = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int gInd = 0;
        int sInd = 0;

        while(sInd < size){

            if(g[gInd] <= s[sInd]){
                gInd++;
            }
            sInd++;
        }
       return gInd;

    }
}
