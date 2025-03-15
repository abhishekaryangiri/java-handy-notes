package arrays;

import java.util.Scanner;

public class B1TakeInput {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int[] numbers = new int[5];
	System.out.println("Enter 5 numbers");
	for(int i =0;i<5;i++) {
		numbers[i] = sc.nextInt();
	}
	System.out.println("the numbers are: ");
	for(int  n=0;n<5;n++) {
		System.out.println(numbers[n]+ " ");
	}
	sc.close();
}
}
//intitution:
//1: take scanner class
//2: declair size of arr
//3: loop till size
//4: loop for output