package com.smartcampus.service;

import com.smartcampus.dao.CourseDAO;
import com.smartcampus.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CourseService.java - Service Layer
 */
@Service
public class CourseService {

    @Autowired
    private CourseDAO dao;

    public int save(Course c) {
        validate(c);
        return dao.save(c);
    }

    public List<Course> getAll()         { return dao.findAll(); }
    public Course       getById(int id)  { return dao.findById(id); }
    public int          count()          { return dao.count(); }

    public int update(Course c) {
        validate(c);
        return dao.update(c);
    }

    public int delete(int id) { return dao.delete(id); }

    private void validate(Course c) {
        if (isBlank(c.getCourseCode())) throw new IllegalArgumentException("Course code is required.");
        if (isBlank(c.getCourseName())) throw new IllegalArgumentException("Course name is required.");
        if (c.getDepartmentId() <= 0)   throw new IllegalArgumentException("Department is required.");
        if (c.getCredits() <= 0)        throw new IllegalArgumentException("Credits must be a positive number.");
    }

    private boolean isBlank(String s) { return s == null || s.isBlank(); }
}
