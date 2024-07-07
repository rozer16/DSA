package c_binarysearch.B_BS_on_answers;


/*
https://takeuforward.org/binary-search/finding-sqrt-of-a-number-using-binary-search/
https://www.youtube.com/watch?v=Bsv3FPUX_BA
https://www.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root


Finding Sqrt of a number using Binary Search

Problem Statement: You are given a positive integer n.
 Your task is to find and return its square root.
 If ‘n’ is not a perfect square, then return the floor value of 'sqrt(n)'.


Example 1:
Input Format:
 n = 36
Result:
 6
Explanation:
 6 is the square root of 36.

Example 2:
Input Format:
 n = 28
Result:
 5
Explanation:
 Square root of 28 is approximately 5.292. So, the floor value will be 5.
* */
public class A_FindingSqrtOfNumber {

    public static void main(String[] args) {
        A_FindingSqrtOfNumber sol = new A_FindingSqrtOfNumber();
        System.out.println(sol.floorSqrt(36)); //6
        System.out.println(sol.floorSqrt(28)); //5
        System.out.println(sol.floorSqrt(45)); //6
    }
    long floorSqrt(long x){
        long low = 1;
        long high = x;

        long ans = 1;

        while(low <= high){

            long mid = low + (high-low)/2;
            //If mid * mid <= x the store x into ans
            if(mid * mid <= x){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

}
