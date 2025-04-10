package arrays2d;

public class Arr2d1Print2dArr {
public static void main(String[] args) {
	int[][] arr2d = {
						{1, 2, 3},
						{2, 3, 4},
						{4, 5, 6},
					};	
	for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			System.out.print(arr2d[i][j]+ " ");
		}
		System.out.println();
	}
}
}
