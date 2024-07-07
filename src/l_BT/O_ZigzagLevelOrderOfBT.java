/*

https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/
*/

package l_BT;

import java.util.*;


/*
*
*
*                     1
             2              3
         4      5       6       7
*
* [[1], [3, 2], [4, 5, 6, 7]]
*
* */
public class O_ZigzagLevelOrderOfBT {
    public static void main(String[] args) {
        A1_Node node = A1_Node.createTree();

        List<List<Integer>> result =  zigzagLevelOrderOfBT(node);
        System.out.println(result);

    }

    private static List<List<Integer>> zigzagLevelOrderOfBT(A1_Node node) {
        List<List<Integer>> result = new ArrayList<>();
        if(node == null)
            return result;
        Queue<A1_Node> queue = new LinkedList<>();
        queue.offer(node);
        boolean ltr = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                A1_Node tempNode = queue.poll();
                temp.add(tempNode.getVal());
                if(tempNode.getLeft() != null)
                    queue.offer(tempNode.getLeft());

                if(tempNode.getRight() != null)
                    queue.offer(tempNode.getRight());
            }

            if(ltr)
                Collections.reverse(temp);
            ltr = !ltr;
            result.add(temp);
        }

        return result;

    }
}
