package features.streamapi.features;

import java.util.Arrays;
import java.util.List;

public class SA01Structure {
	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,8,10,20);
		
		numList.stream().filter(n -> n%2 ==0).forEach(System.out::println);
	}

}
//user: processing collections and streams of data
// operation: filter, mapping , reducing

/*
 * intuition:
 * 
 * Arrays.asList: initializinga fixed size array
 * 
 * numList.stream():convert a list into stream
 * 
 * Stream: A sequence of elements that can be processed in a pipeline (e.g., filtering, mapping, or reducing). Streams don’t modify the original data structure but provide a view for processing.
 * 
 * filter(expression):filter the elements of the stream based on the expression
 * 
 * .forEach(System.out::println): iterate over the filtered stream and print it
 * 
 * 
 */