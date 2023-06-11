package h_bitmanipulation;

public class H_setIthBit {


    /*
    * N = 12 : 1100
    * i = 0001 ==> 1<<1  : 0010
    *
    * N | i ==> will set ith bit
    *
    * */
    public int setIthBitOfNumber(int N,int i){
        return ((1<<i) | N);
    }

    public static void main(String[] args) {
        int x = 10;
        int i = 2;

        System.out.println(Integer.toBinaryString(x));
        int n = new H_setIthBit().setIthBitOfNumber(x,1);
        System.out.println(Integer.toBinaryString(n));
    }
}
