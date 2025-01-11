Here’s a comprehensive cheatsheet for solving string DSA problems. It includes important techniques, common patterns, and tips to approach string-related problems effectively.

String DSA Cheatsheet

1. Common Operations
   •	Reverse a String:

String reversed = new StringBuilder(str).reverse().toString();


	•	Character Frequency:

int[] freq = new int[26];
for (char c : str.toCharArray()) {
freq[c - 'a']++;
}


	•	Substring Operations:
	•	str.substring(start, end) – Extract substring from start to end - 1.
	•	str.indexOf("pattern") – Find the index of the first occurrence.
	•	str.contains("pattern") – Check if substring exists.

2. Two Pointer Technique
   •	Problem Examples:
   •	Palindrome Check
   •	Remove duplicates
   •	Template:

int left = 0, right = str.length() - 1;
while (left < right) {
// Compare or process str.charAt(left) and str.charAt(right)
left++;
right--;
}

3. Sliding Window
   •	When to Use:
   •	Finding substrings of a fixed or variable size.
   •	Problems like “longest substring without repeating characters”.
   •	Template:

int start = 0, maxLength = 0;
Map<Character, Integer> map = new HashMap<>();

for (int end = 0; end < str.length(); end++) {
char c = str.charAt(end);
// Update window state
map.put(c, map.getOrDefault(c, 0) + 1);

    // Shrink window if condition is violated
    while (map.size() > requiredCondition) {
        char leftChar = str.charAt(start);
        map.put(leftChar, map.get(leftChar) - 1);
        if (map.get(leftChar) == 0) map.remove(leftChar);
        start++;
    }

    // Update maxLength or result
    maxLength = Math.max(maxLength, end - start + 1);
}

4. Prefix and Suffix
   •	Prefix Sum in Strings:
   •	Use to compute cumulative values for each position.
   •	Common Problems:
   •	Longest prefix-suffix in string.
   •	Count distinct substrings.

5. Pattern Matching Algorithms
   •	Rabin-Karp Algorithm (Rolling Hash):
   •	Efficient for substring search with hashing.
   •	KMP Algorithm:
   •	Precompute longest prefix-suffix array to reduce comparisons.
   •	Implementation for KMP:

int[] lps = new int[m]; // Length of pattern
int j = 0;
for (int i = 1; i < m; i++) {
if (pattern.charAt(i) == pattern.charAt(j)) {
j++;
lps[i] = j;
} else if (j > 0) {
j = lps[j - 1];
i--;
}
}

6. Trie (Prefix Tree)
   •	Usage:
   •	Search suggestions
   •	Prefix matching
   •	Node Structure:

class TrieNode {
Map<Character, TrieNode> children = new HashMap<>();
boolean isEndOfWord;
}

7. Palindrome Problems
   •	Check Palindrome:

boolean isPalindrome(String s) {
int left = 0, right = s.length() - 1;
while (left < right) {
if (s.charAt(left) != s.charAt(right)) return false;
left++;
right--;
}
return true;
}


	•	Longest Palindromic Substring (Expand Around Center):

for (int i = 0; i < n; i++) {
expandAroundCenter(s, i, i);     // Odd length
expandAroundCenter(s, i, i + 1); // Even length
}

8. Hashing
   •	Hashing Strings:
   •	Hash for fast lookup of substrings.
   •	Use mod for hash collisions.

long hash = 0;
int p = 31, mod = 1_000_000_007;
for (int i = 0; i < str.length(); i++) {
hash = (hash * p + (str.charAt(i) - 'a' + 1)) % mod;
}

9. Dynamic Programming
   •	Common Problems:
   •	Longest Common Subsequence
   •	Longest Palindromic Substring
   •	Longest Increasing Subsequence in Strings
   •	Example: Longest Palindromic Substring

boolean[][] dp = new boolean[n][n];
for (int len = 1; len <= n; len++) {
for (int i = 0; i <= n - len; i++) {
int j = i + len - 1;
dp[i][j] = (s.charAt(i) == s.charAt(j)) && (len <= 2 || dp[i + 1][j - 1]);
}
}

10. Common String Problems
    •	Anagram Check:

boolean isAnagram(String s, String t) {
int[] count = new int[26];
for (char c : s.toCharArray()) count[c - 'a']++;
for (char c : t.toCharArray()) count[c - 'a']--;
for (int c : count) if (c != 0) return false;
return true;
}


	•	Group Anagrams:

Map<String, List<String>> map = new HashMap<>();
for (String s : strs) {
char[] arr = s.toCharArray();
Arrays.sort(arr);
String key = new String(arr);
map.putIfAbsent(key, new ArrayList<>());
map.get(key).add(s);
}

11. Tips for Optimization
    1.	Use Hashing for fast substring or pattern matching.
    2.	Try sliding window for substring problems.
    3.	Use dynamic programming for overlapping subproblems.
    4.	Prefer prefix/suffix arrays to reduce redundant calculations.

This cheatsheet covers foundational approaches and will guide you through most string DSA problems. Let me know if you want elaboration on specific concepts!