package k_BT;


import java.util.LinkedList;
import java.util.Queue;

/*
* Max No of nodes in a level between any two nodes
* */
public class I_MaxWidhthOfBT {


    public static void main(String[] args) {
        A1_Node root = A1_Node.createTree();
        int width = getMaxWidthOfBT(root);
    }

    private static int getMaxWidthOfBT(A1_Node root) {
        int ans = 0;
        if(root== null)
            return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        while (!queue.isEmpty()){
            int size = queue.size();
            int mmin = queue.peek().getNum(); //To make id starting from zero
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int curr_id = queue.peek().getNum() - mmin;
                A1_Node node = queue.peek().getNode();
                queue.poll();
                if(i == 0)
                    first = curr_id;

                if(i == size-1)
                    last = curr_id;

                if(node.getLeft() != null)
                    queue.offer(new Pair(node.getLeft(), curr_id*2+1));
                if(node.getRight() != null)
                    queue.offer(new Pair(node.getRight(), curr_id*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;

    }



    static class Pair{
        A1_Node node ;
        int num;

        public Pair(A1_Node node, int num) {
            this.node = node;
            this.num = num;
        }

        public A1_Node getNode() {
            return node;
        }

        public void setNode(A1_Node node) {
            this.node = node;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
