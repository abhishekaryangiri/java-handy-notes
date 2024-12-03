package features.lambdaexp;

import java.util.ArrayList;
import java.util.List;

public class La0200AddintoListandPrint {
public static void main(String[] args) {
	
	List<String> lst = new ArrayList<>();
	lst.add("Kishor");
	lst.add("Kamal");
	lst.add("Jacky");
	
	lst.forEach(n -> System.out.println(n));
	
}
}
