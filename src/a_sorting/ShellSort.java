package a_sorting;

import java.util.Arrays;


public class ShellSort {
    public static void main(String[] args) {
        int[] a = new int[]{20, 35, -15, 7, 55, 1, -22};
        shellSort(a);
        System.out.println(Arrays.toString(a));

    }

    /*
    * Variation of Insertion sort
    * Insertion sort chooses which element to insert using gap of 1
    * Shell sort stands out using larger gap value unlike insertion sort using gap of 1
    * Since the gap is reduced, amount of shifting is also reduced.
    * In place algorithm
    * worst case : o(n2) quadratic but it can perform much better than that
    * Doesn't require as much shifting as insertion sort
    * Unstable algo

        gap = len / 2 = 7/2 = 3
        i = gap = 3
        j = i
        newElement = a[i]
        Compare a[j-gap] with newElement

        20 35 -15 7 55 1 -22

        i = 3, firstUnsortedElement = a[i]


        gap = gap/2 = 3/2 = 1  ==> Insertion sort only

        20 35 -15 7 55 1 -22


        7 35 -15 20 55 1 -22
        firstUnsortedElement = -22 j=6 gap=3

        7 35 -15 20 55 1 20
        7 35 -15 7 55 1 20
        -22 35 -15 7 55 1 20




    * */
    private static void shellSort(int[] a) {
        for(int gap = a.length/2 ; gap > 0 ;gap /= 2){
            for(int i = gap;i<a.length; i++){
                int firstUnsortedElement = a[i];
                int j = i;
                while(j>= gap && firstUnsortedElement < a [j-gap]){
                    a[j] = a[j-gap];
                    j = j-gap;
                }
                a[j] = firstUnsortedElement;
            }

        }
    }
}