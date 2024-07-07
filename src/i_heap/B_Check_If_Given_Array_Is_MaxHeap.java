package i_heap;


/*
https://www.geeksforgeeks.org/problems/does-array-represent-heap4345/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=does-array-represent-heap

https://www.geeksforgeeks.org/how-to-check-if-a-given-array-represents-a-binary-heap/

* */
public class B_Check_If_Given_Array_Is_MaxHeap {

    public static void main(String[] args) {
        long [] arr = {90, 15, 10, 7, 12, 2};
        B_Check_If_Given_Array_Is_MaxHeap sol = new B_Check_If_Given_Array_Is_MaxHeap();
        System.out.println(sol.countSub(arr,arr.length));
    }



    //Time complexity: O(n), Where n is the total number of elements in the given array.
    //Auxiliary Space: O(1), As constant extra space is used.
    public boolean countSub(long arr[], long n) {

        //Starting from root node and going till most right most internal node
        //Parent of last node(n-1) = (n-1)-1/2

        for(int i = 0; i<= (n-2)/2; i++){

            //If left node is greater than current node for max heap
            if(arr[(2*i)+1] > arr[i] )
                return false;

            //If right node is greater than current node for max heap
            int k = (2*i)+2;
            if(k < n && arr[k] > arr[i])
                return false;
        }

        return true;
    }


    //Recursive solution
    //Time complexity: O(n)
    //Auxiliary Space: O(h), Here h is the height of the given tree and
    // the extra space is used due to the recursion call stack.
    public  boolean isHeap(int arr[],int i, int n)
    {
        // If (2 * i) + 1 >= n, then leaf node, so return true
        if (i >= (n - 1) / 2) {
            return true;
        }

        // If an internal node and is greater than its  children, and same is  recursively true for the children
        if (arr[i] >= arr[2 * i + 1]
                && arr[i] >= arr[2 * i + 2]
                && isHeap(arr, 2 * i + 1, n)
                && isHeap(arr, 2 * i + 2, n)) {
            return true;
        }

        return false;
    }

}
