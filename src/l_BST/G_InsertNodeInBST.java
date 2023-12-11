package l_BST;
/*
* https://leetcode.com/problems/insert-into-a-binary-search-tree/
*
* */
public class G_InsertNodeInBST {
    public static void main(String[] args) {
        Node node = Node.getBST();
        System.out.println(insertNode(node,6));

    }

    private static Node insertNode(Node node, int i) {
        Node root = node;
        Node temp = node;

        if(temp== null){
            return new Node(i);
        }

        while(true){
            if(temp.data >= i){
                if(temp.getLeft() != null){
                    temp = temp.getLeft();
                }else{
                    temp.setLeft(new Node(i));
                    break;
                }
            }else {
                if(temp.getRight() != null){
                    temp = temp.getRight();
                }else{
                    temp.setRight(new Node(i));
                    break;
                }
            }
        }

        return  root;
    }

}
