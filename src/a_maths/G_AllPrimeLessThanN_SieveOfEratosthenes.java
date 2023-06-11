package a_maths;


// https://leetcode.com/problems/count-primes/


import java.util.ArrayList;
import java.util.List;

public class G_AllPrimeLessThanN_SieveOfEratosthenes {

    public boolean isPrime(int n) {
        if (n <= 1)
            return false;

        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;


        for (int i = 5; i * i < n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

    public List<Integer> sieveOfEratosthenes(int n){
        List<Integer> result  = new ArrayList<>(n/2);
        boolean [] arr = new boolean[n+1];
        for(int i=0;i<n;i++)
            arr[i] = true;

        arr[1] =false;
        for(int i=2;i*i<=n;i++) {
            if (isPrime(i) && arr[i]) {
                int j = i;
                for (j = i + j; j <= n; j = j + i)
                    arr[j] = false;
            }
        }
        for(int i=1;i<n;i++) {
            if(arr[i] == true)
                result.add(i);
        }

        return result;


    }

    public   boolean[] getPrimeNoUptoN(int n) {
        boolean[] nos = new boolean[n];
        for(int i = 2;i<n;i++)
            nos[i] = true;


        for(int i =2 ;i<=(n/2); i++) {
            if(nos[i] != false && isPrime(i)) {
                for(int j = (i*2); j<n; j=(j+i)) {
                    nos[j]=false;
                }
            }
        }


        return nos;
    }

    public static void main(String[] args) {
        G_AllPrimeLessThanN_SieveOfEratosthenes test = new G_AllPrimeLessThanN_SieveOfEratosthenes();
        System.out.println(test.sieveOfEratosthenes(10));
    }
}
