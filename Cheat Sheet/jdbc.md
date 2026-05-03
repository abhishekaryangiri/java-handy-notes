# JDBC Complete Interview Revision Notes

# 1. JDBC Introduction

## What is JDBC?

JDBC (Java Database Connectivity) is a Java API used to connect Java applications with databases.

Using JDBC, Java applications can:

* Insert data
* Update data
* Delete data
* Fetch data

JDBC acts as a bridge between:

```text
Java Application <-> JDBC API <-> JDBC Driver <-> Database
```

Databases commonly used:

* MySQL
* PostgreSQL
* Oracle
* SQL Server

---

## Why JDBC is Used?

Before JDBC, Java applications had no standard way to communicate with databases.

JDBC provides:

* Standard API
* Database independence
* SQL execution support
* Transaction management
* Better security using PreparedStatement

---

## Interview Definition

"JDBC is a Java API that allows Java applications to communicate with relational databases and perform CRUD operations using SQL queries."

---

# 2. JDBC Architecture

## JDBC Architecture Flow

```text
Java Application
       |
       v
JDBC API
       |
       v
JDBC Driver
       |
       v
Database
```

---

## Components Explanation

### 1. Java Application

Application written in Java.

Example:

* Banking System
* Employee Management System
* Hospital Management System

---

### 2. JDBC API

Classes and interfaces provided by Java.

Package:

```java
import java.sql.*;
```

---

### 3. JDBC Driver

Driver converts Java commands into database-specific commands.

Example:

* MySQL Driver
* PostgreSQL Driver

---

### 4. Database

Stores data.

Example:

* MySQL
* PostgreSQL

---

## Interview Answer

"JDBC architecture contains Java Application, JDBC API, JDBC Driver, and Database. JDBC API sends requests to JDBC Driver, and driver communicates with database."

---

# 3. JDBC Drivers Types

There are 4 types of JDBC drivers.

---

## Type 1 Driver

### JDBC-ODBC Bridge Driver

```text
Java -> JDBC -> ODBC -> Database
```

### Disadvantages

* Slow
* Requires ODBC installation
* Removed from Java 8

---

## Type 2 Driver

### Native API Driver

Uses native database libraries.

### Disadvantages

* Platform dependent
* Native software required

---

## Type 3 Driver

### Network Protocol Driver

Uses middleware server.

### Advantages

* Platform independent

### Disadvantages

* Middleware required

---

## Type 4 Driver (Most Important)

### Thin Driver

```text
Java -> JDBC -> Database
```

### Advantages

* Fast
* Platform independent
* No middleware required
* Most commonly used

Examples:

* MySQL Connector/J
* PostgreSQL JDBC Driver

---

## Interview Question

### Which JDBC driver is mostly used?

Type 4 Driver because it is fast and platform independent.

---

# 4. JDBC API

JDBC API provides interfaces and classes for database connectivity.

Main package:

```java
java.sql
```

---

## Important Interfaces

| Interface         | Purpose                    |
| ----------------- | -------------------------- |
| Driver            | Database Driver            |
| Connection        | Create database connection |
| Statement         | Execute SQL                |
| PreparedStatement | Execute parameterized SQL  |
| CallableStatement | Call stored procedure      |
| ResultSet         | Store fetched data         |

---

## Important Classes

| Class         | Purpose               |
| ------------- | --------------------- |
| DriverManager | Manages drivers       |
| SQLException  | Handles DB exceptions |

---

# 5. java.sql Package

Contains all JDBC classes and interfaces.

Import statement:

```java
import java.sql.*;
```

---

## Commonly Used Classes/Interfaces

```text
Connection
Statement
PreparedStatement
CallableStatement
ResultSet
DriverManager
SQLException
```

---

# 6. JDBC Workflow

## JDBC Flow Steps

```text
1. Load Driver
2. Create Connection
3. Create Statement
4. Execute Query
5. Process Result
6. Close Connection
```

---

## Real Life Example

```text
Java App -> Sends SQL -> Database -> Returns Data
```

---

# 7. Loading Driver

Driver class loads database driver into memory.

## Syntax

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

---

## Why Needed?

* Registers driver with DriverManager
* Makes JDBC aware of database driver

---

## PostgreSQL Driver

```java
Class.forName("org.postgresql.Driver");
```

---

## Interview Point

In modern JDBC, explicit loading is often optional because drivers auto-load.

---

# 8. DriverManager

DriverManager manages JDBC drivers.

Used to create database connection.

---

## Syntax

```java
Connection con = DriverManager.getConnection(url, username, password);
```

---

## Example

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/test",
    "root",
    "root"
);
```

---

## Interview Answer

"DriverManager is a class used to establish connection between Java application and database."

---

# 9. Database Connection

Connection interface represents a connection between Java application and database.

---

## Example

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/test",
    "root",
    "root"
);
```

---

## Important Methods

| Method             | Purpose                   |
| ------------------ | ------------------------- |
| createStatement()  | Creates Statement         |
| prepareStatement() | Creates PreparedStatement |
| prepareCall()      | Creates CallableStatement |
| commit()           | Save transaction          |
| rollback()         | Undo transaction          |
| close()            | Close connection          |

---

## Interview Question

### What is Connection Interface?

Connection interface represents a session between Java application and database.

---

# 10. Connection Interface

Connection is one of the most important JDBC interfaces.

It is used for:

* Opening DB session
* Executing SQL
* Managing transactions
* Creating statements

---

## Example

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/company",
    "root",
    "root"
);
```

---

## Common Methods

```java
con.createStatement();
con.prepareStatement(sql);
con.commit();
con.rollback();
con.close();
```

---

# 11. Statement

Statement interface is used to execute normal SQL queries.

---

## Syntax

```java
Statement st = con.createStatement();
```

---

## Example

```java
Statement st = con.createStatement();

ResultSet rs = st.executeQuery("select * from emp");
```

---

## Disadvantages

* Slow
* SQL Injection possible
* Query compiled every time

---

## Interview Answer

"Statement interface is used to execute simple SQL queries without parameters."

---

# 12. PreparedStatement

PreparedStatement is used to execute parameterized queries.

It is:

* Faster
* More secure
* Prevents SQL Injection

---

## Syntax

```java
PreparedStatement ps = con.prepareStatement(sql);
```

---

## Example

```java
String sql = "insert into emp values(?, ?)";

PreparedStatement ps = con.prepareStatement(sql);

ps.setInt(1, 101);
ps.setString(2, "Rahul");

ps.executeUpdate();
```

---

## Advantages

* Better performance
* Secure
* Precompiled query
* Reusable

---

## Interview Question

### Why PreparedStatement is better than Statement?

PreparedStatement:

* Prevents SQL Injection
* Faster due to precompilation
* Supports parameters

---

# 13. CallableStatement

CallableStatement is used to call stored procedures.

---

## Syntax

```java
CallableStatement cs = con.prepareCall("{call myproc()}");
```

---

## Example

```java
CallableStatement cs = con.prepareCall("{call getEmployee()}");

ResultSet rs = cs.executeQuery();
```

---

## Interview Answer

"CallableStatement is used to execute stored procedures from Java application."

---

# 14. ResultSet

ResultSet stores data returned by SELECT query.

---

## Example

```java
Statement st = con.createStatement();

ResultSet rs = st.executeQuery("select * from emp");
```

---

## Fetching Data

```java
while(rs.next()) {
    System.out.println(rs.getInt(1));
    System.out.println(rs.getString(2));
}
```

---

## Important Methods

| Method      | Purpose       |
| ----------- | ------------- |
| next()      | Move cursor   |
| getInt()    | Fetch integer |
| getString() | Fetch string  |
| getDouble() | Fetch double  |

---

## Interview Question

### What is ResultSet?

ResultSet is an object that stores data returned from database after executing SELECT query.

---

# 15. executeQuery()

Used for SELECT queries.

Returns:

```text
ResultSet
```

---

## Example

```java
ResultSet rs = st.executeQuery("select * from emp");
```

---

## Interview Answer

executeQuery() is used for SELECT statements and returns ResultSet.

---

# 16. executeUpdate()

Used for:

* INSERT
* UPDATE
* DELETE

Returns:

```text
int
```

(Number of affected rows)

---

## Example

```java
int rows = st.executeUpdate(
    "update emp set name='Rahul' where id=1"
);
```

---

## Interview Question

### What does executeUpdate return?

It returns number of affected rows.

---

# 17. execute()

Used for any type of SQL query.

Returns:

```text
boolean
```

---

## Example

```java
boolean result = st.execute("select * from emp");
```

---

## Use Case

When query type is unknown.

---

# 18. CRUD Operations

CRUD means:

| Operation | SQL    |
| --------- | ------ |
| Create    | INSERT |
| Read      | SELECT |
| Update    | UPDATE |
| Delete    | DELETE |

---

# INSERT Example

```java
String sql = "insert into emp values(?, ?)";

PreparedStatement ps = con.prepareStatement(sql);

ps.setInt(1, 101);
ps.setString(2, "Aman");

ps.executeUpdate();
```

---

# SELECT Example

```java
ResultSet rs = st.executeQuery("select * from emp");
```

---

# UPDATE Example

```java
st.executeUpdate(
    "update emp set name='Ravi' where id=1"
);
```

---

# DELETE Example

```java
st.executeUpdate(
    "delete from emp where id=1"
);
```

---

# 19. SQL Injection

SQL Injection is a security vulnerability.

Occurs when user input directly becomes part of SQL query.

---

## Unsafe Example

```java
String sql = "select * from user where username='"
        + username +
        "' and password='" + password + "'";
```

Hackers can manipulate query.

---

## Solution

Use PreparedStatement.

---

## Safe Example

```java
PreparedStatement ps = con.prepareStatement(
    "select * from user where username=? and password=?"
);

ps.setString(1, username);
ps.setString(2, password);
```

---

## Interview Question

### How does PreparedStatement prevent SQL Injection?

PreparedStatement treats user input as data, not SQL command.

---

# 20. Statement vs PreparedStatement

| Statement              | PreparedStatement      |
| ---------------------- | ---------------------- |
| Dynamic query          | Precompiled query      |
| Slower                 | Faster                 |
| SQL Injection possible | Prevents SQL Injection |
| No parameters          | Supports parameters    |

---

## Interview Answer

PreparedStatement is preferred because it is secure, faster, reusable, and prevents SQL Injection.

---

# 21. ResultSet Methods

## next()

Moves cursor to next row.

```java
rs.next();
```

---

## getInt()

Fetch integer value.

```java
rs.getInt(1);
```

---

## getString()

Fetch string value.

```java
rs.getString(2);
```

---

## Complete Example

```java
while(rs.next()) {
    int id = rs.getInt(1);
    String name = rs.getString(2);

    System.out.println(id + " " + name);
}
```

---

# 22. PreparedStatement Methods

PreparedStatement provides setter methods.

---

## Common Methods

| Method      | Purpose     |
| ----------- | ----------- |
| setInt()    | Set integer |
| setString() | Set string  |
| setDouble() | Set double  |
| setDate()   | Set date    |

---

## Example

```java
PreparedStatement ps = con.prepareStatement(
    "insert into emp values(?, ?)"
);

ps.setInt(1, 101);
ps.setString(2, "Rahul");
```

---

# Important Interview Questions Revision

## 1. What is JDBC?

JDBC is a Java API used to connect Java applications with relational databases.

---

## 2. What are JDBC steps?

1. Load Driver
2. Create Connection
3. Create Statement
4. Execute Query
5. Process Result
6. Close Connection

---

## 3. Difference between Statement and PreparedStatement?

PreparedStatement is faster, secure, reusable, and prevents SQL Injection.

---

## 4. What is ResultSet?

ResultSet stores data returned by SELECT query.

---

## 5. Difference between executeQuery and executeUpdate?

* executeQuery() -> SELECT
* executeUpdate() -> INSERT UPDATE DELETE

---

## 6. Which JDBC driver is mostly used?

Type 4 Driver.

---

## 7. Why use PreparedStatement?

* Better performance
* Secure
* Prevent SQL Injection

---

## 8. What is SQL Injection?

Security vulnerability where malicious SQL is injected through user input.

---

# Full Basic JDBC Example

```java
import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) {

        try {

            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "root"
            );

            // 3. Prepare Query
            String sql = "insert into emp values(?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            // 4. Set Values
            ps.setInt(1, 101);
            ps.setString(2, "Rahul");

            // 5. Execute Query
            int rows = ps.executeUpdate();

            System.out.println(rows + " row inserted");

            // 6. Close Connection
            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

# 23. Batch Processing

## What is Batch Processing?

Batch Processing means executing multiple SQL queries together in one batch.

Instead of sending queries one by one to database, JDBC sends all queries together.

---

## Why Batch Processing?

Advantages:

* Faster execution
* Reduces database round trips
* Improves performance
* Useful for bulk insert/update

---

## Example

```java
Statement st = con.createStatement();

st.addBatch("insert into emp values(101, 'Rahul')");
st.addBatch("insert into emp values(102, 'Aman')");
st.addBatch("insert into emp values(103, 'Ravi')");

st.executeBatch();
```

---

## PreparedStatement Batch Example

```java
PreparedStatement ps = con.prepareStatement(
    "insert into emp values(?, ?)"
);

ps.setInt(1, 101);
ps.setString(2, "Rahul");
ps.addBatch();

ps.setInt(1, 102);
ps.setString(2, "Aman");
ps.addBatch();

ps.executeBatch();
```

---

## Interview Question

### Where is Batch Processing used?

Used in:

* Payroll systems
* Bulk employee insertion
* CSV/Excel data upload
* Banking systems

---

# 24. Transaction Management

## What is Transaction?

A transaction is a group of SQL operations executed as a single unit.

If all queries succeed -> commit
If any query fails -> rollback

---

## Real Life Example

### Bank Transfer

```text
Withdraw money from Account A
Deposit money into Account B
```

If second query fails, first query should also undo.

---

## Transaction Methods

```java
con.setAutoCommit(false);
con.commit();
con.rollback();
```

---

## Complete Example

```java
try {

    con.setAutoCommit(false);

    Statement st = con.createStatement();

    st.executeUpdate(
        "update account set balance=balance-1000 where id=1"
    );

    st.executeUpdate(
        "update account set balance=balance+1000 where id=2"
    );

    con.commit();

} catch(Exception e) {

    con.rollback();
}
```

---

## Interview Answer

"Transaction management ensures data consistency by executing multiple SQL queries as one unit."

---

# 25. AutoCommit

## What is AutoCommit?

By default, JDBC automatically commits every SQL query.

Default value:

```text
true
```

---

## Disable AutoCommit

```java
con.setAutoCommit(false);
```

---

## Why Disable?

Needed when multiple queries should execute together.

---

## Interview Question

### What is default AutoCommit mode?

Default AutoCommit mode is true.

---

# 26. commit()

## What is commit()?

commit() permanently saves transaction changes into database.

---

## Example

```java
con.commit();
```

---

## Interview Answer

commit() permanently saves all transaction operations.

---

# 27. rollback()

## What is rollback()?

rollback() undoes all transaction changes.

---

## Example

```java
con.rollback();
```

---

## Use Case

Used when exception occurs.

---

## Interview Answer

rollback() restores database to previous state if transaction fails.

---

# 28. SQLException Handling

## What is SQLException?

SQLException handles database-related exceptions.

---

## Example

```java
try {

    Connection con = DriverManager.getConnection(url, user, pass);

} catch(SQLException e) {

    e.printStackTrace();
}
```

---

## Important Methods

```java
e.getMessage();
e.getErrorCode();
e.getSQLState();
```

---

## Interview Question

### Why SQLException occurs?

Possible reasons:

* Wrong SQL query
* Database connection issue
* Wrong credentials
* Driver missing

---

# 29. ResultSetMetaData

## What is ResultSetMetaData?

Used to get information about table columns.

---

## Example

```java
ResultSet rs = st.executeQuery("select * from emp");

ResultSetMetaData rsmd = rs.getMetaData();

System.out.println(rsmd.getColumnCount());
System.out.println(rsmd.getColumnName(1));
```

---

## Important Methods

| Method              | Purpose       |
| ------------------- | ------------- |
| getColumnCount()    | Total columns |
| getColumnName()     | Column name   |
| getColumnTypeName() | Data type     |

---

## Interview Answer

ResultSetMetaData provides metadata information about ResultSet columns.

---

# 30. DatabaseMetaData

## What is DatabaseMetaData?

Provides information about database.

---

## Example

```java
DatabaseMetaData dbmd = con.getMetaData();

System.out.println(dbmd.getDatabaseProductName());
System.out.println(dbmd.getDriverName());
```

---

## Information Retrieved

* Database name
* Driver name
* Database version
* Supported features

---

## Interview Answer

DatabaseMetaData provides metadata about database and JDBC driver.

---

# 31. Stored Procedures

## What is Stored Procedure?

A stored procedure is precompiled SQL stored inside database.

---

## Advantages

* Faster execution
* Reusable
* Better security
* Reduced network traffic

---

## JDBC Example

```java
CallableStatement cs = con.prepareCall("{call getEmployee()}");

ResultSet rs = cs.executeQuery();
```

---

## Interview Answer

Stored procedures are database-side programs executed using CallableStatement.

---

# 32. Connection Pooling

## What is Connection Pooling?

Connection pooling means reusing database connections.

Instead of creating new connection every time, existing connections are reused.

---

## Why Needed?

Creating DB connection is expensive.

Connection pooling improves:

* Performance
* Scalability
* Speed

---

## Popular Connection Pools

* HikariCP
* Apache DBCP
* C3P0

---

## Interview Question

### Why connection pooling is used?

To improve application performance by reusing database connections.

---

# 33. DataSource

## What is DataSource?

DataSource is an alternative to DriverManager.

Used mainly in enterprise applications.

Supports:

* Connection pooling
* Better resource management

---

## Example

```java
DataSource ds;

Connection con = ds.getConnection();
```

---

## Interview Answer

DataSource is preferred over DriverManager in enterprise applications because it supports connection pooling.

---

# 34. try-with-resources

## What is try-with-resources?

Automatically closes JDBC resources.

---

## Example

```java
try(
    Connection con = DriverManager.getConnection(url, user, pass);
    PreparedStatement ps = con.prepareStatement("select * from emp");
) {

}
```

---

## Advantages

* Cleaner code
* Automatic resource closing
* Prevents memory leak

---

## Interview Question

### Why use try-with-resources?

To automatically close resources like Connection, Statement, and ResultSet.

---

# 35. JDBC with MySQL/PostgreSQL

## MySQL Driver

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

---

## MySQL URL

```java
jdbc:mysql://localhost:3306/test
```

---

## PostgreSQL Driver

```java
Class.forName("org.postgresql.Driver");
```

---

## PostgreSQL URL

```java
jdbc:postgresql://localhost:5432/test
```

---

## Interview Question

### Difference in JDBC for MySQL and PostgreSQL?

Mainly driver class name and JDBC URL differ.

---

# 36. DAO Pattern

## What is DAO?

DAO = Data Access Object.

Used to separate database logic from business logic.

---

## Benefits

* Clean architecture
* Easy maintenance
* Better code organization

---

## Flow

```text
Controller -> Service -> DAO -> Database
```

---

## DAO Example

```java
public class EmployeeDAO {

    public void saveEmployee(Employee e) {

    }
}
```

---

## Interview Answer

DAO pattern separates database operations from business logic.

---

# 37. MVC with JDBC

## MVC Architecture

```text
Model -> Business/Data
View -> UI
Controller -> Request Handling
```

---

## JDBC in MVC

* JSP = View
* Servlet = Controller
* DAO/JDBC = Model

---

## Flow

```text
User -> JSP -> Servlet -> DAO -> Database
```

---

## Interview Answer

In MVC architecture, JDBC code is generally written inside DAO layer.

---

# 38. JDBC Best Practices

## Best Practices

* Use PreparedStatement
* Close resources properly
* Use try-with-resources
* Use connection pooling
* Avoid hardcoded credentials
* Handle exceptions properly
* Use DAO pattern

---

## Interview Answer

PreparedStatement, connection pooling, and proper resource management are important JDBC best practices.

---

# 39. JDBC vs Hibernate

| JDBC             | Hibernate         |
| ---------------- | ----------------- |
| Low level API    | ORM Framework     |
| Manual SQL       | Automatic SQL     |
| More code        | Less code         |
| Faster sometimes | Easy development  |
| Manual mapping   | Automatic mapping |

---

## Interview Answer

JDBC provides direct database interaction while Hibernate is an ORM framework that simplifies database operations.

---

# 40. JDBC vs JPA

| JDBC             | JPA              |
| ---------------- | ---------------- |
| API              | Specification    |
| Manual SQL       | ORM approach     |
| Table-oriented   | Object-oriented  |
| More boilerplate | Less boilerplate |

---

## Interview Answer

JDBC works directly with SQL while JPA works using entity objects.

---

# 41. Scrollable ResultSet

## What is Scrollable ResultSet?

Allows cursor movement in any direction.

---

## Example

```java
Statement st = con.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE,
    ResultSet.CONCUR_READ_ONLY
);
```

---

## Cursor Methods

```java
rs.next();
rs.previous();
rs.first();
rs.last();
```

---

## Interview Answer

Scrollable ResultSet allows moving cursor forward and backward.

---

# 42. Updatable ResultSet

## What is Updatable ResultSet?

Allows updating database directly through ResultSet.

---

## Example

```java
Statement st = con.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE,
    ResultSet.CONCUR_UPDATABLE
);
```

---

## Update Example

```java
rs.next();
rs.updateString("name", "Rahul");
rs.updateRow();
```

---

## Interview Answer

Updatable ResultSet allows modification of database records directly from ResultSet.

---

# 43. ACID Properties

## What is ACID?

ACID properties ensure reliable transactions.

---

## A = Atomicity

Either complete transaction or none.

---

## C = Consistency

Database remains consistent.

---

## I = Isolation

Transactions do not interfere.

---

## D = Durability

Committed data remains saved permanently.

---

## Interview Answer

ACID properties ensure reliability, consistency, and safety of database transactions.

---

# 44. JDBC Real-Time Flow

## Real-Time Application Flow

```text
Frontend Form
      |
      v
Servlet/Controller
      |
      v
Service Layer
      |
      v
DAO Layer
      |
      v
JDBC API
      |
      v
Database
```

---

## Real-Time Example

### Employee Registration

```text
User enters data
-> Servlet receives request
-> DAO saves data using JDBC
-> Database stores employee
-> Success response shown
```

---

## Interview Answer

In real-time projects, JDBC is usually used inside DAO layer for database communication.

---

# One Line Revision

```text
JDBC = Java API for database connectivity.
Connection = Session with database.
Statement = Executes normal SQL.
PreparedStatement = Secure and faster SQL execution.
ResultSet = Stores fetched data.
executeQuery = SELECT.
executeUpdate = INSERT UPDATE DELETE.
CallableStatement = Calls stored procedures.
PreparedStatement prevents SQL Injection.
Type 4 Driver is most used.
```
