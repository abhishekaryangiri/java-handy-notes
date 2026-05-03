# Struts 1 Complete Interview Notes

# 1. Introduction to Struts 1

## What is Struts 1?

Struts 1 is an MVC (Model View Controller) framework for developing Java web applications.

Developed by:

```text
Apache Software Foundation
```

Built on top of:

* Servlet
* JSP

---

## Why Struts 1 Introduced?

Servlet/JSP applications had problems:

* Too much code
* Difficult maintenance
* No proper MVC separation
* Repeated code
* Hard navigation handling

Struts 1 solved these issues using MVC architecture.

---

## Simple Definition

"Struts 1 is a Java MVC framework used to develop enterprise web applications using Action classes, Form Beans, and centralized request handling."

---

## Real-Time Usage

Used mainly in:

* Banking systems
* Government projects
* Enterprise legacy applications
* Insurance portals

---

## Interview Question

### What is Struts 1?

Struts 1 is an MVC framework built on top of Servlet and JSP for developing enterprise Java web applications.

---

# 2. MVC Architecture in Struts 1

# MVC Meaning

| Component  | Responsibility            |
| ---------- | ------------------------- |
| Model      | Business Logic + Database |
| View       | JSP UI                    |
| Controller | ActionServlet             |

---

# Struts 1 MVC Flow

```text
Browser
   |
ActionServlet (Controller)
   |
ActionForm
   |
Action Class
   |
Business Logic/DAO
   |
Database
   |
JSP (View)
```

---

## Interview Question

### Explain MVC architecture in Struts 1.

Struts 1 follows MVC architecture where ActionServlet acts as controller, JSP as view, and business/DAO layer as model.

---

# 3. Components of Struts 1

## Important Components

| Component         | Purpose            |
| ----------------- | ------------------ |
| ActionServlet     | Front Controller   |
| Action Class      | Handles request    |
| ActionForm        | Form data holder   |
| struts-config.xml | Configuration file |
| JSP               | View layer         |
| ActionMapping     | URL mapping        |
| ActionForward     | Navigation         |

---

# 4. ActionServlet

## What is ActionServlet?

Central controller of Struts 1.

Handles all requests.

---

## Responsibilities

* Receives request
* Reads struts-config.xml
* Calls ActionForm
* Calls Action class
* Forwards response

---

## Internal Flow

```text
Browser
   |
ActionServlet
   |
ActionForm
   |
Action Class
```

---

## Interview Question

### What is ActionServlet?

ActionServlet is the front controller of Struts 1 that manages all incoming requests.

---

# 5. struts-config.xml

## What is struts-config.xml?

Main configuration file of Struts 1.

Used for:

* Action mapping
* Form bean mapping
* Forward configuration

---

## Example

```xml
<struts-config>

    <form-beans>
        <form-bean
            name="loginForm"
            type="com.form.LoginForm"/>
    </form-beans>

    <action-mappings>

        <action
            path="/login"
            type="com.action.LoginAction"
            name="loginForm"
            scope="request"
            input="login.jsp">

            <forward name="success" path="home.jsp"/>
            <forward name="failure" path="login.jsp"/>

        </action>

    </action-mappings>

</struts-config>
```

---

## Interview Question

### What is use of struts-config.xml?

Used for centralized configuration of actions, forms, and navigation.

---

# 6. Action Class

## What is Action Class?

Handles business request logic.

Extends:

```java
org.apache.struts.action.Action
```

---

## Example

```java
public class LoginAction extends Action {

    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response
    ) {

        return mapping.findForward("success");
    }
}
```

---

## Important Point

Every request handled through execute() method.

---

## Interview Question

### What is Action class?

Action class contains business logic and processes client requests.

---

# 7. execute() Method

## Purpose

Main method of Action class.

Called for every request.

---

## Signature

```java
public ActionForward execute(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response
)
```

---

## Parameters

| Parameter     | Purpose         |
| ------------- | --------------- |
| ActionMapping | Forward mapping |
| ActionForm    | Form data       |
| request       | Client request  |
| response      | Server response |

---

## Interview Question

### What is execute() method in Struts 1?

execute() is main request processing method of Action class.

---

# 8. ActionForm

## What is ActionForm?

JavaBean used to store form data.

Extends:

```java
ActionForm
```

---

## Example

```java
public class LoginForm extends ActionForm {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
```

---

## Responsibilities

* Holds form data
* Validation
* Data transfer

---

## Interview Question

### What is ActionForm?

ActionForm is a JavaBean used to capture form data in Struts 1.

---

# 9. ActionMapping

## What is ActionMapping?

Maps URL request to Action class.

Configured in:

```text
struts-config.xml
```

---

## Example

```xml
<action
    path="/login"
    type="com.action.LoginAction">
</action>
```

---

## Interview Answer

ActionMapping maps request URL to Action class.

---

# 10. ActionForward

## What is ActionForward?

Used for page navigation.

---

## Example

```java
return mapping.findForward("success");
```

---

## XML Mapping

```xml
<forward name="success" path="home.jsp"/>
```

---

## Interview Question

### What is ActionForward?

ActionForward is used to transfer control to another resource/page.

---

# 11. Request Flow in Struts 1

## Complete Flow

```text
1. Browser sends request
2. ActionServlet receives request
3. Reads struts-config.xml
4. Creates ActionForm object
5. Populates form data
6. Calls Action class execute()
7. Business logic executed
8. ActionForward returned
9. JSP response displayed
```

---

## Interview Question

### Explain Struts 1 request flow.

ActionServlet receives request, calls ActionForm and Action class, then forwards response to JSP.

---

# 12. Validation in Struts 1

## Types of Validation

* Manual validation
* Validator framework

---

# Manual Validation Example

```java
if(username == null || username.equals("")) {

}
```

---

# Validator Framework

Uses:

```text
validation.xml
```

---

## Interview Question

### How validation done in Struts 1?

Validation can be done manually or using Validator Framework.

---

# 13. validate() Method

## Purpose

Used for form validation.

Defined inside ActionForm.

---

## Example

```java
public ActionErrors validate(
    ActionMapping mapping,
    HttpServletRequest request
) {

    ActionErrors errors = new ActionErrors();

    return errors;
}
```

---

## Interview Question

### What is validate() method?

validate() method validates form data before execute() method call.

---

# 14. reset() Method

## Purpose

Resets form fields.

Called before populating form data.

---

## Example

```java
public void reset(
    ActionMapping mapping,
    HttpServletRequest request
) {

    username = null;
}
```

---

## Interview Answer

reset() method resets ActionForm fields before request processing.

---

# 15. JSP Integration in Struts 1

## JSP Used As

```text
View Layer
```

---

## Struts HTML Tags

| Tag           | Purpose        |
| ------------- | -------------- |
| html:form     | Form creation  |
| html:text     | Text field     |
| html:password | Password field |
| html:submit   | Submit button  |

---

## Example

```jsp
<html:form action="/login">

    <html:text property="username"/>

    <html:password property="password"/>

    <html:submit value="Login"/>

</html:form>
```

---

## Interview Question

### Why Struts tags used?

Struts tags simplify JSP form handling and integration with ActionForm.

---

# 16. Tiles Framework

## What is Tiles?

Used for reusable page layouts.

---

## Components Reused

* Header
* Footer
* Menu
* Sidebar

---

## Flow

```text
Header
Menu
Body
Footer
```

---

## Interview Question

### What is Tiles Framework?

Tiles provides reusable template-based page design in Struts 1.

---

# 17. Exception Handling in Struts 1

## Methods

* try-catch
* Global exception handling

---

## Example

```xml
<global-exceptions>
</global-exceptions>
```

---

## Interview Answer

Exceptions handled using try-catch or global exception configuration.

---

# 18. Session Handling in Struts 1

## Using HttpSession

```java
HttpSession session = request.getSession();
```

---

## Store Session Data

```java
session.setAttribute("user", username);
```

---

## Interview Question

### How session managed in Struts 1?

Using HttpSession object.

---

# 19. Request Scope vs Session Scope

| Scope   | Lifetime       |
| ------- | -------------- |
| Request | Single request |
| Session | User session   |

---

## Action Scope Example

```xml
scope="request"
```

---

# 20. DAO Integration in Struts 1

## Flow

```text
JSP
   |
Action Class
   |
DAO Layer
   |
Database
```

---

## DAO Example

```java
public class UserDAO {

    public boolean checkLogin() {
        return true;
    }
}
```

---

## Interview Answer

DAO layer separates database logic from Action class.

---

# 21. JDBC Integration in Struts 1

## Example

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/test",
    "root",
    "root"
);
```

---

## Flow

```text
Action Class
   |
DAO
   |
JDBC
   |
Database
```

---

# 22. Login Flow in Struts 1

## Complete Flow

```text
login.jsp
   |
ActionServlet
   |
LoginForm
   |
LoginAction
   |
DAO/JDBC
   |
Database Validation
   |
home.jsp
```

---

## Interview Question

### Explain login flow in Struts 1.

Request goes through ActionServlet, then ActionForm, Action class, DAO, and finally forwards to JSP.

---

# 23. CRUD Application Flow

## Example

```text
Add Employee
View Employee
Update Employee
Delete Employee
```

---

## CRUD Flow

```text
JSP
   |
Action Class
   |
DAO/JDBC
   |
Database
```

---

# 24. Thread Safety in Struts 1

## Important Point

Single Action object shared among multiple requests.

---

## Problem

Thread safety issue possible.

---

## Solution

* Avoid instance variables
* Use local variables

---

## Interview Question

### Is Struts 1 thread safe?

No, because same Action object shared by multiple threads.

---

# 25. Advantages of Struts 1

## Advantages

* MVC architecture
* Centralized request handling
* Better organization
* Reusable components
* Easier maintenance than servlet

---

# 26. Disadvantages of Struts 1

## Disadvantages

* Heavy XML configuration
* Thread safety issues
* Complex ActionForms
* Old framework
* Hard debugging

---

# 27. Struts 1 vs Servlet

| Servlet                   | Struts 1                 |
| ------------------------- | ------------------------ |
| Manual MVC                | Built-in MVC             |
| More coding               | Less coding              |
| No centralized controller | ActionServlet controller |
| Manual navigation         | ActionForward            |

---

## Interview Question

### Why Struts 1 better than Servlet?

Struts 1 provides MVC architecture and centralized request handling.

---

# 28. Struts 1 vs Struts 2

| Struts 1         | Struts 2             |
| ---------------- | -------------------- |
| ActionServlet    | FilterDispatcher     |
| ActionForm       | No ActionForm        |
| XML heavy        | Cleaner              |
| Less thread safe | Better thread safety |
| Old architecture | Better architecture  |

---

## Interview Question

### Why Struts 2 better than Struts 1?

Struts 2 provides better architecture, POJO actions, interceptors, and thread safety.

---

# 29. Important Configuration Files

| File                            | Purpose              |
| ------------------------------- | -------------------- |
| web.xml                         | Web configuration    |
| struts-config.xml               | Struts configuration |
| validation.xml                  | Validation rules     |
| ApplicationResources.properties | Messages             |

---

# 30. Project Structure in Struts 1

```text
Project
 |
 |-- src
 |     |-- action
 |     |-- form
 |     |-- dao
 |
 |-- WebContent
 |     |-- jsp
 |     |-- WEB-INF
 |            |-- web.xml
 |            |-- struts-config.xml
 |            |-- lib
```

---

# 31. web.xml Configuration

## Example

```xml
<servlet>

    <servlet-name>action</servlet-name>

    <servlet-class>
        org.apache.struts.action.ActionServlet
    </servlet-class>

</servlet>
```

---

## Mapping

```xml
<servlet-mapping>

    <servlet-name>action</servlet-name>

    <url-pattern>*.do</url-pattern>

</servlet-mapping>
```

---

## Important Point

Requests end with:

```text
.do
```

---

# 32. Message Resources

## Purpose

Stores application messages.

---

## Example

```properties
login.success=Login Successful
```

---

## Access in JSP

```jsp
<bean:message key="login.success"/>
```

---

# 33. DynaActionForm

## What is DynaActionForm?

Dynamic ActionForm without JavaBean class.

---

## Defined in XML

```xml
<form-bean
    name="loginForm"
    type="org.apache.struts.action.DynaActionForm">
</form-bean>
```

---

## Interview Question

### What is DynaActionForm?

Dynamic form bean configured in XML without separate Java class.

---

# 34. Global Forward

## Purpose

Used for common navigation.

---

## Example

```xml
<global-forwards>

    <forward name="home" path="/home.jsp"/>

</global-forwards>
```

---

# 35. Best Practices in Struts 1

## Best Practices

* Follow MVC properly
* Use DAO layer
* Avoid business logic in JSP
* Use validation framework
* Use local variables
* Handle exceptions properly
* Keep XML organized
* Use reusable JSP components

---

# 36. Most Important Interview Questions

## Q1. What is Struts 1?

Struts 1 is MVC framework built on Servlet and JSP.

---

## Q2. What is ActionServlet?

Front controller of Struts 1.

---

## Q3. What is ActionForm?

JavaBean used to store form data.

---

## Q4. What is ActionForward?

Used for page navigation.

---

## Q5. What is struts-config.xml?

Main configuration file.

---

## Q6. Explain request flow in Struts 1.

Request handled by ActionServlet, ActionForm, Action class, then forwarded to JSP.

---

## Q7. What is validate() method?

Used for form validation.

---

## Q8. What is reset() method?

Resets form fields.

---

## Q9. Why Struts 1 used?

For MVC architecture and centralized request handling.

---

## Q10. Is Struts 1 thread safe?

No.

---

## Q11. Difference between Servlet and Struts 1?

Struts 1 provides built-in MVC.

---

## Q12. Difference between Struts 1 and Struts 2?

Struts 2 uses interceptors and POJO actions.

---

## Q13. What is Tiles?

Reusable template framework.

---

## Q14. What is DynaActionForm?

Dynamic form bean configured in XML.

---

## Q15. Why Struts 1 considered old?

Heavy XML and better frameworks available.

---

# 37. Enterprise Level Struts 1 Application Working Flow

# Example: Government Enterprise Project (Like NSAP)

Large enterprise applications like:

* NSAP
* Banking Systems
* Insurance Portals
* Railway Systems

mostly follow layered architecture.

---

# 1. Real-Time Enterprise Architecture

```text
Browser
   |
JSP Page
   |
ActionServlet (Front Controller)
   |
struts-config.xml
   |
Action Class
   |
DTO/Bean
   |
DAO Layer
   |
JDBC
   |
Database
   |
Response JSP using Tiles
```

---

# 2. Enterprise Project Folder Structure

```text
Project
 |
 |-- src
 |     |
 |     |-- action
 |     |      |-- LoginAction.java
 |     |      |-- PensionAction.java
 |     |
 |     |-- form
 |     |      |-- LoginForm.java
 |     |
 |     |-- dao
 |     |      |-- UserDAO.java
 |     |
 |     |-- dto
 |     |      |-- UserDTO.java
 |     |
 |     |-- service
 |     |      |-- UserService.java
 |     |
 |     |-- util
 |            |-- DBConnection.java
 |
 |-- WebContent
 |     |
 |     |-- jsp
 |     |      |-- login.jsp
 |     |      |-- dashboard.jsp
 |     |
 |     |-- tiles
 |     |      |-- header.jsp
 |     |      |-- menu.jsp
 |     |      |-- footer.jsp
 |     |
 |     |-- WEB-INF
 |            |-- web.xml
 |            |-- struts-config.xml
 |            |-- tiles-def.xml
 |            |-- lib
```

---

# 3. web.xml Working

## Purpose

Main deployment descriptor.

Tomcat first reads:

```text
web.xml
```

---

## Responsibilities

* Loads ActionServlet
* URL mapping
* Welcome page
* Filter configuration
* Session config

---

## Example

```xml
<servlet>

    <servlet-name>action</servlet-name>

    <servlet-class>
        org.apache.struts.action.ActionServlet
    </servlet-class>

</servlet>
```

---

## Mapping

```xml
<servlet-mapping>

    <servlet-name>action</servlet-name>

    <url-pattern>*.do</url-pattern>

</servlet-mapping>
```

---

# Real-Time Meaning

If request comes:

```text
login.do
```

then request goes to:

```text
ActionServlet
```

---

# 4. struts-config.xml Working

## Purpose

Heart of Struts 1 application.

Stores:

* Action mapping
* Form beans
* Forward pages
* Global forwards

---

## Example

```xml
<action
    path="/login"
    type="com.action.LoginAction"
    name="loginForm"
    scope="request"
    input="login.jsp">

    <forward name="success" path="home.jsp"/>

</action>
```

---

# Real-Time Working

When request:

```text
/login.do
```

comes:

```text
ActionServlet
```

reads:

```text
struts-config.xml
```

and identifies:

```text
Which Action class should execute.
```

---

# 5. Tiles Framework Working

# Why Tiles Used?

Enterprise applications have same:

* Header
* Footer
* Menu
* Sidebar

on every page.

Instead of repeating code, Tiles used.

---

# Tiles Layout Example

```text
--------------------------------
Header
--------------------------------
Menu
--------------------------------
Body Content
--------------------------------
Footer
--------------------------------
```

---

# tiles-def.xml Example

```xml
<definition name="baseLayout"
            path="/layout/baseLayout.jsp">

    <put name="header" value="/tiles/header.jsp"/>

    <put name="menu" value="/tiles/menu.jsp"/>

    <put name="footer" value="/tiles/footer.jsp"/>

</definition>
```

---

# Real-Time Working

Suppose:

```text
Dashboard page opens.
```

Tiles automatically loads:

* Header
* Menu
* Body
* Footer

---

# Advantage

If menu changes:

Only one file update needed.

Entire application updates automatically.

---

# 6. JSP Working in Enterprise Application

## JSP Used As

```text
View Layer
```

---

## Responsibilities

* Display UI
* Show form
* Display table data
* Show reports
* Show error messages

---

## Important Rule

Enterprise applications avoid:

```text
Business logic inside JSP.
```

---

# JSP Example

```jsp
<html:form action="/login">

    <html:text property="username"/>

    <html:password property="password"/>

    <html:submit value="Login"/>

</html:form>
```

---

# 7. Form Bean Working

# Purpose

Captures form data.

---

# Example

```java
public class LoginForm extends ActionForm {

    private String username;
    private String password;
}
```

---

# Real-Time Flow

User enters:

```text
Username + Password
```

Data automatically stored inside:

```text
LoginForm
```

---

# 8. Action Class Working

## Purpose

Acts like controller/business handler.

---

# Example

```java
public class LoginAction extends Action {

    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response
    ) {

        return mapping.findForward("success");
    }
}
```

---

# Responsibilities

* Receive request
* Call service/DAO
* Handle business flow
* Return response page

---

# 9. DTO/Bean Working

# DTO Meaning

DTO = Data Transfer Object.

Used for carrying data between layers.

---

# Example

```java
public class UserDTO {

    private String username;
    private String state;
    private String scheme;
}
```

---

# Why DTO Used?

Suppose database has:

* Username
* Pension Scheme
* State
* Age

Instead of sending individual variables:

Single DTO object carries all data.

---

# Real-Time Flow

```text
DAO -> DTO -> Action -> JSP
```

---

# 10. DAO Layer Working

# DAO Meaning

DAO = Data Access Object.

Responsible for database operations.

---

# Responsibilities

* Insert data
* Update data
* Delete data
* Fetch data

---

# Example

```java
public class UserDAO {

    public boolean loginCheck(UserDTO dto) {

        return true;
    }
}
```

---

# Important Rule

Database logic should stay inside DAO.

---

# Why?

Better:

* Maintainability
* Reusability
* Separation of concerns

---

# 11. JDBC Working

# Flow

```text
DAO
   |
JDBC Driver
   |
Database
```

---

# Example

```java
Connection con = DriverManager.getConnection(
    url,
    username,
    password
);
```

---

# Real-Time Enterprise Flow

```text
Action Class
   |
DAO Layer
   |
JDBC
   |
PostgreSQL/Oracle/MySQL
```

---

# 12. Service Layer Working

# Why Service Layer Used?

Large enterprise projects avoid direct:

```text
Action -> DAO
```

Instead:

```text
Action -> Service -> DAO
```

---

# Advantage

Business logic centralized.

---

# Example

```java
public class UserService {

    public boolean validateUser(UserDTO dto) {

        return dao.loginCheck(dto);
    }
}
```

---

# 13. Real-Time NSAP-Type Login Flow

```text
1. User opens login.jsp

2. User enters username/password

3. Form submits to login.do

4. web.xml sends request to ActionServlet

5. ActionServlet reads struts-config.xml

6. ActionServlet creates LoginForm

7. Form data stored inside LoginForm

8. LoginAction execute() called

9. LoginAction creates UserDTO

10. LoginAction calls Service layer

11. Service layer calls DAO

12. DAO executes JDBC query

13. Database validates user

14. DAO returns result

15. Service returns result

16. Action returns ActionForward

17. Tiles layout loads dashboard.jsp

18. Header/Menu/Footer automatically loaded

19. Final response shown to user
```

---

# 14. Enterprise Application Advantages

## Why Large Organizations Used Struts 1?

* Centralized architecture
* Better MVC separation
* Reusable components
* Easier maintenance
* Structured codebase
* Large team support

---

# 15. Common Enterprise Features

## Real Enterprise Applications Include

* Login Authentication
* Role-based access
* Session management
* Tiles layouts
* DAO layer
* Service layer
* DTO objects
* Validation framework
* Exception handling
* Logging
* Database pooling
* Reports
* Pagination
* Audit system

---

# 16. Interview Questions on Enterprise Flow

## Q1. Explain enterprise flow in Struts 1 application.

Request comes to ActionServlet through web.xml mapping. ActionServlet reads struts-config.xml and calls ActionForm and Action class. Action class communicates with Service/DAO layer. DAO interacts with database through JDBC. Response returned to JSP/Tiles layout.

---

## Q2. Why DAO layer used?

To separate database logic from business logic.

---

## Q3. Why DTO used?

DTO used for transferring data between layers.

---

## Q4. Why Tiles used?

For reusable layouts like header/footer/menu.

---

## Q5. Why Service layer used?

To keep business logic separate from controller.

---

## Q6. Why enterprise apps follow layered architecture?

For better maintenance, scalability, and team development.

---

# 37. Final Summary

```text
Struts 1 is an MVC framework built on Servlet/JSP.
ActionServlet acts as front controller.
ActionForm stores form data.
Action class processes request.
ActionForward handles navigation.
struts-config.xml stores configuration.
Tiles provides reusable layouts.
DAO handles database operations.
DTO transfers data between layers.
Service layer handles business logic.
Enterprise applications follow layered architecture.
Used mainly in legacy enterprise projects.
Modern projects mostly use Spring Boot.
```


# Enterprise Application Security and Web Services Complete Notes

# PART 1 : Enterprise Application Security

# 1. Introduction to Security

## What is Security?

Security means protecting application and data from:

* Unauthorized access
* Hackers
* Data theft
* Fake requests
* Malicious users

---

## Real-Time Enterprise Examples

Applications like:

* NSAP
* Banking systems
* Insurance portals
* Railway systems
* Government portals

handle sensitive user data.

Therefore strong security required.

---

# 2. Authentication

## What is Authentication?

Authentication means:

```text
Verifying user identity
```

Checking:

* Username
* Password
* OTP
* Token

---

## Real-Time Login Flow

```text
Login Page
   |
User enters username/password
   |
Application verifies credentials
   |
Database check
   |
User authenticated
   |
Session created
```

---

## Example

```sql
SELECT * FROM users
WHERE username=?
AND password=?
```

---

## Important Point

If credentials valid:

```text
User allowed to access system.
```

Otherwise:

```text
Access denied.
```

---

## Interview Question

### What is Authentication?

Authentication verifies whether user is valid or not.

---

# 3. Authorization

## What is Authorization?

Authorization means:

```text
Checking user permissions.
```

---

## Real-Time Example

| Role     | Permission     |
| -------- | -------------- |
| Admin    | Full Access    |
| Operator | Limited Access |
| Viewer   | Read Only      |

---

## Flow

```text
User Login
   |
Role Fetch
   |
Permission Check
   |
Access Granted/Denied
```

---

## Example

```java
session.setAttribute("role", "ADMIN");
```

---

## Interview Question

### Difference between Authentication and Authorization?

Authentication verifies user identity while authorization checks user permissions.

---

# 4. Session Management

## What is Session?

Session stores logged-in user information.

---

## Why Session Needed?

HTTP protocol is stateless.

So server cannot remember user automatically.

Session solves this problem.

---

## Example

```java
HttpSession session = request.getSession();

session.setAttribute("user", username);
```

---

## Real-Time Working

After login:

```text
Session ID generated
```

Stored in browser cookie.

Each request validates session.

---

## Interview Question

### Why session used?

To track logged-in user across multiple requests.

---

# 5. Session Timeout

## Purpose

Automatically logout inactive users.

---

## web.xml Example

```xml
<session-config>

    <session-timeout>30</session-timeout>

</session-config>
```

---

## Meaning

```text
30 minutes inactivity -> auto logout
```

---

## Interview Question

### What is session timeout?

Automatic logout after user inactivity.

---

# 6. URL Security

## Problem

User may directly access protected URL.

Example:

```text
/dashboard.jsp
```

without login.

---

# Solution

Session checking.

---

## Example

```java
if(session.getAttribute("user") == null) {

    response.sendRedirect("login.jsp");
}
```

---

## Real-Time Flow

```text
Request comes
   |
Session validated
   |
Access allowed/blocked
```

---

# 7. Password Encryption and Hashing

## Problem

Plain passwords dangerous.

---

# Solution

Passwords encrypted or hashed.

---

## Common Algorithms

* MD5
* SHA
* BCrypt

---

## Real-Time Flow

```text
Password entered
   |
Hash generated
   |
Hash stored in database
```

Login time:

```text
Input password hash compared
```

---

## Interview Question

### Why password hashing used?

To securely store passwords.

---

# 8. SQL Injection Prevention

## What is SQL Injection?

Attack where hacker manipulates SQL query.

---

## Dangerous Example

```sql
' OR '1'='1
```

---

# Wrong Code

```java
String sql =
"select * from users where username='"
+ user + "'";
```

---

# Correct Code

```java
PreparedStatement ps =
con.prepareStatement(
"select * from users where username=?"
);
```

---

## Why PreparedStatement Better?

* Prevents SQL injection
* Faster query execution
* Safer

---

## Interview Question

### Why PreparedStatement used?

To prevent SQL Injection.

---

# 9. CSRF Protection

## CSRF Meaning

Cross Site Request Forgery.

---

## Problem

Fake requests can be sent using logged-in session.

---

## Solution

Token-based validation.

---

## Flow

```text
Server generates token
   |
Hidden form field
   |
Token validation
```

---

# 10. XSS Protection

## XSS Meaning

Cross Site Scripting.

---

## Problem

Malicious JavaScript injected into pages.

---

## Example Attack

```html
<script>alert('hack')</script>
```

---

## Solution

* Input sanitization
* Output escaping
* Validation

---

## Interview Question

### What is XSS?

XSS is attack where malicious JavaScript injected into webpage.

---

# 11. Access Control

## Purpose

Restrict user operations.

---

## Example

```text
Only admin can delete records.
```

---

## Flow

```text
Request received
   |
Role check
   |
Permission validation
   |
Action allowed/blocked
```

---

# 12. Audit Logging

## Purpose

Track:

* Login activity
* Data updates
* Delete operations
* User actions

---

## Example

```text
User Rahul updated pension record at 10:30 PM
```

---

## Real-Time Importance

Used for:

* Monitoring
* Security investigation
* Government compliance

---

# 13. HTTPS Security

## What is HTTPS?

Secure communication protocol.

---

## Why Used?

Encrypts:

* Passwords
* Sensitive data
* API communication

---

## Flow

```text
Browser
   |
Encrypted communication
   |
Server
```

---

# 14. Enterprise Security Layers

```text
UI Security
   |
Session Security
   |
Role Security
   |
DAO Security
   |
Database Security
```

---

# 15. Real-Time Enterprise Security Flow

```text
1. User opens login page

2. Username/password entered

3. Password encrypted

4. Database validation

5. Session created

6. User role assigned

7. Session validated on every request

8. Unauthorized access blocked

9. Audit logs maintained

10. Session timeout applied
```

---

# 16. Common Security Technologies

| Technology        | Purpose                  |
| ----------------- | ------------------------ |
| HTTPS             | Secure communication     |
| Session           | User tracking            |
| Filter            | Request security         |
| PreparedStatement | SQL injection prevention |
| BCrypt            | Password hashing         |
| Role-based access | Authorization            |

---

# 17. Security Interview Questions

## Q1. Difference between Authentication and Authorization?

Authentication verifies user identity while authorization checks permissions.

---

## Q2. Why PreparedStatement used?

To prevent SQL Injection.

---

## Q3. Why session used?

To track logged-in user.

---

## Q4. What is session timeout?

Automatic logout after inactivity.

---

## Q5. What is XSS?

Malicious JavaScript injection attack.

---

## Q6. What is CSRF?

Fake request attack using logged-in user session.

---

# PART 2 : Web Services

# 18. Introduction to Web Services

## What is Web Service?

Web service allows:

```text
Application-to-application communication
```

using network.

---

## Real-Time Example

Enterprise systems communicate with:

* Aadhaar services
* Bank systems
* Payment gateways
* State portals
* External APIs

---

## Interview Question

### What is Web Service?

Web service enables communication between applications over network.

---

# 19. Why Web Services Needed?

Enterprise applications have:

* Multiple systems
* Different technologies
* Different servers

Need data exchange.

---

# Example

```text
NSAP System <-> Bank System
```

---

# 20. Types of Web Services

| Type     | Data Format |
| -------- | ----------- |
| SOAP     | XML         |
| REST API | JSON        |

---

# 21. SOAP Web Service

## Characteristics

* Uses XML
* Heavy protocol
* Enterprise-level
* Highly secure
* Old government systems use SOAP

---

## XML Example

```xml
<user>
   <name>Rahul</name>
</user>
```

---

## Interview Question

### What is SOAP?

SOAP is XML-based web service protocol.

---

# 22. REST API

## Characteristics

* Lightweight
* Fast
* Uses JSON
* Modern applications mostly use REST

---

## JSON Example

```json
{
   "name":"Rahul"
}
```

---

## Interview Question

### Why REST popular?

Because REST is lightweight and faster.

---

# 23. REST API Methods

| Method | Purpose     |
| ------ | ----------- |
| GET    | Fetch data  |
| POST   | Insert data |
| PUT    | Update data |
| DELETE | Delete data |

---

# Examples

## GET

```text
GET /users
```

---

## POST

```text
POST /saveUser
```

---

# 24. JSON Response Example

```json
{
   "status":"success",
   "username":"Rahul"
}
```

---

# 25. Enterprise Web Service Flow

```text
Frontend
   |
Action/Controller
   |
Service Layer
   |
REST Client/API Call
   |
External Server
   |
JSON/XML Response
   |
DTO Mapping
   |
JSP/UI Response
```

---

# 26. Web Services in Struts 1 Projects

Old enterprise applications use:

* SOAP APIs
* REST APIs
* HttpURLConnection
* Apache HttpClient

---

## Flow

```text
Action Class
   |
Service Layer
   |
REST/SOAP API Call
   |
External System
```

---

# 27. Real-Time Government Example

## Example APIs

* Aadhaar verification API
* Bank verification API
* PFMS payment API
* State service APIs

---

# 28. API Authentication

## APIs Secured Using

* Token
* API Key
* OAuth
* JWT

---

## Example

```text
Authorization: Bearer token
```

---

# 29. DTO Usage in APIs

## Why DTO Used?

To transfer API response data between layers.

---

## Example DTO

```java
public class UserDTO {

    private String username;

}
```

---

## Real-Time Flow

```text
API Response
   |
DTO Mapping
   |
Service Layer
   |
JSP Display
```

---

# 30. Error Handling in APIs

## Common Errors

| Error Code | Meaning            |
| ---------- | ------------------ |
| 404        | Resource Not Found |
| 500        | Server Error       |
| 401        | Unauthorized       |
| 403        | Forbidden          |

---

# 31. Enterprise API Security

## Security Applied

* HTTPS
* Token validation
* IP restrictions
* Encryption
* Role-based access

---

# 32. Real-Time Enterprise API Architecture

```text
Frontend
   |
Struts Action
   |
Service Layer
   |
REST Client
   |
External APIs
   |
JSON/XML Response
   |
DTO Mapping
   |
JSP Response
```

---

# 33. Web Services Interview Questions

## Q1. What is Web Service?

Web service enables communication between applications.

---

## Q2. Difference between SOAP and REST?

SOAP uses XML and is heavy while REST uses JSON and is lightweight.

---

## Q3. What is JSON?

JavaScript Object Notation used for data exchange.

---

## Q4. Why DTO used in APIs?

DTO transfers API response data between layers.

---

## Q5. What is API authentication?

Securing APIs using token/API key/JWT.

---

## Q6. Why HTTPS used?

To encrypt communication.

---

# 34. Final Summary

```text
Enterprise security manages authentication, authorization, session handling, encryption, SQL
```
