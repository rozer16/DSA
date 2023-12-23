package g_recursion;


import java.util.*;

/*
* https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/
* https://youtu.be/G1fRTGRxXU8?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9
* https://leetcode.com/problems/combination-sum-ii/description/
*
*
*
*
* Given a collection of candidate numbers (candidates) and a target number (target),
*  find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

*
*
*
* Combination must be in sorted order and they are unique
*
* For e.g. arr : {1,2,1,2,1} target = 4 then
*
* Possible answers : {1,1,2} & {2,2}
* wrong answer : {1,2,1} because its not sorted
*
*
*
* */
public class C2_CombinationSum1 {


    public static void main(String[] args) {
        int arr [] = {1,2,1,2,1};
        Arrays.sort(arr);
        Set<List<Integer>> result = new HashSet<>();
        findSubArrayWithSumN(arr,0,4,new ArrayList<>(),result);
        System.out.println(result);
    }

    /*
    * Approach 1 :
    *
    * 1) Sort the Array
    * 2) Since we are not allowed to take same element again, in next recursion call we will have to move to next index if arr[index] <= target
    * 3) If target is zero and index >= arr.length then add sorted collection in set
    *
    * Complexity : 2^(t*k*sorting complexity)
    * */

    public static void findSubArrayWithSumN(int [] arr, int index, int target, List<Integer> ele, Set<List<Integer>> result){
        if(index >= arr.length){
            if(target == 0) {
                List<Integer> aa = new ArrayList<>(ele);
                Collections.sort(aa);
                result.add(aa);
            }
            return;
        }

        //Taking  index
        if(target >= arr[index]){
            ele.add(arr[index]);
            //Taking same index again
            findSubArrayWithSumN(arr,index+1,target-arr[index],ele,result);
            ele.remove(ele.size()-1);
        }
        //Not taking  index  and just moving to next index
        findSubArrayWithSumN(arr,index+1,target,ele,result);
    }


    /*
    * Approach 2:
    *
    * Instead of using pick and not pick, we are going to try to pick subsequence
    *
    * */
    public static void findSubArrayWithSumN1(int [] arr, int index, int target, List<Integer> ele, Set<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(ele));
            return;
        }
        for (int i = index; i < arr.length ; i++) {

            //if for a given position same ele is already taken then no need to take it again since we want sorted set
            if(i > index && arr[i] == arr[i-1])
                continue;


            //Since array is sorted and current ind element is greater than target then no meaning in going to next index.
            if(arr[i] > target)
                break;

            ele.add(arr[i]);
            findSubArrayWithSumN(arr,i+1,target-arr[i],ele,result);
            //Removing element for next iteration back tracking
            ele.remove(ele.size()-1);

        }
    }

}
