# JSP Complete Interview Notes

# 1. JSP Introduction

## What is JSP?

JSP = Java Server Pages.

JSP is a server-side technology used to create dynamic web pages.

JSP allows mixing:

* HTML
* CSS
* Java Code
* JSP Tags

---

## Simple Definition

"JSP is used to create dynamic web pages using HTML and Java."

---

## Why JSP Introduced?

Servlet had problems:

* Too much HTML inside Java
* Difficult UI development
* Hard maintenance

JSP solved this problem.

---

## Real-Time Examples

* Login page
* Registration page
* Dashboard page
* Profile page
* Shopping cart page

---

## Interview Question

### What is JSP?

JSP is a server-side technology used to create dynamic web pages using HTML and Java.

---

# 2. JSP Architecture

## Important Point

JSP internally converted into Servlet.

---

## Internal Flow

```text
Browser
   |
JSP Request
   |
Tomcat
   |
JSP Converted into Servlet
   |
Compilation
   |
Execution
   |
Response
```

---

## Interview Question

### What happens internally when JSP runs?

JSP first converts into servlet, then compiles into class file, then executes.

---

# 3. JSP Lifecycle

## JSP Lifecycle Methods

```text
1. Translation
2. Compilation
3. Class Loading
4. Object Creation
5. jspInit()
6. _jspService()
7. jspDestroy()
```

---

# Lifecycle Explanation

## 1. Translation

JSP converted into Servlet.

---

## 2. Compilation

Servlet converted into .class file.

---

## 3. Class Loading

Class loaded into memory.

---

## 4. Object Creation

Servlet object created.

---

## 5. jspInit()

Called once.

Initialization work.

---

## 6. _jspService()

Handles every request.

---

## 7. jspDestroy()

Called before JSP removal.

---

## Interview Question

### Explain JSP Lifecycle.

JSP lifecycle includes translation, compilation, initialization, request processing, and destruction.

---

# 4. JSP vs Servlet

| JSP                     | Servlet                     |
| ----------------------- | --------------------------- |
| UI oriented             | Logic oriented              |
| Easier HTML writing     | More Java code              |
| Converted into servlet  | Already Java class          |
| Better for presentation | Better for request handling |

---

## Important Point

Servlet acts as Controller.

JSP acts as View.

---

## Interview Question

### Difference between JSP and Servlet?

JSP mainly used for presentation while servlet handles business logic and request processing.

---

# 5. JSP Syntax

## Types of JSP Elements

* Directives
* Scripting Elements
* Implicit Objects
* Action Tags
* Expression Language
* JSTL

---

# 6. JSP Directives

## What are Directives?

Directives provide instructions to JSP container.

---

## Types of Directives

| Directive | Purpose          |
| --------- | ---------------- |
| page      | Page settings    |
| include   | Include file     |
| taglib    | JSTL/custom tags |

---

# 7. Page Directive

## Syntax

```jsp
<%@ page language="java" %>
```

---

## Common Attributes

| Attribute   | Purpose        |
| ----------- | -------------- |
| import      | Import package |
| contentType | Response type  |
| errorPage   | Error page     |
| isErrorPage | Error handling |

---

## Example

```jsp
<%@ page import="java.util.*" %>
```

---

## Interview Question

### What is page directive?

Page directive provides page-level configuration.

---

# 8. Include Directive

## Purpose

Includes static content during translation phase.

---

## Syntax

```jsp
<%@ include file="header.jsp" %>
```

---

## Use Cases

* Header
* Footer
* Common menu

---

## Interview Question

### Difference between include directive and action tag include?

Include directive includes content at translation time while action tag includes at request time.

---

# 9. Taglib Directive

## Purpose

Used to use JSTL/custom tags.

---

## Example

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
```

---

# 10. JSP Scripting Elements

## Types

| Element     | Syntax |
| ----------- | ------ |
| Scriptlet   | <% %>  |
| Expression  | <%= %> |
| Declaration | <%! %> |

---

# 11. Scriptlet Tag

## Purpose

Used to write Java code.

---

## Example

```jsp
<%
int a = 10;
out.println(a);
%>
```

---

## Important Point

Nowadays scriptlets avoided.

Use JSTL and EL instead.

---

## Interview Question

### Why scriptlets discouraged?

Because mixing Java code with HTML reduces readability and maintainability.

---

# 12. Expression Tag

## Purpose

Displays output directly.

---

## Example

```jsp
<%= new Date() %>
```

---

## Converted Internally

```java
out.print()
```

---

## Interview Question

### Difference between scriptlet and expression tag?

Scriptlet writes Java code while expression prints value.

---

# 13. Declaration Tag

## Purpose

Used to declare variables/methods.

---

## Example

```jsp
<%!
int count = 0;
%>
```

---

## Important Point

Variables become instance variables.

---

# 14. JSP Implicit Objects

## What are Implicit Objects?

Objects automatically available in JSP.

---

## Important Implicit Objects

| Object      | Purpose           |
| ----------- | ----------------- |
| request     | Client request    |
| response    | Server response   |
| session     | Session handling  |
| application | Application scope |
| out         | Print output      |
| config      | Servlet config    |
| pageContext | JSP context       |
| exception   | Error handling    |

---

## Example

```jsp
<%= request.getParameter("name") %>
```

---

## Interview Question

### What are implicit objects?

Objects automatically provided by JSP container.

---

# 15. Request Object in JSP

## Purpose

Used to read client request data.

---

## Example

```jsp
<%
String name = request.getParameter("username");
%>
```

---

# 16. Session Object in JSP

## Purpose

Used for session management.

---

## Example

```jsp
<%
session.setAttribute("user", "Rahul");
%>
```

---

## Reading Session

```jsp
<%= session.getAttribute("user") %>
```

---

## Interview Question

### Why session used?

Session maintains user information across multiple requests.

---

# 17. Out Object

## Purpose

Used to send response to browser.

---

## Example

```jsp
<%
out.println("Welcome User");
%>
```

---

# 18. JSP Action Tags

## What are Action Tags?

Used for dynamic operations.

---

## Important Action Tags

| Tag         | Purpose          |
| ----------- | ---------------- |
| jsp:include | Include resource |
| jsp:forward | Forward request  |
| jsp:param   | Pass parameter   |
| jsp:useBean | Use JavaBean     |

---

# 19. jsp:include

## Purpose

Includes content at request time.

---

## Example

```jsp
<jsp:include page="header.jsp" />
```

---

# 20. jsp:forward

## Purpose

Forward request to another resource.

---

## Example

```jsp
<jsp:forward page="home.jsp" />
```

---

# 21. JavaBean in JSP

## What is JavaBean?

Reusable Java class with:

* Private variables
* Getter/setter
* Default constructor

---

## Example Bean

```java
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

---

# 22. jsp:useBean

## Purpose

Creates/reuses bean object.

---

## Example

```jsp
<jsp:useBean id="u" class="com.test.User" />
```

---

# 23. Expression Language (EL)

## What is EL?

EL = Expression Language.

Used to access data easily without Java code.

---

## Syntax

```jsp
${expression}
```

---

## Example

```jsp
${user}
```

---

## Benefits

* Cleaner code
* Less Java code
* Easy readability

---

## Interview Question

### Why EL preferred over scriptlet?

EL reduces Java code and improves readability.

---

# 24. JSTL

## What is JSTL?

JSTL = JSP Standard Tag Library.

Provides predefined tags.

---

## Common JSTL Tags

| Tag       | Purpose     |
| --------- | ----------- |
| c:if      | Condition   |
| c:forEach | Loop        |
| c:set     | Set value   |
| c:out     | Print value |

---

## Example

```jsp
<c:if test="${age > 18}">
    Eligible
</c:if>
```

---

## Interview Question

### Why JSTL used?

JSTL reduces Java code in JSP.

---

# 25. Exception Handling in JSP

## Using errorPage

### Main JSP

```jsp
<%@ page errorPage="error.jsp" %>
```

---

### Error JSP

```jsp
<%@ page isErrorPage="true" %>
```

---

## Interview Answer

JSP exceptions handled using errorPage and isErrorPage directives.

---

# 26. JSP Include vs Forward

| Include                | Forward            |
| ---------------------- | ------------------ |
| Includes content       | Transfers control  |
| Current page continues | Current page stops |

---

# Include Example

```jsp
<jsp:include page="header.jsp" />
```

---

# Forward Example

```jsp
<jsp:forward page="home.jsp" />
```

---

# 27. MVC with JSP and Servlet

## MVC Flow

```text
Browser
   |
Servlet (Controller)
   |
DAO/Model
   |
Database
   |
JSP (View)
```

---

## Important Point

Best Practice:

```text
Servlet = Controller
JSP = View
DAO/Java = Model
```

---

## Interview Question

### Why JSP should not contain business logic?

Because JSP should focus only on presentation layer.

---

# 28. Login Flow using JSP + Servlet

## Flow

```text
login.jsp
   |
LoginServlet
   |
DAO/JDBC
   |
Database Validation
   |
Home.jsp
```

---

## Example

### login.jsp

```html
<form action="login" method="post">

    <input type="text" name="username">

    <input type="password" name="password">

    <input type="submit">

</form>
```

---

### Servlet

```java
String user = req.getParameter("username");
```

---

# 29. JSP Advantages

## Advantages

* Easy UI development
* Less Java code
* Faster development
* Better readability
* Reusable components

---

# 30. JSP Disadvantages

## Disadvantages

* Mixing Java + HTML
* Hard debugging
* Not suitable for business logic
* Large JSP becomes messy

---

# 31. Best Practices in JSP

## Best Practices

* Avoid scriptlets
* Use JSTL and EL
* Keep business logic in servlet/service
* Use MVC architecture
* Reuse header/footer using include
* Use proper session management
* Keep JSP clean

---

## Interview Question

### Why scriptlets avoided in modern projects?

Because business logic should not be mixed with presentation layer.

---

# 32. JSP Real-Time Project Structure

```text
Project
 |
 |-- jsp
 |     |-- login.jsp
 |     |-- home.jsp
 |
 |-- servlet
 |     |-- LoginServlet.java
 |
 |-- dao
 |     |-- UserDAO.java
 |
 |-- WEB-INF
 |     |-- web.xml
```

---

# 33. JSP Interview Questions

## Q1. What is JSP?

JSP is server-side technology used to create dynamic web pages.

---

## Q2. Difference between JSP and Servlet?

JSP used for presentation while servlet used for request handling/business logic.

---

## Q3. What happens internally when JSP executes?

JSP converts into servlet and then executes.

---

## Q4. What are implicit objects?

Objects automatically available in JSP.

---

## Q5. Difference between include directive and jsp:include?

Include directive works at translation time while jsp:include works at request time.

---

## Q6. What is EL?

EL is Expression Language used to access data easily in JSP.

---

## Q7. What is JSTL?

JSTL provides standard JSP tags.

---

## Q8. Why JSP better for UI?

Because HTML writing easier in JSP.

---

## Q9. Why scriptlets avoided?

Because they reduce readability and mix business logic with UI.

---

## Q10. What is jspInit()?

Initialization method called once.

---

## Q11. What is _jspService()?

Handles every request.

---

## Q12. What is jspDestroy()?

Called before JSP removal.

---

## Q13. What is JavaBean?

Reusable Java class with getter/setter methods.

---

## Q14. Difference between forward and include?

Forward transfers control while include adds content.

---

## Q15. Why MVC architecture used?

For separation of concerns and better maintainability.

---

# 34. Final Summary

```text
JSP = Java Server Pages.
Used for creating dynamic web pages.
Internally converted into Servlet.
Best used for UI/View layer.
Servlet handles controller/business logic.
Modern JSP development uses EL + JSTL instead of scriptlets.
MVC architecture recommended.
```
