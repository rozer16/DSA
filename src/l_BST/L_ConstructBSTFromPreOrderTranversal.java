package l_BST;


/*
* https://www.youtube.com/watch?v=UmJT3j26t1I
*
*  Inorder traversal of binary tree always gives  nodes in ascending order ==> Ascending order of node = Inorder traversal of BST
*  If you have Preorder binary tree and we sort it we will get inorder traversal of BST
*
*  So if we have inorder and preorder traversal, we can create unique tree.
*
*  TC : O(n logn)[For sorting] + O(N) [for creating unique tree]
*  SC : O(n) [To store inorder in list]
*
*   But this complexity is  much.
*
*   To improve the complexity we can think on below intuition
*           We are given PreOrder BST
*           Left sub part of BST should be less than node val of parent node
*           Right subpart of BST can be  upper bound value of its parent node
*           if new value from preorder array is greater than curr node upper bound then
*               we need to traverse towards upper parent until we find node val whose upper bound is greater tha node val
*
*
*           For e.g.   PreOrder : 8 5 1 7 10 12
*           Step : 1
*                                           8[UB: IM]
*                           5[UB : 8]
*
*
*
*           Step 2 :
*                                           8[UB: IM]
 *                           5[UB : 8]
*
*
*
*           Step 3
*
*                                            8[UB: IM]
 *                           5[UB : 8]
*                   1[UB:5]
*
*
*           Step 4
*
*                                        8[UB: IM]
 *                           5[UB : 8]
 *                   1[UB:5]
 *               left cannot be 7 because its UB is 1 and it cannot be also right because its right bound is 5 so it has to go up
 *
 *          Step 4.1
 *
 *                                        8[UB: IM]
 *                           5[UB : 8]
 *                   1[UB:5]              7[LB : 7, UB : 8]
 *                10 cannot go at 7 and 5 so it will go to 8 right as 8 upper bound is Interger.MAX_VALUE
 *
 *          Step 5
 *
 *                                        8[UB: IM]
 *                           5[UB : 8]                      10[LB : 10, UB : IM]
 *                   1[UB:5]              7[LB : 7, UB : 8]                     12[lb: 12, UB : IM]
 *
 *
 *         ===================================================
 *
 *          To check left bound : Take node value
 *          To check right bound : Take parent node UB
 * */public class L_ConstructBSTFromPreOrderTranversal {

    public static void main(String[] args) {
        int [] preorder = {8, 5, 1, 7, 10, 12};
        Node node = createBSTTree(preorder,Integer.MAX_VALUE,new int[]{0});
    }

    private static Node createBSTTree(int[] preorder, int upperBound, int[] indexOfPreOrder) {
        if(indexOfPreOrder[0] == preorder.length || preorder[indexOfPreOrder[0]] > upperBound)
                return null;

        Node root = new Node(preorder[indexOfPreOrder[0]]);
        indexOfPreOrder[0]++;
        root.left = createBSTTree(preorder, root.data, indexOfPreOrder);
        root.right = createBSTTree(preorder,upperBound,indexOfPreOrder);

        return  root;
    }
}
