1. Singleton Pattern - Deep Understanding

What is Singleton Pattern?

Singleton Pattern is a Creational Design Pattern that ensures a class has only one instance and provides a global access point to it.

Why Use It?

We use Singleton when we need only one instance of a class throughout the application, such as:

Database Connection – A single connection should be shared across the system.

Caching System – Store frequently accessed data to avoid redundant calls.

Logging System – A single logger instance should handle logs.

Thread Pool – A fixed number of threads should be managed centrally.



---

How Does It Work?

1. Make the constructor private, so no external class can instantiate it using new.


2. Provide a static method that returns the same instance every time.


3. Store the instance in a static variable, so it remains the same throughout the application.




---

Singleton Implementation (Lazy Initialization)

class Singleton {
    // 1. Static instance variable
    private static Singleton instance;

    // 2. Private constructor (Prevents direct instantiation)
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    // 3. Static method to return instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();  // Instance created only once
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        obj1.showMessage();
        
        // Both objects have the same hashcode (Same instance)
        System.out.println(obj1.hashCode()); 
        System.out.println(obj2.hashCode()); 
    }
}

Output:

Singleton instance created.
Hello from Singleton!
12345678  (Both objects have the same hashcode)
12345678


---

Thread-safe Singleton

If the application is running in a multi-threaded environment, synchronized is needed to prevent multiple instances.

class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


---

Real-life Examples:

1. Database Connection

A database connection should be a single instance throughout the application to optimize resource usage.

2. Log Manager

A logging system should have only one instance to maintain consistency in log files.


---

2. Factory Pattern - Deep Understanding

What is Factory Pattern?

Factory Pattern is a Creational Design Pattern that hides object creation logic and allows dynamic instantiation of objects.

Why Use It?

1. Encapsulation: Hides object creation details from the client.


2. Loose Coupling: The client does not need to know which concrete class to instantiate.


3. Flexibility: Easy to add new object types without modifying existing code.




---

How Does It Work?

1. Create a Factory Class, which decides which object to create.


2. Use an Interface or Abstract Class for object types.


3. The client class does not know which exact object is created.




---

Factory Pattern Implementation

Let's create a Vehicle Factory that can produce Car and Bike objects.

// 1. Parent Interface
interface Vehicle {
    void drive();
}

// 2. Concrete Classes
class Car implements Vehicle {
    public void drive() {
        System.out.println("Car is driving.");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Bike is driving.");
    }
}

// 3. Factory Class
class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("Bike")) {
            return new Bike();
        }
        return null;
    }
}

// 4. Client Code
public class Main {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("Car");
        Vehicle bike = VehicleFactory.getVehicle("Bike");

        car.drive();  // Output: Car is driving.
        bike.drive(); // Output: Bike is driving.
    }
}


---

Real-life Examples:

1. Payment System

If we need an online Payment Gateway supporting PayPal, UPI, and Credit Card, we can use Factory Pattern to dynamically create the required payment method.

2. Notification System

For sending SMS, Email, and Push Notifications, we can use Factory Pattern.

interface Notification {
    void notifyUser();
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS Notification");
    }
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email Notification");
    }
}

class NotificationFactory {
    public static Notification getNotification(String type) {
        if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("Email")) {
            return new EmailNotification();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.getNotification("SMS");
        notification.notifyUser();  // Output: Sending SMS Notification
    }
}


---

Conclusion

Singleton Pattern ensures only one instance of a class exists throughout the application.

Factory Pattern helps in creating objects dynamically without exposing object creation logic.


Let me know if you need more details!

