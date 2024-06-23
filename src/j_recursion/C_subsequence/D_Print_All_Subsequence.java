package j_recursion.C_subsequence;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
*
* Subsequence : A sequence (Contiguous/Non-Contiguous sequence which follows the order)
* {3,1,2 }: Seq : [][3,1,2] ,[3,1],[3,2],[1,2],[3],[1],[2] are sub sequences
* From above seq, [3,2] is not contiguous subsequence since its not following order

*
*
Thought process :
*
1) Take/Not take :
    3,1,2 : Take 2
    3,1 : not take 2

2) I need to iterate elements in an array so in function one of the param will be index
3) I need to add curr index element to list so in function one of the param will be
4) if current index is greater or equal to size of an array then need to add to result so in function one of the param will be List<List<Integer>>
5) And of cource one of the param will be an array


*
*
Base condition :
* if index is greater or equal to size of an array then stop and add list to result
*
*
* *
* *
f(index, collection){
    if(index >= collection.size()){
        print collection
        return;
    }
    collection.add(arr[i]); //take
    f(index+1,collection);
    collection.remove(collection.size()-1);  // Not take
    f(index, collection); //not take
    *
    *
    TC : O(N^2) +n
        * For Every Index there are  two options (Take or not take ) 2 2 2 : 2^n   + near about O(n) for printing
    SC : O(N) i.e. depth of tree
}
* */
public class D_Print_All_Subsequence {

    public void printAllSubsequence(List<Integer> nos, int index,List<Integer> subArr,List<List<Integer>> result){
            if(index >= nos.size()){
                //Do not add n directly to result since its reference and it will be changed for not take
                result.add(new ArrayList<>(subArr));
                return;
            }

            //Case of take
            subArr.add(nos.get(index));
            printAllSubsequence(nos,index+1,subArr,result);

            //case of Not Take.
            printAllSubsequence(nos,index+1,subArr.subList(0,subArr.size()-1),result);
    }

    public static void main(String[] args) {
        int arr [] ={3,2,1};
        List<Integer> nos = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        D_Print_All_Subsequence test = new D_Print_All_Subsequence();
        test.printAllSubsequence(nos,0,new ArrayList<Integer>(),result);
        System.out.println(result);
    }

}
