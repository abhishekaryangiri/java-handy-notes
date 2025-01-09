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






### **DOM (Document Object Model)** vs **Virtual DOM**: Detailed Explanation for Interview Purposes

Both **DOM** (Document Object Model) and **Virtual DOM** are essential concepts in web development, especially for working with JavaScript frameworks like React. Here’s a detailed explanation of each, their differences, and how they impact performance and rendering.

---

### **What is the DOM (Document Object Model)?**

The **DOM** is an **interface** that browsers implement, allowing scripts (like JavaScript) to dynamically interact with the content and structure of HTML and XML documents.

#### **Key Points about the DOM:**
- **Tree Structure**: The DOM represents the page as a hierarchical tree structure. Each HTML element, attribute, and piece of text is a node in this tree.
- **Dynamic Representation**: It provides a live, dynamic representation of the document. As JavaScript modifies the DOM, the changes are reflected in the page without requiring a reload.
- **Browser Interaction**: The DOM allows JavaScript to access, modify, add, and delete HTML elements dynamically.

#### **How it Works:**
1. **HTML Document Parsing**: When an HTML document is loaded, the browser parses it and constructs a DOM tree where each node corresponds to an HTML element.
2. **JavaScript Manipulation**: JavaScript can access the DOM through the `document` object, enabling you to manipulate elements, handle events, and modify the structure dynamically.

#### **Example**: Manipulating DOM
```html
<!DOCTYPE html>
<html>
<head>
  <title>DOM Example</title>
</head>
<body>
  <h1 id="header">Hello, World!</h1>
  <button onclick="changeText()">Change Text</button>

  <script>
    function changeText() {
      // Accessing the DOM element by ID
      const header = document.getElementById('header');
      header.textContent = 'Hello, DOM!';
    }
  </script>
</body>
</html>
```
In the example above, clicking the button triggers the JavaScript function `changeText()` which modifies the content of the `<h1>` tag by accessing it through the DOM.

---

### **What is the Virtual DOM?**

The **Virtual DOM** (VDOM) is an abstraction of the actual DOM. It is a lightweight copy of the real DOM and is mostly associated with modern JavaScript frameworks like **React**.

#### **Key Points about the Virtual DOM:**
- **In-Memory Representation**: The virtual DOM is an in-memory representation of the actual DOM. It’s a lightweight copy of the real DOM that React keeps track of.
- **Efficient Updates**: Instead of directly modifying the real DOM, the virtual DOM allows React to first make changes to the virtual representation, then efficiently update the real DOM in the most optimized way.
- **Rendering Optimization**: The virtual DOM minimizes expensive reflows and repaints by reducing the number of direct manipulations to the real DOM.

#### **How it Works:**
1. **Virtual DOM Creation**: When a component is rendered, React creates a virtual DOM representation of it (a JavaScript object).
2. **Re-rendering on State Changes**: When state or props change, React updates the virtual DOM first.
3. **Diffing Algorithm**: React compares the old virtual DOM with the new virtual DOM to identify the differences (or "diffs").
4. **Efficient Reconciliation**: Once the differences are found, React updates only the changed parts of the real DOM, rather than re-rendering the entire page.

#### **Example**: Virtual DOM in React
In React, when a state changes, React doesn't immediately touch the DOM. Instead, it updates the virtual DOM, compares it to the previous virtual DOM, and only applies the changes to the real DOM that were necessary.

```javascript
import React, { useState } from 'react';

const App = () => {
  const [text, setText] = useState('Hello, Virtual DOM!');
  
  return (
    <div>
      <h1>{text}</h1>
      <button onClick={() => setText('Hello, React!')}>Change Text</button>
    </div>
  );
};

export default App;
```

In the above React component:
1. The state (`text`) is initially set to "Hello, Virtual DOM!".
2. When the button is clicked, it triggers a state change to "Hello, React!".
3. React updates the virtual DOM first and compares it with the previous state.
4. Only the necessary updates (in this case, the `<h1>` tag) are applied to the real DOM.

---

### **DOM vs. Virtual DOM: Key Differences**

| **Aspect**             | **DOM**                                         | **Virtual DOM**                                   |
|------------------------|-------------------------------------------------|---------------------------------------------------|
| **Definition**          | A tree-like structure that represents HTML elements. | A lightweight in-memory copy of the real DOM.     |
| **Performance**         | Direct manipulation of the real DOM can be slower, especially with large updates. | More efficient updates through diffing and reconciliation. |
| **Updates**             | Any changes require reflow and repaint in the browser, which can be expensive. | Updates are done in memory first, and then the minimal changes are applied to the real DOM. |
| **Rendering**           | Renders the entire page or changes the entire DOM tree. | Only the changed parts are rendered or updated.   |
| **Usage**               | Used by browsers to represent web pages.       | Used by JavaScript frameworks like React for optimized rendering. |
| **Interaction**         | Direct interaction with the HTML elements.      | Indirect interaction with the real DOM, through the virtual representation. |

---

### **Advantages of Virtual DOM**

1. **Performance Optimization**: Virtual DOM reduces the number of expensive DOM manipulations, improving overall performance. By diffing the virtual DOM before applying changes to the real DOM, React avoids unnecessary reflows and repaints.
   
2. **Faster UI Updates**: Updates in React are efficient because only the parts of the real DOM that changed are updated. This is much faster than directly manipulating the entire DOM every time an update is needed.

3. **Declarative UI**: With the Virtual DOM, developers describe what the UI should look like at any given point in time, and React takes care of updating the real DOM. This leads to simpler and more maintainable code.

---

### **DOM Manipulation Challenges**
- **Performance Issues**: Direct manipulation of the DOM can lead to performance bottlenecks, especially when many updates happen rapidly.
- **Complexity in Repainting**: When updating large portions of the UI, browsers must repaint large sections, which can be slow.
- **Reflow and Repaint**: Each modification of the DOM can trigger reflows and repaints, which can degrade performance.

---

### **Conclusion**

- **DOM** is the standard interface for manipulating HTML/XML documents in the browser. It's essential for accessing and modifying webpage elements.
- **Virtual DOM** is an abstraction used by libraries like React to optimize updates to the real DOM. It improves performance by minimizing direct DOM manipulations, resulting in faster and more efficient rendering.

Both concepts are crucial, but **Virtual DOM** primarily serves to optimize DOM manipulations, making modern front-end frameworks like React more performant and user-friendly.










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

### Q23: How do you use the `.map()` method in JavaScript?
**Answer**: The `.map()` method is used to create a new array by applying a callback function to each element of an existing array.

```javascript
let numbers = [1, 2, 3, 4];
let squaredNumbers = numbers.map(num => num * num);
console.log(squaredNumbers); // Output: [1, 4, 9, 16]
```
Explanation:

The map() method iterates over the numbers array.
For each element, the callback function (num => num * num) is executed.
A new array, squaredNumbers, is returned containing the squared values.

### 24: How do you use the .filter() method in JavaScript?
Answer: The .filter() method is used to create a new array containing elements that pass a specific test defined in the callback function.
```javascript
let numbers = [1, 2, 3, 4, 5];
let evenNumbers = numbers.filter(num => num % 2 === 0);
console.log(evenNumbers); // Output: [2, 4]
```
Explanation:

The filter() method iterates over the numbers array.
Each element is checked using the callback function (num => num % 2 === 0).
Only elements that satisfy the condition (even numbers) are included in the new array evenNumbers.
### Q25: How do you use the .reduce() method in JavaScript?
Answer: The .reduce() method is used to reduce an array to a single value by executing a callback function on each element, with an accumulator carrying over the result.

```javascript
let numbers = [1, 2, 3, 4];
let sum = numbers.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
console.log(sum); // Output: 10
```
### Q26: How do you create a `Map` and add key-value pairs?
**Answer**: Use the `Map` object and its `.set()` method to add key-value pairs.

```javascript
let myMap = new Map();
myMap.set("name", "Alice");
myMap.set("age", 25);
myMap.set("city", "New York");
console.log(myMap);
// Output: Map(3) { 'name' => 'Alice', 'age' => 25, 'city' => 'New York' }
```
### Q27: How do you access a value in a Map?
Answer: Use the .get() method and pass the key.
```javascript
console.log(myMap.get("name")); // Output: Alice
console.log(myMap.get("age"));  // Output: 25
```
### Q28: How do you check if a key exists in a Map?
Answer: Use the .has() method.

```javascript
console.log(myMap.has("city"));  // Output: true
console.log(myMap.has("country")); // Output: false
```
### Q29: How do you remove a key-value pair from a Map?
Answer: Use the .delete() method.
```javascript
Copy code
myMap.delete("age");
console.log(myMap); 
// Output: Map(2) { 'name' => 'Alice', 'city' => 'New York' }
```
### Q30: How do you iterate over a Map?
Answer: Use the .forEach() method or for...of loops.
```javascript
Copy code
// Using forEach
myMap.forEach((value, key) => {
  console.log(`${key}: ${value}`);
});
// Output:
// name: Alice
// city: New York
// Using for...of
for (let [key, value] of myMap) {
  console.log(`${key}: ${value}`);
}
```
### Q31: Create a Map to count the occurrences of each character in a string.
Write a function that takes a string and returns a Map with characters as keys and their frequencies as values.
```javascript
function charFrequency(str) {
  let frequencyMap = new Map();
  for (let char of str) {
    frequencyMap.set(char, (frequencyMap.get(char) || 0) + 1);
  }
  return frequencyMap;
}
console.log(charFrequency("hello"));
// Output: Map(4) { 'h' => 1, 'e' => 1, 'l' => 2, 'o' => 1 }
```
### Q32: Find the first non-repeating character in a string using Map.
Write a function that returns the first character with a frequency of 1.

```javascrip
function firstNonRepeatingChar(str) {
  let frequencyMap = charFrequency(str);
  for (let char of str) {
    if (frequencyMap.get(char) === 1) {
      return char;
    }
  }
  return null;
}
console.log(firstNonRepeatingChar("swiss"));
// Output: 'w'
```
### Q33: Use Map to group words by their length.
Given an array of words, group them into a Map where the keys are word lengths and the values are arrays of words.
```javascript
function groupByLength(words) {
  let lengthMap = new Map();
  for (let word of words) {
    let length = word.length;
    if (!lengthMap.has(length)) {
      lengthMap.set(length, []);
    }
    lengthMap.get(length).push(word);
  }
  return lengthMap;
}
console.log(groupByLength(["apple", "bat", "cat", "banana"]));
// Output: Map(3) { 5 => [ 'apple' ], 3 => [ 'bat', 'cat' ], 6 => [ 'banana' ] }
```
### Q34: Implement a simple caching mechanism using Map.
Create a function that caches the results of an expensive computation.
```javascript
function expensiveComputation(x) {
  return x * x; // Simulate a complex computation
}

function cachedComputation(x, cache = new Map()) {
  if (cache.has(x)) {
    return cache.get(x);
  }
  let result = expensiveComputation(x);
  cache.set(x, result);
  return result;
}
let cache = new Map();
console.log(cachedComputation(5, cache)); // Output: 25
console.log(cachedComputation(5, cache)); // Cached result: 25
```
### Q35: Find common elements between two arrays using Map.
Write a function that takes two arrays and returns their intersection.
```javascript
function findIntersection(arr1, arr2) {
  let map = new Map();
  let result = [];
  for (let num of arr1) {
    map.set(num, true);
  }
  
  for (let num of arr2) {
    if (map.has(num)) {
      result.push(num);
    }
  }
  return result;
}
console.log(findIntersection([1, 2, 3, 4], [3, 4, 5, 6]));
// Output: [3, 4]
```
### Q36: Store User Data in a `Map` and Access It
Create a `Map` to store user data with the `id` as the key and an object containing `name` and `email` as the value. Write a function to fetch user details by `id`.
```javascript
let users = new Map();
users.set(1, { name: "Alice", email: "alice@example.com" });
users.set(2, { name: "Bob", email: "bob@example.com" });
users.set(3, { name: "Charlie", email: "charlie@example.com" });
function getUserById(id) {
  return users.get(id) || "User not found";
}
console.log(getUserById(2)); 
// Output: { name: 'Bob', email: 'bob@example.com' }
console.log(getUserById(4)); 
// Output: User not found
```
### Q37: Access Users with Odd or Even IDs
Write a function that filters and returns all users with odd or even id values from the Map.
```javascript
function getUsersByIdParity(users, isEven) {
  let result = [];
  for (let [id, data] of users) {
    if ((id % 2 === 0) === isEven) {
      result.push({ id: id, name: data.name, email: data.email });
      // Using spread operator:
      // result.push({ id, ...data });
    }
  }
  return result;
}

console.log(getUsersByIdParity(users, true)); 
// Output: [ { id: 2, name: 'Bob', email: 'bob@example.com' } ]
console.log(getUsersByIdParity(users, false)); 
// Output: [ { id: 1, name: 'Alice', email: 'alice@example.com' }, { id: 3, name: 'Charlie', email: 'charlie@example.com' } ]
```
### Q38: Find All Users with a Specific Email Domain
Write a function that filters users by their email domain (e.g., "example.com") and returns the matching users.
```javascript
function getUsersByEmailDomain(users, domain) {
  let result = [];
  for (let [id, data] of users) {
    if (data.email.endsWith(domain)) {
      result.push({ id: id, name: data.name, email: data.email });
      // Using spread operator:
      // result.push({ id, ...data });
    }
  }
  return result;
}

console.log(getUsersByEmailDomain(users, "example.com")); 
// Output: [
//   { id: 1, name: 'Alice', email: 'alice@example.com' },
//   { id: 2, name: 'Bob', email: 'bob@example.com' },
//   { id: 3, name: 'Charlie', email: 'charlie@example.com' }
// ]
```
### Q39: Count Users by Name Length
Write a function that groups and counts users based on the length of their names.
```javascript
function countUsersByNameLength(users) {
  let nameLengthMap = new Map();
  for (let [id, data] of users) {
    let length = data.name.length;
    if (!nameLengthMap.has(length)) {
      nameLengthMap.set(length, 0);
    }
    nameLengthMap.set(length, nameLengthMap.get(length) + 1);
  }
  return nameLengthMap;
}
console.log(countUsersByNameLength(users)); 
// Output: Map(2) { 5 => 2, 7 => 1 }
```
### Q40: Remove Users with Specific Conditions
Write a function to remove all users with id greater than a given number from the Map.
```javascript
function removeUsersByIdCondition(users, maxId) {
  for (let id of users.keys()) {
    if (id > maxId) {
      users.delete(id);
    }
  }
}

removeUsersByIdCondition(users, 2);
console.log(users);
// Output: Map(2) { 
//   1 => { name: 'Alice', email: 'alice@example.com' }, 
//   2 => { name: 'Bob', email: 'bob@example.com' } 
// }
```
### Q341: Get Users Sorted by ID
Write a function to return all users sorted by their id.
```javascript
function getUsersSortedById(users) {
  let result = [];
  let sortedEntries = Array.from(users.entries()).sort((a, b) => a[0] - b[0]);
  for (let [id, data] of sortedEntries) {
    result.push({ id: id, name: data.name, email: data.email });
    // Using spread operator:
    // result.push({ id, ...data });
  }
  return result;
}

console.log(getUsersSortedById(users)); 
// Output: [
//   { id: 1, name: 'Alice', email: 'alice@example.com' },
//   { id: 2, name: 'Bob', email: 'bob@example.com' }
// ]
```
### Q42: Check if All Users Have Valid Emails
Write a function to verify if all users in the Map have a valid email (contain @ and a domain).
```javascript
function areAllEmailsValid(users) {
  for (let data of users.values()) {
    if (!data.email.includes("@") || !data.email.split("@")[1]) {
      return false;
    }
  }
  return true;
}

console.log(areAllEmailsValid(users)); 
// Output: true
```
