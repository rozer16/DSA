package i_heap;

import java.util.PriorityQueue;


/*
https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths.
The task is to connect the ropes with minimum cost. Given N size array arr[] contains the lengths of the ropes.

Example 1:

Input:
n = 4
arr[] = {4, 3, 2, 6}
Output:
29
Explanation:
We can connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Which makes the array {4, 5, 6}. Cost of
this operation 2+3 = 5.
2) Now connect ropes of lengths 4 and 5.
Which makes the array {9, 6}. Cost of
this operation 4+5 = 9.
3) Finally connect the two ropes and all
ropes have connected. Cost of this
operation 9+6 =15
Total cost for connecting all ropes is 5
+ 9 + 15 = 29. This is the optimized cost
for connecting ropes.
Other ways of connecting ropes would always
have same or more cost. For example, if we
connect 4 and 6 first (we get three rope of 3,
2 and 10), then connect 10 and 3 (we get
two rope of 13 and 2). Finally we
connect 13 and 2. Total cost in this way
is 10 + 13 + 15 = 38.
Example 2:

Input:
n = 5
arr[] = {4, 2, 7, 6, 9}
Output:
62
Explanation:
First, connect ropes 4 and 2, which makes
the array {6,7,6,9}. Cost of
this operation 4+2 = 6. Next, add ropes
6 and 6, which results in {12,7,9}.
Cost of this operation 6+6 = 12.
Then, add 7 and 9, which makes the array {12,16}.
Cost of this operation 7+9 = 16. And
finally, add these two which gives {28}.
Hence, the total cost is 6 + 12 + 16 +
28 = 62.
Your Task:
You don't need to read input or print anything. Your task is to complete the function minCost() which takes an integer array arr[] and an integer n as arguments and returns the minimum cost.

Expected Time Complexity : O(nlogn)
Expected Auxilliary Space : O(n)

Constraints:
1 ≤ N ≤ 200000
1 ≤ arr[i] ≤ 106
* */
public class J_Minumum_Cost_To_Connect_Ropes {


    public static void main(String[] args) {
        int len[] = { 4, 3, 2, 6 };
        J_Minumum_Cost_To_Connect_Ropes sol = new J_Minumum_Cost_To_Connect_Ropes();
        //System.out.println(sol.cutRod(len, len.length));

        long len1[] = { 4, 3, 2, 6 };
        System.out.println(sol.minCost(len1, len.length));
    }

    long minCost(long arr[], int n)
    {

        PriorityQueue<Long> minHeap = new PriorityQueue();

        for(long price1 : arr){
            minHeap.offer(price1);
        }

        long sum = 0;
        while(minHeap.size() != 1){
            long rop1 = minHeap.poll();
            long rop2 = minHeap.poll();
            sum += (rop1+rop2);
            minHeap.offer(rop1+rop2);
        }

        return sum;
    }
    public int cutRod(int price[], int n) {
        MinHeap minHeap = new MinHeap(price.length);

        for(int price1 : price){
            minHeap.offer(price1);
        }
        int sum = 0;
        while(minHeap.size() != 1){
            int rop1 = minHeap.poll();
            int rop2 = minHeap.poll();
            sum += (rop1+rop2);
            minHeap.offer(rop1 + rop2);
        }

        return sum;
    }
}

class MinHeap{
    int [] arr;
    int size;
    int capacity;

    public MinHeap(int capacity){
        arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

   public int peek(){
        if(size ==0)
            return Integer.MAX_VALUE;

        return arr[0];
   }

    public int poll(){
        if(size <= 0)
            return Integer.MAX_VALUE;
        if(size == 1){
            size--;
            return arr[0];
        }

        int root = arr[0];
        arr[0] = arr[size-1];
        size--;
        minHeapify(0);



        return root;
    }

    public void offer(int no){
        if(size == capacity)
            return;

        size++;
        arr[size-1] = no;

        int i = size-1;
        while(i != 0 && arr[i] < arr[getParent(i)]){
            swap(i,getParent(i));
            i = getParent(i);
        }
    }


    public void minHeapify(int index){
        int smallest = index;

        int left = getLeft(index);
        int right = getRight(index);

        if(left < size() && arr[left] < arr[index])
            smallest = left;
        if(right < size() && arr[right] < arr[smallest])
            smallest = right;

        if(smallest != index){
            swap(smallest, index);
            minHeapify(smallest);
        }

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    int getLeft(int i){
        return (2*i)+1;
    }

    int getRight(int i){
        return (2*i)+2;
    }

    int getParent(int i){
        return (i-1)/2;
    }

    public void swap(int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
