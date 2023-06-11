package h_binarysearch;
/*
*
* Given a non decreasing array of int and another variable x, find the index of x's lower bound
* in the array if there is none then return -1
*
* The lower bound is the first element that is greater than or equal to x
*
*
*
* 1,2,2,8,10,13,13,21,30
*
* Lower bound of 13 is index 5
*
* */
public class B_LowerBound {
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

    public static void main(String[] args) {
        int arr[] = {1,2,2,8,10,13,13,21,30};
        B_LowerBound test = new B_LowerBound();
        System.out.println(test.getLowerBound(arr,25));
    }

}
