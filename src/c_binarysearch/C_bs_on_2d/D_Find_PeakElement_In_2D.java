package c_binarysearch.C_bs_on_2d;

public class D_Find_PeakElement_In_2D {


    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;


        int low = 0;
        int high = cols-1;


        while(low <= high){
            int mid = low + (high-low)/2;

            int row = findMaxElementFromColumn(mat,mid);
            int left = mid-1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid+1 < cols ? mat[row][mid+1] : -1;

            if(left < mat[row][mid] && mat[row][mid] > right)
                return new int[]{row,mid};
            else if(left > mat[row][mid])
                high = mid-1;
            else
                low = mid+1;
        }

        return new int[]{-1,-1};
    }


    public int findMaxElementFromColumn(int [][] mat, int col){
        int rows = mat.length;
        int cols = mat[0].length;
        int max = Integer.MIN_VALUE;
        int maxRow = 0;
        for(int i=0;i<rows;i++) {
            if(max < mat[i][col]){
                max = mat[i][col];
                maxRow = i;
            }

        }

        return maxRow;
    }
}
