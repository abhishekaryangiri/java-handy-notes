package timeandspacecomplexity;

public class TSC03FindMin {
	public static int findMin(int[] arr) {
		int min = arr[0];// let min  elem
		for(int num:arr) {
			if(num<min) {
				min = num;//storing min element in min bucket
			}
		}
		return min;
	}
public static void main(String[] args) {
	int[] arr = {10,2,3,4,5,11,22,33,44,100};
	System.out.println(findMin(arr));
}
}
