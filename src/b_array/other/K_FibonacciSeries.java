package b_array.other;

import java.util.Arrays;

public class K_FibonacciSeries {

    private int getRecursiveFibonacci(int n){

        if( n <= 1)
            return n;

        // 5 : 3,4; 4:3,2; 3:2,1 1:1,0 0:0
        return getRecursiveFibonacci(n-1)+getRecursiveFibonacci(n-2);
    }

    private int getIterativeFibonacci(int n){

        int [] series = new int[n+1];


        if(n == 1)
            return 0;
        if(n == 2)
            return 1;

        series[0] = 0;
        series[1] = 1;
        int prev = 0;
        int current = 1;

        while((current+1) <= n){
            series[current+1] = series[prev++]+series[current];
            current++;

        }
        // 0 1 1 2 3 5
        System.out.println(Arrays.toString(series));
        return series[current];
    }
    public static void main(String[] args) {
        K_FibonacciSeries f = new K_FibonacciSeries();
        System.out.println(f.getIterativeFibonacci(10));
        System.out.println(f.getRecursiveFibonacci(10));
    }
}
