package i_heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
https://www.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=replace-elements-by-its-rank-in-the-array
Replace elements by its rank in the array
Given an array arr of N integers, the task is to replace each element of the array by its rank in the array. The rank of an element is defined as the distance between the element with the first element of the array when the array is arranged in ascending order. If two or more are same in the array then their rank is also the same as the rank of the first occurrence of the element.

Example 1:

Input:
N = 6
arr = [20, 15, 26, 2, 98, 6]
Output:
4, 3, 5, 1, 6, 2
Explanation:
After sorting, array becomes {2,6,15,20,26,98}
Rank(2) = 1 (at index 0)
Rank(6) = 2 (at index 1)
Rank(15) = 3 (at index 2)
Rank(20) = 4 (at index 3) and so on..
Example 2:

Input:
N = 4
arr = [2, 2, 1, 6]
Output:
2, 2, 1, 3
Explanation:
After sorting, array becomes {1, 2, 2, 6}
Rank(1) = 1 (at index 0)
Rank(2) = 2 (at index 1)
Rank(2) = 2 (at index 2)
Rank(6) = 3 (at index 3)
Rank(6) = 3 because rank after 2 is 3 as rank
of same element remains same and for next element
increases by 1.
Your Task:
Complete the function int replaceWithRank(), which takes integer N  and an array of N integers as input and returns the list in which element at each position of original array is replaced by the rank of that element.

Expected Time Complexity: O(N * logN)
Expected Auxiliary Space: O(N)


Constraints:

1 <= N <= 105
1 <= arr[i] <= 109
* */
public class P_Replace_Element_By_Its_Rank {

    public static void main(String[] args) {
        int [] arr = {2, 20, 10, 3, 14, 16, 14};
        P_Replace_Element_By_Its_Rank sol = new P_Replace_Element_By_Its_Rank();
        System.out.println(Arrays.toString(sol.replaceWithRank(arr,arr.length)));//[1, 6, 3, 2, 4, 5, 4]
    }

    public int[] replaceWithRank(int arr[], int N) {

        PriorityQueue<Ele> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        int index = 0;
        for(int ele : arr){
            minHeap.offer(new Ele(ele, index++));
        }
        //System.out.println(Arrays.toString(minHeap.toArray()));
        int [] result = new int[N];
        int rank = 0;
        int lastEle = -1;
        while(!minHeap.isEmpty()){
            Ele ele = minHeap.poll();
            if(ele.val == lastEle){
                result[ele.index] = rank;
            }else{
                rank = rank+1;
                result[ele.index] = rank;
            }
            lastEle = ele.val;

        }
        return result;

    }


    static class Ele{
        int val;
        int index;

        public Ele(int val, int index){
            this.val = val;
            this.index = index;
        }

        public String toString(){
            return index+"-"+val+"";
        }
    }

}
