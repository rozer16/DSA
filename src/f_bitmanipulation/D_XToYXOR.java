package f_bitmanipulation;


/*
*
* XOR(3-6) ==> 3^4^5^6
* XOR (R) ==> 1^2^3^4^5^6
* X(L-1) = X(2) = 1^2
*
* X(R) ^ X(L-1) ==> (1^2^3^4^5^6) ^ (1^2) ==> 3^4^5^6
* */
public class D_XToYXOR {

    public static void main(String[] args) {
        D_XToYXOR test = new D_XToYXOR();
        int no = test.XToYXOR(3,6);
        System.out.println(no);
    }

    private int XToYXOR(int i, int i1) {
        return print1ToNXOR(i1)^print1ToNXOR(i-1);
    }

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
