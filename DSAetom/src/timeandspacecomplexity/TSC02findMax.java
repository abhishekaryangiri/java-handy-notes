package timeandspacecomplexity;

public class TSC02findMax {
	public static int findMax(int[] arr) {
		int max = arr[0];
		for(int num:arr) {
			if(num>max) {
				max = num;//every time store max element if smaller-no
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {22,44,55,111,60,10};
		System.out.println(findMax(arr));
	}
}
//time complexity: O(n), because comparing every element