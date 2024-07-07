package f_bitmanipulation;

public class A_RemoveTwoDuplicateNo {

    public static void main(String[] args) {
        A_RemoveTwoDuplicateNo test = new A_RemoveTwoDuplicateNo();
        int[]  arr = {1,1,2,2,3,3,4,4,5};
        System.out.println(test.removeTwoDuplicates(arr));
    }

     private int removeTwoDuplicates(int[] arr) {
        // any n ^ 0 = n
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor^arr[i];
        }
        return xor;
    }
}
