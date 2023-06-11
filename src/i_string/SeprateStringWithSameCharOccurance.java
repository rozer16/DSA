package i_string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeprateStringWithSameCharOccurance {
	
	public static void main(String[] args) {
		  List<String> strs = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
	      System.out.println(getStringList(strs));
	}
	private static String sortString(String str){
		char [] chars = str.toCharArray();
		Arrays.sort(chars);
		return String.copyValueOf(chars);
	}
	private static List<List<String>> getStringList(List<String> strList){
		Map<String,List<String>> map = new HashMap();

		strList.forEach(s->{
			System.out.println("Processing :"+s);
			String sortedString = sortString(s);
			if(map.containsKey(sortedString)) {
				map.get(sortedString).add(s);
			}else {
				List<String> strings = new ArrayList<>();
				strings.add(s);
				map.put(sortedString, strings);
			}

			System.out.println(map);
		});
		List<List<String>> strs = new ArrayList<List<String>>();
		map.values().forEach(list -> {
			Collections.sort(list);
			strs.add(list);
		});
		return strs;
	}
}
