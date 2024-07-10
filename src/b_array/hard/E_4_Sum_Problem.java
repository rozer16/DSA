package b_array.hard;


import java.util.*;

/*
https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/
https://leetcode.com/problems/4sum/description/
https://youtu.be/eD95WRfh81c


Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

* */
public class E_4_Sum_Problem {



    /*
    Time Complexity: O(N3), where N = size of the array.
    Reason: Each of the pointers i and j, is running for approximately N times.
    And both the pointers k and l combined can run for approximately N times including the operation of skipping duplicates.
    So the total time complexity will be O(N3).

    Space Complexity: O(no. of quadruplets), This space is only used to store the answer.
     We are not using any extra space to solve this problem.
     So, from that perspective, space complexity can be written as O(1).
    * */
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i< n; i++){

            if(i > 0 && arr[i] == arr[i-1])
                continue;

            for(int j=i+1;j<n; j++){

                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                int k = j+1;
                int l = n-1;

                while(k < l){
                    long sum = arr[i]+ arr[j] ;
                    sum += arr[k];
                    sum += arr[l];
                    if(sum < target){
                        k++;
                    }else if(sum > target){
                        l--;
                    }else{
                        List<Integer> list1 = Arrays.asList(arr[i],arr[j],arr[k], arr[l]);
                        list.add(list1);
                        k++;
                        l--;
                        while(k < l && arr[k] == arr[k-1])
                            k++;
                        while(k < l && arr[l] == arr[l+1])
                            l--;
                    }
                }
            }
        }
        //List<List<Integer>> ans = new ArrayList(set);
        return list;
    }



    /*
    Time Complexity: O(N^3*log(M)), where N = size of the array, M = no. of elements in the set.
    Reason: Here, we are mainly using 3 nested loops, and inside the loops there are some operations on the set data structure which take log(M) time complexity.

    Space Complexity: O(2 * no. of the quadruplets)+O(N)
    Reason: we are using a set data structure and a list to store the quads.
     This results in the first term. And the second space is taken by the set data structure we are using to store the array elements.
     At most, the set can contain approximately all the array elements and so the space complexity is O(N).
    * */
    public List<List<Integer>> fourSumBetter(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i< n; i++){
            for(int j=i+1;j<n; j++){
                Set<Integer> set1 = new HashSet();
                for(int k=j+1; k<n; k++){
                    int sum = arr[i]+ arr[j] + arr[k];
                    int find = target-sum;
                    if(set1.contains(find)){
                        List<Integer> list = Arrays.asList(arr[i],arr[j],arr[k], find);
                        set.add(list);
                    }
                    set1.add(arr[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList(set);
        return ans;
    }


    /*
     Time Complexity: O(N^4), where N = size of the array.
        Reason: Here, we are mainly using 4 nested loops. But we not considering the time complexity of sorting as we are just sorting 4 elements every time.

        Space Complexity: O(2 * no. of the quadruplets) as we are using a set data structure and a list to store the quads.
    * */
    public static List<List<Integer>> fourSumBF(int[] nums, int target) {
        int n = nums.length; // size of the array
        Set<List<Integer>> set = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        // taking bigger data type
                        // to avoid integer overflow:
                        long sum = (long)nums[i] + nums[j];
                        sum += nums[k];
                        sum += nums[l];

                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}
