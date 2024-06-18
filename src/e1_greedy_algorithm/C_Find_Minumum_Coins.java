package e1_greedy_algorithm;

import e_slidingwindow_two_pointer.hard.C_Minimum_Window_Substring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://takeuforward.org/data-structure/find-minimum-number-of-coins/
https://youtu.be/mVg9CfJvayM?list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma

https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
* */
public class C_Find_Minumum_Coins {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        C_Find_Minumum_Coins sol = new C_Find_Minumum_Coins();
        System.out.println(sol.minCoins1(coins, coins.length, 49));
        System.out.println(sol.minCoins1(new int[]{25, 10, 5}, 3, 30));
        System.out.println(sol.minCoins1(new int[]{9, 6, 5, 1}, 3, 11));

    }

    int minCoins(int coins[], int m, int V) {

        if (V < 0)
            return 0;


        //Arrays.sort(coins);
        int index = coins.length - 1;


        int noOfCoins = 0;


        while (V > 0) {
            while (coins[index] > V)
                index--;
            int newCoins = V / coins[index];
            V = V - (newCoins * coins[index]);
            System.out.println(newCoins + "*" + coins[index]);
            noOfCoins = noOfCoins + newCoins;
            index--;
        }

        return noOfCoins;
    }

    int minCoins1(int coins[], int m, int V) {

        if (V < 0)
            return 0;
        List<Integer> ans = new ArrayList<>();

        //Arrays.sort(coins);
        int n = coins.length;
        for (int i = n - 1; i >= 0; i--) {
            while (V >= coins[i]) {
                V -= coins[i];
                ans.add(coins[i]);
            }
        }
        System.out.println(ans);
        return ans.size();
    }

}