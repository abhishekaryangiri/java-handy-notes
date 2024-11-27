package basicproblems;

import java.util.HashMap;
import java.util.Scanner;

public class Hashmap0101addpeopleandgetpeplebyid {
public static void main(String[] args) {
    // Create a HashMap to store people with their IDs as keys
    HashMap<Integer, String> people = new HashMap<>();

    // Adding 4 people to the list
    people.put(1, "Alice");
    people.put(2, "Bob");
    people.put(3, "Charlie");
    people.put(4, "Diana");

    // Prompt user to enter an ID to access a person's details
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter an ID to get the person's details (1-4):");
    int inputId = scanner.nextInt();

    // Access and display the person's details
    if (people.containsKey(inputId)) {
        System.out.println("ID: " + inputId + ", Name: " + people.get(inputId));
    } else {
        System.out.println("No person found with ID " + inputId);
    }

    scanner.close();
}
}
