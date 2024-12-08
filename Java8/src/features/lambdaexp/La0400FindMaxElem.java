package features.lambdaexp;

import java.util.Arrays;
import java.util.List;

public class La0400FindMaxElem {
public static void main(String[] args) {
	List<Integer> nums = Arrays.asList(20,29,60,120,50,30,80);
	int max = nums.stream().max((a,b) -> a-b).orElseThrow(null);
	System.out.println(max);
}
}
