package e_slidingwindow_two_pointer.medium;


/*
https://www.youtube.com/watch?v=pBWCOCS636U
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.



Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However,
choosing the rightmost card first will maximize your total score.
 The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.


Constraints:

1 <= cardPoints.length <= 105
1 <= cardPoints[i] <= 104
1 <= k <= cardPoints.length
* */
public class H_Maximum_Points_You_Can_Obtain_From_Cards {
    public static void main(String[] args) {
        H_Maximum_Points_You_Can_Obtain_From_Cards sol = new H_Maximum_Points_You_Can_Obtain_From_Cards();
        System.out.println(sol.maxScore(new int [] {9,7,7,9,7,7,9}, 7)); //55
    }
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;


        //Doing sum of first k points
        for(int i=0; i<k; i++){
            leftSum += cardPoints[i];
        }
        int max  = leftSum;
        int left = k-1;
        int right = cardPoints.length-1;

        // Subtracting kth element and adding nth-1 ele and checking if its greater than max.
        while(left >= 0){
            leftSum = leftSum - cardPoints[left];
            rightSum = rightSum + cardPoints[right];
            left--;
            right--;
            max = Math.max(max, leftSum+rightSum);
        }

        return max;
    }
}