package b_array.hard;

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
*   * for r=5, c = 3 , answer = 6
*
*
* Formula to use NcR  = N!/R!*(N-R)!
*       N = r-1 ==> 4
*       R = c-1 ==> 2
*
*   4c2 ==> 4!/2!*(4-2)!

*
* Lets say N = 10, R = 3
*       ==> N! / R!*(N-R)!
*       ==> 10! / 3!*7*
*       ==>10*9*8*(7*6*5*4*3*2*1)/(3*2*1)*(7*6*5*4*3*2*1)
*       ==>10*9*8/(3*2*1)
*       ==>10*9*8/1*2*3
*
* */
public class A_Find_R_C_Ele_PascalTriangle {
    public static void main(String[] args) {
        A_Find_R_C_Ele_PascalTriangle test = new A_Find_R_C_Ele_PascalTriangle();
        int r = 5;
        int c = 3;
        System.out.println(test.findValueOfRCFromPascalTriangle(1,1)); // 1
        System.out.println(test.findValueOfRCFromPascalTriangle(2,2)); // 1
        System.out.println(test.findValueOfRCFromPascalTriangle(5,3)); // 6
        System.out.println(test.findValueOfRCFromPascalTriangle(6,4)); // 10
    }

    public int findValueOfRCFromPascalTriangle(int row,int col){
        row = row-1;
        col = col-1;
        return findNcR(row,col);


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
