package arrays2d;

import java.util.Scanner;

public class Arr2d2TakeInputFromUser {
public static void main(String[] args) {
	int[][] arr2d = new int[3][3];
	Scanner scn = new Scanner(System.in);
	
	System.out.println("Enter 3*3 arrays element to print  2 d array");
	for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			arr2d[i][j] = scn.nextInt();
		}
	}
	System.out.println();
	
	//print users input
	for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			System.out.print(arr2d[i][j] + " ");
		}
		System.out.println();
	}

}
}
