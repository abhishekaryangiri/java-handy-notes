
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
