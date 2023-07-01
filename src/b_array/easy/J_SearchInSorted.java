package b_array.easy;

public class J_SearchInSorted {

    public static void main(String[] args) {
        J_SearchInSorted test = new J_SearchInSorted();
        int arr[] = {1 ,2,3, 4, 6};
        System.out.println(test.searchInSorted(arr,arr.length,00010));
    }

    public int searchInSorted(int [] arr, int N,int K){
        int left = 0;
        int right = N-1;

        while(left <= right){
            int mid = left+(right-left)/2;
            if(arr[mid] == K)
                return 1;
            else{
                if(arr[mid] > K){
                    right = mid-1;
                }else{
                    left = mid+1;
                }

            }
        }
        return -1;
    }
}
