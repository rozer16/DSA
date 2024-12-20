package b_array.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
* https://takeuforward.org/data-structure/leaders-in-an-array/
* https://youtu.be/cHrH9CQ8pmY
*
*
* Problem Statement: Given an array, print all the elements which are leaders.
* A Leader is an element that is greater than all of the elements on its right side in the array.
*
* arr = {10,22,12,3,0,6}
* o/p = {22,12,6}
*
* */
public class G_LeadersInArray {

    public static void main(String[] args) {
        G_LeadersInArray test = new G_LeadersInArray();
        int [] nums = {16 ,17 ,4 ,3 ,5, 2};
       // System.out.println(Arrays.toString(test.leadersInArray(nums)));
        System.out.println(test.leaders(nums.length, nums));
    }



     ArrayList<Integer> leaders(int n, int arr[]) {
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        int index = n-1;
        while(index >= 0){
            while(!stack.isEmpty() && stack.peek() <= arr[index])
                stack.pop();

                if(stack.isEmpty())
                    result.add(arr[index]);

                stack.push(arr[index]);
                index--;


        }

        return result;
    }
    /*
    * Optimal
    * SC : O(n)
    *
    * Intuition
    *
    * Step1 : initialize var var max = Integer.MIN_VALUE,
    * Step 2 : Iterate from last element to zero
    * Step 3 : if currEle > max then add currEle is to result and set max = currEle
    * */
    public int [] leadersInArray(int [] nums){
        int [] result = new int[nums.length];
        int ri=0;
        int max = Integer.MIN_VALUE;
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i] > max){
                max= nums[i];
                result[ri++] = nums[i];
            }
        }


        return result;
    }

    /*
    * Bruteforce
    * TC : O(n^2)
    * SC : O(1)
    * */

    public int [] leadersInArray1(int [] num){
        int [] result = new int[num.length];
        int ri=0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if(num[j] > num[i]){
                    break;
                }
                if(j == num.length-1)
                    result[ri++] = num[i];


            }

        }
        result[ri++]= num[num.length-1];
        return result;
    }
}
