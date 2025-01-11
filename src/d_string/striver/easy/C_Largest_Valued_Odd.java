package d_string.striver.easy;

public class C_Largest_Valued_Odd {
    public static void main(String[] args) {
        C_Largest_Valued_Odd obj = new C_Largest_Valued_Odd();
        System.out.println(obj.largestOddNumber("35427"));//35427
        System.out.println(obj.largestOddNumber("4206"));//""
        System.out.println(obj.largestOddNumber("35427"));//35427
        System.out.println(obj.largestOddNumber("35427"));//35427
    }

    public String largestOddNumber(String num) {
        int n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
