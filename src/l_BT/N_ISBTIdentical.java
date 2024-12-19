/*

https://takeuforward.org/data-structure/check-if-two-trees-are-identical/
*/

package l_BT;

public class N_ISBTIdentical {

    public static void main(String[] args) {
        A1_Node root1 = A1_Node.createTree();
        A1_Node root2 = A1_Node.createTree();

        boolean isTreeIdentical = isTreeIdentical(root1,root2);
        System.out.println("Tree1 & Tree2 are identical : "+isTreeIdentical);
    }

    private static boolean isTreeIdentical(A1_Node root1, A1_Node root2) {
        if(root1 == null || root2 == null)
            return root1 == root2;

         return root1.getVal() == root2.getVal() && isTreeIdentical(root1.getLeft(),root2.getLeft()) && isTreeIdentical(root1.getRight(),root2.getRight());
         }

         }
