package e_slidingwindow_two_pointer.medium;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://www.youtube.com/watch?v=e3bs0uA1NhQ
https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1


You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits of size N, where fruits[i]  is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow :

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of the baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.


Example 1:

Input:
N = 3
fruits [ ] = { 2, 1, 2 }
Output: 3
Explanation: We can pick from all three trees.


Problem can be understood as max subarray len with atmost N diff  elements
* */
public class D_Fruit_Into_Basket {

    public static void main(String[] args) {
        D_Fruit_Into_Basket sol = new D_Fruit_Into_Basket();
        System.out.println(sol.totalFruits(41,new int []{17,20,14,22,21,39,2,25,28,6,19,34,17,39,40,2,11,30,24,1,8,7,30,5,0,37,20,38,10,35,37,11,17,24,27,1,18,20,13,3,31}));
    }

    public static int totalFruits(int m, int[] fruits) {
        int n = fruits.length;
        int l = 0;
        int r = 0;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();


        while(r < n){


            if(map.containsKey(fruits[r])){
                map.put(fruits[r], map.get(fruits[r])+1);
            }else{
                map.put(fruits[r],1);
            }


            if(map.size() > 2){
                while(map.size() > 2) {
                    int curr = map.get(fruits[l]);
                    if (curr == 1)
                        map.remove(fruits[l]);
                    else
                        map.put(fruits[l], curr - 1);

                    l++;
                }
            }

            if(map.size() <= 2)
                max = Math.max(r-l+1, max);

            r++;

        }

        return max;


    }
    //TC : O(n^2)
    public static int totalFruitsBF(int N, int[] fruits) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int n = fruits.length;

        for(int i=0; i < n; i++){
            set = new HashSet();
            for(int j = 0; j<n; j++){
                set.add(fruits[j]);

                if(set.size() > 2)
                    break;

                max = Math.max(max, j-i+1);
            }
        }
        return max;

    }

}
