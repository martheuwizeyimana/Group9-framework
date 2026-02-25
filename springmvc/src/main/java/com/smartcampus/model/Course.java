package com.smartcampus.model;

/**
 * Course.java - Model
 * Maps to the `courses` table.
 */
public class Course {

    private int    id;
    private String courseCode;
    private String courseName;
    private int    credits;
    private int    departmentId;
    private String departmentName;   // joined from departments (display)
    private int    lecturerId;
    private String lecturerName;     // joined from lecturers (display)
    private String description;
    private String status;
    private String createdAt;

    // ── Constructors ──────────────────────────────────────────
    public Course() {}

    // ── Getters & Setters ─────────────────────────────────────
    public int    getId()                          { return id; }
    public void   setId(int id)                    { this.id = id; }

    public String getCourseCode()                  { return courseCode; }
    public void   setCourseCode(String c)          { this.courseCode = c; }

    public String getCourseName()                  { return courseName; }
    public void   setCourseName(String c)          { this.courseName = c; }

    public int    getCredits()                     { return credits; }
    public void   setCredits(int c)                { this.credits = c; }

    public int    getDepartmentId()                { return departmentId; }
    public void   setDepartmentId(int d)           { this.departmentId = d; }

    public String getDepartmentName()              { return departmentName; }
    public void   setDepartmentName(String d)      { this.departmentName = d; }

    public int    getLecturerId()                  { return lecturerId; }
    public void   setLecturerId(int l)             { this.lecturerId = l; }

    public String getLecturerName()                { return lecturerName; }
    public void   setLecturerName(String l)        { this.lecturerName = l; }

    public String getDescription()                 { return description; }
    public void   setDescription(String d)         { this.description = d; }

    public String getStatus()                      { return status; }
    public void   setStatus(String s)              { this.status = s; }

    public String getCreatedAt()                   { return createdAt; }
    public void   setCreatedAt(String c)           { this.createdAt = c; }
}
