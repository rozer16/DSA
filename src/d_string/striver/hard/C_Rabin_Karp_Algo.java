package d_string.striver.hard;


import java.util.ArrayList;
import java.util.List;

/*

* */
public class C_Rabin_Karp_Algo {

    public static void main(String[] args) {
        C_Rabin_Karp_Algo obj = new C_Rabin_Karp_Algo();
        System.out.println(obj.rabinKarp1("helloll", "ll"));//2,5
        System.out.println(obj.rabinKarp1("aaaaa", "aaa"));//0,1,2
        System.out.println(obj.rabinKarp1("", ""));//[]
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

    The time complexity of the rabinKarp method is (O(n + m)),
    where (n) is the length of the source string and (m) is the length of the target string.
    This is because:
        Computing the power of 31 modulo BASE takes (O(m)) time.
        Computing the hash code of the target string takes (O(m)) time.
        The sliding window over the source string takes (O(n)) time, as each character is processed once.
    Thus, the overall time complexity is (O(n + m)).

        The space required to store the input strings text and pattern.
        The space required for the integer variables BASE, patternLen, power, patternHash, and textHash.
        Since the method uses a constant amount of extra space
        (i.e., it does not use any additional data structures that grow with the input size),
        the space complexity of the rabinKarp method is O(1).
    * */

    private int rabinKarp(String text, String pattern) {
        int BASE = 31;
        if (text.isEmpty() || pattern.isEmpty()) return -1;

        int patternLen = pattern.length();
        int power = 1;

        // Compute 31^m % BASE
        for (int i = 0; i < patternLen; i++) {
            power = (power * 31) % BASE;
        }

        // Compute hash of the target
        int patternHash = 0;
        for (int i = 0; i < patternLen; i++) {
            patternHash = (patternHash * 31 + pattern.charAt(i)) % BASE;
        }

        // Compute rolling hash for the source
        int textHash = 0;
        for (int i = 0; i < text.length(); i++) {
            textHash = (textHash * 31 + text.charAt(i)) % BASE;

            // Skip until we have the first m characters
            if (i < patternLen - 1) continue;

            // Remove the contribution of the character sliding out of the window
            //WWhenever we are subtracting, no might go negative so always add base whenever we are subtracting
            if (i >= patternLen) {
                textHash = (textHash - (text.charAt(i - patternLen) * power) % BASE + BASE) % BASE;
            }

            // If hash codes match, verify the actual substring
            if (textHash == patternHash) {
                if (text.substring(i - patternLen + 1, i + 1).equals(pattern)) {
                    return i - patternLen + 1;
                }
            }
        }

        return -1;
    }

    private List<Integer> rabinKarp1(String text, String pattern) {
        List<Integer> res = new ArrayList<>();
        int BASE = 31;
        if (text.isEmpty() || pattern.isEmpty()) return res;

        int patternLen = pattern.length();
        int power = 1;

        // Compute 31^m % BASE
        for (int i = 0; i < patternLen; i++) {
            power = (power * 31) % BASE;
        }

        // Compute hash of the target
        int patternHash = 0;
        for (int i = 0; i < patternLen; i++) {
            patternHash = (patternHash * 31 + pattern.charAt(i)) % BASE;
        }

        // Compute rolling hash for the source
        int textHash = 0;
        for (int i = 0; i < text.length(); i++) {
            textHash = (textHash * 31 + text.charAt(i)) % BASE;

            // Skip until we have the first m characters
            if (i < patternLen - 1) continue;

            // Remove the contribution of the character sliding out of the window
            //WWhenever we are subtracting, no might go negative so always add base whenever we are subtracting
            if (i >= patternLen) {
                textHash = (textHash - (text.charAt(i - patternLen) * power) % BASE + BASE) % BASE;
            }

            // If hash codes match, verify the actual substring
            if (textHash == patternHash) {
                if (text.substring(i - patternLen + 1, i + 1).equals(pattern)) {
                    res.add( i - patternLen + 1);
                }
            }
        }

        return res;
    }
}
