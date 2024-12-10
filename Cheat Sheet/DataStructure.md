### **Data Structures Cheat Sheet with Detailed Explanation**

Data structures are essential components of computer science and programming. They help in organizing and managing data efficiently, and knowing the right data structure for a particular problem is key to solving it optimally. Below is a detailed explanation of the most common data structures along with key operations, characteristics, and interview question solutions.

---

### **1. Arrays**

#### **Definition:**
An array is a collection of elements that are stored in contiguous memory locations. It allows accessing elements by their index.

#### **Key Operations:**
- **Access**: O(1) — Direct access to elements using the index.
- **Search**: O(n) — Linear search for an element.
- **Insert**: O(n) — Inserting at the beginning or middle requires shifting elements.
- **Delete**: O(n) — Deleting an element from the beginning or middle requires shifting elements.

#### **Example:**
```java
int[] arr = {1, 2, 3, 4, 5};
System.out.println(arr[2]); // Output: 3
```

---

### **2. Linked Lists**

#### **Definition:**
A linked list is a linear collection of nodes, where each node contains data and a reference to the next node in the list. It can be:
- **Singly Linked List**: Each node points to the next node.
- **Doubly Linked List**: Each node points to both the next and previous nodes.
- **Circular Linked List**: The last node points to the first node.

#### **Key Operations:**
- **Access**: O(n) — To access an element, you must traverse the list.
- **Insert**: O(1) — Inserting at the beginning or end is O(1).
- **Delete**: O(1) — Deleting a node when you have a reference to it is O(1).

#### **Example (Singly Linked List):**
```java
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

### **3. Stacks**

#### **Definition:**
A stack is a linear data structure that follows the **LIFO (Last In, First Out)** principle, meaning elements are added and removed from the top of the stack.

#### **Key Operations:**
- **Push**: O(1) — Add an element to the stack.
- **Pop**: O(1) — Remove the top element.
- **Peek**: O(1) — View the top element.

#### **Example:**
```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
System.out.println(stack.pop());  // Output: 3
```

---

### **4. Queues**

#### **Definition:**
A queue is a linear data structure that follows the **FIFO (First In, First Out)** principle, meaning elements are added to the rear and removed from the front.

#### **Key Operations:**
- **Enqueue**: O(1) — Add an element to the rear.
- **Dequeue**: O(1) — Remove an element from the front.
- **Front**: O(1) — View the front element.

#### **Example:**
```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);
queue.offer(2);
queue.offer(3);
System.out.println(queue.poll());  // Output: 1
```

---

### **5. Hash Tables (Hash Maps)**

#### **Definition:**
A hash table (or hash map) stores key-value pairs and uses a hash function to compute the index for storing values. It provides fast access for searching, insertion, and deletion operations.

#### **Key Operations:**
- **Insert**: O(1) — Average time complexity for inserting an element.
- **Search**: O(1) — Average time complexity for searching by key.
- **Delete**: O(1) — Average time complexity for deleting by key.

#### **Example:**
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("a", 1);
map.put("b", 2);
System.out.println(map.get("a"));  // Output: 1
```

---

### **6. Trees**

#### **Definition:**
A tree is a hierarchical data structure that consists of nodes connected by edges. A **binary tree** is a tree in which each node has at most two children (left and right).

#### **Types of Trees**:
- **Binary Search Tree (BST)**: A binary tree with nodes such that the left child is less than the parent node, and the right child is greater.
- **AVL Tree**: A self-balancing binary search tree.
- **Heap**: A complete binary tree where the parent node is either greater (max-heap) or smaller (min-heap) than its children.

#### **Key Operations**:
- **Insertion**: O(log n) for balanced trees (e.g., AVL trees), O(n) for unbalanced trees.
- **Search**: O(log n) for balanced trees, O(n) for unbalanced trees.
- **Deletion**: O(log n) for balanced trees, O(n) for unbalanced trees.

#### **Example (Binary Search Tree)**:
```java
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
```

---

### **7. Graphs**

#### **Definition:**
A graph is a collection of vertices (nodes) and edges (connections between nodes). Graphs can be:
- **Directed**: Edges have a direction.
- **Undirected**: Edges do not have a direction.
- **Weighted**: Edges have weights associated with them.

#### **Key Operations:**
- **DFS (Depth-First Search)**: Explores a graph by going deep into each branch before backtracking.
- **BFS (Breadth-First Search)**: Explores a graph level by level, starting from a root node.

---

### **8. Heaps**

#### **Definition:**
A heap is a special tree-based data structure that satisfies the **heap property**. It can be a max-heap (parent node is greater than its children) or a min-heap (parent node is smaller than its children).

#### **Key Operations:**
- **Insert**: O(log n) — Insert a new element while maintaining the heap property.
- **Extract**: O(log n) — Extract the root (min or max) element.

---

## **Data Structures Interview Questions**

Here are some commonly asked interview questions on data structures with their solutions:

---

### **1. Find the Maximum Subarray Sum (Kadane's Algorithm)**

**Problem**: Given an array, find the contiguous subarray that has the largest sum.

**Solution**: Use Kadane’s Algorithm, which iterates through the array while maintaining the current maximum subarray sum and the global maximum sum.

```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int currentSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}
```

**Time Complexity**: O(n)

---

### **2. Reverse a Linked List**

**Problem**: Reverse a singly linked list.

**Solution**: Use three pointers (`prev`, `current`, `next`) to reverse the links in the list.

```java
public Node reverseLinkedList(Node head) {
    Node prev = null;
    Node current = head;

    while (current != null) {
        Node next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}
```

**Time Complexity**: O(n)

---

### **3. Check for Balanced Parentheses**

**Problem**: Given an expression with parentheses, check if the parentheses are balanced.

**Solution**: Use a stack to match the opening and closing parentheses.

```java
public boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<>();

    for (char c : expression.toCharArray()) {
        if (c == '(') {
            stack.push(c);
        } else if (c == ')') {
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }
    }
    return stack.isEmpty();
}
```

**Time Complexity**: O(n)

---

### **4. Find the First Non-Repeating Character**

**Problem**: Find the first non-repeating character in a string.

**Solution**: Use a hash table (HashMap) to count the occurrences of each character.

```java
public char firstUniqChar(String s) {
    Map<Character, Integer> count = new HashMap<>();
    for (char c : s.toCharArray()) {
        count.put(c, count.getOrDefault(c, 0) + 1);
    }

    for (char c : s.toCharArray()) {
        if (count.get(c) == 1) {
            return c;
        }
    }
    return '-1'; // Return if no unique character
}
```

**Time Complexity**: O(n)

---

### **5. Find the Diameter of a Binary Tree**

**Problem**: Find the diameter of a binary tree (the longest path between two nodes in the tree).

**Solution**: Use Depth-

First Search (DFS) to compute the height of each subtree and update the diameter.

```java
public int diameterOfBinaryTree(TreeNode root) {
    int[] diameter = new int[1];
    dfs(root, diameter);
    return diameter[0];
}

private int dfs(TreeNode node, int[] diameter) {
    if (node == null) return 0;

    int left = dfs(node.left, diameter);
    int right = dfs(node.right, diameter);

    diameter[0] = Math.max(diameter[0], left + right);

    return 1 + Math.max(left, right);
}
```

**Time Complexity**: O(n)

---

### **6. Merge Two Sorted Lists**

**Problem**: Merge two sorted linked lists into a single sorted linked list.

**Solution**: Use two pointers to merge the lists.

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```

**Time Complexity**: O(m + n), where m and n are the lengths of the two lists.




------------------------------------------



