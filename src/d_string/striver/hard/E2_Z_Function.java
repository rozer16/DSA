package d_string.striver.hard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://takeuforward.org/plus/dsa/strings--advanced-algo/advanced-problems-(less-asked)/z-function?tab=editorial


Z Algorithm:
The Z-algorithm is a common technique to solve String Pattern Matching problems.
It combines the pattern P and the text T as P + "$" + T, computes the Z-array, and find matches.

Z-array:
The Z-array is an array where each position Z[i] represents the length of the longest substring starting
from s[i] that is also a prefix of the string s.


For example, if the string is s = "abcdabc":

pattern = "cdab"


combined string : cdab$abcdabc

z result : 0 0 0 0 0 0 0 4 0 0 0 0


Key Notes:

The Z-array helps identify positions where the pattern fully matches a substring in the text.
The delimiter ensures there are no false matches due to overlapping of the pattern with itself.


Intuition:
The Z-algorithm uses the Z-array which contains for every index,
the length of the longest substring starting from that particular index
which is also a prefix of the string.
Thus, the pattern that needs to be matched is kept as prefix in the string s and then the Z-array can be used
to find all the indices where the pattern is found in the text string.


* */
public class E2_Z_Function {

    public static void main(String[] args) {
        E2_Z_Function obj = new E2_Z_Function();
        System.out.println(obj.strStr("abcdabc", "cdab"));//[2]
        System.out.println(obj.strStr("abacaba", "aba"));//[0, 4]


        //System.out.println(Arrays.toString(calculateZArrayOptimized("xyz$xyzabxyzabxyz")));
       // System.out.println(Arrays.toString(zFunctionBrute("xyz$xyzabxyzabxyz")));

        System.out.println(Arrays.toString(calculateZArrayOptimized("ttfxttfxzttfxttfxtz")));
        System.out.println(Arrays.toString(zFunctionBrute("ttfxttfxzttfxttfxtz")));
    }

    public List<Integer> strStr(String text, String pattern) {
        String str = pattern + "$" + text;
        int [] z = zFunctionBrute(str);
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ;i<z.length; i++){
            if(z[i] == pattern.length())
                result.add(i - pattern.length()-1);
        }


        return result;
    }


    /*
    The time complexity of the zFunction is (O(n^2)) in the worst case
    because of the nested loops where the inner while loop can potentially run up to (n) times for each iteration of the outer for loop.
    The space complexity of the zFunction is (O(n))
    because it uses an array z of size n to store the Z-values.
    * */
    public static int [] zFunctionBrute(String str){
        int n = str.length();
        int z[] = new int[n];

        for(int i = 1; i< n; i++){
            while ( i + z[i] < n &&   str.charAt(i + z[i]) == str.charAt(z[i]))
                z[i]++;
        }

        return z;
    }


    /*
 * Constructs the Z-array for the given string using an optimized approach.
 *
 * @param str The input string.
 * @return The Z-array.
 *
 * The time complexity of the calculateZArrayOptimized function is (O(n)),
 * where (n) is the length of the input string str.
 * This is because each character of the string is processed at most twice,
 * once when extending the Z-box(range) and once when comparing characters.
 *
 * The space complexity of the calculateZArrayOptimized function is (O(n)),
 * where (n) is the length of the input string str.
 * This is because the function uses an array Z of size (n) to store the Z-values.
 * The additional variables left and right use constant space,
 *  so they do not affect the overall space complexity.
 *
 *
 *
 *   Index : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
 *   String: t t f x t t f x z t  t  f  x  t  t  f  x  t  z
 *   Z     : 0 1 0 0 4 1 0 0 0 8  1  0  0  5  1  0  0  1  0
 */
public static int[] calculateZArrayOptimized(String str) {
    int n = str.length();
    int[] Z = new int[n];
    int left = 0, right = 0;

    for (int i = 1; i < n; i++) {
        // If i is within the current Z-box(range), use previously computed Z-values
        if (i <= right) {


            // We take the minimum of (right - i + 1) and Z[i - left] to ensure that we do not exceed the current Z-box(range).
            // (right - i + 1) is the remaining length of the Z-box(range) from position i.
            // Z[i - left] is the previously computed Z-value that can be reused.

            //For e.g. when i = 13, left = 9, right = 16, Z[5] = 5 So, Z[13] = min(16 - 13 + 1, 5) = 4 so below while condition will be executed and z[13] = 5
            // when i = 17, left = 13, right = 17, i-left=4, z[4] =  4 but it will exceed the string(17+4 = 23) so will take right-i+1 = 17-17+1= 1
            Z[i] = Math.min(right - i + 1, Z[i - left]);
        }
        //i is outside the current Z-box(range), so we need to compute Z[i] explicitly
        // Extend the Z-box(range) as far as possible
        while (i + Z[i] < n && str.charAt(Z[i]) == str.charAt(i + Z[i])) {
            Z[i]++;
        }
        // Update the Z-box(range) if it has been extended
        if (i + Z[i] - 1 > right) {
            left = i;
            right = i + Z[i] - 1;
        }
    }
    return Z;
}
}
