package j_recursion.A_functional;

import java.util.Arrays;


/*
* https://takeuforward.org/data-structure/reverse-a-given-array/
*
* */
public class A_ReverseArray {

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,6};
        reverseArray(arr,0);
        System.out.println(Arrays.toString(arr));

    }

    public static void reverseArray(int [] arr,int i){
        if(i>=arr.length/2){
            return;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length-i-1];
        arr[arr.length-i-1] = temp;

        reverseArray(arr,i+1);
    }
    public static void reverseArray(int [] arr,int i , int j){
        if(i>=j){
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverseArray(arr,i+1,j-1);
    }


}
