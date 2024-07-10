package b_array.hard;


import java.util.HashMap;
import java.util.Map;

/*
https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1?category%5B%5D=Hash&company%5B%5D=Amazon&page=1&query=category%5B%5DHashcompany%5B%5DAmazonpage1company%5B%5DAmazoncategory%5B%5DHash&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-subarray-with-0-sum
https://youtu.be/xmguZ6GbatA

Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Examples:

Input: arr[] = {15,-2,2,-8,1,7,10,23}, n = 8
Output: 5
Explanation: The largest subarray with sum 0 is -2 2 -8 1 7.


Input: arr[] = {2,10,4}, n = 3
Output: 0
Explanation: There is no subarray with 0 sum.


Input: arr[] = {1, 0, -4, 3, 1, 0}, n = 6
Output: 5
Explanation: The subarray is 0 -4 3 1 0.


Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

* */
public class F_Largest_Subarray_With_0_Sum {


    public static void main(String[] args) {

    }


    //Intuition:
    //Now let’s say we know that the sum of subarray(i, j) = S,
    // and we also know that the sum of subarray(i, x) = S where i < x < j.
    // We can conclude that the sum of subarray(x+1, j) = 0.


    // Time Complexity: O(N), as we are traversing the array only once

    //Space Complexity: O(N), in the worst case we would insert all array elements prefix sum into our hashmap
    int maxLen(int arr[], int n) {
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;


        for(int i = 0; i< n; i++){
            sum += arr[i];
            if(sum == 0){
                maxLen = i+1;
                continue;
            }

            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    /*
    Time Complexity: O(N^2) as we have two loops for traversal

    Space Complexity: O(1) as we aren’t using any extra space.
    * */
    public int maxSubArray(int[] a){
        int  max = 0;
        for(int i = 0; i < a.length; ++i){
            int sum = 0;
            for(int j = i; j < a.length; ++j){
                sum += a[j];
                if(sum == 0){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
}
