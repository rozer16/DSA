package string;

public class ReverseStatement {

    public static void main(String[] args) {
        String s = "Alice loves    Bob";
        String reverse = reverseStatement(s);
        System.out.println(reverse);

    }

    private static char [] reverse(char [] s1,int back,int front){
        while (front <= back){
            char temp = s1[back];
            s1[back] = s1[front];
            s1[front] = temp;
            front++;
            back--;
        }
        return s1;
    }

    private static String reverseStatement(String s) {
        String reverse = "";
        char [] s1 = reverse(s.toCharArray(),s.length()-1,0);
        int pointer = 0;
        int back = 0;
        while(pointer < s1.length){

            while(pointer < s1.length-1 && s1[pointer] != ' ')
                pointer++;

            int front = pointer == (s1.length-1) || pointer == 0 ? pointer : pointer-1;
            s1= reverse(s1,front,back);

            pointer++;
            back = pointer;
        }
        return String.valueOf(s1);
    }
}
