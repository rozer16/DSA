package hashmap;

import java.util.HashSet;
import java.util.Set;

public class PairHavingSum {
    public int findPairHavingSum(int max,int sum){
        int noOfPairs = 0;
        Set<Integer> nos = new HashSet<>();
        for(int i = 1; i <= max;i++){
            if(nos.contains(sum-i) && i < sum)
                noOfPairs++;
            nos.add(i);
        }
        return  noOfPairs;
    }

    public static void main(String[] args) {
        PairHavingSum p = new PairHavingSum();
        System.out.println(p.findPairHavingSum(10,7));
    }
}
