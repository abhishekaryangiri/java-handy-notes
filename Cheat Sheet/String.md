### **Java String Cheat Sheet with Detailed Explanation**

Strings are one of the most commonly used data types in Java. A `String` in Java is a sequence of characters that is immutable, meaning it cannot be changed once it is created. Below is a comprehensive Java String Cheat Sheet, covering essential topics, methods, and interview questions.

---

### **1. String Basics**

- **String Declaration**:
  ```java
  String str = "Hello, World!";  // String Literal
  String str2 = new String("Hello, Java!");  // Using the constructor
  ```

- **String Immutability**:
  - Once a string object is created, it cannot be changed. Any modifications to the string result in the creation of a new string.
  
---

### **2. String Methods in Java**

- **`length()`**: Returns the length of the string.
  ```java
  String str = "Hello";
  System.out.println(str.length());  // Output: 5
  ```

- **`charAt(index)`**: Returns the character at the specified index.
  ```java
  String str = "Hello";
  System.out.println(str.charAt(1));  // Output: 'e'
  ```

- **`substring(startIndex, endIndex)`**: Returns a new string that is a substring of the original string.
  ```java
  String str = "Hello, World!";
  System.out.println(str.substring(7, 12));  // Output: 'World'
  ```

- **`equals(String other)`**: Compares two strings for equality.
  ```java
  String str1 = "hello";
  String str2 = "hello";
  System.out.println(str1.equals(str2));  // Output: true
  ```
# Comparison of `==` Operator and `.equals()` Method

## `==` Operator
- **Purpose**: Compares:
  - **Primitives**: For value equality.
  - **Objects**: For reference equality (checks if two references point to the same memory location).
- **Key Points**:
  - Works at the **memory address level** for objects.
  - Does **not compare content** of objects.
  - For primitives, it checks **actual values**.

### Example:
```java
// Primitive comparison
int a = 5;
int b = 5;
System.out.println(a == b); // true (values are equal)

// Object reference comparison
String s1 = new String("Hello");
String s2 = new String("Hello");
System.out.println(s1 == s2); // false (different references)
```
-**.equals() Method**:
**Purpose:** 
- Compares content of objects (logical equality), not references.
**Default Behavior:**
  - In Object class, it checks reference equality but is often overridden by classes like String, Integer, etc., to compare content.
**Key Points:**
- Used for logical equality comparisons.
- Can be overridden in custom classes.
- Safe for comparing complex objects or strings.

```java
// Content comparison
String s1 = new String("Hello");
String s2 = new String("Hello");
System.out.println(s1.equals(s2)); // true (content is the same)

// Custom object example
Integer i1 = 100;
Integer i2 = 100;
System.out.println(i1.equals(i2)); // true (compares actual value)
```
**Key Differences**
- Aspect	== Operator	.equals() Method
- Comparison	Reference equality for objects.	Content equality (if overridden).
- Primitives	Compares actual values.	Not applicable.
**Default Behavior:**
- Checks memory address for objects.	
- Checks memory address (default in Object).
**Overridable?:**
- No.	Yes (commonly overridden).
-Null Handling	Can throw NullPointerException.	Safe for null values (if handled).
-Objects.equals() Utility Method
**Purpose:**
- Null-safe method to compare objects, introduced in Java 7 to avoid NullPointerException.
**Key Points:**
- Handles null values gracefully.
- Ideal for comparisons where null safety is critical.
Example:
```java
String s1 = null;
String s2 = "Hello";
System.out.println(Objects.equals(s1, s2)); // false
System.out.println(Objects.equals(s1, null)); // true
```
- **`equalsIgnoreCase(String other)`**: Compares two strings ignoring case.
  ```java
  String str1 = "HELLO";
  String str2 = "hello";
  System.out.println(str1.equalsIgnoreCase(str2));  // Output: true
  ```

- **`concat(String other)`**: Concatenates the specified string to the end of the original string.
  ```java
  String str = "Hello";
  System.out.println(str.concat(", World!"));  // Output: "Hello, World!"
  ```

- **`indexOf(String str)`**: Returns the index of the first occurrence of the specified substring.
  ```java
  String str = "Hello, World!";
  System.out.println(str.indexOf("World"));  // Output: 7
  ```

- **`contains(CharSequence sequence)`**: Checks if the string contains the specified sequence.
  ```java
  String str = "Hello, World!";
  System.out.println(str.contains("World"));  // Output: true
  ```

- **`replace(CharSequence old, CharSequence new)`**: Replaces all occurrences of a specified substring with a new substring.
  ```java
  String str = "Hello, World!";
  System.out.println(str.replace("World", "Java"));  // Output: "Hello, Java!"
  ```

- **`toUpperCase()`**: Converts all characters in the string to uppercase.
  ```java
  String str = "hello";
  System.out.println(str.toUpperCase());  // Output: "HELLO"
  ```

- **`toLowerCase()`**: Converts all characters in the string to lowercase.
  ```java
  String str = "HELLO";
  System.out.println(str.toLowerCase());  // Output: "hello"
  ```

- **`trim()`**: Removes leading and trailing spaces.
  ```java
  String str = "  Hello  ";
  System.out.println(str.trim());  // Output: "Hello"
  ```

---

### **3. StringBuffer and StringBuilder**

- **StringBuffer**:
  - StringBuffer is a mutable sequence of characters. It is thread-safe but slower than `StringBuilder` due to synchronization.
  
  ```java
  StringBuffer sb = new StringBuffer("Hello");
  sb.append(", World!");
  System.out.println(sb);  // Output: "Hello, World!"
  ```

- **StringBuilder**:
  - StringBuilder is similar to StringBuffer but it is not thread-safe and is faster for single-threaded applications.
  
  ```java
  StringBuilder sb = new StringBuilder("Hello");
  sb.append(", World!");
  System.out.println(sb);  // Output: "Hello, World!"
  ```

---

### **4. String Pool**

- **String Pool**: In Java, strings are stored in a special memory region called the "String Pool" or "String Constant Pool." When you create a string literal, Java checks the pool. If the string is already in the pool, it returns the reference; otherwise, it adds the new string.

  ```java
  String s1 = "Hello";
  String s2 = "Hello";
  System.out.println(s1 == s2);  // Output: true (same reference)
  ```

---

### **5. String vs StringBuffer vs StringBuilder**

| **Feature**              | **String**         | **StringBuffer**  | **StringBuilder** |
|--------------------------|--------------------|-------------------|-------------------|
| **Immutability**          | Immutable          | Mutable           | Mutable           |
| **Thread Safety**         | No                 | Yes               | No                |
| **Performance**           | Slow (due to immutability) | Faster (due to mutability and thread-safety) | Faster (non-thread-safe) |
| **Use Case**              | When the string will not change | When the string changes frequently in multi-threaded environments | When the string changes frequently in single-threaded environments |

---

### **6. Common String Interview Questions**

---

#### **1. How do you check if two strings are anagrams?**

**Explanation**:
An anagram is a word formed by rearranging the letters of another word.

```java
public class Anagram {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));  // Output: true
    }
}
```

---

#### **2. Find the longest substring without repeating characters.**

**Explanation**:
We can solve this problem by using a sliding window approach.

```java
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));  // Output: 3
    }
}
```

---

#### **3. Reverse a string without using library functions.**

**Explanation**:
You can reverse a string using a `for` loop and building the string manually.

```java
public class ReverseString {
    public static String reverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello"));  // Output: "olleH"
    }
}
```

---

#### **4. How to convert a String to an Integer?**

**Explanation**:
You can use `Integer.parseInt()` to convert a string to an integer.

```java
String str = "1234";
int num = Integer.parseInt(str);
System.out.println(num);  // Output: 1234
```

To handle potential exceptions (if the string is not a valid number):

```java
try {
    int num = Integer.parseInt(str);
} catch (NumberFormatException e) {
    System.out.println("Invalid number format");
}
```

---

#### **5. How to find the first non-repeated character in a string?**

**Explanation**:
You can iterate through the string and use a map or frequency count to find the first non-repeated character.

```java
public class FirstNonRepeatedChar {
    public static char firstNonRepeated(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : str.toCharArray()) {
            if (map.get(c) == 1) return c;
        }
        return '-';  // No unique character found
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeated("swiss"));  // Output: "w"
    }
}
```

---

### **7. Conclusion**

This cheat sheet covers the most important methods and concepts related to Java Strings, including methods for manipulation, common operations, and frequently asked interview questions. Understanding these concepts thoroughly will help you in both practical development and during interviews.
