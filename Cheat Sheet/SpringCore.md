Here’s a **Spring Core cheatsheet** that covers essential concepts, definitions, and code examples for Spring Framework Core, organized in an easy-to-follow structure. 

---

## **1. What is Spring Core?**
Spring Core is the foundational module of the Spring Framework that provides features like dependency injection (DI) and inversion of control (IoC) for developing loosely coupled, scalable, and maintainable Java applications.

---

## **2. Core Spring Features**

| **Feature**              | **Definition**                                                                                   | **Code Example**                                                                                                 |
|---------------------------|---------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| **Inversion of Control**  | IoC allows objects to delegate the responsibility of managing their dependencies to the container.| Objects are created and managed by the Spring IoC container.                                                   |
| **Dependency Injection**  | A design pattern that lets you inject dependencies into objects rather than objects managing them.| Inject beans via constructor or setter injection.                                                              |
| **Bean Lifecycle**        | A bean's lifecycle defines its initialization, use, and destruction within the container.        | Customize using `@PostConstruct`, `@PreDestroy`, or implement `InitializingBean` and `DisposableBean`.         |
| **ApplicationContext**    | The central interface in Spring for configuring and managing beans.                             | Use `AnnotationConfigApplicationContext` or `ClassPathXmlApplicationContext` for initializing Spring beans.    |

---

## **3. Spring Core Annotations**

| **Annotation**           | **Purpose**                                                                                      | **Example**                                                                                                     |
|---------------------------|--------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| `@Component`              | Marks a class as a Spring-managed component.                                                    | `@Component public class MyService {}`                                                                          |
| `@Service`                | Specialized `@Component` for service layer classes.                                              | `@Service public class UserService {}`                                                                          |
| `@Repository`             | Specialized `@Component` for DAO classes, enables exception translation.                        | `@Repository public class UserDao {}`                                                                           |
| `@Configuration`          | Marks a class for defining Spring bean configurations.                                           | `@Configuration public class AppConfig {}`                                                                      |
| `@Bean`                   | Declares a bean managed by the Spring container.                                                 | `@Bean public MyBean myBean() { return new MyBean(); }`                                                         |
| `@Autowired`              | Injects a dependency automatically.                                                             | `@Autowired private MyBean myBean;`                                                                             |
| `@Qualifier`              | Specifies which bean to inject when multiple beans of the same type exist.                      | `@Autowired @Qualifier("beanName") private MyBean myBean;`                                                      |
| `@Scope`                  | Defines the scope of a bean (`singleton`, `prototype`, etc.).                                    | `@Scope("prototype")`                                                                                           |
| `@PostConstruct`          | Marks a method to be executed after bean initialization.                                         | `@PostConstruct public void init() { }`                                                                         |
| `@PreDestroy`             | Marks a method to be executed before bean destruction.                                           | `@PreDestroy public void cleanup() { }`                                                                         |

---

## **4. Bean Configuration**

### **XML-Based Configuration**
```xml
<beans xmlns="http://www.springframework.org/schema/beans">
    <bean id="myBean" class="com.example.MyBean"/>
</beans>
```

### **Java-Based Configuration**
```java
@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

### **Annotation-Based Configuration**
```java
@Component
public class MyBean { }
```

---

## **5. Dependency Injection**

### **1. Constructor Injection**
```java
@Component
public class MyService {
    private final MyRepository repository;

    @Autowired
    public MyService(MyRepository repository) {
        this.repository = repository;
    }
}
```

### **2. Setter Injection**
```java
@Component
public class MyService {
    private MyRepository repository;

    @Autowired
    public void setRepository(MyRepository repository) {
        this.repository = repository;
    }
}
```

### **3. Field Injection**
```java
@Component
public class MyService {
    @Autowired
    private MyRepository repository;
}
```

---

## **6. Bean Scopes**

| **Scope**      | **Description**                                           | **Example**                           |
|-----------------|-----------------------------------------------------------|---------------------------------------|
| `singleton`    | Single instance per Spring container (default).            | `@Scope("singleton")`                 |
| `prototype`    | Creates a new instance for each request.                   | `@Scope("prototype")`                 |
| `request`      | Scoped to an HTTP request (Web applications).              | `@Scope("request")`                   |
| `session`      | Scoped to an HTTP session (Web applications).              | `@Scope("session")`                   |
| `application`  | Scoped to the application lifecycle.                       | `@Scope("application")`               |

---

## **7. Lifecycle Methods**

### Using `@PostConstruct` and `@PreDestroy`:
```java
@Component
public class MyBean {
    @PostConstruct
    public void init() {
        System.out.println("Bean initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean destroyed");
    }
}
```

### Using Interfaces:
```java
public class MyBean implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() {
        System.out.println("Bean initialized");
    }

    @Override
    public void destroy() {
        System.out.println("Bean destroyed");
    }
}
```

---

## **8. Spring Core Interfaces**

| **Interface**                | **Description**                                                                 |
|-------------------------------|---------------------------------------------------------------------------------|
| `ApplicationContext`          | The central interface for Spring container.                                    |
| `BeanFactory`                 | A basic container for managing beans.                                          |
| `InitializingBean`            | Provides a lifecycle callback method after bean initialization.                |
| `DisposableBean`              | Provides a lifecycle callback method before bean destruction.                  |
| `ApplicationEventPublisher`   | Used for publishing events within the application.                             |

---

## **9. Event Handling in Spring**

### Custom Event:
```java
public class CustomEvent extends ApplicationEvent {
    public CustomEvent(Object source) {
        super(source);
    }
}
```

### Listener for the Event:
```java
@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Custom event received");
    }
}
```

### Publishing the Event:
```java
@Component
public class EventPublisher {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void publishEvent() {
        publisher.publishEvent(new CustomEvent(this));
    }
}
```

---

## **10. Core Concepts of Spring AOP**

| **Term**             | **Description**                                                                         |
|-----------------------|-----------------------------------------------------------------------------------------|
| **Aspect**           | A modularization of a concern that cuts across multiple classes.                        |
| **Join Point**       | A point during program execution (e.g., method execution).                              |
| **Advice**           | Action taken by an aspect at a join point (e.g., `@Before`, `@After`).                  |
| **Pointcut**         | Defines when advice should be applied.                                                  |
| **Weaving**          | Linking aspects with other application code.                                            |

**AOP Example:**
```java
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.MyService.*(..))")
    public void logBefore() {
        System.out.println("Executing before method");
    }
}
```

-------------------------------------------


Here’s a comprehensive list of **Spring Core interview questions with answers** to help you prepare effectively:

---

### **Basic Spring Core Questions**

#### 1. **What is Spring Framework?**
**Answer:**  
Spring is a powerful, lightweight, and open-source framework for Java development. It provides comprehensive infrastructure support for building Java applications and promotes practices like Dependency Injection (DI) and Aspect-Oriented Programming (AOP) for creating loosely coupled, scalable, and maintainable applications.

---

#### 2. **What are the core concepts of the Spring Framework?**
**Answer:**  
The core concepts include:
1. **Inversion of Control (IoC):** The container controls object creation and their dependencies.
2. **Dependency Injection (DI):** Dependencies are injected into objects instead of being created by them.
3. **Aspect-Oriented Programming (AOP):** Allows separation of cross-cutting concerns (e.g., logging, security).
4. **ApplicationContext:** The central interface for configuring and managing beans.

---

#### 3. **What is Dependency Injection? How is it implemented in Spring?**
**Answer:**  
Dependency Injection (DI) is a design pattern where the container injects dependencies into a class at runtime. In Spring, DI is implemented in two ways:
1. **Constructor Injection:**
   ```java
   @Component
   public class MyService {
       private final MyRepository repository;

       @Autowired
       public MyService(MyRepository repository) {
           this.repository = repository;
       }
   }
   ```
2. **Setter Injection:**
   ```java
   @Component
   public class MyService {
       private MyRepository repository;

       @Autowired
       public void setRepository(MyRepository repository) {
           this.repository = repository;
       }
   }
   ```

---

#### 4. **What are Spring beans?**
**Answer:**  
Spring beans are objects managed by the Spring IoC container. They are instantiated, configured, and managed entirely by Spring.

---

#### 5. **What are the scopes of Spring beans?**
**Answer:**  
Spring supports five main bean scopes:
1. **Singleton (Default):** A single instance per Spring container.
2. **Prototype:** A new instance for each request.
3. **Request:** A single instance for an HTTP request (web applications).
4. **Session:** A single instance for an HTTP session (web applications).
5. **Application:** A single instance for the lifecycle of a ServletContext.

Example:
```java
@Scope("prototype")
@Bean
public MyBean myBean() {
    return new MyBean();
}
```

---

### **Intermediate Spring Core Questions**

#### 6. **What is the difference between `BeanFactory` and `ApplicationContext`?**
**Answer:**
| **Feature**             | **BeanFactory**                            | **ApplicationContext**                        |
|--------------------------|--------------------------------------------|-----------------------------------------------|
| **Scope**               | Lightweight and basic                      | More advanced and feature-rich                |
| **Eager Initialization**| Lazy initializes singleton beans           | Eagerly initializes singleton beans           |
| **Internationalization**| Not supported                              | Supported                                     |
| **Event Propagation**   | Not supported                              | Supported                                     |

---

#### 7. **What is the role of the `@Component` annotation?**
**Answer:**  
`@Component` is a stereotype annotation that marks a class as a Spring-managed component. Spring automatically detects and registers it as a bean during component scanning.

Example:
```java
@Component
public class MyService { }
```

---

#### 8. **What is the purpose of `@Configuration` and `@Bean` annotations?**
**Answer:**  
- `@Configuration`: Marks a class as a source of bean definitions.
- `@Bean`: Declares a method that returns a Spring bean to be managed by the IoC container.

Example:
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```

---

#### 9. **What is the Spring IoC container?**
**Answer:**  
The IoC container is the core of Spring, responsible for managing the lifecycle and dependencies of beans. There are two main types of IoC containers:
1. **BeanFactory**: Basic container.
2. **ApplicationContext**: Advanced container with additional features like event propagation and internationalization.

---

#### 10. **What are Spring Profiles?**
**Answer:**  
Spring Profiles allow you to define different configurations for different environments (e.g., dev, test, prod). You can activate a profile using the `spring.profiles.active` property.

Example:
```java
@Configuration
@Profile("dev")
public class DevConfig {
    @Bean
    public MyBean devBean() {
        return new MyBean("Development");
    }
}
```

---

### **Advanced Spring Core Questions**

#### 11. **Explain the Spring bean lifecycle.**
**Answer:**  
1. Instantiate: The container instantiates the bean.
2. Populate Properties: Dependencies are injected.
3. Initialization: Callbacks like `@PostConstruct` or `afterPropertiesSet()` are executed.
4. Ready for Use: The bean is ready for use.
5. Destruction: Callbacks like `@PreDestroy` or `destroy()` are executed before the container shuts down.

---

#### 12. **What is Aspect-Oriented Programming (AOP) in Spring?**
**Answer:**  
AOP separates cross-cutting concerns (like logging, security) from the main business logic. In Spring, AOP is implemented using aspects, advices, join points, and pointcuts.

Example:
```java
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore() {
        System.out.println("Logging before method execution");
    }
}
```

---

#### 13. **What are the differences between `@Component`, `@Repository`, `@Service`, and `@Controller`?**
**Answer:**  
All are specialization of `@Component`:
1. `@Component`: Generic component.
2. `@Repository`: For data access objects; enables exception translation.
3. `@Service`: For service layer classes.
4. `@Controller`: For MVC controllers.

---

#### 14. **What is `@Qualifier`?**
**Answer:**  
`@Qualifier` is used to resolve ambiguity when multiple beans of the same type exist.

Example:
```java
@Autowired
@Qualifier("specificBean")
private MyBean myBean;
```

---

#### 15. **How does Spring handle transactions?**
**Answer:**  
Spring provides declarative transaction management using `@Transactional`. It ensures ACID properties.

Example:
```java
@Transactional
public void processOrder() {
    // transactional code here
}
```

---

### **Practical and Scenario-Based Questions**

#### 16. **How would you create a custom event in Spring?**
**Answer:**  
1. Define the event class:
   ```java
   public class CustomEvent extends ApplicationEvent {
       public CustomEvent(Object source) {
           super(source);
       }
   }
   ```
2. Publish the event:
   ```java
   @Component
   public class EventPublisher {
       @Autowired
       private ApplicationEventPublisher publisher;

       public void publish() {
           publisher.publishEvent(new CustomEvent(this));
       }
   }
   ```
3. Create an event listener:
   ```java
   @Component
   public class CustomEventListener implements ApplicationListener<CustomEvent> {
       @Override
       public void onApplicationEvent(CustomEvent event) {
           System.out.println("Event received: " + event);
       }
   }
   ```

---

#### 17. **What are some common Spring exceptions?**
**Answer:**
1. `BeanCreationException`: Issues during bean instantiation.
2. `NoSuchBeanDefinitionException`: Requested bean is not found.
3. `UnsatisfiedDependencyException`: Missing required dependency.
4. `BeanCurrentlyInCreationException`: Circular dependencies.

----------------------------------------