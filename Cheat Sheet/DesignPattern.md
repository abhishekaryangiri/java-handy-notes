### **Design Patterns Cheat Sheet with Detailed Explanations**

Design patterns provide general solutions to commonly occurring problems in software design. They allow you to reuse proven designs and improve system architecture by focusing on flexibility, maintainability, and scalability. 

Design patterns are generally classified into three main categories:
1. **Creational Patterns**
2. **Structural Patterns**
3. **Behavioral Patterns**

**Low-Level Design (LLD)** and **High-Level Design (HLD)** are often used to describe how systems or components are structured and how they interact, respectively, and they align closely with the use of design patterns.

---

### **1. Creational Design Patterns**
These patterns deal with the object creation mechanism, trying to create objects in a manner suitable to the situation.

#### **1.1 Singleton Pattern**
- **Purpose**: Ensures that a class has only one instance and provides a global point of access to that instance.
- **Use Case**: Used when only one instance of a class is needed, e.g., for logging, database connections, etc.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {} // private constructor

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

#### **1.2 Factory Method Pattern**
- **Purpose**: Defines an interface for creating objects but allows subclasses to decide which class to instantiate.
- **Use Case**: Used when the exact type of the object cannot be determined until runtime.

```java
interface Product {
    void create();
}

class ConcreteProductA implements Product {
    public void create() {
        System.out.println("Product A created");
    }
}

abstract class Creator {
    abstract Product factoryMethod();
}

class ConcreteCreator extends Creator {
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
```

#### **1.3 Abstract Factory Pattern**
- **Purpose**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- **Use Case**: Used when you have multiple types of related objects that should be created together (e.g., in GUI libraries with themes, colors, and widgets).

```java
interface ProductA {
    void create();
}

class ConcreteProductA1 implements ProductA {
    public void create() {
        System.out.println("Concrete Product A1 created");
    }
}

interface AbstractFactory {
    ProductA createProductA();
}

class ConcreteFactory implements AbstractFactory {
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }
}
```

---

### **2. Structural Design Patterns**
These patterns focus on simplifying the structure of complex systems by identifying simple ways to realize relationships between objects.

#### **2.1 Adapter Pattern**
- **Purpose**: Converts the interface of a class into another interface that a client expects. It allows classes to work together that couldn’t otherwise due to incompatible interfaces.
- **Use Case**: Used when you want to integrate a legacy system with a new one that uses a different interface.

```java
interface Target {
    void request();
}

class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee specific request");
    }
}

class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}
```

#### **2.2 Composite Pattern**
- **Purpose**: Allows you to compose objects into tree-like structures to represent part-whole hierarchies.
- **Use Case**: Used when objects are naturally hierarchical, e.g., graphical user interface elements.

```java
interface Component {
    void operation();
}

class Leaf implements Component {
    public void operation() {
        System.out.println("Leaf operation");
    }
}

class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void operation() {
        for (Component child : children) {
            child.operation();
        }
    }
}
```

---

### **3. Behavioral Design Patterns**
Behavioral design patterns are concerned with algorithms and the assignment of responsibilities between objects.

#### **3.1 Observer Pattern**
- **Purpose**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified.
- **Use Case**: Used in event handling systems, such as GUI systems or messaging apps.

```java
interface Observer {
    void update(String message);
}

class ConcreteObserver implements Observer {
    public void update(String message) {
        System.out.println("Received message: " + message);
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
```

#### **3.2 Strategy Pattern**
- **Purpose**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. It allows the algorithm to be selected at runtime.
- **Use Case**: Used when you have different ways of performing a task, e.g., sorting algorithms.

```java
interface Strategy {
    void execute();
}

class ConcreteStrategyA implements Strategy {
    public void execute() {
        System.out.println("Executing strategy A");
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}
```

#### **3.3 Chain of Responsibility Pattern**
- **Purpose**: Allows passing a request along a chain of handlers. Each handler can either process the request or pass it along to the next handler.
- **Use Case**: Used in logging frameworks, event handling systems, or GUI toolkits.

```java
abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler handler) {
        nextHandler = handler;
    }

    public abstract void handleRequest(String request);
}

class ConcreteHandlerA extends Handler {
    public void handleRequest(String request) {
        if (request.equals("A")) {
            System.out.println("Handler A processing the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
```

---

### **LLD (Low-Level Design) and HLD (High-Level Design)**

#### **LLD (Low-Level Design)**
- **Purpose**: Focuses on the implementation details. It deals with classes, methods, and interactions among objects. The design is detailed and addresses the specific needs of each component.
- **Use Case**: Provides a detailed understanding of how to implement the system from a code perspective. It includes entity diagrams, class structures, and UML diagrams.

#### **HLD (High-Level Design)**
- **Purpose**: Provides a broader overview of the system architecture. It represents the system's major components, the relationships between them, and the interaction between external systems.
- **Use Case**: Used for building the system architecture. Includes diagrams like block diagrams, system flow diagrams, and component interaction diagrams.

---

### **Common Design Pattern Interview Questions**

### 1. **What is the difference between Singleton and Factory Design Patterns?**
   - **Singleton**: Ensures only one instance of a class is created, providing a global point of access.
   - **Factory**: Defines an interface for creating objects but allows subclasses to change the type of object that is created.

### 2. **What is the Adapter Pattern and when would you use it?**
   - The **Adapter Pattern** allows incompatible interfaces to work together by converting the interface of a class into another interface that the client expects. Used when integrating systems with incompatible interfaces.

### 3. **What is the Observer Pattern?**
   - The **Observer Pattern** defines a one-to-many dependency between objects. When one object changes its state, all its dependents (observers) are notified. Common in event-driven systems like GUIs.

### 4. **What are some real-world applications of the Strategy Pattern?**
   - The **Strategy Pattern** is used when there are multiple ways to perform an operation, and the specific method is chosen at runtime. Examples include choosing different payment methods in an e-commerce system, sorting algorithms, or compression strategies.

### 5. **Explain the Composite Pattern with an example.**
   - The **Composite Pattern** is used when you need to work with groups of objects in a uniform way. It allows you to combine objects into tree-like structures to represent part-whole hierarchies. Example: A file system where files and directories are treated uniformly.

### 6. **How does the Chain of Responsibility pattern work?**
   - The **Chain of Responsibility** pattern allows passing a request along a chain of handlers. Each handler can process the request or pass it on to the next handler. Example: Event handling in GUIs or request filtering in web servers.


Here are some more **Design Pattern** interview questions with detailed explanations that are commonly asked during interviews, focusing on various design patterns:

### **7. What is the difference between the Factory Method and Abstract Factory Pattern?**
- **Factory Method**:
  - A method that is responsible for creating an object, but it allows subclasses to alter the type of objects that will be created.
  - It focuses on creating a single type of object based on certain conditions or criteria.
  - **Example**: A document generator that can create PDF, HTML, or Word documents.
  
- **Abstract Factory**:
  - Provides an interface for creating families of related or dependent objects, without specifying their concrete classes.
  - It creates related product objects, which are designed to work together. This is usually used when the system needs to create a series of related objects that should work together.
  - **Example**: A GUI library that can create different sets of widgets for different operating systems (like Windows or Linux).
  
  **Key Difference**: The Factory Method creates one object, whereas the Abstract Factory creates a family of related objects.

---

### **8. What is the difference between Composite and Decorator Pattern?**
- **Composite Pattern**:
  - Allows you to compose objects into tree-like structures to represent part-whole hierarchies. This pattern is used when you want to treat individual objects and compositions of objects uniformly.
  - **Use Case**: Organizing a directory structure where a file (leaf) and folder (composite) are treated as the same object.
  
- **Decorator Pattern**:
  - Allows you to add responsibilities to an object dynamically. It’s used to extend the behavior of a class without modifying its source code.
  - **Use Case**: Adding additional functionalities to a graphical object such as a window (like adding borders, scroll bars, etc.) dynamically.

  **Key Difference**: The Composite Pattern is used for hierarchical structures, while the Decorator Pattern adds functionalities to objects dynamically.

---

### **9. Can you explain the Proxy Pattern with an example?**
- **Proxy Pattern**:
  - The Proxy Pattern provides an object representing another object. This pattern is used to control access to the real object and can serve as a placeholder for the real object, controlling access, and adding additional behavior (e.g., lazy loading, access control).
  - **Use Case**: Used for remote service access, virtual proxy for lazy loading objects, and protection proxy for security purposes.

  **Example**:
  
  ```java
  interface Image {
      void display();
  }

  class RealImage implements Image {
      private String filename;

      public RealImage(String filename) {
          this.filename = filename;
      }

      public void display() {
          System.out.println("Displaying image: " + filename);
      }
  }

  class ProxyImage implements Image {
      private RealImage realImage;
      private String filename;

      public ProxyImage(String filename) {
          this.filename = filename;
      }

      public void display() {
          if (realImage == null) {
              realImage = new RealImage(filename);
          }
          realImage.display();
      }
  }
  ```

  **Key Point**: The Proxy Pattern is typically used to manage and optimize access to an object.

---

### **10. When would you use the Flyweight Pattern?**
- **Flyweight Pattern**:
  - It is used to minimize memory usage by sharing as many data as possible with similar objects. Instead of creating new objects for similar data, the Flyweight pattern shares the common state and keeps the state unique to each object separately.
  - **Use Case**: For example, in a word processor, many words may be typed using the same font, size, and color. Rather than storing a separate object for each word with the same font, size, and color, the Flyweight pattern can be used to share common properties.

  **Example**:

  ```java
  class Font {
      private String style;

      public Font(String style) {
          this.style = style;
      }

      public String getStyle() {
          return style;
      }
  }

  class Word {
      private String word;
      private Font font;

      public Word(String word, Font font) {
          this.word = word;
          this.font = font;
      }

      public void display() {
          System.out.println("Word: " + word + " with Font Style: " + font.getStyle());
      }
  }
  ```

  **Key Point**: The Flyweight Pattern is ideal for scenarios where the system needs to manage large numbers of similar objects, and you want to minimize memory usage by sharing parts of those objects.

---

### **11. What is the State Pattern and when is it used?**
- **State Pattern**:
  - The State Pattern allows an object to change its behavior when its internal state changes. It appears as if the object has changed its class. It is useful for systems where an object's behavior depends on its state.
  - **Use Case**: Commonly used in scenarios like workflow systems, where an object’s state dictates how it behaves or interacts with other objects.

  **Example**:

  ```java
  interface State {
      void handle();
  }

  class ConcreteStateA implements State {
      public void handle() {
          System.out.println("State A handling the request");
      }
  }

  class ConcreteStateB implements State {
      public void handle() {
          System.out.println("State B handling the request");
      }
  }

  class Context {
      private State state;

      public void setState(State state) {
          this.state = state;
      }

      public void request() {
          state.handle();
      }
  }
  ```

  **Key Point**: The State Pattern is used to manage the state-dependent behavior of an object in a system.

---

### **12. What is the Builder Pattern and when is it useful?**
- **Builder Pattern**:
  - The Builder Pattern allows the construction of complex objects step by step. It is particularly useful when an object needs to be created with many optional components, or when an object is too complex to construct in a single method call.
  - **Use Case**: Building complex objects like a `House` or `Car`, where the builder allows you to configure the object step by step.

  **Example**:

  ```java
  class Car {
      private String model;
      private String engine;
      private String color;

      public void setModel(String model) { this.model = model; }
      public void setEngine(String engine) { this.engine = engine; }
      public void setColor(String color) { this.color = color; }
  }

  class CarBuilder {
      private Car car = new Car();

      public CarBuilder buildModel(String model) {
          car.setModel(model);
          return this;
      }

      public CarBuilder buildEngine(String engine) {
          car.setEngine(engine);
          return this;
      }

      public CarBuilder buildColor(String color) {
          car.setColor(color);
          return this;
      }

      public Car build() {
          return car;
      }
  }
  ```

  **Key Point**: The Builder Pattern is useful when you need to create an object with many possible configurations or options.

---

### **13. How does the Template Method Pattern work?**
- **Template Method Pattern**:
  - Defines the skeleton of an algorithm in the superclass but allows subclasses to implement specific steps of the algorithm. It is used to define the structure of an algorithm while allowing customization of specific steps.
  - **Use Case**: Used when several classes share the same algorithm structure but need to implement certain steps in different ways.

  **Example**:

  ```java
  abstract class AbstractClass {
      public final void templateMethod() {
          step1();
          step2();
          step3();
      }

      abstract void step1();
      abstract void step2();
      abstract void step3();
  }

  class ConcreteClassA extends AbstractClass {
      void step1() { System.out.println("Concrete Class A - Step 1"); }
      void step2() { System.out.println("Concrete Class A - Step 2"); }
      void step3() { System.out.println("Concrete Class A - Step 3"); }
  }
  ```

  **Key Point**: The Template Method Pattern is used when you have a common sequence of steps but want to allow customization of some steps.

---

### **14. What is the Mediator Pattern?**
- **Mediator Pattern**:
  - The Mediator Pattern is used to reduce the communication complexity between multiple objects or classes. Instead of objects referring to each other directly, they refer to a mediator, which handles the interactions between the objects.
  - **Use Case**: Used in chat systems or workflows where multiple components need to interact but shouldn’t have direct references to each other.

  **Example**:

  ```java
  interface Mediator {
      void send(String message, Colleague colleague);
  }

  class ConcreteMediator implements Mediator {
      private ColleagueA colleagueA;
      private ColleagueB colleagueB;

      public void setColleagueA(ColleagueA colleagueA) {
          this.colleagueA = colleagueA;
      }

      public void setColleagueB(ColleagueB colleagueB) {
          this.colleagueB = colleagueB;
      }

      public void send(String message, Colleague colleague) {
          if (colleague == colleagueA) {
              colleagueB.receive(message);
          } else {
              colleagueA.receive(message);
          }
      }
  }

  abstract class Colleague {
      protected Mediator mediator;

      public Colleague(Mediator mediator) {
          this.mediator = mediator;
      }

      public abstract void receive(String message);
  }

  class ColleagueA extends Colleague {
      public ColleagueA(Mediator mediator) {
          super(mediator);
     

 }

      public void receive(String message) {
          System.out.println("ColleagueA received message: " + message);
      }
  }

  class ColleagueB extends Colleague {
      public ColleagueB(Mediator mediator) {
          super(mediator);
      }

      public void receive(String message) {
          System.out.println("ColleagueB received message: " + message);
      }
  }
  ```

  **Key Point**: The Mediator Pattern is useful for reducing direct dependencies between objects, simplifying communication and coordination.

---

### **Conclusion**
Design patterns offer proven solutions to recurring design problems. These patterns play a crucial role in software development, ensuring that your codebase is scalable, maintainable, and flexible. Understanding and applying these patterns is key to writing efficient and reusable code, especially in large-scale systems.

For a full-stack Java developer, understanding the design patterns and knowing when and how to use them is vital for building robust, scalable systems. Keep practicing the implementation of these patterns to improve your problem-solving skills in interviews.
### **Conclusion**

Design patterns are essential in designing scalable and maintainable software systems. **Creational**, **Structural**, and **Behavioral patterns** offer solutions to common problems faced during software development. In interviews, being able to explain and implement design patterns effectively is crucial, especially for system design problems where the knowledge of **Low-Level Design (LLD)** and **High-Level Design (HLD)** is critical.



