package basicconcept;

public class BasicConcept0101LinearSerch {
public static void main(String[] args) {
	
	int[] arr = {1, 2, 3, 4011, 5, 22, 33, 4, 55, 66, 77, 88, 4, 23, 444, 33, 444, 55, 6, 233, 434, 22, 3};
	int target = 4011;
	
	int result =  linearSearch(arr, target);//to call method and get res
	
	//if get elem., show index otws- elem not found
	if(result == -1) {
		System.out.println("Result not found");
	}else {
		System.out.println("Result found on ["+ result + "] index");
	}
}

private static int linearSearch(int[] arr, int target) {
	
	for(int i=0;i<=arr.length;i++) {
		if(arr[i] == target) {
			return i;
		}
	}
	
	return -1;
}
}

