package e_slidingwindow_two_pointer.medium;


import java.util.HashMap;
import java.util.Map;

/*

https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
https://www.youtube.com/watch?v=-zSxTJkcdAo
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
* */
public class A_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        A_LongestSubstringWithoutRepeatingCharacters sol = new A_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(sol.lengthOfLongestSubstring("bbbb"));
    }


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char [] chars = s.toCharArray();
        if(s.length() <2)
            return s.length();
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){

            //Check if left iis greater than index
            //Could be the case that left is on right side of repeating char index
            if (map.containsKey(s.charAt(right)))
                left = Math.max(
                        map.get(chars[right]) + 1,
                        left
                );

            max = Math.max(max, right - left + 1);
            map.put(chars[right],right);
            right++;
        }

        return max;

    }
    public int lengthOfLongestSubstringBF(String s) {
        int [] no = new int[256];
        char [] chars = s.toCharArray();

        int max = 0;
        for(int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                if(no[chars[j]] == 0){
                    int len = j-i+1;
                    max = Math.max(len , max);
                    no[chars[j]] = 1;
                }else{
                    no = new int[256];
                    break;
                }
            }
        }

        return max;
    }
}
