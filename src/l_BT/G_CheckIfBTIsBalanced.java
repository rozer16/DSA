/*
https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/
*/

package l_BT;

/*
*  For every node : Abs(height(left) - height(right)) <= 1
* */

public class G_CheckIfBTIsBalanced {

    public static void main(String[] args) {
        A1_Node root = A1_Node.createTree();

    }

    public boolean isBTBalanced(A1_Node root){
        return checkBTBalanced(root) != -1;
    }

    public int checkBTBalanced(A1_Node root){
        if(root == null)
            return 0;

        int hl = checkBTBalanced(root.getLeft());
        if(hl == -1)
            return -1;
        int hr = checkBTBalanced(root.getRight());
        if(hr == -1)
            return -1;

        if(Math.abs(hl-hr) >1)
            return -1;

        return 1+Math.max(hl,hr);
    }
}
