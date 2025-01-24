package timeandspacecomplexity;

public class TSC04SearchANumber {
	public static int searchSpecificNum(int[] arr, int targetNum) {
		for(int i=0;i<=arr.length;i++) {
			if(arr[i] == targetNum) {
				return i;
			}
		}
		return -1;
	}
public static void main(String[] args) {
	int[] arr = {11,22,33,22,55,23,1111,6556,233,90,900,200,20,100};
	int targetNum = 20;
	int result = searchSpecificNum(arr, targetNum);
	
	if(result == -1) {
		System.out.println( targetNum+" element not found");
	}else {
		System.out.println(targetNum+" element found on index "+ result);
	}
	//t& c: O(n)- bcz comparing each elements
}
}
