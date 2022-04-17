package string;



public class RemoveCharacterSorrounding {
	private static String play(String s) {
		StringBuffer s1 = new StringBuffer(s);
		
		
		char nextTurn1 = 'b';
		while(s1.length() > 0) {
			int i= 1;
			nextTurn1 = nextTurn1 == 'w' ? 'b':'w';
	
			while(i<s1.length()-2 && s1.charAt(i-1) != nextTurn1 || s1.charAt(i) != nextTurn1 || s1.charAt(i+1) != nextTurn1) {
				i++;
			}
			if(s1.charAt(i-1) == nextTurn1 && s1.charAt(i) == nextTurn1 && s1.charAt(i+1) == nextTurn1) {
				s1.deleteCharAt(i);
			}else {
				return nextTurn1 == 'b' ? "Wendy" : "Bob";
			}
		}
		
		return null;
	}
	public static void main(String[] args) {
		System.out.println(play("wwwbb"));
	}
}
