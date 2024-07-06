package g_stack;

public class M_InfixToPrefixConversion {
    public static void main(String[] args) {
        M_InfixToPrefixConversion test = new M_InfixToPrefixConversion();
        String infix = "a+(b*c)"; //+a*bc
        String infix1 = "x+y*z/w+u"; //+x+*y/zwu
        System.out.println(test.infixToPrefix(infix1));
    }



    //reverse
    //replace ( to ) AND ( TO )
    // INFIX TO post fix
    //  reverse
    // return

    public String infixToPrefix(String infix){
        // Reverse String and replace ( with ) and vice versa Get Postfix Reverse Postfix
        int l = infix.length();
        String infix1 = reverse(infix.toCharArray(), 0, l - 1);
        char [] infix_char_array = infix1.toCharArray();
        for (int i = 0; i < infix_char_array.length; i++) {

            if (infix_char_array[i] == '(') {
                infix_char_array[i] = ')';

            }
            else if (infix_char_array[i] == ')') {
                infix_char_array[i] = '(';

            }
        }

        String prefix = new I_InfixToPostfixConversion().infixToPostfix(String.valueOf(infix_char_array));
        // Reverse postfix
        prefix = reverse(prefix.toCharArray(), 0, prefix.length()-1);

        return prefix;
    }


    public int getPrecedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Reverse the letters of the word
    static String reverse(char str[], int start, int end)
    {
        // Temporary variable to store character
        char temp;
        while (start < end) {
            // Swapping the first and last character
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }
}
