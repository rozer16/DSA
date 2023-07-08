package b_array.easy;

/*
*https://www.geeksforgeeks.org/check-if-an-array-is-sorted-and-rotated/
* https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
* */
public class D_CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        D_CheckIfArrayIsSortedAndRotated test = new D_CheckIfArrayIsSortedAndRotated();
        int [] arr = {3,4,5,1,2};
        System.out.println(test.checkIfArrayIsSortedAndRotated(arr));
    }
    /*
    *
    Find the minimum element in the array.
    Now, if the array is sorted and then rotated, then all the elements before the minimum element will be in increasing order
    and all elements after the minimum element will also be in increasing order.
    Check if all elements before the minimum element are in increasing order.
    Check if all elements after the minimum element are in increasing order.
    Check if the last element of the array is smaller than the starting element, as this would make sure that the array has been rotated at least once.
    If all of the above three conditions satisfies then print YES otherwise print NO
    *
    *
    another approach
    *
    * 3,4,5,1,2
    *
    * iterate i = 0 --> n-1
    * i=0 ==> 3>4
    * i=1 ==> 4>5
    * i=0 ==> 5>1
    * i=0 ==> 1>2
    * i=0 ==> 2>3
    *
    *     * */
    private boolean checkIfArrayIsSortedAndRotated(int[] nums) {

        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            //For last element of an array we put nums[(i+1)%nums.length]
            //For e.g. {6,7,1,2,3,4,5}, len = 7
            //i= 6 ==> (6+1)%7 ==> 7%7 ==> 0
            if(nums[i]>nums[(i+1)%nums.length])
                count++;
        }
        return (count<=1);

    }
    
    //If array is not rotated
    private boolean checkIfArrayIsSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] <= arr[i-1])
                i=i;
            else
                return false;
        }
        return  true;

    }

}
