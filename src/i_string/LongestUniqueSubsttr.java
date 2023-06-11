package i_string;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubsttr {
	
	/*
	  Time Complexity: O(n) since we slide the window whenever we see any
	  repetitions.
	  
	  Auxiliary Space: O(1)
	 */
	public static int longestUniqueSubstr(String str) {
		
		int maxLen = 0;
		String test = "";
		for(char c : str.toCharArray()) {
			if(test.contains(String.valueOf(c))) 
				test = test.substring(str.indexOf(c)+1);
			test = test+c;
			maxLen = Math.max(maxLen, test.length());
		}
		return maxLen;
	}

	public static int longestUniqueSubstr1(String str) {

		Map<Character,Integer> map = new HashMap<>();
		int ans=1;
		int j=0;
		char [] chars = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if(map.containsKey(chars[i])){
				j=map.get(chars[i]);
				map.remove(chars[i]);
			}
			map.put(chars[i],i+1);
			if(ans < (i-j+1))
				ans = i-j+1;
		}
		return ans;
	}
	
	
	/*
	 * 
	 * Time Complexity: O(n^2) since we are traversing each window to remove all repetitions.
		Auxiliary Space: O(1)
	 * */
	public static int longestUniqueSubsttr(String str)
	{
	    int n = str.length();
	     
	    // Result
	    int res = 0;
	     
	    for(int i = 0; i < n; i++)
	    {
	         
	        // Note : Default values in visited are false
	        boolean[] visited = new boolean[256];
	         
	        for(int j = i; j < n; j++)
	        {
	             
	            // If current character is visited
	            // Break the loop
	            if (visited[str.charAt(j)] == true)
	                break;
	 
	            // Else update the result if
	            // this window is larger, and mark
	            // current character as visited.
	            else
	            {
	                res = Math.max(res, j - i + 1);
	                visited[str.charAt(j)] = true;
	            }
	        }
	 
	        // Remove the first character of previous
	        // window
	        visited[str.charAt(i)] = false;
	    }
	    return res;
	}
	 
	// Driver code
	public static void main(String[] args)
	{
	    String str = "abcbdef";
	    System.out.println("The input string is " + str);
	 
	    int len = longestUniqueSubstr(str);
	    System.out.println("The length of the longest " +
	                       "non-repeating character " +
	                       "substring is " + len);

		System.out.println(longestUniqueSubstr1(str));
	}
}

