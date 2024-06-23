package z_hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;


public class MostActiveCustomer {

    /*
     * Complete the 'mostActive' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY customers as parameter.
     */

    public static List<String> mostActive(List<String> customers) {
    	Map<String, Long> counts =
    			customers.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    	List<String> result = new ArrayList();
    	
    	float percentage = (float)customers.size()*(5.0f/100.0f);
    	for(String s:counts.keySet()) {
    		if((float)counts.get(s) >= percentage) {
    			result.add(s);
    		}
    	}
    	Collections.sort(result);
    	return result;
    }
    public static void main(String[] args) throws IOException {
        
        int customersCount =20;
        String [] aa = {"Alpha","Beta","Zeta","Beta","Zeta","Zeta","Epsilon","Beta","Zeta","Beta","Zeta","Beta","Delta","Zeta","Beta","Zeta","Beta","Zeta","Beta","Zeta","Beta"};
        List<String> customers = Arrays.asList(aa);

        List<String> result = MostActiveCustomer.mostActive(customers);

       System.out.println(result.stream().collect(joining("\n"))+ "\n");
    }

}
