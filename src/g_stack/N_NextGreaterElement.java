package g_stack;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
* https://takeuforward.org/data-structure/next-greater-element-using-stack/
* https://takeuforward.org/data-structure/next-greater-element-using-stack/

 Input: N = 11, A[] = {3,10,4,2,1,2,6,1,7,2,9}


Output: 10,-1,6,6,2,6,7,7,9,9,10

Explanation: For the first element in A ,i.e, 3, the greater element which comes next to it while traversing and is closest to it is 10. Hence,10 is present on index 0 in the resultant array. Now for the second element,i.e, 10, there is no greater number and hence -1 is it’s next greater element (NGE). Similarly, we got the NGEs for all other elements present in A.  


Example 2:

Input:  N = 6, A[] = {5,7,1,7,6,0}

Output: 7,-1,7,-1,7,5
*

To make it a bit easier let’s first try to solve without considering the array as circular.
 To find the next greater element we start traversing the given array from the right.
 As for the rightmost element, there is no other element at its right.
 Hence, we assign -1 at its index in the resultant array.
 Since this can be the next greater element (NGE) for some other element,
 we push it in the stack S. We keep checking for other elements.
 Let’s say we are checking for an element at index i.
 We keep popping from the stack until the element at the top of the stack is smaller than A[i].
 The main intuition behind popping them is that these elements can never be the NGE for any element present at the left of A[i]
 because A[i] is greater than these elements. Now, if the top element of S is greater than A[i]
 then this is NGE of A[i] and we will assign it to res[i],
 where res is the resultant array. If the stack becomes empty then it implies that
 no element at the right of A[i] is greater than it and we assign -1. At last, we push A[i] in S.
 *
 *
* */
public class N_NextGreaterElement {
    //[7, -1, 2, 6, 7, 5]
    public static void main(String[] args) {
        N_NextGreaterElement test = new N_NextGreaterElement();
        int [] arr = {9,7,1,2,6,10};
        System.out.println(Arrays.toString(test.nextGreaterElements(arr)));
    }
    public  int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length <= 1)
            return nums;
        int [] nge = new int[nums.length];
        Deque<Integer> stack
                = new ArrayDeque();

        for (int i = nums.length*2-1; i >=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i%nums.length])
                stack.pop();

            if(i<nums.length){
                if(stack.isEmpty())
                    nge[i] = -1;
                else
                    nge[i] = stack.peek();
            }

            stack.push(nums[i% nums.length]);
        }

        return nge;
    }
}
