package java01loop;

public class demo {
public static void main(String[] args) {
	for(int i=1;i<=5;i++) {//row, outer loop
//		System.out.println("*");
		for(int j=5; j>=i;j--) {//row me print, inner loop
			System.out.print("*");
		}
		System.out.println();
	}
}}
