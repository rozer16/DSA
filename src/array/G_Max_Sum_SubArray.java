package array;

public class G_Max_Sum_SubArray {

    //Best solution
    public int maxSubArray(int[] nums) {
        int sum = 0 , maxi = Integer.MIN_VALUE;;
        int i = 0 , j = 0;
        while(j<nums.length){

            if(sum < 0 && nums[j] >= sum){
                sum = 0;
                i = j;
            }
            sum += nums[j];
            maxi = Math.max(maxi , sum);
            j++;
        }
        return maxi;
    }


    public int partialSum_MaxSumSubArray(int [] nums){
        if(nums.length == 0)
            return 0  ;
        int ps[] = new int[nums.length];
        int mins=0;
        int ans = nums[0];
        ps[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ps[i] = ps[i-1]+nums[i];
        }

        for(int i =0;i< nums.length ;i++){
                if(ps[i]-mins > ans)
                    ans = ps[i]-mins;

                if(mins > ps[i])
                    mins = ps[i];
        }

        return ans;

    }


    public int maxSubArray_BruteForce(int [] arr){
        int result = 0;

        for(int left = 0;left<arr.length;left++){
            int currentSum=0;
            for(int right=left;right<arr.length;right++){
                currentSum += arr[right];
                if(currentSum > result)
                    result = currentSum;
            }
        }


        return result;
    }


    /*
    * Doesn't work when all elements are negative.
    *
    * */
    public int maxSumSubArray_Greedy(int [] arr){
        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;


        for(int i=0;i<arr.length;i++){

            if(current_sum < 0 && arr[i] >= current_sum)
                current_sum = 0;


            current_sum += arr[i];
            if(current_sum > max_sum)
                max_sum = current_sum;
        }

        return max_sum;
    }


    public static void main(String[] args) {
        G_Max_Sum_SubArray test= new G_Max_Sum_SubArray();
        int [] arr = {5,-6,3,4,-2,3,3};
        int [] arr1 = {-2,1};
        System.out.println(test.maxSumSubArray_Greedy(arr1));
        System.out.println(test.partialSum_MaxSumSubArray(arr1));

    }


}
