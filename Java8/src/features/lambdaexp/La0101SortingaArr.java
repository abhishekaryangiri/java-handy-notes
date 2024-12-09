package features.lambdaexp;

import java.util.Arrays;

public class La0101SortingaArr {
public static void main(String[] args) {
	int[] arr = {2,7,5,9,90,20,4,0};
	Arrays.sort(arr);
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
}
}
