package oops.parameterizedconst;

public class Client {
	public static void main(String[] args) {
		
		//creating obj of std class std
		
		Student std1 = new Student(123, "Paratha", "Meeruth");
		//no need to create obj here
		
		Student std2 = new Student(345, "Ram", "Delhi");
		
		
		Student std3 = new Student(3211, "Sohan", "Kanpur");

		
		std1.study();
		std2.study();
		std3.study();
		
		System.out.println("---students detail---");
		
		std1.fullDetails();
		std2.fullDetails();
		std3.fullDetails();
		
	}

}
