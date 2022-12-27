package string;
import java.util.*;


 public class CharRollOut{
	    
	 public static void main(String[] args) {
		String s = "bca";
	    List<Integer> roll = Arrays.asList(1,2,3);
	    System.out.println(rollOut(s, roll));
	}
	    
	    private static String rollOut(String s,List<Integer> roll) {
	    	char [] chars = s.toCharArray();
	    	for(int i = 0;i<chars.length;i++) {
	    		
	    		int position = i+1;
	    		long count = roll.stream().filter(x -> x >= position ).count();
	    		if(count == 0)
	    			break;
	    		if(chars[i] == 'z') {
	    			chars[i] = 'a';
	    		}else {
	    			chars[i] =(char) (chars[i]+count);
	    		}
	    	}
	    	
	    	
	    	return String.valueOf(chars);
	    }

	    
}
