/*

https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
*/

package k_BT;

import java.util.ArrayList;
import java.util.List;

public class T_LeftViewOfTree {
    public static void main(String[] args) {
        A1_Node node = A1_Node.createTree();
        List<Integer> bottomViewEle = getLeftViewEleByRecursion(node);
        System.out.println(bottomViewEle);
    }

    private static List<Integer> getLeftViewEleByRecursion(A1_Node node){
        List<Integer> result = new ArrayList<>();
        getLeftViewEleByRecursion(node,0,result);
        return result;
    }

    private static void getLeftViewEleByRecursion(A1_Node node, int level, List<Integer> result) {
        //Following reverse preorder i.e. root right left

        if(node == null)
            return;

        if(result.size() == level)
            result.add(node.getVal());

        getLeftViewEleByRecursion(node.getLeft(),level+1,result);
        getLeftViewEleByRecursion(node.getRight(),level+1,result);


    }
}
