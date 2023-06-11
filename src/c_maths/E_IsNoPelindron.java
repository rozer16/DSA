package c_maths;


//https://leetcode.com/problems/palindrome-number/

public class E_IsNoPelindron {

    public static boolean isPalindrome(int x) {

        if(x<0 || x!=0 && x%10 ==0 ) return false;
        int check=0;
        while(x>check){
            check = check*10 + x%10;
            x/=10;
        }
        return (x==check || x==check/10);


    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
