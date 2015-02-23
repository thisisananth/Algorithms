package search;

public class Search {

	public static int binarySearch(int[] array, int n) {

		
		int index = -1;
		
		int lo = 0;
		int hi = array.length-1;
		
		
		
		while(lo <=hi){
			int mid = (hi - lo)/2 + lo; 
			if(array[mid]==n){
				return mid;
			}else if(n < array[mid]){
				hi = mid-1;
			}else{
				lo = mid+1;
				
			}
			
		}
		
		return index;
		

	}

	public static void printIntArray(int[] n) {

		if (n != null) {

			for (Integer i : n) {
				System.out.println(i);
			}

		}
	}

	public static void main(String[] args) {

		int index = Search.binarySearch(new int[] { 1, 3, 5, 7,9,11,18,26,29 },29);
	  
		if(index <0){
			System.out.println("Element not found in array");
		}else{
			System.out.println("element found at index: "+index);
		}
		
		
	}

}
