package c_binarysearch.A_BS_on_1d;


/*
https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/
https://leetcode.com/problems/single-element-in-a-sorted-array/description/

https://www.youtube.com/watch?v=AZOmHuHadxQ

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.



Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105

0 1 2 3 4 5 6 7 8 9 10
1 1 2 2 3 3 4 5 5 6 6
E O E O E O E O E O E


Observatoin :

1) Left half of single element(Index 0-5)

Index of first occurrence : even
Index of second occurrence  : odd

2) Right half of single element(index 7-10)
Index of first occurrence : odd
Index of second occurrence  : even

3) so in order to  eliminate half part of array we can use above 2 point observation
    if mid is odd & nums[mid] == nums[mid+1]
                OR
     if mid is even & nums[mid] == nums[mid-1]

     then single element is on right half of mid

     if(mid%2 == 1 && nums[mid] == nums[mid-1]
                    || mid%2 == 0 && nums[mid] == nums[mid+1]
* */
public class K_SearchSingleElementInSortedArray {


    public static void main(String[] args) {
        int [] arr = {1,1,2,2,3,3,4,5,5,6,6};
        K_SearchSingleElementInSortedArray sol = new K_SearchSingleElementInSortedArray();
        System.out.println(sol.singleNonDuplicate(arr)); //4
    }
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;

        //If there is single element then element itself is single element
        if(length == 1)
            return nums[0];


        //To avoid extra edde case check if first element is single element
        if(nums[0] != nums[1]){
            return nums[0];
        }

        //To avoid extra edge case check if last element is single element
        if(nums[length-1] != nums[length-2]){
            return nums[length-1];
        }

        //To avoid extra edge case check do binary search betwenn 1 to n-2
        int low = 1;
        int high = length-2;

        while(low <= high){
            int mid = low + (high-low)/2;

            ////check if single element is mid
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1])
                return nums[mid];


            //check if single element is in left half or right half accodingly upate low/high

            //If mid is at odd index and arr[mid] == arr[mid-1]
            if(mid%2 == 1 && nums[mid] == nums[mid-1]
                    || mid%2 == 0 && nums[mid] == nums[mid+1]){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }

        return -1;
    }
}
