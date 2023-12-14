package l_BST;


/*
* https://leetcode.com/problems/recover-binary-search-tree/description/
* https://www.youtube.com/watch?v=ZWGW7FminDM
*
* Problem : given the root of a binary search tree (BST),
* where the values of exactly two nodes of the tree were swapped by mistake.
* Recover the tree without changing its structure.

Approaches 1:
    1) Traverse tree inorder and sort it
    2) Again traverse tree in inorder and compare node at each step with element in collect and if it's not same then they are difference
    3) Complexity : O(N) for traversing tree first time + O(N log N) for sorting + O(N) for again traversing tree
    *
Approach 2:
    1) There are two cases when 2 nodes are swapped, one is they are adjacent, or they are not.
    2) keep 4 variables prev , first , middle & last
    3) set prev - Integer.MIN_VALUE
    4) Iterate tree from root and check if its values is less than prev
    5) If its value is less than prev and first and second is null then set first = prev, middle = curr else third = root

 *
*
* */
public class P_RecoverBST
{
    Node prev,first,middle,last;
    public static void main(String[] args) {
        Node root =new Node(25);
        root.left = new Node(15);
        root.left.left = new Node(41);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(13);
        root.left.right = new Node(21);


        root.right = new Node(45);
        root.right.right = new Node(52);
        root.right.left = new Node(9);

        P_RecoverBST test = new P_RecoverBST();
        test.recoverBST(root);
        System.out.println(root);

    }

    public void recoverBST(Node root){
        prev = new Node(Integer.MIN_VALUE);
        inorder(root);
        if(last == null){
            int temp = first.data;
            first.setData(middle.data);
            middle.setData(temp);
        }else{
            int temp = first.data;
            first.setData(last.data);
            last.setData(temp);
        }
    }

    private void inorder(Node root) {
        if(root == null)
            return;
        inorder(root.left);
        if(prev.getData() > root.getData()){
            //If this is first violation then make first and middle
            if(first == null){
                first = prev;
                middle = root;
            }else{
                //If this is last violation then set last node as root
                last = root;

            }
        }
        prev = root;
        inorder(root.right);

    }
}
