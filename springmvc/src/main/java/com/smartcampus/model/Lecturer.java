package com.smartcampus.model;

/**
 * Lecturer.java - Model
 * Maps to the `lecturers` table.
 */
public class Lecturer {

    private int    id;
    private String staffNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int    departmentId;
    private String departmentName;   // joined from departments (for display)
    private String specialization;
    private String status;
    private String createdAt;

    // ── Constructors ──────────────────────────────────────────
    public Lecturer() {}

    // ── Convenience getter ────────────────────────────────────
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // ── Getters & Setters ─────────────────────────────────────
    public int    getId()                          { return id; }
    public void   setId(int id)                    { this.id = id; }

    public String getStaffNumber()                 { return staffNumber; }
    public void   setStaffNumber(String s)         { this.staffNumber = s; }

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

    public String getSpecialization()              { return specialization; }
    public void   setSpecialization(String s)      { this.specialization = s; }

    public String getStatus()                      { return status; }
    public void   setStatus(String s)              { this.status = s; }

    public String getCreatedAt()                   { return createdAt; }
    public void   setCreatedAt(String c)           { this.createdAt = c; }
}
