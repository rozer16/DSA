package j_recursion.Z_extra;


import java.util.ArrayList;
import java.util.List;

/*
* N-Queens
*
* N*N Chessboards
* N Queens
* Print all solutions where queens are safe
*
*
* */
public class G_N_Queens_Problem {

    public static void main(String[] args) {
        G_N_Queens_Problem test = new G_N_Queens_Problem();
        System.out.println(test.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n){
        List<List<String>> allboards = new ArrayList<>();
        char [][] board = new char[n][n];
        backtracking(board,allboards,0);
        return allboards;
    }

    public void backtracking(char [][] board,List<List<String>> allboards,int col){
        if(col == board.length){
            saveBoard(board,allboards);
            return;
        }
            
        for (int row = 0; row < board.length; row++) {
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                backtracking(board,allboards,col+1);
                board[row][col] = '.'; //backtrack
            }
        }
    }

    private void saveBoard(char[][] board, List<List<String>> allboards) {
        String row = "";
        List<String> board1 = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            row="";
            for (int j = 0; j < board[0].length; j++) {
                row += board[i][j] == 'Q' ? 'Q':'.';
            }
            board1.add(row);
        }
        allboards.add(board1);
    }

    private boolean isSafe(char[][] board, int row, int col) {

        //Horizontal
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == 'Q')
                return false;
        }

        //Vertical
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == 'Q')
                return false;
        }



        //Upper left corner
        int row1 = row-1;
        int col1 = col-1;
        while(row1 >= 0 && col1 >= 0){
            if(board[row1][col1] == 'Q') {
                return false;
            }
            row1--;
            col1--;
        }


        //Upper right corner
        row1 = row-1;
        col1 = col+1;
        while(row1 >= 0 && col1 <= board.length-1){
            if(board[row1][col1] == 'Q') {
                return false;
            }
            row1--;
            col1++;
        }


        //Lower left corner
        row1 = row+1;
        col1 = col-1;
        while(row1 <= board.length-1 && col1 >= 0){
            if(board[row1][col1] == 'Q') {
                return false;
            }
            row1++;
            col1--;
        }


        //Lower right corner
        row1 = row+1;
        col1 = col+1;
        while(row1 <= board.length-1 && col1 <= board.length-1){
            if(board[row1][col1] == 'Q') {
                return false;
            }
            row1++;
            col1++;
        }
        //System.out.println("Checked lower right corner...returning true");
        return true;
    }
}
