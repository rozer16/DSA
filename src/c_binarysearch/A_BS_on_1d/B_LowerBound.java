package c_binarysearch.A_BS_on_1d;
/*
https://takeuforward.org/arrays/implement-lower-bound-bs-2/
https://takeuforward.org/arrays/implement-upper-bound/

* Given a non decreasing array of int and another variable x, find the index of x's lower bound in the array if there is none then return -1

 The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is notfound, the lower bound algorithm returns n i.e. size of the given array.
arr[] = {1,2,2,3}, x = 2 , lower bound : 1




The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than the given key i.e. x.
The upper bound is the smallest index, ind, where arr[ind] > x.
arr[] = {3,5,8,9,15,19}, x = 9, Upper bound : 4



The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate,
thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.
 *
*
* 3 5 8 15 19
*
* x = 8 ==> lb = 2
* x = 9 ==> lb = 3
* x = 20 ==> lb= 5
*
 * x = 8 ==> ub = 3
 * x = 9 ==> lb = 3
 * x = 20 ==> lb= 5
*
* */
public class B_LowerBound {
    public int getLowerBound(int [] arr,int k){
        int len = arr.length;
        int left = 0;
        int right = arr.length-1;
        int result = -1;

        while(left <= right){
            int mid = (right+left)/2;
            if(arr[mid] >= k){
                result = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return result > 0 ? result : len;
    }

    public int getUpperBound(int arr[] , int x){
        int len = arr.length;
        int high = len-1;
        int low = 0;
        int result = -1;

        while(low < high){
            int mid = low+(high-low)/2;
            if(arr[mid] > x){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return result > 0 ? result : len;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,2,8,10,13,13,21,30};
        B_LowerBound test = new B_LowerBound();
        System.out.println(test.getLowerBound(arr,25));
    }

}
