package arrays;

import java.util.Scanner;

public class Arr5TakeInputFromUser {
public static void main(String[] args) {
	//take input from users and store them in arr
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		System.out.println("ENTER 5 NUMBERS");
		
		for(int i=0;i<5;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Array:");
		for(int j=0;j<5;j++) {
			System.out.print(arr[j]+ " ");
}	
	
}}
