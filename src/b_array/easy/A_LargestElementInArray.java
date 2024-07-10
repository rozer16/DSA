package b_array.easy;

/*
https://youtu.be/37E9ckMDdTk
https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/
 *
* https://practice.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-element-in-array

*
* */
public class A_LargestElementInArray {

    public static void main(String[] args) {
        A_LargestElementInArray test  = new A_LargestElementInArray();
        int [] arr = {1, 8, 7, 56, 90};
        System.out.println(test.largest(arr,arr.length));
    }
    public int largest(int arr[], int n) {
        int left = 0;
        int right = n-1;
        int max = Integer.MIN_VALUE;
        while(left <= right){
            int temp = arr[left] > arr[right] ? arr[left] : arr[right];
            max = max < temp ? temp : max;
            left++;
            right--;
        }
        return max;
    }


}
