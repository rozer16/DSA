package c_binarysearch.A_BS_on_1d;


/*
https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/

https://www.geeksforgeeks.org/problems/rotation4723/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotation

https://www.youtube.com/watch?v=jtSiWTPLwd0



Given an ascending sorted rotated array arr of distinct integers of size n. The array is right-rotated k times. Find the value of k.

Example 1:

Input:
n = 5
arr[] = {5, 1, 2, 3, 4}
Output: 1
Explanation: The given array is 5 1 2 3 4.
The original sorted array is 1 2 3 4 5.
We can see that the array was rotated
1 times to the right.
Example 2:

Input:
n = 5
arr[] = {1, 2, 3, 4, 5}
Output: 0
Explanation: The given array is not rotated.
Your Task:
Complete the function findKRotation() which takes array arr and size n, as input parameters and returns an integer representing the answer. You don't have to print answers or take inputs.

Expected Time Complexity: O(log(n))
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <=105
1 <= arri <= 107
* */
public class J_HowManyTimesArrayRotated {

    public static void main(String[] args) {
        int [] arr = {5,5,6,7,1,2,3,4,5,5,5};
        J_HowManyTimesArrayRotated sol = new J_HowManyTimesArrayRotated();
        System.out.println(sol.findKRotation(arr, arr.length));
    }

    int findKRotation(int arr[], int n) {
        int len = arr.length;
        int low = 0;
        int high = len-1;
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        while(low <= high){




            int mid = low + (high-low)/2;

            //6 7 1 2 3 4 4 5 --> Works since we can check if left is sorted or half is sorted : 6<2 false so left is unsorted
            //6 7 1 2 3 3 4 4 4 --> Works since we can check if left is sorted or half is sorted : 6<2 false so left is unsorted
            // 3 1 2 3 3 3 3 --> This doesnt work for finding which one is sorted so we will have to shring from left and right.
            // if we are trying to find exact that element then it will be found from middle.
            ////Edge case:

            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }

            //If array is already sorted and not rotated
            if(arr[low] <= arr[high]){
                if(minValue > arr[low]){
                    minValue = arr[low];
                    minIndex = low;

                }

                return minIndex;

            }

            //If array is rotated, either left half will be sorted or. right half will be sorted
            //If left half is sorted then take arr[low] and check if in right half any ele less than arr[low] exists
            if(arr[low] <= arr[mid]){
                if(arr[low] < minValue){
                    minValue = arr[low];
                    minIndex = low;
                }
                low = mid+1;
            }else{
                //If right half is sorted then take arr[mid] and check if in left half any ele less than arr[mid] exists
                if(arr[mid] < minValue){
                    minIndex = mid;
                    minValue = arr[mid];
                }
                high = mid-1;
            }
        }

        return minIndex;
    }


}
