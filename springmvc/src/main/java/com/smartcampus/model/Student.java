package com.smartcampus.model;

/**
 * Student.java - Model
 * Maps to the `students` table.
 */
public class Student {

    private int    id;
    private String regNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int    departmentId;
    private String departmentName;   // joined from departments table (for display)
    private int    academicYear;
    private String status;
    private String createdAt;

    // ── Constructors ──────────────────────────────────────────
    public Student() {}

    // ── Convenience getter ────────────────────────────────────
    /** Returns "First Last" */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // ── Getters & Setters ─────────────────────────────────────
    public int    getId()                          { return id; }
    public void   setId(int id)                    { this.id = id; }

    public String getRegNumber()                   { return regNumber; }
    public void   setRegNumber(String r)           { this.regNumber = r; }

    public String getFirstName()                   { return firstName; }
    public void   setFirstName(String f)           { this.firstName = f; }

    public String getLastName()                    { return lastName; }
    public void   setLastName(String l)            { this.lastName = l; }

    public String getEmail()                       { return email; }
    public void   setEmail(String e)               { this.email = e; }

    public String getPhone()                       { return phone; }
    public void   setPhone(String p)               { this.phone = p; }

    public int    getDepartmentId()                { return departmentId; }
    public void   setDepartmentId(int d)           { this.departmentId = d; }

    public String getDepartmentName()              { return departmentName; }
    public void   setDepartmentName(String d)      { this.departmentName = d; }

    public int    getAcademicYear()                { return academicYear; }
    public void   setAcademicYear(int a)           { this.academicYear = a; }

    public String getStatus()                      { return status; }
    public void   setStatus(String s)              { this.status = s; }

    public String getCreatedAt()                   { return createdAt; }
    public void   setCreatedAt(String c)           { this.createdAt = c; }
}
