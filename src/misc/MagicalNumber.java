package misc;

/*

Magical No transformation of positive int n cosists in computing
the sum of its digit and assign that value to n

Give an it perform magical transformation as long as it becomes one digit

9754 => 9+7+5+7 ==> 25 ==> 7

* */

public class MagicalNumber {
    public static int magicalIterativeNumber(int no){
        int ans = 0;
        do {
            ans = 0;
            while (no > 0) {
                ans += no %10;
                no = no/10;
            }

            no = ans;
        }while(ans > 9);
        return ans;
    }

    public static int magicalRecursiveNumber(int no){
        while(no>9)
            no = digitSum(no);

        return no;
    }

    public static int digitSum(int no){
        int ans = 0;
        while(no > 0){
            ans += no%10;
            no /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(magicalIterativeNumber(12345));
        System.out.println(magicalRecursiveNumber(12345));
    }
}
