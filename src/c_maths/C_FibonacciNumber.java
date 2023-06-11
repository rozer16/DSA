package c_maths;

import java.util.Arrays;

public class C_FibonacciNumber {

    public  static int getNthFibonacciNo(int n){
        if(n<0)
            return -1;
        if(n ==1 )
            return 0;
        if(n==2)
            return 1;
        int [] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2;i<n;i++ ){
            arr[i]= arr[i-1]+arr[i-2];
        }
        System.out.println(Arrays.toString(arr));
        return arr[n-1];
    }

    public static void main(String[] args) {
        System.out.println(getNthFibonacciNo(10));
    }
}
