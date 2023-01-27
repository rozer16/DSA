package array;


public class SubArrayMaxSum {

    private static int maxSumSubArray(int [] arr,int n){
        int ans = 0;
        int s [] = new int[n];
        s[0] = arr[0];
        int minS = 0;
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

    public static void main(String[] args) {
        int a [] = {4,1,-5,7,8,6,-2};
        System.out.println(maxSumSubArray(a,a.length));
    }
}