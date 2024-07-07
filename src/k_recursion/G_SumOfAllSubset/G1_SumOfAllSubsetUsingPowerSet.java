package k_recursion.G_SumOfAllSubset;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Subset Sum : Sum of all Subsets
Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.


https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/
https://youtu.be/rYkfBRtMJr8


Examples:

Example 1:
* s = "abc"
* All substrings : "" a b c ab bc ac abc
* no of possible substring : 2^n :8
* 0  000
* 1  001
* 2  010
* 3  011
* 4  100
* 5  101
* 6  110
* 7  111

*
* */
public class G1_SumOfAllSubsetUsingPowerSet {

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

    }
}
