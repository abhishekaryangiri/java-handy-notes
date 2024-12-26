package oops.oops01;

public class Client {
	public static void main(String[] args) {
		
		//creating obj of std class std
		
		Student std1 = new Student();
		std1.studentName="Ram";
		std1.studentdId= 1212;
		std1.studentCity="Jaipur";
		
		
		Student std2 = new Student();
		std2.studentName="Mohan";
		std2.studentdId= 4312;
		std2.studentCity="Kanpur";
		
		Student std3 = new Student();
		std3.studentName="Sohan";
		std3.studentdId= 3212;
		std3.studentCity="Mathura";
		
		std1.study();
		std2.study();
		std3.study();
		
		System.out.println("---students detail---");
		
		std1.fullDetails();
		std2.fullDetails();
		std3.fullDetails();
		
	}

}
