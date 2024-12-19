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

        boolean bst = isValidBST(root1,Integer.MIN_VALUE,Integer.MAX_VALUE);

        if(bst)
            System.out.println("Its BST");
        else
            System.out.println("Its BT");
    }

    private static boolean isValidBST(Node root1, long minValue, long maxValue) {
        if(root1 == null)
            return true;

        if(root1.data <= minValue || root1.data >= maxValue)
            return false;

        return isValidBST(root1.left, minValue, root1.data) && isValidBST(root1.right,root1.data, maxValue);
    }


}
