//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.smartcampus.model;

public class Lecturer {
    private int id;
    private String staffNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int departmentId;
    private String departmentName;
    private String specialization;
    private String status;
    private String createdAt;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffNumber() {
        return this.staffNumber;
    }

    public void setStaffNumber(String s) {
        this.staffNumber = s;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String f) {
        this.firstName = f;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String l) {
        this.lastName = l;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String p) {
        this.phone = p;
    }

    public int getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(int d) {
        this.departmentId = d;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String d) {
        this.departmentName = d;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String s) {
        this.specialization = s;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String c) {
        this.createdAt = c;
    }
}
