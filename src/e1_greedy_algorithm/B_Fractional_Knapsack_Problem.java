package e1_greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

/*
https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/
https://www.youtube.com/watch?v=F_DDzYnxO14&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=50
https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1


Given weights and values of n items, we need to put these items in a knapsack of capacity w to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item here.

Example 1:

Input:
n = 3
w = 50
value[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.000000
Explanation:
Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0
Thus, total maximum value of item we can have is 240.00 from the given capacity of sack.
Example 2:

Input:
n = 2
w = 50
value[] = {60,100}
weight[] = {10,20}
Output:
160.000000
Explanation:
Take both the items completely, without breaking.
Total maximum value of item we can have is 160.00 from the given capacity of sack.
Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity w, an array of structure/class,
and size n and returns a double value representing the maximum value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.

Expected Time Complexity : O(NlogN)
Expected Auxilliary Space: O(1)

Constraints:
1 <= n <= 105
1 <= w <= 109
1 <= valuei, weighti <= 104
* */
public class B_Fractional_Knapsack_Problem {


    public static void main(String[] args) {
        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        B_Fractional_Knapsack_Problem sol = new B_Fractional_Knapsack_Problem();
        System.out.println(sol.fractionalKnapsack(50, arr, arr.length));


        Item arr1[] = {new Item (1,4),new Item(5,9),new Item(7,6),new Item (2,3),new Item(7,7),new Item(10,3)};
        System.out.println(sol.fractionalKnapsack(24, arr1, arr1.length));
    }
    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    Comparator<Item> i1 = (c1,c2) -> {
        double diff = (double) c2.value / (double) c2.weight - (double) c1.value / (double) c1.weight;
        return diff == 0 ? 0 : diff > 0 ? 1: -1;
    };


    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, i1);
        double currWeight = 0;
        double currvalue = 0;

        for (int i = 0; i < n; i++) {
            if(currWeight + arr[i].weight <= w){
               currWeight = currWeight + arr[i].weight;
               currvalue = currvalue + arr[i].value;
            }else{
                double remain = w - currWeight;
                currvalue = currvalue + ((double) arr[i].value/(double) arr[i].weight)*remain;
                break;
            }
        }

        return currvalue;
    }

}
