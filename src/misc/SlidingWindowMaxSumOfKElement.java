package misc;

import java.util.*;

public class SlidingWindowMaxSumOfKElement {

    public static void main(String[] args) {
        List<Integer> nos = Arrays.asList(1,2,3,4,5); 
        System.out.println(getSumOfConsecutiveNElemnent(nos, 3));
    }

    
    
   /*
    * Complexity : O(k*n)
    * */
    public static int getSumOfConsecutiveNElemnent(List<Integer> no,int k) {
    	int n = no.size();
    	int maxSum = Integer.MIN_VALUE;
    	for(int i = 0;i<=(n-k);i++) {
    		int sum = 0;
    		for(int j = 0;j<k;j++) {
    			sum += no.get(i+j);  
    		}
    		maxSum = Math.max(maxSum, sum);
    	}
    	return maxSum;
    }
    
    
    
    
}
