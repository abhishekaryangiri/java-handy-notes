package arrays;

import java.util.Arrays;

public class Arr03ReverseArr {
	public static int[] reverseArray(int[] arr) {
		int start =0;// decl starting index
		int end = arr.length-1;// decl. last index
		
		while(start < end) {
			int temp = arr[start];//temp storing  initial elem
			arr[start] = arr[end];// storing last elemt at 1st index(swaping 1 and last element)
			arr[end] = temp;//storing 1st elemt at last index
			
			start++;//incresing loop forward
			end--;// coming ledt to arr
			
		}
		return arr;//printing final rev arr
	}
	
public static void main(String[] args) {
	int[] arr = {1,2,3,4,5,6,7,8,9,10};
	System.out.println(Arrays.toString(reverseArray(arr)));
}
}
