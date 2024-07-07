package j_greedy_algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
https://www.youtube.com/watch?v=2JzRBPFYbKE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=7
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


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
* */
public class O_Merge_Interval {

    public static void main(String[] args) {
        O_Merge_Interval sol = new O_Merge_Interval();
        int [][] intervals = {
                {1,4},{4,5}
        };
        System.out.println(Arrays.toString(sol.merge(intervals)));
    }
    public int[][] merge(int[][] intervals) {
        //Sorting 2D array based on first element
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            //Check if there is no overlapping sub interval
            if(result.isEmpty() || start > result.get(result.size()-1)[1]) {
                result.add(new int[]{start, end});

            }else{
                ////Check if there is  intersection then update arr[1] to max element
                result.get(result.size()-1)[1] = Math.max(end,result.get(result.size()-1)[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
