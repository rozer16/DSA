package g_recursion;

/*
Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.

Examples:

Example 1:

Input: N = 3, arr[] = {5,2,1}

Output: 0,1,2,3,5,6,7,8

Explanation: We have to find all the subset’s sum and print them.
in this case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],
so the sums we get will be  0,1,2,3,5,6,7,8


Input: N=3,arr[]= {3,1,2}

Output: 0,1,2,3,3,4,5,6

Explanation: We have to find all the subset’s sum and print them.
In this case the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],
so the sums we get will be  0,1,2,3,3,4,5,6
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K_Sum_Of_All_Subset {

    public void sumOfAllSubset(int [] arr,int index,int sum, List<Integer> result){
        if(index>= arr.length) {
            result.add(sum);
            return;
        }


        sumOfAllSubset(arr,index+1,sum+arr[index],result);
        sumOfAllSubset(arr,index+1,sum,result);
    }

    public static void main(String[] args) {
        int [] arr = {3,2,1};
        List<Integer> result = new ArrayList<>();
        K_Sum_Of_All_Subset test= new K_Sum_Of_All_Subset();
        test.sumOfAllSubset(arr,0,0,result);
        Collections.sort(result);
        System.out.println(result);
    }


}
