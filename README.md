

# SmartCampus - University Management System (Spring MVC)

**Group 9** | Spring MVC Project

SmartCampus is a web-based University Management System designed to streamline the administration of educational institutions. It facilitates the management of students, lecturers, courses, and departments through a user-friendly interface.

Built using **Java Spring MVC**, **JdbcTemplate**, and **MySQL**, adhering to the MVC (Model-View-Controller) architectural pattern.

---

## 🚀 Features

* **📊 Dashboard:** Real-time overview of total students, lecturers, courses, and departments.
* **🏫 Department Management:** Create, edit, and delete university departments/faculties.
* **🎓 Student Management:** * Register new students with automatic registration number generation.
    * Track academic year and status (Active, Graduated, Suspended).
    * Search students by name or registration number.
* **👨‍🏫 Lecturer Management:** Manage staff details, specialization, and department assignments.
* **📚 Course Management:** * Create courses with credit definitions.
    * Assign courses to specific departments and lecturers.
* **📱 Responsive UI:** Built with Bootstrap 5 for mobile-friendly access.

---

## 🛠️ Technology Stack

* **Backend:** Java 11 (JDK 11), Spring MVC 5.3.31
* **Database:** MySQL 8.0, Spring JDBC (JdbcTemplate)
* **Frontend:** JSP (JavaServer Pages), JSTL, Bootstrap 5.3.2, CSS3
* **Build Tool:** Maven
* **Server:** Apache Tomcat 9+ (Servlet 4.0 support)

---

## 📂 Project Structure

The project follows a standard layered architecture:

```text
src/main/java/com/smartcampus
├── controller/   # Handles HTTP requests and navigation logic
├── service/      # Business logic and validation
├── dao/          # Data Access Object (Raw SQL & JdbcTemplate)
└── model/        # POJOs representing database entities

src/main/webapp/WEB-INF
├── views/        # JSP files (UI)
├── db.properties # Database connection credentials
└── ...xml        # Spring Context configurations

```

---

## ⚙️ Setup & Installation

### 1. Prerequisites

* Java Development Kit (JDK) 11 or higher.
* Apache Maven.
* MySQL Server.
* Apache Tomcat (or any Servlet Container).

### 2. Database Setup

1. Open your MySQL client (Workbench, CLI, or phpMyAdmin).
2. Locate the SQL script in the project folder:
`springmvc/database/smartcampus_spring_db.sql`
3. Run the script to create the database, tables, and insert sample data.

### 3. Application Configuration

1. Navigate to `src/main/webapp/WEB-INF/db.properties`.
2. Update the database credentials if your local MySQL setup differs from the defaults:

```properties
db.driver   = com.mysql.cj.jdbc.Driver
db.url      = jdbc:mysql://localhost:3306/smartcampus_spring_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
db.username = root
db.password = YOUR_PASSWORD_HERE

```

### 4. Build and Run

1. Open the project in your IDE (IntelliJ IDEA, Eclipse, or NetBeans).
2. Update Maven dependencies to download the required JARs.
3. Build the project:
```bash
mvn clean install

```


4. Deploy the generated `.war` file to your Tomcat server.
5. Access the application at:
```text
http://localhost:8080/smartcampus-springmvc/

```



---

## 📸 Modules Overview

### Dashboard

Provides a summary card view with quick action buttons to register new entities.

### Students Module

* **List View:** Table display with search functionality.
* **Fields:** Reg Number, First/Last Name, Email, Phone, Dept, Academic Year.

### Courses Module

* **Logic:** Courses must be linked to a valid Department. Optionally, a Lecturer can be assigned to a course.

---

## 🤝 Contributing

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

---

## 📝 License

This project is created for educational purposes by **Group 9**.

```

```