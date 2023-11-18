package k_BT;

import java.util.*;

public class D_BFS {

    public static void main(String[] args) {
        A1_Node root = A1_Node.createTree();
        System.out.println("==========BFS Traversal=====");
        displayTreeByBFSTraversal(root);
    }

    private static void displayTreeByBFSTraversal(A1_Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<A1_Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                A1_Node node = queue.poll();
                temp.add(node.getVal());
                if(node.getLeft() != null)
                    queue.offer(node.getLeft());
                if(node.getRight() != null)
                    queue.offer(node.getRight());
            }
            result.add(temp);
        }

        for(List<Integer> nos : result){
            for (Integer no : nos){
                System.out.print(no+" ");
            }
        }
    }
}
