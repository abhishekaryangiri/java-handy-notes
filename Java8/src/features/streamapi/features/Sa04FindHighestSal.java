package features.streamapi.features;

import java.util.ArrayList;
import java.util.List;

public class Sa04FindHighestSal {
public static void main(String[] args) {
	List<Integer> salaries = new ArrayList<>();
	salaries.add(200);
	salaries.add(500);
	salaries.add(800);
	salaries.add(100);
	
	int highestSalary = salaries.stream().reduce(Integer::max).orElseThrow(()-> new RuntimeException("Empty List"));
	System.out.println(highestSalary);
}
}
