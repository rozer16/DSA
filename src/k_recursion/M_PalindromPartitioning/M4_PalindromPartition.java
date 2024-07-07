package k_recursion.M_PalindromPartitioning;

import java.util.ArrayList;
import java.util.List;

public class M4_PalindromPartition {
    public static void main(String[] args) {
        String s ="aabb";
        List<List<String>> result = new ArrayList<>();
        palindrom(result,s);
        System.out.println(result); //[[a, a, b, b], [a, a, bb], [aa, b, b], [aa, bb]]
    }

    private static void palindrom(List<List<String>> result,String s) {
       List<String> temp = new ArrayList<>();
       func(0,s,temp,result);
    }

    private static void func(int index, String s, List<String> path, List<List<String>> res) {
        if (index == s.length()) { //If partition has reached last index that means all prev partitions had palindrome str
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); ++i) { //Started i with index so that first character itself is always palindrome
            if (isPalindrome(s, index, i)) { //Check if index to i is palindrome
                path.add(s.substring(index, i + 1)); //If index to i is palindrome then add to temp result
                func(i + 1, s, path, res); //Call recursion function for i+1
                path.remove(path.size() - 1); //Backtracking remove temp string what we have removed            }
            }
        }
    }


    private static boolean isPalindrome(String str, int start, int end) {
        while(start <= end){
            if(str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return  true;
    }
}
