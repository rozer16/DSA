package k_recursion.H_FIndUniqueSubset;


import java.util.*;

/*
* https://takeuforward.org/data-structure/subset-ii-print-all-the-unique-subsets/
* https://leetcode.com/problems/subsets-ii/description/
*
*
*
* Given an integer array nums that may contain duplicates, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*
*
*
* Bruteforce
*
* 1) Using take and not take technique find all subset with complexity of 2^n
* 2) Once we have all subset, put them in set and remove duplicate and again put it into list with complexity : 2^n log 2^n
*
*
* Optimized
*
* 1) Sort element
* 2) Find subset (with check if same element has been taken, dont take again
* */
public class H3_FindAllUniqueSubset {


    public static void main(String[] args) {
        int arr [] = {1,2,1,2,1};
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        findAllUniqueSubset(arr,0,new ArrayList<>(),result);
        System.out.println(result);
       //[[], [1], [1, 1], [1, 1, 1], [1, 1, 1, 2], [1, 1, 1, 2, 2], [1, 1, 2], [1, 1, 2, 2], [1, 2], [1, 2, 2], [2], [2, 2]]
    }
    //
    public static void findAllUniqueSubset(int [] arr, int index, List<Integer> ele,List<List<Integer>> result){
            result.add(new ArrayList<>(ele));
        for(int i = index;i<arr.length;i++){
            //For avoiding duplicate, making sure next index element is not same
            if(i>index && arr[i] == arr[i-1])
                continue;

            ele.add(arr[i]);
            findAllUniqueSubset(arr,i+1,ele,result);
            ele.remove(ele.size()-1);
        }
    }
}
