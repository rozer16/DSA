package b_array.other;

public class F_ElementAppearingMoreThan25_Percent {

    public int findSpecialInteger(int[] arr) {
        int pointer = 1;
        int max = arr.length/4;
        int counter = 1;

        while(pointer < arr.length){
            while(arr[pointer] == arr[pointer-1]){
                counter++;
                pointer++;
            }
            if(pointer != 1)
                pointer++;

            if(counter >= max)
                max = counter;
            else
                counter = 0;

        }

        return max;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,2,6,6,6,6,7,10};
        F_ElementAppearingMoreThan25_Percent f = new F_ElementAppearingMoreThan25_Percent();
        System.out.println(f.findSpecialInteger(arr));
    }
}
