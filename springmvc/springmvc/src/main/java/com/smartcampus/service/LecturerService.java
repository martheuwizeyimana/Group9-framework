//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.smartcampus.service;

import com.smartcampus.dao.LecturerDAO;
import com.smartcampus.model.Lecturer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerService {
    @Autowired
    private LecturerDAO dao;

    public int save(Lecturer l) {
        this.validate(l);
        return this.dao.save(l);
    }

    public List<Lecturer> getAll() {
        return this.dao.findAll();
    }

    public Lecturer getById(int id) {
        return this.dao.findById(id);
    }

    public List<Lecturer> getByDepartment(int deptId) {
        return this.dao.findByDepartment(deptId);
    }

    public int count() {
        return this.dao.count();
    }

    public int update(Lecturer l) {
        this.validate(l);
        return this.dao.update(l);
    }

    public int delete(int id) {
        return this.dao.delete(id);
    }

    private void validate(Lecturer l) {
        if (this.isBlank(l.getFirstName())) {
            throw new IllegalArgumentException("First name is required.");
        } else if (this.isBlank(l.getLastName())) {
            throw new IllegalArgumentException("Last name is required.");
        } else if (this.isBlank(l.getEmail())) {
            throw new IllegalArgumentException("Email is required.");
        } else if (this.isBlank(l.getStaffNumber())) {
            throw new IllegalArgumentException("Staff number is required.");
        } else if (l.getDepartmentId() <= 0) {
            throw new IllegalArgumentException("Department is required.");
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}
