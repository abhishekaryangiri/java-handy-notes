package oops.methodoverl;

public class Employee {
	public void techDepartment(int id) {
		System.out.println("emp Id: "+id);
	}
	public void techDepartment(int id, String n) {
		System.out.println("emp id: "+ id+ " Emp name "+ n );
	}
	public void techDepartment(int id, String n, String exp) {
		System.out.println("emp id: "+ id+ " Emp name "+ n +" Emp exp: "+exp);
	}
	

}
