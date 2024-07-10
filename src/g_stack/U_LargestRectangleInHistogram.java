package g_stack;

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

        System.out.println(test.largestRectangleAreaBetter(arr));
    }

    //TC : O(n) for arr tranversal + O(n) for stack = O(2n)
    //SC : O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = Integer.MIN_VALUE;

        //In stack we will be storing index so that we can calculate width, height can be accessed by height[stack.peek()]
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i<=n; i++){
            //If height[i] is less than val of index at stack.peek() then start calculating max width
            //since height[i] is  max  right width and left width is one down to stack top so pop it and get it
            // and calculate area. if area is greater than max then update max.

            while(!stack.isEmpty() && (i == n || (heights[stack.peek()] >= heights[i]))){
                int height = heights[stack.pop()];
                int width = 0;
                if(stack.isEmpty())
                    width = i;
                else
                    width = i-stack.peek()-1;

                max = Math.max(max, height*width);
            }

            stack.push(i);
        }

        return max;
    }




    /*
        //TC : O(n) for traversing left to right + O(n) for stack
               + O(n) for traversing right to left + O(n) for stack
               + O(n) for calcularing

               =~ O(3n)

       //SC : O(n)


        arr = [2,1,5,6,2,3,1]
    *   leftMinIndex = {0,0,2,3,2,5,0}    *
    *   rightMinIndex = {0,6,3,3,5,5,6}

    *   for i = 0 -> n-1
    *       if max > rightMinIndex[i] - leftMinIndex[i] +1 then max = rightMinIndex[i] - leftMinIndex[i] +1
    *
    *   return max
    *
    */
    public int largestRectangleAreaBetter(int[] heights) {
        Deque<Integer> stack = new ArrayDeque();
        int [] prevSmallerIndex = new int[heights.length];
        int [] nextSmallerIndex = new int[heights.length];

        //Calculating left min index having less or equal size
        for(int i = 0;i<heights.length;i++){

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            if(stack.isEmpty())
                prevSmallerIndex[i] = 0;
            else
                prevSmallerIndex[i]=stack.peek()+1;

            stack.push(i);
        }
        stack.clear();

        //Calculating right min index having less or equal size
        for(int i = heights.length-1; i>=0 ; i--){

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            if(stack.isEmpty())
                nextSmallerIndex[i] = heights.length-1;
            else
                nextSmallerIndex[i] = stack.peek()-1;

            stack.push(i);
        }

        int max = 0;
        for(int k = 0;k<heights.length; k++){
            if (((nextSmallerIndex[k]-prevSmallerIndex[k]+1)*heights[k]) > max)
                max = ((nextSmallerIndex[k]-prevSmallerIndex[k]+1)*heights[k]);
        }

        return max;

    }


    //SC : O(n^2)
    //TC : O(1)


    public int largestRectangleAreaBruteForce(int[] heights) {
        int n = heights.length;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                min = Math.min(min, heights[j]);
                largest = Math.max(largest, min*(j-i+1));
            }
        }

        return largest;
    }





}
