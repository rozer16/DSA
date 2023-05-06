package string;

/*



Wendy and Bob play a game where white or black pieces are represented by a string, colors.
 The string colors can be arranged as follows:
Wendy moves first and then they take alternate turns.
With each move, Wendy may remove a white piece that has two adjacent white pieces on either side.
Likewise, with each move, Bob may remove any black piece that has two adjacent black pieces on either side.
After a piece is removed, the string is reduced in size by one piece. For instance: If a piece Y has adjacent pieces X and Yon either side, following a move, X and Z will now be adjacent.
When a player can no longer move, they have lost the game.

Example
colors = wwwbbbbwww
Wendy removes the piece wat index 1, colors = wwbbbbwww
Bob removes the piece b at index 3, colors = wwbbbwww
Wendy removes the piece w at index 6, colors = wwbbbww
Bob removes the piece b from index 3, colors = wwbbww
Wendy has no other move, and Bob wins.
Determine who wins if Wendy and Bob both play with optimum skill.
Function Description



 * */



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
