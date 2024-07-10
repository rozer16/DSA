package b_array.easy;

import java.util.Arrays;
/*
https://takeuforward.org/data-structure/rotate-array-by-k-elements/
https://youtu.be/wvcQg43_V8U
https://leetcode.com/problems/rotate-array/description/


* */
public class G_LeftRotateArrayByK {

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5}; //[3, 4, 5, 1, 2]
        G_LeftRotateArrayByK test = new G_LeftRotateArrayByK();
        test.leftRotateArray(arr,2);
        System.out.println(Arrays.toString(arr));

    }


    public void leftRotateArray(int [] arr,int k){
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,arr.length-1);
        reverseArray(arr,0,arr.length-1);

    }

    public void reverseArray(int [] arr, int p1,int p2){
        int left = p1;
        int right = p2;
        while(left <= right){
            swap(arr,left++,right--);
        }
    }

    private void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    /*
    * SC : O(K)
    *
    * */
    public int [] leftRotateArrayByK(int [] arr,int k){
        int [] temp = new int[k];
        System.arraycopy(arr,0,temp,0,k);
        int index=0;
        for (int i = k; i < arr.length; i++) {
            arr[index++] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            arr[index++] = temp[i];
        }


        return arr;
    }
}
