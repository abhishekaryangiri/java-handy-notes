package loop;

public class PrintNumsCal {
public static void main(String[] args) {
//			1=1
//			2*2=4
//			3*3*3=27
//			4*4*4*4=256
//			5*5*5*5*5=3125
	int i,j;
	//iterate nums 1-5
	for(i=1;i<=5;i++) {
		//print multiplication pattern
		for(j=1;j<=i;j++) {
			System.out.print(i);
			if(j<i) {
				//adding * bw nums
				System.out.print("*");
			}
		}
		System.out.println("="+(int)Math.pow(i, i));
	}
}
}
