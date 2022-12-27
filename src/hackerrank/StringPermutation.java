package hackerrank;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringPermutation {

    public static void main(String[] args) {
        String s = "abcde";
       System.out.println(findPemutations(s));
    }

    private static Long findPemutations(String str) {
    	String str1= new String(str);
    	List<String> result = new ArrayList();
    	while(str1.length() > 0) {
    		for(int i = 0;i<str1.length();i++) {
    			String temp = str1.substring(0,i+1);
        		result.add(str1.substring(0,i+1));
        		if(temp.length() >1) {
        			result.add(new StringBuffer(temp).reverse().toString());
        		}
        	}
    		str1 = str1.substring(1);
    	}
    	System.out.println(result);
    	Predicate<String> test = s -> s.length() >=2 && s.length() <=3;
    	result = result.stream().filter(test).collect(Collectors.toList());
    	System.out.println(result);
    	Optional<Long> test1 = result.stream().collect(Collectors.groupingBy(i->i,Collectors.counting())).values().stream().max(Comparator.comparingLong(i->i));
    	 
        return test1.get();

    }
}
