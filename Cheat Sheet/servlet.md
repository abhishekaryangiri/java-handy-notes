# Servlet Complete Interview Revision Notes

# 1. Servlet Introduction

## What is Servlet?

Servlet is a Java technology used to create dynamic web applications.

Servlet runs on server side and handles:

* Client requests
* Business logic
* Database communication
* Dynamic response generation

---

## Simple Definition

"Servlet is a server-side Java program that handles HTTP requests and generates dynamic responses."

---

## Why Servlet is Used?

Before Servlets:

* CGI was used
* Slow performance
* New process created for every request

Servlet advantages:

* Fast
* Platform independent
* Reusable
* Better performance
* Uses multithreading

---

## Real-Time Examples

* Login System
* Registration System
* Banking Application
* E-commerce Website
* Employee Management System

---

## Interview Question

### What is Servlet?

Servlet is a server-side Java component used to handle client requests and generate dynamic web responses.

---

# 2. Web Application Basics

## What is Web Application?

A web application is software accessed through browser.

Examples:

* Facebook
* Amazon
* Flipkart
* Gmail

---

## Components of Web Application

```text
Frontend:
- HTML
- CSS
- JavaScript

Backend:
- Servlet
- JSP
- Spring Boot

Database:
- MySQL
- PostgreSQL
```

---

## Web Application Flow

```text
Browser -> Server -> Database -> Server -> Browser
```

---

## Interview Answer

Web application is an application that runs on server and is accessed through browser using HTTP protocol.

---

# 3. Client Server Architecture

## What is Client?

Client sends request.

Examples:

* Browser
* Mobile App

---

## What is Server?

Server processes request and sends response.

---

## Architecture Flow

```text
Client (Browser)
      |
      | HTTP Request
      v
Server (Tomcat)
      |
      v
Servlet
      |
      v
Database
      |
      v
Response
```

---

## Interview Question

### Explain Client Server Architecture.

Client sends request to server. Server processes request, communicates with database if needed, and sends response back to client.

---

# 4. HTTP Protocol

## What is HTTP?

HTTP = HyperText Transfer Protocol.

Used for communication between browser and server.

---

## Features

* Stateless protocol
* Request-response based
* Application layer protocol

---

## Common HTTP Methods

| Method | Purpose     |
| ------ | ----------- |
| GET    | Fetch data  |
| POST   | Send data   |
| PUT    | Update data |
| DELETE | Delete data |

---

## Interview Question

### Why HTTP is called stateless?

Because server does not remember previous request information automatically.

---

# 5. HTTP Request & Response

# HTTP Request

Sent by browser to server.

Contains:

* URL
* Method
* Headers
* Parameters

---

# HTTP Response

Sent by server to browser.

Contains:

* Status code
* HTML data
* Headers

---

## Common Status Codes

| Code | Meaning      |
| ---- | ------------ |
| 200  | Success      |
| 404  | Not Found    |
| 500  | Server Error |

---

## Interview Answer

Client sends HTTP request and server sends HTTP response.

---

# 6. Web Server vs Application Server

| Web Server             | Application Server      |
| ---------------------- | ----------------------- |
| Handles static content | Handles dynamic content |
| HTML CSS JS            | Servlet JSP EJB         |
| Example: Apache HTTP   | Example: Tomcat         |

---

## Important Point

Tomcat works as both:

* Web Server
* Application Server

---

## Interview Question

### Difference between Web Server and Application Server?

Web server handles static resources while application server handles business logic and dynamic content.

---

# 7. Apache Tomcat

## What is Tomcat?

Apache Tomcat is a Servlet Container/Application Server.

Used to run:

* Servlet
* JSP

---

## Responsibilities

* Receives request
* Creates servlet object
* Manages lifecycle
* Sends response

---

## Internal Flow

```text
Browser -> Tomcat -> Servlet -> Database -> Response
```

---

## Interview Question

### What is Tomcat?

Tomcat is an open-source application server used to run Java web applications.

---

# 8. Servlet API

## What is Servlet API?

Servlet API provides interfaces and classes for servlet development.

Package:

```java
javax.servlet
javax.servlet.http
```

---

## Important Classes & Interfaces

| Name                | Purpose                      |
| ------------------- | ---------------------------- |
| Servlet             | Base interface               |
| GenericServlet      | Protocol independent servlet |
| HttpServlet         | HTTP specific servlet        |
| HttpServletRequest  | Request object               |
| HttpServletResponse | Response object              |

---

# 9. Servlet Lifecycle

## Servlet Lifecycle Methods

```text
1. init()
2. service()
3. destroy()
```

---

## Lifecycle Flow

```text
Servlet Loading
      |
      v
init() -> called once
      |
      v
service() -> called for every request
      |
      v
destroy() -> called once before unloading
```

---

## Interview Question

### Explain Servlet Lifecycle.

Servlet lifecycle consists of init(), service(), and destroy() methods managed by servlet container.

---

# 10. init()

## Purpose

Used for initialization.

Called only once.

---

## Example

```java
public void init() {
    System.out.println("Servlet Initialized");
}
```

---

## Use Cases

* DB connection setup
* Resource initialization
* Configuration loading

---

## Interview Answer

init() method is called once when servlet object is created.

---

# 11. service()

## Purpose

Handles client requests.

Called for every request.

---

## Example

```java
public void service(
    ServletRequest req,
    ServletResponse res
) {

}
```

---

## Important Point

In HttpServlet, service() internally calls:

* doGet()
* doPost()

---

## Interview Answer

service() method processes every client request.

---

# 12. destroy()

## Purpose

Used for cleanup.

Called once before servlet removal.

---

## Example

```java
public void destroy() {
    System.out.println("Servlet Destroyed");
}
```

---

## Use Cases

* Closing DB connection
* Releasing resources

---

## Interview Answer

destroy() method is called once before servlet object destruction.

---

# 13. GenericServlet

## What is GenericServlet?

GenericServlet is an abstract class.

Provides protocol-independent servlet.

---

## Important Point

* Uses service() method
* Not HTTP specific

---

## Example

```java
public class DemoServlet extends GenericServlet {

    public void service(
        ServletRequest req,
        ServletResponse res
    ) {

    }
}
```

---

## Interview Answer

GenericServlet is protocol independent abstract class implementing Servlet interface.

---

# 14. HttpServlet

## What is HttpServlet?

HttpServlet is HTTP protocol specific servlet.

Most commonly used servlet class.

---

## Methods

* doGet()
* doPost()
* doPut()
* doDelete()

---

## Example

```java
public class MyServlet extends HttpServlet {

}
```

---

## Interview Answer

HttpServlet is used for handling HTTP requests in web applications.

---

# 15. doGet()

## Purpose

Handles GET request.

Used mainly for:

* Fetching data
* Searching
* Reading information

---

## Example

```java
protected void doGet(
    HttpServletRequest req,
    HttpServletResponse res
) {

}
```

---

## Important Point

GET data visible in URL.

---

## Interview Question

### When do we use doGet()?

Used for reading/fetching data.

---

# 16. doPost()

## Purpose

Handles POST request.

Used for:

* Form submission
* Sensitive data
* Insert operations

---

## Example

```java
protected void doPost(
    HttpServletRequest req,
    HttpServletResponse res
) {

}
```

---

## Important Point

POST data not visible in URL.

---

## Interview Question

### Difference between GET and POST?

| GET                 | POST            |
| ------------------- | --------------- |
| Data visible in URL | Data hidden     |
| Limited data        | Large data      |
| Less secure         | More secure     |
| Used for fetch      | Used for submit |

---

# 17. Deployment Descriptor (web.xml)

## What is web.xml?

Configuration file of web application.

Used for:

* Servlet mapping
* Welcome file
* Initialization parameters

---

## Example

```xml
<web-app>

    <servlet>
        <servlet-name>demo</servlet-name>
        <servlet-class>com.test.DemoServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>demo</servlet-name>
        <url-pattern>/demo</url-pattern>
    </servlet-mapping>

</web-app>
```

---

## Interview Answer

web.xml is deployment descriptor used for servlet configuration and mapping.

---

# 18. Servlet Annotation (@WebServlet)

## What is @WebServlet?

Annotation-based servlet configuration.

Removes need of web.xml.

---

## Example

```java
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

}
```

---

## Advantages

* Less XML
* Cleaner code
* Easy configuration

---

## Interview Question

### Which is better: web.xml or annotation?

Annotation is simpler and modern approach.

---

# 19. Servlet Configuration

Servlet configuration means providing initialization parameters.

Two types:

* ServletConfig
* ServletContext

---

# 20. ServletConfig

## What is ServletConfig?

Stores servlet-specific configuration.

Each servlet has separate ServletConfig object.

---

## Example

```xml
<init-param>
    <param-name>username</param-name>
    <param-value>admin</param-value>
</init-param>
```

---

## Accessing Parameter

```java
String name = getServletConfig()
                .getInitParameter("username");
```

---

## Interview Answer

ServletConfig stores servlet-specific initialization parameters.

---

# 21. ServletContext

## What is ServletContext?

ServletContext stores application-wide data.

Shared among all servlets.

---

## Example

```java
ServletContext context = getServletContext();
```

---

## Uses

* Sharing global data
* Reading application parameters

---

## Interview Question

### Difference between ServletConfig and ServletContext?

| ServletConfig | ServletContext     |
| ------------- | ------------------ |
| Per servlet   | Entire application |
| Local data    | Global data        |

---

# 22. Request Object

## What is HttpServletRequest?

Represents client request.

Used to:

* Read form data
* Read headers
* Read parameters

---

## Example

```java
String name = req.getParameter("username");
```

---

## Common Methods

```java
getParameter()
getHeader()
getAttribute()
```

---

## Interview Answer

HttpServletRequest stores client request data.

---

# 23. Response Object

## What is HttpServletResponse?

Represents server response.

Used to send response to browser.

---

## Example

```java
PrintWriter out = res.getWriter();
out.println("Welcome");
```

---

## Common Methods

```java
sendRedirect()
setContentType()
getWriter()
```

---

## Interview Answer

HttpServletResponse is used to send response back to client.

---

# 24. RequestDispatcher

## What is RequestDispatcher?

Used for request forwarding.

---

## Example

```java
RequestDispatcher rd =
req.getRequestDispatcher("home.jsp");

rd.forward(req, res);
```

---

## Methods

```java
forward()
include()
```

---

## Interview Answer

RequestDispatcher is used to transfer request from one resource to another.

---

# 25. forward() vs sendRedirect()

| forward()     | sendRedirect() |
| ------------- | -------------- |
| Server-side   | Client-side    |
| Same request  | New request    |
| URL unchanged | URL changes    |
| Faster        | Slower         |

---

## forward Example

```java
rd.forward(req, res);
```

---

## sendRedirect Example

```java
res.sendRedirect("home.jsp");
```

---

## Interview Question

### Difference between forward and sendRedirect?

forward() happens internally on server while sendRedirect() sends new request from browser.

---

# 26. Form Handling

## What is Form Handling?

Reading HTML form data in servlet.

---

## HTML Form Example

```html
<form action="login" method="post">
    <input type="text" name="username">
    <input type="submit">
</form>
```

---

## Servlet Code

```java
String name = req.getParameter("username");
```

---

## Interview Answer

Form handling means reading client form data using request object.

---

# 27. HTML Form with Servlet

## Complete Example

### HTML

```html
<form action="register" method="post">

    Name:
    <input type="text" name="name">

    <input type="submit">

</form>
```

---

### Servlet

```java
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(
        HttpServletRequest req,
        HttpServletResponse res
    ) {

        String name = req.getParameter("name");
    }
}
```

---

# 28. URL Rewriting

## What is URL Rewriting?

Session tracking technique where data appended in URL.

---

## Example

```text
home.jsp?user=rahul
```

---

## Interview Answer

URL rewriting stores session information inside URL.

---

# 29. Hidden Form Field

## What is Hidden Field?

Stores hidden data in HTML form.

---

## Example

```html
<input type="hidden" name="id" value="101">
```

---

## Use Case

* Session tracking
* Passing internal values

---

# 30. Cookies

## What is Cookie?

Small text data stored in browser.

Used for:

* Login tracking
* Remember me feature
* Session tracking

---

## Create Cookie

```java
Cookie c = new Cookie("user", "rahul");
res.addCookie(c);
```

---

## Read Cookie

```java
Cookie[] cookies = req.getCookies();
```

---

## Interview Answer

Cookie is small information stored on client browser.

---

# 31. Session Management

## Why Session Management?

HTTP is stateless.

Session management maintains user state.

---

## Techniques

* Cookies
* URL Rewriting
* Hidden Form Field
* HttpSession

---

## Interview Answer

Session management maintains user information across multiple requests.

---

# 32. HttpSession

## What is HttpSession?

Server-side session tracking mechanism.

Most commonly used session technique.

---

## Example

```java
HttpSession session = req.getSession();

session.setAttribute("user", "Rahul");
```

---

## Reading Session

```java
String name = (String)
session.getAttribute("user");
```

---

## Interview Question

### Difference between Cookie and Session?

| Cookie            | Session          |
| ----------------- | ---------------- |
| Client side       | Server side      |
| Less secure       | More secure      |
| Stored in browser | Stored on server |

---

# 33. ServletContext vs HttpSession vs Request Scope

| Scope          | Lifetime           |
| -------------- | ------------------ |
| Request        | Single request     |
| Session        | User session       |
| ServletContext | Entire application |

---

## Interview Question

### Difference between request, session, and application scope?

Request scope lasts for one request, session scope lasts until logout/browser close, and application scope is shared globally.

---

# 34. Page Navigation

## Navigation Types

* forward()
* sendRedirect()

---

## Example

```java
res.sendRedirect("home.jsp");
```

---

# 35. Servlet Chaining

## What is Servlet Chaining?

Passing request from one servlet to another.

---

## Example

```java
RequestDispatcher rd =
req.getRequestDispatcher("next");

rd.forward(req, res);
```

---

## Interview Answer

Servlet chaining means forwarding request from one servlet to another servlet.

---

# 36. Filter Basics

## What is Filter?

Filter intercepts request and response before reaching servlet.

---

## Uses

* Authentication
* Logging
* Validation
* Compression

---

## Flow

```text
Client -> Filter -> Servlet -> Response
```

---

## Interview Answer

Filter is used for preprocessing and postprocessing requests.

---

# 37. Listener Basics

## What is Listener?

Listener listens to application/session/request events.

---

## Examples

* Session creation
* Session destroy
* Context initialization

---

## Common Listeners

| Listener               | Purpose        |
| ---------------------- | -------------- |
| ServletContextListener | App events     |
| HttpSessionListener    | Session events |

---

## Interview Answer

Listeners are used to monitor servlet container events.

---

# 38. Exception Handling in Servlet

## Ways to Handle Exception

* try-catch
* web.xml error page

---

## Example

```java
try {

} catch(Exception e) {

}
```

---

## web.xml Error Page

```xml
<error-page>
    <exception-type>java.lang.Exception</exception-type>
    <location>/error.jsp</location>
</error-page>
```

---

## Interview Answer

Exceptions in servlet can be handled using try-catch or error-page configuration.

---

# 39. MVC Architecture with Servlet

## MVC Components

| Component  | Responsibility |
| ---------- | -------------- |
| Model      | Business Logic |
| View       | JSP UI         |
| Controller | Servlet        |

---

## Flow

```text
Browser
   |
   v
Servlet (Controller)
   |
   v
DAO/Service (Model)
   |
   v
Database
   |
   v
JSP (View)
```

---

## Real-Time Example

### Login System

```text
User enters username/password
-> Servlet receives request
-> DAO checks DB
-> Result returned
-> JSP displays response
```

---

## Interview Question

### Why MVC is used?

MVC separates business logic, UI, and request handling for better maintainability.

---

# 40. DAO with Servlet

## What is DAO?

DAO = Data Access Object.

DAO layer handles database operations separately.

---

## Why DAO Used?

Benefits:

* Clean architecture
* Code reusability
* Separation of concerns
* Easy maintenance

---

## MVC + DAO Flow

```text
Browser
   |
Servlet
   |
DAO
   |
Database
```

---

## DAO Example

### EmployeeDAO.java

```java
public class EmployeeDAO {

    public void saveEmployee(Employee e) {

    }
}
```

---

## Interview Answer

DAO separates database logic from servlet/business logic.

---

# 41. JDBC Integration with Servlet

## What is JDBC Integration?

Using JDBC inside servlet to communicate with database.

---

## Flow

```text
HTML Form
   |
Servlet
   |
JDBC
   |
Database
```

---

## Example

```java
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(
        HttpServletRequest req,
        HttpServletResponse res
    ) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "root"
            );

            PreparedStatement ps = con.prepareStatement(
                "insert into user values(?, ?)"
            );

            ps.setString(1, req.getParameter("name"));
            ps.setString(2, req.getParameter("email"));

            ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## Interview Answer

JDBC integration allows servlet to store and retrieve data from database.

---

# 42. CRUD Application using Servlet

## CRUD Meaning

| Operation | SQL    |
| --------- | ------ |
| Create    | INSERT |
| Read      | SELECT |
| Update    | UPDATE |
| Delete    | DELETE |

---

## Real-Time Example

### Employee Management System

Features:

* Add Employee
* View Employee
* Update Employee
* Delete Employee

---

## CRUD Flow

```text
JSP Form
   |
Servlet
   |
DAO/JDBC
   |
Database
```

---

## Interview Answer

CRUD application using servlet performs insert, fetch, update, and delete operations using JDBC.

---

# 43. File Upload Basics

## What is File Upload?

Uploading files from browser to server.

Examples:

* Profile image upload
* Resume upload
* PDF upload

---

## Required Annotation

```java
@MultipartConfig
```

---

## Example

```java
@MultipartConfig
public class UploadServlet extends HttpServlet {

}
```

---

## Getting File

```java
Part file = req.getPart("file");
```

---

## Interview Answer

Servlet file upload is handled using multipart request and @MultipartConfig annotation.

---

# 44. Servlet Authentication Basics

## What is Authentication?

Authentication verifies user identity.

---

## Login Flow

```text
User enters username/password
      |
Servlet validates from DB
      |
Success or Failure Response
```

---

## Basic Example

```java
String user = req.getParameter("username");
String pass = req.getParameter("password");
```

---

## Session After Login

```java
HttpSession session = req.getSession();
session.setAttribute("user", user);
```

---

## Interview Answer

Authentication checks whether user credentials are valid.

---

# 45. WAR Structure

## What is WAR?

WAR = Web Application Archive.

Used for deploying Java web applications.

Extension:

```text
.war
```

---

## Contains

* JSP
* Servlet classes
* web.xml
* Libraries
* HTML/CSS/JS

---

## Interview Answer

WAR file is deployment package of Java web application.

---

# 46. Web Application Directory Structure

## Standard Structure

```text
Project
 |
 |-- src
 |-- WebContent
 |     |-- index.jsp
 |     |-- WEB-INF
 |            |-- web.xml
 |            |-- lib
 |            |-- classes
```

---

## Important Folders

| Folder  | Purpose          |
| ------- | ---------------- |
| WEB-INF | Secure resources |
| lib     | JAR files        |
| classes | Compiled classes |

---

## Interview Question

### Why WEB-INF important?

Resources inside WEB-INF cannot be directly accessed from browser.

---

# 47. GET vs POST Method

| GET                 | POST                  |
| ------------------- | --------------------- |
| Fetch data          | Submit data           |
| Data visible in URL | Data hidden           |
| Less secure         | More secure           |
| Limited size        | Large data            |
| Bookmark possible   | Bookmark not possible |

---

## Interview Answer

GET is mainly used for reading data while POST is used for sending sensitive/form data.

---

# 48. Request Parameters

## What are Request Parameters?

Data sent from client to servlet.

---

## Example

```java
String name = req.getParameter("name");
```

---

## Multiple Values

```java
String[] skills = req.getParameterValues("skill");
```

---

## Interview Answer

Request parameters are form/input values sent from browser.

---

# 49. Response Methods

## Important Response Methods

| Method           | Purpose        |
| ---------------- | -------------- |
| getWriter()      | Write response |
| sendRedirect()   | Redirect page  |
| setContentType() | Response type  |
| sendError()      | Error response |

---

## Example

```java
res.setContentType("text/html");
```

---

# 50. PrintWriter

## What is PrintWriter?

Used to send output to browser.

---

## Example

```java
PrintWriter out = res.getWriter();
out.println("Welcome User");
```

---

## Interview Answer

PrintWriter is used to write response data to browser.

---

# 51. Send Error Response

## What is sendError()?

Used to send error message/status to browser.

---

## Example

```java
res.sendError(404, "Page Not Found");
```

---

## Common Codes

| Code | Meaning      |
| ---- | ------------ |
| 404  | Not Found    |
| 500  | Server Error |
| 403  | Forbidden    |

---

## Interview Answer

sendError() sends HTTP error response to client.

---

# 52. Content Type

## What is Content Type?

Defines response format.

---

## Examples

```java
res.setContentType("text/html");
res.setContentType("application/json");
```

---

## Interview Answer

Content type tells browser what type of response is being returned.

---

# 53. Servlet Multithreading Concept

## Important Point

Servlet uses:

```text
One Servlet Object
Multiple Threads
```

---

## Working

For every request:

* New thread created
* Same servlet object reused

---

## Advantages

* Better performance
* Less memory usage

---

## Interview Question

### Why servlet is faster than CGI?

Servlet uses multithreading while CGI creates new process per request.

---

# 54. Thread Safety

## What is Thread Safety?

Ensuring shared data is safely accessed by multiple threads.

---

## Unsafe Example

```java
public class DemoServlet extends HttpServlet {

    int count = 0;
}
```

Shared variable can create issues.

---

## Solution

* Avoid instance variables
* Use local variables
* Synchronization if needed

---

## Interview Answer

Servlets are not thread-safe by default because multiple threads use same servlet object.

---

# 55. Load on Startup

## What is load-on-startup?

Loads servlet during server startup.

---

## Example

```xml
<load-on-startup>1</load-on-startup>
```

---

## Benefits

* Faster first request
* Pre-initialization

---

## Interview Answer

load-on-startup loads servlet at server startup instead of first request.

---

# 56. Welcome File

## What is Welcome File?

Default page loaded when application starts.

---

## Example

```xml
<welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
</welcome-file-list>
```

---

## Interview Answer

Welcome file is default startup page of web application.

---

# 57. Session Tracking Techniques

## Techniques

| Technique     | Storage |
| ------------- | ------- |
| Cookies       | Browser |
| URL Rewriting | URL     |
| Hidden Field  | Form    |
| HttpSession   | Server  |

---

## Most Used

```text
HttpSession
```

---

## Interview Question

### Which session technique is most secure?

HttpSession because data stored on server.

---

# 58. JSP and Servlet Difference

| JSP                               | Servlet             |
| --------------------------------- | ------------------- |
| UI oriented                       | Logic oriented      |
| Easier HTML                       | More Java code      |
| Converted into servlet internally | Already Java class  |
| Used for presentation             | Used for controller |

---

## Interview Answer

JSP is mainly used for UI while servlet handles request processing/business logic.

---

# 59. Servlet Container

## What is Servlet Container?

Part of web server/application server that manages servlets.

Example:

```text
Tomcat
```

---

## Responsibilities

* Lifecycle management
* Request handling
* Thread management
* Security

---

## Interview Answer

Servlet container manages servlet lifecycle and request processing.

---

# 60. Tomcat Internal Working

## Internal Flow

```text
1. Browser sends request
2. Tomcat receives request
3. web.xml/@WebServlet mapping checked
4. Servlet object created if not exists
5. init() called once
6. service()/doGet()/doPost() called
7. Response sent back
8. destroy() called during shutdown
```

---

## Interview Question

### Explain Tomcat internal working.

Tomcat receives HTTP request, maps servlet, executes lifecycle methods, and returns response.

---

# 61. Life Cycle Methods Interview Questions

## Which method called once?

```text
init()
```

---

## Which method handles every request?

```text
service()
```

---

## Which method called before servlet removal?

```text
destroy()
```

---

## Lifecycle Order

```text
init() -> service() -> destroy()
```

---

# 62. Real-Time Servlet Flow

## Complete Flow

```text
User Browser
     |
HTML/JSP Form
     |
Servlet Controller
     |
DAO/JDBC
     |
Database
     |
Response
     |
JSP Page
```

---

## Real-Time Example

### Registration System

```text
User fills registration form
-> Servlet gets form data
-> DAO saves in DB
-> Success message shown
```

---

# 63. Mini Login/Register Project Flow using Servlet + JDBC

## Registration Flow

```text
HTML Form
   |
RegisterServlet
   |
DAO/JDBC
   |
Database Insert
   |
Success Page
```

---

## Login Flow

```text
Login Form
   |
LoginServlet
   |
Check username/password from DB
   |
Session Created
   |
Home Page
```

---

## Important Concepts Used

* Servlet
* JDBC
* Session
* PreparedStatement
* MVC
* DAO

---

# 64. Best Practices in Servlet Development

## Best Practices

* Use MVC architecture
* Use DAO layer
* Use PreparedStatement
* Avoid Java code in JSP
* Use try-with-resources
* Handle exceptions properly
* Avoid instance variables in servlet
* Use connection pooling
* Validate user input
* Use session carefully

---

## Interview Answer

Servlet best practices include MVC architecture, DAO pattern, PreparedStatement, and proper session/exception handling.

---

# Most Important Interview Questions Revision

## 1. What is Servlet?

Servlet is a server-side Java component used to handle HTTP requests.

---

## 2. Explain Servlet Lifecycle.

Servlet lifecycle includes init(), service(), and destroy() methods.

---

## 3. Difference between doGet and doPost?

GET is used for fetching data while POST is used for submitting data.

---

## 4. Difference between forward and sendRedirect?

forward() uses same request while sendRedirect() creates new request.

---

## 5. Difference between ServletConfig and ServletContext?

ServletConfig is servlet-specific while ServletContext is application-wide.

---

## 6. Why session management needed?

Because HTTP is stateless.

---

## 7. Difference between Cookie and Session?

Cookies are client-side while sessions are server-side.

---

## 8. What is Tomcat?

Tomcat is application server/servlet container for running servlet and JSP.

---

## 9. What is RequestDispatcher?

Used to forward/include request between resources.

---

## 10. What is MVC?

MVC separates application into Model, View, and Controller.


# Servlet vs Struts 1 vs Struts 2 Detailed Comparison Notes

# 1. Introduction

## What is Servlet?

Servlet is a core Java server-side technology used to create dynamic web applications.

Servlet handles:

* Client requests
* Business logic
* Database communication
* Dynamic response generation

Servlet is part of Java EE/Jakarta EE.

---

## What is Struts 1?

Struts 1 is an MVC framework built on top of Servlet and JSP.

Developed by:

```text
Apache Software Foundation
```

Struts 1 simplifies web application development using:

* MVC Architecture
* Centralized request handling
* Action classes
* Form Beans

---

## What is Struts 2?

Struts 2 is advanced version of Struts 1.

Built using:

* WebWork Framework
* Interceptor architecture
* POJO-based design

Struts 2 provides:

* Cleaner coding
* Better validation
* Better extensibility
* Easier testing

---

# 2. Basic Architecture

| Feature      | Servlet                     | Struts 1      | Struts 2               |
| ------------ | --------------------------- | ------------- | ---------------------- |
| Type         | Core Technology             | MVC Framework | Advanced MVC Framework |
| Architecture | Not complete MVC by default | MVC           | Advanced MVC           |
| Complexity   | Simple                      | Medium        | Medium-High            |

---

# 3. Internal Working

# Servlet Flow

```text
Browser
   |
HTTP Request
   |
Tomcat Server
   |
Servlet
   |
Business Logic/JDBC
   |
Database
   |
Response
   |
Browser
```

---

# Struts 1 Flow

```text
Browser
   |
ActionServlet (Front Controller)
   |
ActionForm
   |
Action Class
   |
Business Logic
   |
JSP
   |
Browser
```

---

# Struts 2 Flow

```text
Browser
   |
FilterDispatcher / StrutsPrepareAndExecuteFilter
   |
Interceptor Stack
   |
Action Class
   |
Business Logic
   |
Result/JSP
   |
Browser
```

---

# 4. Front Controller

## Servlet

Servlet does not provide fixed front controller.

Developer manually handles request mapping.

---

## Struts 1

Uses:

```text
ActionServlet
```

All requests go through ActionServlet.

---

## Struts 2

Uses:

```text
FilterDispatcher
```

or

```text
StrutsPrepareAndExecuteFilter
```

---

## Interview Question

### What is Front Controller?

Front Controller is a centralized controller that handles all incoming requests.

---

# 5. Request Handling

# Servlet

Developer directly handles request.

Example:

```java
protected void doPost(
    HttpServletRequest req,
    HttpServletResponse res
) {

}
```

---

# Struts 1

Request handled through:

```text
ActionServlet -> Action Class
```

---

# Struts 2

Request handled through:

```text
Filter -> Interceptors -> Action
```

---

# 6. Configuration Files

| Technology | Configuration File |
| ---------- | ------------------ |
| Servlet    | web.xml            |
| Struts 1   | struts-config.xml  |
| Struts 2   | struts.xml         |

---

# Servlet Example

```xml
<servlet>
    <servlet-name>login</servlet-name>
    <servlet-class>com.test.LoginServlet</servlet-class>
</servlet>
```

---

# Struts 1 Example

```xml
<action path="/login"
        type="com.test.LoginAction">
</action>
```

---

# Struts 2 Example

```xml
<action name="login"
        class="com.test.LoginAction">
    <result>home.jsp</result>
</action>
```

---

# 7. Action Classes

# Servlet

Servlet itself handles request.

```java
public class LoginServlet extends HttpServlet {

}
```

---

# Struts 1

Action class extends Action.

```java
public class LoginAction extends Action {

}
```

---

# Struts 2

Simple POJO class.

```java
public class LoginAction {

}
```

---

# Important Point

Struts 2 does not require extending framework classes.

---

# 8. Form Handling

# Servlet

Manual parameter handling.

```java
String name = req.getParameter("name");
```

---

# Struts 1

Uses:

```text
ActionForm Bean
```

Example:

```java
public class LoginForm extends ActionForm {

}
```

---

# Struts 2

Automatic parameter mapping.

```java
private String username;

public void setUsername(String username) {
    this.username = username;
}
```

---

## Interview Question

### Which framework provides automatic form mapping?

Struts 2.

---

# 9. Validation

| Technology | Validation          |
| ---------- | ------------------- |
| Servlet    | Manual              |
| Struts 1   | Validator framework |
| Struts 2   | Built-in validation |

---

# Servlet Validation Example

```java
if(name == null || name.equals("")) {

}
```

---

# Struts 1 Validation

Uses:

```text
validation.xml
```

---

# Struts 2 Validation

Supports:

* XML validation
* Annotation validation

---

# 10. Thread Safety

# Servlet

Single servlet object handles multiple requests.

Need thread safety care.

---

# Struts 1

Single Action object shared.

Thread safety issue possible.

---

# Struts 2

Creates new Action object per request.

More thread-safe.

---

## Interview Question

### Why Struts 2 more thread-safe?

Because new action object created for every request.

---

# 11. MVC Architecture

# Servlet

MVC manually implemented.

```text
Servlet = Controller
JSP = View
JDBC/Java = Model
```

---

# Struts 1

Built-in MVC support.

```text
ActionServlet = Controller
JSP = View
Business Logic = Model
```

---

# Struts 2

Advanced MVC implementation.

```text
Filter + Interceptors = Controller
JSP = View
POJO + Service = Model
```

---

# 12. Interceptors

# Servlet

No interceptor concept.

---

# Struts 1

No interceptor stack.

---

# Struts 2

Main feature:

```text
Interceptor Stack
```

---

## Uses of Interceptors

* Authentication
* Logging
* Validation
* Exception handling
* File upload

---

## Interview Question

### What are Interceptors?

Interceptors intercept requests before reaching action class.

---

# 13. Expression Language

| Technology  | Expression Language |
| ----------- | ------------------- |
| Servlet/JSP | JSP EL              |
| Struts 1    | JSP EL              |
| Struts 2    | OGNL                |

---

# What is OGNL?

OGNL = Object Graph Navigation Language.

Used in Struts 2 for accessing object data.

---

# Example

```jsp
<s:property value="username"/>
```

---

# 14. Database Integration

# Servlet

Manual JDBC integration.

```java
Connection con = DriverManager.getConnection(...);
```

---

# Struts 1

DAO/JDBC integration manually.

---

# Struts 2

Easy integration with:

* JDBC
* Hibernate
* Spring

---

# 15. Exception Handling

| Technology | Exception Handling        |
| ---------- | ------------------------- |
| Servlet    | try-catch/web.xml         |
| Struts 1   | ActionErrors              |
| Struts 2   | Global exception handling |

---

# Servlet Example

```java
try {

} catch(Exception e) {

}
```

---

# Struts 2 Example

```xml
<global-exception-mappings>
</global-exception-mappings>
```

---

# 16. Navigation Handling

# Servlet

Manual navigation.

```java
RequestDispatcher rd =
req.getRequestDispatcher("home.jsp");
```

---

# Struts 1

Configured in:

```text
struts-config.xml
```

---

# Struts 2

Configured in:

```text
struts.xml
```

---

# 17. Performance

| Technology | Performance     |
| ---------- | --------------- |
| Servlet    | Fastest         |
| Struts 1   | Moderate        |
| Struts 2   | Slightly slower |

---

# Why Servlet Faster?

* Lightweight
* No interceptors
* Less processing

---

# Why Struts 2 Slower?

Because of:

* Interceptor stack
* OGNL processing
* Extra framework layers

---

# 18. Development Speed

| Technology | Development Speed    |
| ---------- | -------------------- |
| Servlet    | Slow                 |
| Struts 1   | Faster than Servlet  |
| Struts 2   | Faster than Struts 1 |

---

# Why?

Servlet requires:

* Manual coding
* Manual validation
* Manual navigation

Struts frameworks automate many tasks.

---

# 19. Code Complexity

| Technology | Complexity       |
| ---------- | ---------------- |
| Servlet    | Boilerplate code |
| Struts 1   | XML heavy        |
| Struts 2   | Cleaner code     |

---

# 20. Reusability

| Technology | Reusability |
| ---------- | ----------- |
| Servlet    | Limited     |
| Struts 1   | Better      |
| Struts 2   | High        |

---

# 21. Learning Curve

| Technology | Difficulty  |
| ---------- | ----------- |
| Servlet    | Easy        |
| Struts 1   | Medium      |
| Struts 2   | Medium-Hard |

---

# 22. Real-Time Usage

# Servlet

Used for:

* Learning core web concepts
* Small projects
* Backend fundamentals

---

# Struts 1

Used mainly in:

* Legacy enterprise applications
* Government projects
* Banking systems

---

# Struts 2

Used in:

* Older enterprise projects
* Legacy maintenance

---

# Important Point

Modern industry mostly uses:

```text
Spring Boot
```

But Servlet/Struts knowledge still important for legacy projects.

---

# 23. Current Industry Demand

| Technology  | Demand                         |
| ----------- | ------------------------------ |
| Servlet     | Fundamental knowledge required |
| Struts 1    | Legacy support demand          |
| Struts 2    | Limited legacy demand          |
| Spring Boot | Very High                      |

---

# 24. Advantages and Disadvantages

# Servlet

## Advantages

* Fast
* Lightweight
* Full control
* Easy to learn basics

---

## Disadvantages

* Boilerplate code
* Manual MVC
* Hard maintenance
* More coding effort

---

# Struts 1

## Advantages

* MVC support
* Centralized request handling
* Better organization than servlet

---

## Disadvantages

* Old framework
* Heavy XML configuration
* Thread safety issues
* Complex form beans

---

# Struts 2

## Advantages

* Cleaner architecture
* POJO-based actions
* Interceptors
* Better validation
* Easier testing

---

## Disadvantages

* More internally complex
* Slightly slower
* Less modern demand

---

# 25. Real-Time Login Flow Comparison

# Servlet Login Flow

```text
Login Form
   |
LoginServlet
   |
JDBC/DAO
   |
Database
   |
Response JSP
```

---

# Struts 1 Login Flow

```text
Login.jsp
   |
ActionServlet
   |
LoginForm
   |
LoginAction
   |
DAO
   |
JSP
```

---

# Struts 2 Login Flow

```text
Login.jsp
   |
FilterDispatcher
   |
Interceptor Stack
   |
LoginAction
   |
Service/DAO
   |
Result JSP
```

---

# 26. Important Interview Questions

## Q1. Difference between Servlet and Struts?

Servlet is core Java web technology while Struts is MVC framework built on top of Servlet.

---

## Q2. Difference between Struts 1 and Struts 2?

Struts 2 provides:

* POJO actions
* Interceptors
* Better validation
* Better thread safety
* Cleaner architecture

---

## Q3. Why Struts 2 better than Struts 1?

* No ActionForm required
* Better validation
* Interceptors
* Easier testing
* More thread-safe

---

## Q4. Why Servlet faster than Struts?

Servlet has less framework overhead.

---

## Q5. Which technology currently used most?

Modern applications mostly use Spring Boot.

---

## Q6. Why Struts 1 considered old?

Because:

* Heavy XML configuration
* Thread safety issues
* Less flexibility
* Better frameworks available now

---

## Q7. What is ActionServlet?

Front controller of Struts 1.

---

## Q8. What is Interceptor in Struts 2?

Interceptor processes request before action execution.

---

## Q9. Which framework uses OGNL?

Struts 2.

---

## Q10. Which technology easier for beginners?

Servlet.

---

# 27. Final Summary Table

| Feature             | Servlet                  | Struts 1          | Struts 2               |
| ------------------- | ------------------------ | ----------------- | ---------------------- |
| Type                | Core Technology          | MVC Framework     | Advanced MVC Framework |
| Front Controller    | No fixed                 | ActionServlet     | FilterDispatcher       |
| MVC Support         | Manual                   | Yes               | Advanced               |
| Form Handling       | Manual                   | ActionForm        | Automatic              |
| Validation          | Manual                   | Validator         | Built-in               |
| Thread Safety       | Less                     | Less              | Better                 |
| Interceptors        | No                       | No                | Yes                    |
| Configuration       | web.xml                  | struts-config.xml | struts.xml             |
| Performance         | Fastest                  | Moderate          | Slightly slower        |
| Learning Difficulty | Easy                     | Medium            | Medium-Hard            |
| Current Demand      | Basic knowledge required | Legacy            | Legacy                 |
| Modern Replacement  | Spring Boot              | Spring Boot       | Spring Boot            |

---

# One Line Revision

```text
Servlet = Core Java web technology.
Struts 1 = Old MVC framework using ActionServlet.
Struts 2 = Advanced MVC framework using Interceptors and POJO actions.
Servlet is fastest.
Struts 2 is cleaner and more powerful than Struts 1.
Modern industry mainly uses Spring Boot.
```
