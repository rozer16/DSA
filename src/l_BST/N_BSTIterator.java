package l_BST;


import java.util.Stack;

/*

*                           25
                    15              45
                 9      21        41    52
*            3     13

        Inorder :   3 9 13 15 21 25 41 45 52
*
*       Given 25 node as input param


        hasNext() -> true
        next() -> 3
        next() -> 9
        next() -> 13
        hasNext() -> true
        next() -> 15
        next() -> 21
        next() -> 25
        hasNext() --> true
        next() -> 41
        next() -> 45
        next() -> 52
        hasNext() -> false

*
Approach 1 :
    i) Traverse BST in inorder and store values in collection,
    ii) Maintain pointer for index

    TC : O(N) for traversing + O(N) for iterator
    SC : O(N) for storing data into collection


Approach 2 :
    1) Follow inorder iterative approach(left Root right) i.e. put all left node in stack -->  pushAll()
    2) when next is called, pop current element and push right node and its all left element
    3) when hasNext is called, check if stack is empty then return false else return true
    4) For getting reverse order, we can just negate step 1 & 2 i.e. push all right node from root and when next is called then pop and push its left node and all its right node
*
*
* */
public class N_BSTIterator {

    Stack<Node> stack = new Stack<>();
    boolean reverse;

    public N_BSTIterator(Node node,boolean reverse){
        this.reverse = reverse;
        pushAll(node);

    }
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

        N_BSTIterator iterator = new N_BSTIterator(root,true);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public Node next(){
        Node node = stack.pop();
        if(reverse){
            pushAll(node.getLeft());
        }else {
            pushAll(node.getRight());
        }
        return node;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }


    public void pushAll(Node node){
        while(node != null){
            stack.push(node);
            if(reverse){
                node = node.getRight();
            }else {
                node = node.getLeft();
            }
        }
    }
}
