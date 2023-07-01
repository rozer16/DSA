package b_array.medium;


import java.util.Arrays;

/*
* https://leetcode.com/problems/sort-colors/
* https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
*
* Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

* */
public class B_SortColors_Seperate_0_1_2 {


    /*
    * Bruteforce approach : Iterate array, count 0,1 & 2, fill array based on count, TC : O(2n)
    * Better approach : sort array , TC : O(nlogn)
    * Optimal approach : Dutch national Flag Algorithm
    *
    * Keep 4 variables : low,mid,high
    *
    * 0 --> (low-1)  ==> 0
    * low --> mid-1  ==> 1
    * mid --> high-1 ==> unsorted
    * high --> n-1   ==> 2
    *
    * ________________________________________________________________________________________
    *0|---(0s)---(low-1)|low---(1s)---(mid-1)|mid---(unsorted)---(high-1)|high---(2s)---(n-1)|
    *
    *
    * Algorithm :
    *       1) Initialize 3 variables low = 0, mid=0, high=n-1
    *       2) Run a loop while mid <= high and follow below steps
    *
                    a[mid] == 0 ==> swap(a[mid],a[low])
                                low++
                                mid++;

                    a[mid] == 1 ==> mid++;

                    a[mid] == 2 ==> swap(a[mid],a[high])
                                    high--;
    *
    *
    * */
    public static void main(String[] args) {
        int [] arr = {0,1,1,0,1,2,1,2,0,0,0};
        B_SortColors_Seperate_0_1_2 test = new B_SortColors_Seperate_0_1_2();
        test.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sortColors(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length-1;

        while(mid <= high){
            //a[mid] == 0 ==> swap(a[mid],a[low])
            //low++
            //mid++

            if(arr[mid] == 0){
                swap(arr,mid,low);
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else{
                swap(arr,high,mid);
                high--;
            }
        }
    }

    public void swap(int [] arr,int no,int no2){
        int temp = arr[no];
        arr[no] = arr[no2];
        arr[no2] = temp;
    }
}
