package o_dp.A_IntroToDP;

public class A2_Fibbonacci_Recursive {

    public static void main(String[] args) {
        System.out.println("5th fibbonacci series is "+fibbonacci(4));
    }

    public static int fibbonacci(int n){
        if(n <= 1)
            return n;

        return fibbonacci(n-2) + fibbonacci(n-1);

    }
}
