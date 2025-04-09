package arrays;

public class Arr2SumAndAvg {
public static void main(String[] args) {
	//display sum and average of an array
	double[] arr = {10, 20, 30, 40, 50};
	double sum = 0;
	double count =0;
	double avg;
	
	for(double i : arr) {
		sum += i;
		count++;
	}
	avg = sum / count;
	System.out.println(sum);
	System.out.println(avg);
}
}
