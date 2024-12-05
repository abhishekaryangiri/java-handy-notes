package features.lambdaexp;

import java.util.Arrays;
import java.util.List;

public class La0300ShortaStrByLen {
public static void main(String[] args) {
	List<String> str = Arrays.asList("Abhi", "Ram", "Suman", "Prateek", "ramaswami");
	str.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()));
	System.out.println(str);
}
}
