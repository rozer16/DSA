package g_recursion.basic;


import java.util.ArrayList;
import java.util.List;

/*
* Given a digit ‘d’ and a range [L, R] where L < R,
* print all good numbers in given range that don’t contain digit ‘d’.
* A number is good if its every digit is larger than the sum of digits which are on the right side of that digit.
* For example 9620 is good number because 2 > 0, 6 > 2+0 and 9 > 6+2+0.
*
*
Example:

Input:  L = 410, R = 520, d = 3
Output: 410 420 421 510 520
All the numbers in output are good (every digit is more
than sum of digits on right of it) and don't have digit 3.

Input:  L = 410, R = 520, d = 1
Output: 420 430 520
All the numbers in output are good (every digit is more
than sum of digits on right of it) and don't have digit 1.
*
*
* */
public class E_GoodNumber {

    public static void main(String[] args) {
        int no1 = 410;
        int no2 = 520;

        List<Integer> gonos = findGoodNosRec(20,45,1);
        System.out.println(gonos);
    }

    //Time Complexity: O((l-r) * log10 n) , takes O(log10 n) time to check if a number is a good number
    //Auxiliary Space: O(1)
    private static List<Integer> findGoodNos(int i, int i1,int d) {
        List<Integer> gonos = new ArrayList<>();
        for (int j = i; j <= i1 ; j++) {
            if(isGoodNum(j,d))
                gonos.add(j);
        }

        return gonos;
    }

    private static List<Integer> findGoodNosRec(int i, int i1,int d) {
        List<Integer> gonos = new ArrayList<>();
        for (int j = i; j <= i1 ; j++) {

            if(j%10 != d && isGoodNumRec(j/10,d,j%10))
                gonos.add(j);
        }

        return gonos;
    }

    public static boolean isGoodNum(int n,int d){
        // Get last digit and initialize sum from right side
        int digit = n%10;
        int sum = digit;

        // If last digit is d, return
        if (digit == d)
            return false;

        // Traverse remaining digits
        n /= 10;
        while (n>0)
        {
            // Current digit
            digit = n%10;

            // If digit is d or digit is less than or
            // equal to sum of digits on right side
            if (digit == d || digit <= sum)
                return false;

                // Update sum and n
            else
            {
                sum += digit;
                n /= 10;
            }
        }
        return true;
    }

    public static boolean isGoodNumRec(int n,int d,int sum){
        // Get last digit and initialize sum from right side
        int digit = n%10;

        if(n <= 0)
            return true;

        // If last digit is d, return
        if (digit == d)
            return false;

        if(sum >= digit)
            return false;

        return isGoodNumRec(n/10,d,sum+digit);

    }

}
