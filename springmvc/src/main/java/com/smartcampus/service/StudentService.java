package com.smartcampus.service;

import com.smartcampus.dao.StudentDAO;
import com.smartcampus.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StudentService.java - Service Layer
 */
@Service
public class StudentService {

    @Autowired
    private StudentDAO dao;

    public int save(Student s) {
        validate(s);
        return dao.save(s);
    }

    public List<Student> getAll()            { return dao.findAll(); }
    public Student       getById(int id)     { return dao.findById(id); }
    public List<Student> search(String kw)   { return dao.search(kw); }
    public int           count()             { return dao.count(); }

    public int update(Student s) {
        validate(s);
        return dao.update(s);
    }

    public int delete(int id) { return dao.delete(id); }

    private void validate(Student s) {
        if (isBlank(s.getFirstName()))  throw new IllegalArgumentException("First name is required.");
        if (isBlank(s.getLastName()))   throw new IllegalArgumentException("Last name is required.");
        if (isBlank(s.getEmail()))      throw new IllegalArgumentException("Email is required.");
        if (isBlank(s.getRegNumber()))  throw new IllegalArgumentException("Registration number is required.");
        if (s.getDepartmentId() <= 0)   throw new IllegalArgumentException("Department is required.");
    }

    private boolean isBlank(String s) { return s == null || s.isBlank(); }
}
