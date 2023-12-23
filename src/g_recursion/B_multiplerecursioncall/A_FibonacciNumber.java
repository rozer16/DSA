package g_recursion.B_multiplerecursioncall;

import java.util.Arrays;
import java.util.Date;


/*
* Fibonacci series starts with 0 1 1 2 3 5 8 12
*
*   f(5) = f(4) + f(3)
* */
public class A_FibonacciNumber {


    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(iterativeNthFibonacciNo(50));
        System.out.println(new Date());
        System.out.println(recursiveNthFibonacciNo(49));
        System.out.println(new Date());
    }


    //TC :  nearly O(n*n)
//https://www.youtube.com/watch?v=kvRjNm4rVBE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=5
    public static long recursiveNthFibonacciNo(int n){
        if(n<= 1)
            return n;

        return ((long)recursiveNthFibonacciNo(n-1))+((long)recursiveNthFibonacciNo(n-2));
    }

    public  static long iterativeNthFibonacciNo(int n){
        String s = "abc";

        if(n<0)
            return -1;
        if(n ==1 )
            return 0;
        if(n==2)
            return 1;
        long [] arr = new long[n];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2;i<n;i++ ){
            arr[i]= arr[i-1]+arr[i-2];
        }
        System.out.println(Arrays.toString(arr));
        return arr[n-1];
    }


}
