package g_recursion.A_functional;


/*
* https://takeuforward.org/data-structure/check-if-the-given-string-is-palindrome-or-not/
*
* */
public class B_IsStringPalindrom {
    public static void main(String[] args) {
        String str = "ABCBAA";
        System.out.println(isStringPalindrom(str,0));
    }


    public static boolean isStringPalindrom(String str,int i){
        if(str.length()/2 < i)
            return true;

        if(str.charAt(i) != str.charAt(str.length()-i-1))
            return false;

        return isStringPalindrom(str,i+1);
    }
}
