package array;


public class SubArrayMaxSum {

    /*

    4,1,-5,7,8,6,-2 ==> 7+8+6 ==>21 ==> Max

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
    public static void main(String[] args) {
        int a [] = {4,1,-5,7,8,6,-2};
        System.out.println(maxSumSubArray(a,a.length));

        int a1 [] = {5,-6,3,4,-2,3,-3};
        System.out.println(greedyApproach(a1));

        int a2 [] = {-10,1,9,4,-3,5};
        System.out.println(greedyApproach(a2));
    }
}