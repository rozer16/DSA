package i_heap;


import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
* */
public class N_Merge_K_Sorted_Singly_LinkedList {


    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);


        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;

        ListNode node = new N_Merge_K_Sorted_Singly_LinkedList().mergeKLists(lists);
        System.out.println(node.toString()); //1 1 2 3 4 4 5 6

    }
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0)
            return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(e-> e.val));
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for(int i = 0; i<lists.length; i++){
            if(lists[i] != null)
                minHeap.offer(lists[i]);
        }

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            curr.next = new ListNode(node.val);
            curr= curr.next;
            node = node.next;
            if(node != null){
                minHeap.offer(node);
            }
        }
        return head.next;
    }


}


class ListNode {
     int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder b = new StringBuilder();
        while(node != null){
            b.append(node.val+" ");
            node = node.next;
        }

        return b.toString();
    }


}