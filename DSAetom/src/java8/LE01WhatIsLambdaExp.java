package java8;

public class LE01WhatIsLambdaExp {
public static void main(String[] args) {
	Runnable r = () -> System.out.println("Hello World");
	r.run();
}
}
//LE: way to writen clear, easy to readable and shorten code, it is a way to express Functional interface in concise and shorten way.
// mostly it is used for FI for enabling functional programing 
//(parfameter)->expression
//->lambda operator