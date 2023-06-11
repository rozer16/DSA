package array;
import java.util.*;


 import java.io.*;
 import java.util.*;

 public class I_CostToReachLastRowIn2D {
	 
	 public static int getMinAdj(List<Integer> list, int aboveRowXIndex,int maxXIndex) {
		 //Initially keeping min as same column of above row. 
		 int min = aboveRowXIndex;
		 
		 //check if above row min column is not zero then only doing aboveRowXIndex-1
		 if(aboveRowXIndex != 0) {
			 if(list.get(min) > list.get(aboveRowXIndex-1)) {
				 min = aboveRowXIndex-1;
			 }
		 }
		 //check if above row min column is not max then only doing aboveRowXIndex+1
		 if(aboveRowXIndex != maxXIndex) {
			 if(list.get(min) > list.get(aboveRowXIndex+1)) {
				 min = aboveRowXIndex+1;
			 }
			 
		 }
		 return min;
	 }

	  public static int findMinCost(List<List<Integer>> mat){

		         int minEnergy = Integer.MAX_VALUE;
		     
		         //Outer loop to check every element of first row and then calculate cost to reach last row
		         for(int i = 0;i<mat.get(0).size();i++) {
		        	 //Initialize cost for current iteration with first row ith element
		        	 int en = mat.get(0).get(i);
		        	 //Check if minEnergey value is less than ith element of first row then skip it.
		        	 if(en > minEnergy && i>0)
		        		 continue;
		        	 int currentRowMinYIndex = 0;
		        	  for(int y = 1 ;y<= 3;y++){
				             List<Integer> currentRow = mat.get(y);
				             //if this is second row then first row would be default i only.
				             if(y == 1) {
				            	 currentRowMinYIndex = i;
				             }
				             currentRowMinYIndex = getMinAdj(currentRow,currentRowMinYIndex,mat.get(0).size()); 	
				             en += currentRow.get(currentRowMinYIndex);
				         }
		        	  minEnergy = Math.min(minEnergy, en);
		        	
		         }
		       
		         return 100-minEnergy;
	    }
	 
	    public static void main(String[] args)
	    {
			
			  int[][] cost1 = { { 10,20,30,40 },
				  				{ 60,50,20,80 },
				  				{ 10,10,10,10 }, 
				  				{ 60,50,60,50} };
			 List<List<Integer>> cost = Arrays.asList(Arrays.asList(  4,6,14,21 ),Arrays.asList(17,0,5,5),Arrays.asList(4,41,22,3),Arrays.asList(2,51,6,0));
	    	
	    	System.out.println(findMinCost(cost));
	        
	    }
 }
