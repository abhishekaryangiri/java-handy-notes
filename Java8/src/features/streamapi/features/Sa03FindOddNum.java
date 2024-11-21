package features.streamapi.features;

import java.util.Arrays;
import java.util.List;


public class Sa03FindOddNum {
	//find odd num in a list
	public static void main(String[] args) {
		List<Integer> listtt = Arrays.asList(1,22,33,43,55,6,77,12,34,344,8,7);
		
		listtt.stream().filter(n -> n%2 !=0).forEach(System.out::println);
	}

	}