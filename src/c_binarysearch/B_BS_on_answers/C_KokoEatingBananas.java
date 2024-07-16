package c_binarysearch.B_BS_on_answers;


/*
https://takeuforward.org/binary-search/koko-eating-bananas/
https://leetcode.com/problems/koko-eating-bananas/description/
https://youtu.be/qyfekrNni90


Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k.
Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23

* */
public class C_KokoEatingBananas {
    public static void main(String[] args) {
        C_KokoEatingBananas sol = new C_KokoEatingBananas();

    }


    /*
    Time Complexity: O(N * log(max(a[]))), where max(a[]) is the maximum element in the array and N = size of the array.
    Reason: We are applying Binary search for the range [1, max(a[])], and for every value of ‘mid’,
we are traversing the entire array inside the function named calculateTotalHours().

Space Complexity: O(1) as we are not using any extra space to solve this problem.
    * */

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        //apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(piles, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }



    /*
    Time Complexity: O(max(a[]) * N), where max(a[]) is the maximum element in the array and N = size of the array.


    Reason: We are running nested loops.
            The outer loop runs for max(a[]) times in the worst case and the inner loop runs for N times.

    Space Complexity: O(1) as we are not using any extra space to solve this problem.
    * */
    public int minEatingSpeedBF(int[] piles, int h) {
        int maxi = findMax(piles);

        //Find the minimum value of k:
        for (int i = 1; i <= maxi; i++) {
            int reqTime = calculateTotalHours(piles, i);
            if (reqTime <= h) {
                return i;
            }
        }

        //dummy return statement
        return maxi;
    }


    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }

}
