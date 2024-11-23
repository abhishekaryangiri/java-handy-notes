package features.streamapi.features;

import java.util.Arrays;
import java.util.List;

public class SA0101PrintNum {
	public static void main(String[] args) {
		
		 List<Integer> list = Arrays.asList(1,22,43,55,67,44);
		 list.stream().forEach(System.out::println);
		 
	}

}
