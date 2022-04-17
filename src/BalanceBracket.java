import java.util.*;

public class BalanceBracket {
	
	public static void main(String[] args) {
		 String s1 = "][(])";
		 String s2 = "[()]{}{[()()]()";
		 System.out.println("========================="+validateStr1(s1));
	}
	/*private static boolean validateStr(String s1) {
		  boolean result  = true;
		  char [] chars = s1.toCharArray();
		  List<Integer> Openingbrackets = Arrays.asList((int)'[',(int)'{',(int)'(');
		  List<Integer> closingbrackets = Arrays.asList((int)']',(int)'}',(int)')');
		  Stack<Character> charStack = new Stack<>();
		  for(char c : chars){
		    if(Openingbrackets.contains((int)c)){
		       charStack.push(c);
		    }else if(closingbrackets.contains((int)c)){
		        if(charStack.isEmpty())
		          return false;
		        char c1 = charStack.peek();
		        int closeIndex = closingbrackets.indexOf((int)c);
		        int openIndex =  Openingbrackets.indexOf((int)c1);
		        if(closeIndex != openIndex){
		            result = false;
		            break;
		        }else{
		          charStack.pop();
		        }
		       
		    }
		    
		  } 
		  return result;
		}
	
	*/
	private static boolean validateStr1(String s1) {
		  boolean result  = true;
		  char [] chars = s1.toCharArray();
		  List<Character> Openingbrackets = Arrays.asList('[','{','(');
		  List<Character> closingbrackets = Arrays.asList(']','}',')');
		  Stack<Character> charStack = new Stack<>();
		  for(char c : chars){
		    if(Openingbrackets.contains(c)){
		       charStack.push(c);
		    }else if(closingbrackets.contains(c)){
		        if(charStack.isEmpty())
		          return false;
		        char c1 = charStack.peek();
		        int closeIndex = closingbrackets.indexOf(c);
		        int openIndex =  Openingbrackets.indexOf(c1);
		        if(closeIndex != openIndex){
		            result = false;
		            break;
		        }else{
		          charStack.pop();
		        }
		       
		    }
		    
		  } 
		  return result;
		}
}
