package l_BT;


import java.util.ArrayList;
import java.util.List;

/*

https://takeuforward.org/data-structure/morris-preorder-traversal-of-a-binary-tree/

https://www.youtube.com/watch?v=80Zug6D1_r4
 */
public class ZD_MorrisPreorderTraversalOFBT {

    public static void main(String[] args) {

    }
    public List<Integer> preorderTraversal(Node root) {
        Node curr = root;

        List<Integer> preorder = new ArrayList<Integer>();
        while(curr != null){
            //Option 1 if left node is null
            if(curr.left == null){
                //Add current node value in list and move to right
                preorder.add(curr.data);
                curr = curr.right;
            }else{
                //Option 2 current left is not null

                //We need to  either draw threaded line or if its already there then we need to remove
                //To check lets reach to left tree's most right node

                Node prev = curr.left;
                while(prev.right != null && prev.right != curr)
                    prev = prev.right;

                //if there is no threaded line then do it  and move curr = curr.left
                if(prev.right == null){
                    prev.right = curr;
                    preorder.add(curr.data);
                    curr = curr.left;
                }else{
                    //There is already threaded line means we can cut it and move curr = curr.right
                    prev.right = null;

                    curr = curr.right;

                }

            }
        }

        return preorder;
    }
}
