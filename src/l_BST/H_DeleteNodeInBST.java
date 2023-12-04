package l_BST;


/*

https://youtu.be/kouxiP_H5WE


                        8
                5               12
          2             7|10            13
    1           3|6             8
                        4


*/
public class H_DeleteNodeInBST {

    public static void main(String[] args) {
        Node node = Node.getBST();
        deleteNode(node,6);
    }

    private static Node deleteNode(Node node, int i) {
        if(node == null)
            return node;

        Node curr = node;

        while(curr != null){
            if(curr.getData() > i){
                if(curr.getLeft() != null && curr.getLeft().getData() == i){
                    curr.setLeft(helper(curr.getLeft()));
                    break;
                }else{
                    curr = curr.getLeft();
                }
            }else{
                if(curr.getRight() != null && curr.getRight().getData() == i){
                    curr.setRight(helper(curr.getLeft()));
                    break;
                }else{
                    curr = curr.getRight();
                }
            }

        }
        return node;
    }

    private static Node helper(Node node) {
        if(node.getLeft() == null)
                return node.getRight();
        if(node.getRight() == null)
            return node.getLeft();


        Node mostRightOfLeft = getMostRight(node.getLeft());
        mostRightOfLeft.setRight(node.getRight());
        return node.getLeft();
    }

    private static Node getMostRight(Node node) {
        if(node.getRight() == null)
            return  node;

        return getMostRight(node.getRight());
    }
}
