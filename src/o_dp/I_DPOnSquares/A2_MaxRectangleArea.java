package o_dp.I_DPOnSquares;

import java.util.ArrayDeque;
import java.util.Deque;

public class A2_MaxRectangleArea {


    public static void main(String[] args) {
        char[][] height = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        A2_MaxRectangleArea sol = new A2_MaxRectangleArea();
        System.out.println(sol.maximalRectangle(height));
    }
    public int maximalRectangle(char[][] matrix) {

        int [] ansArray = new int[matrix[0].length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    ansArray[j] = ansArray[j]+1;
                }else{
                    ansArray[j] = 0;
                }
            }
            max = Math.max(largestRectangleArea(ansArray),max);
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {



        Deque<Integer> stack = new ArrayDeque<>();

        int [] leftMin = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            if(heights[i] == 0){
                stack.push(i);
                leftMin[i] = 0;
                continue;
            }


            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();


            if(stack.isEmpty())
                leftMin[i] = 0;
            else
                leftMin[i] = stack.peek()+1 ;


            stack.push(i);
        }

        stack.clear();

        int [] rightMin = new int[heights.length];

        for (int i = heights.length-1; i >= 0; i--) {
            if(heights[i] == 0){
                stack.push(i);
                leftMin[i] = 0;
                continue;
            }


            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();


            if(stack.isEmpty())
                rightMin[i] = heights.length-1;
            else
                rightMin[i] = stack.peek()-1 ;


            stack.push(i);
        }

        int max = 0;
        for(int k = 0;k<heights.length; k++){
            if (((rightMin[k]-leftMin[k]+1)*heights[k]) > max)
                max = ((rightMin[k]-leftMin[k]+1)*heights[k]);
        }
        return max;
    }
}
