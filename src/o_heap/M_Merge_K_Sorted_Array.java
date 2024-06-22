package o_heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/*
https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
https://www.youtube.com/watch?v=l8CuET0jlDU&list=PLzjZaW71kMwTF8ZcUwm9md_3MvtOfwGow&index=18

Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6],
[7, 8, 9]]
The merged list will be
[1, 2, 3, 4, 5, 6, 7, 8, 9].
Example 2:

Input:
K = 4
arr[][]={{1,2,3,4},{2,2,3,4},
         {5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6], [7, 8, 9, 9 ]]
The merged list will be
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5,
6, 6, 7, 8, 9, 9].
Your Task:
You do not need to read input or print anything. Your task is to complete mergeKArrays() function which takes 2 arguments, an arr[K][K] 2D Matrix containing K sorted arrays and an integer K denoting the number of sorted arrays, as input and returns the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python)

Expected Time Complexity: O(K2*Log(K))
Expected Auxiliary Space: O(K2)


* */
public class M_Merge_K_Sorted_Array {


    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Comparator<ArrayEle> com = (c1, c2)-> {
            if(c1.val > c2.val){
                return 1;
            }else if(c1.val < c2.val){
                return -1;
            }else{
                if(c1.row > c2.row){
                    return 1;
                }else if(c1.row < c2.row){
                    return -1;
                }else{
                    return c1.col - c2.col;
                }
            }
        };

        PriorityQueue<ArrayEle> minHeap = new PriorityQueue<>(com);
        for(int i = 0; i< arr.length; i++){
            minHeap.offer(new ArrayEle(arr[i][0],i,0));
        }

        while(!minHeap.isEmpty()){
            ArrayEle ele = minHeap.peek();
            minHeap.poll();
            result.add(ele.val);

            if(ele.col +1 < arr[ele.row].length){
                minHeap.offer(new ArrayEle(arr[ele.row][ele.col +1], ele.row, ele.col +1));
            }
        }

        return result;
    }
}

class ArrayEle {
    int val;
    int row;
    int col;

    public ArrayEle(int val, int row, int col){
        this.val = val;
        this.row = row;
        this.col = col;
    }
}
