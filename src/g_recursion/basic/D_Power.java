package g_recursion.basic;

/*
*https://leetcode.com/problems/powx-n/solutions/
* Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
*
* Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*
*
* Complexity : O(log base 2 N)
*
* */
public class D_Power {

    public static void main(String[] args) {
        //System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(2.00000, 10));
       //System.out.println(myPow(2.00000, -2));
    }
    public static double myPow(double x, int n) {
        // If x^0 return 1
        // If x^0 return 1
        if (n == 0)
            return 1;
        if(n==1)
            return x;
        // If we need to find of 0^y
        if (x == 0)
            return 0;

        // Convert n to a long integer to handle the edge case with Integer.MIN_VALUE
        long N = n;

        // If n is negative, take the reciprocal of x and make N positive
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        // For all other cases

        // solution. The idea is simple. (high school math). x8 = (x2)4
        if(n %2 == 0 )
            return myPow(x*x, (int)(N/2));
        else
            return x * myPow(x,(int)(N-1));


    }
}
