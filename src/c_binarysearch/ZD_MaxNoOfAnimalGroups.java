package c_binarysearch;


import java.util.Arrays;

/*
* You have n different types of animals.
* For each type knowing how many animals you have of that type
* You have to sell the animal only in group k distinct animals.
* Find the max no of group you can sell
*
* n=7
* arr = {1,2,3,4,5,6,7}  --> Already sorted,arr[i] -->  no of animals we have of i type
* k=5 --> Need to sell animals in group of 5 distinct animals
*
*
*
* {1,3,5,6,7} G1
* {2,4,5,6,7} G2
* {2,4,5,6,7} G3
* {3,4,5,6,7} G4
* {3,4,5,6,7} G5
*
*
* So ans is x=5 since we are able to form 5 max groups having 5 distinct animals.
*
*
* so we need to get x(No of groups having k elements)*k() elements
*
*
*         5 5 5
*       5 4 4 4
*     5 4 3 3 3
*   3 4 3 2 2 2
* 1 2 1 2 1 1 1
*
* 1 2 3 4 5 6 7
*
*
* Each no means that animal is in that group for e.g.
*       7 is in group 1,2,3,4,5
*       6 is in group 1,2,3,4,5
*       3 is in group 1,4,5
*
*  So each no in above histogram will appear exactly x times
*  1,1,1,1...1  -> k times
*  2,2,2,2...2  -> k times
*  3,3,3,3...3  -> k times
*  .
*  .
*  .
*  x,x,x,x...x  -> k times
*
*
*
*
* */
public class ZD_MaxNoOfAnimalGroups {

    /*
    *
    * arr[] : no of animals we have of i type
    * n : Total no of types of animal
    * k : Need to sell animals in group of k distinct animals
    * x : max no of groups having k elements
    * */

    public boolean isValid(int [] arr,int n,int k,int x){

        long count = 0l;

        for (int i = 0; i < n; i++) {
            count += Math.min(x,arr[i]);
        }

        return count >= 1l*x*k;
    }


    public int getMaxNoOfAnimalGroup(int arr[], int k){
        int n= arr.length;
        int left = 0;
        int right = Arrays.stream(arr).sum()/k;
        int ans = 0;


        while(left <= right){
            int mid = (left+right)/2;
            if(isValid(arr,n,k,mid)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        ZD_MaxNoOfAnimalGroups test = new ZD_MaxNoOfAnimalGroups();
        System.out.println(test.getMaxNoOfAnimalGroup(arr,5));
    }
}
