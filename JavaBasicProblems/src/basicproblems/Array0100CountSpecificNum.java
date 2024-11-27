package basicproblems;

public class Array0100CountSpecificNum {
public static void main(String[] args) {
	
	int[] arr = {1,2,3,4,5,6,0,0,0,1,2,2,3,3,3,4};
	int count = 0;
	
	for(int n : arr) {
		if(n == 3) {
			count++;
		}
	}
	System.out.println(count);
}
}
