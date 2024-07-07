package n_graph.B_BFS_DFS_Problems;

public class C_FloodFill {


    public static void main(String[] args)
    {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        // sr = 1, sc = 1, newColor = 2
        C_FloodFill obj = new C_FloodFill();
        int[][] ans = obj.floodFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int tarColor) {
        int [][] ans =new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            System.arraycopy(image[i], 0, ans[i], 0, image[i].length);
        }

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        int startColor = image[sr][sc];

        dfs(sr,sc,ans,image,tarColor,dx,dy,startColor);

        return ans;
    }

    private void dfs(int row, int col,
                     int[][] ans,
                     int[][] image,
                     int newColor, int delRow[], int delCol[],
                     int iniColor) {

        ans[row][col] = newColor;
        int rows = image.length;
        int cols = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && image[nrow][ncol] == iniColor  && ans[nrow][ncol] != newColor)
                dfs(nrow,ncol,ans,image,newColor,delRow,delCol,iniColor);
        }

    }
}
