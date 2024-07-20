package c_binarysearch.B_BS_on_answers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/*
https://takeuforward.org/arrays/painters-partition-problem/
https://youtu.be/thUd_WJn6wk
https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf


Problem statement
Given an array/list of length ‘n’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘k’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint.



You are supposed to return the area of the minimum time to get this job done of painting all the ‘n’ boards under a constraint that any painter will only paint the continuous sections of boards.



Example :
Input: arr = [2, 1, 5, 6, 2, 3], k = 2

Output: 11

Explanation:
First painter can paint boards 1 to 3 in 8 units of time and the second painter can paint boards 4-6 in 11 units of time. Thus both painters will paint all the boards in max(8,11) = 11 units of time. It can be shown that all the boards can't be painted in less than 11 units of time.

* */
public class K_Painters_Partition {

    public static void main(String[] args) {
        K_Painters_Partition sol = new K_Painters_Partition();
        System.out.println(sol.findLargestMinDistance(Arrays.asList(10, 20, 30, 40),2));
    }
    public int findLargestMinDistance(List<Integer> boards, int k){
       int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        while(low <= high){
            int mid = low + (high-low)/2;

            if(getNoOfPainterToPaintNBoards(boards, mid) > k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;

        /*int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        // Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = getNoOfPainterToPaintNBoards(boards, mid);
            if (painters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;*/
    }

    public static int getNoOfPainterToPaintNBoards(List<Integer> boards, int maxLength){
        int sum = 0;
        int noOfPainter = 1;

        for(int board : boards){
            if(sum + board > maxLength){
                noOfPainter++;
                sum = board;
            }else{
                sum += board;
            }
        }

        return noOfPainter;
    }
}
