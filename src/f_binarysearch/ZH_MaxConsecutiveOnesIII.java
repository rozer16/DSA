package f_binarysearch;

public class ZH_MaxConsecutiveOnesIII {

        //Complexity : O(n)
        public int longestOnes(int [] a, int k){
            int ans = 0;
            int j = 0;
            int n = a.length;
            for(int i = 0; i < n; i++){
                if(a[i] == 0) k--;
                while(j <= i && k <0){
                    if(a[j] == 0){
                        k++;
                    }
                    j++;
                }
                ans =i - j + 1>  ans ? i-j+1 : ans;
            }
            return ans;
        }

    public  int maxConsecutiveOnes(int[] nums, int k) {
        int left = 0, right = 0, zeroCount = 0, maxCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }

        return maxCount;
    }
    public static void main(String[] args) {
        ZH_MaxConsecutiveOnesIII test = new ZH_MaxConsecutiveOnesIII();
        int arr [] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(test.longestOnes(arr,2));
    }
}
