package l_BST;

public class F_FindMinMax {
    public static void main(String[] args) {
        Node node = Node.getBST();
        System.out.println(findMin(node));
        System.out.println(findMax(node));
    }

    public static int findMin(Node root){
        if(root == null)
            return -1;
        Node temp = root;
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return  temp.getData();
    }

    public static int findMax(Node root){
        if(root == null)
            return -1;
        Node temp = root;
        while(temp.getRight() != null){
            temp = temp.getRight();
        }
        return  temp.getData();
    }
}
