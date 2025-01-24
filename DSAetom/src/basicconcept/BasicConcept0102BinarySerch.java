package basicconcept;

import java.util.Arrays;

public class BasicConcept0102BinarySerch {
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4011, 5, 22, 33, 4, 55, 66, 77, 88, 4, 23, 444, 1330, 444, 55, 6, 233, 434, 22, 3};
		Arrays.sort(arr);// binary search works on sorted arrays only
		int target = 1330;
		int result = binarySearch(arr, target);// print res and call method
		//to check target value exist or not/ print res
		if(result == -1) {
			System.out.println("result not found");
		}else {
			System.out.println(target+ " result found at ["+result+"] index.");
			System.out.println(arr.length);
		}
	}

	private static int binarySearch(int[] arr, int target) {
		int left = 0, right=arr.length-1;
		
		while(left<=right) {
			int mid = left+(right-left)/2;
			
			if(arr[mid]==target) {
				return mid;
			}
			if(arr[mid]<=target) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return -1;
	}

}
