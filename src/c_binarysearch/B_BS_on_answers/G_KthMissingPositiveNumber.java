package c_binarysearch.B_BS_on_answers;

/*
https://takeuforward.org/arrays/kth-missing-positive-number/

https://www.youtube.com/watch?v=uZ0N_hZpyps


https://leetcode.com/problems/kth-missing-positive-number/description/

Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.



Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...].
The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
* */
public class G_KthMissingPositiveNumber {

    public static void main(String[] args) {

    }


    /*
        We are going to use the Binary Search algorithm to optimize the approach.

        The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

        We cannot apply binary search on the answer space here as we cannot assure which missing number has the possibility of being the kth missing number. That is why, we will do something different here. We will try to find the closest neighbors (i.e. Present in the array) for the kth missing number by counting the number of missing numbers for each element in the given array.

        Let’s understand it using an example. Assume the given array is {2, 3, 4, 7, 11}. Now, if no numbers were missing the given array would look like {1, 2, 3, 4, 5}. Comparing these 2 arrays, we can conclude the following:


        arr  : 2 3 4 7 11
        index: 1 2 3 4 5 6 7 8 9 10 11
        missing 1 5 6 8 9 10 11
        Up to index 0: Only 1 number i.e. 1 is missing in the given array.
        Up to index 1: Only 1 number i.e. 1 is missing in the given array.
        Up to index 2: Only 1 number i.e. 1 is missing in the given array.
        Up to index 3: 3 numbers i.e. 1, 5, and 6 are missing.
        Up to index 4: 6 numbers i.e. 1, 5, 6, 8, 9, and 10 are missing.
        For a given value of k as 5, we can determine that the answer falls within the range of 7 to 11. Since there are only 3 missing numbers up to index 3, the 5th missing number cannot be before vec[3], which is 7. Therefore, it must be located somewhere to the right of 7. Our actual answer i.e. 9 also supports this theory. So, by following this process we can find the closest neighbors (i.e. Present in the array) for the kth missing number. In our example, the closest neighbors of the 5th missing number are 7 and 11.

        How to calculate the number of missing numbers for any index i?

        From the above example, we can derive a formula to find the number of missing numbers before any array index, i. The formula is
        Number of missing numbers up to index i = vec[i] - (i+1).
        The given array, vec, is currently containing the number vec[i] whereas it should contain (i+1) if no numbers were missing. The difference between the current and the ideal element will give the result.

        How to apply Binary Search?

        We will apply binary search on the indices of the given array.
         For each index, we will calculate the number of missing numbers and based on it, we will try to eliminate the halves.

        How we will get the answer after all these steps?

        After completing the binary search on the indices,
        the pointer high will point to the closest neighbor(present in the array) that is smaller than the kth missing number.

        So, in the given array, the preceding neighbor of the kth missing number is vec[high].
        Now, we know, up to index ‘high’,
        the number of missing numbers = vec[high] - (high+1).
        But we want to go further and find the kth number. To extend our objective, we aim to find the kth number in the sequence. In order to determine the number of additional missing values required to reach the kth position, we can calculate this as
        more_missing_numbers = k - (vec[high] - (high+1)).
        Now, we will simply add more_missing_numbers to the preceding neighbor i.e. vec[high] to get the kth missing number.
        kth missing number = vec[high] + k - (vec[high] - (high+1))
                =  vec[high] + k - vec[high] + high + 1
                = k + high + 1.
        Note: Please make sure to refer to the video and try out some test cases of your own to understand, how the pointer ‘high’ will be always pointing to the preceding closest neighbor in this case.

        Algorithm:
        Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to index 0 and the high will point to index n-1 i.e. the last index.
        Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
        mid = (low+high) // 2 ( ‘//’ refers to integer division)
        Eliminate the halves based on the number of missing numbers up to index ‘mid’:
        We will calculate the number of missing numbers using the above-said formula like this: missing_numbers = vec[mid] - (mid+1).
        If missing_numbers < k: On satisfying this condition, we can conclude that we are currently at a smaller index. But we want a larger index. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
        Otherwise, we have to consider smaller indices. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
        Finally, when we are outside the loop, we will return the value of (k+high+1) i.e. the kth missing number.
        The steps from 2-3 will be inside a loop and the loop will continue until low crosses high.


    * */
    public int findKthPositive(int[] arr, int k) {
        //We will be playing on index and our goal is find
        // 2 3 4 7 11 //arr & k =5
        // 1 2 3 4 5 //Expected
        // 1 1 1 3 6 //how many no missing till that index
        int low = 0;
        int high = arr.length-1;

        //Do binary search until low and high are crossed so low reaches to index where missing is greater than k
        //After while loop completion low = high +1
        //In above e.g. low = 4, high =3
        while(low <= high){
            int mid = low + (high-low)/2;
            int noOfMissing = arr[mid] - (mid+1);

            if(noOfMissing < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        //1.  the number of missing numbers at high index = arr[high] - (high+1).  //At index 3 , 3 nos are missing
        //2.  more_missing_numbers at high index = k - (arr[high] - (high+1)). //More missing no k=5, 5-3=2
        //3.  kth missing number = arr[high] + more //why arr[high]  ???
        //                       = arr[high] + k - (arr[high] - (high+1))
        //                       = arr[high] + k - arr[high] + high + 1
        //                       = k + high + 1.
        return k + high + 1;
    }
    //TC : O(n)
    public int findKthPositive1(int[] arr, int k) {


        //If vec[i] <= k: we will simply increase the value of k by 1.
        //The main idea is to shift k by 1 step if the current element is smaller or equal to k.
        // And whenever we get a number > k, we can conclude that k is the missing number.

        int ans = k;
        int index = 0;
        while(index < arr.length){
            if(arr[index] <= ans){
                ans++;
                index++;
            }else{
                break;
            }
        }
        return ans;
    }
}
