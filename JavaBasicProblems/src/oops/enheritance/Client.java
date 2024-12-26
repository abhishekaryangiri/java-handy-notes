package oops.enheritance;

public class Client {
	public static void main(String[] args) {
		Employee emp = new Employee();
		
		//set values, we get access toi set value sin par and chield both
		emp.department="tech"; //into parent class
		emp.name="Tech Mahindara";// chield class
		
		emp.allDepartments();
		emp.myDepartment();
	}

}
