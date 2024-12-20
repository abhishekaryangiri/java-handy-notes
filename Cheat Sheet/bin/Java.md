






---

# Object-Oriented Programming (OOP) Cheat Sheet

### 1. **Class and Object**

- **Class**: A blueprint for creating objects (instances). It defines properties and methods.
- **Object**: An instance of a class that holds data and methods to perform actions on the data.

```java
// Class definition
class Car {
    String model;
    int year;
    
    // Method
    void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
    }
}

// Creating an object
public class Main {
    public static void main(String[] args) {
        Car car = new Car(); // Creating an object
        car.model = "Toyota";
        car.year = 2020;
        car.displayInfo(); // Calling method on object
    }
}
```

### 2. **Encapsulation**

Encapsulation is the concept of wrapping data (variables) and methods into a single unit known as class. It hides the internal state and requires interaction only through getter and setter methods.

```java
class Person {
    private String name; // Private variable

    // Getter method
    public String getName() {
        return name;
    }

    // Setter method
    public void setName(String name) {
        this.name = name;
    }
}
```

### 3. **Abstraction**

Abstraction is the concept of hiding the implementation details and showing only the essential features of an object. It is achieved using abstract classes or interfaces.

```java
abstract class Animal {
    abstract void sound(); // Abstract method
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound(); // Output: Bark
    }
}
```

### 4. **Inheritance**

Inheritance is a mechanism where a new class (subclass) inherits the properties and methods of an existing class (superclass).

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(); // Inherited method
        dog.bark(); // Dog's own method
    }
}
```

### 5. **Polymorphism**

Polymorphism allows a class to have multiple forms. It can be achieved through method overloading (compile-time polymorphism) and method overriding (runtime polymorphism).

#### Method Overloading (Compile-time Polymorphism)
```java
class Printer {
    void print(int a) {
        System.out.println("Printing integer: " + a);
    }
    
    void print(String a) {
        System.out.println("Printing string: " + a);
    }
}
```

#### Method Overriding (Runtime Polymorphism)
```java
class Animal {
    void sound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound(); // Output: Bark
    }
}
```

### 6. **this Keyword**

The `this` keyword refers to the current object. It is often used to refer to the current class’s instance variables.

```java
class Student {
    String name;
    
    Student(String name) {
        this.name = name; // Refers to the current object's name variable
    }
}
```

### 7. **super Keyword**

The `super` keyword refers to the parent class’s constructor or methods. It is used to call the superclass’s constructor or methods.

```java
class Animal {
    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {
    Dog() {
        super(); // Calls parent class constructor
        System.out.println("Dog constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog(); // Output: Animal constructor, Dog constructor
    }
}
```

### 8. **Constructors: Default, Parameterized, Copy Constructor**

- **Default Constructor**: Automatically created by the compiler if no constructor is provided.
- **Parameterized Constructor**: Allows initialization of objects with specific values.
- **Copy Constructor**: Creates a new object as a copy of an existing object.

```java
class Person {
    String name;

    // Default constructor
    Person() {
        name = "John Doe";
    }

    // Parameterized constructor
    Person(String name) {
        this.name = name;
    }

    // Copy constructor
    Person(Person other) {
        this.name = other.name;
    }
}
```

### 9. **Method Overloading and Overriding**

- **Overloading**: Same method name, different parameters.
- **Overriding**: Same method name and same parameters but in a subclass.

```java
// Method Overloading
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
}

// Method Overriding
class Animal {
    void sound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

### 10. **Access Modifiers**

Access modifiers determine the visibility of classes, methods, and variables. There are four types:

- **public**: Accessible from anywhere.
- **private**: Accessible only within the same class.
- **protected**: Accessible within the same package and by subclasses.
- **default (no modifier)**: Accessible within the same package.

```java
class Example {
    public int publicVar;
    private int privateVar;
    protected int protectedVar;
    int defaultVar; // default access

    public void display() {
        System.out.println("Public: " + publicVar);
        System.out.println("Private: " + privateVar);
        System.out.println("Protected: " + protectedVar);
        System.out.println("Default: " + defaultVar);
    }
}
```

---

# 10 Interview Questions on OOP

### 1. **What is the difference between a class and an object?**

**Answer**: 
- A **class** is a blueprint or template for creating objects. It defines properties and behaviors. 
- An **object** is an instance of a class, containing real values for the class properties.

### 2. **What is encapsulation in OOP?**

**Answer**: 
Encapsulation is the concept of bundling the data (variables) and methods (functions) that operate on the data into a single unit or class. It hides the internal state of the object and only exposes the necessary methods to interact with it.

### 3. **What is the difference between abstraction and encapsulation?**

**Answer**: 
- **Abstraction** focuses on hiding the complex implementation details and showing only essential features of the object.
- **Encapsulation** involves bundling the data and methods in a single class and restricting access to some of the object's components.

### 4. **What is inheritance in OOP?**

**Answer**: 
Inheritance allows a class to inherit properties and methods from another class. This promotes code reusability and establishes a relationship between classes.

### 5. **What is polymorphism?**

**Answer**: 
Polymorphism allows one interface to be used for different data types. It is achieved through method overloading (compile-time polymorphism) and method overriding (runtime polymorphism).

### 6. **What is the use of the `this` keyword in Java?**

**Answer**: 
The `this` keyword refers to the current instance of the class. It is used to differentiate instance variables from local variables and to call the constructor of the same class.

### 7. **What is method overloading?**

**Answer**: 
Method overloading is the ability to define multiple methods in the same class with the same name but different parameters (different type, number, or both).

### 8. **What is method overriding?**

**Answer**: 
Method overriding occurs when a subclass provides a specific implementation of a method that is already defined in its superclass.

### 9. **What is a constructor in Java?**

**Answer**: 
A constructor is a special method used to initialize objects. It is called when an object of a class is created. There are default constructors (provided by Java) and parameterized constructors (defined by the user).

### 10. **What are the types of access modifiers in Java?**

**Answer**: 
Java has four types of access modifiers:
- **public**: Accessible from any other class.
- **private**: Accessible only within the same class.
- **protected**: Accessible within the same package or subclasses.
- **default**: Accessible only within the same package.

---

This cheat sheet provides a concise overview of OOP concepts with code examples and commonly asked interview questions to help you prepare.