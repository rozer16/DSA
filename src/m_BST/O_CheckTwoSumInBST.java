package m_BST;

/*

*                           25
                    15              45
                 9      21        41    52
*            3     13
*/
public class O_CheckTwoSumInBST {
    public static void main(String[] args) {
        Node root =new Node(25);
        root.left = new Node(15);
        root.left.left = new Node(9);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(13);
        root.left.right = new Node(21);


        root.right = new Node(45);
        root.right.right = new Node(52);
        root.right.left = new Node(41);

        N_BSTIterator start = new N_BSTIterator(root,false);
        N_BSTIterator end = new N_BSTIterator(root,true);

        /*
        *   Node{data=21, left=null, right=null}
            Node{data=41, left=null, right=null}
            If two nodes exists with sum 62: true
        * */
        System.out.println("If two nodes exists with sum "+62+": " +checkTwoSum(start,end,62));

    }

    private static boolean checkTwoSum(N_BSTIterator start, N_BSTIterator end, int i) {
        if(!start.hasNext() || !end.hasNext())
            return false;
        Node p = start.next();
        Node q = end.next();
        while(p.getData() < q.getData()){
            if(p.getData()+q.getData() == i){
                System.out.println(p);
                System.out.println(q);
                return true;
            } else if (p.getData()+q.getData() > i) {
                q = end.next();
            }else{
                p = start.next();
            }
        }
        return false;
    }
}
