package m_BST;


/*
* https://takeuforward.org/binary-search-tree/floor-in-a-binary-search-tree/
* https://youtu.be/xm_W1ub-K-w
*
* Note: Floor(X) is a number that is either equal to X or is immediately lesser than X.
 *
* */
public class E_BST_Floor {

    public static void main(String[] args) {
        Node node = Node.getBST();

        System.out.println(findFloor(node,11));
    }

    private static int findFloor(Node root, int i) {

        // If the input is already available in BST, return that.
        if(root  == null)
            return -1;
        int floor = -1;
        Node temp  = root;
        while(temp != null){
            if(temp.getData() == i)
                return temp.getData();
            else if(temp.getData() > i){
                //the floor value must be in the left subtree.
                temp = temp.left;
            }else{
                // If the input is greater than root, we mark floor to be root and move to
                // right subtree where it may be further closer to the input value
                floor = temp.data;
                temp = temp.right;

            }
        }

        return  floor;
    }
}
