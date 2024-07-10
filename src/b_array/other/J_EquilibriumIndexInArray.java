package b_array.other;

import java.util.*;

public class J_EquilibriumIndexInArray {

    int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        J_EquilibriumIndexInArray test = (J_EquilibriumIndexInArray) o;
        return id == test.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    static int findElement(int arr[], int size)
    {
        int right_sum = 0, left_sum = 0;

        // Computing right_sum
        for (int i = 1; i < size; i++)
            right_sum += arr[i];

        // Checking the point of partition
        // i.e. left_Sum == right_sum
        for (int i = 0, j = 1; j < size; i++, j++) {
            right_sum -= arr[j];
            left_sum += arr[i];

            if (left_sum == right_sum)
                return arr[i + 1];
        }

        return -1;
    }

    // Driver
    public static void main(String args[])
    {
        int arr[] = { 2, 3, 4, 1, 4, 5 };
        int size = arr.length;
        System.out.println(findElement(arr, size));
    }


}





