package features.lambdaexp;

import java.util.Arrays;
import java.util.List;

public class La0300ShortaStrByLen {
public static void main(String[] args) {
	List<String> str = Arrays.asList("Abhi", "Ram", "Suman", "Prateek", "ramaswami");
	str.sort((a,b) -> Integer.compare(a.length(), b.length()));
	System.out.println(str);
}
}
