package b_array.medium;

import java.util.*;
import java.util.stream.Collectors;

/*
* https://leetcode.com/problems/longest-consecutive-sequence/description/
* https://youtu.be/oO5uLE7EUlM
*
*
*
 Given an unsorted array of integers nums,
return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
*
*
* */
public class H_LongestConsequtiveInArray {

    public static void main(String[] args) {
        H_LongestConsequtiveInArray test = new H_LongestConsequtiveInArray();
        int [] arr = {100,4,200,1,3,2,5};
        System.out.println(test.getLongestConsequtiveNos(arr));
    }


    /*
    * Bruteforce : TC : O(3N)
    *              SC : O(N)
    * */
    public int getLongestConsequtiveNos(int [] arr){
        int max = 0;
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        Set<Integer> nos = new HashSet();

        for (int i = 0; i < arr.length; i++) {
            nos.add(arr[i]);
        }

        Iterator<Integer> i1 = nos.iterator();
        while(i1.hasNext()){
            int no = i1.next();
            if(!nos.contains(no-1)){

                int counter = 1;
                while(nos.contains(no+counter)){
                    counter++;
                }
                max= Math.max(counter,max);

            }
        }



        return max;
    }


}
