package b_array.medium;

/*
*
* https://leetcode.com/problems/maximum-subarray/
*
* */
public class D_SubArrayMaxSum {


    public static void main(String[] args) {
        int a [] = {4,1,-5,7,8,6,-2};
        System.out.println(getMaxSumSubArray(a)); //Index : 3-5

        int [] a3 = {-2,-3,4,1,-2,1,5,-3}; //Index : 2-6, suum=  9
        System.out.println(getMaxSumSubArray(a3));

        int a1 [] = {5,-6,3,4,-2,3,-3};
        System.out.println(getMaxSumSubArray(a1)); //Index : 2-5

        int a2 [] = {-10,1,9,4,-3,5};
        System.out.println(getMaxSumSubArray(a2));//Index : 1-5

        int [] a4 = {-2,-4,-6,-1,-5,-4};
        System.out.println(getMaxSumSubArray(a4));//Index : 1-5

    }

    /*
     * Kadane's algorithm
     *
     * Step 1 : Initialize two vars, currentSum, maxSum
     * Step 2 : Iterate from i=0 to n-1 and repeat step 3 to 5
     * Step 3 : Add arr[i] to currentSum
     * Step 4 : set maxSum = Math.max(currentSum, maxSum)
     * Step 5 : if currentSum < 0 ==> set currentSum = 0
     * */

    public static int getMaxSumSubArray(int [] arr){
        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int startIndex = -1, endIndex = -1;
        int start = -1;
        for(int i=0;i<arr.length;i++){

         /*   if(current_sum < 0 && arr[i] > current_sum)
                current_sum = 0;


            current_sum += arr[i];
            if(current_sum > max_sum)
                max_sum = current_sum;*/

            //Below condition is only for index,  not sum
            if(current_sum == 0){
                startIndex = i;
            }


            current_sum += arr[i];


            if(current_sum > max_sum) {
                max_sum = current_sum;

                endIndex = i;
            }

            if(current_sum < 0)
                current_sum = 0;
        }
        System.out.println("Index : "+startIndex+"-"+endIndex);
        return max_sum;
    }




    /*
    4,1,-5,7,8,6,-2 ==> 7+8+6 ==>21 ==> Max

    PS : 4,5,0,7,15,21,19

      1. Apply partial sum and store in s[]
      2. initialize ans = misSum = 0;
      3. Iterate all element and store min element from partial element.
      4. check if s[i]-minSum > ans, store s[i]-ans in ans
      5. s[i]-ans gives you sum of element between index where ans is stored to ith element

    * */
    private static int maxSumSubArray(int [] arr,int n){
        int ans = 0;
        int s [] = new int[n];
        s[0] = arr[0];
        int minS = 0;

        //[4, 5, 0, 7, 15, 21, 19]
        //array to store sum of o...i at element s[i]
        for (int i = 1; i < n; i++) {
            s[i] = arr[i]+s[i-1];
        }

        for (int i = 1; i < n; i++) {
            if(s[i] - minS > ans)
                ans = s[i] - minS;


            if(minS > s[i])
                minS = s[i];
        }
        return ans;



    }

    /*
    ans = sum = a[0]
        i = 1 to n
        if(sum < 0)
            sum = 0;
        sum = sum + a[i]
        if(sum > ans)
            ans = sum;



    * */

    public static int greedyApproach(int [] arr){
        int ans = arr[0];
        int sum = arr[0];

        for(int i=1 ; i<arr.length ; i++){
            if(sum < 0){
                sum = 0;
            }
            sum = sum + arr[i];
            if(sum > ans)
                ans = sum;

        }
        return ans;
    }

}