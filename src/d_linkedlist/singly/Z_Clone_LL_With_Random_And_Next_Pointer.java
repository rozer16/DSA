package d_linkedlist.singly;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/description/
https://takeuforward.org/data-structure/clone-linked-list-with-random-and-next-pointer/

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.



Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]


Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.
* */
public class Z_Clone_LL_With_Random_And_Next_Pointer {


    public static void main(String[] args) {
        // Example linked list: 7 -> 14 -> 21 -> 28
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        Z_Clone_LL_With_Random_And_Next_Pointer sol = new Z_Clone_LL_With_Random_And_Next_Pointer();

        System.out.println("Original Linked List with Random Pointers:");
        sol.printClonedLinkedList(head);

        Node clonedHead = sol.copyRandomList(head);
        System.out.println("\nCloned Linked List with Random Pointers:");
        sol.printClonedLinkedList(clonedHead);

        /*
        Original Linked List with Random Pointers:
        Data: 7, Random: 21
        Data: 14, Random: 7
        Data: 21, Random: 28
        Data: 28, Random: 14

        Cloned Linked List with Random Pointers:
        Data: 7, Random: 21
        Data: 14, Random: 7
        Data: 21, Random: 28
        Data: 28, Random: 14
        * */
    }

        static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node temp = head;

        //Insert node in between
        while(temp != null){
            Node next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = temp.next.next;
        }

        //print(head);
        temp = head;
        //Poinging random
        while(temp != null){
            Node copyNode = temp.next;

            // If the original node
            // has a random pointer
            if (temp.random != null) {
                // Point the copied node's random to the
                // corresponding copied random node
                copyNode.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        Node dummy = new Node(-1);
        Node newTemp = dummy;

        temp = head;
        //Extracting copied node list
        while(temp != null){
            newTemp.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            newTemp = newTemp.next;
        }
        //print(head);
        return dummy.next;


    }

    public void print(Node head){
        Node temp = head;
        while(temp != null){
            String ran = temp.random == null ? null : String.valueOf(temp.random.val);
            System.out.print("["+ temp.val+" , "+ran+" ] "+" -> ");
            temp = temp.next;
        }
        System.out.println("Printed");
    }

    //TC : O(2n)
    //SC : O(n)
    public Node copyRandomListBF(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node temp = head;

        while(temp != null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);


    }

    // Function to print the cloned linked list
    void printClonedLinkedList(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.val);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.val);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            // Move to the next node
            head = head.next;
        }
    }

}
