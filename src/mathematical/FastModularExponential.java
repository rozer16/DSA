package mathematical;

/*
 
 (a power b) mod c 
 a^2 mod c = (a*a) mod c = ((a mod c)*(a mod c)) mod c
 * 
 * */
public class FastModularExponential {

	
	/*
	 * Complexity : o(n) ==> n is power
	 * 
	 * */
	public static int bruteForceFastModularExponential(int no,int power,int mod) {
		int result = 1;
		
		for(int i = 1;i<=power;i++) {
			//System.out.print("( "+result+"*"+no+" ) % "+mod);
			result = (result*no) % mod;
			//System.out.println(" = "+result);
		}
		
		return result; 
	}
	
	
	/*
	 * if power is even => (base^power) mod c ==> (1l*(base^2)^power/2) mod c
	 * if power is odd => (base^power) mod c => (1l*base * base^power-1) mod c 
	 * 
	 * 
	 * */
	public static int recursiveFastModularExponential(int base, int power,int mod) {
		if(power == 0)
			return 1;
		if(power % 2 == 0)
			return recursiveFastModularExponential((int)(1l*base*base) % mod, power/2, mod);
		return ((int)1l*base*recursiveFastModularExponential(base, power-1, mod)) % mod;
	}
	
	
	
	/*
	 * (base^power) % mod
	 * base = 2 , power = 13, result = 1
	 * 
	 * power is odd => base = 2*2 , power = 12, result = 1 => base =2 , power = 12, result = 2
	 * power is even => base = 4 , power = 6, result = 2
	 * power is even => base = 16 , power = 3 , result = 2
	 * power is odd => base = 16*16 , power = 2 , result = 2 => base=16 , power = 2 ,  result = 32
	 * power is even => base = 256, power = 1 , result =  32
	 * power is odd ==> base 256 * 256*0, power = 0, result = 32 ==> base = 1, power = 0; result = 32*256 = 8192  
	 * */
	public static int iterativeFastModularExponential(int base, int power,int mod) {
		int result = 1;
		while(power > 0 ) {
			if(power %2 == 0) {
				base = (int)(1l*base*base)% mod;
				power = power /2;
			}else {
				result = (int)(1l*result*base)%mod;
				power = power -1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int base = 2;
		int power = 10;
		int mod = 1000000007;
		System.out.println(bruteForceFastModularExponential(base,power,mod));
		System.out.println(recursiveFastModularExponential(base,power,mod));
		System.out.println(iterativeFastModularExponential(base,power,mod));
	}
}
