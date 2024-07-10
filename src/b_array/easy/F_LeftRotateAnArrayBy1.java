package b_array.easy;

import java.util.Arrays;


/*
https://takeuforward.org/data-structure/left-rotate-the-array-by-one/

Input:
 N = 5, array[] = {1,2,3,4,5}
Output:
 2,3,4,5,1
Explanation:

Since all the elements in array will be shifted
toward left by one so ‘2’ will now become the
first index and and ‘1’ which was present at
first index will be shifted at last.


Example 2:
Input:
 N = 1, array[] = {3}
Output:



* */
public class F_LeftRotateAnArrayBy1 {

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5}; //[2, 3, 4, 5, 1]
        F_LeftRotateAnArrayBy1 test = new F_LeftRotateAnArrayBy1();
        System.out.println(Arrays.toString(test.rotateArrayBy1(arr)));
    }
    public int [] rotateArrayBy1(int [] arr){
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;

        return arr;
    }
}
