package java01loop;

public class Loop12CheckPrime {
public static void main(String[] args) {
	int num = 19;
	boolean isPrime = true;
	if(num<2) {
		isPrime = false;
	}
	for(int i=2; i<=num; i++) {
		if(num % i == 0) {
			isPrime = false;
			break;
		}
	}
	System.out.println("isPrime? " + ": " +isPrime );
}
}
