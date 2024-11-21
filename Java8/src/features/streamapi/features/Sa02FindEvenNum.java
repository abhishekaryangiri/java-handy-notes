package features.streamapi.features;

import java.util.Arrays;
import java.util.List;

public class Sa02FindEvenNum {
	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,22,34,56,100,129);
		
		//stream api operator -
		numList.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
	}

}
