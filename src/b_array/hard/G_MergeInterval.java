package b_array.hard;

import java.util.*;
/*
https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
https://youtu.be/IexN60k62jo
https://leetcode.com/problems/merge-intervals/description/


Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].



Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

* */
public class G_MergeInterval    {

    public static void main(String[] args) {
        G_MergeInterval sol = new G_MergeInterval();
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int [][] ans = sol.merge(arr);
        System.out.print("The merged intervals are: \n");
        for (int [] it : ans) {
            System.out.print(Arrays.toString(it));
        }
        System.out.println();
    }

    /*
     Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
    Reason: Sorting the given array takes  O(N*logN) time complexity.
    Now, after that, we are just using a single loop that runs for N times. So, the time complexity will be O(N).

    Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.
    * */
    public int[][] merge(int[][] intervals) {
        //Sort elements based on first element of an array
        Arrays.sort(intervals,(interval1, interval2)-> interval1[0]- interval2[0]);

        List<int[]> ans = new ArrayList();

        for(int i=0; i<intervals.length; i++){
            // If ans is empty or 0th element of current interval is greater than 1st element of last interval
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(ans.isEmpty() || ans.get(ans.size()-1)[1] < start)
                ans.add(new int[]{start, end});
            else
                //Set last interval with max of current[1] or prev[1]
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], end);
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
