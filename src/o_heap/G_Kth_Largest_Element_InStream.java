package o_heap;

import java.util.Arrays;
import java.util.PriorityQueue;


/*

https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
https://www.youtube.com/watch?v=8HR8Ak5zuus&list=PLzjZaW71kMwTF8ZcUwm9md_3MvtOfwGow&index=14
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.


Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8


Constraints:

1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element
* */
public class G_Kth_Largest_Element_InStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public static void main(String[] args) {
        int [] arr = {4,5,8,2};
        int k = 3;
        G_Kth_Largest_Element_InStream sol = new G_Kth_Largest_Element_InStream(k,arr);
    }
    int gk = 0;
    public G_Kth_Largest_Element_InStream(int k, int[] nums) {
        gk = k;
        for(int i=0;i<nums.length; i++){
            if(minHeap.size() < k){
                minHeap.offer(nums[i]);
            }else if(minHeap.size() == k && minHeap.peek() < nums[i]){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }

        }
        System.out.println(Arrays.toString(minHeap.toArray()));
    }

    public int add(int val) {
        if(minHeap.size() < gk){
            minHeap.offer(val);
        }else if(minHeap.size() == gk && minHeap.peek() < val){
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }


}
