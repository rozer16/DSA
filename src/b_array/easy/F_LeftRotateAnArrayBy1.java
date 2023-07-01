package b_array.easy;

import java.util.Arrays;

public class F_LeftRotateAnArrayBy1 {

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5};
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
