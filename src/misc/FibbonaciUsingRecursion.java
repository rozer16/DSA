package misc;

import java.util.ArrayList;

public class FibbonaciUsingRecursion {

    public static void main(String[] args) {
        System.out.println(getFibboNaci(5));
    }

    /*
    f[0] = 0;
    f[1] = 1;
    f[n] = f[n-1] + f[n-2]

    * */
    public static  int getFibboNaci(int no) {
    	System.out.println("Fibbonaci : "+no);
        if (no < 2) {
            return no;
        } else {
            return getFibboNaci(no-1)+getFibboNaci(no-2);
        }


    }
}
