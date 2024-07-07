package k_recursion.Z_extra;


/*
*
* 1. Decision : each board[row][column] ∈ [1,9]
* 2. Constraint : each row,column and sub board has different value
*                 Same no should not be there in same row
*                 Same no should not be there in same column
*                 Same no should not be there in same grid(3*3)
*
* 3. End goal : Fill every cell.
*
*
* */

public class F_SolveSudoku {

    private int[][] board;
    private final int BOARD_SIZE = 9;
    private final int EMPTY_CELL = 0;

    public F_SolveSudoku(int[][] board) {
        this.board = board;
    }

    public boolean solve() {
        int row = 0;
        int col = 0;
        boolean emptyCellFound = false;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    row = i;
                    col = j;
                    emptyCellFound = true;
                    break;
                }
            }
            if (emptyCellFound) {
                break;
            }
        }

        if (!emptyCellFound) {
            return true; // puzzle solved
        }



        for (int num = 1; num <= BOARD_SIZE; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (solve()) {
                    return true;
                }
                board[row][col] = EMPTY_CELL; // backtrack
            }
        }

        return false; // puzzle unsolvable
    }

    private boolean isValid(int row, int col, int num) {
        // check row
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // check column
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // check subgrid
        int subgridRow = (row / 3) * 3;
        int subgridCol = (col / 3) * 3;
        for (int i = subgridRow; i < subgridRow + 3; i++) {
            for (int j = subgridCol; j < subgridCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }


    private void printSudoku(int[][] sudokuMatrix) {
        for (int i = 0; i < sudokuMatrix.length; i++) {
            for (int j = 0; j < sudokuMatrix[0].length; j++) {
                System.out.print(sudokuMatrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [] [] sudokuMatrix = new int[9][9];
        fillInitialNos(sudokuMatrix);
        F_SolveSudoku test = new F_SolveSudoku(sudokuMatrix);



        System.out.println("#################  Before  ############");
        test.printSudoku(sudokuMatrix);

        test.solve();
        System.out.println("#################  After iterative  ############");
        test.printSudoku(sudokuMatrix);

    }



    private static void fillInitialNos(int[][] sudokuMatrix) {
        sudokuMatrix[0]= new int[]{5,3,0,0,0,0,0,0,0};
        sudokuMatrix[1]= new int[]{6,0,0,1,9,5,0,0,0};
        sudokuMatrix[2]= new int[]{0,9,8,0,0,0,0,6,0};
        sudokuMatrix[3]= new int[]{8,0,0,0,6,0,0,0,3};
        sudokuMatrix[4]= new int[]{4,0,0,8,0,3,0,0,1};
        sudokuMatrix[5]= new int[]{7,0,0,0,2,0,0,0,6};
        sudokuMatrix[6]= new int[]{0,6,0,0,0,0,2,8,0};
        sudokuMatrix[7]= new int[]{0,0,0,4,1,9,0,0,5};
        sudokuMatrix[8]= new int[]{0,0,0,0,8,0,0,7,9};



    }
}
