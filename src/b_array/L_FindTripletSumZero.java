package b_array;

import java.util.*;

public class L_FindTripletSumZero {

	static void findTriplets(Integer arr[], int n)
    {
        boolean found = false;
 
        for (int i = 0; i < n - 1; i++)
        {
            // Find all pairs with sum equals to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++)
            {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x))
                {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                }
                else
                {
                    s.add(arr[j]);
                }
            }
        }
 
        if (found == false)
        {
            System.out.printf(" No Triplet Found\n");
        }
    }
	
	/*
	 Time Complexity: O(n2).
	 * */
	static void findTriplets(List<Integer> nos) {
		
		
		for(int i = 0;i< nos.size();i++) {
			for(int j = i+1;j<nos.size();j++) {
				HashMap<Integer,Integer> elements = new HashMap();
				int x = -(nos.get(i)+nos.get(j));
				if(elements.containsKey(x)) {
					System.out.println(nos.get(i)+","+nos.get(j)+","+x);
				}else {
					elements.put(nos.get(j),0);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Integer [] arr = {0,-1,2,-3,1};
		List<Integer> nos = Arrays.asList(arr);
		findTriplets(arr,arr.length);
		findTriplets(nos);
	}
}
