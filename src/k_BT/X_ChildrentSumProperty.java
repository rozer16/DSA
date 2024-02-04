package k_BT;


/*
 https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/
 https://youtu.be/fnmisPM6cVo
*
*
* */
public class X_ChildrentSumProperty {

    public static void main(String[] args) {
        Node  root = new Node(2);
        root . left = new Node(35);
        root . left . left = new Node(2);
        root . left . right = new Node(3);
        root . right = new Node(10);
        root . right . left = new Node(5);
        root . right . right = new Node(2);

        changeTree(root);

        displayInorderByRecursion(root);
    }

    public static void displayInorderByRecursion(Node AANode) {
        if(AANode == null)
            return;

        System.out.print(AANode.data+" ");
        displayInorderByRecursion(AANode.left);
        displayInorderByRecursion(AANode.right);
    }

    private static void changeTree(Node root) {
            if(root == null)
                return;

            int childSum = 0;

            if(root.left != null)
                childSum += root.left.data;

            if(root.right != null)
                childSum += root.right.data;

            if(childSum >= root.data){
                root.data = childSum;
            }else{
                if(root.left != null){
                    root.left.data = root.data;
                }
                if(root.right != null){
                    root.right.data = root.data;
                }
            }

            changeTree(root.left);
            changeTree(root.right);

            int totoalSum =0;
            totoalSum += root.left != null ? root.left.data : 0;
            totoalSum += root.right != null ? root.right.data : 0;

            if(root.left != null || root.right != null )
                root.data = totoalSum;

    }
}
