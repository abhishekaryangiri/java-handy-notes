package java01loop;

public class Loop20ReaverseOfaNum {
public static void main(String[] args) {
	int initialDigit = 10101995;
	while(initialDigit>0) {
		int reverse = initialDigit % 10;
		System.out.print(reverse );
		initialDigit = initialDigit/10;
	}
	System.out.println();
}
}
