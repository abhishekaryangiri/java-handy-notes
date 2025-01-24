package java8;

public class LE05Add {
	public static void main(String[] args) {
		Add add = (a,b,c,d) -> a+b+c+d;
		System.out.print(add.addOfThreeNum(120, 20, 40, 60));
	}

}

interface Add{
	int addOfThreeNum(int a, int b, int c, int d);
}