Here is a detailed **JavaScript Cheat Sheet** with explanations, terminology, and use cases for each topic, specifically designed for full-stack developers. 

---

### **1. JavaScript Basics**

#### **Variables**
Variables are used to store data values.

- **`var`**: The old way of declaring variables, function-scoped (only accessible within the function in which they are declared). Not commonly used in modern JavaScript due to potential issues with hoisting and scope confusion.
  - Example: 
    ```javascript
    var name = 'Alice';
    ```

- **`let`**: Modern way to declare variables, block-scoped (accessible only within the block where it’s declared).
  - Example:
    ```javascript
    let age = 25;
    ```

- **`const`**: Used to declare constants (values that cannot be reassigned), block-scoped.
  - Example:
    ```javascript
    const pi = 3.14;
    ```

#### **Data Types**
JavaScript has two types of data types: **primitive** and **reference** types.

- **Primitive Types**: Direct values, immutable.
  - `string`: Represents text. Example: `'Hello World'`
  - `number`: Represents numeric values. Example: `10`, `3.14`
  - `boolean`: Represents `true` or `false`.
  - `undefined`: A variable that has not been assigned a value.
  - `null`: Represents the intentional absence of a value.
  - `symbol`: Represents a unique value used for object property keys.
  
- **Reference Types**: Stores references to objects.
  - `object`: A collection of key-value pairs. Example: `{name: "Alice", age: 25}`
  - `array`: A special type of object used for storing ordered collections. Example: `[1, 2, 3]`
  - `function`: A block of reusable code.

---

### **2. Control Flow**

#### **Conditionals**
Conditionals are used to perform different actions based on different conditions.

- **`if`-`else`**:
  ```javascript
  let age = 20;
  if (age >= 18) {
    console.log("You are an adult.");
  } else {
    console.log("You are a minor.");
  }
  ```

- **`switch-case`**: Used when we have multiple conditions to evaluate.
  ```javascript
  let fruit = "apple";
  switch (fruit) {
    case "apple":
      console.log("Apple is selected.");
      break;
    case "banana":
      console.log("Banana is selected.");
      break;
    default:
      console.log("No fruit selected.");
  }
  ```

#### **Loops**
Loops are used to execute a block of code repeatedly.

- **`for` loop**: Used when you know in advance how many times you want to execute a statement.
  ```javascript
  for (let i = 0; i < 5; i++) {
    console.log(i);  // prints numbers from 0 to 4
  }
  ```

- **`while` loop**: Executes the code block as long as the condition is true.
  ```javascript
  let i = 0;
  while (i < 5) {
    console.log(i);
    i++;
  }
  ```

- **`do-while` loop**: Similar to `while`, but guarantees the code runs at least once.
  ```javascript
  let i = 0;
  do {
    console.log(i);
    i++;
  } while (i < 5);
  ```

- **`for-in` loop**: Used for iterating over object properties.
  ```javascript
  let person = { name: "Alice", age: 25 };
  for (let key in person) {
    console.log(key, person[key]);
  }
  ```

- **`for-of` loop**: Used for iterating over iterable objects (like arrays).
  ```javascript
  let fruits = ["apple", "banana", "cherry"];
  for (let fruit of fruits) {
    console.log(fruit);  // prints each fruit
  }
  ```

---

### **3. Functions**

Functions are blocks of code that are designed to perform a particular task.

- **Function Declaration**: A named function defined using the `function` keyword.
  ```javascript
  function add(a, b) {
    return a + b;
  }
  console.log(add(3, 4));  // 7
  ```

- **Function Expression**: A function defined within an expression, often used with anonymous functions.
  ```javascript
  const subtract = function(a, b) {
    return a - b;
  };
  console.log(subtract(7, 2));  // 5
  ```

- **Arrow Functions** (ES6): A shorter syntax for writing functions. Arrow functions also do not have their own `this`, which is important in certain contexts like callbacks.
  ```javascript
  const multiply = (a, b) => a * b;
  console.log(multiply(2, 3));  // 6
  ```

- **Callback Functions**: Functions passed as arguments to other functions, used to handle asynchronous tasks or control flow.
  ```javascript
  function greet(name, callback) {
    console.log("Hello " + name);
    callback();
  }

  greet("Alice", function() {
    console.log("Callback executed!");
  });
  ```

---

### **4. Objects**

Objects are collections of key-value pairs used to store data.

- **Creating Objects**:
  ```javascript
  let person = {
    name: "Alice",
    age: 30,
    greet: function() {
      console.log("Hello!");
    }
  };
  ```

- **Accessing Object Properties**:
  ```javascript
  console.log(person.name);  // Dot notation
  console.log(person["age"]);  // Bracket notation
  ```

- **Adding/Modifying Properties**:
  ```javascript
  person.address = "123 Main St";  // Adding
  person.age = 31;  // Modifying
  ```

- **Deleting Properties**:
  ```javascript
  delete person.age;  // Deletes the age property
  ```

- **Object Destructuring** (ES6): A convenient way to extract multiple properties from an object into variables.
  ```javascript
  const { name, age } = person;
  console.log(name, age);  // Alice 30
  ```

---

### **5. Arrays**

Arrays are ordered collections used to store multiple values.

- **Creating Arrays**:
  ```javascript
  let fruits = ["apple", "banana", "cherry"];
  ```

- **Accessing Array Elements**:
  ```javascript
  console.log(fruits[0]);  // apple
  ```

- **Array Methods**:
  - **push()**: Adds an item to the end.
    ```javascript
    fruits.push("date");
    ```

  - **pop()**: Removes the last item.
    ```javascript
    fruits.pop();
    ```

  - **shift()**: Removes the first item.
    ```javascript
    fruits.shift();
    ```

  - **unshift()**: Adds an item to the beginning.
    ```javascript
    fruits.unshift("grape");
    ```

  - **forEach()**: Executes a function for each element.
    ```javascript
    fruits.forEach(function(item) {
      console.log(item);
    });
    ```

  - **map()**: Returns a new array by transforming each element.
    ```javascript
    let lengths = fruits.map(fruit => fruit.length);
    ```

  - **filter()**: Filters elements based on a condition.
    ```javascript
    let longFruits = fruits.filter(fruit => fruit.length > 5);
    ```

  - **reduce()**: Accumulates a single result from the array.
    ```javascript
    let totalLength = fruits.reduce((sum, fruit) => sum + fruit.length, 0);
    ```

---

### **6. Error Handling**

Error handling is essential for graceful degradation of functionality when something goes wrong.

- **try-catch-finally**: Used for handling exceptions.
  ```javascript
  try {
    let result = riskyFunction();
  } catch (error) {
    console.error("An error occurred:", error);
  } finally {
    console.log("This always runs");
  }
  ```

---

### **7. Date and Time**

JavaScript provides the `Date` object to work with dates and times.

- **Creating Date Objects**:
  ```javascript
  let now = new Date();  // Current date and time
  let birthday = new Date("1995-12-17");
  ```

- **Getting Date Parts**:
  ```javascript
  console.log(now.getFullYear());  // Current year
  console.log(now.getMonth());     // Current month (0-11)
  console.log(now.getDate());      // Current day of the month
  ```

- **Setting Date Parts**:
  ```javascript
  now.setFullYear(2025);
  now.setMonth(5);
  now.setDate(15);
  ```

---

### **8. Regular Expressions**

Regular expressions are patterns used to match character combinations in strings.

- **Creating a Regular Expression**:
  ```javascript
  let pattern = /abc/;  // Pattern to match "abc"
  ```

- **Testing a Regular Expression**:
  ```javascript
  console.log(pattern.test("abcdef"));  // true
  ```

- **

Matching a Regular Expression**:
  ```javascript
  let str = "hello world";
  let matches = str.match(/world/);  // ["world"]
  ```

- **Replacing with Regular Expressions**:
  ```javascript
  let newStr = "hello world".replace(/world/, "universe");
  console.log(newStr);  // "hello universe"
  ```




--------------------------------------------


Here’s a detailed list of **JavaScript interview questions** for developers, specifically focusing on concepts **excluding ES6**. These questions are designed to test your knowledge of core JavaScript principles, and understanding these will help you ace most interviews.

### **1. Basic JavaScript Concepts**

#### **Q1: What are the different data types in JavaScript?**
**Answer**: JavaScript has **7 primitive types** and **1 non-primitive type**:
- **Primitive types**: `undefined`, `null`, `boolean`, `number`, `string`, `symbol`, `bigint`
- **Non-primitive types**: `object` (which includes arrays, functions, and more)

#### **Q2: What is the difference between `null` and `undefined`?**
**Answer**:
- **`null`**: Represents the intentional absence of any object value. It is an assignment value.
  ```javascript
  let x = null;  // x is explicitly set to null
  ```
- **`undefined`**: Means a variable has been declared but has not been assigned any value yet.
  ```javascript
  let y;
  console.log(y);  // undefined
  ```

#### **Q3: What is the `typeof` operator?**
**Answer**: The `typeof` operator is used to return the type of a variable or an expression.
  ```javascript
  let age = 25;
  console.log(typeof age);  // "number"
  ```

#### **Q4: What is the difference between `==` and `===`?**
**Answer**:
- **`==` (loose equality)**: Compares values for equality after type coercion.
- **`===` (strict equality)**: Compares both value and type, without type coercion.
  ```javascript
  console.log(2 == '2');   // true (type coercion occurs)
  console.log(2 === '2');  // false (no type coercion)
  ```

---

### **2. Functions and Scope**

#### **Q5: What is a function in JavaScript?**
**Answer**: A function is a block of reusable code that performs a specific task. Functions are defined using the `function` keyword.
  ```javascript
  function greet(name) {
    console.log("Hello, " + name);
  }
  greet("Alice");  // "Hello, Alice"
  ```

#### **Q6: What is the difference between function declaration and function expression?**
**Answer**:
- **Function Declaration**: A named function defined using the `function` keyword.
  ```javascript
  function add(a, b) {
    return a + b;
  }
  ```
- **Function Expression**: A function defined within an expression and can be anonymous.
  ```javascript
  var multiply = function(a, b) {
    return a * b;
  };
  ```

#### **Q7: What is the scope of a variable in JavaScript?**
**Answer**: JavaScript variables have different scopes:
- **Global Scope**: Variables declared outside any function are in the global scope.
- **Function Scope**: Variables declared inside a function are local to that function.
- **Block Scope**: With `let` and `const`, variables can be scoped to a block (e.g., loops, conditionals).

#### **Q8: What are closures in JavaScript?**
**Answer**: A closure is a function that retains access to its lexical scope, even when the function is executed outside that scope.
  ```javascript
  function outer() {
    let outerVar = 'I am outside!';
    function inner() {
      console.log(outerVar);
    }
    return inner;
  }
  const myClosure = outer();
  myClosure();  // "I am outside!"
  ```

---

### **3. Arrays and Objects**

#### **Q9: How do you create an array in JavaScript?**
**Answer**: An array can be created using the `Array` constructor or array literal notation.
  ```javascript
  let fruits = ["apple", "banana", "cherry"];
  let numbers = new Array(1, 2, 3, 4);
  ```

#### **Q10: How do you access elements in an array?**
**Answer**: Array elements are accessed using their **index**.
  ```javascript
  let fruits = ["apple", "banana", "cherry"];
  console.log(fruits[0]);  // "apple"
  ```

#### **Q11: What is the difference between an array and an object?**
**Answer**:
- **Array**: Ordered collection of items, accessed by numerical indices.
- **Object**: Unordered collection of key-value pairs, accessed by keys (properties).
  ```javascript
  let fruit = { name: "apple", color: "red" };
  console.log(fruit.name);  // "apple"
  ```

#### **Q12: How can you iterate over an array?**
**Answer**: There are multiple ways to iterate over an array:
- **`for` loop**:
  ```javascript
  for (let i = 0; i < fruits.length; i++) {
    console.log(fruits[i]);
  }
  ```
- **`forEach()` method**:
  ```javascript
  fruits.forEach(function(fruit) {
    console.log(fruit);
  });
  ```

---

### **4. Loops and Iterations**

#### **Q13: What is the difference between a `for` loop and a `while` loop?**
**Answer**:
- **`for` loop**: Best used when you know in advance how many times the loop should run.
  ```javascript
  for (let i = 0; i < 5; i++) {
    console.log(i);  // prints 0 to 4
  }
  ```
- **`while` loop**: Runs as long as the condition is true. It may run zero or more times.
  ```javascript
  let i = 0;
  while (i < 5) {
    console.log(i);
    i++;
  }
  ```

#### **Q14: What is a `for-in` loop and when would you use it?**
**Answer**: A `for-in` loop is used to iterate over the **keys** of an object.
  ```javascript
  let person = { name: "Alice", age: 30 };
  for (let key in person) {
    console.log(key, person[key]);
  }
  ```

#### **Q15: What is a `for-of` loop and when would you use it?**
**Answer**: A `for-of` loop is used to iterate over **iterable objects** (arrays, strings, etc.).
  ```javascript
  let fruits = ["apple", "banana", "cherry"];
  for (let fruit of fruits) {
    console.log(fruit);  // prints each fruit in the array
  }
  ```

---

### **5. Object and Array Methods**

#### **Q16: How do you add a property to an object?**
**Answer**: You can add properties using dot notation or bracket notation.
  ```javascript
  let person = { name: "Alice", age: 30 };
  person.city = "New York";  // Dot notation
  person["country"] = "USA"; // Bracket notation
  ```

#### **Q17: How do you remove a property from an object?**
**Answer**: Use the `delete` operator.
  ```javascript
  delete person.age;  // Removes the 'age' property
  ```

#### **Q18: What are array methods `push()`, `pop()`, `shift()`, and `unshift()`?**
**Answer**:
- **`push()`**: Adds one or more elements to the end of an array.
  ```javascript
  fruits.push("orange");  // Adds "orange" to the end
  ```
- **`pop()`**: Removes the last element from an array.
  ```javascript
  fruits.pop();  // Removes "orange"
  ```
- **`shift()`**: Removes the first element from an array.
  ```javascript
  fruits.shift();  // Removes the first element
  ```
- **`unshift()`**: Adds one or more elements to the beginning of an array.
  ```javascript
  fruits.unshift("kiwi");  // Adds "kiwi" to the start
  ```

---

### **6. Error Handling**

#### **Q19: What is the `try...catch` block in JavaScript?**
**Answer**: The `try...catch` block allows you to handle exceptions that may occur during code execution. The `catch` block executes if an error is thrown.
  ```javascript
  try {
    let result = riskyFunction();
  } catch (error) {
    console.error("An error occurred:", error);
  }
  ```

#### **Q20: What is the `finally` block?**
**Answer**: The `finally` block executes after `try` and `catch`, regardless of whether an exception was thrown.
  ```javascript
  try {
    let result = riskyFunction();
  } catch (error) {
    console.error("An error occurred:", error);
  } finally {
    console.log("This always runs");
  }
  ```

---

### **7. Miscellaneous**

#### **Q21: What is the difference between `call()`, `apply()`, and `bind()`?**
**Answer**:
- **`call()`**: Calls a function with a specified `this` value and arguments.
  ```javascript
  function

 greet() {
    console.log(`Hello, ${this.name}`);
  }
  const person = { name: "Alice" };
  greet.call(person);  // "Hello, Alice"
  ```
- **`apply()`**: Similar to `call()`, but arguments are passed as an array.
  ```javascript
  greet.apply(person);  // "Hello, Alice"
  ```
- **`bind()`**: Returns a new function with the specified `this` value and arguments.
  ```javascript
  const greetAlice = greet.bind(person);
  greetAlice();  // "Hello, Alice"
  ```

#### **Q22: What is the `setTimeout()` and `setInterval()` functions?**
**Answer**:
- **`setTimeout()`**: Executes a function after a specified delay (in milliseconds).
  ```javascript
  setTimeout(() => {
    console.log("Hello after 2 seconds");
  }, 2000);
  ```
- **`setInterval()`**: Executes a function repeatedly at specified intervals (in milliseconds).
  ```javascript
  setInterval(() => {
    console.log("This runs every 2 seconds");
  }, 2000);
  ```

--------------------------------------------
