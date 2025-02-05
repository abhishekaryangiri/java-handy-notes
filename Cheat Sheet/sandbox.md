# Users can register and their data will be saved in PostgreSQL, and then we will fetch and display the data on a React frontend.


---

Tech Stack

Backend: Node.js, Express.js, PostgreSQL

Frontend: React.js



---

1. Setup Backend (Node.js + Express + PostgreSQL)

Step 1: Install Dependencies

Run this in the backend folder:

npm init -y
npm install express pg cors dotenv body-parser

Step 2: Configure Database

Create a PostgreSQL table:

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15)
);

Step 3: Create .env File

Store database credentials:

DB_USER=your_username
DB_PASSWORD=your_password
DB_HOST=localhost
DB_PORT=5432
DB_NAME=your_database

Step 4: Create server.js

require("dotenv").config();
const express = require("express");
const cors = require("cors");
const bodyParser = require("body-parser");
const { Pool } = require("pg");

const app = express();
app.use(cors());
app.use(bodyParser.json());

// PostgreSQL Connection
const pool = new Pool({
  user: process.env.DB_USER,
  host: process.env.DB_HOST,
  database: process.env.DB_NAME,
  password: process.env.DB_PASSWORD,
  port: process.env.DB_PORT,
});

// Save user data to DB
app.post("/register", async (req, res) => {
  const { name, email, phone } = req.body;
  try {
    const result = await pool.query(
      "INSERT INTO users (name, email, phone) VALUES ($1, $2, $3) RETURNING *",
      [name, email, phone]
    );
    res.json(result.rows[0]);
  } catch (err) {
    console.error(err.message);
    res.status(500).send("Server Error");
  }
});

// Fetch all users from DB
app.get("/users", async (req, res) => {
  try {
    const result = await pool.query("SELECT * FROM users");
    res.json(result.rows);
  } catch (err) {
    console.error(err.message);
    res.status(500).send("Server Error");
  }
});

const PORT = 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));


---

2. Setup Frontend (React)

Go to your React folder and install dependencies:

npx create-react-app frontend
cd frontend
npm install axios

Step 1: Create App.js

import { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [formData, setFormData] = useState({ name: "", email: "", phone: "" });
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const res = await axios.get("http://localhost:5000/users");
      setUsers(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:5000/register", formData);
      fetchUsers(); // Refresh list after submission
      setFormData({ name: "", email: "", phone: "" });
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>User Registration</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="name" placeholder="Name" value={formData.name} onChange={handleChange} required />
        <input type="email" name="email" placeholder="Email" value={formData.email} onChange={handleChange} required />
        <input type="text" name="phone" placeholder="Phone" value={formData.phone} onChange={handleChange} required />
        <button type="submit">Register</button>
      </form>

      <h2>Registered Users</h2>
      <ul>
        {users.map((user) => (
          <li key={user.id}>{user.name} - {user.email} - {user.phone}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;


---

3. Run the Project

Run Backend

node server.js

Run React Frontend

npm start


---

4. Testing

Open http://localhost:3000/ in a browser.

Register a user.

The user should be saved in PostgreSQL and displayed below the form.


This is a full-stack mini-project using React, Node.js, and PostgreSQL.

