package java8;

import java.util.Arrays;
import java.util.List;

public class LE09SortAArray {
public static void main(String[] args) {
	List<Integer> arr = Arrays.asList(44,2,66,90,2,1,6,7,44,5);
	
	arr.stream()
	.sorted()
	.forEach(i -> System.out.print(i+" "));
}
}
