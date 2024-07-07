package n_graph.D_shortest_path;

public class N2_Find_City_With_Smallest_Number_of_Neighbours_With_Threshold_Distance {

    public static void main(String[] args) {
        int n = 4;

        int[][] edges =  {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;

        N2_Find_City_With_Smallest_Number_of_Neighbours_With_Threshold_Distance solution = new N2_Find_City_With_Smallest_Number_of_Neighbours_With_Threshold_Distance();
        System.out.println(solution.findTheCity(n,edges,distanceThreshold));
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {


        int [][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int target = edges[i][1];
            int weight = edges[i][2];
            dist[source][target] = weight;
            dist[target][source] = weight;
        }


        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        int noOfCities = n;
        int citino = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int ajdCiti = 0; ajdCiti < n; ajdCiti++) {
                if(dist[city][ajdCiti] <= distanceThreshold)
                    cnt++;
            }

            if(cnt <= noOfCities){
                noOfCities = cnt;
                citino = city;
            }
        }

        return citino;
    }
}
