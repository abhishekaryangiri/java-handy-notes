package java8;

import java.util.Arrays;
import java.util.List;

public class LE03PrintNamesStartWith {
	public static void main(String[] args) {
		
		List<String> arr = Arrays.asList("Ram","Shayam","Mohan","Sohan");
		
		arr.stream()
//		.filter(i -> i.startsWith("n"))
		.filter(i -> i.endsWith("m"))
		.forEach(i -> System.out.println(i));
	}

}
