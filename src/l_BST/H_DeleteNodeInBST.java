package l_BST;


/*

https://youtu.be/kouxiP_H5WE


                        8
                5               12
          2             7|10            13
    1           3|6             8
                        4

Observation : For any given node,
        Left tree will have lesser value than current node.
        Right tree will have greater value than current node.

1) Find a node
2) Check if root value is the node we are trying to find then set currNode.left = get value from left from  step no : 4 by passing currNode.left
3) Set CurrentNode = root and run loop until we find current node
3.1) if curr node value is greater than the searchValue(Or if searchValue is less than currNode value)
        check if currNode.left is not null
            if currNode.left.val is searchValue then set currNode.left = get value from left from  step no : 4 by passing currNode.left
            else set currNode to currNode.left

3.2) if curr node value is left than the searchValue(or searchValue is greater than currNode value)
        check if currNode.right is not null
            if currNode.right.val is searchValue then set currNode.left = get value from left from  step no : 4 by passing currNode.left
            else set currNode to currNode.left

4) if curr.left is null then return curr.right
   if curr.right is null then return curr.left

   if  curr.left & curr.right not null then
   1) mostRight = Find most right of curr.left
   2) set mostRight.right = curr.right
   3) return curr.left

*/
public class H_DeleteNodeInBST {

    public static void main(String[] args) {
        Node node = Node.getBST();
        deleteNode(node,6);
    }

    private static Node deleteNode(Node node, int i) {
        if(node == null)
            return node;
        if(node.data == i)
            helper(node);

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
