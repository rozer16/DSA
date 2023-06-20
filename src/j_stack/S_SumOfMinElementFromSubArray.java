package j_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
* https://leetcode.com/problems/sum-of-subarray-minimums/
*
* Given an array of integers arr, find the sum of min(b),
* where b ranges over every (contiguous) subarray of arr.
*  Since the answer may be large, return the answer modulo 10^9 + 7.


 *
* */
public class S_SumOfMinElementFromSubArray {


    public static void main(String[] args) {
        S_SumOfMinElementFromSubArray test = new S_SumOfMinElementFromSubArray();
        int arr [] = {3,1,2,4};
        int arr1[] = {71,55,82,55};
        System.out.println(test.sumSubarrayMins(arr));
    }

    class Pair{
        int element;
        int numMin;

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


    public int sumSubarrayMins(int[] arr) {
        int left [] = new int[arr.length];
        int right [] = new int[arr.length];
        long sum = 0;
        Deque<Pair> leftS = new ArrayDeque<>();
        Deque<Pair> rightS = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            while(!leftS.isEmpty() && leftS.peek().getElement() > arr[i])
                count += leftS.pop().getNumMin();

            leftS.push(new Pair(arr[i],count));
            left[i] = count;

        }


        for (int i = arr.length-1; i >= 0 ; i--) {
            int count = 1;
            while(!rightS.isEmpty() && rightS.peek().getElement() >= arr[i])
                count += rightS.pop().getNumMin();

            rightS.push(new Pair(arr[i],count));
            right[i] = count;

        }
        long m = (int)Math.pow(10,9)+7;
        for (int i = 0; i < arr.length; i++) {
            sum = (sum+(long)left[i]*right[i]*arr[i] )% m;
        }
        return (int)sum;
    }
}
