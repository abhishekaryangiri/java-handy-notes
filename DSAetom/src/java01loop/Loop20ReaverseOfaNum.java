package java01loop;

public class Loop20ReaverseOfaNum {
public static void main(String[] args) {
	int dob = 10101995;
	while(dob>0) {
		int rev = dob % 10;
		System.out.print(rev);
		dob = dob/10;
	}
	System.out.println();
}
}
