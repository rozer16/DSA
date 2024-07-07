package d_string;


import java.util.*;

/*

    * Anagram : Rearrangement of the order of characters in string
    * abc and bca are anagram
    * input : ["eat","tea","tan","ate","nat","bat"]
    * group anagram : [["bat],["eat","tea","ate",],["tan","nat"]]
    * bat and tea and not anagram

* */
public class GroupAnagram {

    public static Map<String, List<String>> getAnagrams(List<String> strs){
        Map<String, List<String>> anagrams= new HashMap<>();
        for(String str:strs){
            char [] a = str.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);

            if(anagrams.containsKey(key)) {
                anagrams.get(key).add(str);
            }else{
                List<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                anagrams.put(key,anagramList);
            }
        }

        return  anagrams;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("eat","tea","tan","ate","nat","bat");
        for (List<String> value : getAnagrams(strs).values()) {
            Collections.sort(value);
            System.out.println(value);
        }
    }
}
