package sorting;


import java.util.Arrays;

/*

* The way bubble sort works is as the algorithm proceeds, it creates logical partition of sorting
* Start with 0 element and swap with subsequent element in case current is greater than the next.
* So the last element in iteration would be biggest element
 and biggest element would be bubbled up at end of array for each iteration.
* decrease the index and repeat the same step.
* Time Complexity : o(n2) -quadratic
* In place algo -- doesn't require extra space.
* Stable Algo.

20 35 -15 -7 55 1 -22
20 -15 35 -7 55 1 -22
20 -15 -7 35 55 1 -22
20 -15 -7 35 1 55 -22
20 -15 -7 35 1 -22 55

-15 20 -7 35 1 -22 55
-15 -7 20 35 1 -22 55
-15 -7 20 1 35 -22 55
-15 -7 20 1 -22 35 55

-15 -7 1 20 -22 35 55
-15 -7 1 -22 20 35 55

-15 -7 -22 1 20 35 55

-15 -22 -7 1 20 35 55

-22 -15 -7 1 20 35 55

* */
public class B_BubbleSort {
    public static void main(String[] args) {
        int [] a = new int[]{20 ,35, -15, 7, 55, 1, -22};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int [] a){
        int unsortedIndexPartition = a.length - 1;
        for(int i = 0 ; i<= a.length - 1 ; i++){
            for(int j = 0 ; j <= unsortedIndexPartition-1 ; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            unsortedIndexPartition--;
        }
    }

}
