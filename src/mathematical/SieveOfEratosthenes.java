package mathematical;

import java.util.Arrays;

public class SieveOfEratosthenes {

	public static boolean[] getPrimeNoUptoN(int n) {
		boolean[] nos = new boolean[n];
		for(int i = 2;i<n;i++)
			nos[i] = true;
		
		
		for(int i =2 ;i<=(n/2); i++) {
			if(inPrime(i)) {
				for(int j = (i*2); j<n; j=(j+i)) {
					nos[j]=false;
				}
			}
		}
		
		
		return nos;
	}
	
	private static boolean inPrime(int n) {
		if(n <=1 )
			return false;
		if(n <= 3)
			return true;
		
		if(n%2 == 0 || n%3 == 0)
			return false;
		
		
		for(int i = 5;i*i<n; i=i+6) {
			if(n%i == 0 || (n% (i+2) == 0)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int i = 10000;
		boolean [] aa = getPrimeNoUptoN(i);
		for(int x = 1 ; x<i;x++) {
			if(aa[x] == true)
				System.out.print((x)+" ");
		}
		
		
	}
}
