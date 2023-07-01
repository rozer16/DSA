package b_array.easy;

import java.util.Arrays;

public class E_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        E_RemoveDuplicatesFromSortedArray test = new E_RemoveDuplicatesFromSortedArray();
        int [] arr = {1,1,2,2,2,3,3};
        System.out.println(Arrays.toString(test.RemoveDuplicatesFromSortedArray(arr)));

    }

    private int[] RemoveDuplicatesFromSortedArray(int[] arr) {
        int index = 0;
        int i = 0;
        while(i<arr.length){
            while(arr[i] == arr[i+1])
                i++;
        }

        return null;
    }
}
