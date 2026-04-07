💰 Expense Split Application

A full-stack web application to manage and split expenses among groups, similar to Splitwise. This project is built using Spring Boot (Backend) and HTML, CSS, JavaScript (Frontend).

🚀 Features
👤 User Management
Create and manage users
👥 Group Management
Create groups and add members
💸 Expense Management
Add expenses within groups
Split expenses among members
🔄 Settlement System
Track balances
Settle debts between users
📊 Net Balance Calculation
Optimized settlement logic to minimize transactions
🛠️ Tech Stack

🔹 Backend
Java
Spring Boot
Spring Web
Spring Data JPA
REST APIs
🔹 Frontend
HTML
CSS
JavaScript
🔹 Database
(Configured via application.properties, likely MySQL or H2)

⚙️ Backend Architecture

The backend follows a layered architecture:

1. Controller Layer

Handles HTTP requests:

UserController
GroupController
ExpensesController
TransactionController
2. Service Layer

Contains business logic:

Expense splitting logic
Balance calculation
Settlement optimization
3. Repository Layer
Uses Spring Data JPA
Interfaces for database operations
4. Entity Layer

Main entities:
User
Group
Expenses
Split
Transactions
Members

5. DTOs
Request & Response objects
Clean API structure

6. Exception Handling
Global exception handler
Custom exceptions:
UserNotFoundException
GroupNotFoundException
SplitNotFoundException


🔗 API Endpoints (Overview)
👤 User APIs
Create User
Get Users
👥 Group APIs
Create Group
Add Members
Get Group Details
💸 Expense APIs
Add Expense
Split Expense
Get Expense Details
🔄 Transaction APIs
Settle Payments
Get Balance Summary
🧠 Core Logic
Expense Splitting
Equal split among group members
Tracks who owes whom
Net Settlement
Minimizes number of transactions
Converts multiple debts into optimized payments
▶️ How to Run the Project

🔹 Backend
Navigate to project folder:
cd Expense-Split
Run Spring Boot app:
mvn spring-boot:run
Server runs at:
http://localhost:8080

🔹 Frontend
Open index.html in browser
OR
Serve using Live Server (recommended)
🧪 Testing
Postman collection available in project
Test all APIs using provided endpoints
📌 Future Enhancements
🔐 Authentication & Authorization (JWT)
📱 Mobile responsive UI improvements
📊 Advanced analytics (charts)
📧 Notifications & reminders
💳 Payment integration
🤝 Contribution

Feel free to fork this repository and contribute!
