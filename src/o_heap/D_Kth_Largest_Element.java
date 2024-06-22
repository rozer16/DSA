package o_heap;


import java.util.Collections;
import java.util.PriorityQueue;

/*

https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/
https://leetcode.com/problems/kth-largest-element-in-an-array/description/

 Approach 2/3: Min-Heap
  The main idea of this solution is to use a min-heap with a maximum size of k. By doing this, we ensure that the smallest of the k largest elements is always on the top of the heap.

  Key Data Structures:
  heap:
  This is a min-heap containing the first k elements of nums. As we progress, we will modify this heap to ensure it contains the k largest elements.
  Step-by-step Breakdown:
  Initialization:

  Create a heap with the first k elements of nums.
  Transform this list into a min-heap.
  Iterate through the List:

  For each of the remaining elements in nums:
  If the element is larger than the smallest element in the heap (i.e., the top of the heap):
  Remove the top element from the heap.
  Insert the current element into the heap.
  Result:

  After processing all elements in nums, the top of the heap will contain the kth largest element. Return this element.
  Example:
  Consider the list nums = [3,2,1,5,6,4] with k = 2.

  Here's the evolution of the heap:

  Initial State:

  heap: [3,2]
  After processing index 2 (element = 1):

  heap remains unchanged as 1 is not larger than 2.
  After processing index 3 (element = 5):

  heap: [3,5]
  After processing index 4 (element = 6):

  heap: [5,6]
  After processing index 5 (element = 4):

  heap: [5,6]
  The final state of the heap shows that the kth largest element is 5.

  Complexity
  Time Complexity: O(nlog⁡k)O(n \log k)O(nlogk)
  Each of the n elements is processed once. However, heap operations take O(log⁡k)O(\log k)O(logk) time, leading to an overall complexity of O(nlog⁡k)O(n \log k)O(nlogk).

  Space Complexity: O(k)O(k)O(k)
  The solution uses a heap with a maximum of k elements.
  */

public class D_Kth_Largest_Element {

    public static void main(String[] args) {
        D_Kth_Largest_Element sol = new D_Kth_Largest_Element();
        System.out.println(sol.findKthLargest(new int[]{1,5,7,10,15,8,9},5));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //Inserting first k elements in min heap
        for(int i = 0; i<k; i++){
            minHeap.offer(nums[i]);
        }

        //Now maintaining only first k largest element
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

}
