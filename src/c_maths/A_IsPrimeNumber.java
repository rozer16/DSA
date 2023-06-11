package c_maths;


/*
 * 1. A number n is not prime if its divisible by 2 to n-1
 * 2. A number n is not prime if multiplication of 2 numbers a * b = n
 * 3. a <= b
 * 4. a square <= a*b
 * 5. a square <= n => if n is divisible by any no less than root n then return false
 * 
 * 
 * 2,3,5,(6k+-i && (n%2 != 0 || n%3 !=0 ) are prime no
 * */


public class A_IsPrimeNumber {

	
	
	
	private static boolean isPrimeNoBruteForce(int no) {
		for(int i = 2;i< (no-1); i++) {
			if(no % i == 0)
				return false;
		}
		
		return true;
		
	}
	
	private static boolean isPrimeNo1(int no) {
		if(no <= 1)
			return false;
		if(no <= 3)
			return true;
		
		if(no % 2 == 0 || no % 3 == 0)
			return false;
		
		
		// This is checked so that we can skip
        // middle five numbers in below loop
		// Forming (6k +- i)
		// starting with i=5 and checking i+2
		for(int i=5; i*i < no ; i = i+6) {
			if(no % i == 0 || no % (i+2) == 0)
				return false;
		}
		
		return true;
		
	}
	public static void main(String[] args) {
		int no =281;
		System.out.println("No : "+no+" is prime ? "+isPrimeNo1(no));
	}
}
