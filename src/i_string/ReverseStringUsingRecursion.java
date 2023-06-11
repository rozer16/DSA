package i_string;

public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        String s1="abcde";
        reverseString(s1);
    }

    private static void reverseString(String s1) {
                if(s1.length() == 1)
                    System.out.print(s1);
                else{
                    reverseString(s1.substring(1,s1.length()));
                    System.out.print(s1.substring(0,1));
                }
    }
}
