package h_bitmanipulation;

public class C_Print1ToNXOR {
    public static void main(String[] args) {
        C_Print1ToNXOR test = new C_Print1ToNXOR();
        System.out.println(test.print1ToNXOR(7));
    }


    /*
    *
    * N = 1(0001) ==> 0001               ==> 1
    * N = 2(0010) ==> 0001^0010 => 0010  ==> 3
    * N = 3(0010) ==> 0010 ^ 0010        ==> 0
    * N = 4(0100) ==> 0100 ^ 0           ==> 4
    * N = 5(0101) ==> 0101^0100 => 0001  ==> 1
    * N = 6(0110) ==> 0110^0001 => 0111  ==> 7
    * N = 7(0111) ==> 0111^0111 => 0000  ==> 0
    * N = 8(1000) ==> 1000^0000 => 1000  ==> 8
    *
    *
    *
    * */
    private int print1ToNXOR(int n) {
        if(n%4 == 0)
            return n;
        if(n%4 == 1)
            return 1;
        if(n%4 == 2)
            return n+1;
        if(n%4 == 3)
            return 0;

        return -1;



    }
}
