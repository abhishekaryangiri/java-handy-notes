Here's an expanded **Spring Boot cheat sheet** covering all the essential topics and subtopics with detailed explanations. This cheat sheet includes **annotations**, configurations, security, and more.

---

## **1. Introduction to Spring Boot**

### **What is Spring Boot?**
- **Spring Boot** simplifies Java-based development by providing an opinionated framework with minimal setup and auto-configuration options.
- Allows you to run **standalone Spring applications** with embedded servers like Tomcat, Jetty, or Undertow.

### **Difference between Spring and Spring Boot**
- **Spring** requires a lot of configuration (e.g., XML or Java-based configuration) for setting up beans, views, and controllers.
- **Spring Boot** offers **auto-configuration**, embedded servers, and pre-built templates, making setup and development faster.

### **Spring Boot Features**
- **Auto-Configuration**: Automatically configures the application based on dependencies in the classpath.
- **Embedded Servers**: Built-in support for Tomcat, Jetty, and Undertow.
- **Standalone Applications**: Spring Boot apps can be packaged as a JAR and run as standalone applications.
- **Production-ready Features**: Built-in support for metrics, health checks, and application monitoring via **Spring Boot Actuator**.

---

## **2. Spring Boot Basics**

### **Creating a Simple Spring Boot Application**
- **`@SpringBootApplication`**: The main entry point annotation, combining **`@EnableAutoConfiguration`**, **`@ComponentScan`**, and **`@Configuration`**.
  ```java
  @SpringBootApplication
  public class MyApp {
      public static void main(String[] args) {
          SpringApplication.run(MyApp.class, args);
      }
  }
  ```

### **Dependency Injection**
- **Autowiring**: Spring automatically injects dependencies where needed using **`@Autowired`**.
  ```java
  @Service
  public class MyService {
      @Autowired
      private MyRepository repository;
  }
  ```

### **Application Properties**
- Configuration can be stored in **`application.properties`** or **`application.yml`**.
  ```properties
  server.port=8080
  spring.datasource.url=jdbc:mysql://localhost:3306/mydb
  ```

---

## **3. Spring Boot Annotations**

### **Common Annotations**
- **`@RestController`**: Used for RESTful web services.
  ```java
  @RestController
  public class HelloController {
      @GetMapping("/hello")
      public String hello() {
          return "Hello, Spring Boot!";
      }
  }
  ```

- **`@Controller`**: Used for MVC controllers (returns views).
  ```java
  @Controller
  public class WebController {
      @GetMapping("/home")
      public String home() {
          return "home";
      }
  }
  ```

- **`@RequestMapping`**: Maps HTTP requests to handler methods.
  ```java
  @RequestMapping("/api")
  public String getApiData() {
      return "API Data";
  }
  ```

- **`@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`**: Shortcuts for HTTP methods.
  ```java
  @GetMapping("/user")
  public User getUser(@RequestParam Long id) {
      return userRepository.findById(id);
  }
  ```

- **`@Service`**, **`@Component`**, **`@Repository`**: Marks beans for service layers, components, and repositories.
  ```java
  @Service
  public class MyService { }
  ```

- **`@Value`**: Injects values from the configuration.
  ```java
  @Value("${my.property}")
  private String property;
  ```

- **`@Profile`**: Activates beans only for specific profiles (e.g., development or production).
  ```java
  @Profile("dev")
  @Bean
  public DataSource devDataSource() {
      return new DataSource();
  }
  ```

---

## **4. Spring Boot Configuration**

### **Externalizing Configuration**
- **`application.properties`** or **`application.yml`** allows configuration properties to be stored externally (e.g., database configurations).
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/mydb
  ```

### **Using Profiles for Configuration**
- **`@Profile`**: Different beans are loaded for different environments.
  ```properties
  spring.profiles.active=dev
  ```

### **Configuration Classes and `@ConfigurationProperties`**
- Bind configuration properties to POJOs using **`@ConfigurationProperties`**.
  ```java
  @ConfigurationProperties(prefix = "app")
  public class AppConfig {
      private String name;
      private String version;
  }
  ```

---

## **5. Spring Boot Data Access**

### **Spring Data JPA**
- **`@Entity`**: Marks a class as a JPA entity.
- **`@Id`**, **`@GeneratedValue`**: Marks the primary key.
  ```java
  @Entity
  public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;
      private String name;
  }
  ```

### **Spring Boot with Relational Databases**
- **JPA**: Use **Spring Data JPA** for easy database access.
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/mydb
  ```

### **Spring Boot with NoSQL Databases**
- **MongoDB**, **Cassandra**, etc., can be used with Spring Boot for NoSQL databases.
  ```properties
  spring.data.mongodb.uri=mongodb://localhost:27017/mydb
  ```

---

## **6. Spring Boot RESTful Web Services**

### **Creating REST APIs**
- Use **`@RestController`** for defining RESTful APIs.
  ```java
  @RestController
  public class UserController {
      @GetMapping("/users")
      public List<User> getUsers() {
          return userRepository.findAll();
      }
  }
  ```

### **Handling Request and Response**
- **`@RequestBody`** and **`@ResponseBody`** for handling data transfer.
  ```java
  @PostMapping("/user")
  public User createUser(@RequestBody User user) {
      return userRepository.save(user);
  }
  ```

---

## **7. Spring Boot Exception Handling**

### **Global Exception Handling**
- **`@ControllerAdvice`**: Handles exceptions globally.
  ```java
  @ControllerAdvice
  public class GlobalExceptionHandler {
      @ExceptionHandler(UserNotFoundException.class)
      public ResponseEntity<String> handleUserNotFound(UserNotFoundException e) {
          return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
      }
  }
  ```

### **Custom Exception Handling**
- **`@ResponseStatus`**: Maps exceptions to HTTP status codes.
  ```java
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public class UserNotFoundException extends RuntimeException { }
  ```

---

## **8. Spring Boot Security**

### **Basic Authentication**
- **`@EnableWebSecurity`** enables Spring Security.
  ```java
  @EnableWebSecurity
  public class SecurityConfig extends WebSecurityConfigurerAdapter {
      @Override
      protected void configure(HttpSecurity http) throws Exception {
          http
              .authorizeRequests().anyRequest().authenticated()
              .and()
              .formLogin().and()
              .httpBasic();
      }
  }
  ```

### **JWT Authentication**
- **JWT (JSON Web Token)**: Used for stateless authentication in APIs.
  - Include **JWT** in the `Authorization` header for API requests.

### **Method Security**
- **`@PreAuthorize`** and **`@Secured`** annotations for securing methods.
  ```java
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteUser(Long userId) {
      // Logic to delete user
  }
  ```

### **CSRF and CORS**
- **Cross-Origin Resource Sharing (CORS)** can be enabled for specific controllers.
  ```java
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/api/data")
  public List<Data> getData() {
      return dataService.getAll();
  }
  ```

---

## **9. Spring Boot with Thymeleaf**

### **Thymeleaf Template Engine**
- **Thymeleaf** is a Java-based templating engine for rendering dynamic web pages.
  ```html
  <html xmlns:th="http://www.thymeleaf.org">
      <body>
          <h1 th:text="${message}"></h1>
      </body>
  </html>
  ```

---

## **10. Spring Boot Testing**

### **Unit Testing**
- Use **JUnit** and **Mockito** for unit testing.
  ```java
  @SpringBootTest
  public class MyServiceTest {
      @MockBean
      private UserRepository userRepository;

      @Autowired
      private MyService myService;

      @Test
      void testFindUser() {
          User user = myService.findUser(1L);
          assertNotNull(user);
      }
  }
  ```

---

## **11. Spring Boot Actuator**

### **Monitoring and Managing Spring Boot Apps**
- **Spring Boot Actuator** provides built-in endpoints for health checks, metrics, and application status.
  ```properties
  management.endpoints.web.exposure.include=health,metrics
  ```

### **Custom Endpoints**
- Create custom endpoints for your application’s health or other metrics.
  ```java


  @Endpoint(id = "custom")
  public class CustomEndpoint {
      @ReadOperation
      public String getCustomData() {
          return "Custom Data";
      }
  }
  ```

---

## **12. Spring Boot with Docker**

### **Dockerizing Spring Boot Apps**
- **Dockerfile** to create a containerized Spring Boot app.
  ```Dockerfile
  FROM openjdk:11-jre-slim
  COPY target/myapp.jar app.jar
  ENTRYPOINT ["java", "-jar", "app.jar"]
  ```

---

## **13. Spring Boot Performance Tuning**

### **Optimizing Spring Boot**
- Use **JVM tuning** and **garbage collection** optimizations to enhance performance.
  ```properties
  spring.datasource.hikari.maximum-pool-size=10
  ```

### **Caching**
- Use **Spring Cache** with **@Cacheable** and **@CacheEvict** for better performance.
  ```java
  @Cacheable("users")
  public List<User> findAll() {
      return userRepository.findAll();
  }
  ```

--------------------------------------------




Here’s a list of commonly asked **Spring Boot interview questions** with **easy explanations** to help you prepare for your interview. These questions cover the basics, annotations, configurations, security, and more.

---

## **1. What is Spring Boot?**

**Answer:**  
Spring Boot is a framework built on top of the **Spring Framework**. It simplifies the development of Java applications by providing **auto-configuration**, an **embedded server** (like Tomcat or Jetty), and **standalone applications**. It reduces the complexity of setting up Spring applications and is ideal for microservices.

---

## **2. What is the difference between Spring and Spring Boot?**

**Answer:**
- **Spring Framework**: Requires manual configuration of components using XML or Java config.
- **Spring Boot**: Provides **auto-configuration**, reducing the need for extensive setup. It also comes with an embedded server (e.g., Tomcat), so you don't need to deploy the application to a separate server.

---

## **3. What is the use of `@SpringBootApplication` annotation?**

**Answer:**  
`@SpringBootApplication` is a **composite annotation** that includes:
- **`@EnableAutoConfiguration`**: Tells Spring Boot to automatically configure the application based on dependencies.
- **`@ComponentScan`**: Enables component scanning for Spring beans.
- **`@Configuration`**: Marks the class as a configuration class.

This annotation is typically used in the main application class to launch the Spring Boot application.

---

## **4. How do you create a Spring Boot application?**

**Answer:**  
- Use **Spring Initializr** (https://start.spring.io/) to generate the project structure.
- Select the required dependencies (e.g., Spring Web, Spring Data JPA).
- Generate and unzip the project.
- Write your application code and run it using the **`@SpringBootApplication`** annotation.

---

## **5. What is the role of `@Autowired` annotation?**

**Answer:**  
`@Autowired` is used for **dependency injection** in Spring. It automatically injects the required bean into the class, either by field, constructor, or setter method.

Example:
```java
@Autowired
private UserRepository userRepository;
```

---

## **6. What is the purpose of `application.properties` in Spring Boot?**

**Answer:**  
The `application.properties` file is used for **external configuration** in Spring Boot applications. It stores properties such as database configurations, server ports, logging levels, and more.

Example:
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
```

---

## **7. What are the different types of Spring Boot profiles?**

**Answer:**  
Spring Boot allows the use of **profiles** to define different configurations for various environments (e.g., development, testing, production). Profiles are specified in the `application.properties` or `application.yml` file.

Example:
```properties
spring.profiles.active=dev
```

You can define specific beans or configurations for each profile using `@Profile` annotation.

---

## **8. What is `@RestController` in Spring Boot?**

**Answer:**  
`@RestController` is a **specialized version of `@Controller`** that is used to build RESTful web services. It combines `@Controller` and `@ResponseBody`, meaning the return value of methods is directly written to the HTTP response body.

Example:
```java
@RestController
public class UserController {
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
```

---

## **9. What is the purpose of `@RequestMapping`, `@GetMapping`, `@PostMapping` annotations?**

**Answer:**
- **`@RequestMapping`**: Maps HTTP requests to handler methods.
  Example:
  ```java
  @RequestMapping("/home")
  public String home() {
      return "Welcome";
  }
  ```

- **`@GetMapping`**, **`@PostMapping`**: Shortcuts for specific HTTP methods. 
  Example:
  ```java
  @GetMapping("/user")
  public User getUser(@RequestParam Long id) {
      return userRepository.findById(id);
  }
  ```

---

## **10. What is the role of `@Entity` and `@Id` in Spring Boot?**

**Answer:**  
- **`@Entity`**: Marks a class as a JPA entity (i.e., a database table).
- **`@Id`**: Denotes the primary key of the entity.

Example:
```java
@Entity
public class User {
    @Id
    private Long id;
    private String name;
}
```

---

## **11. What is Spring Boot Actuator?**

**Answer:**  
Spring Boot Actuator provides **production-ready features** like health checks, metrics, application status, and more. It exposes endpoints like `/actuator/health`, `/actuator/metrics`, which help monitor and manage the application.

Example:
```properties
management.endpoints.web.exposure.include=health,metrics
```

---

## **12. How do you handle exceptions in Spring Boot?**

**Answer:**  
In Spring Boot, exceptions can be handled globally using `@ControllerAdvice` and `@ExceptionHandler`. This provides a central place for exception handling.

Example:
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

---

## **13. What is `@Profile` in Spring Boot?**

**Answer:**  
The `@Profile` annotation is used to **define beans that are loaded only for specific profiles** (e.g., development, production).

Example:
```java
@Profile("dev")
@Bean
public DataSource devDataSource() {
    return new DataSource();
}
```

---

## **14. What is Spring Boot Security?**

**Answer:**  
Spring Boot Security provides **authentication and authorization** for web applications. It can be used to implement features like **form-based login**, **basic authentication**, and **JWT authentication**.

Example:
```java
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin();
    }
}
```

---

## **15. What is the difference between `@Controller` and `@RestController`?**

**Answer:**
- **`@Controller`**: Used for handling web requests and returning views (e.g., HTML pages).
- **`@RestController`**: Used for building REST APIs, and it automatically serializes the return value to JSON or XML.

---

## **16. How can we configure the database in Spring Boot?**

**Answer:**  
You can configure the database by setting properties in **`application.properties`** or **`application.yml`** for JDBC URL, username, password, and other parameters.

Example (for MySQL):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=secret
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

---

## **17. What is `@RequestParam` and `@PathVariable` in Spring Boot?**

**Answer:**
- **`@RequestParam`**: Used to extract query parameters from the URL.
  Example: `/user?id=1`
  ```java
  @GetMapping("/user")
  public User getUser(@RequestParam Long id) {
      return userRepository.findById(id);
  }
  ```

- **`@PathVariable`**: Used to extract variables from the URL path.
  Example: `/user/{id}`
  ```java
  @GetMapping("/user/{id}")
  public User getUser(@PathVariable Long id) {
      return userRepository.findById(id);
  }
  ```

---

## **18. How to run a Spring Boot application?**

**Answer:**  
- You can run a Spring Boot application using the following commands:
  - **From IDE**: Run the `main` method in the class annotated with `@SpringBootApplication`.
  - **Using Maven**: 
    ```bash
    mvn spring-boot:run
    ```
  - **Using Gradle**:
    ```bash
    gradle bootRun
    ```

---

## **19. What is Spring Boot’s embedded server?**

**Answer:**  
Spring Boot provides an **embedded server** (like **Tomcat**, **Jetty**, or **Undertow**) that allows you to run your application as a standalone JAR file without needing to deploy it to a separate server.

---

## **20. How do you create custom REST API responses in Spring Boot?**

**Answer:**  
You can use `ResponseEntity` to create custom responses, including custom HTTP status codes, headers, and bodies.

Example:
```java
@GetMapping("/user")
public ResponseEntity<User> getUser(@RequestParam Long id) {
    User user = userRepository.findById(id);
    if (user == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(user, HttpStatus.OK);
}
```

---------------------------------------------



