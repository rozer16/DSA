package b_array.other;

public class M_ElementAtIthIndex {
	public static void main(String[] args) {
		
		int []a ={1,5,3,7,9,2,5,7,4};
		IElementAtIthIndex(a);
		System.out.println();
	}
	
	 public static int[] IElementAtIthIndex(int[] A) 
	    { 
	        for (int i = 0; i < A.length; i++)  
	        { 
	            if (A[i] != -1 && A[i] != i) 
	            { 
	                int x = A[i]; 
	  
	                // check if desired place 
	                // is not vacate 
	                while (A[x] != -1 && A[x] != x)  
	                { 
	  
	                    // store the value from 
	                    // desired place 
	                    int y = A[x]; 
	  
	                    // place the x to its correct 
	                    // position 
	                    A[x] = x; 
	  
	                    // now y will become x, now 
	                    // search the place for x 
	                    x = y; 
	                } 
	  
	                // place the x to its correct 
	                // position 
	                A[x] = x; 
	  
	                // check if while loop hasn't  
	                // set the correct value at A[i] 
	                if (A[i] != i) 
	                { 
	  
	                    // if not then put -1 at 
	                    // the vacated place 
	                    A[i] = -1; 
	                } 
	            } 
	        } 
	        return A; 
	    } 
}
