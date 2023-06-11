package i_recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
*
* Subsequence : A sequence (Contiguous/Non-Contiguous sequence which follows the order)
* {3,1,2 }: Seq : [][3,1,2] ,[3,1],[3,2],[1,2],[3,1,2] are sub sequences
* From above seq, [3,2] is not contiguous sub sequence since its not following order

f(index, collection){
    if(index >= collection.size()){
        print collection
        return;
    }
    collection.add(arr[i]); //take
    f(index+1,collection);
    collection.remove(collection.size()-1);
    f(index, collection); //not take
}
* */
public class K_Print_All_Subsequence {

    public void printAllSubsequence(List<Integer> nos, int index,List<Integer> subArr,List<List<Integer>> result){
            if(index >= nos.size()){
                result.add(subArr);
                return;
            }

            subArr.add(nos.get(index));
            printAllSubsequence(nos,index+1,subArr,result);
            printAllSubsequence(nos,index+1,subArr.subList(0,subArr.size()-1),result);
    }

    public static void main(String[] args) {
        int arr [] ={3,2,1};
        List<Integer> nos = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        K_Print_All_Subsequence test = new K_Print_All_Subsequence();
        test.printAllSubsequence(nos,0,new ArrayList<Integer>(),result);
        System.out.println(result);
    }

}
