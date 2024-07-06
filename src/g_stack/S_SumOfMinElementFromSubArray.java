package g_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/sum-of-subarray-minimums/
https://www.youtube.com/watch?v=Ulb3ixSpE4Y
*
* Given an array of integers arr, find the sum of min(b),
* where b ranges over every (contiguous) subarray of arr.
*  Since the answer may be large, return the answer modulo 10^9 + 7.
*
*
Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

*
*
*
* Hint : If we know how many times a element will occur in subarray
*       Get count, a specific element will be minimum in all subarray
*       To get count, we will use stack having pairs(element, count)
                    to get count in how many subarray this will be smaller element
*       left[] = Element from i to 0(left part of i) : if specific element from left index of i
*                                                       is less than current ith element,
*       right[] = Element from i to n-1 : : if specific element from right index of i
*                                                       is less than current ith element,


 arr = 3 1 2 4
 left= 1 2 1 1
 right=1 3 2 1


 consider left = m, right = n
 total no of subarray  : (m+n-1)(m+n) /2
 total no of subarray on left = (m-1)m/2
 to get no of subarray on right: (n-1)n/2

 total no of sub array = (m+n-1)(m+n) /2 +  (m-1)m/2 +  (n-1)n/2 = mn

* */
public class S_SumOfMinElementFromSubArray {


    public static void main(String[] args) {
        S_SumOfMinElementFromSubArray test = new S_SumOfMinElementFromSubArray();
        int arr [] = {3,1,2,4};
        int arr1[] = {71,55,82,55};
        System.out.println(test.sumSubarrayMins(arr));
    }

    public int sumSubarrayMins(int[] arr) {
        int left [] = new int[arr.length];
        int right [] = new int[arr.length];
        long sum = 0;
        Deque<Pair> leftS = new ArrayDeque<>();
        Deque<Pair> rightS = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            //if arr[i] is less than top of stack
            // (Meaning current element is smaller and will occur as smaller element in subarray)
            // then add it to count,
            while(!leftS.isEmpty() && leftS.peek().getElement() > arr[i])
                count += leftS.pop().getNumMin();

            leftS.push(new Pair(arr[i],count));
            //Store no of occurrences for arr[i] in left[i]
            left[i] = count;

        }


        for (int i = arr.length-1; i >= 0 ; i--) {
            int count = 1;
            while(!rightS.isEmpty() && rightS.peek().getElement() >= arr[i])
                count += rightS.pop().getNumMin();

            rightS.push(new Pair(arr[i],count));
            right[i] = count;

        }
        //To count how many times a specific element occurred , left[i]*right[i]
        long m = (int)Math.pow(10,9)+7;
        for (int i = 0; i < arr.length; i++) {
            //If element has occurred n times then sum of it ele*n
            //Doing modulo m since in question its said :  answer may be large, return the answer modulo 10^9 + 7.

            sum = (sum+(long)left[i]*right[i]*arr[i] )% m;
        }
        return (int)sum;
    }

    class Pair{
        int element;
        int numMin; // No of times its min

        public Pair(int element, int numMin) {
            this.element = element;
            this.numMin = numMin;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public int getNumMin() {
            return numMin;
        }

        public void setNumMin(int numMin) {
            this.numMin = numMin;
        }
    }

}
