package basicproblems;

import java.util.HashMap;
import java.util.Scanner;

class Person{
	
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// Inner class to manage the list of people
    public static class PeopleList {
        private HashMap<Integer, Person> people = new HashMap<>();

        // Method to add a person to the list
        public void addPerson(int id, String name) {
            Person person = new Person();
            person.setId(id);
            person.setName(name);
            people.put(id, person);
        }

        // Method to get a person by ID
        public Person getPersonById(int id) {
            return people.get(id);
        }
    }
}


public class HashMap01setListandGetbyId {

    public static void main(String[] args) {
        // Create an instance of PeopleList
        Person.PeopleList peopleList = new Person.PeopleList();

        // Add people to the list
        peopleList.addPerson(1, "Alice");
        peopleList.addPerson(2, "Bob");
        peopleList.addPerson(3, "Charlie");
        peopleList.addPerson(4, "Diana");

        // Prompt user to enter an ID
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an ID to get the person's details:");
        int inputId = scanner.nextInt();

        // Fetch and display the person's details
        Person person = peopleList.getPersonById(inputId);
        if (person != null) {
            System.out.println("ID: " + person.getId() + ", Name: " + person.getName());
        } else {
            System.out.println("No person found with ID " + inputId);
        }

        scanner.close();	 
}
}


