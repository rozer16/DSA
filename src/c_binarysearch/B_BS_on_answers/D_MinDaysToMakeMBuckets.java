package c_binarysearch.B_BS_on_answers;


/*
https://takeuforward.org/arrays/minimum-days-to-make-m-bouquets/
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
https://youtu.be/TXAuxeYBTdg

You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.



Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
Example 2:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
Example 3:

Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.

* */
public class D_MinDaysToMakeMBuckets {

    public static void main(String[] args) {
        int [] arr1 = {};
        D_MinDaysToMakeMBuckets sol = new D_MinDaysToMakeMBuckets();
       // System.out.println(sol.minDays(arr1,);


    }

    //Using binary search
    //TC : log2n * (max-min+1)
    //SC :
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if(m*k > len)
            return -1;
        int ans = -1;
        int [] minMax = findMinMax(bloomDay);
        //Range can be between min no of days to bloom to max no of days
        int low = minMax[0];
        int high = minMax[1];

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isPossible(bloomDay,m,k,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;

    }
    public int minDaysBruteForce(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if(m*k > len)
            return -1;

        int [] minMax = findMinMax(bloomDay);
        int min = minMax[0];
        int max = minMax[1];
        System.out.println(min+" "+max);
        for(int i = min; i<= max;i++){
            if(isPossible(bloomDay,m,k,i))
                return i;
        }

        return -1;
    }

    public int [] findMinMax(int [] bloomDay){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : bloomDay){
            if(i > max)
                max = i;

            if(i < min)
                min = i;
        }

        return new int[]{min, max};
    }

    public boolean isPossible(int [] bloomDay,int m, int k, int day){
        int n = bloomDay.length;
        int cnt = 0;
        int noOfB = 0;
        for(int i = 0;i<n; i++){
            if(bloomDay[i] <= day){
                cnt++;
            }else{
                noOfB += (cnt/k);
                cnt = 0;
            }
        }
        noOfB += (cnt/k);
        if(noOfB >= m)
            return true;

        return false;
    }
}
