package o_dp.G_LonngestIncreasingSubsequence;

public class F2_LongestBitonicSubsequence {
    public static void main(String[] args) {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        F2_LongestBitonicSubsequence solution = new F2_LongestBitonicSubsequence();
        System.out.println(solution.getLongestBitonicSubSequence(arr)); //6

        int arr1[] = {7,4,8};
        System.out.println(solution.getLongestBitonicSubSequence(arr1)); //2
    }

    public int getLongestBitonicSubSequence(int [] arr){
        int n = arr.length;
        int dp1 [] = new int[arr.length];


        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp1[i]<dp1[j]+1){
                    dp1[i] = dp1[j]+1;

                }
            }
        }


        int dp2 [] = new int[arr.length];

        for (int i = n-1; i >=0; i--) {
            dp2[i] = 1;
            for (int j = n-1; j >i; j--) {
                if(arr[j] < arr[i] && dp2[i]<dp2[j]+1){
                    dp2[i] = dp2[j]+1;

                }
            }
        }


        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp1[i]+dp2[i]-1);
        }

        return maxi;
    }
}
