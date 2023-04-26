package mathematical;

public class PrimeFactorization {

	
	public PrimeFactorization() {
	
	}
	
	private static void primeFacrtor(int n) {
		
		int len = -1;
		int[]  f = new int[100];
		int[] expo = new int[100];
		
		int d = 2;
		
		
		while(d*d <= n && n >1) {
			int k = 0;
			while( n %d == 0) {
				k++;
				n = n/d;
			}
			if(k > 0) {
				len++;
				f[len] = d;
				expo[len] = k;
				
			}
			d++;
		}
		
		
		if(n>1) {
			len++;
			f[len]=n;
			expo[len] = 1;
		}
		
		if(len==0) {
			System.out.println(f[len]+" * "+expo[len]);
			return;
		}
		for(int i = 0;i<=len; i++) {
			System.out.println(f[i]+" ^ "+expo[i]);
		}
	}
	
	public static void main(String[] args) {
		primeFacrtor(100);
		
	}
}
