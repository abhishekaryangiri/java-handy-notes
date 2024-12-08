package features.lambdaexp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class La0500FindFirstRepCharOfStr {
public static void main(String[] args) {
	String str = "india";
	Character result = str.chars()
			.mapToObj(c->(char) c)
			.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
			.entrySet()
			.stream()
			.filter(entry -> entry.getValue() == 1)
			.map(Map.Entry::getKey)
			.findFirst()
			.orElse(null);
	
	System.out.println(result);
}
}
