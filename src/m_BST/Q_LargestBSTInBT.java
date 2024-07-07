package m_BST;


/*
* https://youtu.be/X0oXMdtUDwo
* Problem : In given BT, find largest BST and return no of nodes of BST.
*
*
* Intuition / Thought process :
*   i) A node is considered to be valid BST node if it satisfies below condition : largest < nodeVal < smallest
*        A : Find the largest node from left subtree(Find node having largest value) and that largest value should be smaller than node value.
*        B : Find the smallest node from right subtree(Find node having smallest value) and that smallest value should be greater than node value.
*
*   ii) We need to validate left subtree and right subtree
*   iii) We need to think which traversal technique we can use which supports traversing first left subtree then right subtree and node i.e. post order.
*   iv) Size of node if its valid BST node : leftSize + rightSize + 1
*   v)  So we need to keep three params for a node :
*           size of node
*           largest of all node
*           smallest of all node
*   vi) If node is leaf node
*         return :  Size : 0, largest : Integer.MIN_VALUE, smallest : Integer.MAX_VALUE so whatever value node have it will satisfy of that node as valid BST left subtree
*         So if node is leaf node then its valid subtree with size 1, largest : nodeVal, smallest : nodeVal : [1,nodeVal,nodeVal]
*
*   vii) if node satisfies condition given in i.a) and i.b) then we can conclude below
*        size = leftSize + rightSize + 1
*        smallest : Math.min(node.value, leftNode.smallest)
*        largest  : Math.max(node.value, rightNode.largest)
*
*  viii) If node does not satisfy condition than set below
*          size : Max(leftNodeSize, rightNodeSize)
*          Smallest : Integer.MIN_VALUE
*          Largest : Integer.MAX_VALUE
*
*
* TC : O(N)
* SC : O(1)
* */
public class Q_LargestBSTInBT {
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


        System.out.println(getLargestBSTSize(root).nodeCount);
    }

    public static BSTNode getLargestBSTSize(Node node){

        /*
        *  vi) If node is leaf node
                return :  Size : 0, largest : Integer.MIN_VALUE, smallest : Integer.MAX_VALUE so whatever value node have it will satisfy of that node as valid BST left subtree
                So if node is leaf node then its valid subtree with size 1, largest : nodeVal, smallest : nodeVal : [1,nodeVal,nodeVal]
        * */
        if(node == null)
            return new BSTNode(0,Integer.MAX_VALUE,Integer.MIN_VALUE);

        BSTNode left = getLargestBSTSize(node.left);
        BSTNode right = getLargestBSTSize(node.getRight());

        //A node is considered to be valid BST node if it satisfies below condition : largest < nodeVal < smallest
        if(left.getLargest() < node.getData() && node.getData() < right.getSmallest()){

             //Valid BST Node
            /*
            *
            *        size = leftSize + rightSize + 1
            *        smallest : Math.min(node.value, leftNode.smallest)
            *        largest  : Math.max(node.value, rightNode.largest)
            *
            * */
             return new BSTNode(left.getNodeCount() + right.getNodeCount()+1,
                     Math.min(node.getData(),left.getSmallest()),
                     Math.max(node.getData(), right.getLargest())
                     );
        }

        /*
        *  node does not satisfy condition so set below
         *          size : Max(leftNodeSize, rightNodeSize)
         *          Smallest : Integer.MIN_VALUE
         *          Largest : Integer.MAX_VALUE
        * */
        return new BSTNode(Math.max(left.getNodeCount(),right.getNodeCount()),Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


}

class BSTNode{
    int nodeCount;
    int smallest;
    int largest;


    public BSTNode(int nodeCount, int smallest, int largest) {
        this.nodeCount = nodeCount;
        this.smallest = smallest;
        this.largest = largest;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public int getSmallest() {
        return smallest;
    }

    public void setSmallest(int smallest) {
        this.smallest = smallest;
    }

    public int getLargest() {
        return largest;
    }

    public void setLargest(int largest) {
        this.largest = largest;
    }
}
