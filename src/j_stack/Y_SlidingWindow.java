package j_stack;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/*
*
* https://leetcode.com/problems/sliding-window-maximum/
*
* You are given an array of integers nums, there is a sliding window of size k
* which is moving from the very left of the array to the very right.
* You can only see the k numbers in the window.
*  Each time the sliding window moves right by one position.

Return the max sliding window.
*
*
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 *
 *
Input: nums = [1], k = 1
Output: [1]
*
*
Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*
*
* */
public class Y_SlidingWindow {
    public static void main(String[] args) {
        Y_SlidingWindow test = new Y_SlidingWindow();
        int [] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(test.maxSlidingWindowPQ(arr,3)));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] r  = new int[n-k+1];
        int ri=0; //Store index

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //Remove no out of range k
            if(!q.isEmpty() && q.peek() == i-k)
                q.poll();

            //Remove smaller no in k range as they are smaller
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();

            q.offer(i);
            if(i>=k-1)
                r[ri++] = nums[q.peek()];

        }

        return r;
    }

    /*
    * BruteForce
    * TC : O(n*k)
    * SC : O(1)
    *
    * */

    public int[] maxSlidingWindowBF(int[] nums, int k) {
        int resultSize =nums.length-k+1;
        int [] result = new int[resultSize];
        int resultIndex = 0;
        for (int i = 0; i <= nums.length-k; i++) {
            int currentSubArrayMax = nums[i];
            for (int j = i; j < i+k; j++)
                currentSubArrayMax = currentSubArrayMax < nums[j] ? nums[j] : currentSubArrayMax;

            result[resultIndex++] = currentSubArrayMax;

        }

        return result;
    }

    /*
    * Approach : In priority queue we will store Pair(number,index) in descending order of number
    *
    * 1) add first k element in pq and store result[0] = queue.peek();
    * 2) loop i=k --> nums.length
    *           Keep removing element from front of queue if its index is <= i-k
    * 3) Add in queue ==> new Pair(nums[i],i)
    * 4) res[i-k+1] = pq.peek().num;
    *
    * */
    public int[] maxSlidingWindowPQ(int[] nums, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        int[] res=new int[nums.length-k+1];
        for(int i=0; i<k; i++){
            pq.add(new Pair(nums[i],i));
        }
        res[0]=pq.peek().num;
        for(int i=k; i<nums.length ;i++){
            while(pq.size()>0 && pq.peek().index<= (i-k)){
                pq.remove();
            }
            pq.add(new Pair(nums[i],i));
            res[i-k+1]=pq.peek().num;
        }
        return res;
    }
    public class Pair implements Comparable<Pair>{
        int num;
        int index;
        public Pair(int num, int index){
            this.num=num;
            this.index=index;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.num-this.num; // Sort in descending Order
        }
    }
}
