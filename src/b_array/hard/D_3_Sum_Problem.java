package b_array.hard;


import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://youtu.be/eD95WRfh81c
https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
https://leetcode.com/problems/3sum/description/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.

The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.





* */
public class D_3_Sum_Problem {


    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
    }

      /*
      In this approach, we intend to get rid of two things i.e. the HashSet we were using for the look-up operation
      and the set data structure used to store the unique triplets.

      So, We will first sort the array. Then, we will fix a pointer i, and the rest 2 pointers j and k will be moving.

     Time Complexity: O(NlogN)+O(N2), where N = size of the array.
     Reason: The pointer i, is running for approximately N times.
     And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates.
     So the total time complexity will be O(N^2).

     Space Complexity: O(no. of quadruplets), This space is only used to store the answer.
     We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).


      * */
      public static List<List<Integer>> triplet(int n, int[] arr) {
          List<List<Integer>> ans = new ArrayList<>();
          Arrays.sort(arr);

          for (int i = 0; i < n; i++) {
              //remove duplicates:
              if (i != 0 && arr[i] == arr[i - 1]) continue;

              //moving 2 pointers:
              int j = i + 1;
              int k = n - 1;
              while (j < k) {
                  int sum = arr[i] + arr[j] + arr[k];
                  if (sum < 0) {
                      j++;
                  } else if (sum > 0) {
                      k--;
                  } else {
                      List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                      ans.add(temp);
                      j++;
                      k--;
                      //skip the duplicates:
                      while (j < k && arr[j] == arr[j - 1]) j++;
                      while (j < k && arr[k] == arr[k + 1]) k--;
                  }
              }
          }

          return ans;
      }



     /*
     In the previous approach, we utilized 3 loops, but now our goal is to reduce it to 2 loops.
     To achieve this, we need to find a way to calculate arr[k]
     since we intend to eliminate the third loop (k loop). To calculate arr[k], we can derive a formula as follows:

     arr[k] = target - (arr[i]+arr[j]+arr[k]) = 0-(arr[i]+arr[j]+arr[k]) = -(arr[i]+arr[j]+arr[k])

    Time Complexity: O(N^2 * log(no. of unique triplets)), where N = size of the array.
    Reason: Here, we are mainly using 3 nested loops.
    And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity.
    But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

    Space Complexity: O(2 * no. of the unique triplets) + O(N) as
    we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.
     * */
     public static List<List<Integer>> tripletBetter(int n, int[] arr) {
         Set<List<Integer>> st = new HashSet<>();

         for (int i = 0; i < n; i++) {
             Set<Integer> hashset = new HashSet<>();
             for (int j = i + 1; j < n; j++) {
                 //Calculate the 3rd element:
                 int third = -(arr[i] + arr[j]);

                 //Find the element in the set:
                 if (hashset.contains(third)) {
                     List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                     temp.sort(null);
                     st.add(temp);
                 }
                 hashset.add(arr[j]);
             }
         }

         // store the set elements in the answer:
         List<List<Integer>> ans = new ArrayList<>(st);
         return ans;
     }


    /*
    This approach is pretty straightforward. Here,
    we will check all possible triplets using 3 loops and among them,
    we will consider the ones whose sum is equal to the given target i.e. 0.
    And before considering them as our answer we need to sort the triplets in ascending order so that we can consider only the unique ones.


        Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array.
        Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

        Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
    * */
    public static List<List<Integer>> tripletBF(int n, int[] arr) {
        Set<List<Integer>> st = new HashSet<>();

        // check all possible triplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}
