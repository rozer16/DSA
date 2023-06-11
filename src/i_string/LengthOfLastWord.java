package i_string;

public class LengthOfLastWord {

	/*
	 * This is brute force approach.
	 * 
	 * If we iterate the string from left to right, we would have to be careful about the spaces after the last word. 
	 * The spaces before the first word can be ignored easily. However,
	 * it is difficult to detect the length of the last word if there are spaces at the end of the string.
	 * This can be handled by trimming the spaces before or at the end of the string.
	 *  If modifying the given string is restricted, we need to create a copy of the string and trim spaces from that.  
	 * */
	public static int getLastWordLength(String s) {
		String s1 = s.trim();
		int result = 0;
		int len = 0;
		while(len < s1.length()){
			if(s1.charAt(len) == ' ')
				result = 0;
			else {
				result++;
			}
			len++;
		}
	
		return result;
	}
	

	/*
	 * Trim is not allowed
	 * */
	public static int getLastWordLength1(String s1) {
		int result = 0;
		int pointer= 0;
		while(pointer < s1.length()) {
			if(s1.charAt(pointer) != ' ') {
				pointer++;
				result++;
			}else {
				while(pointer < s1.length() && s1.charAt(pointer) == ' ')
					pointer++;
				
				if(pointer == s1.length()-1)
					return result;
				else
					result = 0;
			}
		}
		
		return result;
	}
	
	
	/*
	 * We are allowed to use trim function
	 * */
	public static int getLastWordLength2(String s) {
		int result = 0;
		String s1 = s.trim();
		for(int i = s1.length()-1; i>=0 ; i--) {
			if(s1.charAt(i)== ' ') {
				return result;
			}else {
				result++;
			}
		}
		return result;
	}
	
	

	
	public static void main(String[] args) {
		String statement = "Hello World";
		String statement1 = "   123456789   ";
		int result = getLastWordLength2(statement);
		System.out.println(result);
	}
}
