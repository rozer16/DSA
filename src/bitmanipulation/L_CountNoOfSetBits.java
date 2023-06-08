package bitmanipulation;

public class L_CountNoOfSetBits {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(new L_CountNoOfSetBits().countNoOfSetBits(x));
    }


    /*
    * TC : O(MSB) Most Significant bit
    *
    * 12 : 1100
    *
    * 2nd bit is MSB for 12
    *
    * */
    public int countNoOfSetBits(int n){
        int count = 0;
        while(n>0){
            if((n & 1) == 1)
                count++;

            n = n>>1;
        }
        return count;
    }

    /*
    * N = 14 ==> 1110
    *
    * 1st Iteration : 1110 & 1101 ==> 1100 , count =1
    * 2nd iteration : 1100 & 1011 ==> 1000 , count =2
    * 3rd iteration : 1000 & 0111 ==> 0000
    *
    *
    * TC : O(set bits) ==> 3
    *
    * */
    public int countNoOfSetBits1(int n){
        int count = 0;
        while(n>0){
            count++;

            n = n&(n-1);
        }
        return count;
    }
}
