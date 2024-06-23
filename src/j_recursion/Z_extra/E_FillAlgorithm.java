package j_recursion.Z_extra;


import java.util.Arrays;

/*

You are given a 2D grid map of '.'(Land) and '#'(Water)
An island is formed by connecting adjucent lan cells horizontally or vertically and is surronded by water
Find the no of island and max no of cells of one island

. # . # # .
# . . # . .
# . # . . #
# . . # # .
. . # . . .


Approach :

1) Iterate through each element cell by cell in in 1st, 2nd
like (0,0),(0,1),(0,m)...(1,0),(1,1)...(1,m)...(n,1)(n,2)...(n,m)

2) if cell is filled with '.' then increase noOfIsland
mark visited[i][j] as visited
call recursive function to check if its neighbour is land cell
if neighbour is land cell then increase no of cells and mark it visited.
if currentNoOfCell is greater than maxNoOfCell them set maxNoOfCell=currentNoOfCell

3) Return no of island


4) checkIfNeighbourIsLand
/// (row, col) --> Up: (row - 1, col), Right: (row, col + 1), Down: (row + 1, col), Left: (row, col - 1)
px={-1,0,1,0}
py={0,1,0,-1}



 . . .
* */
public class E_FillAlgorithm {
    boolean [][] visited = new boolean[5000][5000];
    char [][] matrix ;
    int [] dx ={-1,0,1,0};
    int [] dy ={0,1,0,-1};
    int islandsCnt;
    int currentCellCount;
    int maxislandCellCnt;


    /*
    * TP : O(n*m)
    * SP : O(n*m)
    * */


    public static void main(String[] args) {
        E_FillAlgorithm test = new E_FillAlgorithm();
        test.matrix = new char[5][6];
        test.matrix[0]= new char[]{'.', '#', '.', '#', '#', '.'};
        test.matrix[1]= new char[]{'#', '.', '.', '#', '.', '.'};
        test.matrix[2]= new char[]{'#', '.', '#', '.', '.', '#'};
        test.matrix[3]= new char[]{'#', '.', '.', '#', '#', '.'};
        test.matrix[4]= new char[]{'.', '.', '#', '.', '.', '.'};

        System.out.println(Arrays.toString(test.fillAlgorithm(test.matrix)));
    }

    public int [] fillAlgorithm(char [][] matrix){
        int [] result = new int[2];
        int n=matrix.length;
        int m = matrix[0].length;

        //Iterate through each element cell by cell in in 1st, 2nd
        //like (0,0),(0,1),(0,m)...(1,0),(1,1)...(1,m)...(n,1)(n,2)...(n,m)
        for(int row =0; row < n; row++)
            for(int col = 0; col < m; col++)


                //check if this cell is valid(Not crossing matrix boundries and not visited land cell)
                if(isValidLandCell(row, col, n, m)) {
                    islandsCnt++;
                    currentCellCount = 0;
                    findIslandAndMaxCells(row, col, n, m);
                    maxislandCellCnt = Math.max(maxislandCellCnt, currentCellCount);
                }
        result[0] = islandsCnt;
        result[1] = maxislandCellCnt;
        return result;
    }
    public void findIslandAndMaxCells(int row, int col,int rowSize, int colSize){
        visited[row][col] = true;
        currentCellCount++;
        //Base condition : when no neighbour island is land cell
        for(int i=0;i<4;i++){
            if(isValidLandCell(dx[i]+row, dy[i]+col,rowSize,colSize)){
                findIslandAndMaxCells(dx[i]+row, dy[i]+col,rowSize,colSize);
            }
        }
    }

    public boolean isValidLandCell(int row,int col,int rowSize, int colSize){
        if(row <0 || col < 0 || row > rowSize-1 || col > colSize-1)
            return false;

        if(matrix[row][col] == '#' || visited[row][col])
            return false;

        return true;
    }
}
