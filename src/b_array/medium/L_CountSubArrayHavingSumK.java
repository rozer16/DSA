package b_array.medium;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/subarray-sum-equals-k/
*
*
* */
public class L_CountSubArrayHavingSumK {

    public static void main(String[] args) {
        L_CountSubArrayHavingSumK test = new L_CountSubArrayHavingSumK();
        int [] nums = {1,2,1,2,1}; //4
        int [] nums1 = {1,-1,0}; // k = 0,result = 3[{1,-1},{1,-1,0},{0}]
        int [] nums2 = {0,0}; // k = 0 , result =3[{0(0th ele)},{0(1st ele)},{0,0}]
        System.out.println(test.subarraySum(nums2,0));

    }


    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0;

        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(map.containsKey(sum-k))
                cnt += map.get(sum-k);

            if(map.containsKey(sum))
                map.put(sum,map.get(sum)+1);
            else
                map.put(sum,1);

        }
        return cnt;
    }
}
