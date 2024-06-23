package g_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class O_NextSmallerElement {
    public static void main(String[] args) {
        O_NextSmallerElement test = new O_NextSmallerElement();
        int [] arr = {5,7,1,2,6,0};
        System.out.println(Arrays.toString(test.nextSmallerElements(arr)));
    }

    private int[] nextSmallerElements(int[] nums) {
        int [] nse = new int[nums.length];
        if(nums == null || nums.length <= 1)
            return nums;
        Deque<Integer> stack = new ArrayDeque<>();



        for (int i = nums.length*2-1; i >=0 ; i--) {
            while(!stack.isEmpty() && stack.peek() >= nums[i%nums.length])
                stack.pop();

            if(i< nums.length){
                if(stack.isEmpty())
                    nse[i] = -1;
                else
                    nse[i] = stack.peek();
            }

            stack.push(nums[i%nums.length]);
        }
        return nse;
    }
}
