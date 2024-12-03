package features.lambdaexp;

import java.util.Arrays;
import java.util.List;

public class La0100Syntax {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(2,4,5,6,7,8,9,1,23,4);
		nums.forEach(n -> System.out.print(n + " "));
	}

}

//LE: is short and simple way to write a small block of code that can be passed as an argument to a method or stored as a variable. Its like an anonymous function(means its dont need a name)

//ex. imagine we have to do something simple, like add two nums or print a msg, nad we dnt want to write a full method for it. LE write it in one quick line.
//(parameter) -> { body} 
//() -> System.out.prinbtln("Hello World)
//(a,b) -> a+b