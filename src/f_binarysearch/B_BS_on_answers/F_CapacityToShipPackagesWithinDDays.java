package f_binarysearch.B_BS_on_answers;


/*
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
https://takeuforward.org/arrays/capacity-to-ship-packages-within-d-days/
https://www.youtube.com/watch?v=MG-Ac4TAvTY

A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.



Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given,
so using a ship of capacity 14 and splitting the packages into parts like
(2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1


Constraints:

1 <= days <= weights.length <= 5 * 104
1 <= weights[i] <= 500
* */
public class F_CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        F_CapacityToShipPackagesWithinDDays sol = new F_CapacityToShipPackagesWithinDDays();
        System.out.println(sol.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
        System.out.println(sol.shipWithinDays(new int[]{3,2,2,4,1,4},3));
        System.out.println(sol.shipWithinDays(new int[]{1,2,3,1,1},4));

    }

    public int shipWithinDays(int[] weights, int days) {
        int [] maxAndSum = findMaxAndSum(weights);
        //Since we are supposed to ship all the packages the min capacity of ship should be max capacity from all the packages
        int low = maxAndSum[0];
        //Highest capacity of ship can be sum of all the packages that can be delivered in 1 day
        int high = maxAndSum[1];

        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(getNoOfDays(weights, mid) <= days){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }


    public int getNoOfDays(int [] weights, int capacity){
        int days = 0;
        int sum = 0;
        for(int i = 0; i<weights.length; i++){
            if(sum + weights[i] <= capacity){
                sum += weights[i];
            }else{
                days++;
                sum = weights[i];
            }
        }
        if(sum > 0)
            days++;
        return days;
    }
    public int [] findMaxAndSum(int [] weights){
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i : weights){
            if(i > max)
                max = i;
            sum += i;
        }

        return new int[]{max, sum};
    }
}
