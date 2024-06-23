package e_slidingwindow_two_pointer.hard;

/*
 Given two strings s and t of lengths m and n respectively, return the minimum window substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?


* */
public class C_Minimum_Window_Substring {


    public static void main(String[] args) {

        C_Minimum_Window_Substring sol = new C_Minimum_Window_Substring();
        System.out.println(sol.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(sol.minWindow("a","a"));

    }
    public String minWindow(String s, String t) {

        int cnt = 0;
        int left = 0;
        int right = 0;
        int [] freq = new int[256];
        int minWin = Integer.MAX_VALUE;
        int startInd = -1;
        int m = s.length();
        int n = t.length();

        char [] sChars = s.toCharArray();
        char [] tChars = t.toCharArray();


        //Cashing occurrence of t characters
        for(int i = 0; i<n; i++)
            freq[tChars[i]]++;

        while(right < m){
            //If occurrence of any t char found, increase cnt
            if(freq[sChars[right]] > 0)
                cnt++;

            //Reduce occurrence
            //while traversing for right, decrease occurrence since we have used it
            freq[sChars[right]]--;

            //we have found all character of t into S for this window from left to right.
            //Since we want min length, check if we can shrink length i.e increase left pointer
            while(cnt == n){
                //Before shrinking check if current interval length is min
                if(right-left+1 < minWin){
                    minWin = right-left+1 ;
                    startInd = left;
                }


                //while traversing for left, increase occurrence since we are removing it to our char list
                freq[sChars[left]]++;

                //if occurrence is turning into positive, we are removing a character of t from interval of s, so reduce cnt
                if(freq[sChars[left]] > 0)
                    cnt--;
                left++;
            }

            right++;
        }

        return minWin == Integer.MAX_VALUE ? "" : s.substring(startInd, startInd+minWin);

    }
    public String minWindowBF(String s, String t) {
        int [] freq = new int[256];
        int startInd = -1;
        int minWindow = Integer.MAX_VALUE;
        int m = s.length();
        int n = t.length();

        char [] sChars = s.toCharArray();
        char [] tChars = t.toCharArray();

        for(int i = 0; i< m; i++){

            freq = new int[256];
            for(int i1 = 0; i1 < n; i1++)
                freq[tChars[i1]]++;
            int cnt = 0;
            for(int j = i; j<m; j++){
                if(freq[sChars[j]] > 0)
                    cnt++;

                freq[sChars[j]]--;

                if(cnt == n){
                    if(j-i+1 < minWindow){
                        startInd = i;
                        minWindow = j-i+1;

                    }
                    break;
                }

            }
        }
        System.out.println(startInd+" "+minWindow);
        if(minWindow == Integer.MAX_VALUE)
            return "";
        return s.substring(startInd, startInd+minWindow);
    }

}
