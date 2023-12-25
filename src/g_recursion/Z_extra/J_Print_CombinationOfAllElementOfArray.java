package g_recursion.Z_extra;

import java.util.ArrayList;
import java.util.List;


/*
*
*                              0,[]
*                   1,[3]                           1,[]
*        2,[3,1]             2,[3]           2,[1]          2[]
 3,[3,1,2]   3,[3,1]    3,[3,2]   3,[3] 3,[1,2]  3,[1]  3,[2]    3,[]
* */
public class J_Print_CombinationOfAllElementOfArray {

    private int [] arr;
    public J_Print_CombinationOfAllElementOfArray(int [] arr){
        this.arr = arr;
    }


    public void subSequence(int index, List<Object> list ){
        if(index >= arr.length){
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        subSequence(index+1,list);
        list.remove(list.size()-1);
        subSequence(index+1,list);
    }

    public static void main(String[] args) {
        int []arr = {1,2,3,4};
        J_Print_CombinationOfAllElementOfArray test = new J_Print_CombinationOfAllElementOfArray(arr);
        test.subSequence(0, new ArrayList<>());
    }
}
