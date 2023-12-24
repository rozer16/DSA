package g_recursion;


import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/combination-sum/description/
* https://youtu.be/OyZFFqQtu98?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9
*https://takeuforward.org/data-structure/combination-sum-1/
*
*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []


Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

*
*
* Intuition : arr : {2,3,6,7} , sum : 7
*   Whenever problem is about combination of element from an array, first thought that comes to mind is pick and not pick
*   so possible subarray is 2,2,3 i.e. 001
*   Another possible subarray is 7 ie 0001
*   So in our function can have arr, index,sum , List
*   For a given index, one option is take index  and not take index and jump to next index
*
*   TC : 2^t*k
*   SC : k(Avg Len)* x(combination) --> Hypothetical
*
* */
public class B2_CombinationSum {

    public static void main(String[] args) {
        int arr [] = {2,3,6,7};
        List<List<Integer>> result = new ArrayList<>();
        findSubArrayWithSumN(arr,0,7,new ArrayList<>(),result);
        System.out.println(result);
    }


    public static void findSubArrayWithSumN(int [] arr,int index, int target, List<Integer> ele, List<List<Integer>> result){
        if(index >= arr.length){
            if(target == 0)
                result.add(new ArrayList<>(ele));
            return;
        }

        //Taking same index again if target is less or equal arr[index] otherwise all possible rest index
        if(target >= arr[index]){
            ele.add(arr[index]);
            //Taking same index again
            findSubArrayWithSumN(arr,index,target-arr[index],ele,result);
            ele.remove(ele.size()-1);
        }
        //Not taking same index again and just moving to next index
        findSubArrayWithSumN(arr,index+1,target,ele,result);
    }
}
