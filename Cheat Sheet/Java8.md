### **Java 8 Cheat Sheet with Detailed Explanation**

Java 8 introduced several powerful features that greatly enhanced the language and made it more functional and expressive. Below is a cheat sheet that covers the key features of Java 8 with detailed explanations.

---

### **1. Lambda Expressions**

- **Definition**: Lambda expressions provide a clear and concise way to represent an instance of a functional interface (an interface with a single abstract method). It allows us to treat functionality as a method argument or to create a short function.

#### **Syntax**:
```java
(parameters) -> expression
```

- **Example**:
```java
// Lambda expression for adding two numbers
(int a, int b) -> a + b;
```

- **Usage**: You can use lambda expressions with **functional interfaces** such as `Runnable`, `Callable`, `Comparator`, etc.

---

### **2. Functional Interfaces**

- **Definition**: A **functional interface** is an interface with just **one abstract method**. It can have multiple default or static methods.

- **Common Examples**: 
  - `Runnable`, `Callable`, `Comparator`, `Predicate`, `Consumer`, `Function`

- **Syntax**:
```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void myMethod(); // single abstract method
}
```

- **Predefined Functional Interfaces**:
  - `Predicate<T>`: Represents a boolean-valued function of one argument.
  - `Consumer<T>`: Represents an operation that accepts a single input argument and returns no result.
  - `Function<T, R>`: Represents a function that accepts one argument and produces a result.
  - `Supplier<T>`: Represents a supplier of results.

- **Example**:
```java
// Using Predicate
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(4)); // true
```

---

### **3. Stream API**

- **Definition**: The Stream API allows you to process sequences of elements (e.g., collections) in a functional style. It can be used to perform complex data manipulations such as filtering, mapping, and reducing.

- **Key Methods**:
  - `filter()`: Filters elements based on a condition.
  - `map()`: Transforms each element in the stream.
  - `reduce()`: Reduces elements to a single value.
  - `forEach()`: Performs an action for each element in the stream.
  - `collect()`: Collects elements from the stream into a collection.
  
#### **Syntax**:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .filter(n -> n % 2 == 0)    // Filter even numbers
       .map(n -> n * n)            // Square the numbers
       .forEach(System.out::println); // Print each number
```

---

### **4. Default Methods**

- **Definition**: Java 8 allows interfaces to have **default methods**, which have a method body. These methods can be overridden by implementing classes, but they are not required to be overridden.

- **Syntax**:
```java
public interface MyInterface {
    default void defaultMethod() {
        System.out.println("This is a default method");
    }
}
```

- **Example**:
```java
public interface Vehicle {
    default void start() {
        System.out.println("Vehicle starting...");
    }
}
```

---

### **5. Method References**

- **Definition**: Method references are a shorthand notation of a lambda expression that calls a method.

- **Types of Method References**:
  - **Static method reference**: `ClassName::methodName`
  - **Instance method reference**: `object::methodName`
  - **Constructor reference**: `ClassName::new`

- **Example**:
```java
// Method reference to a static method
List<String> names = Arrays.asList("Tom", "Jerry", "Mickey");
names.forEach(System.out::println); // Equivalent to (name) -> System.out.println(name);
```

---

### **6. Optional Class**

- **Definition**: `Optional` is a container object which may or may not contain a non-null value. It is used to avoid `NullPointerExceptions` in Java programs by explicitly handling null values.

- **Key Methods**:
  - `isPresent()`: Returns true if there is a value present.
  - `ifPresent()`: If a value is present, it performs the given action.
  - `orElse()`: Returns the value if present, or the given default value if absent.
  - `map()`: Applies a function if a value is present.

#### **Example**:
```java
Optional<String> name = Optional.ofNullable("Java");
name.ifPresent(System.out::println); // Prints "Java"
```

---

### **7. New Date and Time API (java.time package)**

- **Definition**: Java 8 introduced a new Date-Time API (`java.time`) that is immutable and thread-safe. It includes `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, and `Instant` classes.

- **Key Classes**:
  - `LocalDate`: Represents a date without time.
  - `LocalTime`: Represents time without date.
  - `LocalDateTime`: Represents date and time without timezone.
  - `ZonedDateTime`: Represents date and time with a timezone.
  - `Instant`: Represents a point in time (timestamp).

#### **Example**:
```java
// Getting current date and time
LocalDateTime now = LocalDateTime.now();
System.out.println(now);

// Formatting Date
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
String formattedDate = now.format(formatter);
System.out.println(formattedDate);
```

---

### **8. Nashorn JavaScript Engine**

- **Definition**: Nashorn is the JavaScript engine that comes with Java 8. It allows you to run JavaScript code from Java, or integrate JavaScript code into Java applications.

- **Example**:
```java
ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
engine.eval("print('Hello from JavaScript')");
```

---

### **9. Collector Interface**

- **Definition**: The `Collector` interface provides a way to collect elements from a Stream into a different form (like a list, set, map, etc.). It is typically used with the `collect()` method.

- **Common Collectors**:
  - `Collectors.toList()`
  - `Collectors.toSet()`
  - `Collectors.joining()`
  - `Collectors.groupingBy()`
  - `Collectors.partitioningBy()`

#### **Example**:
```java
List<String> names = Arrays.asList("Tom", "Jerry", "Mickey");
List<String> result = names.stream()
                           .filter(name -> name.startsWith("T"))
                           .collect(Collectors.toList());
System.out.println(result);
```

---

### **10. Streams Parallelism**

- **Definition**: In Java 8, Streams can be processed in parallel, which can significantly improve performance for large datasets by utilizing multiple cores.

- **How to use**: 
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.parallelStream().mapToInt(Integer::intValue).sum();
System.out.println(sum);
```

---

### **11. Concurrency Enhancements (CompletableFuture)**

- **Definition**: Java 8 introduces `CompletableFuture`, which allows you to write non-blocking asynchronous code in a more straightforward and flexible way.

#### **Example**:
```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                                                    .thenApplyAsync(result -> result * 2)
                                                    .thenApplyAsync(result -> result + 5);
System.out.println(future.get()); // Output: 25
```

---

### **12. Default Methods in Interfaces**

- **Definition**: Java 8 allows interfaces to have methods with a body. These methods are known as **default methods**, and they can be implemented directly in the interface.

#### **Example**:
```java
interface Vehicle {
    default void honk() {
        System.out.println("Honk! Honk!");
    }
}

class Car implements Vehicle {
    public static void main(String[] args) {
        Car car = new Car();
        car.honk();  // Output: Honk! Honk!
    }
}
```


-------------------------------------------------------------


### **Java 8 Interview Questions with Detailed Explanations**

Java 8 introduced a plethora of features that revolutionized how Java developers approach programming. Here is a comprehensive list of common Java 8 interview questions along with detailed explanations to help you prepare.

---

### **1. What are the main features introduced in Java 8?**

**Answer:**
Java 8 introduced several new features that significantly improved the Java programming language. The key features are:
- **Lambda Expressions**: Simplify code by passing behavior as parameters, allowing you to write more concise code.
- **Functional Interfaces**: Interfaces with just one abstract method that can be implemented with lambda expressions.
- **Stream API**: Provides a modern approach for handling collections with operations like filtering, mapping, and reducing.
- **Default Methods**: Allows interfaces to have method implementations, ensuring backward compatibility.
- **New Date and Time API**: A new `java.time` package to replace `java.util.Date` with a more accurate and easier-to-use API.
- **Nashorn JavaScript Engine**: Enables running JavaScript code from Java.

---

### **2. What is a Lambda Expression?**

**Answer:**
A **Lambda expression** is a concise way of representing an anonymous function (or method) that can be passed as an argument to a method. It allows you to treat behavior as a parameter to methods, enabling functional programming in Java.

**Syntax**:
```java
(parameters) -> expression
```

**Example**:
```java
// Lambda expression to add two numbers
(int a, int b) -> a + b;
```

---

### **3. What is a Functional Interface? Give an example.**

**Answer:**
A **Functional Interface** is an interface that contains exactly one abstract method, and it can have multiple default or static methods. These interfaces can be used as the target types for lambda expressions.

**Example**:
```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void myMethod(); // single abstract method
}
```

- **Common Functional Interfaces**:
  - `Predicate<T>`
  - `Consumer<T>`
  - `Function<T, R>`
  - `Supplier<T>`
  
**Example Usage**:
```java
// Using a functional interface with lambda
Function<Integer, Integer> square = x -> x * x;
System.out.println(square.apply(5)); // Output: 25
```

---

### **4. What is the Stream API in Java 8?**

**Answer:**
The **Stream API** in Java 8 allows you to process sequences of elements (e.g., collections) in a functional manner. You can use streams to perform filtering, mapping, and reducing operations in a more declarative style.

- **Key Features of Stream API**:
  - **Intermediate Operations**: Operations like `filter()`, `map()`, `distinct()`, `sorted()`, etc.
  - **Terminal Operations**: Operations like `collect()`, `forEach()`, `reduce()`, etc., that produce a result or a side-effect.

**Example**:
```java
List<String> names = Arrays.asList("John", "Jane", "Alice", "Bob");
names.stream()
     .filter(name -> name.startsWith("J"))
     .forEach(System.out::println); // Output: John, Jane
```

---

### **5. What is the difference between `map()` and `flatMap()` in Java 8 Streams?**

**Answer:**
- **`map()`**: It is used to transform elements of the stream into another form. The result is a stream of transformed elements.
- **`flatMap()`**: It is used when you want to flatten a nested structure (e.g., a stream of lists) into a single stream.

**Example**:

```java
List<List<String>> nestedList = Arrays.asList(
    Arrays.asList("John", "Jane"), Arrays.asList("Alice", "Bob")
);

// Using map (results in a stream of lists)
nestedList.stream().map(list -> list.get(0)).forEach(System.out::println);

// Using flatMap (flattens the lists into a single stream)
nestedList.stream().flatMap(list -> list.stream()).forEach(System.out::println);
```

---

### **6. What are Default Methods in Java 8?**

**Answer:**
**Default methods** are methods defined in an interface that have a method body. They allow interfaces to have method implementations, making it possible to add new methods to an interface without breaking existing implementations.

**Syntax**:
```java
interface MyInterface {
    default void defaultMethod() {
        System.out.println("Default method");
    }
}
```

**Usage**: Default methods help to add new functionalities to interfaces without affecting existing implementations.

---

### **7. What is the `Optional` class in Java 8?**

**Answer:**
The **`Optional`** class is used to represent a value that may or may not be present. It helps avoid `NullPointerException` by explicitly checking whether a value is present or not before performing operations.

**Key Methods**:
- `isPresent()`: Returns true if the value is present.
- `ifPresent()`: Executes the provided action if the value is present.
- `orElse()`: Returns the value if present, or a default value if absent.
- `get()`: Retrieves the value if present, throwing `NoSuchElementException` if not.

**Example**:
```java
Optional<String> name = Optional.ofNullable("John");
System.out.println(name.orElse("Default")); // Output: John

Optional<String> emptyName = Optional.ofNullable(null);
System.out.println(emptyName.orElse("Default")); // Output: Default
```

---

### **8. What is the new Date and Time API in Java 8?**

**Answer:**
Java 8 introduced a new **Date and Time API** (`java.time` package) that provides a better, immutable, and thread-safe alternative to the old `java.util.Date` and `java.util.Calendar` classes.

**Key Classes**:
- **`LocalDate`**: Represents a date without time (e.g., 2021-12-15).
- **`LocalTime`**: Represents a time without a date (e.g., 12:30 PM).
- **`LocalDateTime`**: Represents both date and time (e.g., 2021-12-15T12:30:00).
- **`ZonedDateTime`**: Represents a date and time with a time zone.

**Example**:
```java
LocalDateTime now = LocalDateTime.now();
System.out.println(now);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
System.out.println(now.format(formatter)); // Output: 2021-12-15
```

---

### **9. What is a Method Reference in Java 8?**

**Answer:**
A **method reference** is a shorthand notation for a lambda expression that calls a method. It is used to refer to a method directly using its name, which makes the code more readable.

**Types of Method References**:
- **Static method reference**: `ClassName::staticMethod`
- **Instance method reference**: `instance::instanceMethod`
- **Constructor reference**: `ClassName::new`

**Example**:
```java
// Using method reference to print names
List<String> names = Arrays.asList("John", "Jane", "Bob");
names.forEach(System.out::println);
```

---

### **10. What are the differences between `==` and `.equals()` in Java 8?**

**Answer:**
- **`==`**: Checks if two object references point to the same memory location (i.e., if they are the same object).
- **`.equals()`**: Checks if the content of two objects is the same (i.e., if they are logically equal).

**Example**:
```java
String str1 = new String("Java");
String str2 = new String("Java");
System.out.println(str1 == str2);        // false (different memory locations)
System.out.println(str1.equals(str2));   // true (same content)
```

---

### **11. What is the difference between `findFirst()` and `findAny()` in Java 8 Streams?**

**Answer:**
- **`findFirst()`**: Returns the first element of the stream, or an empty `Optional` if the stream is empty.
- **`findAny()`**: Returns any element from the stream (can return the first one or any other, depending on parallel streams).

**Example**:
```java
List<String> list = Arrays.asList("A", "B", "C", "D");

// findFirst()
Optional<String> first = list.stream().findFirst();
System.out.println(first.get()); // Output: A

// findAny()
Optional<String> any = list.stream().findAny();
System.out.println(any.get()); // Output could be A, B, C, or D
```

---

### **12. What is `Collectors` in Java 8?**

**Answer:**
The **`Collectors`** class provides a set of useful static methods to collect elements of a stream into various types, such as a list, set, map, etc.

- **Common Collectors**:
  - `toList()`: Collects elements into a list.
  - `toSet()`: Collects elements into a set.
  - `joining()`: Concatenates elements into a single string.
  - `groupingBy()`: Groups elements by a classifier function.
  - `partitioningBy()`: Divides elements into two groups.

**Example**:
```java
List<String> names = Arrays.asList("John", "Jane", "Alice");


List<String> collected = names.stream().collect(Collectors.toList());
System.out.println(collected); // Output: [John, Jane, Alice]
```

------------------------------------------
