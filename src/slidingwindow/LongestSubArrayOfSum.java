package slidingwindow;


/*

    * Given an array of positive integers and integer S, find the longest
      subarray of sum maximum S

      nums : {3,2,5,2,2,1,1,3,1,2}
      S : 11

      output 3...8 , sum = 10
* */
public class LongestSubArrayOfSum {

    public static void bruteforceApproach1(int [] arr, int s) {
        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;

        int [] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for(int i =1 ;i< arr.length;i++)
            prefixSum[i] = prefixSum[i-1]+arr[i];

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            if(i==0){
                while(prefixSum[j] < s)
                    j++;
            }else{
                while(prefixSum[j]-prefixSum[i-1] < s)
                    j++;
            }
            int length = j - i;
            if (maxLen < length) {
                maxLen = length;
                left = i;
                right = j - 1;
            }
        }
        System.out.println(left+"..."+right);
    }
    public static void bruteforceApproach(int [] arr, int s){
        int left=0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0;i< arr.length; i++){
            int sum = 0;
            for(int j=i;j<arr.length;j++){
                sum += arr[j];
                if(sum >  s){
                    int length = j - i;
                    if(maxLen < length) {
                        maxLen = length;
                        left = i;
                        right = j-1;
                    }

                    break;
                }
            }
        }
        System.out.println(left+"..."+right);

    }

    public static void main(String[] args) {
        int [] arr = {3,2,5,2,2,1,1,3,1,2};
        bruteforceApproach1(arr,11);
    }
}
