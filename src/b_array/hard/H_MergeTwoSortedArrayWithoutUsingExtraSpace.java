package b_array.hard;


import java.util.Arrays;

/*
https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
https://youtu.be/n7uwj04E0I4
https://leetcode.com/problems/merge-sorted-array/description/
* */
public class H_MergeTwoSortedArrayWithoutUsingExtraSpace {


        /*
        We can start with two pointers i and j, initialized to m-1 and n-1, respectively.
    We will also have another pointer k initialized to m+n-1,
    which will be used to keep track of the position in nums1 where we will be placing the larger element.
    Then we can start iterating from the end of the arrays i and j, and compare the elements at these positions.
    We will place the larger element in nums1 at position k, and decrement the corresponding pointer i or j accordingly.
    We will continue doing this until we have iterated through all the elements in nums2.
    If there are still elements left in nums1, we don't need to do anything because they are already in their correct place.

    Complexity
    Time complexity: O(m+n)
    We are iterating through both arrays once, so the time complexity is O(m+n).

    Space complexity: O(1)
    We are not using any extra space, so the space complexity is O(1).


        * */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;


        while(j>= 0){
            if(i>=0 && nums2[j] <= nums1[i]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }

    }


    /*
        Time Complexity: O((n+m)*log(n+m)), where n and m are the sizes of the given arrays.
        Reason: The gap is ranging from n+m to 1 and every time the gap gets divided by 2.
        So, the time complexity of the outer loop will be O(log(n+m)).
        Now, for each value of the gap, the inner loop can at most run for (n+m) times.
        So, the time complexity of the inner loop will be O(n+m).
        So, the overall time complexity will be O((n+m)*log(n+m)).

Space Complexity: O(1) as we are not using any extra space.
    * */
    void merge(long[] arr1, long[] arr2, int n, int m) {

        // len of the imaginary single array:
        int len = n + m;

        // Initial gap: orr to get ceiling
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
    }


    //shell short


    public void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }



    //If array are given like this

    // long[] arr1 = {1, 4, 8, 10};
    //        long[] arr2 = {2, 3, 9};
    public static void merge1(long[] arr1, long[] arr2, int n, int m) {

        // Declare 2 pointers:
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is
        // smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
