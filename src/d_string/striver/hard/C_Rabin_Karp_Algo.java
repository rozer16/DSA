package d_string.striver.hard;


import java.util.ArrayList;
import java.util.List;

/*

* */
public class C_Rabin_Karp_Algo {

    public static void main(String[] args) {
        C_Rabin_Karp_Algo obj = new C_Rabin_Karp_Algo();
        System.out.println(obj.search("hello", "ll"));//2
        System.out.println(obj.search("aaaaa", "bba"));//-1
        System.out.println(obj.search("", ""));//0
    }

    public List<Integer> search(String pattern, String text) {


        List<Integer> result = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();

        //ababcabcababc //abc
        for(int  i = 0; i<=n-m; i++){
            boolean flag = false;
            for(int j = 0; j<m; j++){
                if(text.charAt(i+j) != pattern.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                result.add(i);
        }


        return result;
    }


    /*

    The time complexity of the rabinKarp method is (O(n + m)), where (n) is the length of the source string and (m) is the length of the target string.
    This is because:
        Computing the power of 31 modulo BASE takes (O(m)) time.
        Computing the hash code of the target string takes (O(m)) time.
        The sliding window over the source string takes (O(n)) time, as each character is processed once.
    Thus, the overall time complexity is (O(n + m)).
    * */

    public int rabinKarp(String text, String pattern) {
        if (pattern.length() > text.length()) return -1; // Pattern longer than text
        if (text.equals(pattern)) return 0; // Exact match

        int MOD = 100000; // Large prime to prevent overflow
        int PRIME = 31;   // Prime multiplier for hash

        int patternLen = pattern.length();
        int textLen = text.length();
        int power = 1;

        // Compute PRIME^(patternLen-1) % MOD
        for (int i = 0; i < patternLen - 1; i++) {
            power = (power * PRIME) % MOD;
        }

        // Compute the hash of the pattern
        int patternHashCode = 0;
        for (int i = 0; i < patternLen; i++) {
            patternHashCode = (patternHashCode * PRIME + pattern.charAt(i)) % MOD;
        }

        // Compute the hash for the first window of the text
        int textHashCode = 0;
        for (int i = 0; i < textLen; i++) {
            textHashCode = (textHashCode * PRIME + text.charAt(i)) % MOD;

            // Adjust the hash when the window size exceeds patternLen
            if (i >= patternLen) {
                textHashCode = (textHashCode - (text.charAt(i - patternLen) * power)%MOD) % MOD;
                if (textHashCode < 0) textHashCode += MOD; // Ensure non-negative hash
            }

            // Check for hash match and confirm with actual string comparison
            if (i >= patternLen - 1) {
                if (textHashCode == patternHashCode) {
                    if (text.substring(i - patternLen + 1, i + 1).equals(pattern)) {
                        return i - patternLen + 1; // Return starting index
                    }
                }
            }
        }

        return -1; // Pattern not found
    }
}
