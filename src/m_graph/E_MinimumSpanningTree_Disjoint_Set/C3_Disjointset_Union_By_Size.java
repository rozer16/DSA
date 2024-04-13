package m_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.ArrayList;
import java.util.List;

public class C3_Disjointset_Union_By_Size {

    private int noOfNodes;


    private List<Integer> parent;

    private List<Integer> size;


    /*
        Initial Configuration
            parent = [0,1,2,3,4,5,...n] --> each node is their own boss
            size = [0,0,0,0....0] --> all node are leaf and they dont have any children

    * */
    public C3_Disjointset_Union_By_Size(int noOfNodes){
        this.noOfNodes = noOfNodes;
        this.parent = new ArrayList<>(noOfNodes+1);
        this.size = new ArrayList<>(noOfNodes);

        for (int i = 0; i <= noOfNodes; i++) {
            this.parent.add(i);
            this.size.add(0);
        }
    }

    public int findUltimateParent(int nodeU){
        if(nodeU == parent.get(nodeU))
            return nodeU;

        parent.set(nodeU, findUltimateParent(parent.get(nodeU)));
        return parent.get(nodeU);
    }

    public void unionBySize(int nodeU, int nodeV){
        int upu = findUltimateParent(nodeU);
        int upv = findUltimateParent(nodeV);

        if(upu == upv)
            return;

        if(size.get(upu) < size.get(upv)){
            parent.set(upu, upv);
            size.set(upv,size.get(upv)+size.get(upu));
        }else{
            parent.set(upv, upu);
            size.set(upu, size.get(upu)+size.get(upv));
        }
    }
    public static void main(String[] args) {
        C3_Disjointset_Union_By_Size solution = new C3_Disjointset_Union_By_Size(7);
        solution.unionBySize(1,2);
        solution.unionBySize(2,3);
        solution.unionBySize(4,5);

        solution.unionBySize(6,7);
        solution.unionBySize(5,6);

        if(solution.findUltimateParent(3) == solution.findUltimateParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not same");
        }

        solution.unionBySize(3,7);

        if(solution.findUltimateParent(3) == solution.findUltimateParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not same");
        }
    }
}
