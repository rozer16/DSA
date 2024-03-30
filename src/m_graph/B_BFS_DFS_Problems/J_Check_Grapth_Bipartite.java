package m_graph.B_BFS_DFS_Problems;

import java.util.ArrayList;

public class J_Check_Grapth_Bipartite {

    public static void main(String[] args) {
        // V = 4, E = 4
        ArrayList < ArrayList < Integer >> adj = new ArrayList< >();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        J_Check_Grapth_Bipartite obj = new J_Check_Grapth_Bipartite();
        boolean ans = obj.isBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }

    private boolean isBipartite(int noOfNode, ArrayList<ArrayList<Integer>> adj) {
        int [] color = new int[adj.size()];

        for(int i = 0;i<adj.size();i++)
            color[i] = -1;


        for (int j = 0; j < adj.size(); j++) {
            if(color[j] == -1){
                if(!dfs(j,0,color,adj))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {


        color[node] = col;;
        for(int n : adj.get(node)){
            if(color[n] == -1){
                dfs(n,1-col,color,adj);
            }else if(color[n] == col){
                return false;
            }
            //if color[n] is opposite of col then we are good and move to next adj node.
        }
        return true;
    }
}
