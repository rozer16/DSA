package n_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.ArrayList;
import java.util.List;

public class C2_DisjointSet_UnionByRank {

    private int noOfNode;
    private List<Integer> rank;

    private List<Integer> parent;
    public C2_DisjointSet_UnionByRank(int noOfNode){
        this.noOfNode = noOfNode;
        this.rank = new ArrayList<>(noOfNode+1);
        this.parent = new ArrayList<>(noOfNode+1);
        for (int i = 0; i < noOfNode+1; i++) {
            this.rank.add(0);
            this.parent.add(i);
        }
    }

    public int findUltimateParent(int node){
        if(parent.get(node) == node)
            return node;

        parent.set(node, findUltimateParent(parent.get(node)));
        return parent.get(node);
    }

    public void unionByRank(int nodeU, int nodeV){
        int ultimateParentOfU = findUltimateParent(nodeU);
        int ultimateParentOfV = findUltimateParent(nodeV);

        if(ultimateParentOfU == ultimateParentOfV)
            return;

        if(rank.get(ultimateParentOfU) > rank.get(ultimateParentOfV)){
            parent.set(ultimateParentOfV,ultimateParentOfU);
        } else if (rank.get(ultimateParentOfV) > rank.get(ultimateParentOfU)) {
            parent.set(ultimateParentOfU, ultimateParentOfV);
        }else{
            parent.set(ultimateParentOfV, ultimateParentOfU);
            rank.set(ultimateParentOfU, rank.get(ultimateParentOfU)+1);
        }
    }


    public static void main(String[] args) {
            C2_DisjointSet_UnionByRank solution = new C2_DisjointSet_UnionByRank(7);

            solution.unionByRank(1,2);
            solution.unionByRank(2,3);
            solution.unionByRank(4,5);

            solution.unionByRank(6,7);
            solution.unionByRank(5,6);

            if(solution.findUltimateParent(3) == solution.findUltimateParent(7)){
                System.out.println("Same");
            }else{
                System.out.println("Not same");
            }

            solution.unionByRank(3,7);

            if(solution.findUltimateParent(3) == solution.findUltimateParent(7)){
                System.out.println("Same");
            }else{
                System.out.println("Not same");
            }

    }


}
