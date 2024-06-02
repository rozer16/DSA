package b_array.hard;

import java.util.*;

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


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(result.isEmpty() || start > result.get(result.size()-1)[1]) {
                result.add(new int[]{start, end});

            }else{
                result.get(result.size()-1)[1] = Math.max(end,result.get(result.size()-1)[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!result.isEmpty() && end <= result.get(result.size()-1)[1] )
                    continue;

            for (int j = 0; j < intervals.length; j++) {
                if(intervals[j][0] <= end)
                    end= Math.max(intervals[j][1], end);
                else
                    break;
            }
            result.add(new int[]{start,end});

        }
        return result.toArray(new int[result.size()][result.size()]);
    }
}
