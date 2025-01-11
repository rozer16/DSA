package d_string.striver.hard;


import java.util.ArrayList;
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
public class E_Z_Function {

    public static void main(String[] args) {
        E_Z_Function obj = new E_Z_Function();
        System.out.println(obj.strStr("abcdabc", "cdab"));//[2]
        System.out.println(obj.strStr("abacaba", "aba"));//[0, 4]
    }

    public List<Integer> strStr(String text, String pattern) {
        String str = pattern + "$" + text;
        int [] z = zFunction(str);
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ;i<z.length; i++){
            if(z[i] == pattern.length())
                result.add(i - pattern.length()-1);
        }


        return result;
    }
    public int [] zFunction(String str){
        int n = str.length();
        int z[] = new int[n];

        for(int i = 1; i< n; i++){
            while ( i + z[i] < n &&   str.charAt(i + z[i]) == str.charAt(z[i]))
                z[i]++;
        }

        return z;
    }
}
