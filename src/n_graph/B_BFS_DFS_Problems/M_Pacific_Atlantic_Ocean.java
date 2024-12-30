package n_graph.B_BFS_DFS_Problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/pacific-atlantic-water-flow/description/

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.



Intuition
Initially we have the first row/column are able to reach the pacific ocean.
Say our current location can reach the pacific, all locations with a height >= the current location can have water flow into our current location and thus reach the pacific.

We keep this principle and do a DFS over all nodes starting from the ones that can reach the pacific to find all nodes that can reach the pacific ocean if water were placed on it.
We do the exact same process for the atlantic ocean and then we check which positions can reach both the atlantic and pacific.

Note: for simplicity we can say the sea is at water level (i.e height of 0)
* */
public class M_Pacific_Atlantic_Ocean {

    public static void main(String[] args) {
        int [][] heights = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        M_Pacific_Atlantic_Ocean solution = new M_Pacific_Atlantic_Ocean();
        System.out.println("Result : "+solution.pacificAtlantic(heights)); //[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
    }

    /*
        Time Complexity
        The time complexity of the pacificAtlantic function can be analyzed as follows:
        Initialization: Initializing the pacific and atlantic boolean arrays takes O(m * n) time, where m is the number of rows and n is the number of columns.
        DFS Traversal: Each cell in the grid is visited once for the Pacific ocean and once for the Atlantic ocean.
        Each DFS traversal takes O(m * n) time in the worst case. Since there are two DFS traversals, the total time for DFS is O(2 * m * n) = O(m * n).

        Result Compilation: Compiling the result by iterating through the grid takes O(m * n) time.
        Combining these, the overall time complexity is: [ O(m * n) + O(m * n) + O(m * n) = O(m * n) ]

        Space Complexity
        The space complexity of the pacificAtlantic function can be analyzed as follows:
        Boolean Arrays: The pacific and atlantic boolean arrays each take O(m * n) space.
        DFS Stack: The maximum depth of the DFS stack is O(m * n) in the worst case.
        Result List: The result list can contain up to O(m * n) elements in the worst case.
        Combining these, the overall space complexity is: [ O(m * n) + O(m * n) + O(m * n) = O(m * n) ]
        Therefore, both the time and space complexity of the pacificAtlantic function are O(m * n).
    * */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean [][] pacific = new boolean[rows][cols];
        boolean [][] atlantic = new boolean[rows][cols];

        int [] dim = new int[]{-1,0,1,0, -1};
        for(int row = 0; row<rows; row++){
            for(int col = 0; col < cols; col++){
                if(row == 0 || col == 0)
                    dfs(pacific, row, col, heights,dim);

                if(row == rows-1 || col == cols-1)
                    dfs(atlantic, row, col, heights, dim);
            }
        }
        /*System.out.println("=====pacific===");
        for(int i= 0; i<rows;i++)
            System.out.println(Arrays.toString(pacific[i]));

        System.out.println("=====atlantic===");
        for(int i= 0; i<rows;i++)
            System.out.println(Arrays.toString(atlantic[i]));*/

        List<List<Integer>> result = new ArrayList();
        for(int row = 0; row<rows; row++){
            for(int col = 0; col < cols; col++){
                if(pacific[row][col] && atlantic[row][col]){
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    public void dfs(boolean [][] sea, int row, int col, int[][] heights, int [] dim){
        sea[row][col] = true;
        for(int i=0; i<4; i++){
            int newX = row + dim[i];
            int newY = col + dim[i+1];

            if(isValid(newX, newY, sea.length, sea[0].length) && heights[newX][newY] >= heights[row][col] && !sea[newX][newY])
                dfs(sea, newX, newY, heights,dim);
        }
    }


    public boolean isValid(int row, int col, int rows, int cols){
        return row >= 0 && row < rows && col >=0 && col < cols;
    }
}
