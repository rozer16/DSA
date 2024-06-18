package e1_greedy_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*

https://leetcode.com/problems/insert-interval/description/

https://youtu.be/xxRE-46OCC8?list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
* */
public class N_Insert_Interval {

    public static void main(String[] args) {
        N_Insert_Interval sol = new N_Insert_Interval();
        int [][] intervals = {
                {1,2},
                {3,10},
                {12,16}
        }

                ;
        System.out.println(Arrays.toString(sol.insert(intervals, new int[]{4,8})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(intervals.length);
        int n = intervals.length;
        int ind = 0;


        //Left part of merge interval where there is no interval
        while(ind < n && intervals[ind][1] < newInterval[0]){
            list.add(intervals[ind]);
            ind++;
        }

        //interval, so taking min and max and then inserting it to result list.
        while(ind < n && newInterval[1] > intervals[ind][0]){
            newInterval[0] = Math.min(newInterval[0] , intervals[ind][0]);
            newInterval[1] = Math.max(newInterval[1] , intervals[ind][1]);
            ind++;
        }
        list.add(newInterval);


        //Right part of interval
        while(ind < n ){
            list.add(intervals[ind]);
            ind++;
        }


        int [][] res = new int[list.size()][2];
        int index = 0;
        for(int [] arr : list){
            res[index++] = arr;
        }
        return res;

    }
}
