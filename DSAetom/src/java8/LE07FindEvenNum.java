package java8;

import java.util.Arrays;
import java.util.List;

public class LE07FindEvenNum {
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(12,4,22,56,89,90);
		
		arr.stream()
		.filter(i -> i%2==0)
		/*.forEach(System.out::println);*/
		.forEach(i -> System.out.print(i+ " "));
		
	}

}
