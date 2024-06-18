package e1_greedy_algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q_LRU_Page_Replacement_Algorithm {

    public static void main(String[] args) {
        Q_LRU_Page_Replacement_Algorithm sol = new Q_LRU_Page_Replacement_Algorithm();
        System.out.println(sol.pageFaults(9,4,new int[]{5 ,0 ,1, 3, 2, 4, 1, 0, 5}));
    }
    public int pageFaults(int N, int C, int pages[]){
        Map<Integer,Boolean> map = new LinkedHashMap<Integer,Boolean>(C)
        {
            private final int MAX_ENTRIES = C;
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_ENTRIES;
            }
        };
        int fault = 0;
        for(int i =0; i<N; i++)
        {
            if(map.containsKey(pages[i])==false)
            {
                map.put(pages[i],true);
                fault++;
            }
            else{
                map.remove(pages[i]);
                map.put(pages[i],true);
            }
        }
        return fault;
    }
}
