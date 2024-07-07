package m_BST;

/*


*https://youtu.be/cX_kPV_foZc
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Find Lowest Common Ancestor of a Binary Search Tree
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
                    6
              2             8
          0     4          7  9
              3   5

  For 2,8 LCA is 6
  For 3,2 LCA is 2


 Characteristics of BST :
*    All nodes on left side of given node will have smaller value
*    All nodes on right side of given node will have greater value
*
*
*   Possibilities of two nodes location from given node
*
*       Both node on left side of current node(Both node's value are less than the curr node value)
*       Both node on right side of current node(Both nodes' value are greater than the curr node value)
*       Current node's value is equal to one of the node
*       Either 1 on left side(smaller than curr val) and 1 on right side(greater than curr val)
*
*
*       so in last 2 case  the result will be current node itself
*
*
* */
public class K_LCAOfBST {

    public static void main(String[] args) {
        Node node = Node.getBST();
        Node result = getLCAOfBST(node, new Node(1), new Node(2));
        System.out.println(result);
    }

    private static Node getLCAOfBST(Node node,Node p, Node q) {
            if(node == null)
                return node;

            int curr = node.data;
            int pval = p.data;
            int qval = q.data;

            // Both node on left side of current node(Both node's value are less than the curr node value)
            if(curr > pval && curr > qval)
                return getLCAOfBST(node.left,p,q);
            // Both node on right side of current node(Both node's value are greater than the curr node value)
            if(curr< pval && curr < qval)
                return getLCAOfBST(node.right,p,q);

            //Current node's value is equal to one of the node
            //OR
            //Either 1 on left side(smaller than curr val) and 1 on right side(greater than curr val)
            return node;

    }


}
