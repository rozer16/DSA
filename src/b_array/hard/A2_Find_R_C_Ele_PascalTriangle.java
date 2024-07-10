package b_array.hard;

import java.util.ArrayList;
import java.util.List;

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
public class A2_Find_R_C_Ele_PascalTriangle {
    public static void main(String[] args) {
        A2_Find_R_C_Ele_PascalTriangle test = new A2_Find_R_C_Ele_PascalTriangle();
        int r = 5;
        int c = 3;
        System.out.println(test.findValueOfRCFromPascalTriangle(1,1)); // 1
        System.out.println(test.findValueOfRCFromPascalTriangle(2,2)); // 1
        System.out.println(test.findValueOfRCFromPascalTriangle(5,3)); // 6
        System.out.println(test.findValueOfRCFromPascalTriangle(6,4)); // 10
    }


    /*
            Time Complexity: O(n2), where n = number of rows(given).
        Reason: We are generating a row for each single row. The number of rows is n. And generating an entire row takes O(n) time complexity.

        Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can still be considered as O(1).
    * */
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); //inserting the 1st element

        //calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalFullTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        //store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }




    //Find value of specific element at row column
    /*
            Time Complexity: O(c), where c = given column number.
        Reason: We are running a loop for r times, where r is c-1.

        Space Complexity: O(1) as we are not using any extra space.
    * */
    public int findValueOfRCFromPascalTriangle(int row,int col){
        row = row-1;
        col = col-1;
        return findNcR(row,col);
    }


    //Given the row number n. Print the n-th row of Pascal’s triangle.
    /*
        Time Complexity: O(n*r), where n is the given row number, and r is the column index which can vary from 0 to n-1.
    Reason: We are calculating the element for each column. Now, there are total n columns, and for each column, the calculation of the element takes O(r) time where r is the column index.

    Space Complexity: O(1) as we are not using any extra space.
    * */
    public void pascalTriangle(int n) {
        // printing the entire row n:
        for (int c = 1; c <= n; c++) {
            System.out.print(findNcR(n - 1, c - 1) + " ");
        }
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
