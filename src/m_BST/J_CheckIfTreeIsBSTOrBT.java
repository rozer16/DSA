package m_BST;


/*
* https://youtu.be/f-sj7I5oXEI
* https://leetcode.com/problems/validate-binary-search-tree/
*
*
*  BST :
*    All nodes on left must be less than current node
*    All nodes on right must be greater than current node
*
*    Below is not BST because 4 is on right side of 4 and left of 6
*    In order to 4 to be valid it should be less than 6 and greater than 5
*
*           5
*   1               6
*               4            8
*
*
*
* So to validate all cases, what if we give a range
* To decide a range for given node
*   left node  range : [ lower range of parent, value of parent node ] ==>  value cannot be greater than parent
*   Right node range : [  value of parent node, higher range of parent] ==> value cannot be smaller than parent
*
*
*                                               13[IntMinValue, IntMaxValue]
*                    10[IntMinValue,13]                                         15[13,IntMaxValue]
*           7[IntMinValue,10]           12[10,13]                      14[13,15]                   17[13,IntMaxValue]
*                   9[IntMinValue,10]
*                8[IntMinValue,9]                                                              16[13,17]
*
*
*
*
* */
public class J_CheckIfTreeIsBSTOrBT {
    public static void main(String[] args) {

        Node root =new Node(3);
        root.left = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(2);
        root.left.right.right = new Node(3);





        Node root1 =new Node(-2147483648);
        root.right = new Node(2147483647);

        boolean bst = isValidBST(root1);
        if(bst)
            System.out.println("Its BST");
        else
            System.out.println("Its BT");
    }

    public static boolean isValidBST(Node root) {
        if(root == null)
            return true;

        //Start with INT min range and Int max range
        return isValidBSTHelper(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean isValidBSTHelper(Node root,long leftRange, long rightRange) {
        /*
        *   1. if node value is null then true
        *   2. left is null OR if left node is not null and leftRange < root.left.data < root.data ===> return true
        *   3. right is null OR if right node is not null and root.data < root.right.data < rightRange ===> return true
        *
        * */
        if(!isValidBSTNode(root,leftRange,rightRange))
            return false;

        boolean left = root == null || isValidBSTHelper(root.left, leftRange, root.data);
        if(!left)
            return false;
        return root == null || isValidBSTHelper(root.right, root.data, rightRange);


    }
    public static boolean isValidBSTNode(Node node, long leftR,long rightR){
        if(node == null)
            return true;
        if(node.left != null && ((node.left.data >= node.data ) || (node.left.data <=  leftR)))
            return false;
        if(node.right != null && ( (node.right.data <= node.data) || (node.right.data >= rightR)))
            return false;

        return true;
    }


}
