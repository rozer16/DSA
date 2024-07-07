package n_graph.B_BFS_DFS_Problems;

public class F_SurroundedRegions_ReplaceOwithX {


    public static void dfs(int row, int col, char [][] matrix, boolean [][] visited, int [] delRow, int [] delCol){
        visited[row][col] = true;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < 4; i++) {
           int nRow = row + delRow[i];
           int nCol = col + delCol[i];

           if(nRow >= 0 && nRow < rows && nCol >=0 && nCol < cols && matrix[nRow][nCol] == 'O' && !visited[nRow][nCol] )
               dfs(nRow,nCol,matrix,visited,delRow,delCol);
        }
    }

    static char[][] fill(char board[][]){

        int [] delRow = new int[]{-1,0,1,0};
        int [] delCol = new int[]{0,1,0,-1};

        int n = board.length;
        int m = board[0].length;
        boolean [] [] visited = new boolean[n][m];

        //First row and last row
        for (int i = 0; i < m; i++) {
            if(board[0][i] == 'O' && !visited[0][i])
                dfs(0,i,board,visited,delRow,delCol);

            if(board[n-1][i] == 'O' && !visited[n-1][i])
                dfs(n-1,i,board,visited,delRow,delCol);
        }

        //First col and last col
        for (int i = 0; i < n; i++) {
            if(board[i][0] == 'O' && !visited[i][0])
                dfs(i,0,board,visited,delRow,delCol);

            if(board[i][m-1] == 'O' && !visited[i][m-1])
                dfs(i,m-1,board,visited,delRow,delCol);
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';

            }
        }
        return board;
    }

    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};


        /*
        *
            X	X	X	X
            X	X	X	X
            X	X	X	X
            X	X	X	X
            X	X	O	O
        * */
        //First row and last row
      char [][] ans = fill(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(ans[i][j] +"\t");
            }
            System.out.println();
        }

    }
}
