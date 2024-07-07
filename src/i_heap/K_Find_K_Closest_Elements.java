package i_heap;

import java.util.*;


/*
https://leetcode.com/problems/find-k-closest-elements/description/
https://www.youtube.com/watch?v=Of4bdCDwcdY&list=PLzjZaW71kMwTF8ZcUwm9md_3MvtOfwGow&index=17
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]


Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
* */
public class K_Find_K_Closest_Elements  {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int k = 4, x=3;
        K_Find_K_Closest_Elements sol = new K_Find_K_Closest_Elements();
        System.out.println(sol.findClosestElements(arr,k,x));
    }

    Comparator<Element> com = (e1, e2) -> {
        if(e1.diff > e2.diff )
            return 1;
        else if (e1.diff < e2.diff)
            return -1;
        else
            return e1.index - e2.index;
    };
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(com);
        int index = 0;
        for(int ele : arr)
            minHeap.offer(new Element(index++, Math.abs(x-ele)));


        List<Integer> result = new ArrayList<>();
        index = 0;
        while(index < k){
            result.add(arr[minHeap.poll().index]);
            index++;
        }
        Collections.sort(result);
        return result;
    }
}

class Element {
    int index;
    int diff;

    public Element(int index, int diff){
        this.index = index;
        this.diff = diff;
    }
}

