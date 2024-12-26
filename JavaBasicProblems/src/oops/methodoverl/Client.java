package oops.methodoverl;

public class Client {
	public static void main(String[] args) {
		Employee emp = new Employee();
		
		emp.techDepartment(12);
		emp.techDepartment(121, "Shayam");
		emp.techDepartment(324, "Ramesh", "4years");
	}
}
//same name diff parameters;
//provides more flexibility to methodsto handle diff situation