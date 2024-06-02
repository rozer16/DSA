package g_recursion.I_FindAllPermutationOfString;


import java.util.ArrayList;
import java.util.List;

/*
* https://takeuforward.org/data-structure/print-all-permutations-of-a-string-array/#google_vignette
* https://leetcode.com/problems/permutations/description/
*
*
*  Problem Statement: Given an array arr of distinct integers, print all permutations of String/Array.

Examples:

Example 1:

Input: arr = [1, 2, 3]

Output:
[
  [1, 2, 3],
  [1, 3, 2],
  [2, 1, 3],
  [2, 3, 1],
  [3, 1, 2],
  [3, 2, 1]
]

Explanation: Given an array, return all the possible permutations.

Example 2:

Input: arr = [0, 1]

Output:
[
  [0, 1],
  [1, 0]
]

Explanation: Given an array, return all the possible permutations.

*
*
*
*
Solution 1: Recursive

Approach: We have given the nums array, so we will declare an ans vector of vector that will store all the permutations also declare a data structure.

Declare a map and initialize it to zero and call the recursive function

Base condition:

When the data structure’s size is equal to n(size of nums array)  then it is a permutation and stores that permutation in our ans, then returns it.

Recursion:

Run a for loop starting from 0 to nums.size() – 1. Check if the frequency of i is unmarked,
if it is unmarked then it means it has not been picked and then we pick. And make sure it is marked as picked.

Call the recursion with the parameters to pick the other elements when we come back from the recursion make sure you throw that element out.
 And unmark that element in the map.
================================================================
* Solution 2 Recursion-Backtracking

[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 2, 1]
[3, 1, 2]
*
Intuition : Swap current element with all right element to get all possible combination


We have given the nums array, so we will declare an ans List of List that will store all the permutations.

Call a recursive function that starts with zero, nums array, and ans List.

Declare a map and initialize it to zero and call the recursive function

Base condition:

Whenever the index reaches the end take the nums array and put it in ans vector and return.

Recursion:

Go from index to n – 1 and swap once the swap has been done call recursion for the next state.
* After coming back from the recursion make sure you re-swap it because, for the next element, the swap will not take place.

Time Complexity: O(N! * N)
N! : After swap recursion tree
N : For loop

Space Complexity: O(1)
* */
public class I3_FindAllPermutationOfStr {

    private void recurPermute(int index, int[] nums, List < List < Integer >> ans) {
        if (index == nums.length) {
            // copy the ds to ans
            List< Integer > ds = new ArrayList< >();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList < > (ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);  //backtracking:  reswapping so in next recursion array wont change
        }
    }
    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        I3_FindAllPermutationOfStr sol = new I3_FindAllPermutationOfStr();
        sol.recurPermute(0,nums,result);
        System.out.println("All Permutations are ");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        StringBuilder s = new StringBuilder();
    }



}
