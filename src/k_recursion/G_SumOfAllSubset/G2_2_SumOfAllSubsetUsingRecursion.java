package k_recursion.G_SumOfAllSubset;


import java.util.*;

/*
* Subset Sum : Sum of all Subsets
Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.


https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/
https://youtu.be/rYkfBRtMJr8


Examples:

Example 1:

Input: N = 3, arr[] = {5,2,1}

Output: 0,1,2,3,5,6,7,8

Explanation: We have to find all the subset’s sum and print them in ascending order.
* in this case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],
* so the sums we get will be  0,1,2,3,5,6,7,8


Input: N=3,arr[]= {3,1,2}

Output: 0,1,2,3,3,4,5,6

Explanation: We have to find all the subset’s sum and print them in ascending order.
 in this case the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],
so the sums we get will be  0,1,2,3,3,4,5,6
*
*
* */
public class G2_2_SumOfAllSubsetUsingRecursion {

    public static void main(String[] args) {
        int [] arr= {3,2,1};
        System.out.println(findSumofAllSubset(arr)); //[0, 1, 2, 3, 3, 4, 5, 6]
    }

    private static List<Integer> findSumofAllSubset(int[] arr) {
        List<Integer> result = new ArrayList<>();
        subOfAllSubset(arr,0,new ArrayList<>(),result);
        Collections.sort(result);
        return result;

    }

    //TC :
    //For every index pick and not pick so TC : 2^n
    // SC : 2^nlon2n for sorting result
    public static void subOfAllSubset(int arr[] , int index, List<Integer> ele, List<Integer> result){
        if(index >= arr.length){
            int sum = ele.stream().reduce(0,Integer::sum);
            result.add(sum);
            return;
        }

        ele.add(arr[index]);
        subOfAllSubset(arr,index+1,ele,result);
        ele.remove(ele.size()-1);
        subOfAllSubset(arr,index+1,ele,result);
    }
}
