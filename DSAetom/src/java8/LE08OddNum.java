package java8;

import java.util.Arrays;
import java.util.List;

public class LE08OddNum {
public static void main(String[] args) {
	
	List<Integer> arr = Arrays.asList(2,4,3,5,6,4,5,7,8,9,77,55,99,7,88);
	
	arr.stream()
	.filter(i -> i%2!=0)
	.forEach(i -> System.out.print(i+ " "));
}
}
