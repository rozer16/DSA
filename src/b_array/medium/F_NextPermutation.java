package b_array.medium;


import java.util.Arrays;

/*
* https://leetcode.com/problems/next-permutation/
* https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr:
   [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].


The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
  More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
  then the next permutation of that array is the permutation that follows it in the sorted container.
  If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,,32]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
* */
public class F_NextPermutation {

    public static void main(String[] args) {
        F_NextPermutation test = new F_NextPermutation();
        int arr [] = {4,2,3,1};
        test.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }


    /*
    * Algorithm / Intuition
    The steps are the following:

    * Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i]
      becomes smaller than arr[i+1].
    * For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing).
      Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.
    * To find the break-point, using a loop we will traverse the array backward and store the index i
      where arr[i] is less than the value at index (i+1) i.e. arr[i+1].
    * If such a break-point does not exist i.e. if the array is sorted in decreasing order,
      the given permutation is the last one in the sorted order of all possible permutations.
      So, the next permutation must be the first i.e. the permutation in increasing order.
    * So, in this case, we will reverse the whole array and will return it as our answer.


    * If a break-point exists:
      Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1)
      and swap it with arr[i].

    * Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.
        *
    *
    * */
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        for (int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverseArray(nums,0, nums.length-1);
            return;
        }

        for (int i = n-1; i > index; i--) {
            if(nums[i] > nums[index]){
                swap(nums,i, index);
                break;
            }
        }
        reverseArray(nums,index+1,n-1);
    }

    public void reverseArray(int [] arr, int p1,int p2){
        int left = p1;
        int right = p2;
        while(left <= right){
            swap(arr,left,right);
            left++;
            right--;
        }
    }

    public void swap(int [] arr, int p1,int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
    /*
    * Bruteforce : Find all permutation combination in order and get next to current one
    * TC : O(n*n!)
    *
    *
    * */
}
