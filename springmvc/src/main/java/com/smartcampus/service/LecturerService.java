package com.smartcampus.service;

import com.smartcampus.dao.LecturerDAO;
import com.smartcampus.model.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LecturerService.java - Service Layer
 */
@Service
public class LecturerService {

    @Autowired
    private LecturerDAO dao;

    public int save(Lecturer l) {
        validate(l);
        return dao.save(l);
    }

    public List<Lecturer> getAll()                       { return dao.findAll(); }
    public Lecturer       getById(int id)                { return dao.findById(id); }
    public List<Lecturer> getByDepartment(int deptId)    { return dao.findByDepartment(deptId); }
    public int            count()                        { return dao.count(); }

    public int update(Lecturer l) {
        validate(l);
        return dao.update(l);
    }

    public int delete(int id) { return dao.delete(id); }

    private void validate(Lecturer l) {
        if (isBlank(l.getFirstName()))   throw new IllegalArgumentException("First name is required.");
        if (isBlank(l.getLastName()))    throw new IllegalArgumentException("Last name is required.");
        if (isBlank(l.getEmail()))       throw new IllegalArgumentException("Email is required.");
        if (isBlank(l.getStaffNumber())) throw new IllegalArgumentException("Staff number is required.");
        if (l.getDepartmentId() <= 0)    throw new IllegalArgumentException("Department is required.");
    }

    private boolean isBlank(String s) { return s == null || s.isBlank(); }
}
