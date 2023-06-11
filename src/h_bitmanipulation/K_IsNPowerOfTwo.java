package h_bitmanipulation;

public class K_IsNPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new K_IsNPowerOfTwo().isNPowerOfTwo(24));
    }


    /*
    * N = 16 ==> 1000
    * N = 15 ==> 0111
    *
    * 16 & 15 ==> 0
    *
    * N = 24 ==> 11000
    * N = 23 ==> 10111
    *
    *  24 & 23 != 0
    *
    *
    * */
    public boolean isNPowerOfTwo(int n){
        return (n & (n-1)) == 0;
    }
}
