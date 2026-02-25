-- ============================================================
--  SmartCampus University Management System
--  Spring MVC Version - Group 9
--  Database: smartcampus_spring_db
-- ============================================================

CREATE DATABASE IF NOT EXISTS smartcampus_spring_db;
USE smartcampus_spring_db;

-- ── Drop in reverse dependency order ─────────────────────────────────────────
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS lecturers;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS departments;

-- ── 1. Departments ────────────────────────────────────────────────────────────
CREATE TABLE departments (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(150) NOT NULL UNIQUE,
    code        VARCHAR(20)  NOT NULL UNIQUE,
    description TEXT,
    created_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ── 2. Students ───────────────────────────────────────────────────────────────
CREATE TABLE students (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    reg_number      VARCHAR(50)  NOT NULL UNIQUE,
    first_name      VARCHAR(100) NOT NULL,
    last_name       VARCHAR(100) NOT NULL,
    email           VARCHAR(150) NOT NULL UNIQUE,
    phone           VARCHAR(20),
    department_id   INT NOT NULL,
    academic_year   INT NOT NULL DEFAULT 1,
    status          ENUM('ACTIVE','INACTIVE','GRADUATED','SUSPENDED') NOT NULL DEFAULT 'ACTIVE',
    created_at      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

-- ── 3. Lecturers ──────────────────────────────────────────────────────────────
CREATE TABLE lecturers (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    staff_number    VARCHAR(50)  NOT NULL UNIQUE,
    first_name      VARCHAR(100) NOT NULL,
    last_name       VARCHAR(100) NOT NULL,
    email           VARCHAR(150) NOT NULL UNIQUE,
    phone           VARCHAR(20),
    department_id   INT NOT NULL,
    specialization  VARCHAR(200),
    status          ENUM('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
    created_at      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

-- ── 4. Courses ────────────────────────────────────────────────────────────────
CREATE TABLE courses (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    course_code     VARCHAR(20)  NOT NULL UNIQUE,
    course_name     VARCHAR(200) NOT NULL,
    credits         INT NOT NULL DEFAULT 3,
    department_id   INT NOT NULL,
    lecturer_id     INT,
    description     TEXT,
    status          ENUM('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
    created_at      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES departments(id),
    FOREIGN KEY (lecturer_id)   REFERENCES lecturers(id)
);

-- ── Sample Data ───────────────────────────────────────────────────────────────
INSERT INTO departments (name, code, description) VALUES
('Computer Science',       'CS',   'Department of Computer Science and Software Engineering'),
('Information Technology', 'IT',   'Department of Information Technology and Systems'),
('Mathematics',            'MATH', 'Department of Pure and Applied Mathematics'),
('Business Administration','BA',   'Department of Business Administration and Management');

INSERT INTO lecturers (staff_number, first_name, last_name, email, phone, department_id, specialization) VALUES
('STAFF001', 'Jean',    'Mutabazi',  'j.mutabazi@smartcampus.rw',  '+250788001001', 1, 'Software Engineering'),
('STAFF002', 'Alice',   'Uwimana',   'a.uwimana@smartcampus.rw',   '+250788001002', 1, 'Artificial Intelligence'),
('STAFF003', 'Robert',  'Habimana',  'r.habimana@smartcampus.rw',  '+250788001003', 2, 'Network Security'),
('STAFF004', 'Marie',   'Ingabire',  'm.ingabire@smartcampus.rw',  '+250788001004', 3, 'Calculus and Algebra');

INSERT INTO students (reg_number, first_name, last_name, email, phone, department_id, academic_year) VALUES
('SC2025/CS/001', 'Eric',    'Nkurunziza', 'e.nkurunziza@student.rw', '+250780001001', 1, 2),
('SC2025/CS/002', 'Grace',   'Mukamurenzi','g.mukamurenzi@student.rw', '+250780001002', 1, 1),
('SC2025/IT/001', 'Patrick', 'Nsengiyumva','p.nsengiyumva@student.rw', '+250780001003', 2, 3),
('SC2025/BA/001', 'Diane',   'Uwera',      'd.uwera@student.rw',       '+250780001004', 4, 2);

INSERT INTO courses (course_code, course_name, credits, department_id, lecturer_id, description) VALUES
('CS101', 'Introduction to Programming',  3, 1, 1, 'Fundamentals of programming using Java'),
('CS201', 'Data Structures & Algorithms', 4, 1, 2, 'Core data structures and algorithm analysis'),
('IT101', 'Network Fundamentals',         3, 2, 3, 'Introduction to computer networking'),
('MATH101','Calculus I',                  3, 3, 4, 'Differential and integral calculus');

-- Verify
SELECT 'departments' AS tbl, COUNT(*) AS rows FROM departments
UNION SELECT 'students',  COUNT(*) FROM students
UNION SELECT 'lecturers', COUNT(*) FROM lecturers
UNION SELECT 'courses',   COUNT(*) FROM courses;
