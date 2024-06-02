package j_stack;


/*
https://leetcode.com/problems/trapping-rain-water/
https://youtu.be/m18Hntz4go8
*
To look diagram visit link

Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

*
*
Input: height = [4,2,0,3,2,5]
Output: 9
* */
public class R_TrappingRainWater {
    public static void main(String[] args) {
        int arr [] = {0,1,0,2,1,0,1,3,2,1,2,1}; //ans = 6
        int arr1[] = {4,2,0,3,2,5}; //ans = 9
        R_TrappingRainWater test = new R_TrappingRainWater();
        System.out.println(test.twoPointer(arr1));
    }

    //TC : O(N)
    //SC : O(1)
    public int twoPointer(int [] height){
        int n = height.length;
        int left = 0, right = height.length-1;
        int res = 0;
        int lMax = 0, rMax = 0;

        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= lMax)
                    lMax = height[left];
                else
                    res += lMax - height[left];

                left++;
            }else{
                if(height[right] >= rMax)
                    rMax = height[right];
                else
                    res+= rMax - height[right];

                right--;
            }
        }
        return res;
    }


    //TC : O(3N) ~= O(N)
    //SC : O(2N) ~= O(N)

    //height =    [0,1,0,2,1,0,1,3,2,1,2,1]
    //leftPrefix =[0,1,1,2,2,2,2,3,3,3,3,3] // start from left to right(0 --> n-1)
    //rightPrefix=[3,3,3,3,3,3,3,3,2,2,2,1] // start from right to left(n-1 --> 0)
        //for i=0 -> n-1, sum += Math.min(leftPrefix[i],rightPrefix[i])-height[i];
    public int prefixSum(int [] height){
        int sum = 0;
        //SC : O(N)
        int leftPrefix []=new int[height.length];

        //SC : O(N)
        int rightPrefix []=new int[height.length];

        leftPrefix[0] = height[0];

        //TC : O(N)
        for (int i = 1; i < height.length; i++)
            leftPrefix[i] = Math.max(leftPrefix[i-1],height[i]);

        rightPrefix[height.length-1] = height[height.length-1];

        //TC : O(N)
        for (int i = height.length-2; i >= 0; i--)
            rightPrefix[i] = Math.max(rightPrefix[i+1],height[i]);

        //TC : O(N)
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(leftPrefix[i],rightPrefix[i])-height[i];
        }
        return sum;
    }

    //Complexity : O(n^2)
    //ans[i] = min (find maximum no to left , find maximum no to right)-height[i]
    public int bruteForceApproach1(int[] hieght){
        int sum = 0;
        for (int i = 0; i < hieght.length; i++) {
            //For each i, find maximum no to left and store in leftMax
            int leftMax = hieght[i];
            for (int j = 0; j < i; j++) {
                if(hieght[j] > leftMax)
                    leftMax = hieght[j];
            }
            //For each i, find maximum no to right and store in rightMax
            int rightMax = hieght[i];
            for (int j = i; j < hieght.length; j++) {
                if(hieght[j] > rightMax)
                    rightMax = hieght[j];
            }

            sum += Math.min(leftMax,rightMax)-hieght[i];
        }
        return sum;
    }


}
