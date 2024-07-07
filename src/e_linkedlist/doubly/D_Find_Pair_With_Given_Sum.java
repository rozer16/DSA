package e_linkedlist.doubly;

import java.util.ArrayList;


/*
https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-pairs-with-given-sum-in-doubly-linked-list
https://youtu.be/YitR4dQsddE

Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.



Example 1:

Input:
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs
(1, 6) and (2,5) with sum 7.


Example 2:

Input:
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.



Your Task:
You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum() which takes head node of the doubly linked list and an integer target as input parameter and returns an array of pairs. If there is no such pair return empty array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= target <= 105
* */
public class D_Find_Pair_With_Given_Sum {

    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        if(head == null || head.next == null)
            return null;

        ArrayList<ArrayList<Integer>> result =new ArrayList<>();

        Node left = head;
        Node right = head;

        while(right.next != null)
            right = right.next;


        while(left.data < right.data){
            //System.out.println(left.data +" "+ right.data);
            if(left.data + right.data == target){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(left.data);
                temp.add(right.data);

                result.add(temp);
                left = left.next;
                right = right.prev;
            }else if(left.data + right.data < target){
                left = left.next;
            }else{
                right = right.prev;
            }
        }

        return result;
    }
}
