package j_recursion.C_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
*
* Find all subseq element whose sum = k
*
* For e.g. for array :{1,4,5,1}
*
* Subseq whose sum is 5 : [[1, 4, 1], [1, 5], [5, 1]]
*
* Thought process :
*
* Take element / Not take element at given index and add it to sum
* If index is equal to input array size and sum is equal to targetSum then add subSeq to result.
*
* */
public class F_SubSequenceWithSumN {

    public static void main(String[] args) {
        List<Integer> nos = Arrays.asList(1,4,5,1);
        List<List<Integer>> result = new ArrayList<>();
        subSequenceWithSumN(nos,0,0,6,new ArrayList<>(),result);
        System.out.println(result); //[[1, 4, 1], [1, 5], [5, 1]]


    }

    public static void subSequenceWithSumN(List<Integer> nos, int index, int sum, int targetSum,
                                    List<Integer> n, List<List<Integer>> result ){
        if(index >= nos.size()){
            if(sum == targetSum){
                //Do not add n directly to result since its reference and it will be changed for not take
                result.add(new ArrayList<>(n));
            }

            return;
        }


        n.add(nos.get(index));

        //Take
        if(nos.get(index)+sum <= targetSum)
            subSequenceWithSumN(nos,index+1,sum+nos.get(index),targetSum,n,result);

       n.remove(n.size()-1);
       //Not take
       subSequenceWithSumN(nos,index+1,sum,targetSum,n,result);

    }


}


