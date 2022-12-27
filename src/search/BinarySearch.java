package search;

public class BinarySearch {
	public static void main(String[] args) {
		int [] array = {5,8,10,13,15,25,45};
		System.out.println(binarySearch(array,0,6,45));
	}
	
	public static int binarySearchRecursion(int []array, int left,int right, int search) {
		if(array.length < 1) {
			return -1;
		}
		if(left <= right) {
			int mid = (left + right)/2;
			if(array[mid] == search) {
				return mid;
			}
			if(search < array[mid]) {
				return binarySearchRecursion(array, left, mid, search);
			}else {
				return binarySearchRecursion(array, mid+1, right, search);
			}
		}
		
		return -1;
	}
	
	public static int binarySearch(int [] array,int left,int right,int search) {
		if(array.length < 1) {
			return -1;
		}
			while(left <= right) {
			int mid = (left + right)/2;
			if(array[mid] == search)
				return mid;
			if(array[mid] > search)
				right=mid;
			else
				left=mid+1;
		}
		return -1;
	}
}
