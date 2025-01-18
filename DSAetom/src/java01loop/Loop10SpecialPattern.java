package java01loop;

public class Loop10SpecialPattern {
//Question: Write a program to print a pattern where the 1st row has * _ _ _ _ _ _ _ * (8 blanks), the 2nd row has ** _ _ _ _ ** (6 blanks), the 3rd row has *** _ _ *** (4 blanks), the 4th row has **** _ **** (2 blanks), and the 5th row has ********** (no blanks).

public static void main(String[] args) {
	int n=5;
	for(int i=1; i<=n;i++) {
		//print *
		for(int j=1;j<=i;j++) {
			System.out.print("*");
		}
		//print spaces
		for(int j=1; j<=(n-i)*2; j++) {
			System.out.print(" ");
		}
		//print * again
		for(int j=1; j<=i; j++) {
			System.out.print("*");
		}
		//move to the next line
		System.out.println();
	}
}

}
