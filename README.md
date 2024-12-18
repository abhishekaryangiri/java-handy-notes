
# QUIZ-APP: API Testing on Postman

---

### 1. **Start Quiz**

**Endpoint:** `POST /api/quiz/start/{userId}`

**Example Request:**  
```http
POST http://localhost:8080/api/quiz/start/7
```

**Output:**  
```json
"Quiz session started for user: 7"
```

This starts a new quiz session for the user with the given `userId`. Replace `7` with the appropriate user ID.

---

### 2. **Fetch Question**

**Endpoint:** `GET /api/quiz/question`

**Example Request:**  
```http
GET http://localhost:8080/api/quiz/question
```

**Output:**  
```json
{
    "id": 1,
    "question": "What is the default value of a boolean variable in Java?",
    "option1": "true",
    "option2": "false",
    "option3": "0",
    "option4": "1",
    "correctOption": 2
}
```

This endpoint retrieves a random question from the quiz. The options and the correct answer are returned.

---

### 3. **Process Question**

**Endpoint:** `GET /api/quiz/process?questionId={questionId}`

**Example Request:**  
```http
GET http://localhost:8080/api/quiz/process?questionId=7
```

**Output:**  
```json
"Question processed: 7"
```

This endpoint processes the question by its `questionId`. Replace `7` with the question ID you want to process.

---

### 4. **Submit Answer**

**Endpoint:** `POST /api/quiz/submit/{userId}`

**Example Request:**  
```http
POST http://localhost:8080/api/quiz/submit/7?questionId=1&selectedOption=2
```

**Output (Correct Answer):**  
```json
"Correct answer!"
```

**Output (Incorrect Answer):**  
```json
"Wrong answer!"
```

This endpoint submits the selected answer for a given `userId` and `questionId`. It also checks if the selected option is correct or not.

---

### 5. **Check Result**

**Endpoint:** `GET /api/quiz/result/{userId}`

**Example Request:**  
```http
GET http://localhost:8080/api/quiz/result/7
```

**Output:**  
```json
{
    "Total Questions": 2,
    "Correct Answers": 2,
    "Incorrect Answers": 0
}
```

This endpoint provides the result of the quiz for a specific user by their `userId`. It returns the total number of questions, the correct answers, and the incorrect answers.

---

### Conclusion

You can now test these endpoints in Postman for the Quiz API. These steps cover everything from starting a quiz session to fetching questions, submitting answers, and checking the results.

---

Feel free to customize this README further to fit your project’s needs!
