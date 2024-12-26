package oops.constructor;

public class Student {

	//data: data member and also called instance var 
	int studentdId;
	String studentName;
	String studentCity;
	
	//behav. : member methods or methods
	
	public void study() {
		System.out.println(studentName);
	}
	
	//create constructor 
	public Student() {
		System.out.println("constr: creating obj");
	}
	
	public Student(int nn) {
		System.out.println("parameterized const called");
	}
	

	
	public void fullDetails() {
		System.out.println(studentName);
		System.out.println(studentdId);
		System.out.println(studentCity);
	}
}

