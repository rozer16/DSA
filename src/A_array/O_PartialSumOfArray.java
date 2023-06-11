package A_array;


import java.util.Arrays;

/*
* Arr : 7 -2 3 9 -11 5 1 -3
*
* sum(2,6) = 3+9-11+5+1 = 4
* sum(5,8) = -11+5+1-3=-8
*
*
*
*
* */
public class O_PartialSumOfArray {

    /*
    *
    * Complexity : O(endIndex-startIndex+1) ==~ O(n)
    *
    * expected : O(1) per query
    *
    * */
    public static int bruteForceApproach(int [] arr,int startIndex, int endIndex){

        if(startIndex > arr.length || endIndex > arr.length)
            return 0;
        int result = 0;
        for(int i=startIndex;i<=endIndex;i++){
            result = result+arr[i];
        }

        return result;
    }



    /*
    *
    * Calculate sum of element from 0th ele to ith ele
    *
    * a[i] = sum(arr[0]...arr[i])
    *
    * arr = 7 -2 3 9 -11 5 1 -3
    * sum = 7 5 8 17 6 11 12 9
    *
    * query(3,5) = sum from o to 5 - sum from 0 to 2
    *              sum[5]-sum[5-3] = 11-8 = 3 = 3+9-11
    * query(x,y) = sum[y]-sum[y-x]
    *
    * */
    public static int optimizedApproach(int [] arr,int startIndex,int endIndex){
        int result = 0;
        int sum [] = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i-1]+arr[i];
        }
        System.out.println(Arrays.toString(sum));


        return  sum[endIndex]-sum[endIndex-startIndex-1];
    }
    public static void main(String[] args) {
        int [] arr = {7,-2,3,9,-11,5,1,-3};
        System.out.println(bruteForceApproach(arr,3,6));
        System.out.println(optimizedApproach(arr,3,6));
    }
}
