### Java 8 के महत्वपूर्ण फीचर्स:

1. **Lambda Expressions**: कोड को छोटा और readable बनाने के लिए।  
   ```java
   List<Integer> list = Arrays.asList(1, 2, 3, 4);
   list.forEach(x -> System.out.println(x));
   ```

2. **Stream API**: Collection data को प्रोसेस और manipulate करने के लिए।  
   ```java
   List<String> names = Arrays.asList("Ram", "Shyam", "Mohan");
   names.stream().filter(x -> x.startsWith("S")).forEach(System.out::println);
   ```

3. **Default Methods**: Interface में methods को default implementation देने के लिए।  
   ```java
   interface MyInterface {
       default void show() {
           System.out.println("Default Method");
       }
   }
   ```

4. **Optional Class**: NullPointerException से बचने के लिए।  
   ```java
   Optional<String> optional = Optional.ofNullable(null);
   System.out.println(optional.orElse("Default Value"));
   ```

5. **Date and Time API**: नया `java.time` package date और time को manage करने के लिए।  
   ```java
   LocalDate today = LocalDate.now();
   System.out.println(today);
   ```

---

### Java 8 पर आधारित टॉप 8-10 बेसिक DSA प्रश्न:  

#### 1. **दो Arrays को merge करके sort करना**  
```java
import java.util.*;
import java.util.stream.*;

public class MergeAndSortArrays {
    public static void main(String[] args) {
        int[] arr1 = {5, 8, 9};
        int[] arr2 = {4, 7, 2};

        // Arrays को merge और sort करना
        int[] mergedArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                                     .sorted()
                                     .toArray();

        System.out.println("Sorted Array: " + Arrays.toString(mergedArray));
    }
}
```

#### 2. **Array में unique elements को count करना**  
```java
import java.util.*;

public class UniqueElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};

        long count = Arrays.stream(arr).distinct().count();
        System.out.println("Unique Elements Count: " + count);
    }
}
```

#### 3. **Array में duplicates को हटाना**  
```java
import java.util.*;
import java.util.stream.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};

        int[] uniqueArr = Arrays.stream(arr).distinct().toArray();
        System.out.println("Array without Duplicates: " + Arrays.toString(uniqueArr));
    }
}
```

#### 4. **String में vowels count करना**  
```java
import java.util.stream.*;

public class VowelCount {
    public static void main(String[] args) {
        String str = "Java Programming";

        long count = str.toLowerCase()
                        .chars()
                        .filter(c -> "aeiou".indexOf(c) != -1)
                        .count();

        System.out.println("Vowel Count: " + count);
    }
}
```

#### 5. **Palindrome चेक करना (String)**  
```java
public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";

        boolean isPalindrome = str.equals(new StringBuilder(str).reverse().toString());
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
```

#### 6. **किसी Array में दूसरा सबसे बड़ा element ढूंढना**  
```java
import java.util.*;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 7};

        int secondLargest = Arrays.stream(arr)
                                  .boxed()
                                  .sorted(Comparator.reverseOrder())
                                  .distinct()
                                  .skip(1)
                                  .findFirst()
                                  .get();

        System.out.println("Second Largest Element: " + secondLargest);
    }
}
```

#### 7. **String में character frequency count करना**  
```java
import java.util.*;
import java.util.stream.*;

public class CharacterFrequency {
    public static void main(String[] args) {
        String str = "hello";

        Map<Character, Long> frequency = str.chars()
                                            .mapToObj(c -> (char) c)
                                            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("Character Frequency: " + frequency);
    }
}
```

#### 8. **Array में subarray sum 0 है या नहीं चेक करना**  
```java
import java.util.*;

public class SubarraySumZero {
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        boolean found = false;

        for (int num : arr) {
            sum += num;
            if (set.contains(sum) || sum == 0) {
                found = true;
                break;
            }
            set.add(sum);
        }

        System.out.println("Subarray with sum 0 exists: " + found);
    }
}
```

#### 9. **String के हर शब्द का पहला letter uppercase करना**  
```java
import java.util.stream.*;

public class CapitalizeWords {
    public static void main(String[] args) {
        String str = "java programming language";

        String result = Stream.of(str.split(" "))
                              .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                              .collect(Collectors.joining(" "));

        System.out.println("Capitalized String: " + result);
    }
}
```

#### 10. **Array में continuous subarray का maximum sum (Kadane's Algorithm)**  
```java
public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = Integer.MIN_VALUE, currentSum = 0;

        for (int num : arr) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
}
```
यहाँ Java 8 आधारित **10 और DSA प्रश्न** दिए गए हैं जो इंटरव्यू के लिए उपयोगी हैं:  

---
---
### 1. **किसी Array में Kth सबसे बड़ा element ढूंढना**  
```java
import java.util.*;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int kthLargest = Arrays.stream(arr)
                               .boxed()
                               .sorted(Comparator.reverseOrder())
                               .distinct()
                               .skip(k - 1)
                               .findFirst()
                               .get();

        System.out.println("Kth Largest Element: " + kthLargest);
    }
}
```

---

### 2. **Array में missing number ढूंढना (1 to N)**  
```java
import java.util.stream.*;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        int n = 8; // Maximum number in array

        int sum = IntStream.rangeClosed(1, n).sum();
        int actualSum = Arrays.stream(arr).sum();

        System.out.println("Missing Number: " + (sum - actualSum));
    }
}
```

---

### 3. **Array में pair ढूंढना जिनका sum K है**  
```java
import java.util.*;

public class PairWithSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(target - num)) {
                System.out.println("Pair: (" + num + ", " + (target - num) + ")");
                return;
            }
            map.put(num, 1);
        }
    }
}
```

---

### 4. **Array को reverse करना**  
```java
import java.util.*;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int[] reversedArray = IntStream.range(0, arr.length)
                                       .map(i -> arr[arr.length - 1 - i])
                                       .toArray();

        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
    }
}
```

---

### 5. **Matrix को transpose करना**  
```java
import java.util.*;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int n = matrix.length;
        int[][] transpose = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transpose of Matrix:");
        for (int[] row : transpose) {
            System.out.println(Arrays.toString(row));
        }
    }
}
```

---

### 6. **String को reverse करना (Words भी reverse)**  
```java
import java.util.stream.*;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Java Programming Language";

        String reversed = Stream.of(str.split(" "))
                                .map(word -> new StringBuilder(word).reverse().toString())
                                .collect(Collectors.joining(" "));

        System.out.println("Reversed String: " + reversed);
    }
}
```

---

### 7. **Array में majority element ढूंढना (N/2 से ज्यादा बार)**  
```java
import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};

        int n = arr.length;
        Optional<Integer> majority = Arrays.stream(arr)
                                           .boxed()
                                           .filter(x -> Collections.frequency(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)), x) > n / 2)
                                           .findFirst();

        System.out.println("Majority Element: " + majority.orElse(-1));
    }
}
```

---

### 8. **Array को Zig-Zag pattern में sort करना**  
```java
import java.util.*;

public class ZigZagArray {
    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        boolean flag = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (flag && arr[i] > arr[i + 1] || !flag && arr[i] < arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            flag = !flag;
        }

        System.out.println("Zig-Zag Array: " + Arrays.toString(arr));
    }
}
```

---

### 9. **Array में subarray का product K के बराबर है या नहीं**  
```java
import java.util.*;

public class SubarrayProductK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 6};
        int k = 100;

        int product = 1, count = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            product *= arr[i];
            while (j <= i && product >= k) {
                product /= arr[j++];
            }
            count += i - j + 1;
        }

        System.out.println("Subarray count with product less than " + k + ": " + count);
    }
}
```

---

### 10. **Array में सभी permutations generate करना**  
```java
import java.util.*;

public class ArrayPermutations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        permute(arr, 0, result);
        System.out.println("All Permutations: " + result);
    }

    private static void permute(int[] arr, int start, List<List<Integer>> result) {
        if (start == arr.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : arr) current.add(num);
            result.add(current);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            permute(arr, start + 1, result);
            swap(arr, i, start);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

---

### 1. **Array को rotate करना (K positions)**  
```java
import java.util.*;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        k = k % arr.length; // Avoid extra rotations
        int[] rotated = IntStream.concat(Arrays.stream(Arrays.copyOfRange(arr, arr.length - k, arr.length)),
                                          Arrays.stream(Arrays.copyOfRange(arr, 0, arr.length - k)))
                                 .toArray();

        System.out.println("Rotated Array: " + Arrays.toString(rotated));
    }
}
```

---

### 2. **Array में सबसे छोटा positive missing number ढूंढना**  
```java
import java.util.*;

public class SmallestPositiveMissing {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};

        int smallestMissing = Arrays.stream(arr)
                                    .filter(x -> x > 0)
                                    .distinct()
                                    .sorted()
                                    .reduce(1, (missing, num) -> (num == missing) ? missing + 1 : missing);

        System.out.println("Smallest Positive Missing Number: " + smallestMissing);
    }
}
```

---

### 3. **String में anagrams को group करना**  
```java
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> grouped = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        System.out.println("Grouped Anagrams: " + grouped.values());
    }
}
```

---

### 4. **String के characters को frequency के हिसाब से sort करना**  
```java
import java.util.*;
import java.util.stream.*;

public class SortByFrequency {
    public static void main(String[] args) {
        String str = "tree";

        String sorted = str.chars()
                           .mapToObj(c -> (char) c)
                           .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                           .entrySet()
                           .stream()
                           .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                           .flatMap(e -> Stream.generate(() -> e.getKey()).limit(e.getValue()))
                           .map(String::valueOf)
                           .collect(Collectors.joining());

        System.out.println("Sorted by Frequency: " + sorted);
    }
}
```

---

### 5. **Array में leader elements को ढूंढना**  
```java
import java.util.*;

public class LeaderElements {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders = new ArrayList<>();

        int maxFromRight = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        Collections.reverse(leaders);
        System.out.println("Leader Elements: " + leaders);
    }
}
```

---

### 6. **Array में equilibrium index ढूंढना**  
```java
import java.util.*;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};

        int totalSum = Arrays.stream(arr).sum();
        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];
            if (leftSum == totalSum) {
                System.out.println("Equilibrium Index: " + i);
                return;
            }
            leftSum += arr[i];
        }

        System.out.println("No Equilibrium Index Found");
    }
}
```

---

### 7. **Array में longest consecutive sequence का length ढूंढना**  
```java
import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }

                longestStreak = Math.max(longestStreak, streak);
            }
        }

        System.out.println("Longest Consecutive Sequence: " + longestStreak);
    }
}
```

---

### 8. **String में duplicate characters को हटाना**  
```java
import java.util.*;

public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        String str = "programming";

        String result = str.chars()
                           .distinct()
                           .mapToObj(c -> String.valueOf((char) c))
                           .collect(Collectors.joining());

        System.out.println("String without Duplicates: " + result);
    }
}
```

---

### 9. **किसी Array में सभी subarrays को generate करना**  
```java
public class GenerateSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }
}
```

---

### 10. **Matrix में spiral traversal करना**  
```java
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) System.out.print(matrix[top][i] + " ");
            top++;
            for (int i = top; i <= bottom; i++) System.out.print(matrix[i][right] + " ");
            right--;
            if (top <= bottom) for (int i = right; i >= left; i--) System.out.print(matrix[bottom][i] + " ");
            bottom--;
            if (left <= right) for (int i = bottom; i >= top; i--) System.out.print(matrix[i][left] + " ");
            left++;
        }
    }
}
```

---

Java 8 ने कई महत्वपूर्ण features पेश किए, जो इंटरव्यू में अक्सर पूछे जाते हैं। यहां Java 8 के **मुख्य फीचर्स** और उनके **इंटरव्यू पर्पस से महत्व** को समझाया गया है:  

---

### 1. **Lambda Expressions**  
Lambda Expression, concise तरीके से **functions** को define करने का तरीका है।  
#### Syntax:  
```java
(parameters) -> expression
```
#### उदाहरण:  
```java
List<String> names = Arrays.asList("John", "Doe", "Jane");
names.forEach(name -> System.out.println(name));
```
#### **इंटरव्यू सवाल:**  
1. Lambda Expressions का उपयोग क्यों करते हैं?  
   - Code को short और readable बनाने के लिए।  
2. Functional Interface क्या है और यह Lambda से कैसे जुड़ा है?  
   - Functional Interface एक interface है जिसमें केवल एक abstract method होता है। Lambda Expressions इसका implementation करते हैं।  

---

### 2. **Functional Interfaces**  
Java 8 में कुछ predefined functional interfaces दिए गए हैं:  
- **Predicate** (boolean-valued function)
- **Consumer** (input लेता है, output नहीं देता)  
- **Supplier** (output देता है, input नहीं लेता)  
- **Function** (input और output दोनों के लिए)  

#### उदाहरण:  
```java
import java.util.function.*;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // Output: true
    }
}
```
#### **इंटरव्यू सवाल:**  
1. Functional Interfaces और उनके उपयोग को समझाएं।  
2. Default और Static Methods का उपयोग Functional Interfaces में क्यों हुआ?  

---

### 3. **Stream API**  
Stream API का उपयोग large data collections पर operations के लिए किया जाता है।  
#### Key Features:  
- Lazy Evaluation  
- Parallel Streams  
- Functional Programming Style  
#### उदाहरण:  
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squares = numbers.stream()
                                .map(x -> x * x)
                                .collect(Collectors.toList());
System.out.println(squares); // Output: [1, 4, 9, 16, 25]
```
#### **इंटरव्यू सवाल:**  
1. Stream API और Collections में अंतर बताएं।  
2. Intermediate और Terminal operations क्या हैं?  

---

### 4. **Default Methods**  
Interfaces में methods को default implementation के साथ define करने की सुविधा है।  
#### उदाहरण:  
```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car implements Vehicle {}
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
    }
}
```
#### **इंटरव्यू सवाल:**  
1. Default Methods क्यों पेश किए गए?  
   - Multiple inheritance problems को solve करने और backward compatibility के लिए।  

---

### 5. **Optional Class**  
NullPointerException को avoid करने के लिए Optional class का उपयोग होता है।  
#### उदाहरण:  
```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("Default Name")); // Output: Default Name
    }
}
```
#### **इंटरव्यू सवाल:**  
1. Optional का उपयोग कब और क्यों करें?  
2. Optional के `of()`, `ofNullable()` और `empty()` methods में अंतर बताएं।  

---

### 6. **Method References**  
Lambda Expressions को और ज्यादा readable बनाने के लिए method references का उपयोग किया जाता है।  
#### उदाहरण:  
```java
List<String> names = Arrays.asList("John", "Doe", "Jane");
names.forEach(System.out::println); // Method Reference
```
#### **इंटरव्यू सवाल:**  
1. Method References के प्रकार (Static, Instance, Constructor)।  
2. Method Reference और Lambda में क्या अंतर है?  

---

### 7. **Date and Time API**  
Java 8 ने **java.time** package पेश किया, जो immutable और thread-safe है।  
#### उदाहरण:  
```java
import java.time.*;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);
    }
}
```
#### **इंटरव्यू सवाल:**  
1. Java 8 Date/Time API और पुरानी Date/Calendar API में अंतर।  
2. TimeZones के साथ कैसे काम करेंगे?  

---

### 8. **Streams with Parallel Processing**  
#### उदाहरण:  
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.parallelStream()
       .forEach(System.out::println); // Parallel Execution
```
#### **इंटरव्यू सवाल:**  
1. Parallel Streams और Sequential Streams में अंतर।  
2. Parallel Streams में performance impact।  

---

### 9. **Collectors**  
Stream API के परिणाम को संग्रहित करने के लिए Collectors का उपयोग होता है।  
#### उदाहरण:  
```java
List<String> names = Arrays.asList("John", "Doe", "Jane");
String joined = names.stream()
                     .collect(Collectors.joining(", "));
System.out.println(joined); // Output: John, Doe, Jane
```
#### **इंटरव्यू सवाल:**  
1. Collectors के विभिन्न methods (toList, toSet, groupingBy) क्या हैं?  

---

### 10. **Base64 Encoding and Decoding**  
Java 8 ने Base64 encoding/decoding को support करने के लिए classes पेश की।  
#### उदाहरण:  
```java
import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String text = "Hello, Java 8!";
        String encoded = Base64.getEncoder().encodeToString(text.getBytes());
        System.out.println("Encoded: " + encoded);

        String decoded = new String(Base64.getDecoder().decode(encoded));
        System.out.println("Decoded: " + decoded);
    }
}
```
#### **इंटरव्यू सवाल:**  
1. Base64 Encoding/Decoding का उपयोग कहाँ करें?  
2. Base64 के Basic, URL, और MIME Encoders में क्या अंतर है?  

---

### Java 8 Features को क्यों याद रखें?  
Java 8 ने functional programming को Java में introduce किया, जिससे performance, readability, और productivity बढ़ी। Interviewers अक्सर Java 8 के उपयोग को जानना चाहते हैं क्योंकि ये features industry-standard बन चुके हैं।

---

---
यहाँ Java 8 के महत्वपूर्ण features और उनसे जुड़े **इंटरव्यू प्रश्नों के उत्तर** दिए गए हैं। ये उत्तर concise और इंटरव्यू में पूछे जाने वाले practical aspects पर आधारित हैं:  

---

### **1. Lambda Expressions**  
#### प्रश्न 1: Lambda Expressions क्या हैं?  
**उत्तर:**  
Lambda Expression functions को concise और readable तरीके से define करने का तरीका है। यह anonymous functions की तरह काम करता है। Syntax:  
```java
(parameters) -> expression  
(parameters) -> { multiple statements }
```

#### प्रश्न 2: Lambda Expressions के फायदे बताएं।  
**उत्तर:**  
- कोड readable और short होता है।  
- Functional programming को सपोर्ट करता है।  
- Collection APIs में functional operations (map, filter, reduce) का उपयोग आसान बनाता है।  

---

### **2. Functional Interfaces**  
#### प्रश्न 1: Functional Interface क्या है?  
**उत्तर:**  
Functional Interface एक interface है जिसमें केवल एक abstract method होता है। Java 8 में Lambda Expressions इन्हीं का implementation करते हैं। उदाहरण: `Runnable`, `Callable`, `Predicate` आदि।  

#### प्रश्न 2: Functional Interfaces में default और static methods का क्या उपयोग है?  
**उत्तर:**  
- Default methods backward compatibility के लिए हैं।  
- Static methods utility methods define करने के लिए उपयोगी हैं।  

---

### **3. Stream API**  
#### प्रश्न 1: Stream API क्या है?  
**उत्तर:**  
Stream API का उपयोग collections और arrays पर functional-style operations करने के लिए होता है। यह data processing tasks (filtering, mapping, reducing) को आसान बनाता है।  

#### प्रश्न 2: Intermediate और Terminal operations में क्या अंतर है?  
**उत्तर:**  
- **Intermediate Operations**: Lazy होती हैं और एक नया Stream लौटाती हैं। जैसे `filter()`, `map()`, `sorted()`।  
- **Terminal Operations**: Stream को consume करती हैं और non-stream result देती हैं। जैसे `collect()`, `forEach()`, `reduce()`।  

---

### **4. Default Methods**  
#### प्रश्न 1: Default Methods का उपयोग क्यों किया गया?  
**उत्तर:**  
Interface में नए methods को जोड़ने पर backward compatibility बनाए रखने के लिए।  

#### प्रश्न 2: क्या Default Methods multiple inheritance problems को हल कर सकते हैं?  
**उत्तर:**  
Java में multiple inheritance conflicts को default methods हल कर सकते हैं। यदि दो interfaces में समान default method है, तो implementing class को इसे override करना होगा।  

---

### **5. Optional Class**  
#### प्रश्न 1: Optional Class का उपयोग कब और क्यों करें?  
**उत्तर:**  
Optional Class का उपयोग NullPointerException को avoid करने के लिए किया जाता है। यह `null` values को handle करने के लिए safe तरीका प्रदान करता है।  

#### प्रश्न 2: Optional के `of()`, `ofNullable()`, और `empty()` methods में अंतर बताएं।  
**उत्तर:**  
- `of()`: Non-null value के लिए उपयोग होता है। अगर null दिया तो Exception।  
- `ofNullable()`: Null और Non-null दोनों को handle करता है।  
- `empty()`: Empty Optional लौटाता है।  

---

### **6. Method References**  
#### प्रश्न 1: Method References क्या हैं?  
**उत्तर:**  
Lambda Expressions को और readable बनाने के लिए method references का उपयोग किया जाता है। यह class और methods को refer करता है।  

#### प्रश्न 2: Method References के प्रकार बताएं।  
**उत्तर:**  
- Static method reference: `ClassName::methodName`  
- Instance method reference: `object::methodName`  
- Constructor reference: `ClassName::new`  

---

### **7. Date and Time API**  
#### प्रश्न 1: Java 8 की Date/Time API और पुरानी Date/Calendar API में क्या अंतर है?  
**उत्तर:**  
- Java 8 API immutable और thread-safe है।  
- Modern methods प्रदान करता है, जैसे `LocalDate`, `LocalTime`, और `ZonedDateTime`।  
- Formatting और parsing आसान है।  

#### प्रश्न 2: Time Zones के साथ कैसे काम करेंगे?  
**उत्तर:**  
Java 8 का `ZonedDateTime` class time zones के साथ काम करने की सुविधा देता है।  

---

### **8. Streams with Parallel Processing**  
#### प्रश्न 1: Parallel Streams और Sequential Streams में क्या अंतर है?  
**उत्तर:**  
- **Sequential Streams**: एक के बाद एक items process करता है।  
- **Parallel Streams**: Items को multiple threads में parallel process करता है।  

#### प्रश्न 2: Parallel Streams का performance impact क्या है?  
**उत्तर:**  
- Parallel Streams multi-core processors पर performance improve कर सकते हैं।  
- छोटे datasets पर overhead ज्यादा हो सकता है।  

---

### **9. Collectors**  
#### प्रश्न 1: Collectors क्या हैं और इनका उपयोग कब होता है?  
**उत्तर:**  
Collectors, Stream results को एक data structure (List, Set, Map) में collect करने के लिए उपयोग होते हैं।  
उदाहरण:  
```java
List<String> names = Arrays.asList("John", "Doe");
List<String> result = names.stream().collect(Collectors.toList());
```

#### प्रश्न 2: Collectors के कुछ महत्वपूर्ण methods बताएं।  
**उत्तर:**  
- `toList()`: Stream को List में collect करता है।  
- `toSet()`: Stream को Set में collect करता है।  
- `groupingBy()`: Stream elements को groups में divide करता है।  
- `joining()`: Strings को concatenate करता है।  

---

### **10. Base64 Encoding/Decoding**  
#### प्रश्न 1: Base64 Encoding का उपयोग क्यों करते हैं?  
**उत्तर:**  
Base64 Encoding binary data को text format में convert करने के लिए उपयोग होता है, ताकि data को आसानी से transfer किया जा सके।  

#### प्रश्न 2: Base64 Encoding के प्रकार बताएं।  
**उत्तर:**  
- **Basic Encoder**: Standard encoding।  
- **URL Encoder**: Special characters (like `+`, `/`, `=`) को URL-safe characters में convert करता है।  
- **MIME Encoder**: MIME types के साथ multi-line encoding के लिए उपयोगी।  

---

