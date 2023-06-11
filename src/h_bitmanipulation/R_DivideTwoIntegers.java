package h_bitmanipulation;


/*
* Return the quotient after dividing dividend by divisor.
https://leetcode.com/problems/divide-two-integers/
Note: Assume we are dealing with an environment that could only store integers
* within the 32-bit signed integer range: [−231, 231 − 1].
* For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1,
*  and if the quotient is strictly less than -231, then return -231.
*
*
* Note: Assume we are dealing with an environment that could only store integers
*  within the 32-bit signed integer range: [−231, 231 − 1]. For this problem,
*  if the quotient is strictly greater than 231 - 1, then return 231 - 1,
*  and if the quotient is strictly less than -231, then return -231.
*
*
*
* */
public class R_DivideTwoIntegers {
    public static void main(String[] args) {
        R_DivideTwoIntegers test = new R_DivideTwoIntegers();
        int divident = 2147483647;
        int divisor = -1;
        System.out.println(test.divideTwoIntegers(divident,divisor));
    }


    /*
    *
    * BruteForce Approach :
    *
    * 100   100 100 100 100  100  100
    * 3*1   3*2 3*4 3*8 3*16 3*32 3*64
    *
    * 100   100     100
    * 3*32  3*33    3*34
    *
    *
    * */
    public int divideTwoIntegers(int dividend, int divisor){

        if(dividend == 0)
            return 0;
        if(dividend <= Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend <= Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(dividend >= Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE+1;
        if(dividend >= Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;



        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);
        int ans = 0;
        while(dividend1 >= divisor1){
            long sum = divisor1;
            int count = 1;

            while(sum <= (dividend1-sum)){
                sum+=sum;
                count+=count;
            }
            ans+= count;
            dividend1 -=sum;
        }

        if((dividend < 0 && divisor > 0)  || (dividend > 0 && divisor < 0))
            return -ans;
        return ans;
    }
}
