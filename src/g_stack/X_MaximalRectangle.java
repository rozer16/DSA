package g_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
* https://leetcode.com/problems/maximal-rectangle/
* Given a rows x cols binary matrix filled with 0's and 1's,
*  find the largest rectangle containing only 1's and return its area.

1   0   1   0   0
1   0   1   1   1
1   1   1   1   1
1   0   0   1   0

Output : 6
*
*
*
Input: matrix = [["0"]]
Output: 0
*
*
Input: matrix = [["1"]]
Output: 1
*
*
*
* Observations :
*
* 1. This problem is different than maximal area rectangle problem
* 2. We can convert matrix into histograms row wise and find maximal area rectangle in each of those histogram
*
* Intution
*
* Convert matrix into histograms row wise
*
* Rules :
*
* 1) For ith row histogram would be 0 to ith row
* 2) Height of specific column for given row is = count of no of 1 in that column
* 3) If element value for current cell is 0 then weight = 0
*
*
*
* 0 1   0   1   1st Row ==> 0   1   0   1
* 1 1   1   1   2nd Row ==> 1   2   1   2
* 1 1   0   0   3rd row ==> 2   3   0   0
*
*
* 1 0   1   0   0   1st Row ==> 1   0   1   0   0
* 1 0   1   1   1   2nd Row ==> 2   0   2   1   1
* 1 1   1   1   1   3rd Row ==> 3   1   3   2   2
* 1 0   0   1   0   4th Row ==> 4   0   0   3   0
*
* To process single row and find max rectangle complexity O(No of columns)
*
* For binary matrix TC = O(No of rows* Finding largest rectangle area in a histogram)
*                      = O(R*C)
*
* */
public class X_MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                new char[]{'1','0','1','0','0'},
                new char[]{'1','0','1','1','1'},
                new char[]{'1','1','1','1','1'},
                new char[]{'1','0','0','1','0'}
        };
        X_MaximalRectangle test = new X_MaximalRectangle();
        System.out.println(test.maximalRectangle(matrix));
    }
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int length = matrix.length;
        int width =  length == 0 ? 0 : matrix[0].length; //added length condition in case empty matrix
        
        //To store height of each row  
        int [][] heights = new int[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix[i][j] == '0'){
                    heights[i][j] = 0;
                }else{
                    heights[i][j] = (i == 0) ? 1 : heights[i-1][j]+1; // 1 row above
                }
            }
        }

        for (int i = 0; i < length; i++) {
            int area = getMaxRectangle(heights[i]);
            if(area > max)
                    max = area;
        }
        return max;
    }

    private int getMaxRectangle(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int [] left = new int[height.length];
        int [] right = new int[height.length];
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            if(height[i] == 0){
                left[i] = 0;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && height[stack.peek()] >= height[i])
                stack.pop();

            if(stack.isEmpty())
                left[i] = 0;
            else
                left[i] = stack.peek()+1;


            stack.push(i);
        }
        stack.clear();
        for (int i = height.length-1; i >= 0; i--) {
            if(height[i] == 0){
                right[i] = 0;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && height[stack.peek()] >= height[i])
                stack.pop();

            if(stack.isEmpty())
                right[i] = height.length-1;
            else
                right[i] = stack.peek()-1;

            stack.push(i);



        }
        for (int i = 0; i < height.length; i++) {
            int rectangleArea = (right[i]-left[i]+1)*height[i];
            max = max < rectangleArea ? rectangleArea : max;
        }

        return max;
    }
}
