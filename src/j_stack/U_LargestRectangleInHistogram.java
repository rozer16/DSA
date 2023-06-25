package j_stack;

import java.util.ArrayDeque;
import java.util.Deque;
/*
* https://leetcode.com/problems/largest-rectangle-in-histogram/
* https://youtu.be/X0X6G-eWgQ8
*
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*
*
Input: heights = [2,4]
Output: 4
*
*
*
* Solution : Two stack and arrays to find elements which are less than left side and right side respectively
* Once we have two arrays right and left, for ith element area = rightMinIndex[k]-leftMinIndex[k]+1
* To find max
        for(int k = 0;k<heights.length; k++){
            if (((rightMinIndex[k]-leftMinIndex[k]+1)*heights[k]) > max)
                max = ((rightMinIndex[k]-leftMinIndex[k]+1)*heights[k]);
        }
*
* **/
public class U_LargestRectangleInHistogram {
    public static void main(String[] args) {
        int [] arr = {2,1,5,6,2,3,1};
        int [] arr1 = {0,9};
        U_LargestRectangleInHistogram test = new U_LargestRectangleInHistogram();

        System.out.println(test.largestRectangleArea(arr));
    }


    /*
    *
    * 1. If stack is empty then put leftMinIndex[i] = 0
    * 2)
    *    2.1)  for i = 0 -> n-1
    *       while heights[i] <= heights[stack.peek()] , keep popping from stack
            since we want to go left until its value is less or equal to current index
    *   2.2) if stack is empty then set minLeft[i] = 0 else minLeft[i] = stack.peek()+1;
    *
    *   leftMinIndex = {0,0,2,3,2,5,0}
    *
    * 3) clear the stack
    *
    * 4) for i = n-1 --> 0
    *        while heights[i] <= heights[stack.peek()] , keep popping from stack
            since we want to go right until its value is less or equal to current index
    *   2.2) if stack is empty then set minLeft[i] = 0 else minLeft[i] = stack.peek()-1;
    *
    *   rightMinIndex = {0,6,3,3,5,5,6}
    *
    *
    *   for i = 0 -> n-1
    *       if max > rightMinIndex[i] - leftMinIndex[i] +1 then max = rightMinIndex[i] - leftMinIndex[i] +1
    *
    *   return max
    *
    */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque();
        int [] leftMinIndex = new int[heights.length];
        int [] rightMinIndex = new int[heights.length];

        //Calculating left min index having less or equal size
        for(int i = 0;i<heights.length;i++){
            if(heights[i] == 0){
                leftMinIndex[i] = 0;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            if(stack.isEmpty())
                leftMinIndex[i] = 0;
            else
                leftMinIndex[i]=stack.peek()+1;

            stack.push(i);
        }
        stack.clear();

        //Calculating right min index having less or equal size
        for(int i = heights.length-1; i>=0 ; i--){
            if(heights[i] == 0){
                rightMinIndex[i] = 0;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            if(stack.isEmpty())
                rightMinIndex[i] = heights.length-1;
            else
                rightMinIndex[i] = stack.peek()-1;

            stack.push(i);
        }

        int max = 0;
        for(int k = 0;k<heights.length; k++){
            if (((rightMinIndex[k]-leftMinIndex[k]+1)*heights[k]) > max)
                max = ((rightMinIndex[k]-leftMinIndex[k]+1)*heights[k]);
        }

        return max;

    }

    //Bruteforce
    private int getLargestRectangleInHistogram(int[] heights) {
        int maxRectangle = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            int count = 0;
            int j=i;
            while(j>=0 && heights[j]>=heights[i]){
                count++;
                j--;
            }
            j=i+1;
            while(j<heights.length && heights[j] >=heights[i]){
                count++;
                j++;
            }
            if(count*heights[i] > maxRectangle)
                maxRectangle = count*heights[i];
        }
        return maxRectangle;
    }
}
