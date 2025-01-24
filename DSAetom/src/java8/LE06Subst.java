package java8;

public class LE06Subst {
	public static void main(String[] args) {
		Sub sub = (a, b) -> a-b;
		System.out.println(sub.findSub(50, 30));
	}

}
interface Sub{
	int findSub(int a, int b);
}
