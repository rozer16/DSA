package b_array.medium.hard;


import java.util.Arrays;

/*
* https://youtu.be/bR7mQgwQ_o8
*
* Pascal's triangle
*
Row 1           1
Row 2         1   1
Row 3       1   2   1
Row 4     1   3   3   1
Row 5    1  4   6   4   1
Row 6  1   5  10  10  5   1

*
*   * Starts and ends with 1
*   * current element sum would corner of above two element
*   * For n = 2 ==> 1 1
*   * for n = 6 ==> 1   5   10  10  5   1
*

*
*
*/
public class B_PrintNthRowFromPascalTriangle {


    public static void main(String[] args) {
        B_PrintNthRowFromPascalTriangle test = new B_PrintNthRowFromPascalTriangle();
        int [] arr = test.getNthRowFromPascalTriangle(6);
        System.out.println(Arrays.toString(arr));
    }

/*
*
*   TC : O(n)
*   SC : O(n)
    Observation :
     *
     *       [0] = 1  ==> 1
     *       [1] = 5  ==> col=2 & row = 6 ==> 5C1 ==> 5!/(4!*1!) ==> 5/1 ==> 1
     *       [2] = 10 ==> col=3 & row = 6 ==> 5C2 ==> 5!/(3!*2!) ==> 5*4/2*1 ==> 10
     *       [3] = 10 ==> col=4 & row = 6 ==> 5C3 ==> 5!/2!*3!   ==> 5*4*3/3 ==> 10
     *       [4] = 5  ==> col=5 & row = 6 ==> 5C4 ==> 5!/1!*4!   ==> 10(2/4) ==> 5
     *       [5] = 1  ==> col=6 & row = 6 ==> 5C5 ==> 1
     *

     *   ==> If we start with column with 0th index and first and last element will always be 1
     *   ==> [0] = 1  ==> 1
     *       [1] = 5  ==> col=1 & row = 6 ==> result[col-1]*(row-col)/col   ==> 1*(5/1) ==> 5
     *       [2] = 10 ==> col=2 & row = 6 ==> result[col-1]*(row-col)/col   ==> 5(4/2) ==> 10
     *       [3] = 10 ==> col=3 & row = 6 ==> result[col-1]*(row-col)/col   ==> 10(3/3) ==> 10
     *       [4] = 5  ==> col=4 & row = 6 ==> result[col-1]*(row-col)/col   ==> 10(2/4) ==> 5
     *       [5] = 1  ==> col=5 & row = 6 ==> result[col-1]*(row-col)/col   ==> 10(1/5) ==> 1
     *
    *
*
* */
    private int[] getNthRowFromPascalTriangle(int n) {
        int [] result = new int[n];
        result[0] =1;
        for (int i = 1; i < n; i++) {
           long temp = (int)(1l*result[i-1]*(n-i));
            result[i] = (int)temp/i;
        }

        return result;
    }

    /*
    *
    * Bruteforce
    * TC : O(n*r)
    * */
    private int[] getNthRowFromPascalTriangle1(int n) {
        int [] result = new int[n];
        for (int i = 1; i <= n; i++) {
            result[i-1] = findNcR(n-1,i-1);
        }


        return result;
    }

    public int findNcR(int N,int R){
        int result = 1;
        for (int i = 0; i < R; i++) {
            result = result * (N-i);
            result = result / (i+1);
        }
        return result;
    }
}
