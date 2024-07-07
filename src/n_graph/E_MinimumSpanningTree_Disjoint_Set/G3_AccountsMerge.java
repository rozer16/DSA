package n_graph.E_MinimumSpanningTree_Disjoint_Set;

import java.util.*;

public class G3_AccountsMerge {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList();
        accounts.add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
        accounts.add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
        accounts.add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
        accounts.add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

        List<List<String>> accountMerged = new G3_AccountsMerge().accountsMerge(accounts);
        for (int i = 0; i < accountMerged.size(); i++) {
            System.out.println(accountMerged.get(i));
        }

        /*
        [John, j1@com, j2@com, j3@com, j5@com]
        [John, j4@com]
        [Raj, r1@com, r2@com, r3@com]
        [Mary, m1@com]
        * */

    }

    /*
    Time Complexity: O(N+E) + O(E*4ɑ) + O(N*(ElogE + E))
            where N = no. of indices or nodes
                  E = no. of emails. The first term is for visiting all the emails.

                  The second term is for merging the accounts.
                  And the third term is for sorting the emails and storing them in the answer array.

    Space Complexity: O(N)+ O(N) +O(2N) ~ O(N) where
            N = no. of nodes/indices.
            The first and second space is for the ‘mergedMail’ and the ‘ans’ array.
            The last term is for the parent and size array used inside the Disjoint set data structure.
    * */

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        C3_Disjointset_Union_By_Size ds= new C3_Disjointset_Union_By_Size(accounts.size());
        Map<String,Integer> map = new HashMap<>();


        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if(map.containsKey(accounts.get(i).get(j))){
                    ds.unionBySize(map.get(accounts.get(i).get(j)),i);
                }else{
                    map.put(accounts.get(i).get(j),i);
                }
            }
        }

        List<List<String>> mergedAccount = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++)
            mergedAccount.add(new ArrayList<>());

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int node = entry.getValue();
            int parent = ds.findUltimateParent(node);
            mergedAccount.get(parent).add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        int cnt =-1;
        for(List<String> ma : mergedAccount){
            cnt++;
            if(ma.isEmpty())
                continue;
            Collections.sort(ma);
            ma.add(0,accounts.get(cnt).get(0));
            result.add(ma);
        }

        return result;

    }

}
