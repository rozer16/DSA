package d_string;
import java.util.Stack;

public class StringGame {
	static class Entity { 
        char character; 
        int frequency; 
        Entity(char p, int q) 
        { 
            character = p; 
            frequency = q; 
        } 
    }
	
	
	static String remove_k_characters(String st1, int n, int k) 
    { 
  
        // Stack to store the character 
        Stack<Entity> st = new Stack<Entity>(); 
  
        int i = 0; 
        for (i = 0; i < n; i++) { 
  
            // the current character 
            char x = st1.charAt(i); 
  
            // if the stack is not empty 
            // and the frequency of the element 
            // at the top of the stack is = k 
            // then pop k elements 
            if (st.size() > 0 && st.peek().frequency == k) { 
  
                // stores the character at 
                // the top of the stack 
                char curr = st.peek().character; 
  
                // while the character 
                // at the top of the stack is curr 
                // pop the character from the stack 
                while (st.size() > 0 && st.peek().character == curr) 
                    st.pop(); 
            } 
  
            // if the stack is not empty 
            // and the top element of the 
            // stack is = x, 
            if (st.size() > 0 && st.peek().character == x) { 
  
                // increase it's frequency and 
                // push it to the stack 
                Entity new_top = new Entity(x, st.peek().frequency + 1); 
                st.push(new_top); 
            } 
  
            // if the current element is 
            // not equal to the character 
            // at the top of the stack 
            else { 
                Entity new_top = new Entity(x, 1); 
                st.push(new_top); 
            } 
        } 
  
        // if the last pushed character 
        // has k frequency, then pop the 
        // top k characters. 
        if (st.size() > 0 && st.peek().frequency == k) { 
  
            // get the character 
            // at the top of the stack 
            char curr = st.peek().character; 
  
            // while the character 
            // at the top of the stack is 
            // curr, pop it from the stack 
            while (st.size() > 0 && st.peek().character == curr) 
                st.pop(); 
        } 
  
        // Stores the string in 
        // reversed fashion from stack 
        String stack_string = ""; 
        while (st.size() > 0) 
            stack_string += st.pop().character; 
  
        String reduced_string = ""; 
  
        // reverse the stack string 
        for (i = stack_string.length() - 1; i >= 0; i--) 
            reduced_string += stack_string.charAt(i); 
  
        return reduced_string; 
    } 
	// Driver code
	public static void main(String[] args) {
		  int k = 3; 
	        String st = "abcdeeeddcbfgf"; 
	        String ans = remove_k_characters(st, st.length(), k); 
	        System.out.println(ans); 
	}
}
