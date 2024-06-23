package j_recursion.K_Sudoku;

public class SudokuSolver {
    public static boolean solveSudoku(char[][] board) {
        //We will traverse row by row and left to right.

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // When we find an empty cell, we pause and try to put all available numbers(1 – 9) in that particular empty cell.
                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {
                        //Check if current c is valid
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solveSudoku(board))
                                return true;
                            else
                                board[i][j] = '.'; //Backtrack, reverse the value since current loop didn't work.
                            //Since some of next empty cells didnt work
                            //try next no from loop
                        }
                    }
                    ///since any no(1-9) didn't work and above true condition was never executed,
                    // will have to revert previous cells and try with other possibilities.
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;

            if (board[row][i] == c)
                return false;
             //– the expression (3 * (row / 3) + i / 3) evaluates to the row numbers of that 3×3 submatrix and
            //  the expression (3 * (col / 3) + i % 3) evaluates to the column numbers of that 3×3 submatrix .
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}
