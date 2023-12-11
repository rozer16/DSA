package l_BST;


/*https://youtu.be/SXKAD2svfmI

*                           25
                    15              45
                 9      21        41    52
*            3     13

        Inorder :   3 9 13 15 21 25 41 45 52
*

    Successor of 21 is 25
    Successor of 13 is 15

    Bruteforce approach :
        Traverse all node and store elements in collection and apply Binary search since bst inorder always gives sorted
        complexity : O(N) for traverse + log n for search

    Better Approach
        While traversing tree keep track if curr node element is greater than store it as successor and move based on value
        loop until currNode is not null
            if current node value is less than or equal searchVal then curr = curr.left
            if current node value is greater than searchVal then set successor = currNode.val and currNode = currNode.left


*/
public class M_FindSuccessofNodeOfBST {
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

        System.out.println(findSuccessor(root, new Node(21)));

    }


    public static Node findSuccessor(Node root,Node p){
        Node successor = null;
        if(root == null || p == null)
            return null;

        Node temp = root;
        while(temp != null){
            if(temp.data <= p.data){
                temp = temp.right;
            }else{
                successor = temp;
                temp = temp.left;
            }
        }
        return successor;
    }
}



