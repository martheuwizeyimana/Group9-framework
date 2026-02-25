package com.smartcampus.model;

/**
 * Department.java - Model
 * Maps to the `departments` table.
 */
public class Department {

    private int    id;
    private String name;
    private String code;
    private String description;
    private String createdAt;

    // ── Constructors ──────────────────────────────────────────
    public Department() {}

    public Department(String name, String code, String description) {
        this.name        = name;
        this.code        = code;
        this.description = description;
    }

    // ── Getters & Setters ─────────────────────────────────────
    public int    getId()                      { return id; }
    public void   setId(int id)                { this.id = id; }

    public String getName()                    { return name; }
    public void   setName(String name)         { this.name = name; }

    public String getCode()                    { return code; }
    public void   setCode(String code)         { this.code = code; }

    public String getDescription()             { return description; }
    public void   setDescription(String d)     { this.description = d; }

    public String getCreatedAt()               { return createdAt; }
    public void   setCreatedAt(String c)       { this.createdAt = c; }

    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "', code='" + code + "'}";
    }
}


   }
