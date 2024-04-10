package m_graph.D_shortest_path;

import java.util.Arrays;

public class M2_Floyd_Warshall_Algorithm {

    public static void main(String[] args) {
        int V = 4;
        int[][] matrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = -1;
            }
        }

        matrix[0][1] = 2;
        matrix[1][0] = 1;
        matrix[1][2] = 3;
        matrix[3][0] = 3;
        matrix[3][1] = 5;
        matrix[3][2] = 4;


        M2_Floyd_Warshall_Algorithm solution = new M2_Floyd_Warshall_Algorithm();
        solution.shortest_distance(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    //cant use Integer.MAX_VALUE
    public void shortest_distance(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == -1)
                    matrix[i][j] = (int) 1e9;

                if(i == j)
                    matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],
                            matrix[i][k] + matrix[k][j]);
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == (int) 1e9)
                    matrix[i][j] = -1;
            }
        }

    }
}
