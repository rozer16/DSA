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
*/
public class A4_PrintPascalTriangle {


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
}
