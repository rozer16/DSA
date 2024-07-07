package c_binarysearch.B_BS_on_answers;

public class D_MinDaysToMakeMBuckets {

    public static void main(String[] args) {
        int [] arr1 = {};
        D_MinDaysToMakeMBuckets sol = new D_MinDaysToMakeMBuckets();
       // System.out.println(sol.minDays(arr1,);


    }

    //Using binary search
    //TC : log2n * (max-min+1)
    //SC :
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if(m*k > len)
            return -1;
        int ans = -1;
        int [] minMax = findMinMax(bloomDay);
        //Range can be between min no of days to bloom to max no of days
        int low = minMax[0];
        int high = minMax[1];

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isPossible(bloomDay,m,k,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;

    }
    public int minDaysBruteForce(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if(m*k > len)
            return -1;

        int [] minMax = findMinMax(bloomDay);
        int min = minMax[0];
        int max = minMax[1];
        System.out.println(min+" "+max);
        for(int i = min; i<= max;i++){
            if(isPossible(bloomDay,m,k,i))
                return i;
        }

        return -1;
    }

    public int [] findMinMax(int [] bloomDay){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : bloomDay){
            if(i > max)
                max = i;

            if(i < min)
                min = i;
        }

        return new int[]{min, max};
    }

    public boolean isPossible(int [] bloomDay,int m, int k, int day){
        int n = bloomDay.length;
        int cnt = 0;
        int noOfB = 0;
        for(int i = 0;i<n; i++){
            if(bloomDay[i] <= day){
                cnt++;
            }else{
                noOfB += (cnt/k);
                cnt = 0;
            }
        }
        noOfB += (cnt/k);
        if(noOfB >= m)
            return true;

        return false;
    }
}
