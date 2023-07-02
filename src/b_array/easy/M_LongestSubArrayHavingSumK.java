package b_array.easy;

/*
* https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/
*
*
* Longest Subarray with given Sum K(Positives)
*
* arr : 1,2,3,1,1,1,1,4,2,3
* k = 3
*
* longest subarray having sum 3==> 1,1,1
*
* */

import java.util.HashMap;
import java.util.Map;

public class M_LongestSubArrayHavingSumK {

    public static void main(String[] args) {
        M_LongestSubArrayHavingSumK test = new M_LongestSubArrayHavingSumK();
        int [] arr = {1,2,3,1,1,1,1,4,2,3}; // 3 {3,4,5}
        System.out.println(test.findLongestSubArrayHavingSumk(arr,6));


        int [] arr1 = {2,0,0,3}; // 3 {1,2,3}
        System.out.println(test.findLongestSubArrayHavingSumk(arr1,3));
    }


    /*
    *
    * Optimal : Only for positive, for negative use below one only.
    *
    * Intuition : Two pointer
    *
    * */
    private int findLongestSubArrayHavingSumk(int[] arr,int k) {
        int maxLen = 0;
        int sum = arr[0];
        int p1 = 0, p2 = 0;
        int n = arr.length;

        while(p2 <n){
            while(sum > k && p1 <= p2) {
                sum -= arr[p1];
                p1++;
            }
            if(sum == k){
                    maxLen = Math.max(maxLen,p2-p1+1);
            }

            p2++;
            if(p2 < n)
                sum += arr[p2];
        }


        return maxLen;
    }

    /*
    * Better : For negative and positive both works
    *
    * Prefix sum and hashmap
    * TC : O(n) since iterating all elements through array
    * SC : O(n) since storing sum in hashmap
    *
    *
    *
    * Step 1 : Initialize three vars map<sum_of_0_to_i,i>, maxLen, sum
    * Step 2 : Iterate 0 to n-1
    * Step 3 : sum += arr[i]
    * Step 4 : put new entry in map (sum,i)
    * Step 5 : if map.containsKey(sum-k) ==> calculate len = i-map.get(sum-k)
    * Step 6 : if len > maxLen then set maxLen = len
    *
    * */
    private int findLongestSubArrayHavingSumk3(int[] arr,int k) {
        int maxLen = 0, sum = 0;
        Map<Integer,Integer> prefix = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(prefix.containsKey(sum-k)){
                maxLen = Math.max(maxLen, i-prefix.get(sum-k));
            }

            //Need this condition since if elements could be 0, negative for e.g. 2,0,0,3
            //so second and third element will replace index and wont give correct output.
            //
            if(!prefix.containsKey(sum))
                prefix.put(sum,i);
        }

        return maxLen;
    }



    //Bruteforce
    //Complexity : O(n^2)

    private int findLogestSubArrayHavingSumk2(int[] arr,int k) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                //If sum = k then check if its maximum len
                if(sum == k){
                    maxLen = Math.max(maxLen, j-i+1);
                    break;  //if sum becomes k then there is no meaning to iterate through rest of element.
                }

                //if sum becomes greater than k then there is no meaning to iterate through rest of element.
                if(sum > k)
                    break;

            }
        }
        return maxLen;
    }

    //Complexity : O(n^3)

    private int findLogestSubArrayHavingSumk1(int[] arr,int k) {
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int k1 = i; k1 <= j; k1++) {
                    sum += arr[k1];
                }
                if(sum == k){
                    int len = j-i+1;
                    maxLen = Math.max(len,maxLen);
                }

            }
        }
        return maxLen;
    }
}
