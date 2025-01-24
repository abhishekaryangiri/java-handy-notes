package java8;

import java.util.Arrays;
import java.util.List;

public class LE02PrintElemOfArr {
	public static void main(String[] args) {
		
		List<String> arr = Arrays.asList("Abhi", "Aryan", "Mack");
		
		arr.forEach(i -> System.out.println(i));
		
	}

}
