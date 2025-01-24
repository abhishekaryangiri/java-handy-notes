package java8;

public class LE04MultiplicationOfN {
	public static void main(String[] args) {
		Multiply multiply = (x) -> x*2;
		System.out.println(multiply.getTable(5));
	}
	
}
interface Multiply{
	int getTable(int x);
}
