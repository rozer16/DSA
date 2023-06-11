package b_array;

import java.util.Arrays;


/*
*   Input : {0,0,1,1,1,2,2,3,3,4,4,4,9};
*   Output : [0, 1, 2, 3, 4, 9, 0, 0, 0, 0, 0, 0, 0]
*
* Keep two point p & mp
* */

public class E_RemoveDuplicatesFromSortedArrary {

    public int [] removeDuplicates(int[] nums) {
        int p = 1;
        int mp = 1;

        while(mp < nums.length){
            if(nums[mp] != nums[mp-1]){
                nums[p++] = nums[mp];
            }
            mp++;
        }

        while(p<nums.length) {
            nums[p] = 0;
            p++;
        }


        return nums;
    }

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4,4,4,9};
        E_RemoveDuplicatesFromSortedArrary e = new E_RemoveDuplicatesFromSortedArrary();
        System.out.println(Arrays.toString(e.removeDuplicates(nums)));
    }
}
