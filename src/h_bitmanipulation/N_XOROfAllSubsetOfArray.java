package h_bitmanipulation;


/*
*
*                 Order       Contiguous
* SubArray          Y             Y

* SubSequence       Y             N

* SubSet            N             N
*
* Arr : {1,2,3,4}
* SubArray(n(n+1)/2)    : {1},{2},{3},{4},{1,2},{2,3},{3,4},{1,2,3},{2,3,4}.,{1,2,3,4}
* SubSequence(2^n - 1) : {1},{2},{3},{4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4},{1,2,3},{1,3,4},{2,3,4}.,{1,2,3,4},{}
* SubSet      : Any combination 2^n
*
*
* */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N_XOROfAllSubsetOfArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        N_XOROfAllSubsetOfArray test = new N_XOROfAllSubsetOfArray();
        System.out.println(test.getSubset(arr));
        //test.getXOROfAllSubsetOfArray(arr);
    }


    /*
    *
    * Subsets [1,2,3]: {1},{2},{3},{1,3},{1,2},{3,1},{2,1},{},{},{},{},{},{},{},{},{},{},
    * Subset [1,2,3,4] : [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3], [4], [1, 4], [2, 4], [1, 2, 4], [3, 4], [1, 3, 4], [2, 3, 4]]
    * */
    public void getXOROfAllSubsetOfArray(int [] arr){

    }

    public List<List<Integer>> getSubset(int arr []){
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<((1<<arr.length)-1) ;i++){
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if(this.isNthBitSet(i,j))
                    sublist.add(arr[j]);
            }
            Collections.sort(sublist);
            result.add(sublist);
        }

        return result;
    }

    public boolean isNthBitSet(int no, int n){
        return ((1<<n) & no) > 0;
    }
}
