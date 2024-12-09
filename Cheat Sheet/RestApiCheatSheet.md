### **REST API Terminology Cheat Sheet for Full-Stack Java Developers**

Here is a complete cheat sheet explaining all key terminologies in RESTful APIs with their definitions, examples, and relevance to Java development.

---

### **1. REST (Representational State Transfer)**
**Definition:**  
An architectural style for designing networked applications. REST relies on stateless, client-server communication, typically over HTTP.

**Key Characteristics:**
- Stateless: No server-side session; every request contains all necessary information.
- Cacheable: Responses can be cached to improve performance.
- Uniform Interface: Resources are represented and accessed in a standard way (usually via URIs).

**Example:**  
`GET /api/users/1` retrieves user details with ID 1.

---

### **2. Resource**
**Definition:**  
A resource is an entity in the system exposed through the API (e.g., users, products).

**Representation:**  
Resources are represented in formats like JSON or XML.

**Example:**  
The `User` resource could be represented in JSON:
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

---

### **3. Endpoint**
**Definition:**  
A specific URL or URI where a resource can be accessed or manipulated.

**Example:**  
`GET /api/users` retrieves a list of users.  
`POST /api/users` creates a new user.

---

### **4. HTTP Methods**
**Definition:**  
Defines the type of action to perform on a resource.

| **Method**  | **Description**                   | **Example**                     |
|-------------|-----------------------------------|---------------------------------|
| `GET`       | Retrieve a resource (read-only).  | `GET /api/users`               |
| `POST`      | Create a new resource.            | `POST /api/users`              |
| `PUT`       | Update/replace a resource.        | `PUT /api/users/1`             |
| `PATCH`     | Partially update a resource.      | `PATCH /api/users/1`           |
| `DELETE`    | Delete a resource.                | `DELETE /api/users/1`          |

---

### **5. URI (Uniform Resource Identifier)**
**Definition:**  
A unique identifier for a resource in the REST API.

**Structure:**  
`http://example.com/api/{resource}/{id}`  
- **Base URI:** `http://example.com`
- **Path:** `/api/users/1`

---

### **6. Path Parameter**
**Definition:**  
A value embedded in the URL path to specify a resource.

**Example:**  
`/api/users/{id}`  
A request like `/api/users/1` retrieves the user with ID 1.

---

### **7. Query Parameter**
**Definition:**  
Used to filter or modify the response of a request.

**Example:**  
`GET /api/users?role=admin&page=2`  
This retrieves page 2 of users with the role "admin."

---

### **8. Payload**
**Definition:**  
The data sent in the body of the HTTP request or response.

**Example (Request Payload):**  
```json
POST /api/users
Content-Type: application/json

{
  "name": "Alice",
  "email": "alice@example.com"
}
```

---

### **9. Header**
**Definition:**  
Metadata sent with an HTTP request or response, such as content type, authorization, or caching information.

| **Header**              | **Description**                      | **Example**                      |
|-------------------------|--------------------------------------|----------------------------------|
| `Content-Type`          | Type of request/response body.       | `application/json`              |
| `Authorization`         | Authentication credentials.          | `Bearer <token>`                |
| `Accept`                | Expected response format.            | `application/json`              |

---

### **10. Status Code**
**Definition:**  
HTTP codes returned by the server to indicate the result of the request.

| **Code** | **Description**               | **Example Scenario**                              |
|----------|--------------------------------|--------------------------------------------------|
| `200`    | OK (Request successful).      | `GET /api/users` succeeds.                       |
| `201`    | Created.                       | `POST /api/users` creates a new user.            |
| `204`    | No Content.                   | `DELETE /api/users/1` deletes a user.            |
| `400`    | Bad Request.                  | Request contains invalid data.                   |
| `401`    | Unauthorized.                 | Authentication failed.                           |
| `403`    | Forbidden.                    | User does not have permission.                   |
| `404`    | Not Found.                    | Resource not found.                              |
| `500`    | Internal Server Error.        | Unexpected error occurred on the server.         |

---

### **11. Serialization/Deserialization**
**Definition:**  
- **Serialization:** Converting Java objects to JSON or XML (for responses).  
- **Deserialization:** Converting JSON or XML to Java objects (for requests).

**Example in Spring Boot (Using Jackson):**
```java
// JSON to Java Object
ObjectMapper mapper = new ObjectMapper();
User user = mapper.readValue(jsonString, User.class);

// Java Object to JSON
String json = mapper.writeValueAsString(user);
```

---

### **12. DTO (Data Transfer Object)**
**Definition:**  
A lightweight object that carries data between layers (e.g., from controller to service).

**Example DTO Class:**
```java
public class UserDTO {
    private String name;
    private String email;
    // Getters and Setters
}
```

---

### **13. ResponseEntity**
**Definition:**  
A Spring framework class to build HTTP responses with status codes, headers, and body.

**Example:**
```java
return ResponseEntity.ok(user); // 200 OK
return ResponseEntity.status(HttpStatus.CREATED).body(newUser); // 201 Created
```

---

### **14. CORS (Cross-Origin Resource Sharing)**
**Definition:**  
A security feature to allow or restrict API calls from different domains.

**Enable CORS in Spring Boot:**
```java
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
```

---

### **15. Authentication and Authorization**
**Definition:**  
- **Authentication:** Verifying user identity (e.g., username and password).
- **Authorization:** Granting access based on roles/permissions.

**Example in Spring Security:**
```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/api/admin/**").hasRole("ADMIN")
        .antMatchers("/api/users/**").authenticated()
        .and().httpBasic();
}
```

---

### **16. Idempotence**
**Definition:**  
An operation is idempotent if calling it multiple times results in the same outcome.

| **Method** | **Idempotent?** |
|------------|-----------------|
| `GET`      | Yes             |
| `PUT`      | Yes             |
| `DELETE`   | Yes             |
| `POST`     | No              |

---

### **17. Pagination**
**Definition:**  
Breaking large datasets into smaller chunks.

**Example Query Parameters:**  
`GET /api/users?page=1&size=10`

---

### **18. HATEOAS (Hypermedia as the Engine of Application State)**
**Definition:**  
An API design principle where responses include links to other actions/resources.

**Example:**
```json
{
  "id": 1,
  "name": "John Doe",
  "_links": {
    "self": { "href": "/api/users/1" },
    "orders": { "href": "/api/users/1/orders" }
  }
}
```

---

### **19. API Versioning**
**Definition:**  
A way to maintain multiple versions of the API for backward compatibility.

**Example:**
- URI Versioning: `/v1/users`, `/v2/users`
- Header Versioning: `Accept: application/vnd.api.v1+json`

---

### **20. Tools for REST API Development**
| **Tool**         | **Purpose**                     | **Example**                     |
|-------------------|---------------------------------|---------------------------------|
| **Postman**       | API testing and documentation. | Test CRUD operations.           |
| **Swagger/OpenAPI** | API documentation.            | Generate API docs in Spring Boot. |
| **cURL**          | Command-line API testing.      | `curl -X GET http://localhost` |

---------------------------------------------

Here's a **RESTful API cheatsheet** specifically designed for **Full Stack Java Developers**. It covers key concepts, code snippets, HTTP methods, best practices, and tools.

---

### **1. HTTP Methods Overview**
| HTTP Method | Purpose                       | Example                         |
|-------------|-------------------------------|---------------------------------|
| `GET`       | Retrieve data (read-only)     | `GET /api/users`               |
| `POST`      | Create a new resource         | `POST /api/users`              |
| `PUT`       | Update/replace a resource     | `PUT /api/users/{id}`          |
| `PATCH`     | Update partially a resource   | `PATCH /api/users/{id}`        |
| `DELETE`    | Delete a resource             | `DELETE /api/users/{id}`       |

---

### **2. REST API Design Best Practices**
1. **Use Nouns for Resource Names**  
   Example: `/users` instead of `/getUsers`.
   
2. **Use Plural Names for Resources**  
   Example: `/users` instead of `/user`.

3. **Use HTTP Status Codes**  
   - `200 OK`: Success
   - `201 Created`: Resource created
   - `204 No Content`: Success with no response body
   - `400 Bad Request`: Invalid request
   - `401 Unauthorized`: Authentication failed
   - `404 Not Found`: Resource not found
   - `500 Internal Server Error`: Server error

4. **Use Path Variables and Query Parameters**  
   - **Path Variables** for identifying resources: `/users/{id}`
   - **Query Parameters** for filtering/sorting: `/users?role=admin`

5. **Paginate Large Responses**  
   Example: `/users?page=1&size=10`

---

### **3. RESTful API in Spring Boot**

#### **Basic Setup**
1. **Add Dependencies (`pom.xml`):**
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   ```

2. **Create a REST Controller:**
   ```java
   @RestController
   @RequestMapping("/api/users")
   public class UserController {
       @GetMapping
       public List<User> getAllUsers() {
           return List.of(new User(1, "Alice"), new User(2, "Bob"));
       }

       @PostMapping
       public ResponseEntity<User> createUser(@RequestBody User user) {
           return ResponseEntity.status(HttpStatus.CREATED).body(user);
       }

       @PutMapping("/{id}")
       public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
           user.setId(id);
           return ResponseEntity.ok(user);
       }

       @DeleteMapping("/{id}")
       public ResponseEntity<Void> deleteUser(@PathVariable int id) {
           return ResponseEntity.noContent().build();
       }
   }
   ```

3. **Define the User Model:**
   ```java
   public class User {
       private int id;
       private String name;

       public User(int id, String name) {
           this.id = id;
           this.name = name;
       }

       // Getters and Setters
   }
   ```

---

### **4. HTTP Status Code in Spring Boot**
Use `ResponseEntity` to control HTTP status codes:
```java
return ResponseEntity.status(HttpStatus.CREATED).body(resource); // 201 Created
return ResponseEntity.noContent().build(); // 204 No Content
return ResponseEntity.badRequest().build(); // 400 Bad Request
```

---

### **5. CRUD Example with JPA**

#### **Add Dependencies (`pom.xml`)**:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

#### **Create the Repository:**
```java
public interface UserRepository extends JpaRepository<User, Integer> {}
```

#### **Modify the Controller:**
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    return ResponseEntity.ok(userRepository.save(existingUser));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
```

---

### **6. Tools and Utilities**
1. **Testing REST APIs:**
   - **Postman:** Manual API testing.
   - **cURL:** Command-line API testing.

   Example:
   ```bash
   curl -X POST -H "Content-Type: application/json" \
       -d '{"name":"Alice"}' http://localhost:8080/api/users
   ```

2. **Database Tools:**
   - H2 Console: `http://localhost:8080/h2-console`
   - MySQL Workbench for MySQL databases.

3. **Swagger Documentation:**
   Add `springdoc-openapi-ui` for API documentation:
   ```xml
   <dependency>
       <groupId>org.springdoc</groupId>
       <artifactId>springdoc-openapi-ui</artifactId>
       <version>1.6.15</version>
   </dependency>
   ```
   Access Swagger UI at `http://localhost:8080/swagger-ui.html`.

---

### **7. Security in REST APIs**
1. Use **Spring Security** for Authentication and Authorization:
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-security</artifactId>
   </dependency>
   ```

2. **Basic Authentication Example:**
   Add a simple in-memory user in `SecurityConfig`:
   ```java
   @Configuration
   public class SecurityConfig extends WebSecurityConfigurerAdapter {
       @Override
       protected void configure(AuthenticationManagerBuilder auth) throws Exception {
           auth.inMemoryAuthentication()
               .withUser("user").password("{noop}password").roles("USER");
       }

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http.authorizeRequests()
               .antMatchers("/api/**").authenticated()
               .and().httpBasic();
       }
   }
   ```

3. Use JWT for token-based authentication (advanced).

---

### **8. Front-End Integration**
1. **React/Angular/JavaScript Example:**
   Use `fetch` or `axios` to call REST APIs.
   ```javascript
   fetch('http://localhost:8080/api/users')
       .then(response => response.json())
       .then(data => console.log(data));
   ```

2. **CORS Configuration for API:**
   Enable CORS for APIs in Spring Boot:
   ```java
   @Configuration
   public class CorsConfig {
       @Bean
       public WebMvcConfigurer corsConfigurer() {
           return new WebMvcConfigurer() {
               @Override
               public void addCorsMappings(CorsRegistry registry) {
                   registry.addMapping("/**").allowedOrigins("http://localhost:3000");
               }
           };
       }
   }
   ```

---

### **9. Error Handling**
Use `@ControllerAdvice` for centralized error handling:
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
```

---

### **10. Deployment**
1. **Jar Packaging:**
   Run `mvn clean package` to create an executable JAR file.
2. **Run with Command Line:**
   ```bash
   java -jar target/your-app.jar
   ```
3. **Deploy to Tomcat:**  
   Package the project as a WAR file and deploy it to a servlet container like Tomcat.

---

This cheatsheet covers the core aspects of RESTful APIs for full-stack Java developers. Let me know if you’d like more details on any section!


--------------------------------------------



Here’s a **comprehensive list of REST API interview questions with answers**, categorized by difficulty. 

---

### **Basic Questions**

#### **1. What is REST?**
**Answer:**  
REST (Representational State Transfer) is an architectural style for designing networked applications. It relies on stateless, client-server communication and uses HTTP for communication.  
**Principles of REST:**  
- Statelessness  
- Client-Server architecture  
- Uniform Interface  
- Cacheable  
- Layered System  

---

#### **2. What are HTTP methods? Provide examples.**
**Answer:**  
HTTP methods define the type of action performed on a resource. Common methods:  
- **GET:** Retrieve data (e.g., `GET /api/users`)  
- **POST:** Create a resource (e.g., `POST /api/users`)  
- **PUT:** Update/replace a resource (e.g., `PUT /api/users/1`)  
- **PATCH:** Partially update a resource (e.g., `PATCH /api/users/1`)  
- **DELETE:** Remove a resource (e.g., `DELETE /api/users/1`)

---

#### **3. What is a Resource in REST?**
**Answer:**  
A resource represents any entity exposed via the API (e.g., users, products). It is identified by a unique URI.  
**Example:**  
`/api/users/1` identifies the user with ID 1.

---

#### **4. What is the difference between URI and URL?**
**Answer:**  
- **URI (Uniform Resource Identifier):** Identifies a resource.  
- **URL (Uniform Resource Locator):** A type of URI that includes the protocol to locate the resource.  
**Example:**  
`URI:` `/api/users/1`  
`URL:` `http://example.com/api/users/1`

---

#### **5. Explain the purpose of HTTP status codes in REST APIs.**
**Answer:**  
HTTP status codes indicate the result of the client's request.  
| **Code** | **Meaning**                  | **Example**                              |
|----------|------------------------------|------------------------------------------|
| `200`    | OK (Request successful)      | `GET /api/users`                         |
| `201`    | Created (Resource created)   | `POST /api/users`                        |
| `400`    | Bad Request                  | Invalid input in request                 |
| `401`    | Unauthorized                 | Authentication failed                    |
| `404`    | Not Found                    | Resource does not exist                  |
| `500`    | Internal Server Error        | Server-side error                        |

---

#### **6. What are Path Parameters and Query Parameters?**
**Answer:**  
- **Path Parameters:** Part of the URI, used to identify a specific resource.  
  **Example:** `/api/users/{id}` → `/api/users/1`
- **Query Parameters:** Appended to the URI to filter or modify the response.  
  **Example:** `/api/users?role=admin&page=1`

---

#### **7. What is idempotence? Which HTTP methods are idempotent?**
**Answer:**  
Idempotence means multiple identical requests have the same effect as a single request.  
**Idempotent Methods:** `GET`, `PUT`, `DELETE`, `OPTIONS`  
**Non-idempotent Method:** `POST`

---

#### **8. What is the difference between `PUT` and `PATCH`?**
**Answer:**  
- **PUT:** Updates/replaces the entire resource.  
- **PATCH:** Updates specific fields of a resource.  
**Example:**  
For a resource:
```json
{ "name": "Alice", "age": 25 }
```
- `PUT /api/users/1` with `{ "name": "Bob", "age": 30 }` replaces the entire resource.
- `PATCH /api/users/1` with `{ "age": 30 }` only updates the age.

---

#### **9. What is `Content-Type` in HTTP headers?**
**Answer:**  
`Content-Type` specifies the format of the data sent in the request or expected in the response.  
**Examples:**  
- `application/json` for JSON data  
- `application/xml` for XML data  

---

#### **10. What is the difference between Stateless and Stateful APIs?**
**Answer:**  
- **Stateless APIs:** Each request is independent and contains all necessary information. REST APIs are stateless.  
- **Stateful APIs:** Maintain client information between requests (e.g., session data).

---

### **Intermediate Questions**

#### **11. What is the difference between SOAP and REST?**
**Answer:**  
| **Feature**        | **SOAP**                        | **REST**                     |
|---------------------|----------------------------------|------------------------------|
| Protocol            | Strict protocol (SOAP/XML)      | Architectural style (HTTP)   |
| Format              | XML only                        | JSON, XML, YAML, etc.        |
| Simplicity          | Complex                         | Simple                       |
| Performance         | Slower                          | Faster                       |

---

#### **12. How does REST handle versioning?**
**Answer:**  
Common methods of API versioning:  
1. **URI versioning:** `/v1/users`, `/v2/users`  
2. **Query parameter versioning:** `/users?version=1`  
3. **Header versioning:** `Accept: application/vnd.api.v1+json`

---

#### **13. What are Response Codes for Successful Operations?**
**Answer:**  
- **200 OK:** Request succeeded.  
- **201 Created:** Resource successfully created.  
- **204 No Content:** Request succeeded, but no content is returned.

---

#### **14. What is HATEOAS?**
**Answer:**  
Hypermedia as the Engine of Application State. Responses include links to related actions/resources.  
**Example:**
```json
{
  "id": 1,
  "name": "John",
  "_links": {
    "self": { "href": "/api/users/1" },
    "orders": { "href": "/api/users/1/orders" }
  }
}
```

---

### **Advanced Questions**

#### **15. What is CORS? How do you handle it?**
**Answer:**  
CORS (Cross-Origin Resource Sharing) allows web apps from one domain to access resources on another domain.  
**Example in Spring Boot:**
```java
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
```

---

#### **16. What is the purpose of `ResponseEntity` in Spring?**
**Answer:**  
`ResponseEntity` is a Spring class used to represent HTTP responses with headers, status codes, and body.  
**Example:**
```java
ResponseEntity<User> response = ResponseEntity.status(HttpStatus.CREATED).body(user);
```

---

#### **17. How do you secure REST APIs?**
**Answer:**  
1. **Authentication:** Use OAuth2, JWT, or API keys.  
2. **Authorization:** Role-based access control.  
3. **HTTPS:** Encrypt data in transit.  
4. **Input Validation:** Prevent injection attacks.  
5. **CORS Policies:** Restrict domains allowed to access the API.  

---

#### **18. What is the difference between `Monolithic` and `Microservices` architectures?**
**Answer:**  
- **Monolithic:** Single, large application.  
- **Microservices:** Decoupled, independent services communicating via REST APIs.  

---

#### **19. Explain how pagination works in REST APIs.**
**Answer:**  
Pagination breaks large data into smaller chunks using query parameters.  
**Example:**  
`GET /api/users?page=2&size=10` retrieves the second page with 10 users per page.

---

#### **20. What is the role of API Gateway in Microservices?**
**Answer:**  
An API Gateway acts as an entry point for client requests, handling routing, load balancing, authentication, and monitoring.

---

These questions will give you a well-rounded understanding of REST APIs for interviews. Let me know if you’d like to explore any in-depth!
