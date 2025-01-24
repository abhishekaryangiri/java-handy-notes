package timeandspacecomplexity;

public class TSC01OneLoop {
	public static int sumOfArray(int[] arr) {
		int sum = 0;
		for(int num:arr) {
			sum+=num;
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(sumOfArray(arr));
	}
//time complexity: every element accessing time-compl:- o(n)

}
