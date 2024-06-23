package n_dp.G_LonngestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C2_LIS_BinarySearch {

    public static void main(String[] args) {

    }

    /*
    Time Complexity: O(N*logN)

    Reason: We iterate over the array of size N and in every iteration,
    we perform a binary search which takes logN time.

    Space Complexity: O(N)

    Reason: We are using an extra array of size N to store the temp variable.
    * */
    int longestIncreasingSubsequence(int[] arr, int n) {

        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        int len = 1;


        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                // arr[i] > the last element of temp array

                temp.add(arr[i]);
                len++;
            }else {
                // Replacement step
                int ind = Collections.binarySearch(temp, arr[i]);

                if (ind < 0) {
                    ind = -ind - 1;
                }

                temp.set(ind, arr[i]);
            }
        }
            return 0;
    }

    //The lower bound is the first element that is greater than or equal to x
    public int getLowerBound(int [] arr,int k){
        int left = 0;
        int right = arr.length-1;
        int ans = -1;

        while(left <= right){
            int mid = (right+left)/2;

            if(arr[mid] >= k){
                ans = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return ans;
    }


    public int getLowerBound(List<Integer> list, int key){
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
           Integer midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }
}
