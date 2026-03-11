Expense Split System
Project Description

Expense Split is a Spring Boot backend application designed to manage and track shared expenses among users or groups.
It allows users to add expenses, split costs between participants, and calculate balances automatically.
The system ensures transparent expense tracking and simplifies settlements between users.

Features

1.Add and manage users
2.Create and track shared expenses
3.Split expenses among multiple participants
4.Automatic balance calculation
5.Track who owes whom

RESTful APIs for expense operations
MySQL database integration
Clean layered architecture (Controller → Service → Repository)

Tech Stack-
Backend
Java
Spring Boot
Spring Data JPA
Hibernate
Database
MySQL

Tools-
IntelliJ IDEA
Postman
Git & GitHub
Maven

Project Architecture

The project follows a layered architecture:

Controller Layer
        ↓
Service Layer
        ↓
Repository Layer
        ↓
Database (MySQL)

This structure improves maintainability, scalability, and code readability.

Database Tables

Main tables used in the system:

Users – Stores user details

Expenses – Stores expense information

Expense Split – Tracks how expenses are divided between users

API Endpoints
User APIs
Method	Endpoint	Description
POST	/users	Create new user
GET	/users	Get all users
GET	/users/{id}	Get user by ID
Expense APIs
Method	Endpoint	Description
POST	/expenses	Add new expense
GET	/expenses	Get all expenses
GET	/expenses/{id}	Get expense details
Expense Split APIs
Method	Endpoint	Description
POST	/split	Split an expense
GET	/balances	View balances between users


Authentication & Authorization (JWT)
Group expense management
Expense settlement feature
Frontend integration (React)

Author
Chandrashekhar Chinta

Java Backend Developer
Spring Boot | Java | MySQL | REST APIs
